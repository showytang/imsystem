package com.imsystem.domain;

import java.util.Date;
import java.util.List;

public class Goods {
    private String id;

    private String name;

    private String tid;

    private String code;

    private String prevbit;

    private String sufbit;

    private String bitval;

    private Double price;

    private Double jprice;

    private String remark;

    private String uid;

    private Integer minsecurity;

    private Integer maxsecurity;

    private String historygid;

    private Date time;

    private Date updatetime;

    private String detail;

    private Integer state;

    private String enname;

    private String column1;

    private String column2;

    private String column3;

    private String column4;

    private String column5;

    private byte[] img;
    
    /**
     * 商品实例集合
     */
    private List<Goodsvalue> goodsValues;
    
   
    public List<Goodsvalue> getGoodsValues() {
		return goodsValues;
	}

	public void setGoodsValues(List<Goodsvalue> goodsValues) {
		this.goodsValues = goodsValues;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrevbit() {
        return prevbit;
    }

    public void setPrevbit(String prevbit) {
        this.prevbit = prevbit;
    }

    public String getSufbit() {
        return sufbit;
    }

    public void setSufbit(String sufbit) {
        this.sufbit = sufbit;
    }

    public String getBitval() {
        return bitval;
    }

    public void setBitval(String bitval) {
        this.bitval = bitval;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getJprice() {
        return jprice;
    }

    public void setJprice(Double jprice) {
        this.jprice = jprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getMinsecurity() {
        return minsecurity;
    }

    public void setMinsecurity(Integer minsecurity) {
        this.minsecurity = minsecurity;
    }

    public Integer getMaxsecurity() {
        return maxsecurity;
    }

    public void setMaxsecurity(Integer maxsecurity) {
        this.maxsecurity = maxsecurity;
    }

    public String getHistorygid() {
        return historygid;
    }

    public void setHistorygid(String historygid) {
        this.historygid = historygid;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}