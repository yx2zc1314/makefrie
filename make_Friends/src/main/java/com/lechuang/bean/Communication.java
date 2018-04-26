package com.lechuang.bean;

/**
 * 1.你要约别人的时候，别人也会要约你，版面要设置2个信息栏一个消息栏，被邀约栏，
 * A邀约B（发送消息："A想和你成为朋友！"），
 * B同意后把自己的昵称和微信号发送给A（发送消息："B（微信号：xyz）同意了你的邀约!"，当然微信号仅限B可见）。
 * 
 */
public class Communication {
	private String i_open_id;//邀请人ID
	private String data;//发送的信息
	private String b_open_id;//被邀请人ID
	private String status;//关系(默认0，同意1，拒绝2)
	private double distance;//距离
	private int suitability;//匹配度
	
	
	public String getI_open_id() {
		return i_open_id;
	}
	public void setI_open_id(String i_open_id) {
		this.i_open_id = i_open_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getB_open_id() {
		return b_open_id;
	}
	public void setB_open_id(String b_open_id) {
		this.b_open_id = b_open_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	
}
