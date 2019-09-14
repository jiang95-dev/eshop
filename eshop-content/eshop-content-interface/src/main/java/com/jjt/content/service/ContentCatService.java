package com.jjt.content.service;
import java.util.List;

import com.jjt.common.pojo.EasyUITreeNode;
import com.jjt.common.pojo.Result;

public interface ContentCatService {
	public List<EasyUITreeNode> getContentCategoryList(Long parentId);
	
	public Result createContentCategory(Long parentId, String name);
	
	public Result updateContentCategory(Long id, String name);
	
	public Result deleteContentCategory(Long id, Long parentId);
}
