package com.dicadut.soms.dto.viewmodel;


import java.util.ArrayList;
import java.util.List;

/**
 * 查询分页结果对象，由后端传递给前端<br>
 * 整合分页插件和MP分页的功能，提供统一的page给前端<br>
 *
 * @author Radium
 * @version 1.0.0
 * @since 2022-01-20 10:55:31
 */
public class Page<T> {
    private int totalPage;      // pageCount -> totalPage
    private int totalCount;     // totalCount
    private int currentPage;    // pageNo -> currentPage
    private int pageSize;       // pageSize
    private List<T> results;

    private com.github.pagehelper.Page<T> helperPage;

    private com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> mpPage;

    public void setHelperPage(com.github.pagehelper.Page<T> helperPage) {
        this.helperPage = helperPage;
    }

    public void setMpPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> mpPage) {
        this.mpPage = mpPage;
    }

    public static <T> Page<T> buildPage(com.github.pagehelper.Page<T> helperPage) {
        Page<T> page = new Page<>();
        page.setHelperPage(helperPage);
        return page;
    }

    public static <T> Page<T> buildPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> mpPage) {
        Page<T> page = new Page<>();
        page.setMpPage(mpPage);
        return page;
    }

    /**
     * 总记录数
     *
     * @return
     */
    public int getTotalCount() {
        if (this.helperPage != null) {
            this.totalCount = (int) helperPage.getTotal();
        } else if (this.mpPage != null) {
            this.totalCount = (int) mpPage.getTotal();
        }
        return totalCount;
    }

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPage() {
        if (this.helperPage != null) {
            this.totalPage = (int) helperPage.getPages();
        } else if (this.mpPage != null) {
            this.totalPage = (int) mpPage.getPages();
        }
        return totalPage;
    }

    /**
     * 页大小
     *
     * @return
     */
    public int getPageSize() {
        if (this.helperPage != null) {
            this.pageSize = (int) helperPage.getPageSize();
        } else if (this.mpPage != null) {
            this.pageSize = (int) mpPage.getSize();
        }
        return pageSize;
    }

    /**
     * 当前页
     *
     * @return
     */
    public int getCurrentPage() {
        if (this.helperPage != null) {
            this.currentPage = (int) helperPage.getPageNum();
        } else if (this.mpPage != null) {
            this.currentPage = (int) mpPage.getCurrent();
        }
        return currentPage;
    }

    /**
     * 列表数据
     *
     * @return
     */
    public List<T> getResults() {
        if (this.helperPage != null) {
            this.results = new ArrayList<>(helperPage.getResult());
        } else if (this.mpPage != null) {
            this.results = mpPage.getRecords();
        }
        return results;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + getTotalCount() +
                ", totalPage=" + getTotalPage() +
                ", pageSize=" + getPageSize() +
                ", currentPage=" + getCurrentPage() +
                ", results=" + getResults() +
                '}';
    }
}
