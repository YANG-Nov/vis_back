package com.dicadut.soms.dto.viewmodel;


import lombok.Data;

import java.util.List;

/**
 * 查询分页结果对象，由后端传递给前端
 *
 * @author Radium
 * @version 1.0.0
 * @since 2022-01-20 10:55:31
 */
@Data
public class PageResult<T> {
    private long pageCount;
    private long totalCount;
    private int pageNo;
    private int pageSize;
    private List<T> results;
}
