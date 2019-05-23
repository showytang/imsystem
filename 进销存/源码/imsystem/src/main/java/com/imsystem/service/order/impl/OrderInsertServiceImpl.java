package com.imsystem.service.order.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.imsystem.domain.Paytype;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesback;
import com.imsystem.domain.Salesbackdetails;
import com.imsystem.domain.Salesdetails;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Salesorderdetails;
import com.imsystem.domain.Salesstockrecord;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Stockrecord;
import com.imsystem.domain.Supplier;
import com.imsystem.domain.Userandlable;
import com.imsystem.domain.Userlableandgoodsvalue;
import com.imsystem.mapper.CustomerMapper;
import com.imsystem.mapper.PaytypeMapper;
import com.imsystem.mapper.SalesMapper;
import com.imsystem.mapper.SalesbackMapper;
import com.imsystem.mapper.SalesbackdetailsMapper;
import com.imsystem.mapper.SalesdetailsMapper;
import com.imsystem.mapper.SalesorderMapper;
import com.imsystem.mapper.SalesorderdetailsMapper;
import com.imsystem.mapper.SalesstockrecordMapper;
import com.imsystem.mapper.StockMapper;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.mapper.StockrecordMapper;
import com.imsystem.mapper.SupplierMapper;
import com.imsystem.mapper.UserandlableMapper;
import com.imsystem.mapper.UserlableandgoodsvalueMapper;
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

	@Autowired
	SalesbackMapper salesbackMap;

	@Autowired
	SalesbackdetailsMapper salesbackdetailsmapper;

	@Autowired
	SupplierMapper supperMap;

	@Autowired
	PaytypeMapper pay;

	@Autowired
	UserandlableMapper userandlable;

	@Autowired
	UserlableandgoodsvalueMapper userlableGoodsVaue;

	@Override
	public int insert(Stock stock) {

		stock.setId(UUID.randomUUID().toString());

		for (int i = 0; i < stock.getStockdetails().size(); i++) {
			stock.getStockdetails().get(i).setId(UUID.randomUUID().toString());
		}

		Supplier supp = new Supplier();

		supp.setId(stock.getSid());

		if (Double.parseDouble(stock.getColumn1()) > Double.parseDouble(stock.getColumn2())) {

			supp.setBalance(Double.parseDouble(stock.getColumn1()) - Double.parseDouble(stock.getColumn2()));

			supperMap.updateBalanceJia(supp);

		}
		if (Double.parseDouble(stock.getColumn1()) < Double.parseDouble(stock.getColumn2())) {

			supp.setBalance(Double.parseDouble(stock.getColumn2()) - Double.parseDouble(stock.getColumn1()));

			supperMap.updateBalancejian(supp);

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

		if (!(salesorder.getCid().equals("0"))) {

			curtomer.updateplug(salesorder.getCid(), salesorder.getPreprice());

		}

		salesorder.setId(UUID.randomUUID().toString());

		salesorder.setUpdatetime(salesorder.getTime());

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

		for (Stockdetails item : stock.getStockdetails()) {

			stockdetail.updateDetails(item);

		}

		if (stockdetail.selectCount(stock.getCode(), stock.getStoreid()) <= 0) {

			stockM.updateState(stock.getCode());

		}

		stockM.updatePrice(stock.getId());

		Supplier sup = new Supplier();

		NumberFormat number = NumberFormat.getNumberInstance();

		number.setMaximumFractionDigits(2);

		sup.setId(stock.getSid());

		double price = stockdetail.querydetailsSumPrice(stock.getId());

		if (price > Double.parseDouble(stock.getColumn1())) {

			sup.setBalance(price - Double.parseDouble(stock.getColumn1()));

			sup.setBalance(Double.parseDouble(number.format(sup.getBalance())));

			supperMap.updateBalanceJia(sup);
		}
		if (price < Double.parseDouble(stock.getColumn1())) {

			sup.setBalance(Double.parseDouble(stock.getColumn1()) - price);

			sup.setBalance(Double.parseDouble(number.format(sup.getBalance())));

			supperMap.updateBalancejian(sup);
		}

		return 0;
	}

	@Override
	public int allot(Vector<Stockdetails> stockde) {

		int count = 0;
		String storeid = "1";
		for (Stockdetails item : stockde) {

			count += stockdetail.updateCount(item.getCode(), item.getCount(), item.getGvid());

			storeid = item.getStoreid();

			if (stockdetail.selectCount(item.getCode(), storeid) == 0) {
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
		stock.setUid(stockde.get(0).getUid());
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
			stod.setStoreid(item.getStoreid());
			stod.setTime(item.getTime());
			stod.setUid(item.getUid());
			list.add(stod);

			Stockrecord stockcords = new Stockrecord();
			stockcords.setId(UUID.randomUUID().toString());
			stockcords.setAftersdid(item.getId());
			stockcords.setBeforesdid(stod.getId());
			stockcords.setAftersid(stockde.get(0).getColumn1());
			stockcords.setBeforesid(item.getColumn1());

			count += stockcord.insertSelective(stockcords);
		}

		stock.setStockdetails(list);

		count += stockdetail.add(stock);

		return count;
	}

	Boolean bool = true;

	String storeidd;

	String uidd;

	@Override
	public Boolean insertOrderOut(Salesorder salesorder) {
		// TODO Auto-generated method stub
		bool = true;
		int count = salesorderMapper.updatePregress(salesorder.getId(), "2");

		if (salesorder.getCid() != "0") {
			if (salesorder.getPaymoney() > (salesorder.getPreprice() + salesorder.getTainmoney())) {
				count += curtomer.update(salesorder.getCid(), salesorder.getPaymoney()-(salesorder.getPreprice() + salesorder.getTainmoney()));
			} else if (salesorder.getPaymoney() < (salesorder.getPreprice() + salesorder.getTainmoney())) {
				count += curtomer.updateplug(salesorder.getCid(),
						((salesorder.getPreprice() + salesorder.getTainmoney())) - salesorder.getPaymoney());
			}
		}

		storeidd = salesorder.getStoreid();

		uidd = salesorder.getUid();

		Sales sales = new Sales();

		sales.setId(UUID.randomUUID().toString());

		sales.setCode(UUID.randomUUID().toString());

		sales.setSoid(salesorder.getId());

		sales.setCid(salesorder.getCid());

		sales.setUid(salesorder.getUid());

		sales.setPaymoney(salesorder.getPaymoney());

		sales.setTainmoney(salesorder.getTainmoney() + salesorder.getPreprice() > salesorder.getPaymoney()
				? salesorder.getPaymoney()
				: salesorder.getTainmoney() + salesorder.getPreprice());

		sales.setPrice(salesorder.getPrice());

		sales.setTime(new Date());

		sales.setUpdatetime(sales.getTime());

		sales.setState(0);

		sales.setStoreid(salesorder.getStoreid());

		sales.setPaytype(salesorder.getPaytype());

		sales.setCount(salesorder.getCount());

		count += salesMapper.insertSelective(sales);

		count += salesdetailsMapper.addcode(sales);

		List<Userandlable> list = userandlable.queryByCid(salesorder.getCid());
		
		Vector<Salesdetails> vector = salesdetailsMapper.queryBySid(sales.getId());

		for (Salesdetails item : vector) {

			for (Userandlable u : list) {

				Userlableandgoodsvalue us = new Userlableandgoodsvalue();

				us.setId(UUID.randomUUID().toString());

				us.setGvid(item.getGvid());

				us.setUid(uidd);

				us.setUlid(u.getId());

				us.setTime(new Date());

				us.setState(0);

				userlableGoodsVaue.insertSelective(us);
			}

			updateCount(item);

		}

		return bool;
	}

	/**
	 * 递归的去减库存
	 * 
	 * @Description:GoodsSupperMan
	 * @param item 销售订单详情对象
	 */
	public void updateCount(Salesdetails item) {

		Stockdetails goodsCount = stockdetail.queryCount(item.getGvid(), storeidd);

		if (goodsCount == null) {

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

		salesstockrecord.setUid(uidd);

		salesstockrecord.setState(0);

		salesstockrecord.setStoreid(storeidd);

		if (goodsCount.getCount() < item.getCount()) {

			stockdetail.updateCount(goodsCount.getCode(), goodsCount.getCount(), item.getGvid());

			if (stockdetail.selectCount(goodsCount.getCode(), storeidd) == 0) {

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

				if (stockdetail.selectCount(goodsCount.getCode(), storeidd) == 0) {

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

		Salesback sales = new Salesback();

		sales.setId(UUID.randomUUID().toString());

		sales.setTime(new Date());

		sales.setUid(salesdetails.get(0).getUid());

		sales.setStoreid(salesdetails.get(0).getStoreid());

		sales.setColumn1(salesdetails.get(0).getId());

		sales.setCount(0);
		sales.setPaymoney(0.00);
		sales.setTainmoney(0.00);

		int count = 0;
		for (Salesdetails item : salesdetails) {
			
			salesdetailsMapper.update(item.getId());

			sales.setCount(sales.getCount() + item.getCount());

			sales.setPaymoney(sales.getPaymoney() + sales.getCount() * item.getPrice());

			sales.setTainmoney(sales.getTainmoney() + sales.getCount() * item.getPrice());

			Salesbackdetails salesbackdetails = new Salesbackdetails();

			salesbackdetails.setId(UUID.randomUUID().toString());

			salesbackdetails.setSid(sales.getId());

			salesbackdetails.setColumn1(item.getId());

			salesbackdetails.setUpdatime(sales.getTime());

			salesbackdetails.setUid(item.getUid());

			salesbackdetails.setStoreid(item.getStoreid());

			count += salesbackdetailsmapper.add(salesbackdetails);

			if (item.getColumn4() != "0") {

				count += curtomer.updateplug(item.getColumn3(), item.getPrice() * item.getCount());

			}

			List<Salesstockrecord> list = salesstockrecordmapper.querystockdetails(item.getId());

			for (Salesstockrecord salesstockrecord : list) {

				count += stockdetail.updateScount(salesstockrecord.getStockdetailid(), salesstockrecord.getCount());

			}

		}

		salesbackMap.add(sales);

		int sum = salesdetailsMapper.selectCount(salesdetails.get(0).getColumn3());

		if (sum == 0) {
			Sales s = new Sales();

			s.setId(salesdetails.get(0).getColumn3());

			s.setState(1);

			salesMapper.updateByPrimaryKeySelective(s);
		}

		return count;
	}

	@Override
	public int UpdateSalesOrder(Salesorder sales) {

		for (Salesorderdetails item : sales.getList1()) {

			salesorderdetailsMapper.updateCount(item);

		}

		int count = salesorderMapper.updateCount(sales.getId());

		return count;
	}

	@Override
	public List<Paytype> queryPaytype() {
		// TODO Auto-generated method stub
		return pay.selectByExample(null);
	}

	@Override
	public int salesorderDel(String id, String cid, Double Moeny) {
		// TODO Auto-generated method stub

		salesorderMapper.deleteByPrimaryKey(id);

		if (!(cid.equals("0"))) {
			curtomer.update(cid, Moeny);
		}

		return salesorderdetailsMapper.deleteBySid(id);
	}

	@Override
	public Boolean insertSales(Sales sales) {
		// TODO Auto-generated method stub
		bool = true;
		storeidd = sales.getStoreid();
		uidd = sales.getUid();

		if (sales.getCid() != "0") {
			if (sales.getPaymoney() > sales.getTainmoney()) {
				curtomer.update(sales.getCid(), sales.getPaymoney() - sales.getTainmoney());
			} else if (sales.getPaymoney() < sales.getTainmoney()) {
				curtomer.updateplug(sales.getCid(), sales.getTainmoney() - sales.getPaymoney());
			}
		}

		sales.setId(UUID.randomUUID().toString());

		sales.setCode(UUID.randomUUID().toString());

		sales.setTime(new Date());

		sales.setUpdatetime(sales.getTime());

		List<Userandlable> list = userandlable.queryByCid(sales.getCid());

		for (Salesdetails item : sales.getList()) {

			item.setId(UUID.randomUUID().toString());

			for (Userandlable u : list) {

				Userlableandgoodsvalue us = new Userlableandgoodsvalue();

				us.setId(UUID.randomUUID().toString());
				
				us.setGvid(item.getGvid());

				us.setUid(uidd);

				us.setUlid(u.getId());

				us.setTime(new Date());

				us.setState(0);

				userlableGoodsVaue.insertSelective(us);
			}

		}

		salesMapper.insertSelective(sales);

		salesdetailsMapper.add(sales);

		Vector<Salesdetails> vector = salesdetailsMapper.queryBySid(sales.getId());

		for (Salesdetails item : vector) {

			updateCount(item);

		}

		return bool;
	}

}
