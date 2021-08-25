package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.WyResDTO;
import com.dicadut.soms.entity.Wy;

import java.util.List;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-08-25 17:03
 */
public interface WyService extends IService<Wy> {
    List<Wy> list10();

    List<WyResDTO> getWyLatest(Integer pageSize);

    List<WyResDTO> getWyList(String startTime, String endTime);
}
