package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.CmponentDTO;
import com.dicadut.soms.entity.Cmponent;


import java.awt.*;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:00
 */
public interface CmponentService extends IService<Cmponent> {
    List<CmponentDTO> getFrequencyList();
}
