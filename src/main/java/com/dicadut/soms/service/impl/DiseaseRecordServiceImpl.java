package com.dicadut.soms.service.impl;

import com.dicadut.soms.domain.DiseaseRecord;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.enumeration.SomsConstant;
import com.dicadut.soms.mapper.DiseaseRecordMapper;
import com.dicadut.soms.service.DiseaseRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 病害记录表 服务实现类
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
@Service
public class DiseaseRecordServiceImpl extends ServiceImpl<DiseaseRecordMapper, DiseaseRecord> implements DiseaseRecordService {

    //添加病害
    @Override
    public void addDiseaseRecords(DiseaseRecordDTO diseaseRecordDTO) {
        if (diseaseRecordDTO == null) {
            return;
        }

        // 1. 将6个list合并到1个list上
        List<DiseaseRecordDTO.Item> items = new ArrayList<>();
        items.addAll(diseaseRecordDTO.getFeatureFields());
        items.addAll(diseaseRecordDTO.getFeaturePopups());
        items.addAll(diseaseRecordDTO.getFeatureRadios());
        items.addAll(diseaseRecordDTO.getDiseasePictures());
        items.addAll(diseaseRecordDTO.getDiseaseVideos());
        items.addAll(diseaseRecordDTO.getDiseaseVoices());
        items.addAll(diseaseRecordDTO.getDiseaseTexts());

        // 2. 将合并后的list转换成与数据库一致的格式
        List<DiseaseRecord> list = new ArrayList<>();
        if (items.size() != 0) {
            for (DiseaseRecordDTO.Item item : items) {
                DiseaseRecord diseaseRecord = new DiseaseRecord();
                diseaseRecord.setDiseaseId(diseaseRecordDTO.getDiseaseId());
                diseaseRecord.setComponentId(diseaseRecordDTO.getComponentId());
                diseaseRecord.setOrderNumber(diseaseRecordDTO.getOrderNumber());
                diseaseRecord.setTaskId(diseaseRecordDTO.getTaskId());
                diseaseRecord.setBridgeId(diseaseRecordDTO.getPositionId());
                diseaseRecord.setRecordId(diseaseRecordDTO.getRecordId());
                diseaseRecord.setDiseaseAttributeId(item.getDiseaseAttributeId());
                diseaseRecord.setContent(item.getContent());
                diseaseRecord.setType(item.getType());
                list.add(diseaseRecord);
            }
        }

        // 3. 批量插入
        saveBatch(list);
    }

    //App添加病害记录前，先通过2个id查出病害记录并删除
    @Override
    public void deleteDiseaseRecord(DiseaseRecordDTO diseaseRecordDTO) {
        String taskId = diseaseRecordDTO.getTaskId();
        Integer recordId = diseaseRecordDTO.getRecordId();
        baseMapper.deleteDiseaseRecord(taskId, recordId);
    }

    //App添加病害后,添加病害页显示病害记录
    @Override
    public List<DiseaseRecordAppListDTO> getDiseaseRecordAppList(String taskId, String componentId) {
        return baseMapper.selectDiseaseRecordAppList(taskId, componentId);
    }

    //App逻辑删除病害记录，查出要删除的数据
    @Override
    public List<DiseaseRecord> getDiseaseRecordDeleteList(String taskId, Integer recordId) {
        return baseMapper.selectDiseaseRecordDeleteList(taskId, recordId);
    }

