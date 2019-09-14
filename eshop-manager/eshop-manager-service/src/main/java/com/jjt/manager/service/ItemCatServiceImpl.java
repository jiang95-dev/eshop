package com.jjt.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjt.common.pojo.EasyUITreeNode;
import com.jjt.manager.mapper.ItemCatMapper;
import com.jjt.manager.pojo.ItemCat;
import com.jjt.manager.pojo.ItemCatExample;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private ItemCatMapper catmapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatListByParentId(Long parentId) {
		ItemCatExample example = new ItemCatExample();
		ItemCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<ItemCat> list = catmapper.selectByExample(example);
		List<EasyUITreeNode> nodes = new ArrayList();
		for (ItemCat itemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent() ? "closed" : "open");
			nodes.add(node);
		}
		return nodes;
	}

}
