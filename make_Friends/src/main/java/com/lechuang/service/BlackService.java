package com.lechuang.service;

import java.util.List;

import com.lechuang.bean.Black;

public interface BlackService {
	
	void addBlackpeople(Black black);
	int selectByB_Openid(String u_open_id);
	List<Black> selectFilterByB_Openid(String l_open_id);

	List<Black> getB_open_id(String u_open_id, String sex);
    

}
