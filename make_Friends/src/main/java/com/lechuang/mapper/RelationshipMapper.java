package com.lechuang.mapper;

import java.util.List;

import com.lechuang.bean.Relationship;

public interface RelationshipMapper {

	List<Relationship> selectRelationshipByB_OpenID(String i_open_id);
	Relationship delecteByB_OpenID(String b_open_id);

}
