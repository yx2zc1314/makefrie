package com.lechuang.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lechuang.bean.Communication;
import com.lechuang.bean.Invited;
import com.lechuang.service.CommunicationService;

import net.sf.json.JSONObject;

@Controller
public class CommunicationController {
	
	@Autowired
	CommunicationService communicationService;
	
	/**
	 * 发出邀请
	 * @param communicationInfo
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("sendInvitation")
	public void sendInvitation(String communicationInfo,HttpServletResponse response) throws IOException {
		
		Communication c=new Communication();
		JSONObject obj = JSONObject.fromObject(communicationInfo);
		c.setI_open_id(obj.getString("i_open_id"));
		c.setB_open_id(obj.getString("b_open_id"));
		c.setDistance((Double.valueOf(obj.getString("distance"))));
		c.setSuitability((Integer.valueOf(obj.getString("suitability"))));
		c.setStatus("0");
		//调用插库Insert的方法，初始状态为0
		communicationService.sendInvitation(c);	
		
	}
	
	/**
	 * 同意邀请
	 * @param communicationInfo
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("acceptInvitation")
	public void acceptInvitation(String communicationInfo,HttpServletResponse response) throws IOException {
		Communication c=new Communication();
		JSONObject obj = JSONObject.fromObject(communicationInfo);
		c.setI_open_id(obj.getString("i_open_id"));
		c.setB_open_id(obj.getString("b_open_id"));
		//调用Update的方法,修改状态为1
		communicationService.acceptInvitation(c);
		
	}
	/**
	 * 拒绝邀请
	 * @param communicationInfo
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("rejectInvitation")
	public void rejectInvitation(String communicationInfo,HttpServletResponse response) throws IOException {
		Communication c=new Communication();
		JSONObject obj = JSONObject.fromObject(communicationInfo);
		c.setI_open_id(obj.getString("i_open_id"));
		c.setB_open_id(obj.getString("b_open_id"));
		//调用Update的方法,修改状态为2
		communicationService.rejectInvitation(c);
	}
	
	/**
	 * 查看被邀请的信息
	 * @param u_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("select_B_Invited")
	public void select_B_Invited(String u_open_id,HttpServletResponse response) throws IOException {
		List<Invited> invited=communicationService.select_B_Invited(u_open_id);
		JsonArray ja = new JsonArray();
		for (int i = 0; i < invited.size(); i++) {
			JsonObject jo = new JsonObject();
			jo.addProperty("i_open_id", invited.get(i).getI_open_id());
			jo.addProperty("b_open_id", invited.get(i).getB_open_id());
			jo.addProperty("u_name", invited.get(i).getU_name());
			jo.addProperty("u_l_name", invited.get(i).getU_l_name());
			jo.addProperty("distance", invited.get(i).getDistance());
			jo.addProperty("suitability", invited.get(i).getSuitability());
			jo.addProperty("sex", invited.get(i).getSex());
			ja.add(jo);

		}
		Writer out = response.getWriter();
		out.write(ja.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 查询同意邀请的信息
	 * @param u_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("select_B_Accept")
	public void select_B_Accept(String u_open_id,HttpServletResponse response) throws IOException {
		List<Invited> invited=communicationService.select_B_Accept(u_open_id);
		JsonArray ja = new JsonArray();
		for (int i = 0; i < invited.size(); i++) {
			JsonObject jo = new JsonObject();
			jo.addProperty("i_open_id", invited.get(i).getI_open_id());
			jo.addProperty("b_open_id", invited.get(i).getB_open_id());
			jo.addProperty("u_name", invited.get(i).getU_name());
			jo.addProperty("u_l_name", invited.get(i).getU_l_name());
			jo.addProperty("distance", invited.get(i).getDistance());
			jo.addProperty("suitability", invited.get(i).getSuitability());
			jo.addProperty("sex", invited.get(i).getSex());
			ja.add(jo);

		}
		Writer out = response.getWriter();
		out.write(ja.toString());
		out.flush();
		out.close();	
	}
	
	
	
	
	
}
