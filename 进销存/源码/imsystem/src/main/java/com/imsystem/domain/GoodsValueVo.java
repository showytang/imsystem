package com.imsystem.domain;

/**
 * 商品查询VO
 * @author Shimmer
 *
 */
public class GoodsValueVo {

	/**
	 * 商品类
	 */
	private Goods goods;
	
	/**
	 * 商品实例
	 */
	private Goodsvalue goodsValue;
	
	/**
	 *库存
	 */
	private Stockdetails stockDetails;
	
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Goodsvalue getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(Goodsvalue goodsValue) {
		this.goodsValue = goodsValue;
	}

	public Stockdetails getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(Stockdetails stockDetails) {
		this.stockDetails = stockDetails;
	}
	
	
	
	
}
