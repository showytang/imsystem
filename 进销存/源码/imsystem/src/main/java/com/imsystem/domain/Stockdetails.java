package com.imsystem.domain;

import java.util.Date;
import java.util.UUID;

public class Stockdetails {
    private String id;

    /**
     * 库存主表id
     */
    private String code;

    private Date time;

    private Date updatetime;

    private String uid;

    private Integer state;

    private String storeid;

    /**
     * 商品实例id
     */
    private String column1;

    /**
     * 进货价
     */
    private String column2;

    /**
     * 进货库存
     */
    private String column3;

    /**
     * 销售库存
     */
    private String column4;

    private String column5;

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public void setId(String id) {
    	
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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