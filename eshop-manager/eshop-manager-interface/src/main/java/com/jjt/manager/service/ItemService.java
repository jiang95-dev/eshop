package com.jjt.manager.service;

import com.jjt.common.pojo.EasyUIDataGridResult;

public interface ItemService {
	public EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
