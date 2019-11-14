package com.xiaojihua.bean;

import java.util.List;

public class PageBean<T> {
    private int pageNumber;//当前页，前台传入
    private int pageSize;//每页显示数据量，前台传入
    private int startIndex;//本类计算
    private int totalNumber;//后台传入
    private int totalPage;//本类计算
    private List<T> data;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return (pageNumber - 1) * pageSize;
    }



    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getTotalPage() {
        return (int)Math.ceil((totalNumber*0.1)/pageSize);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 确保为必填项pageNumber,pageSize
     * @param pageNumber
     * @param pageSize
     */
    public PageBean(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
