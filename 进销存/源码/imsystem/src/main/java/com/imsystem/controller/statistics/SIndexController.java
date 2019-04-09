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
	@RequestMapping("goBaoBiao_3")
	public String goBaoBiao_3() {
		return "yhb/BaoBiao3";
	}
}
