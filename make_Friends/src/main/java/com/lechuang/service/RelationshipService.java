package com.lechuang.service;

import java.util.List;

import com.lechuang.bean.Relationship;

public interface RelationshipService {
	
	List<Relationship> selectRelationshipByB_OpenID(String i_open_id);
	void delecteByB_OpenID(String b_open_id);
}
