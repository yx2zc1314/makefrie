package com.lechuang.bean;

public class Invited {
	private String i_open_id;//邀请人ID
	private String b_open_id;//被邀请人ID
	private String u_name;//用户微信号
	private String u_l_name;//用户昵称
	private double distance;//距离
	private int suitability;//匹配度
	private String sex;//性别
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
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_l_name() {
		return u_l_name;
	}
	public void setU_l_name(String u_l_name) {
		this.u_l_name = u_l_name;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getSuitability() {
		return suitability;
	}
	public void setSuitability(int suitability) {
		this.suitability = suitability;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
