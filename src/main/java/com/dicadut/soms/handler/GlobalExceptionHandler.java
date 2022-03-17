package com.dicadut.soms.handler;

import com.dicadut.soms.exception.TaskException;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author fan_jennifer
 * @version 1.0
 * @description 异常处理
 * @date 2022-03-17 22:29
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseViewModel error(Exception e){
        e.printStackTrace();
        return ResponseViewModel.fail("执行了全局异常");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseViewModel error(ArithmeticException e){
        e.printStackTrace();
        return ResponseViewModel.fail("执行了ArithmeticException异常");
    }

    @ExceptionHandler(TaskException.class)
    @ResponseBody
    public ResponseViewModel error(TaskException e){
        e.printStackTrace();
        return ResponseViewModel.fail(e.getMsg());
    }
}
