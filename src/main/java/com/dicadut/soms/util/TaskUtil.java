package com.dicadut.soms.util;

import com.dicadut.soms.dto.TaskBridgeComponentDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fan_jane
 * @version 1.0.0
 * @date 2022-02-23 22:43
 */
public class TaskUtil {
    /**
     * Jane_TODO 2022/2/24 需要完善，异常处理等
     * 将一次查询到的数据集合，封装到二级层级对象中
     */
    public static <T, E, A> List<T> oneLevelConvertToTwo(List<E> es, Class<T> first, Class<A> second, String sourceId, String targetId) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //方法返回值
        List<T> list = new ArrayList<>();
        // 过渡map集合，key: 主引桥+匝道（location）, value: 桩号对象列表（id,name）
        Map<String, List<E>> mapAll = new HashMap<>();
        Map<String, List<A>> mapSecond = new HashMap<>();

        //遍历数据库中用map集合来封装一次查到的数据对象集合，string为id
        for (E e : es) {
            //Class<T> aClass = (Class<T>) t.getClass();
            //取到e里的id，如果map里没有id就创建一个
            Class<E> aClass = (Class<E>) e.getClass();
            Field id = aClass.getDeclaredField(sourceId);
            id.setAccessible(true);
            String stringId = (String) id.get(e);
            mapAll.putIfAbsent(stringId, new ArrayList<>());
            mapSecond.putIfAbsent(stringId, new ArrayList<>());

            //key 为id.get（添加构件）
            mapAll.get(stringId).add(e);

            //key 为id.get（添加构件）
            A a1 = second.getDeclaredConstructor().newInstance();
            CopyUtils.copyProperties(e, a1);
            mapSecond.get(stringId).add(a1);
        }

        
        //遍历map集合
        for (Map.Entry<String, List<E>> entry : mapAll.entrySet()) {
            String key = entry.getKey();
            //取得key和value,取得id和当前id包含的集合
            List<E> value = entry.getValue();
            //new一个第一层级的对象
            T t1 = first.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(value.get(0), t1);
            Field children = first.getDeclaredField("children");
            children.setAccessible(true);
            List<A> as = mapSecond.get(key);
            children.set(t1, as);
            list.add(t1);
        }
        return list;
    }

    //删除数组中的数
    public static String[] ArraysDelete(String[] strings, int i) {
        if (strings.length - 1 - i >= 0) System.arraycopy(strings, i + 1, strings, i, strings.length - 1 - i);
        String[] y = new String[strings.length - 1];
        System.arraycopy(strings, 0, y, 0, strings.length - 1);
        return y;


    }

    public static Set<String> ArrayToSet(List<String> strings) {
        Set<String> set = new HashSet<>();
        for (String s : strings
        ) {
            String[] split = s.split(",");
            Collections.addAll(set, split);

        }
        return set;

    }

    public static List<String> getInspectionComponentNumbers(List<TaskBridgeComponentDTO> taskBridgeComponentDTOS) {
        List<String> inspectionComponentNumber = new ArrayList<>();
        Map<String, List<TaskBridgeComponentDTO>> listMap = taskBridgeComponentDTOS.stream().collect(Collectors.groupingBy(TaskBridgeComponentDTO::getComponentName));
        for (Map.Entry<String, List<TaskBridgeComponentDTO>> entry1 : listMap.entrySet()) {
            //获得构件名称
            String componentName = entry1.getKey();
            //获得构件编号
            List<TaskBridgeComponentDTO> value = entry1.getValue();
            String join = StringUtils.join(value.stream().map(TaskBridgeComponentDTO::getComponentNumber).distinct().toArray(), "、");
            inspectionComponentNumber.add(componentName + ":" + join);

        }
        return inspectionComponentNumber;
    }
}



