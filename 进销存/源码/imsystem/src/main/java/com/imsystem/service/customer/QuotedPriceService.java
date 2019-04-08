package com.imsystem.service.customer;

import java.util.List;

import com.imsystem.domain.Quotedprice;

public interface QuotedPriceService {
	
	/**
	 * 查询所有报价
	 * @return
	 */
	public List<Quotedprice> queryQuotedPrice();
	
	/**
	 * 新增报价
	 * @param quoteObj  报价新增类
	 * @return
	 */
	public int insertQuotedPrice(Quotedprice quoteObj);
	
	/**
	 * 删除报价
	 * @param quoteId  报价id
	 * @return
	 */
	public int deleteQuotedPrice(int quoteId);
	
	/**
	 * 修改报价
	 * @param quoteObj  报价修改类
	 * @return
	 */
	public int updatQuotedPrice(Quotedprice quoteObj);
	
	/**
	 * 根据价格区间查询报价
	 * @param price1 前段价格区间
	 * @param price2 后段价格区间
	 * @return
	 */
	public List<Quotedprice> queryQuotedPriceByMoney(int price1,int price2);

}
