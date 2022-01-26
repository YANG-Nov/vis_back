package com.dicadut.soms.dto.viewmodel;


import cn.hutool.core.bean.BeanUtil;
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
    private int pages;          // pageCount    -> pages    总页数
    private int total;          // totalCount   -> total    总记录数
    private int current;        // pageNo       -> current  当前页
    private int size;           // pageSize     -> size     也大小
    private List<T> records;    // results      -> records  数据列表

    public static <T> PageResult<T> buildPage(IPage<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        BeanUtil.copyProperties(page, pageResult);
        return pageResult;
    }
}
