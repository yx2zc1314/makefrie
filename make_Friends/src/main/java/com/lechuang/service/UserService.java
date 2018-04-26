package com.lechuang.service;

import java.util.List;

import com.lechuang.bean.User;

public interface UserService {
	void addUserInfo(User user);
	void updateUserDate(User user);
	User selectBy_OpenId(String u_open_id);
	void updateUserGeocentricism(User user);
	void updateUserInfo(User user);
	List<User> selectBy_Sex(String sex);
	
}
