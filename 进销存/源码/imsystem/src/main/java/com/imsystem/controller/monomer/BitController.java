package com.imsystem.controller.monomer;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Bit;
import com.imsystem.service.monomer.BitService;



@Controller
@RequestMapping("/bit")
public class BitController {
	@Autowired
	BitService ser;
	
	@RequestMapping("/query")
	public String queryBit(Model model) {
		return "xl/spdanwei";
	}
	
	@RequestMapping("/querybitbypage" )
	@ResponseBody
	public PageInfo<Bit> queryByLikepage(String tiaojian,Integer currentPage){
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		PageInfo<Bit> page=ser.queryByLikepage(tiaojian, currentPage, 5);
		return page;
		
	}
	
	
	@RequestMapping("/updatestate")
	public String updatestate(String id) {
		
		int r=ser.updatestate(id);
		System.err.println(r);
		return "redirect:/bit/query";
	}
	
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(String name,String uid) {
		Bit bit=ser.querybyname(name);
		System.err.println(bit);
		if (bit==null) {
			String id=new Date().getTime() +"";
			Bit bi=new Bit();
			bi.setId(id);
			bi.setName(name);
			bi.setUid(uid);
			int r=ser.insertSelective(bi);
			return r;
		}else {
			return 0;
		}
		
	}
	
	@RequestMapping("/querybyid")
	@ResponseBody
	public Bit update(String id) {
		Bit bit=ser.querybyid(id);
		return bit;
	}
	
	@RequestMapping("/toupdate")
	@ResponseBody
	public int  toupdate(Bit bit){
		Bit bitt=ser.querybyname(bit.getName());
		
		if (bitt==null) {
			int r=ser.toupdate(bit);
			return r;
		}else {
			return 0;
		}
		
	
	}
	
	
	
	
	
	/*@RequestMapping("/query")
	public String queryBit(Model model) {
		List<Bit> list=ser.queryall();
		model.addAttribute("list", list);
		return "xl/spdanwei";
	}*/
	
	/*@RequestMapping("/query")
	public String queryByPage(Model model,Integer currentPage) {
		
		if(currentPage==null) {
			
			currentPage=1;
		
		}
		
		PageInfo<Bit> pageInfo=ser.querybit(currentPage, 5);
		
		model.addAttribute("pageInfo", pageInfo);
		
		return "xl/spdanwei";
	}
	@RequestMapping("queryBit")
	@ResponseBody
	public PageInfo<Bit> queryBit(Integer currentPage){

		PageInfo<Bit> pageInfo=ser.querybit(currentPage, 5);
		
		return pageInfo;
	}
	
	@RequestMapping("/queryByLike")
	@ResponseBody
	public PageInfo<Bit> queryByLikepage(String text ,Integer currentPage){
		PageInfo<Bit> pageInfo=ser.queryByLikepage(text, currentPage, 5);
		return pageInfo;
		
	}
	
	
	*/
	
	
	
	}

