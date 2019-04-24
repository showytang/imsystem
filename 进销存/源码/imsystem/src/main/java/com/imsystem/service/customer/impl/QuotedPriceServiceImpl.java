package com.imsystem.service.customer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.QuoteVO;
import com.imsystem.domain.Quotedprice;
import com.imsystem.mapper.CustomerMapper;
import com.imsystem.mapper.GoodsMapper;
import com.imsystem.mapper.GoodsvalueMapper;
import com.imsystem.mapper.QuotedpriceMapper;
import com.imsystem.service.customer.QuotedPriceService;

@Service
@Transactional
public class QuotedPriceServiceImpl implements QuotedPriceService{
	
	@Autowired
	QuotedpriceMapper qDao;
	@Autowired
	CustomerMapper cDao;
	@Autowired
	GoodsvalueMapper goodsvalueMap;
	@Autowired
	private GoodsMapper goodsMap;

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

	/**
	 * 报价分页查询
	 */
	@Override
	public List<QuoteVO> queryQuoteByPage(String cname, String gname, Integer curentPage) {
		// TODO Auto-generated method stub
		
		List<QuoteVO> qvoList=new ArrayList<QuoteVO>();
		List<Quotedprice> qlist=qDao.queryQuoteByPage(cname, gname);
		for(Quotedprice qObj:qlist) {
			if(qObj!=null) {
				QuoteVO qvoObj=new QuoteVO();
				qvoObj.setQpobj(qObj);
				if(qObj.getCid()!=null || qObj.getCid()!="") {
					qvoObj.setCobj(cDao.selectByPrimaryKey(qObj.getCid()));
				}
				if(qObj.getSvid()!=null || qObj.getSvid()!="") {
					Goodsvalue goodsvalue = goodsvalueMap.queryGoodsDetail(qObj.getSvid());
					if(goodsvalue!=null) {
						qvoObj.setGvobj(goodsvalue);
						if(goodsvalue.getGid()!=null || goodsvalue.getGid()!="") {
							qvoObj.setGobj(qDao.selectGoodsById(goodsvalue.getGid()));
						}
					}
					
				}
				qvoList.add(qvoObj);
			}
		}
		return qvoList;
	}

	@Override
	public int updatePrice(String qid, Double price) {
		// TODO Auto-generated method stub
		return qDao.updatePrice(qid, price);
	}

}
