package com.jjt.manager.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjt.manager.mapper.TestMapper;
import com.jjt.manager.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	static Logger logger = Logger.getLogger(TestServiceImpl.class);
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public String queryDate() {
		logger.info("Service called: queryDate.");
		return this.testMapper.queryDate();
	}
}
