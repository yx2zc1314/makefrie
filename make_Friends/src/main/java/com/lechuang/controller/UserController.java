package com.lechuang.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.lechuang.bean.Black;
import com.lechuang.bean.User;
import com.lechuang.service.BlackService;
import com.lechuang.service.UserService;
import com.lechuang.util.AddressController;

import net.sf.json.JSONObject;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	BlackService blackService;
	/**
	 * 添加一些基本信息,授权登录
	 * 
	 * @param uinfo
	 * @param u_open_id
	 * @param response
	 *            String uinfo,String u_open_id,
	 * @throws IOException
	 */
	@RequestMapping("addUserInfo")
	public void addUserInfo(HttpServletResponse response) throws IOException {
		User u = new User();
		/*
		 * JSONObject obj = JSONObject.fromObject(uinfo);
		 * u.setU_l_name(obj.getString("u_l_name"));
		 * u.setU_address(obj.getString("u_address"));
		 * u.setSex(obj.getString("sex")); u.setU_open_id(u_open_id);
		 */
		u.setU_l_name("房万杰");
		u.setU_address("小小少年");
		u.setSex("男");
		u.setU_open_id("123");
		// 插入数据前查询此用户是否已存在。
		User us = userService.selectBy_OpenId(u.getU_open_id());
		if (us != null) {
			// 更新
			userService.updateUserInfo(u);
		} else {
			userService.addUserInfo(u);
		}
	}

	/**
	 * 添加测试用的生日等数据,顺带上经纬度,最后加上星盘参数
	 * 
	 * @param userDate
	 * @param u_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("updateUserDate")
	public void updateUserDate(String userDate, String u_open_id, String latitude, String longitude,
			HttpServletResponse response) throws IOException {
		User user = new User();
		JSONObject obj = JSONObject.fromObject(userDate);
		// String转Date,simpleDateFormat.parse(xxx)
		// Date转String,simpleDateFormat.format(xxx)
		user.setU_name(obj.getString("u_name"));
		user.setU_date(obj.getString("u_date"));
		user.setU_time(obj.getString("u_time"));
		user.setU_open_id(u_open_id);
		user.setLatitude(latitude);
		user.setLongitude(longitude);
		userService.updateUserDate(user);
	}

	/**
	 * 查询用户表所有信息
	 * 
	 * @param u_open_id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("selectBy_OpenId")
	public void selectBy_OpenId(String u_open_id, HttpServletResponse response) throws IOException {
		User user = userService.selectBy_OpenId(u_open_id);
		Writer out = response.getWriter();
		System.out.println("**" + user.toString());
		out.write(user.toString());
		out.flush();
		out.close();

	}

	/**
	 * 根据用户输入的性别查询用户表所有信息
	 * 
	 * @param
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("selectBy_Sex")
	public void selectBy_Sex(String u_open_id, String sex, HttpServletResponse response) throws IOException {
		System.out.println(u_open_id + sex);
		List<User> user = userService.selectBy_Sex(sex);// 所有注册用户

		//查询被拉黑的人的ID
		List<Black> black=blackService.getB_open_id(u_open_id,sex);
		//循环并从User(男/女)的id中删除被拉黑的id
		System.out.println(user.size());
		for(int i = 0;i<user.size();i++){
			System.out.println("xx+++xx"+user.size()+"**"+black.size());
			for (int k = 0; k < black.size(); k++) {
				System.out.println("老严");
				if(user.get(i).getU_open_id().equals(black.get(k).getB_open_id())){				
					user.remove(i);
					System.out.println("房万杰"+i);
				}
			}
			
	     }
		
		List<User> u_s = new ArrayList<User>();
		User user_login = userService.selectBy_OpenId(u_open_id);// 登录用户
		for (int i = 0; i < user.size(); i++) {
			Double s = AddressController.getDistance(user.get(i).getLongitude(), user.get(i).getLatitude(),
					user_login.getLongitude(), user_login.getLatitude());
			user.get(i).setS(s);
			u_s.add(user.get(i));
		}

		System.out.println("*+++---*" + JSON.toJSONString(u_s));

		Collections.sort(u_s, new Comparator<User>() {
			public int compare(User o1, User o2) {
				return (int) (o1.getS() - o2.getS());
			}
		});
		List<User> data_list=new ArrayList<User>();
		for (int i = 0; i<u_s.size(); i++) {
			
			if(i<20){
				data_list.add(u_s.get(i));
			}else{
				break;
			}
			System.out.println("*-*-*" + u_s.get(i).getU_open_id() + "--+" + u_s.get(i).getS());
		}
		System.out.println(data_list.size()+"*-*-*" + JSON.toJSONString(data_list));

		//data_list最终获取小于等于20条处理（去除拉黑过的人、拿出距离用户最近，最后去20条）过得数据然后传递给星盘，计算指数。
		
		
		
		Writer out = response.getWriter();
		out.write(data_list.toString());
		out.flush();
		out.close();

	}

	/**
	 * 修改个人信息如生日，职业，微信号等
	 * 
	 * @param userInfo
	 * @param u_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("updateUserInfo")
	public void updateUserInfo(String userInfo, String u_open_id, HttpServletResponse response) throws IOException {
		User user = new User();
		JSONObject obj = JSONObject.fromObject(userInfo);
		user.setU_address(obj.getString("u_address"));
		user.setU_date(obj.getString("u_date"));
		user.setU_name(obj.getString("u_name"));
		user.setU_open_id(u_open_id);
		userService.updateUserInfo(user);
	}

	/**
	 * 查询地心学数据
	 * 
	 * @param u_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("SelectUserInfo")
	public void SelectUserInfo(String u_open_id, HttpServletResponse response) throws IOException {
		User u = userService.selectBy_OpenId(u_open_id);
		JsonObject t = new JsonObject();
		t.addProperty("HIY", u.getHIY());
		t.addProperty("JDY", u.getJDY());
		t.addProperty("MDJ", u.getMDJ());
		t.addProperty("SHH", u.getSHH());
		t.addProperty("SYG", u.getSYG());
		t.addProperty("TFI", u.getTFI());
		t.addProperty("HIY", u.getHIY());
		Writer out = response.getWriter();
		out.write(t.toString());
		out.flush();
		out.close();
	}

	/**
	 * 添加地心学数据
	 * 
	 * @param geocentricismInfo
	 * @param u_open_id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("updateUserGeocentricism")
	public void updateUserGeocentricism(String geocentricismInfo, String u_open_id, HttpServletResponse response)
			throws IOException {
		User user = new User();
		JSONObject obj = JSONObject.fromObject(geocentricismInfo);
		user.setHIY(obj.getString("HIY"));
		user.setJDY(obj.getString("JDY"));
		user.setMDJ(obj.getString("MDJ"));
		user.setSHH(obj.getString("SHH"));
		user.setSYG(obj.getString("SYG"));
		user.setTFI(obj.getString("TFI"));
		user.setHIY(obj.getString("HIY"));
		user.setU_open_id(u_open_id);
		userService.updateUserGeocentricism(user);
	}

}
