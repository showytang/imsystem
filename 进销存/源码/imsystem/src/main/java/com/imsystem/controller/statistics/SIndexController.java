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
}
