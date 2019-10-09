package com.xiaojihua.bean;

import java.util.List;

/**
 * pageBean的定义，一般具有如下几个关键数据
 * 其中前另个是必须的，
 * 有几个是需要本类计算的
 * @param <T>
 */
public class PageBean<T> {
    private int pageNumber;//当前页，前台传入
    private int pageSize;//每页记录数，前台传入
    private int startIndex;//查询数据库时候的开始索引值，本类计算
    private int totalNumber;//总记录数，后台传入
    private int totalPage;//总页数，本类计算
    private List<T> data;//存储当页数据

    public PageBean(int pageNumber, int pageSize){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

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

    /**
     * 计算查询数据时候的开始索引
     * @return
     */
    public int getStartIndex() {
        return (pageNumber - 1) * pageSize;
    }


    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 自动计算总页数，注意半页的情况，需要向上取值
     * @return
     */
    public int getTotalPage() {
        return (int)Math.ceil((totalNumber*1.0)/pageSize);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
