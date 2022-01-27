package com.dicadut.soms.dto.viewmodel;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * 查询分页结果对象，由后端传递给前端<br>
 *
 * @author Radium
 * @version 1.0.0
 * @since 2022-01-20 10:55:31
 */
@Data
public class PageResult<T> {
    private int pageCount;      // pageCount    -> pages    总页数
    private int totalCount;     // totalCount   -> total    总记录数
    private int pageNo;         // pageNo       -> current  当前页
    private int pageSize;       // pageSize     -> size     页大小
    private List<T> results;    // results      -> records  数据列表

    public static <T> PageResult<T> buildPage(IPage<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageCount((int) page.getPages());
        pageResult.setTotalCount((int) page.getTotal());
        pageResult.setPageNo((int) page.getCurrent());
        pageResult.setPageSize((int) page.getSize());
        pageResult.setResults(page.getRecords());
        return pageResult;
    }
}
