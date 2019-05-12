package com.imsystem.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.QuoteVO;
import com.imsystem.domain.Quotedprice;
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
	public String choseOneGoodsValue(Model model,String gid,String cc,String cv,String gc,String gts) {
		//String gts1=gts.trim();
		model.addAttribute("gid", gid);
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		model.addAttribute("gts", gts);
		
		return "lxy/AddQuote";
	}
	
	@RequestMapping("tochosegoods")
	public String toChoseGoods(Model model,String cc,String cv,String gc,String gv,String gts) {
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		model.addAttribute("gv", gv);
		model.addAttribute("gts", gts);
		return "lxy/ChooseGoods";
	}
	
	/**
	 *   #选择根据客户报价需要选择的商品
	 * @param model
	 * @param cc
	 * @param cv
	 * @param gc
	 * @param gv
	 * @param qvo
	 * @return
	 */
	@RequestMapping("choosegoods")
	public String chooseGoods(Model model,String cc,String cv,String gc,String gv,String gts,QuoteVO qvo) {
		List<QuoteVO> qchooselist=new ArrayList<QuoteVO>();
		if(cv!="" || cv!=null) {
			
			if(qvo.getQplist()!=null) {
				int num=0;
				for(Quotedprice qobj:qvo.getQplist()) {
					if(qobj.getId().equals("0")) {
						qobj.setId(null);
						QuoteVO qcObj=new QuoteVO();
						qcObj.setGobj(qvo.getGlist().get(num));
						qcObj.setQpobj(qvo.getQplist().get(num));
						qcObj.setGvobj(qvo.getGvlist().get(num));
						qchooselist.add(qcObj);
					}
					num++;
				}
			}
			
		}
		
		
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		model.addAttribute("gid", gv);
		model.addAttribute("gts", gts);
		model.addAttribute("qvolist1", qchooselist);
		return "lxy/AddQuote";
	}
	
	@RequestMapping("querygoodsquotelist")
	@ResponseBody
	public List<QuoteVO> queryGoodsQuoteList(String name,String cid){
		return qService.queryGoodsQuoteList(name, cid);
	}
	
	@RequestMapping("tochosecustomers")
	public String toChoseCustomers(Model model,String cc,String cv,String gc,String gv,String gts) {
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		model.addAttribute("gv", gv);
		model.addAttribute("gts", gts);
		return "lxy/ChooseCustomers";
	}
	
	
	@RequestMapping("querycustomerquotelist")
	@ResponseBody
	public List<QuoteVO> queryCustomerQuoteList(String name,String gid){
		return qService.queryCustomerQuoteList(name, gid);
	}
	
	@RequestMapping("choosecustomers")
	public String chooseCustomers(Model model,String cc,String cv,String gc,String gv,String gts,QuoteVO qvo) {
		List<QuoteVO> qchooselist=new ArrayList<QuoteVO>();
		if(gv!="" || gv!=null) {
			
			if(qvo.getQplist()!=null) {
				int num=0;
				for(Quotedprice qobj:qvo.getQplist()) {
					if(qobj.getId().equals("0")) {
						qobj.setId(null);
						QuoteVO qcObj=new QuoteVO();
						qcObj.setCobj(qvo.getClist().get(num));
						qcObj.setQpobj(qvo.getQplist().get(num));
						qchooselist.add(qcObj);
					}
					num++;
				}
			}
			
		}
		model.addAttribute("cc", cc);
		model.addAttribute("cv", cv);
		model.addAttribute("gc", gc);
		model.addAttribute("gid", gv);
		model.addAttribute("gts", gts);
		model.addAttribute("qvolist", qchooselist);
		return "lxy/AddQuote";
	}
	
	
	
	@RequestMapping("queryprice")
	@ResponseBody
	public Double queryPrice(String cid,String gvid){
		Double price=qService.queryPrice(cid, gvid);
		return price;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("addquote")
	public String addquote(QuoteVO qvo,String uid) {
		int row=qService.addQuote(qvo, uid);
		return "redirect:toquotedprice";
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
