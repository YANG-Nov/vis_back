package com.dicadut.soms.mapper;


import com.dicadut.soms.domain.Task;
import com.github.pagehelper.Page;
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


        PageHelper.startPage(2, 2); // 查第2页, 页大小为2
        Page<Task> tasks = taskMapper.listAll();    // 执行查询的语句必须紧挨着放在 PageHelper.startPage(2,2) 之后，否则可能不生效
        log.info("{} {}", tasks.getTotal(), tasks.getPageSize());
        for (Task task : tasks.getResult()) {
            log.info("{}", task);
        }
        log.info("{}", tasks);

    }
}
