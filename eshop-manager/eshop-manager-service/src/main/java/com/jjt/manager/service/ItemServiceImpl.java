package com.jjt.manager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jjt.common.pojo.EasyUIDataGridResult;
import com.jjt.manager.mapper.ItemMapper;
import com.jjt.manager.pojo.Item;
import com.jjt.manager.pojo.ItemExample;

@Service
public class ItemServiceImpl implements ItemService {
	private static Logger logger = Logger.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		if(page == null) page = 1;
		if(rows == null) rows = 10;
		PageHelper.startPage(page, rows);
		
		ItemExample example = new ItemExample();
		List<Item> list = itemMapper.selectByExample(example);
		logger.info("List length : " + list.size());
		PageInfo<Item> pageInfo = new PageInfo(list);
		
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int)pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}

}
