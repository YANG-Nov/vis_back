package com.dut.visualization.enumeration;


import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @author visy.wang
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-19 0:04
 * @date 2022/1/10 9:43
 */
public interface EnumConvert {
    //将映射关系缓存到Map中，便于快速查找
    Map<String, Object> map = new HashMap<>();

    //key映射道value
    default Object mapping(Object key) {
        this.initMap();
        return map.get(String.valueOf(key));
    }

    default void initMap() {
        if (!map.isEmpty()) {
            return;
        }
        for (EnumConvert item : getLabels()) {
            map.put(String.valueOf(item.getValue()), item.getLabel());
        }
    }

    Object getValue();

    // 返回的实际类型必须和目标属性的类型一致
    Object getLabel();

    EnumConvert[] getLabels();
}

