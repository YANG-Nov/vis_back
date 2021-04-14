package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.StrainResDTO;
import com.dicadut.soms.entity.Strain;

import java.util.List;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 15:38:31
 */
public interface StrainService extends IService<Strain> {

    List<Strain> list10();

    List<StrainResDTO> getStrainLatest(Integer pageSize);

    List<StrainResDTO> getStrainList(String startTime, String endTime);

}
