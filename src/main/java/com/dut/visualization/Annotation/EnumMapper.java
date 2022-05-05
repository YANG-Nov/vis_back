package com.dut.visualization.Annotation;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-19 0:12
 */

import java.lang.annotation.*;
import java.lang.annotation.Target;

/**
 * 枚举转换注解
 * @author visy.wang
 * @date 2022/1/10 10:11
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumMapper {
    //指定枚举Class
    Class<? extends Enum<?>> value();
    //指定源对象中对应的属性别名（属性名相同时，无需指定alias）
    String alias() default "";
}
