package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.WyResDTO;
import com.dicadut.soms.domain.Wy;
import com.dicadut.soms.mapper.WyMapper;
import com.dicadut.soms.service.WyService;
import com.dicadut.soms.util.WyUtil;
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
public class WyServiceImpl extends ServiceImpl<WyMapper, Wy> implements WyService {
    @Override
    public List<Wy> list10() {
        QueryWrapper<Wy> queryWrapper = new QueryWrapper<>();
        IPage<Wy> page = new Page<>(1, 10);
        page = baseMapper.selectPage(page, queryWrapper);
        page.getRecords().forEach(e -> log.info("{}", e));
        return page.getRecords();
    }

    @Override
    public List<WyResDTO> getWyLatest(Integer pageSize) {
        IPage<Wy> page = new Page<>(1, pageSize);
        QueryWrapper<Wy> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("get_time");
        page = baseMapper.selectPage(page, queryWrapper);
        List<Wy> wys = page.getRecords();
        List<WyResDTO> list = WyUtil.convert(wys);
        return list;
    }

    @Override
    public List<WyResDTO> getWyList(String startTime, String endTime) {
        startTime = startTime == null ? "2020-01-01 00:00:00" : startTime;
        endTime = endTime == null ? DateTime.now().toString("yyyy-MM-dd HH:mm:ss") : endTime;
        QueryWrapper<Wy> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("get_time", startTime, endTime);
        List<Wy> wys = baseMapper.selectList(queryWrapper);
        List<WyResDTO> list = WyUtil.convert(wys);
        return list;
    }
}
