package com.learn.radium;


import cn.hutool.core.io.FileUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-11-07 00:11:05
 */
public class Counter {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(FileUtil.readUtf8String("/weilei/test/eng.txt").split(" ")).collect(Collectors.toSet()).size());
    }
}
