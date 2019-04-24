package com.imsystem.controller.goods;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Goods;
import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.GoodsValueVo;
import com.imsystem.domain.Goodstype;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Img;
import com.imsystem.service.goods.GoodsDetailsService;
import com.imsystem.service.goods.GoodsService;
import com.imsystem.service.goods.GoodsTypeService;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Value("uploadimg")
	private String updataurl;
	
	/**
	 * 商品服务对象
	 */
	@Autowired
	private GoodsService goodsSer;
	/**
	 * 商品服务对象
	 */
	@Autowired
	private GoodsTypeService goodsTypeSer;
	
	/**
	 * 商品实例
	 */
	@Autowired
	private GoodsDetailsService goodsDetailSer;
	
	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	@RequestMapping("/queryAllGoods")
	protected String queryAllGoods() {
		
		return "dws/Goods";
	}
	
	@RequestMapping("/queryByAllGoods")
	@ResponseBody
	protected List queryByAllGoods() {
		
		return null;
	}
	

	/**
	 * 商品查询
	 * @param curPage 当前页
	 * @param liketext 输入内容
	 * @param svid 规格值id array
	 * @param tid 类型id
	 * @return
	 */
	@RequestMapping("/queryGoodsLikeAll")
	@ResponseBody
	protected PageInfo<GoodsValueVo> queryGoodsLikeAll(Integer curPage,String liketext,String [] svid,String tid) {
		
		svid = svid.length==0?null:svid;
		
		curPage = curPage == null?1:curPage;
		
		Page<GoodsValueVo> page = PageHelper.startPage(curPage, 8, true);
		
		PageInfo<GoodsValueVo> pageInfo = new PageInfo<GoodsValueVo>(goodsSer.queryAllGoods(liketext,svid,tid));
		
		
		return pageInfo;
		
	}
	
	/**
	 * 按商品id查询单个商品详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryGoodsDetail")
	protected String queryGoodsDetail(String id,Model model) {

		Goodsvalue gdv = goodsDetailSer.queryGoodsDetail(id);

		model.addAttribute("gdv", gdv);
		
		return "dws/detailsGoods";

	}

	/**
	 * 修改商品实例
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/updateGoodsDateil")
	protected String updateGoodsDateil(Goods goods) {

		return "";

	}

	/**
	 * 修改商品数据加载
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateGoodsLoad")
	protected String updateGoodsLoad(String id,Model model) {

		Goods goods = goodsSer.updateGoodsLoad(id);

		model.addAttribute("goods", goods);

		return "dws/updateGoods";

	}
	
	/**
	 * 类型反向递归
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryGoodsTypeReverse")
	@ResponseBody
	protected Goodstype queryGoodsTypeReverse(String id) {
		
		return goodsTypeSer.queryGoodsTypeReverse(id);
		
	}
	
	

	/**
	 * 修改商品（修改某一商品属性以及所有实例）
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/updateGoods")
	@ResponseBody
	protected Integer updateGoods(MultipartFile[] files,GoodsVO goodsVo) {
		
		if(goodsVo.getGoods().getByteImg() != null) {
			//base64解码
			byte[] buffer1 = new Base64().decodeBase64(goodsVo.getGoods().getByteImg().getBytes());   
			goodsVo.getGoods().setImg(buffer1);   
		}
		
		//1.图片上传
		String url = "d:/img/" +"goods/";
		
        File dest = new File(url);
        /*选择文件上传路径,如果没有则创建*/
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {
        	List<Img> imgs = new ArrayList<Img>();
            for (MultipartFile f : files) {

            	//图片表对象
            	Img img = new Img();
            	
            	if(goodsVo.getGoods().getColumn5() == null && goodsVo.getGoods().getImg() == null) {
            		
            		//获取输入流
    	            InputStream ins = f.getInputStream();
    	            File toFile = new File(f.getOriginalFilename());
    	            // MultipartFile 转 file
    	            ImgCompress.inputStreamToFile(ins, toFile);
            	    ImgCompress imgCom = new ImgCompress(toFile);  
            	    //压缩图片 返回byte[]
                    goodsVo.getGoods().setImg(imgCom.resizeFix(400, 400));
                    
                    ins.close();
            		continue;
            		
            	}
            	
                //唯一标示id
                String uuid = UUID.randomUUID().toString();
                //获取文件名
                String name2 = f.getOriginalFilename();
                //上传前名称
                img.setOldname(name2);

                if(name2 != "" && name2 != null){
                    //获取文件后缀名
                    String suffix = name2.substring(name2.lastIndexOf("."), name2.length());
                    File fileImg = new File(url + uuid + suffix);
                    //新名称
                    img.setName(uuid + suffix);
                    //图片路径
                    img.setUrl("/goods/"+uuid + suffix);
                    f.transferTo(fileImg);

                }
                if(goodsVo.getGoodsImgs()!=null) {
                	
                	goodsVo.getGoodsImgs().add(img);
                }else {
                	imgs.add(img);
                }
            }
            
            if(goodsVo.getGoodsImgs()==null) {
            	goodsVo.setGoodsImgs(imgs);
            }
            
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
        if(goodsVo.getGoods().getColumn5() != null) {
        	
		   File originalFile = new File("d:/img"+goodsVo.getGoods().getColumn5());//指定要读取的图片
	        try {
	        	/*
	            FileInputStream in = new FileInputStream(originalFile);
	            
	            byte[] bb = new byte[1024];// 存储每次读取的内容
	           goodsVo.getGoods().setImg(bb);
	            in.close();*/
	        	
	        	//创建一个字节流 
	        	InputStream inputStream = new FileInputStream(originalFile); 
	        	//把本地文件 转化成byte[] 
	        	ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
	        	byte[] buffer = new byte[1024]; 
	        	int len = 0; 
	        	while( (len=inputStream.read(buffer)) != -1 ){ 
	        	outStream.write(buffer, 0, len); 
	        	} 
	        	byte [] data = outStream.toByteArray();//转化成byte[] 网络上都是 byte [] data = new byte[inputStream.available()];这种方法不可取 
	        	//关闭流 
	        	
        	    ImgCompress imgCom = new ImgCompress(originalFile);  
        	    //压缩图片 返回byte[]
                goodsVo.getGoods().setImg(imgCom.resizeFix(400, 400));
                
	        	outStream.close(); 
	        	inputStream.close(); 
	        	
	        	
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        }
		
		return goodsSer.updateGoods(goodsVo, url);

	}

	/**
	 * 添加商品页面加载
	 * 
	 * @return
	 */
	@RequestMapping("/insertGoodsLoad")
	protected String insertGoodsLoad() {

		return "dws/addGoods";
	}
	
	/**
	 * 客户类型查询
	 * @return
	 */
	@RequestMapping("/queryCustomerType")
	@ResponseBody
	protected List queryCustomerType() {
		
		return goodsSer.queryCustomerType();
		
	}
	
	/**
	 * 商品类型查询
	 * @param id 父级id
	 * @return
	 */
	@RequestMapping("/queryGoodsTypeByPid")
	@ResponseBody
	protected List queryGoodsTypeByPid(String id) {
		
		return goodsTypeSer.QueryGoodsTypeByPid(id);
		
	}
	
	/**
	 * 商品类型规格值查询
	 * @param id 类型id
	 * @return
	 */
	@RequestMapping("/queryGoodsStandradByid")
	@ResponseBody
	protected List queryGoodsStandradByid(String id) {
		
		return goodsTypeSer.queryStandradByid(id);
		
	}
	
	
	
	

	/**
	 * 商品添加
	 * 
	 * @param goodsVo 商品Vo对象
	 * @return
	 */
	@RequestMapping("/insertGoods")
	@ResponseBody
	public int insertGoods(MultipartFile[] files,GoodsVO goodsVo) {

		String url = "d:/img/" +"goods/";
		
        File dest = new File(url);
        /*选择文件上传路径,如果没有则创建*/
        if (!dest.exists()) {
            dest.mkdirs();
        }

        boolean bool = true;
        
        try {

        	List<Img> goodsImg = new ArrayList<Img>();
        	
            for (MultipartFile f : files) {

            	//图片表对象
            	Img img = new Img();
            	
            	if(bool) {
            		bool = false;
            		
            		//获取输入流
    	            InputStream ins = f.getInputStream();
    	            File toFile = new File(f.getOriginalFilename());
    	            // MultipartFile 转 file
    	            ImgCompress.inputStreamToFile(ins, toFile);
            	    ImgCompress imgCom = new ImgCompress(toFile);  
            	    //压缩图片 返回byte[]
                    goodsVo.getGoods().setImg(imgCom.resizeFix(400, 400));
                    
                    ins.close();
            		continue;
            	}
            	
                //唯一标示id
                String uuid = UUID.randomUUID().toString();
                //获取文件名
                String name2 = f.getOriginalFilename();
                //上传前名称
                img.setOldname(name2);

                if(name2 != "" && name2 != null){
                    //获取文件后缀名
                    String suffix = name2.substring(name2.lastIndexOf("."), name2.length());
                    File fileImg = new File(url + uuid + suffix);
                    //新名称
                    img.setName(uuid + suffix);
                    
                    //图片路径
                    img.setUrl("/goods/"+uuid + suffix);
                    f.transferTo(fileImg);

                }
                
                goodsImg.add(img);

            }
            
            goodsVo.setGoodsImgs(goodsImg);

        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		return goodsSer.insertGoods(goodsVo,url);

	}

	/**
	 * 订单选择商品页面(WJH调用)
	 * 
	 * @return
	 */
	@RequestMapping("/orderPickGoods")
	public String orderOptionGoods() {

		return "dws/orderOptionGoods";

	}

	/**
	 * 客户报价商品查询(LXY使用)
	 * 
	 * @return
	 */
	@RequestMapping("/customerPickGoods")
	public String customerPickGoods() {

		return "dws/customerPickGoods";
	}

	
	
	
}
