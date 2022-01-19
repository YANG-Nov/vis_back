package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.domain.Strain;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 17:32:54
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrainMapperTest {
    @Resource
    private StrainMapper strainMapper;

    @Test
    public void selectCount() {
        log.info("sensor record count {}", strainMapper.selectCount(null));
    }

    @Test
    public void selectPage() {
        IPage<Strain> page = new Page<>(100, 10);
        page = strainMapper.selectPage(page, null);

        List<Strain> records = page.getRecords();
        for (Strain strain : records) {
            log.info("{}", strain);
        }
    }
}
