package com.dicadut.soms.common;

import com.dicadut.soms.util.ResourceUtil;
import lombok.Data;

/**
 * @param <T>
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
@Data
public class ResponseViewModel<T> {

    private Result result;

    private T data;

    public static <T> ResponseViewModel<T> ok() {
        return new ResponseViewModel<>();
    }

    public static <T> ResponseViewModel<T> ok(T data) {
        return new ResponseViewModel<>(data);
    }

    public static <T> ResponseViewModel<T> fail(String msg) {
        return new ResponseViewModel<>(-1, msg, null);
    }

    public ResponseViewModel() {
        result = new Result();
        result.setCode(0);
        result.setMessage(ResourceUtil.getValidationMessage("unified.response.success"));
    }

    public ResponseViewModel(T data) {
        result = new Result();
        result.setCode(0);
        result.setMessage(ResourceUtil.getValidationMessage("unified.response.success"));
        setData(data);
    }

    public ResponseViewModel(String msg, T data) {
        result = new Result();
        result.setCode(0);
        result.setMessage(msg);
        setData(data);
    }

    public ResponseViewModel(int code, String msg, T data) {
        result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        setData(data);
    }

}
