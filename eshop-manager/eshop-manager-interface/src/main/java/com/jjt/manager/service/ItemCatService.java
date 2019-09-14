package com.jjt.manager.service;

import java.util.List;

import com.jjt.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	public List<EasyUITreeNode> getItemCatListByParentId(Long parentId);
}
