package com.imsystem.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imsystem.domain.Goods;
import com.imsystem.domain.GoodsVO;
import com.imsystem.service.goods.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	/**
	 * 商品服务对象
	 */
	@Autowired
	private GoodsService goodsSer;
	
	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	@RequestMapping("/queryAllGoods")
	protected String queryAllGoods() {

		return "dws/Goods";
	}

	/**
	 * 按商品id查询单个商品详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryGoodsDetail")
	protected String queryGoodsDetail(Integer id) {

		System.out.println(id);

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
	protected String updateGoodsLoad(Integer id) {

		return "dws/updateGoods";

	}

	/**
	 * 修改商品（修改某一商品属性以及所有实例）
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/updateGoods")
	protected String updateGoods(Goods goods) {

		return "";

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
	 * 商品添加
	 * 
	 * @param goodsVo 商品Vo对象
	 * @return
	 */
	@RequestMapping("/insertGoods")
	protected String insertGoods(GoodsVO goodsVo) {

		goodsSer.insertGoods(goodsVo);
		
		return "";

	}

	/**
	 * 订单选择商品页面(WJH调用)
	 * 
	 * @return
	 */
	@RequestMapping("/orderPickGoods")
	public String orderOptionGoods() {

		return "dws/orderOptionGoods.html";

	}

	/**
	 * 客户报价商品查询(LXY使用)
	 * 
	 * @return
	 */
	@RequestMapping("/customerPickGoods")
	public String customerPickGoods(Goods goods) {

		return "dws/customerPickGoods";
	}

}
