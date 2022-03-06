package com.dicadut.soms.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.dto.ComponentNumberDTO;
import com.dicadut.soms.dto.LineLocationDTO;
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

    List<ComponentNumberDTO> getComponentNumberList(String start, String end, String id);

    List<LineLocationDTO> getLocationList();

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
    List<LineLocationDTO> getLocationListTest() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;


}
