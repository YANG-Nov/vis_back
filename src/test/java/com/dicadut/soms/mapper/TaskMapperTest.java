package com.dicadut.soms.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.viewmodel.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-01-25 15:52:14
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {
    @Resource
    private TaskMapper taskMapper;

    @Test
    public void testPagination() {

        //  法一：分页插件，适用于所有场景，包括复杂的多表关联场景
        PageHelper.startPage(2, 2); // 查第2页, 页大小为2
        com.github.pagehelper.Page<Task> helperPage = taskMapper.listAll();    // 执行查询的语句必须紧挨着放在 PageHelper.startPage(2,2) 之后，否则可能不生效
        log.info("{} {}", helperPage.getTotal(), helperPage.getPageSize());
        for (Task task : helperPage.getResult()) {
            log.info("{}", task);
        }
        log.info("{}", helperPage);

        // 法二：mp提供分页方案，适用于单表场景
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Task> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(2, 2);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Task> mpPage = taskMapper.selectPage(page, new LambdaQueryWrapper<>());
        log.info("{} {} {}", mpPage.getTotal(), mpPage.getSize(), mpPage.getRecords());


        // 结果格式化
        log.info("{}", Page.buildPage(helperPage));
        log.info("{}", Page.buildPage(helperPage));
    }
}
