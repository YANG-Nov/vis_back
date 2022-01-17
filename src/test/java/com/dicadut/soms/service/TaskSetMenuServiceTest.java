package com.dicadut.soms.service;


import com.dicadut.soms.dto.ComponentDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-12-31 16:50:18
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskSetMenuServiceTest {

    @Resource
    private TaskSetMenuService taskSetMenuService;

    @Test
    public void saveTaskMenu() {
        List<ComponentDTO> componentDTOList = new ArrayList<>();
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setId("12");
        componentDTO.setName("1233");
        componentDTOList.add(componentDTO);
        ComponentDTO componentDTO1 = new ComponentDTO();
        componentDTO1.setId("122");
        componentDTO1.setName("1223");
        componentDTOList.add(componentDTO1);
        log.info("#### 启动单元测试 saveTaskMenu");
        taskSetMenuService.saveTaskMenu(componentDTOList);
        log.info("#### 结束单元测试 saveTaskMenu()");
    }

}
