package com.imsystem.service.order.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Salesorderdetails;
import com.imsystem.domain.Salesstockrecord;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Stockrecord;
import com.imsystem.mapper.CustomerMapper;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.mapper.SalesdetailsMapper;
import com.imsystem.mapper.SalesorderMapper;
import com.imsystem.mapper.SalesorderdetailsMapper;
import com.imsystem.mapper.SalesstockrecordMapper;
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

	@Autowired
	CustomerMapper curtomer;

	@Autowired
	SalesstockrecordMapper salesstockrecordmapper;
	
	@Override
	public int insert(Stock stock) {

		stock.setId(UUID.randomUUID().toString());

		for (int i = 0; i < stock.getStockdetails().size(); i++) {
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

		for (int i = 0; i < salesorder.getList1().size(); i++) {

			salesorder.getList1().get(i).setId(UUID.randomUUID().toString());

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

			if (stockdetail.selectCount(item.getCode(),"1") == 0) {
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

	Boolean bool = true;
	
	@Override
	public Boolean insertOrderOut(Salesorder salesorder) {
		// TODO Auto-generated method stub
		bool = true;
		int count = salesorderMapper.updatePregress(salesorder.getId(), "2");

		if (salesorder.getCid() != "1") {
			if (salesorder.getPaymoney() > (salesorder.getPreprice() + salesorder.getTainmoney())) {
				count += curtomer.update(salesorder.getCid(),
						(salesorder.getPaymoney() - salesorder.getPreprice() - salesorder.getTainmoney()));
			}
		}

		Sales sales = new Sales();

		sales.setId(UUID.randomUUID().toString());

		sales.setCode(UUID.randomUUID().toString());

		sales.setSoid(salesorder.getId());

		sales.setCid(salesorder.getCid());

		sales.setUid("0");

		sales.setPaymoney(salesorder.getPaymoney());

		sales.setTainmoney(salesorder.getTainmoney());

		sales.setTime(new Date());

		sales.setUpdatetime(sales.getTime());

		sales.setState(0);

		sales.setStoreid("1");

		sales.setPaytype(salesorder.getPaytype());

		sales.setCount(salesorder.getCount());

		count += salesMapper.insertSelective(sales);

		count += salesdetailsMapper.addcode(sales);

		Vector<Salesdetails> vector = salesdetailsMapper.queryBySid(sales.getId());

		for (Salesdetails item : vector) {

			updateCount(item);

		}

		return bool;
	}

	/**
	 * 递归的去减库存
	 * @Description:GoodsSupperMan
	 * @param item 销售订单详情对象
	 */
	public void updateCount(Salesdetails item) {
		
		Stockdetails goodsCount = stockdetail.queryCount(item.getGvid(),"1");

		if(goodsCount == null) {
			
			bool = false;
			
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return;
		}

		
		Salesstockrecord salesstockrecord = new Salesstockrecord();
		
		salesstockrecord.setId(UUID.randomUUID().toString());

		salesstockrecord.setGvid(item.getGvid());

		salesstockrecord.setSalesdetailid(item.getId());

		salesstockrecord.setStockdetailid(goodsCount.getId());

		salesstockrecord.setTime(new Date());

		salesstockrecord.setUpdatetime(salesstockrecord.getTime());

		salesstockrecord.setUid("1");

		salesstockrecord.setState(0);

		salesstockrecord.setStoreid("1");
		
		if (goodsCount.getCount() < item.getCount()) {

			stockdetail.updateCount(goodsCount.getCode(), goodsCount.getCount(), item.getGvid());

			if (stockdetail.selectCount(goodsCount.getCode(),"1") == 0) {

				stockM.updateState(goodsCount.getCode());

			}

			stockdetail.update(goodsCount.getId());
			
			salesstockrecord.setCount(goodsCount.getCount());

			salesstockrecord.setPrice(goodsCount.getCount() * item.getPrice());

			salesstockrecordmapper.insertSelective(salesstockrecord);

			item.setCount(item.getCount() - goodsCount.getCount());

			updateCount(item);

		} else {

			stockdetail.updateCount(goodsCount.getCode(), item.getCount(), item.getGvid());

			if (goodsCount.getCount() == item.getCount()) {

				if (stockdetail.selectCount(goodsCount.getCode(),"1") == 0) {

					stockM.updateState(goodsCount.getCode());

				}

				stockdetail.update(goodsCount.getId());

			}

			salesstockrecord.setCount(item.getCount());

			salesstockrecord.setPrice(item.getCount() * item.getPrice());

			salesstockrecordmapper.insertSelective(salesstockrecord);

		}
		
	}

	@Override
	public int inserorderDesc(Vector<Salesdetails> salesdetails) {
		// TODO Auto-generated method stub
		
		for (Salesdetails item : salesdetails) {
			
			salesdetailsMapper.update(item.getId());
			
			
			
			
		}
		
		return 0;
	}

}
