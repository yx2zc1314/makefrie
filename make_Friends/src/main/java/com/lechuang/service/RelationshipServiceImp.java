package com.lechuang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lechuang.bean.Relationship;
import com.lechuang.mapper.RelationshipMapper;


@Service
public class RelationshipServiceImp implements RelationshipService{
	
	@Autowired
	RelationshipMapper relationshipMapper;
	
	/**
	 * 查询推荐的20人
	 * @param l_open_id
	 * @return
	 */
	public List<Relationship> selectRelationshipByB_OpenID(String i_open_id) {
		
		return relationshipMapper.selectRelationshipByB_OpenID(i_open_id);
	}
	
	public void delecteByB_OpenID(String b_open_id) {
		relationshipMapper.delecteByB_OpenID(b_open_id);
		
	}
	
}
