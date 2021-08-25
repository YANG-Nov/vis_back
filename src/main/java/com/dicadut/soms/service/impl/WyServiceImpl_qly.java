package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.WyResDTO_qly;
import com.dicadut.soms.entity.Wy_qly;
import com.dicadut.soms.mapper.WyMapper_qly;
import com.dicadut.soms.service.WyService_qly;
import com.dicadut.soms.util.WyUtil_qly;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-08-25 17:05
 */
@Slf4j
@Service
public class WyServiceImpl_qly extends ServiceImpl<WyMapper_qly, Wy_qly> implements WyService_qly {
    @Override
    public List<Wy_qly> list10() {
        QueryWrapper<Wy_qly> queryWrapper = new QueryWrapper<>();
        IPage<Wy_qly> page = new Page<>(1, 10);
        page = baseMapper.selectPage(page, queryWrapper);
        page.getRecords().forEach(e -> log.info("{}", e));
        return page.getRecords();
    }

    @Override
    public List<WyResDTO_qly> getWyLatest(Integer pageSize) {
        IPage<Wy_qly> page = new Page<>(1, pageSize);
        QueryWrapper<Wy_qly> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("get_time");
        page = baseMapper.selectPage(page, queryWrapper);
        List<Wy_qly> wys = page.getRecords();
        List<WyResDTO_qly> list = WyUtil_qly.convert(wys);
        return list;
    }

    @Override
    public List<WyResDTO_qly> getWyList(String startTime, String endTime) {
        startTime = startTime == null ? "2020-01-01 00:00:00" : startTime;
        endTime = endTime == null ? DateTime.now().toString("yyyy-MM-dd HH:mm:ss") : endTime;
        QueryWrapper<Wy_qly> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("get_time", startTime, endTime);
        List<Wy_qly> wys = baseMapper.selectList(queryWrapper);
        List<WyResDTO_qly> list = WyUtil_qly.convert(wys);
        return list;
    }
}
