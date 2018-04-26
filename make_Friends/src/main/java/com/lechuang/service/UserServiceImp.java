package com.lechuang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lechuang.bean.User;
import com.lechuang.mapper.UserMapper;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 添加用户的ID、昵称、性别、所居住城市
	 */
	public void addUserInfo(User user) {
		userMapper.addUserInfo(user);
		
	}
	/**
	 * 添加用户的出生日期，出生时间
	 */
	public void updateUserDate(User user) {
		userMapper.updateUserDate(user);
		
	}
	/**
	 * 查询用户是否授权，也就是u_open_id是否存在
	 */
	public User selectBy_OpenId(String u_open_id) {
		
		return userMapper.selectBy_OpenId(u_open_id);
	}
	/**
	 * 
	 * 更改微信号，生日，所在城市等信息
	 */
	public void updateUserInfo(User user) {
		userMapper.updateUserInfo(user);
		
	}
	/**
	 * 添加地心学数据
	 */
	public void updateUserGeocentricism(User user) {
		userMapper.updateUserGeocentricism(user);
		
	}
	public List<User> selectBy_Sex(String sex) {
		List<User> u=userMapper.selectBy_Sex(sex);
		return u;
	}
	


}
