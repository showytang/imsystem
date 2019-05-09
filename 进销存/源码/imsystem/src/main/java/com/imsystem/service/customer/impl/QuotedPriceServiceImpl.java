package com.imsystem.service.customer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
		int row=qDao.deleteQuote(quoteId);
		return row;
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

	/**
	 * 修改报价价格
	 */
	@Override
	public int updatePrice(String qid, Double price) {
		// TODO Auto-generated method stub
		return qDao.updatePrice(qid, price);
	}

	/**
	 * 根据客户id查询报价
	 */
	@Override
	public List<QuoteVO> queryQuoteByCustomerId(String cid) {
		// TODO Auto-generated method stub
		List<QuoteVO> qvoList=new ArrayList<QuoteVO>();
		List<Quotedprice> qlist=qDao.queryQuoteByCustomerId(cid);
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
	public List<QuoteVO> queryQuoteByGoodsValueId(String gid) {
		// TODO Auto-generated method stub
		List<QuoteVO> qvoList=new ArrayList<QuoteVO>();
		List<Quotedprice> qlist=qDao.queryQuoteByGoodsValueId(gid);
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

	/**
	 * 查询报价客户
	 */
	@Override
	public List<QuoteVO> queryCustomerQuoteList(String name, String gid) {
		// TODO Auto-generated method stub
		return qDao.queryQuoteCustomer(name, gid);
	}

	@Override
	public int addQuote(QuoteVO qvo, String uid) {
		// TODO Auto-generated method stub
		Date time=new Date();
		if(qvo.getGvobj()!=null) {
			//根据商品新增报价
			for(Quotedprice qObj1:qvo.getQplist()) {
				if(qObj1.getId().equals("0")) {
					String rand=UUID.randomUUID().toString();
					qObj1.setId(rand);
					qObj1.setSvid(qvo.getGvobj().getId());
					qObj1.setTime(time);
					qObj1.setUpdatetime(time);
					qObj1.setUid(uid);
					qObj1.setState(0);
					int row1=qDao.insert(qObj1);
				}
			}
		}else if(qvo.getCobj()!=null) {
			//根据客户新增报价
			System.out.println("aaa");
			for(Quotedprice qObj1:qvo.getQplist()) {
				if(qObj1.getId().equals("0")) {
					String rand=UUID.randomUUID().toString();
					qObj1.setId(rand);
					qObj1.setCid(qvo.getCobj().getId());
					qObj1.setTime(time);
					qObj1.setUpdatetime(time);
					qObj1.setUid(uid);
					qObj1.setState(0);
					int row2=qDao.insert(qObj1);
				}
			}
		}
		return 0;
	}

	@Override
	public List<QuoteVO> queryGoodsQuoteList(String name, String cid) {
		// TODO Auto-generated method stub
		List<QuoteVO> qvoList=qDao.queryQuoteGoods(name, cid);
		for(QuoteVO qvo:qvoList) {
			if(qvo.getGvobj()!=null) {
				qvo.setGobj(qDao.selectGoodsById(qvo.getGvobj().getGid()));
				Goodsvalue goodsvalue = goodsvalueMap.queryGoodsDetail(qvo.getGvobj().getId());
				qvo.setGvobj(goodsvalue);
			}
		}
		return qvoList;
	}

}
