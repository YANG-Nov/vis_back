package com.dicadut.soms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.domain.DiseaseRecord;
import com.dicadut.soms.dto.DiseaseAttributeListDTO;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;
import com.dicadut.soms.dto.DiseaseRecordDTO;
import com.dicadut.soms.service.DiseaseRecordService;
import com.dicadut.soms.viewmodel.PageParam;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import com.dicadut.soms.vo.TaskVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 病害记录表 前端控制器
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
@Api(tags = "病害信息管理接口")
@Slf4j
@RestController
@RequestMapping("/disease_record")
public class DiseaseRecordController {


    @Autowired
    private DiseaseRecordService diseaseRecordService;


    /**
     * 通过id查询
     */
    @GetMapping("/get-by-id/{id}")
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
    @DeleteMapping("/delete-by-id/{id}")
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
        PageResult<DiseaseRecord> pr = new PageResult();
        pr.setPageCount((int) page.getPages());
        pr.setTotalCount((int) page.getTotal());
        pr.setPageNo(new Long(page.getCurrent()).intValue());
        pr.setPageSize((int) page.getSize());
        pr.setResults(page.getRecords());
        return ResponseViewModel.ok(pr);
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
        if (!StringUtils.isEmpty(param.getBridgeInfoId())) {
            lambda.eq(DiseaseRecord::getBridgeInfoId, param.getBridgeInfoId());
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

    @ApiOperation("App添加病害后显示病害记录表")
    @GetMapping("getDiseaseRecordAppList")
    public ResponseViewModel<List<DiseaseRecordAppListDTO>> getDiseaseRecordAppList(@RequestParam String taskId,@RequestParam String componentId) {
        List<DiseaseRecordAppListDTO> diseaseRecordAppList = diseaseRecordService.getDiseaseRecordAppList(taskId,componentId);
        return ResponseViewModel.ok(diseaseRecordAppList);
    }
}
