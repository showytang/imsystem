package com.imsystem.service.order.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.xml.crypto.Data;

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
		
		for(int i = 0; i < stock.getStockdetails().size(); i++) {
			stock.getStockdetails().get(i).setId(UUID.randomUUID().toString());
		}
		
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

		for(int i = 0; i < salesorder.getList().size(); i++) {
			
			 salesorder.getList().get(i).setId(UUID.randomUUID().toString());
			
		}
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
	public int allot(Vector<Stockdetails> stockde) {

		int count = 0;
		
		for (Stockdetails item : stockde) {
			
			count += stockdetail.updateCount(item.getCode(), item.getCount(), item.getGvid());
			
			if(stockdetail.selectCount(item.getCode()) == 0) {
				count += stockM.updateState(item.getCode());
				count += stockdetail.update(item.getId());
			}
			
		}
		
		Stock stock = new Stock();
		
		stock.setId(UUID.randomUUID().toString());
		stock.setCode(UUID.randomUUID().toString());
		stock.setTime(new Date());
		stock.setUpdatetime(new Date());
		stock.setState(1);
		stock.setColumn1("0");
		stock.setColumn2("0");
		stock.setUid("0");
		stock.setStoreid(stockde.get(0).getColumn1());
		
		count += stockM.insertSelective(stock);
		
		List<Stockdetails> list = new ArrayList<Stockdetails>();
		
		for (Stockdetails item : stockde) {
			Stockdetails stod = new Stockdetails();
			stod.setId(UUID.randomUUID().toString());
			stod.setCode(stock.getCode());
			stod.setCount(item.getCount());
			stod.setScount(0);
			stod.setPrice(item.getPrice());
			stod.setGvid(item.getGvid());
			stod.setStoreid(item.getColumn1());
			stod.setTime(item.getTime());
			list.add(stod);
			
			Stockrecord stockcords = new Stockrecord();
			stockcords.setId(UUID.randomUUID().toString());
			stockcords.setAftersdid(item.getId());
			stockcords.setBeforesdid(stod.getId());
			stockcords.setAftersid("1");
			stockcords.setBeforesid(item.getColumn1());
			
			count += stockcord.insertSelective(stockcords);
		}
		
		stock.setStockdetails(list);
		
		count += stockdetail.add(stock);
		
		return count;
	}

}
