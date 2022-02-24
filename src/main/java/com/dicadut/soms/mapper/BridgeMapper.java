package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.BridgeSimpleDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.ComponentNumberDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
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

    List<ComponentNumberDTO> selectComponentNumberList(@Param("start") String start,
                                                       @Param("end") String end,
                                                       @Param("id") String id);

    /**
     * Jane_TODO 2022/2/24 stake_or_truss_number 和名字统一
     * 用于指定任务页选择桩号,一次查询所有数据后再做层级
     * 查询bridge全表，返回bridge表的id字段、桩号字段、桥梁位置字段
     *
     * @return 返回过渡对象
     */
    List<BridgeSimpleDTO> selectLocationList();


}
