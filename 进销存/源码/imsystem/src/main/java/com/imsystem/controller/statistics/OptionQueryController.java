package com.imsystem.controller.statistics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.imsystem.domain.GoodsValueVo;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.Sales;
import com.imsystem.domain.Salesorder;
import com.imsystem.domain.Supplier;
import com.imsystem.service.goods.GoodsService;
import com.imsystem.service.statistics.GoodsValueLableService;
import com.imsystem.service.statistics.GoodsValueService;
import com.imsystem.service.statistics.SalesService;
import com.imsystem.service.statistics.SalesorderService;
import com.imsystem.service.statistics.Supplier_yService;
import com.imsystem.util_y.Sending;

import net.sf.jsqlparser.expression.operators.conditional.AndExpression;

@RestController
@RequestMapping("ther")
public class OptionQueryController {
	@Autowired
	GoodsService gs;
	@Autowired
	Supplier_yService ss;
	@Autowired
	SalesService salesService;
	@Autowired
	GoodsValueService gvs;
	@Autowired
	GoodsValueLableService gvals;
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	SalesorderService sos;

	@RequestMapping("queryGoods")
	public List<GoodsValueVo> queryGoods() {
		List<GoodsValueVo> list = gs.queryAllGoods("", null, "");
		return list;
	}

	@RequestMapping("querySupplier_yByStore")
	public List<Supplier> querySupplier_yByStore(String sid) {
		List<Supplier> list = ss.querySupplier_yByStore(sid);
		return list;
	}

	@RequestMapping("queryXf")
	public List<Sales> queryXf(String sid, String startTime, String endTime) {
		List<Sales> list = salesService.queryXf(sid, startTime, endTime);
		if (list.size() > 0) {
			for (Sales s : list) {
				List<Goodsvalue> glist = gvs.querySalesByCid(s.getCid(), startTime, endTime);
				s.setGlist(glist);
			}
		}
		return list;
	}

	@RequestMapping("queryLikeGoodsValue")
	public List<Goodsvaluelable> queryLikeGoodsValue(String cid, String season) {
		if (cid == null || cid == "") {
			cid = "0";
		}
		List<Goodsvaluelable> list = gvals.querySalesGoodsValueByLable(cid, season);
		List<Goodsvaluelable> l = new ArrayList<>();
		for (Goodsvaluelable gvl : list) {
			List<Goodsvaluelable> ll = gvals.queryByLid(gvl.getId(), season);
			l.addAll(ll);
		}
		Random rand = new Random();//随机数
		//获取用户买过的商品
		List<Salesorder> salesGoodsBycid = sos.querySalesGoodsByCid(cid);
		if (salesGoodsBycid.size()>0) {
			//生成随机数
			int getSg = rand.nextInt(list.size());
			//根据购买过的商品随机推荐购买过此商品客户购买过最多的其他的商品
			List<Goodsvaluelable> lb = gvals.queryTaLikeBygvid(salesGoodsBycid.get(getSg).getColumn1());
			for (Goodsvaluelable lbs : lb) {
				Goodsvaluelable gl = gvals.queryGoodsBygvid(lbs.getId());
				if (gl!=null) {
					l.add(gl);//查询商品
				}
			}
		}
		//查询用户标签
		List<Goodsvaluelable> usLable = gvals.queryUlidByCid(cid);
		if (usLable.size()>0) {
			//取随机用户标签
			int getull = rand.nextInt(usLable.size());
			//根据用户标签查询商品
			String ulid =  usLable.get(getull).getColumn1();
			if (ulid != null && ulid != "") {
				List<Goodsvaluelable> byUlGoods = gvals.queryGoodsByUl(ulid);
				for (Goodsvaluelable byul : byUlGoods) {
					if (byul.getId()!=""&&byul.getId()!=null) {
						l.add(byul);
					}
				}
			}
		}
		//删除重复商品
		 for  ( int  i  =   0 ; i  <  l.size()  -   1 ; i ++ )  {
			 System.out.println(l.size());
			 System.out.println(l.get(l.size()-1).getId());
		      for  ( int  j  =  l.size()  -   1 ; j  >  i; j -- )  {  
		    	 System.out.println(j);
		    	 System.out.println(l.get(j).getId());   
		           if  (l.get(j).getId().equals(l.get(i).getId()))  {       
		              l.remove(j); 
		              continue;
		            }
		        }        
		 } 
		return l;
	}

	/***
	 * 邮件
	 * 
	 * @param Addressee
	 * @param title
	 * @param content
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping("SendMail")
	public String SendMail(String Addressee, String title, String [] content,String [] img,String cName,String text,String phone) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setFrom("yw5820n@163.com");

		helper.setTo(Addressee);

		helper.setSubject(title);
		if (text != null && text != "") {
			text = text.replace("[cName]", cName);
		}else {
			text = cName+" 小仙女，这次[米莱琪]为您推荐了更适合您的衣服哦。快些看看吧~~~，期待您再次下凡[莱米琪]哦~~~。";
		}
		String cont = "<html><body><div style='width: 100%;height: 100%;'><h3 style='text-indent: 20px;margin:30px;color: #ffc09f;border-bottom: 1px solid #ffc09f;padding-bottom: 20px;'>"+text+"</h3>";
		for(int i = 0;i<content.length;i++) {
			content[i] = content[i].replaceAll("/goods/"+img[i], "cid:"+img[i]);
			cont += content[i];
		}
		cont += "</div></body></html>";
		helper.setText(cont, true);

		// 注意addInline()中资源名称 hello 必须与 text正文中cid:hello对应起来

		for(int s = 0;s<img.length;s++) {
			FileSystemResource file1 = new FileSystemResource(new File("d:\\img\\goods\\"+img[s]));

			helper.addInline(img[s], file1);
		}

		try {

			mailSender.send(mimeMessage);
			if (phone != null && phone != "") {
				Sending.mobileQuery(phone);
			}

			System.out.println("success");

		} catch (Exception e) {
			System.out.println("error"+e);
			return "0";

		}
		return "1";
	}

}
