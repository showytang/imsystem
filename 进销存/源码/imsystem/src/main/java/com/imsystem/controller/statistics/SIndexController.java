package com.imsystem.controller.statistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sIndex")
public class SIndexController {
	@RequestMapping("goIndex")
	public String goIndex() {
		return "yhb/index";
	}
	@RequestMapping("goBaoBiao_1")
	public String goBaoBiao_1() {
		return "yhb/BaoBiao1";
	}
	@RequestMapping("goBaoBiao_2")
	public String goBaoBiao_2() {
		return "yhb/BaoBiao2";
	}
	@RequestMapping("goBaoBiao_3")
	public String goBaoBiao_3() {
		return "yhb/BaoBiao3";
	}
	@RequestMapping("goGoodsRanking")
	public String goodsRanking() {
		return "yhb/goodsPaim";
	}
	@RequestMapping("goJinHuo")
	public String goJinHuo() {
		return "yhb/jinhuo";
	}
	@RequestMapping("goKuCun")
	public String goKuCun() {
		return "yhb/Kucun";
	}
	@RequestMapping("goMingXi")
	public String goMingXi() {
		return "yhb/mingxi";
	}
	@RequestMapping("goQianKuan")
	public String goQianKuan() {
		return "yhb/qiankuan";
	}
	@RequestMapping("goShouZhang")
	public String goShouZhang() {
		return "yhb/shouzhang";
	}	
	@RequestMapping("goBaoBiao_4")
	public String goBaoBiao_4() {
		return "yhb/BaoBiao_4";
	}
	@RequestMapping("goGoodsLike")
	public String goGoodsLike() {
		return "yhb/GoodsLike";
	}
}
