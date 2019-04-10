package com.imsystem.service.customer.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Quotedprice;
import com.imsystem.service.customer.QuotedPriceService;

@Service
@Transactional
public class QuotedPriceServiceImpl implements QuotedPriceService{

	/**
	 * 查询所有报价
	 */
	@Override
	public List<Quotedprice> queryQuotedPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增报价
	 */
	@Override
	public int insertQuotedPrice(Quotedprice quoteObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除报价
	 */
	@Override
	public int deleteQuotedPrice(String quoteId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改报价
	 */
	@Override
	public int updatQuotedPrice(Quotedprice quoteObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据价格区间查询报价
	 */
	@Override
	public List<Quotedprice> queryQuotedPriceByMoney(int price1, int price2) {
		// TODO Auto-generated method stub
		return null;
	}

}