    //App添加病害后,点击病害记录显示病害详情
    @Override
    public DiseaseDetailDTO getDiseaseDetailList(String taskId, Integer recordId) {
        //从数据库中查出数据
        List<DiseaseDetailListDTO> diseaseDetailList = baseMapper.selectDiseaseList(taskId, recordId);
        String p = null;
        String c = null;
        for (DiseaseDetailListDTO diseaseDetailListDTO : diseaseDetailList) {
            if (diseaseDetailListDTO.getDiseaseAttributeId() != null) {
                p = diseaseDetailListDTO.getDiseaseAttributeId();
                c = diseaseDetailListDTO.getContent();
            }
        }
        List<DiseaseDetailListDTO> diseaseAttributeList = baseMapper.selectDiseaseAttributeList(p);
        for(DiseaseDetailListDTO diseaseAttributeDTO : diseaseAttributeList){
            if (Objects.equals(diseaseAttributeDTO.getDiseaseAttributeId(), p)){
                diseaseAttributeDTO.setChecked("1");
                diseaseAttributeDTO.setContent(c);
            }else {
                diseaseAttributeDTO.setChecked("0");
            }
        }

        // 存放结果列表
        DiseaseDetailDTO diseaseDetailDTO = new DiseaseDetailDTO();
        // 过渡map集合，key: type, value: name、content、value、diseaseAttributeId、unit、type
        Map<String, List<DiseaseDetailListDTO>> map = diseaseDetailList.stream().collect(Collectors.groupingBy(DiseaseDetailListDTO::getType)); // 通过 lambda 表达式实现，比之前代码更简洁
        Map<String, List<DiseaseDetailListDTO>> map1 = diseaseAttributeList.stream().collect(Collectors.groupingBy(DiseaseDetailListDTO::getType));
        diseaseDetailDTO.setFeatureFields(map.getOrDefault(SomsConstant.FEATURE_FIELD, new ArrayList<>()));
        diseaseDetailDTO.setFeaturePopups(map1.getOrDefault(SomsConstant.FEATURE_POPUP, new ArrayList<>()));
        diseaseDetailDTO.setFeatureRadios(map1.getOrDefault(SomsConstant.FEATURE_RADIO, new ArrayList<>()));
        diseaseDetailDTO.setDiseasePictures(map.getOrDefault(SomsConstant.DISEASE_PICTURE, new ArrayList<>()));
        diseaseDetailDTO.setDiseaseVideos(map.getOrDefault(SomsConstant.DISEASE_VIDEO, new ArrayList<>()));
        diseaseDetailDTO.setDiseaseVoices(map.getOrDefault(SomsConstant.DISEASE_VOICE, new ArrayList<>()));
        diseaseDetailDTO.setDiseaseTexts(map.getOrDefault(SomsConstant.DISEASE_TEXT, new ArrayList<>()));
        diseaseDetailDTO.setDiseaseReviewOpinion(map.getOrDefault(SomsConstant.DISEASE_REVIEW_OPINION, new ArrayList<>()));

        return diseaseDetailDTO;
    }

    // App添加病害后，显示病害记录表
    @Override
    public List<DiseaseRecordTableDTO> getDiseaseRecordTable(String taskId){
        //从数据库中查出数据
        List<DiseaseRecordTableListDTO> diseaseRecordTableList = baseMapper.selectDiseaseRecordTable(taskId);
        //返回数据集合
        List<DiseaseRecordTableDTO> list = new ArrayList<>();
        //过渡map集合，key: eg:东引桥B匝道桥面系, value: componentId、component、positionId、position、diseaseId、disease、taskId
        Map<String, List<DiseaseRecordTableDTO.Item>> map = new HashMap<>();
        //遍历数据库中封装一次查到的数据对象集合
        for (DiseaseRecordTableListDTO diseaseRecordTableListDTO : diseaseRecordTableList){
            //添加key：eg:东引桥B匝道桥面系
            String location = diseaseRecordTableListDTO.getLocation();
            String parentComponent = diseaseRecordTableListDTO.getParentComponent();
            String inspectionLocation = location+parentComponent;
            map.putIfAbsent(inspectionLocation,new ArrayList<>());
            //添加value：componentId、component、positionId、position、diseaseId、disease、taskId
            DiseaseRecordTableDTO.Item of = new DiseaseRecordTableDTO.Item();
            of.setComponentId(diseaseRecordTableListDTO.getComponentId());
            of.setComponent(diseaseRecordTableListDTO.getComponent());
            of.setPositionId(diseaseRecordTableListDTO.getPositionId());
            of.setPosition(diseaseRecordTableListDTO.getPosition());
            of.setDiseaseId(diseaseRecordTableListDTO.getDiseaseId());
            of.setDisease(diseaseRecordTableListDTO.getDisease());
            of.setTaskId(diseaseRecordTableListDTO.getTaskId());
            of.setRecordId(diseaseRecordTableListDTO.getRecordId());
            of.setOrderNumber(diseaseRecordTableListDTO.getOrderNumber());
            map.get(inspectionLocation).add(of);
        }
        //遍历map集合
        for (Map.Entry<String,List<DiseaseRecordTableDTO.Item>> entry : map.entrySet()){
            //取得key和value
            String inspectionLocation = entry.getKey();
            List<DiseaseRecordTableDTO.Item> items = entry.getValue();
            //赋值给需要返回的集合
            DiseaseRecordTableDTO diseaseRecordTableDTO = new DiseaseRecordTableDTO();
            diseaseRecordTableDTO.setInspectionLocation(inspectionLocation);
            diseaseRecordTableDTO.setDiseaseRecord(items);
            list.add(diseaseRecordTableDTO);
        }
        return list;
    }

}
