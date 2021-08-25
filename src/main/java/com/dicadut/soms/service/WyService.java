package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.WyResDTO;
import com.dicadut.soms.entity.Wy;

import java.util.List;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 15:38:31
 */
public interface WyService extends IService<Wy> {

    List<Wy> list10();

    List<WyResDTO> getWyLatest(Integer pageSize);

    List<WyResDTO> getWyList(String startTime, String endTime);

}
