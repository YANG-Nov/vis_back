package com.dicadut.soms.viewmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("统一响应对象")
public class Result {

    // 0 -> success
    // 1 -> failure
    // 2 -> redirect
    @ApiModelProperty("状态码")
    private int code;

    // if code is 0, the message will always be '成功',
    // otherwise the message will be error content
    @ApiModelProperty("信息")
    private String message;

//    @ApiModelProperty("数据")
//    private T data;

//    private List<String> errorMessage;

}
