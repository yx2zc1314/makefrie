package com.lechuang.mapper;

import java.util.List;

import com.lechuang.bean.User;

public interface UserMapper {
	void addUserInfo(User user);
	void updateUserDate(User user);
	User selectBy_OpenId(String u_open_id);
	void updateUserInfo(User user);
	void updateUserGeocentricism(User user);
	List<User> selectBy_Sex(String sex);
}
