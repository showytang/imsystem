package com.imsystem.service.goods.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.Goodsprice;
import com.imsystem.domain.Goodsstandardvalue;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.Img;
import com.imsystem.domain.Stock;
import com.imsystem.domain.Stockdetails;
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
	 * 
	 */
	@Override
	public int insertGoods(GoodsVO goodsVo, String url) {

		String gid = UUID.randomUUID().toString();
		String stockId = UUID.randomUUID().toString();

		goodsVo.getGoods().setId(gid);

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
			goodsValue.setGid(gid);
			
			goodsValueMap.insertSelective(goodsValue);
			
			//添加库存
			Stockdetails sd = new Stockdetails();
			sd.setId(UUID.randomUUID().toString());
			sd.setSid(stockId);
			sd.setGvid(goodsvID);
			sd.setPrice(goodsVo.getGoods().getJprice());
			//默认15
			sd.setCount(15);
			
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
							gv.setColumn1("static/goodsimg/" + uuid + suffix);
							
							System.out.println("图片长度:"+gv.getColumn1().length());
							
							gv.getImg().transferTo(fileImg);
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

}
