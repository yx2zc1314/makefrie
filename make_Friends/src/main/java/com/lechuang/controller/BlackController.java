package com.lechuang.controller;

import java.io.IOException;
import java.io.Writer;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lechuang.bean.Black;
import com.lechuang.service.BlackService;
import com.lechuang.service.RelationshipService;




@Controller
public class BlackController {
	
	@Autowired
	BlackService blackService;
	@Autowired
	RelationshipService relationshipService;
	/**
	 * 拉黑用户
	 * @param l_open_id 拉黑
	 * @param b_open_id 被拉黑
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("addBlackpeople")
	public void addBlackpeople(String l_open_id,String b_open_id,HttpServletResponse response) throws IOException {
		Black black = new Black();
		black.setL_open_id(l_open_id);
		black.setB_open_id(b_open_id);
		blackService.addBlackpeople(black);
	}
	/**
	 * 查询用户被拉黑的次数
	 * @param u_open_id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	
	@RequestMapping("selectByB_Openid")
	public void selectByB_Openid(String u_open_id,HttpServletResponse response) throws IOException {
		int count=blackService.selectByB_Openid(u_open_id);
		Writer out = response.getWriter();
		if (count>=5) {
			
			out.write(1);//返回1前端捕捉到后就友好提示一下
			out.flush();
			out.close();
		}else{
			System.out.println(count);
		}
	}	
	
	
}
