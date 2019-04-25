package com.imsystem.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.QuoteVO;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.QuotedPriceService;

@Controller
@RequestMapping("quotedprice")
public class QuotedPriceController {
	
	@Autowired
	QuotedPriceService qService;
	@Autowired
	CustomerService cService;
	
	@RequestMapping("toquotedprice")
	public String toQuotedPrice() {
		return "lxy/Quote";
	}
	
	@RequestMapping("queryquoteprice")
	@ResponseBody
	public PageInfo<QuoteVO> queryQuotedPrice(String cname,String gname,Integer curentPage){
		if(curentPage==null) {
			curentPage=1;
		}
		Page<QuoteVO> page=PageHelper.startPage(curentPage, 1, true);
		List<QuoteVO> qlist = qService.queryQuoteByPage(cname, gname, curentPage);
		for(int i=0;i<qlist.size();i++) {
			page.set(i, qlist.get(i));
		}
		PageInfo<QuoteVO> pages=page.toPageInfo();
		return pages;
	}
	
	
	
	
	@RequestMapping("toaddquote")
	public String toAddQuote() {
		return "lxy/AddQuote";
	}
	
	@RequestMapping("querycustomers")
	@ResponseBody
	public List<Customer> queryCustomers(){
		return cService.queryCustomer();
	}
	
	@RequestMapping("queryquotebycustomerid")
	@ResponseBody
	public List<QuoteVO> queryQuoteByCustomerId(String cid){
		return qService.queryQuoteByCustomerId(cid);
	}
	
	@RequestMapping("queryquotebygoodsvalueid")
	@ResponseBody
	public List<QuoteVO> queryQuoteByGoodsValueId(String gid){
		return qService.queryQuoteByGoodsValueId(gid);
	}
	
	@RequestMapping("tochoseonegoodsvalue")
	public String toChoseOneGoodsValue(Model model,String cc,String cname,String gc) {
		model.addAttribute("customerChoose", cc);
		model.addAttribute("customerName", cname);
		model.addAttribute("goodsChoose", gc);
		return "dws/customerPickGoods";
	}
	
	@RequestMapping("choseonegoodsvalue")
	public String choseOneGoodsValue(Model model,String gid,String cc,String cv,String gc) {
		model.addAttribute("gid", gid);
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		return "lxy/AddQuote";
	}
	
	@RequestMapping("tochosecustomers")
	public String toChoseCustomers(Model model,String cc,String cv,String gc,String gv) {
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		model.addAttribute("gv", gv);
		return "lxy/ChooseGoods";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("updatequotedprice")
	public String updateQuotedPrice(String qid,Double price) {
		int row=qService.updatePrice(qid, price);
		return "redirect:toquotedprice";
	}
	
	@RequestMapping("deletequote")
	public String deleteQuote(String qid) {
		int row=qService.deleteQuotedPrice(qid);
		return "redirect:toquotedprice";
	}

}
