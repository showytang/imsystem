package com.imsystem.domain;

import java.util.List;

/**
 * 商品详情VO
 * @author Shimmer
 *
 */
public class GoodsDetailVo {

	private Goods goods;
	
	private List<Img> img;
	
	private Goodsvalue goodsvalue;
	
	private List<Goodsprice> goodsprice;
	
	private Stockdetails stockdetails;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Img> getImg() {
		return img;
	}

	public void setImg(List<Img> img) {
		this.img = img;
	}

	public Goodsvalue getGoodsvalue() {
		return goodsvalue;
	}

	public void setGoodsvalue(Goodsvalue goodsvalue) {
		this.goodsvalue = goodsvalue;
	}

	public List<Goodsprice> getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(List<Goodsprice> goodsprice) {
		this.goodsprice = goodsprice;
	}

	public Stockdetails getStockdetails() {
		return stockdetails;
	}

	public void setStockdetails(Stockdetails stockdetails) {
		this.stockdetails = stockdetails;
	}
	
	
	
	
	
}
