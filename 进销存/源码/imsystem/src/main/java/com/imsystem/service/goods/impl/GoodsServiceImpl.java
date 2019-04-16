package com.imsystem.service.goods.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customertype;
import com.imsystem.domain.Goods;
import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.GoodsValueVo;
import com.imsystem.domain.Goodsprice;
import com.imsystem.domain.Goodsstandardvalue;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Img;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
import com.imsystem.mapper.CustomertypeMapper;
import com.imsystem.mapper.GoodsMapper;
import com.imsystem.mapper.GoodspriceMapper;
import com.imsystem.mapper.GoodsstandardvalueMapper;
import com.imsystem.mapper.GoodsvalueMapper;
import com.imsystem.mapper.ImgMapper;
import com.imsystem.mapper.StockMapper;
import com.imsystem.mapper.StockdetailsMapper;
import com.imsystem.service.goods.GoodsService;

/**
 * 商品服务层实现
 * 
 * @author dws
 *
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	/**
	 * 商品Mapper
	 */
	@Autowired
	private GoodsMapper goodsMap;

	/**
	 * 商品实例Mapper
	 */
	@Autowired
	private GoodsvalueMapper goodsValueMap;

	/**
	 * 商品价格Mapper
	 */
	@Autowired
	private GoodspriceMapper goodsPriceMap;

	/**
	 * 图片Mapper
	 */
	@Autowired
	private ImgMapper imgMapper;

	/**
	 * 商品规格实例
	 */
	@Autowired
	private GoodsstandardvalueMapper goodsStandardMap;
	
	/**
	 * 库存mapper
	 */
	@Autowired
	private StockMapper stockMap;
	
	/**
	 * 库存详表Map
	 */
	@Autowired
	private StockdetailsMapper stockDetailsMap;
	
	/**
	 * 客户类型查询
	 */
	@Autowired
	private CustomertypeMapper customeTypeMap;
	

	@Override
	public List<Customertype> queryCustomerType() {
		// TODO Auto-generated method stub
		return customeTypeMap.queryCustomerType();
	}
	
	
	/**
	 * 商品新增
	 */
	@Override
	public int insertGoods(GoodsVO goodsVo, String url) {

		String gid = UUID.randomUUID().toString();
		String stockId = UUID.randomUUID().toString();

		goodsVo.getGoods().setId(gid);
		goodsVo.getGoods().setState(0);

		int count = goodsMap.insertSelective(goodsVo.getGoods());

		Stock stock = new Stock();
		
		stock.setId(stockId);
		stock.setCid("0");
		stock.setCode("0");
		stock.setSid("0");
		
		stockMap.insertSelective(stock);
		
		for (Img img : goodsVo.getGoodsImgs()) {
			
			if(img != null) {
				img.setId(UUID.randomUUID().toString());
				
				img.setGid(gid);
				imgMapper.insertSelective(img);
				
			}

		}
		
		//没有商品实例的时候
		if(goodsVo.getGoodsValues() == null) {
			
			Goodsvalue goodsValue = new Goodsvalue();
			String goodsvID = UUID.randomUUID().toString();
			goodsValue.setId(goodsvID);
			goodsValue.setName("");
			goodsValue.setGid(gid);
			goodsValue.setDefaultvalue(1);
			goodsValueMap.insertSelective(goodsValue);
			
			//添加库存
			Stockdetails sd = new Stockdetails();
			sd.setId(UUID.randomUUID().toString());
			sd.setSid(stockId);
			sd.setGvid(goodsvID);
			sd.setPrice(goodsVo.getGoods().getJprice());
			sd.setState(0);
			sd.setTime(new Date());
			//默认15
			sd.setCount(20);
			
			return stockDetailsMap.insertSelective(sd);
		}
		

		for (Goodsvalue gv : goodsVo.getGoodsValues()) {

			if (gv != null) {

				gv.setGid(gid);

				String gvid = UUID.randomUUID().toString();
				gv.setId(gvid);

				

				File dest = new File(url);
				/* 选择文件上传路径,如果没有则创建 */
				if (!dest.exists()) {
					dest.mkdirs();
				}

				if (gv.getImg() != null) {

					try {
						// 唯一标示id
						String uuid = UUID.randomUUID().toString();
						// 获取文件名
						String name2 = gv.getImg().getOriginalFilename();

						if (name2 != "" && name2 != null) {
							// 获取文件后缀名
							String suffix = name2.substring(name2.lastIndexOf("."), name2.length());
							File fileImg = new File(url + uuid + suffix);
							// 图片路径
							gv.setColumn1("/goods/" + uuid + suffix);
							
							System.out.println("图片长度:"+gv.getColumn1().length());
							
							gv.getImg().transferTo(fileImg);
							gv.setDefaultvalue(0);
						}

					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				// 商品实例添加
				goodsValueMap.insertSelective(gv);

				//库存详表添加
				gv.getStockDetails().setSid(stockId);
				gv.getStockDetails().setSid(UUID.randomUUID().toString());
				gv.getStockDetails().setGvid(gvid);
				gv.getStockDetails().setState(0);
				gv.getStockDetails().setTime(new Date());
				stockDetailsMap.insertSelective(gv.getStockDetails());
				
				// 商品规格值实例添加
				for (Goodsstandardvalue stv : gv.getGoodsstandardvalues()) {

					if (stv != null) {
						
						stv.setId(UUID.randomUUID().toString());
						
						stv.setVid(gvid);
						goodsStandardMap.insertSelective(stv);
					}

				}

				// 商品价格添加
				for (Goodsprice gp : gv.getGoodsPrices()) {

					if (gp != null) {
						gp.setId(UUID.randomUUID().toString());
						gp.setGvid(gvid);
						goodsPriceMap.insertSelective(gp);

					}

				}

			}

		}

		return count;
	}


	@Override
	public List<GoodsValueVo> queryAllGoods(String liketext,String [] svid,String tid) {
		// TODO Auto-generated method stub
		return goodsMap.queryAllGoods(liketext,svid,tid);
	}


	/**
	 * 商品修改加载
	 */
	@Override
	public Goods updateGoodsLoad(String id) {
		// TODO Auto-generated method stub
		return goodsMap.updateGoodsLoad(id);
	}

}
