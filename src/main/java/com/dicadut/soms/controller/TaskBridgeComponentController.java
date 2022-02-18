package com.dicadut.soms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.domain.TaskBridgeComponent;
import com.dicadut.soms.service.TaskBridgeComponentService;
import com.dicadut.soms.viewmodel.PageParam;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 任务桥构件表 前端控制器
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-27
 */
@Api(tags = "任务桥构件接口")
@RestController
@RequestMapping("/t_task_bridge_component")
public class TaskBridgeComponentController {


    @Resource
    private TaskBridgeComponentService taskBridgeComponentService;


    /**
     * 通过id查询
     */
    @ApiOperation("通过id查询")
    @GetMapping("/get_by_id/{id}")
    public ResponseViewModel<TaskBridgeComponent> getById(@PathVariable(value = "id") Integer id) {
        return ResponseViewModel.ok(taskBridgeComponentService.getById(id));
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @PostMapping("/save")
    public ResponseViewModel<Void> save(@RequestBody TaskBridgeComponent taskBridgeComponent) {
        taskBridgeComponentService.save(taskBridgeComponent);
        return ResponseViewModel.ok();
    }

    /**
     * 通过id删除
     */
    @ApiOperation("通过id删除")
    @DeleteMapping("/delete_by_id/{id}")
    public ResponseViewModel<Void> delete(@PathVariable(value = "id") String ids) {
        String[] idsStrs = ids.split(",");
        for (String id : idsStrs) {
            taskBridgeComponentService.removeById(Integer.parseInt(id));
        }
        return ResponseViewModel.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping("/update")
    public ResponseViewModel<Void> updateById(@RequestBody TaskBridgeComponent taskBridgeComponent) {
        taskBridgeComponentService.updateById(taskBridgeComponent);
        return ResponseViewModel.ok();
    }


    /**
     * 查询列表
     */
    @ApiOperation("查询列表")
    @PostMapping("/list")
    public ResponseViewModel<List<TaskBridgeComponent>> list(@RequestBody TaskBridgeComponentReqVo taskBridgeComponent) {
        final LambdaQueryWrapper<TaskBridgeComponent> lambda = new QueryWrapper<TaskBridgeComponent>().lambda();
        this.buildCondition(lambda, taskBridgeComponent);
        return ResponseViewModel.ok(taskBridgeComponentService.list(lambda));
    }

    /**
     * 分页查询
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public ResponseViewModel<PageResult> page(@RequestBody PageParam<TaskBridgeComponentReqVo> pageParam) {
        final TaskBridgeComponentReqVo param = pageParam.getParam();
        final LambdaQueryWrapper<TaskBridgeComponent> lambda = new QueryWrapper<TaskBridgeComponent>().lambda();
        this.buildCondition(lambda, param);
        final IPage<TaskBridgeComponent> page = taskBridgeComponentService.page(new Page<>(pageParam.getPageNo(), pageParam.getPageSize()), lambda);
        return ResponseViewModel.ok(PageResult.buildPage(page));
    }


    /**
     * 构造查询条件
     *
     * @param lambda
     * @param param
     */
    private void buildCondition(LambdaQueryWrapper<TaskBridgeComponent> lambda, TaskBridgeComponentReqVo param) {
        lambda.eq(!ObjectUtils.isEmpty(param.getId()), TaskBridgeComponent::getId, param.getId());
        lambda.eq(!ObjectUtils.isEmpty(param.getTaskId()), TaskBridgeComponent::getTaskId, param.getTaskId());
        lambda.eq(!ObjectUtils.isEmpty(param.getBridgeComponentId()), TaskBridgeComponent::getBridgeComponentId, param.getBridgeComponentId());
        lambda.eq(!ObjectUtils.isEmpty(param.getIsDeleted()), TaskBridgeComponent::getIsDeleted, param.getIsDeleted());
        if (!CollectionUtils.isEmpty(param.getCreateTimeList())) {
            lambda.ge(TaskBridgeComponent::getCreateTime, param.getCreateTimeList().get(0));
            lambda.le(TaskBridgeComponent::getCreateTime, param.getCreateTimeList().get(1));
        }
        if (!CollectionUtils.isEmpty(param.getUpdateTimeList())) {
            lambda.ge(TaskBridgeComponent::getUpdateTime, param.getUpdateTimeList().get(0));
            lambda.le(TaskBridgeComponent::getUpdateTime, param.getUpdateTimeList().get(1));
        }
        lambda.orderBy(true, false, TaskBridgeComponent::getId);
    }


    /**
     * 请求model
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TaskBridgeComponentReqVo extends TaskBridgeComponent {
        private List<String> createTimeList; // 创建时间起止
        private List<String> updateTimeList; // 更新时间起止
    }


}
