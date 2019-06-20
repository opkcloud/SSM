package com.opkcloud.util;

import java.util.ArrayList;
import java.util.List;

public class ResultData<T> {

    private List<T> data = new ArrayList<>(); //数据体
    private Integer total = new Integer(0); //
    private Integer returnCount = 0; //

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void addTotal(int total) {
        this.total += total;
    }

    public Integer getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(Integer returnCount) {
        this.returnCount = returnCount;
    }

    public ResultData(List<T> data, Integer total, Integer returnCount) {
        this.data = data;
        this.total = total;
        this.returnCount = returnCount;
    }

    public ResultData() {
    }
}
