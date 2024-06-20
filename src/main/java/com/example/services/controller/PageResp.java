package com.example.services.controller;

import java.util.List;


/**
 * 通用分页数据封装类
 */
public class PageResp<T> {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<T> list;

    public static <T> PageResp<T> restPage(List<T> list, long total) {
        PageResp<T> result = new PageResp<T>();
        result.setTotal(total);
        result.setList(list);
        return result;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
