package com.lechuang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lechuang.bean.Black;
import com.lechuang.mapper.BlackMapper;


@Service
public class BlackServiceImp implements BlackService{
	
	@Autowired
	BlackMapper blackMapper;
	
	/**
	 * 拉黑用户
	 * @param black
	 */
	public void addBlackpeople(Black black) {
		blackMapper.addBlackpeople(black);
		
	}
	/**
	 * 查询被拉黑的次数
	 * @param u_open_id
	 */
	public int selectByB_Openid(String u_open_id) {
		return blackMapper.selectByB_Openid(u_open_id);
		
	}
	/**
	 * 查询被拉黑人的B_open_id,遍历判断后，判断是否被匹配
	 * @param l_open_id
	 */
	public List<Black> selectFilterByB_Openid(String l_open_id) {
		
		return blackMapper.selectFilterByB_Openid(l_open_id);
	}
	/**
	 * 查询被拉黑的B_open_id的集合
	 * @param l_open_id
	 */
	public List<Black> getB_open_id(String l_open_id,String sex) {
		
		return blackMapper.getB_open_id(l_open_id,sex);
	}
}
