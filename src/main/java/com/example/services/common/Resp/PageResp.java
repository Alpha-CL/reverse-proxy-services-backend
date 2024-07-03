package com.example.services.common.Resp;

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
    private List<T> data;

    public static <T> PageResp<T> restPage(List<T> list, Long total) {
        PageResp<T> result = new PageResp<T>();
        result.setTotal(total);
        result.setData(list);
        return result;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
