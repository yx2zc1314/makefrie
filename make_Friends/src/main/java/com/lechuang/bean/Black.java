package com.lechuang.bean;

/**
 * A拉黑了B，SQL（count）查询B被拉黑的次数，大于5次，直接封号
 * B不会再被A匹配到
 */
public class Black {
	private String l_open_id;//拉黑人的用户ID
	private String b_open_id;//被拉黑人的用户ID
	
	public String getL_open_id() {
		return l_open_id;
	}
	public void setL_open_id(String l_open_id) {
		this.l_open_id = l_open_id;
	}
	public String getB_open_id() {
		return b_open_id;
	}
	public void setB_open_id(String b_open_id) {
		this.b_open_id = b_open_id;
	}
	
	

}
