package com.dicadut.soms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.domain.DiseaseRecord;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;
import com.dicadut.soms.dto.DiseaseRecordDTO;
import com.dicadut.soms.service.DiseaseRecordService;
import com.dicadut.soms.viewmodel.PageParam;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;


/**
 * <p>
 * 病害记录表 前端控制器
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
@Api(tags = "病害记录接口")
@Slf4j
@RestController
@RequestMapping("/disease_record")
public class DiseaseRecordController {


    @Resource
    private DiseaseRecordService diseaseRecordService;


    /**
     * 通过id查询
     */
    @GetMapping("/getById/{id}")
    public ResponseViewModel<Object> getById(@PathVariable(value = "id") Integer id) {
        return ResponseViewModel.ok(diseaseRecordService.getById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/save")
    public ResponseViewModel<Object> save(@RequestBody DiseaseRecord diseaseRecord) {
        diseaseRecordService.save(diseaseRecord);
        return ResponseViewModel.ok();
    }

    /**
     * 通过id删除
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseViewModel<Object> delete(@PathVariable(value = "id") String ids) {
        String[] idsStrs = ids.split(",");
        for (String id : idsStrs) {
            diseaseRecordService.removeById(Integer.parseInt(id));
        }
        return ResponseViewModel.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public ResponseViewModel<Object> updateById(@RequestBody DiseaseRecord diseaseRecord) {
        diseaseRecordService.updateById(diseaseRecord);
        return ResponseViewModel.ok();
    }


    /**
     * 查询列表
     */
    @PostMapping("/list")
    public ResponseViewModel<Object> list(@RequestBody DiseaseRecordReqVo diseaseRecord) {
        final LambdaQueryWrapper<DiseaseRecord> lambda = new QueryWrapper<DiseaseRecord>().lambda();
        this.buildCondition(lambda, diseaseRecord);
        return ResponseViewModel.ok(diseaseRecordService.list(lambda));
    }

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public ResponseViewModel<Object> page(@RequestBody PageParam<DiseaseRecordReqVo> pageParam) {
        final DiseaseRecordReqVo param = pageParam.getParam();
        final LambdaQueryWrapper<DiseaseRecord> lambda = new QueryWrapper<DiseaseRecord>().lambda();
        this.buildCondition(lambda, param);
        final IPage<DiseaseRecord> page = diseaseRecordService.page(new Page<>(pageParam.getPageNo(), pageParam.getPageSize()), lambda);
        return ResponseViewModel.ok(PageResult.buildPage(page));
    }


    /**
     * 构造查询条件
     *
     * @param lambda
     * @param param
     */
    private void buildCondition(LambdaQueryWrapper<DiseaseRecord> lambda, DiseaseRecordReqVo param) {
        if (param.getId() != null && param.getId() != 0) {
            lambda.eq(DiseaseRecord::getId, param.getId());
        }
        if (!StringUtils.isEmpty(param.getTaskId())) {
            lambda.eq(DiseaseRecord::getTaskId, param.getTaskId());
        }
        if (!StringUtils.isEmpty(param.getComponentId())) {
            lambda.eq(DiseaseRecord::getComponentId, param.getComponentId());
        }
        if (!StringUtils.isEmpty(param.getBridgeId())) {
            lambda.eq(DiseaseRecord::getBridgeId, param.getBridgeId());
        }
        if (!StringUtils.isEmpty(param.getDiseaseId())) {
            lambda.eq(DiseaseRecord::getDiseaseId, param.getDiseaseId());
        }
        if (param.getType() != null && param.getType() != 0) {
            lambda.eq(DiseaseRecord::getType, param.getType());
        }
        if (!StringUtils.isEmpty(param.getDiseaseAttributeId())) {
            lambda.eq(DiseaseRecord::getDiseaseAttributeId, param.getDiseaseAttributeId());
        }
        if (!StringUtils.isEmpty(param.getContent())) {
            lambda.eq(DiseaseRecord::getContent, param.getContent());
        }
        lambda.orderBy(true, false, DiseaseRecord::getId);
    }


    /**
     * 请求model, 内部类
     */
    @Data
    private static class DiseaseRecordReqVo extends DiseaseRecord {
    }

    @ApiOperation("添加病害记录")
    @PostMapping("addDiseaseRecords")
    public ResponseViewModel addDiseaseRecords(@RequestBody DiseaseRecordDTO diseaseRecordDTO) {
        diseaseRecordService.addDiseaseRecords(diseaseRecordDTO);
        return ResponseViewModel.ok();
    }

    @ApiOperation("App添加病害后,添加病害页显示病害记录")
    @GetMapping("getDiseaseRecordAppList")
    public ResponseViewModel<List<DiseaseRecordAppListDTO>> getDiseaseRecordAppList(@RequestParam String taskId, @RequestParam String componentId, @RequestParam String positionId) {
        List<DiseaseRecordAppListDTO> diseaseRecordAppList = diseaseRecordService.getDiseaseRecordAppList(taskId, componentId, positionId);
        return ResponseViewModel.ok(diseaseRecordAppList);
    }

    @ApiOperation("APP添加病害后，查看病害详情")
    @GetMapping("getDiseaseDetailsList")
    public ResponseViewModel<Collection<DiseaseRecordAppListDTO>> getDiseaseDetailsList(@RequestParam String taskId, @RequestParam String componentId, @RequestParam String positionId, @RequestParam String diseaseId) {
        Collection<DiseaseRecordAppListDTO> diseaseDetailsList = diseaseRecordService.getDiseaseDetailsList(taskId, componentId, positionId, diseaseId);
        return ResponseViewModel.ok(diseaseDetailsList);
    }


}
