package com.imsystem.service.order.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.StockdetailsExample;
import com.imsystem.domain.Stockrecord;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.mapper.SalesdetailsMapper;
import com.imsystem.mapper.SalesorderMapper;
import com.imsystem.mapper.SalesorderdetailsMapper;
import com.imsystem.mapper.StockMapper;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.mapper.StockrecordMapper;
import com.imsystem.service.order.OrderInsertService;

@Service
@Transactional
public class OrderInsertServiceImpl implements OrderInsertService {

	@Autowired
	StockMapper stockM;

	@Autowired
	StockdetailsMapper stockdetail;

	@Autowired
	SalesMapper salesMapper;

	@Autowired
	SalesdetailsMapper salesdetailsMapper;

	@Autowired
	SalesorderMapper salesorderMapper;

	@Autowired
	SalesorderdetailsMapper salesorderdetailsMapper;

	@Autowired
	StockrecordMapper stockcord;

	@Override
	public int insert(Stock stock) {

		stock.setId(UUID.randomUUID().toString());

		int count = stockM.insertSelective(stock);

		count += stockdetail.add(stock);

		return count;
	}

	@Override
	public int insertOut(Sales sales) {

		sales.setId(UUID.randomUUID().toString());

		int count = salesMapper.insertSelective(sales);

		count += salesdetailsMapper.add(sales);

		return count;
	}

	@Override
	public int insertSalesorder(Salesorder salesorder) {
		// TODO Auto-generated method stub
		salesorder.setId(UUID.randomUUID().toString());

		int count = salesorderMapper.insertSelective(salesorder);

		count += salesorderdetailsMapper.add(salesorder);

		return count;
	}

	@Override
	public int updateInsertOrder(Stock stock) {
		// TODO Auto-generated method stub

		int count = stockdetail.del(stock.getCode());

		count += stockdetail.add(stock);

		return count;
	}

	@Override
	public int allot(Sales sales) {

		sales.setTime(new Date());

		sales.setUpdatetime(new Date());

		sales.setId(UUID.randomUUID().toString());

		String code = sales.getCode();

		int count = 0;

		for (Salesdetails item : sales.getList()) {

			count += stockdetail.updateCount(sales.getCode(), item.getCount(), item.getGvid());

		}

		if (stockdetail.selectCount(sales.getCode()) == 0) {

			count += stockM.updateState(sales.getCode());

		}

		sales.setCode(UUID.randomUUID().toString());

		count = salesMapper.insertSelective(sales);

		count += salesdetailsMapper.add(sales);

		count += stockM.add(sales);

		count += stockdetail.addAllot(sales);

		Stockrecord stockrecord = new Stockrecord();

		stockrecord.setId(UUID.randomUUID().toString());

		stockrecord.setAftersdid(code);
		
		stockrecord.setBeforesdid(sales.getCode());
		
		stockrecord.setAftersid("1");
		
		stockrecord.setBeforesid(sales.getColumn1());

		count += stockcord.insertSelective(stockrecord);
		
		return count;
	}

}
