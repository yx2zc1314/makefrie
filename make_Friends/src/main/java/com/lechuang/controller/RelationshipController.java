package com.lechuang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lechuang.bean.Relationship;
import com.lechuang.service.RelationshipService;


@Controller
public class RelationshipController {
	
	@Autowired
	RelationshipService relationshipService;
	/**
	 * 查询推荐的20人的ID
	 * @param l_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("getRelationshipByB_OpenID")
	public void selectRelationship(String l_open_id, HttpServletResponse response) throws IOException {
		List<Relationship> relationship=relationshipService.selectRelationshipByB_OpenID(l_open_id);
		
	}
	/**
	 * 个人通讯，发送邀请
	 */
	/*@RequestMapping("getRelationship_C2C")
	public void getRelationship_C2C(String l_open_id, HttpServletResponse response) throws IOException {
		List<Relationship> relationship=relationshipService.selectRelationshipByB_OpenID(l_open_id);
		
	}*/
}
