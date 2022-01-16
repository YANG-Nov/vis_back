package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.StrainResDTO;
import com.dicadut.soms.entity.Strain;
import com.dicadut.soms.mapper.StrainMapper;
import com.dicadut.soms.service.StrainService;
import com.dicadut.soms.util.StrainUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 15:39:13
 */
@Slf4j
@Service
public class StrainServiceImpl extends ServiceImpl<StrainMapper, Strain> implements StrainService {
    @Override
    public List<Strain> list10() {
        QueryWrapper<Strain> queryWrapper = new QueryWrapper<>();
        IPage<Strain> page = new Page<>(1, 10);
        page = baseMapper.selectPage(page, queryWrapper);
        page.getRecords().forEach(e -> log.info("{}", e));
        return page.getRecords();
    }

    @Override
    public List<StrainResDTO> getStrainLatest(Integer pageSize) {
        IPage<Strain> page = new Page<>(1, pageSize);
        QueryWrapper<Strain> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("get_time");
        page = baseMapper.selectPage(page, queryWrapper);
        List<Strain> strains = page.getRecords();
        List<StrainResDTO> list = StrainUtil.convert(strains);
        return list;
    }

    @Override
    public List<StrainResDTO> getStrainList(String startTime, String endTime) {
        startTime = startTime == null ? "2020-01-01 00:00:00" : startTime;
        endTime = endTime == null ? DateTime.now().toString("yyyy-MM-dd HH:mm:ss") : endTime;
        QueryWrapper<Strain> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("get_time", startTime, endTime);
        List<Strain> strains = baseMapper.selectList(queryWrapper);
        List<StrainResDTO> list = StrainUtil.convert(strains);
        return list;
    }
}
