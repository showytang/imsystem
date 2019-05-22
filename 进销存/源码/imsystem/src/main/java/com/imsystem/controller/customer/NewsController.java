package com.imsystem.controller.customer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Noticefiles;
import com.imsystem.domain.Store;
import com.imsystem.service.customer.CustomerService;
import com.imsystem.service.customer.NewsService;

@Controller
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	NewsService nsService;
	@Autowired
	CustomerService cService;
	
	@RequestMapping("tonewslist")
	public String toNewsList() {
		return "lxy/MyNews";
	}
	
	@RequestMapping("querynewslist")
	@ResponseBody
	public PageInfo<NewsVo> queryNewsList(String content,Integer curentPage,String uid) {
		if(curentPage == null || curentPage <= 0 ) {
			curentPage = 1;
		}
		
		Page<NewsVo> page=PageHelper.startPage(curentPage, 3, true);
		List<NewsVo> nvlist = nsService.queryMyNotice(content, uid);
		for(int i=0;i<nvlist.size();i++) {
			if(nvlist.get(i)!=null) {
				page.set(i, nvlist.get(i));
			}
		}
		PageInfo<NewsVo> pages=page.toPageInfo();
		return pages;
	}
	
	@RequestMapping("querynewsbyid")
	@ResponseBody
	public NewsVo queryNewsById(String id) {
		return nsService.queryNoticeById(id);
	}
	
	@RequestMapping("toaddnews")
	public String toAddNews() {
		return "lxy/AddNews";
	}
	
	@RequestMapping("querystore")
	@ResponseBody
	public List<Store> querystore(String uid){
		return cService.queryTypeAndLevel(uid).getSlist();
	}
	
	@RequestMapping("addnews")
	@ResponseBody
	public int addNews(MultipartFile[] files,NewsVo nvobj) {
		String url="C:/Users/lenovo/git/imsystem/进销存/源码/imsystem/src/main/resources/static/assets/files/";
		if(files.length==0) {
			
			/*文件为空，不进行文件上传*/
			int row1=nsService.addNews(nvobj);
			
		}else {
			
			/*文件不为空，文件上传*/
			 File dest = new File(url);
			 if (!dest.exists()) {
		         dest.mkdirs();
		     }
			 try {
				List<Noticefiles> nflist=new ArrayList<Noticefiles>();
				for(MultipartFile f:files) {
					Noticefiles nfobj=new Noticefiles();
					//唯一标示id
	                String uuid = UUID.randomUUID().toString();
	                //获取文件名
	                String name2 = f.getOriginalFilename();
	                //获取文件后缀名
                    String suffix = name2.substring(name2.lastIndexOf("."), name2.length());
                    File fileImg = new File(url + uuid + suffix);
                    
                    //图片路径
                    nfobj.setFurl("assets/files/"+uuid + suffix);
                    f.transferTo(fileImg);
                    nflist.add(nfobj);
				}
				nvobj.setNflist(nflist);
				
				int row2=nsService.addNews(nvobj);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			 
		}
		return 0;
	}
	
	
	
	@RequestMapping("querynotreadnews")
	@ResponseBody
	public int queryNotReadNews(String uid) {
		int num=nsService.queryNotReadNews(uid);
		return num;
	}
	
	
	
	
	

}
