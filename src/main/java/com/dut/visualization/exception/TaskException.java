package com.dut.visualization.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-17 23:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskException extends RuntimeException{
    private Integer code;
    private String msg;
}
