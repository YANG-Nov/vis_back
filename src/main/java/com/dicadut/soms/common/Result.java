package com.dicadut.soms.common;

import lombok.Data;

import java.util.List;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
@Data
public class Result {

    // 0 -> success
    // 1 -> failure
    // 2 -> redirect
    private int code;

    // if code is 0, the message will always be '成功',
    // otherwise the message will be error content
    private String message;

    private List<String> errorMessage;

}
