package com.lechuang.bean;

/**
 * 推荐给A的朋友，遍历20个同A的匹配度高和距离近的用户B,C.D....（A被B/C/D...拒绝过的用户不会再被B/C/D...用户匹配）
 */
public class Relationship {
	private String i_open_id;//邀请人
	private String b_open_id;//被邀人
	private String relationship;//匹配度 
	private String distance;//距离
	
	
	
	public String getI_open_id() {
		return i_open_id;
	}
	public void setI_open_id(String i_open_id) {
		this.i_open_id = i_open_id;
	}
	public String getB_open_id() {
		return b_open_id;
	}
	public void setB_open_id(String b_open_id) {
		this.b_open_id = b_open_id;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	
}
