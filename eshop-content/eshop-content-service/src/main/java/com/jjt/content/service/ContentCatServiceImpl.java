package com.jjt.content.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjt.common.pojo.EasyUITreeNode;
import com.jjt.common.pojo.Result;
import com.jjt.manager.mapper.ContentCatMapper;
import com.jjt.manager.pojo.ContentCat;
import com.jjt.manager.pojo.ContentCatExample;

@Service
public class ContentCatServiceImpl implements ContentCatService{

	@Autowired
	private ContentCatMapper mapper;
	
	@Override
	public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
		ContentCatExample example = new ContentCatExample();
		ContentCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<ContentCat> list = mapper.selectByExample(example);	
		List<EasyUITreeNode> nodes = new ArrayList<>();
		for (ContentCat contentCat : list) {
			if(contentCat.getStatus() == 1) {
				EasyUITreeNode node = new EasyUITreeNode();
				node.setId(contentCat.getId());
				node.setState(contentCat.getIsParent() ? "closed" : "open");
				node.setText(contentCat.getName());
				nodes.add(node);
			}			
		}
		return nodes;
	}

	@Override
	public Result createContentCategory(Long parentId, String name) {
		ContentCat category = new ContentCat();
		category.setCreated(new Date());
		category.setIsParent(false); //The newly inserted node is always leaf node
		category.setName(name);
		category.setParentId(parentId);
		category.setSortOrder(1);
		category.setStatus(1);
		category.setUpdated(category.getCreated());
		mapper.insertSelective(category);		
		//If parent was leaf node, change its isParent to true
		ContentCat parent = mapper.selectByPrimaryKey(parentId);
		if(!parent.getIsParent()){
			parent.setIsParent(true);
			mapper.updateByPrimaryKeySelective(parent);
		}
		return Result.ok(category);
	}

	@Override
	public Result updateContentCategory(Long id, String name) {
		ContentCat category = new ContentCat();
		category.setId(id);
		category.setName(name);
		category.setUpdated(new Date());
		mapper.updateByPrimaryKeySelective(category);	
		return Result.ok();
	}

	@Override
	public Result deleteContentCategory(Long id, Long parentId) {
		ContentCat category = new ContentCat();
		category.setId(id);
		category.setUpdated(new Date());
		category.setStatus(0);
		mapper.updateByPrimaryKeySelective(category);	
		//If parent is now a leaf node, change its isParent to false
		ContentCatExample example = new ContentCatExample();
		ContentCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo(1);
		long count = mapper.countByExample(example);
		if(count == 0) {
			ContentCat parent = mapper.selectByPrimaryKey(parentId);
			parent.setIsParent(false);
			mapper.updateByPrimaryKeySelective(parent);
		}		
		return Result.ok();
	}

}
