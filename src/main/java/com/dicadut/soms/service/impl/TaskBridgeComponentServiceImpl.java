package com.dicadut.soms.service.impl;

import com.dicadut.soms.domain.TaskBridgeComponent;
import com.dicadut.soms.dto.BridgeComponentTest;
import com.dicadut.soms.mapper.TaskBridgeComponentMapper;
import com.dicadut.soms.service.TaskBridgeComponentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 任务桥构件表 服务实现类
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-27
 */
@Service
public class TaskBridgeComponentServiceImpl extends ServiceImpl<TaskBridgeComponentMapper, TaskBridgeComponent> implements TaskBridgeComponentService {
    //改bridgeComponent表
    @Override
    public List<BridgeComponentTest> getName(){
        List<BridgeComponentTest> bridgeComponentList = baseMapper.getBridgeComponentList();
        //List<BridgeComponentTest> collect = bridgeComponentList.stream().filter(p -> p.getBridgeId().equals("34086")).collect(Collectors.toList());


        for (BridgeComponentTest b: bridgeComponentList) {
            if (b.getStakeOrTrussNumber() == null || b.getStakeOrTrussNumber().isEmpty()){
                baseMapper.setName(b.getBridgeId(),b.getComponentId(),"有误");
                continue;
            }
            String stakeOrTrussNumber = b.getStakeOrTrussNumber();

            String substring = stakeOrTrussNumber.substring(0, 1);


            int length = stakeOrTrussNumber.length();
            String numberStr =stakeOrTrussNumber.substring(length-3,length);
            int i = Integer.parseInt(numberStr);

            String str = substring + i;

            String s = b.getName() + str;

            baseMapper.setName(b.getBridgeId(),b.getComponentId(),s);


        }
        return null;
    }
    //改bridgeComponent表
    @Override
    public List<BridgeComponentTest> setBridgePosition() {
        List<BridgeComponentTest> bridgeComponentList = baseMapper.getBridgeComponentParentList();
        Map<String, List<BridgeComponentTest>> collect = bridgeComponentList.stream().collect(Collectors.groupingBy(BridgeComponentTest::getParentId));
        List<BridgeComponentTest> qiaoMianXi = collect.get("2001000001");
        for (BridgeComponentTest b: qiaoMianXi) {
            baseMapper.setBridgePosition(b.getBridgeId(),b.getComponentId(),"桥面系");
        }

        List<BridgeComponentTest> shangBuJieGou = collect.get("2001000002");
        for (BridgeComponentTest b: shangBuJieGou) {
            baseMapper.setBridgePosition(b.getBridgeId(),b.getComponentId(),"上部结构");
        }
        List<BridgeComponentTest> xiaBuJieGou = collect.get("2001000005");
        for (BridgeComponentTest b: xiaBuJieGou) {
            baseMapper.setBridgePosition(b.getBridgeId(),b.getComponentId(),"下部结构");
        }

        return null;
    }
}
