package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.BridgeCompositionDTO;
import com.dicadut.soms.dto.BridgeSimpleDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.domain.Bridge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
public interface BridgeMapper extends BaseMapper<Bridge> {

    List<StakeNumberDTO> selectNumberListByGenreLine(@Param("genre") String genre,
                                                     @Param("line") String line);

    List<Component> selectBridgeCompositionList(@Param("start") String start,
                                                @Param("end") String end);


    @Deprecated
    List<ComponentDTO> selectComponentByBridgeComposition(@Param("start") String start,
                                                         @Param("end") String end,
                                                         @Param("id") String id);

    List<StakeNumberDTO> selectComponentNumberList(@Param("start") String start,
                                                   @Param("end") String end,
                                                   @Param("id") String id);

    List<BridgeSimpleDTO> selectLocationList();


}
