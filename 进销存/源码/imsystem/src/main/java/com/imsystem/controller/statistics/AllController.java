package com.imsystem.controller.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.domain.Store;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.setup.StoreService_c;
import com.imsystem.service.statistics.GoodsValueService;
import com.imsystem.service.statistics.SalesService;
import com.imsystem.service.statistics.SalesorderService;
import com.imsystem.service.statistics.StockDetailsService;
import com.imsystem.service.statistics.StockService;
import com.imsystem.service.statistics.StoreService;

@Controller
@RequestMapping("/statistics")
public class AllController {
	@Autowired
	SalesorderService salesorderS;
	@Autowired
	StoreService storeS;
	@Autowired
	GoodsValueService gvs;
	@Autowired
	StockDetailsService stockDS;
	@Autowired
	StockService stocks;
	@Autowired
	SalesService ss;
	@Autowired
	CustomerService cs;
	@Autowired
	StoreService_c ssc;
	
	/**
	 * index top 四方格
	 * @return
	 */
	Integer pageSize = 2;
	
	@RequestMapping("query")
	@ResponseBody
	public Salesorder query(String storeid, String code, String startTime, String endTime) {
		List<Salesorder> list = salesorderS.query(storeid, code, startTime, endTime);
		Salesorder sale = new Salesorder();
		sale.setPaymoney(0.0);
		sale.setCount(0);
		sale.setColumn2("0");
		sale.setColumn3("暂无数据");
		sale.setColumn1("0");
		int sum = 0;
		for (Salesorder s : list) {
			if(s!=null) {
				 sum+=1;
				 sale.setPaymoney(sale.getPaymoney()+s.getPaymoney());
				 sale.setColumn1(s.getPaymoney()+Double.parseDouble(sale.getColumn1())+"");//计算成本
			}		
		}
		sale.setCount(sum);//今日订单量
		String lr = Double.parseDouble(sale.getColumn1()) - sale.getPaymoney()+"";
		sale.setColumn2(lr);//利润
		if (list!=null) {
			if(list.get(0)==null) {
				
			}else {
				String id = salesorderS.queryFirst(storeid, code, startTime, endTime).getStoreid();//查询今日销量冠军
				Store store = storeS.selectByPrimaryKey(id);
				sale.setColumn3(store.getName()+"【"+store.getSufname()+"】");//今日销量冠军
			}
		}
		return sale;
	}
	/**
	 * By cody 查询商品
	 * @param code
	 * @return
	 */
	@RequestMapping("queryByCode")
	@ResponseBody
	public List<Goodsvalue> queryByCode(String code){
		List<Goodsvalue> list = gvs.queryByCode(code);
		return list;
	}
	@RequestMapping("queryDaysAgo")
	@ResponseBody
	public List<Salesorder> queryDaysAgo(String storeid,String startTime,String endTime,String state){
		
		if (state.equals("null")) {
			List<Salesorder> list  = salesorderS.queryDaysAgo(storeid,startTime,endTime);
			return list;
		}else {
			List<Salesorder> list1 = salesorderS.queryByTime(startTime, endTime,storeid);
			if (list1.size()>0) {
				for (Salesorder s : list1) {
					s.setList(gvs.queryByCode(s.getId()));
				}
			}
			return list1;
		}
	}
	/***
	 * 查询店铺排名
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("queryRanking")
	@ResponseBody
	public List<Salesorder> queryRanking(String startTime, String endTime,String storeId){
		List<Salesorder> list = salesorderS.queryRanking(startTime, endTime,storeId);
		if (list.size()>0) {
			for (Salesorder ss : list) {
				Integer tedayMoney = salesorderS.queryTedayMoney(ss.getStoreid());
				if (tedayMoney != null) {
					ss.setColumn2(tedayMoney+"");
				}else {
					ss.setColumn2("0");
				}
				List<Goodsvalue> l = gvs.queryGoodsBySid(ss.getStoreid(),startTime,endTime);
				if (l.size()>0) {
					ss.setList(l);
				}
			}
		}
		return list;
	}
	/***
	 * 查询利润
	 * @param year
	 * @param storeId
	 * @return
	 */
	@RequestMapping("queryThisYear")
	@ResponseBody
	public List<Salesorder> queryThisYear(String year,String storeId) {
		List<Salesorder> list = salesorderS.queryThisYear(year);
		if (list.size()>0) {
			for (Salesorder ss : list) {
				List<Goodsvalue> gv = gvs.queryGoodsRanking(ss.getColumn3(),"","",storeId,"","");
				if (gv.size()>0) {
					ss.setList(gv);
				}
			}
		}
		return list;
	}
	/***
	 * 查询商品排名
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param storeId
	 * @return
	 */
	@RequestMapping("queryGoodsRanking")
	@ResponseBody
	public List<Goodsvalue> queryGoodsRanking(String time,String startTime,String endTime,String storeId){
		List<Goodsvalue> list = gvs.queryGoodsRanking(time, startTime, endTime, storeId,"","");
		return list;
	}
	
