package com.imsystem.domain;

import java.util.Date;
import java.util.UUID;

public class Salesstockrecord {
    private String id;

    private String gvid;

    private String salesdetailid;

    private String stockdetailid;

    private Integer count;

    private Double price;

    private Date time;

    private String uid;

    private Date updatetime;

    private Integer state;

    private String storeid;

    private String column1;

    private String column2;

    private String column3;

    private String column4;

    private String column5;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
    	
    	id = UUID.randomUUID().toString();
    	
        this.id = id;
    }

    public String getGvid() {
        return gvid;
    }

    public void setGvid(String gvid) {
        this.gvid = gvid;
    }

    public String getSalesdetailid() {
        return salesdetailid;
    }

    public void setSalesdetailid(String salesdetailid) {
        this.salesdetailid = salesdetailid;
    }

    public String getStockdetailid() {
        return stockdetailid;
    }

    public void setStockdetailid(String stockdetailid) {
        this.stockdetailid = stockdetailid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }
}