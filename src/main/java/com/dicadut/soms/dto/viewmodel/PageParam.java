package com.dicadut.soms.dto.viewmodel;


import lombok.Data;

/**
 * 查询分页参数对象，由前端传递给后端
 *
 * @author Radium
 * @version 1.0.0
 * @since 2022-01-20 10:53:55
 */
@Data
public class PageParam<T> {
    private int pageNo;
    private int pageSize;
    private T param;
}