	/***
	 * 查询商品销售明细
	 * @param currentPage
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param storeId
	 * @param gid
	 * @return
	 */
	@RequestMapping("queryGoodsDetail")
	@ResponseBody
	public PageInfo<Goodsvalue> queryGoodsDetail(Integer currentPage,String time,String startTime,String endTime,String storeId,String gid,String name){
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		Page<Goodsvalue> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Goodsvalue> list = gvs.queryGoodsByTime(time, startTime, endTime, storeId, gid,name);
		return page.toPageInfo();
	}
	/***
	 * 查询店铺所有商品明细
	 * @param storeId
	 * @return
	 */
	@RequestMapping("queryAllGoodsDetail")
	@ResponseBody
	public List<Goodsvalue> queryAllGoodsDetail(String storeId){
		List<Goodsvalue> list = gvs.queryGoodsByTime(null, null, null, storeId, null,"");
		return list;
	}
	/***
	 * 进货查询
	 * @param currentPage
	 * @param startTime
	 * @param endTime
	 * @param cid
	 * @return
	 */
	@RequestMapping("queryJinHuo")
	@ResponseBody
	public PageInfo<Stockdetails> queryJinHuo(Integer currentPage,String startTime,String endTime,String cid,String storeId){
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		Page<Stockdetails> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Stockdetails> list = stockDS.queryJinHuo(startTime, endTime, cid,storeId);
		return page.toPageInfo();
	}
	/***
	 * 查询库存
	 * @param currentPage
	 * @param gid
	 * @param storeId
	 * @return
	 */
	@RequestMapping("queryStockByGidAndStoreId")
	@ResponseBody
	public PageInfo<Stockdetails> queryStockByGidAndStoreId(Integer currentPage,String gid,String storeId,String name){
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		Page<Stockdetails> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Stockdetails> list = stockDS.queryStockByGidAndStoreId(gid, storeId,name);
		return page.toPageInfo();
	}
	/***
	 * 查询欠款
	 * @param currentPage
	 * @param startTime
	 * @param endTime
	 * @param sid
	 * @return
	 */
	@RequestMapping("queryQianKuan")
	@ResponseBody
	public PageInfo<Stock> queryQianKuan(Integer currentPage,String startTime,String endTime,String sid){
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		Page<Stock> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Stock> list = stocks.queryQianKuan(startTime, endTime, sid);
		return page.toPageInfo();
	}
	@RequestMapping("queryAllQianKuan")
	@ResponseBody
	public List<Stock> queryAllQianKuan(String startTime,String endTime,String sid){
		List<Stock> list = stocks.queryQianKuan(startTime, endTime, sid);
		return list;
	}
	/***
	 *	收账
	 * @param currentPage
	 * @param startTime
	 * @param endTime
	 * @param cid
	 * @return
	 */
	@RequestMapping("queryShouZhang")
	@ResponseBody
	public PageInfo<Sales> queryShouZhang(Integer currentPage,String startTime,String endTime,String cid,String storeid){
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		Page<Sales> page = PageHelper.startPage(currentPage, pageSize, true);
		List<Sales> list = ss.queryShouZhang(cid, startTime, endTime,storeid);
		return page.toPageInfo();
	}
	
	@RequestMapping("queryAllShouZhang")
	@ResponseBody
	public List<Sales> queryAllShouZhang(String startTime,String endTime,String cid,String storeid){
		List<Sales> list = ss.queryShouZhang(cid,startTime,endTime,storeid);
		return list;
	}
	/***
	 * 查询客户
	 * @param sid
	 * @return
	 */
	@RequestMapping("queryCustomer")
	@ResponseBody
	public List<Customer> queryCustomer(String sid){
		List<Customer> list = cs.queryCustomerByStore(sid);
		return list;
	}
	
	@RequestMapping("queryStore")
	@ResponseBody
	public List<Store> queryStore() {
		List<Store> list = ssc.queryStoreAll();
		System.out.println(list);
		return list;
	}
	
}
