package com.dicadut.soms.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.viewmodel.PageResult;
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
    public void selectPage() {
        // mp提供分页方案
        Page<Task> page = new Page<>(2, 2);
        taskMapper.selectPage(page, new LambdaQueryWrapper<>());
        log.info("{} {} {}", page.getTotal(), page.getSize(), page.getRecords());

        // 结果格式化
        log.info("{}", PageResult.buildPage(page));
    }
}
