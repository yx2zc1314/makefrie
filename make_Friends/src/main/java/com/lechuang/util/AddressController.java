package com.lechuang.util;
public class AddressController {

	/**
	 * 待开发，再此省略1w行    lat纬度
	 * latitude:34.34127纬度
     * longitude:108.93984
     * 1:经   108.93984   34.34127
     * 98.255  25.55 
	 */
    private static double EARTH_RADIUS = 6378.137;    
    
    private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }    
    
    /**   
     * 通过经纬度获取距离(单位：米)   
     * @param lat1   
     * @param lng1   
     * @param lat2   
     * @param lng2   
     * @return   
     */ 
  
    public static double getDistance(String lng1,String lat1,String lng2,String lat2) {    
        double radLat1 = rad(Double.parseDouble(lat1));    
        double radLat2 = rad(Double.parseDouble(lat2));    
        double a = radLat1 - radLat2;    
        double b = rad(Double.parseDouble(lng1)) - rad(Double.parseDouble(lng2));    
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
                + Math.cos(radLat1) * Math.cos(radLat2)    
                * Math.pow(Math.sin(b / 2), 2)));    
        s = s * EARTH_RADIUS;    
        s = Math.round(s * 10000d) / 10000d;    
        s = s*1000;    
        System.out.println(s);
		return s;    
    } 
	
	
}

