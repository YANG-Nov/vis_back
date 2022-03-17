package com.dicadut.soms.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.dto.ComponentNumberDTO;
import com.dicadut.soms.dto.LineLocationVO;
import com.dicadut.soms.dto.StakeNumberDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
public interface BridgeService extends IService<Bridge> {
    @Deprecated
    List<StakeNumberDTO> getNumberList(String genre, String line);

    List<Tree<String>> getComponentList(String start, String end);

    @Deprecated
    List<ComponentNumberDTO> getComponentNumberList(String start, String end, String id);

    /**
     * // Jane_TODO add description
     *
     * @param
     * @return java.util.List<com.dicadut.soms.dto.LineLocationVO>
     * @author FanJane
     */
    List<LineLocationVO> getLocationList();

    /**
     * 测试
     *
     * @return
     * @throws NoSuchFieldException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Deprecated
    List<LineLocationVO> getLocationListTest() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;


}
