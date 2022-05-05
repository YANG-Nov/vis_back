package com.dut.visualization.util;

import com.dut.visualization.Annotation.EnumMapper;
import com.dut.visualization.enumeration.EnumConvert;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author fan_jennifer
 * @author visy.wang
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-19 0:20
 * @date 2022/1/10 11:28
 */
public class CopyUtils {
    private static final Map<String, List<Field>> TARGET_FIELD_MAP = new HashMap<>();
    private static final Map<String, Map<String, Field>> SOURCE_FIELD_MAP = new HashMap<>();

    public static void copyProperties(Object source, Object target) throws IllegalAccessException {
        List<Field> targetFields = getFields(target);
        if (Objects.isNull(targetFields) || targetFields.isEmpty()) {
            return;
        }

        for (Field targetField : targetFields) {
            Field sourceField = getField(source, targetField.getName());

            if (targetField.isAnnotationPresent(EnumMapper.class)) { //检查注解
                EnumMapper enumMapper = targetField.getAnnotation(EnumMapper.class);

                String aliasName = enumMapper.alias();
                if (Objects.nonNull(aliasName) && !aliasName.isEmpty()) {
                    //指定了别名的情况，优先使用别名
                    sourceField = getField(source, aliasName);
                }

                if (Objects.isNull(sourceField)) {
                    continue; //源属性为空->不拷贝
                }

                if (enumMapper.value().isEnum()) {//注解中指定的Class必须是枚举
                    Enum<?> mapper = enumMapper.value().getEnumConstants()[0]; //随便取一个枚举值
                    if (mapper instanceof EnumConvert) {//枚举必须实现了EnumConvert接口
                        Object oldValue = sourceField.get(source);
                        //转换后拷贝
                        Object newValue = ((EnumConvert) mapper).mapping(oldValue);
                        if (Objects.nonNull(newValue) && targetField.getType().equals(newValue.getClass())) {
                            targetField.set(target, newValue);
                            continue;
                        }
                    }
                }
            }

            if (Objects.isNull(sourceField)) {
                continue; //源属性为空->不拷贝
            }

            if (!targetField.getType().equals(sourceField.getType())) {
                continue; //两个属性类型不一致->不拷贝
            }

            //拷贝
            targetField.set(target, sourceField.get(source));
        }

    }

    private static List<Field> getFields(Object obj) {
        Class<?> clazz = obj.getClass();
        String key = clazz.getName();
        List<Field> fields = TARGET_FIELD_MAP.get(key);
        if (Objects.isNull(fields)) {
            Field[] fieldArray = clazz.getDeclaredFields();
            Field.setAccessible(fieldArray, true);
            fields = Arrays.stream(fieldArray).collect(Collectors.toList());
            TARGET_FIELD_MAP.put(key, fields);
        }
        return fields;
    }

    private static Field getField(Object obj, String fieldName) {
        Class<?> clazz = obj.getClass();
        String key = clazz.getName();
        Map<String, Field> map = SOURCE_FIELD_MAP.get(key);
        if (Objects.isNull(map)) {
            Field[] fieldArray = clazz.getDeclaredFields();
            Field.setAccessible(fieldArray, true);
            map = Arrays.stream(fieldArray).collect(Collectors.toMap(Field::getName, Function.identity()));
            SOURCE_FIELD_MAP.put(key, map);
        }
        return map.get(fieldName);
    }
}

