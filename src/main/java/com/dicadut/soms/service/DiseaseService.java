package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.DieaseDTO;
import com.dicadut.soms.entity.Disease;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
public interface DiseaseService extends IService<Disease> {

    List<DieaseDTO> getDiseaseList();
}
