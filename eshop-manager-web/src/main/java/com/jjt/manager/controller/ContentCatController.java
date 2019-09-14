package com.jjt.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjt.common.pojo.EasyUITreeNode;
import com.jjt.common.pojo.Result;
import com.jjt.content.service.ContentCatService;

@Controller
@RequestMapping("/content/category")
public class ContentCatController {
	@Autowired
	private ContentCatService service;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value="id", defaultValue="0") Long parentId){
		return service.getContentCategoryList(parentId);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public Result createContentCategory(Long parentId, String name){
		return service.createContentCategory(parentId, name);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public void updateContentCategory(Long id, String name) {
		service.updateContentCategory(id, name);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public void deleteContentCategory(Long id, Long parentId) {
		service.deleteContentCategory(id, parentId);
	}
}
