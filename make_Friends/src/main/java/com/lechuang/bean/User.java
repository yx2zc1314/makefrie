package com.lechuang.bean;


/**
 * 1.出生日期，出生时间，用户的地址作为获取相对地心学数据
 * 2.用户的图像，昵称，职业，性别，出生日期，所在城市作为可见数据显示
 * 3.用相对地心学数据获取和推荐好友的匹配度
 * 4.用户的微信号用于被匹配同意后加微信好友聊天
 * 5.性别作为推荐好友的限制字段
 */
public class User {
	private String u_open_id;//用户id
	private String u_name;//用户微信号
	private String u_l_name;//用户昵称
	private String u_career;//职业
	private String sex;//性别
	private String u_date;//出生日期1999.05.06
	private String u_time;//出生12:30
	private String u_address;//用户地址
	private String latitude;//纬度
	private String longitude;//经度
	private String SYG;//相对地心的数据
	private String YKH;//相对地心的数据
	private String JDY;//相对地心的数据
	private String MDJ;//相对地心的数据
	private String SHH;//相对地心的数据
	private String HIY;//相对地心的数据
	private String TFI;//相对地心的数据
	private Double s;
	
	
	
	public Double getS() {
		return s;
	}
	public void setS(Double s) {
		this.s = s;
	}
	public String getU_open_id() {
		return u_open_id;
	}
	public void setU_open_id(String u_open_id) {
		this.u_open_id = u_open_id;
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
	public String getU_career() {
		return u_career;
	}
	public void setU_career(String u_career) {
		this.u_career = u_career;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getU_date() {
		return u_date;
	}
	public void setU_date(String u_date) {
		this.u_date = u_date;
	}
	public String getU_time() {
		return u_time;
	}
	public void setU_time(String u_time) {
		this.u_time = u_time;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getSYG() {
		return SYG;
	}
	public void setSYG(String sYG) {
		SYG = sYG;
	}
	public String getYKH() {
		return YKH;
	}
	public void setYKH(String yKH) {
		YKH = yKH;
	}
	public String getJDY() {
		return JDY;
	}
	public void setJDY(String jDY) {
		JDY = jDY;
	}
	public String getMDJ() {
		return MDJ;
	}
	public void setMDJ(String mDJ) {
		MDJ = mDJ;
	}
	public String getSHH() {
		return SHH;
	}
	public void setSHH(String sHH) {
		SHH = sHH;
	}
	public String getHIY() {
		return HIY;
	}
	public void setHIY(String hIY) {
		HIY = hIY;
	}
	public String getTFI() {
		return TFI;
	}
	public void setTFI(String tFI) {
		TFI = tFI;
	}


}
