package com.imsystem.service.customer;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.imsystem.domain.QuoteVO;
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
	public int deleteQuotedPrice(String quoteId);
	
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
	
	/**
	 * 分页查询客户报价
	 * @param cname 客户名称
	 * @param gname  商品名称
	 * @param curentPage  当前页
	 * @return
	 */
	public List<QuoteVO> queryQuoteByPage(String cname,String gname,Integer curentPage);

	/**
	 * 修改报价价格
	 * @param qid  报价id
	 * @param price  报价价格
	 * @return
	 */
	public int updatePrice(String qid,Double price);
	
	/**
	 * 根据客户id查报价
	 * @param cid 客户id
	 * @return
	 */
	public List<QuoteVO> queryQuoteByCustomerId(String cid);
	
	/**
	 * 根据商品实例id查报价
	 * @param gid  商品实例id
	 * @return
	 */
	public List<QuoteVO> queryQuoteByGoodsValueId(String gid);
}
