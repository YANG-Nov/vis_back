package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.WyResDTO_qly;
import com.dicadut.soms.entity.Wy_qly;

import java.util.List;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-08-25 17:03
 */
public interface WyService_qly extends IService<Wy_qly> {
    List<Wy_qly> list10();

    List<WyResDTO_qly> getWyLatest(Integer pageSize);

    List<WyResDTO_qly> getWyList(String startTime, String endTime);
}
