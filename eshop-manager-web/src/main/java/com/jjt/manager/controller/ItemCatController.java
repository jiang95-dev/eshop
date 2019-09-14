package com.jjt.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjt.common.pojo.EasyUITreeNode;
import com.jjt.manager.service.ItemCatService;

@Controller
@RequestMapping("/item-cat")
public class ItemCatController {
	@Autowired
	private ItemCatService catservice;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0") Long parentId){
		List<EasyUITreeNode> list = catservice.getItemCatListByParentId(parentId);
		return list;
	}
}