package com.sl.core.mvc.bean;

import java.io.Serializable;

public class PageInfo implements Serializable {

    private Integer pageNumber = 1; //当前页

    private Integer pageSize = 10;  //每页数量

    private Integer totalPage = 0; //总页数

    private Integer totalRow = 0; //总记录数

    private Integer startRow = 0; //分页开始

    private Integer endRow = 0; //分页结束

    public PageInfo() {
    }

    public PageInfo(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageInfo(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }
}
