package com.xiaojihua.bean;

import java.util.List;

/**
 * 针对easyUI分页组件封转的pageBean,
 * 经过跟踪easyUI的浏览器端请求头和请求体发现，
 * 其发送分页请求的时候，发送的数据有两个：
 * page:当前页
 * rows:每页显示条数
 * 接收相应数据显示的时候要求的数据有两个：
 * total:总记录数
 * rows:记录列表
 * 基于以上数据进行封装
 *
 * 原理与自定义分页pagebean一样，也有五个关键字段和一个记录列表，只是
 * 总记录数和记录列表的字段名称必须保持和easyui要求的一致才行
 */
public class EasyuiPageBean<T> {
    //当前页，存储前台传入的page参数
    private int pageNumber;
    //每页记录数，存储前台传入的rows参数
    private int pageSize;
    //查询数据库的时候每页的所以起始值，计算得出
    private int startIndex;
    //总记录数量，用于返回到页面供easyUI使用，名称与easyui要求的一致，后台传入
    private int total;
    //总页数，easyUI不需要，但是本类提供用于扩展，计算得出
    private int totalPage;
    //记录列表，用于返回到页面供easyUI使用，名称与easyui要求一致
    private List<T> rows;

    /**
     * 提供唯一构造函数，防止pageNumber,pageSize没有传入
     * @param pageNumber
     * @param pageSize
     */
    public EasyuiPageBean(int pageNumber, int pageSize) {
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
     * 计算得到startIndex
     * @return
     */
    public int getStartIndex() {
        return (this.pageNumber - 1) * this.pageSize;
    }

//    public void setStartIndex(int startIndex) {
//        this.startIndex = startIndex;
//    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 计算得到总页数
     * @return
     */
    public int getTotalPage() {
        return (int)Math.ceil((this.total * 0.1)/this.pageSize);
    }


}
