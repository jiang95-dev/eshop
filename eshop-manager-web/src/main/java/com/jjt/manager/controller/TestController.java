package com.jjt.manager.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjt.manager.service.TestService;

@Controller
@RequestMapping("test")
public class TestController {
	static Logger logger = Logger.getLogger(TestController.class);

	@Autowired
	private TestService testService;

	@RequestMapping("date")
	@ResponseBody
	public String queryDate() {
		logger.info("Service called: queryDate.");
		return this.testService.queryDate();
	}
}