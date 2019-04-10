package com.imsystem.domain;

import java.util.List;

/**
 * 商品添加VO类
 * @author Shimmer
 *
 */
public class GoodsVO {

	/**
	 * 商品类
	 */
	private Goods goods;
	
	/**
	 * 商品实例集合
	 */
	private List<Goodsvalue> goodsValues;
	
	/**
	 * 商品图片集合
	 */
	private List<Img> goodsImgs;
	
	
	/**
	 * 库存实例集合
	 */
	private List<Stockdetails> stockDetailsList;
	
	/**
	 * 库存主表
	 */
	private Stock stock;
	
	
	
	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	public List<Stockdetails> getStockDetailsList() {
		return stockDetailsList;
	}


	public void setStockDetailsList(List<Stockdetails> stockDetailsList) {
		this.stockDetailsList = stockDetailsList;
	}


	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public List<Goodsvalue> getGoodsValues() {
		return goodsValues;
	}


	public void setGoodsValues(List<Goodsvalue> goodsValues) {
		this.goodsValues = goodsValues;
	}


	public List<Img> getGoodsImgs() {
		return goodsImgs;
	}


	public void setGoodsImgs(List<Img> goodsImgs) {
		this.goodsImgs = goodsImgs;
	}


	
	
}
