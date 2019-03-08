package com.imsystem.domain;

import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="goods")
public class Goods {
	 private String id; //编号
	 private  String name; //名称
	 private  List<Integer> img; //图片
	 private  String tid; //商品类型
	 private  String code; //商品编码
	 private  String prevbit; //商品前缀单位
	 private  String sufbit; //商品后缀单位
	 private  String bitval; //商品单位值
	 private  Double jprice; //商品初始进价
	 private  Double pprice; //商品批发价
	 private  Double lprice; //商品零售价
	 private  String remark; //商品备注
	 private  String uid; //操作用户
	 private  Integer minsecurity; //商品最小库存
	 private  Integer maxsecurity; //最大库存
	 private  String time; //创建时间
	 private  Integer state; //商品状态
	 private  String storeid;
	 private  Double price;//售价
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
	public List<Integer> getImg() {
		return img;
	}
	public void setImg(List<Integer> img) {
		this.img = img;
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
	public Double getJprice() {
		return jprice;
	}
	public void setJprice(Double jprice) {
		this.jprice = jprice;
	}
	public Double getPprice() {
		return pprice;
	}
	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}
	public Double getLprice() {
		return lprice;
	}
	public void setLprice(Double lprice) {
		this.lprice = lprice;
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
	public int getMinsecurity() {
		return minsecurity;
	}
	public void setMinsecurity(Integer minsecurity) {
		this.minsecurity = minsecurity;
	}
	public int getMaxsecurity() {
		return maxsecurity;
	}
	public void setMaxsecurity(Integer maxsecurity) {
		this.maxsecurity = maxsecurity;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getState() {
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@PersistenceConstructor
	public Goods(String id, String name, List<Integer> img, String tid, String code, String prevbit, String sufbit,
			String bitval, Double jprice, Double pprice, Double lprice, String remark, String uid, Integer minsecurity,
			Integer maxsecurity, String time, Integer state, String storeid, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.tid = tid;
		this.code = code;
		this.prevbit = prevbit;
		this.sufbit = sufbit;
		this.bitval = bitval;
		this.jprice = jprice;
		this.pprice = pprice;
		this.lprice = lprice;
		this.remark = remark;
		this.uid = uid;
		this.minsecurity = minsecurity;
		this.maxsecurity = maxsecurity;
		this.time = time;
		this.state = state;
		this.storeid = storeid;
		this.price = price;
	}
	 
	 
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	public Goods(String name, List<Integer> img, String tid, String code, String prevbit, String sufbit, String bitval,
			Double jprice, Double pprice, Double lprice, String remark, String uid, Integer minsecurity, Integer maxsecurity,
			String time, Integer state, String storeid, Double price) {
		super();
		this.name = name;
		this.img = img;
		this.tid = tid;
		this.code = code;
		this.prevbit = prevbit;
		this.sufbit = sufbit;
		this.bitval = bitval;
		this.jprice = jprice;
		this.pprice = pprice;
		this.lprice = lprice;
		this.remark = remark;
		this.uid = uid;
		this.minsecurity = minsecurity;
		this.maxsecurity = maxsecurity;
		this.time = time;
		this.state = state;
		this.storeid = storeid;
		this.price = price;
	}
	
	
	
	 
}
