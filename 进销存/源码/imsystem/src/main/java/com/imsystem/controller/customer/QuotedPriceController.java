package com.imsystem.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.QuoteVO;
import com.imsystem.service.customer.QuotedPriceService;

@Controller
@RequestMapping("quotedprice")
public class QuotedPriceController {
	
	@Autowired
	QuotedPriceService qService;
	
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
	
	@RequestMapping("updatequotedprice")
	public String updateQuotedPrice(String qid,Double price) {
		int row=qService.updatePrice(qid, price);
		return "redirect:toquotedprice";
	}

}
