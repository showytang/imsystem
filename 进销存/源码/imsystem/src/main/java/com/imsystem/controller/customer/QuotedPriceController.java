package com.imsystem.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quotedprice")
public class QuotedPriceController {
	
	@RequestMapping("toquotedprice")
	public String toQuotedPrice() {
		return "lxy/Quote";
	}
	
	@RequestMapping("toaddquote")
	public String toAddQuote() {
		return "lxy/AddQuote";
	}

}
