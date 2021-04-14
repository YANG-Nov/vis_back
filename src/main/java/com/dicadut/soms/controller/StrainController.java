package com.dicadut.soms.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.entity.Strain;
import com.dicadut.soms.mapper.StrainMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
@Api(tags = "北大桥应力传感器接口")
@Slf4j
@RestController
@RequestMapping("/api")
public class StrainController {

    @Resource
    private StrainMapper strainMapper;

    @ApiOperation("获取最新的传感器数据")
    @GetMapping("/strain_latest")
    public ResponseViewModel<List<StrainResDTO>> getStrainLatest(@RequestParam Integer pageSize) {
        IPage<Strain> page = new Page<>(1, pageSize);
        QueryWrapper<Strain> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("get_time");
        page = strainMapper.selectPage(page, queryWrapper);
        List<Strain> strains = page.getRecords();
        List<StrainResDTO> list = convert(strains);
        return ResponseViewModel.ok(list);
    }

    @ApiOperation("根据时间范围查询应力传感器数据")
    @GetMapping("/strain")
    public ResponseViewModel<List<StrainResDTO>> getStrainList(@RequestParam String startTime, @RequestParam String endTime) {
        startTime = startTime == null ? "2020-01-01 00:00:00" : startTime;
        endTime = endTime == null ? DateTime.now().toString("yyyy-MM-dd HH:mm:ss") : endTime;
        QueryWrapper<Strain> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("get_time", startTime, endTime);
        List<Strain> strains = strainMapper.selectList(queryWrapper);
        List<StrainResDTO> list = convert(strains);
        return ResponseViewModel.ok(list);
    }

    @Data
    public static class StrainResDTO {
        private Integer id;
        private String sendTime;
        private String getTime;
        private String rawData;
        private String module;
        private String serial;
        private Double frequency;
        private Double amplitude;
    }

    private List<StrainResDTO> convert(List<Strain> strains) {
        return strains.stream().map(e -> {
            StrainResDTO dto = new StrainResDTO();
            dto.setId(e.getId());
            dto.setSendTime(e.getSendTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            dto.setGetTime(e.getGetTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            dto.setRawData(e.getRawData());
            dto.setModule(e.getModule() + "");
            dto.setSerial(e.getSerial() + "");
            dto.setFrequency(e.getFrequency());
            dto.setAmplitude(e.getAmplitude());
            return dto;
        }).collect(Collectors.toList());
    }

}
