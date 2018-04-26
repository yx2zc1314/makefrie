package com.lechuang.mapper;

import java.util.List;

import com.lechuang.bean.Black;

public interface BlackMapper {

	void addBlackpeople(Black black);
	int selectByB_Openid(String u_open_id);
	List<Black> selectFilterByB_Openid(String l_open_id);
	List<Black> getB_open_id(String l_open_id, String sex);

}
