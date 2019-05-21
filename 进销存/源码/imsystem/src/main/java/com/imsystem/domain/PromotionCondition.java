package com.imsystem.domain;

import java.util.List;

public class PromotionCondition {

	/**
	 * 总价
	 */
	private Double totalprice; 
	
	/**
	 * 商品实例id
	 */
	private List<Goodsvalue> gvArray;
	
	/**
	 * 数量
	 */
	private Integer count;
	
	/**
	 * 优惠后的价格
	 */
	private Double promotiontotalprice;
	
	/**
	 * 所属促销
	 */
	private Promotionrulevalue prv;
	
	/**
	 * 赠送商品id
	 */
	private String [] gvid;
	
	/**
	 *已选 商品集合
	 */
	private List<GoodsVO> goodsvolist;
	
	
	
	
	public List<Goodsvalue> getGvArray() {
		return gvArray;
	}

	public void setGvArray(List<Goodsvalue> gvArray) {
		this.gvArray = gvArray;
	}

	

	public List<GoodsVO> getGoodsvolist() {
		return goodsvolist;
	}

	public void setGoodsvolist(List<GoodsVO> goodsvolist) {
		this.goodsvolist = goodsvolist;
	}

	public String[] getGvid() {
		return gvid;
	}

	public void setGvid(String[] gvid) {
		this.gvid = gvid;
	}

	public Promotionrulevalue getPrv() {
		return prv;
	}

	public void setPrv(Promotionrulevalue prv) {
		this.prv = prv;
	}

	public void setPromotiontotalprice(Double promotiontotalprice) {
		this.promotiontotalprice = promotiontotalprice;
	}
	
	public Double getPromotiontotalprice() {
		return promotiontotalprice;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	
}
