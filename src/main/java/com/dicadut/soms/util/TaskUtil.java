package com.dicadut.soms.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fan_jane
 * @version 1.0.0
 * @date 2022-02-23 22:43
 */
public class TaskUtil {
    /**
     * TODO 需要完善，异常处理等
     * 将一次查询到的数据集合，封装到二级层级对象中
     * @param es
     * @param first
     * @param second
     * @param sourceId
     * @param targetId
     * @param <T>
     * @param <E>
     * @param <A>
     *
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public static <T, E, A> List<T> convert(List<E> es, Class<T> first, Class<A> second,String sourceId, String targetId) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //方法返回值
        List<T> list = new ArrayList<>();
        // 过渡map集合，key: 主引桥+匝道（location）, value: 桩号对象列表（id,name）
        Map<String, List<A>> map = new HashMap<>();

        ;

        //遍历数据库中封装一次查到的数据对象集合
        for (E e : es) {
            //Class<T> aClass = (Class<T>) t.getClass();
            //取到e里的id，如果map里没有id就创建一个
            Class<E> aClass = (Class<E>) e.getClass();
            Field[] fields = aClass.getDeclaredFields();
            Field id = aClass.getDeclaredField(sourceId);
            id.setAccessible(true);
            String stringId = (String) id.get(e);
            map.putIfAbsent(stringId, new ArrayList<>());

            //key 为id.get（添加构件）
            A a1 = second.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(e, a1);
            map.get(stringId).add((A) a1);
        }

        //遍历map集合
        for (Map.Entry<String, List<A>> entry : map.entrySet()) {
            //取得key和value
            String key = entry.getKey();
            List<A> value = entry.getValue();
            T t1 = first.getDeclaredConstructor().newInstance();
            Field id = first.getDeclaredField(targetId);
            id.setAccessible(true);
            id.set(t1, key);
            Field children = first.getDeclaredField("children");
            children.setAccessible(true);
            children.set(t1, value);
            list.add(t1);
        }
        return list;
    }
}


