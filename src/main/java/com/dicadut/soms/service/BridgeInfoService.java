package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.domain.BridgeInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
public interface BridgeInfoService extends IService<BridgeInfo> {

    List<StakeNumberDTO> getNumberList(String genre, String line);

    List<ComponentDTO> getComponentList(String start, String end);

    List<StakeNumberDTO> getComponentNumberList(String start, String end, String id);

    List<LineLocationDTO> getLocationList();


}
