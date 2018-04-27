package com.lechuang.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;



public class AstrologUtil {

	/**
	 * 
	 * 
	 * @param url
	 * @return
	 * 根
据url
获取到
页面返回
的数据
	111111
 */
	
	public String getURLValue(String url) {

		// 创建client连接

		HttpClient client = new HttpClient();

		// 创建method对象

		HttpMethod method = new GetMethod(url);

		try {

		client.executeMethod(method);

		// 返回网址里面的内容

		return method.getResponseBodyAsString();

		} catch (Exception e) {

		// 打印错误日志

		e.printStackTrace();

		} finally {

		// 释放连接

		method.releaseConnection();

		}

		return null;

		}
	/**
	 * 
	 * @return
	 * 获取到算法数据    返回一个 数组
	 * 
	 */
	public String[] getAri(String year,String mon,String day,String hour,String min) {
		
		String[] astr = new String[7];
		
		//一级目录文件
		String str = 	this.getURLValue("http://www.freehoro.net/Astrolog32_GB/StarParameters.php?Sex=F&Year="+year+"&Month="+mon+"&Day="+day+"&Hour="+hour+"&Minute="+min+"&Place1=BeiJing&Place2=116%3A28E%2C39%3A55N&PlaceName=%E5%8C%97%E4%BA%AC&EastWest=E&LongitudeDegree=116&LongitudeMinute=28&SouthNorth=N&LatitudeDegree=39&LatitudeMinute=55&BTZ=8&LTZ=8&System=0");
			
		//获取到开始文件
		
		//System.out.println(str.indexOf("document.location.href='"));    473
		
		int begin = str.indexOf("document.location.href='");
		//获取到结束文件
		//System.out.println(str.indexOf("'+iScreenWidth;"));          61411
		int end = str.indexOf("'+iScreenWidth;");
		//截取文件                得到的路径
	    String url1 = 	"http://www.freehoro.net/Astrolog32_GB/"+str.substring(begin+26, end-8)+"&CNT=1920";
	    //根据一级目录文件查找二级目录文件
	    String str2 = 	this.getURLValue(url1);
	    int begin1 = str2.indexOf("提供出生时，各星曜落于十二星座的解析。");//5574  46   5620
	    
	    int end1 =  str2.indexOf("...详细内容");//5753   2    5751
	   // ./NatalSigns/NatalSigns.php?NUrl=&CNT=1920&Info=MTk4OCw0LDIzLDE4LDIsRiwwLDgsMCw4LDA&Place=MTE2OjI4OkUsMzk6NTU6Tg&PlaceName=5YyX5Lqs
	    //得到二级路径
	    String url2 = "http://www.freehoro.net/Astrolog32_GB/"+str2.substring(begin1+48, end1-2);
	    
	   //根据二级目录查找三级目录文件
	    
	    String str3 = 	this.getURLValue(url2);
	    int begin2 = str3.indexOf("太阳");
	    //System.out.println(str2.substring(5620,5751));   
	    //截取有关太阳的数   让要查找的结果成为第一个
	   String str4 = str3.substring(begin2+1000);
	   /**
	    * 
	    * 太阳位置结果
	    */
	   
	   
	   //查到太阳的下标;     
	 int begin3 =  str4.indexOf("太阳");   //703
	  
	 //求的太阳的位置
	  String str5 =   str4.substring(begin3);
	String sun =  str5.substring(0, str5.indexOf("<"));
	   
	   /**
	    * 
	    * 月亮位置结果
	    */
	   
	   
	   //查到月亮的下标;     
	 int begin4 =  str4.indexOf("月亮");   //703
	  
	 //求的月亮的位置
	  String str6 =   str4.substring(begin4);
	  String moon = str6.substring(0, str5.indexOf("<"));
	   
	   
	   /**
	    * 
	    * 水星位置结果
	    */
	   
	   
	   //查到水星的下标;     
	 int begin5 =  str4.indexOf("水星");   //703
	  
	 //求的水星的位置
	  String str7 =   str4.substring(begin5);
	  String merc =   str7.substring(0, str5.indexOf("<"));
	   
	   
	   
	   /**
	    * 
	    * 金星位置结果
	    */
	   
	   
	   //查到金星的下标;     
	 int begin6 =  str4.indexOf("金星");   //703
	  
	 //求的金星的位置
	  String str8 =   str4.substring(begin6);
	  String venu =    str8.substring(0, str5.indexOf("<"));
	   
	   
	   
	   
	   
	   /**
	    * 
	    * 火星位置结果
	    */
	   
	   
	   //查到火星的下标;     
	 int begin7 =  str4.indexOf("火星");   //703
	  
	 //求的火星的位置
	  String str9 =   str4.substring(begin7);
	 String   mars = str9.substring(0, str5.indexOf("<"));
	   
	   
	   
	   /**      
	    * 
	    * 木星位置结果
	    */
	   
	   
	   //查到木星的下标;     
	 int begin8 =  str4.indexOf("木星");   //703
	  
	 //求的木星的位置
	  String str10 =   str4.substring(begin8);
	String jupi = str10.substring(0, str5.indexOf("<"));
	   
	   /**
	    *              
	    * 土星位置结果
	    */
	   
	   
	   //查到土星的下标;     
	 int begin9 =  str4.indexOf("土星");   //703
	  
	 //求的土星的位置
	  String str11 =   str4.substring(begin9);
	  String satu = str11.substring(0, str5.indexOf("<"));
	   
	   
	   
	   
	   /**
	    * 七个结果                                    sun  moon merc venu mars jupi   satu
	    * 
	    * 
	    * 十二星座对应的英语  
	    * 
	    * 摩羯座     Capricorn 
	    * 水瓶座     Aquarius
	    * 双鱼座     Pisces
	    * 白羊座     Aries
	    * 金牛座     Taurus
	    * 双子座     Gemini
	    * 巨蟹座     Cancer
	    * 狮子座     Leo
	    * 处女座     Virgo
	    * 天秤座     Libra
	    * 天蝎座     Scorpio
	    * 射手座    Sagittarius
	    * 
	    */
	   String[] twelveArray  = {"摩羯","Cap","水瓶","Aqu","双鱼","Pis","白羊","Ari","金牛","Tau","双子","Gem","巨蟹","Can","狮子","Leo","处女","Vir","天秤","Lib","天蝎","Sco","射手","Sag"};
	   
	   /**太阳
	    * 
	    */
	  //System.out.println(sun);
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (sun.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  sun.substring(sun.indexOf("°")+1,sun.length()-1);
		   String enddeg =    sun.substring(sun.indexOf("°")-2,sun.indexOf("°"));
		   
		String   sun1 = firstdeg+ twelveArray[i+1] +enddeg;
		   System.out.println("Sun              "+sun1);
		   astr[0]="Sun              "+sun1;
		   }
		   
		   
	}
	   
	   
	   //System.out.println(moon);
	   /**月亮
	    * 
	    */
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (moon.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  moon.substring(moon.indexOf("°")+1,moon.length()-1);
		   String enddeg =    moon.substring(moon.indexOf("°")-2,moon.indexOf("°"));
		   
		String   moon1 = firstdeg+ twelveArray[i+1] +enddeg;
		  System.out.println("Moon             "+moon1);
		  astr[1]="Moon             "+moon1;
		   }
		   
		   
	}
	   
	   
	   
	   
	   /**水星
	    * 
	    */
	  // System.out.println(merc);
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (merc.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  merc.substring(merc.indexOf("°")+1,merc.length()-1);
		   String enddeg =    merc.substring(merc.indexOf("°")-2,merc.indexOf("°"));
		   
		String   merc1 = firstdeg+ twelveArray[i+1] +enddeg;
		   System.out.println("Mercury          "+merc1);
		   astr[2]="Mercury          "+merc1;
		   }
		   
		   
	}
	   
	   
	   
	   /**金星
	    * 
	    */
	 //  System.out.println(venu);
	   
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (venu.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  venu.substring(venu.indexOf("°")+1,venu.length()-1);
		   String enddeg =    venu.substring(venu.indexOf("°")-2,venu.indexOf("°"));
		   
		String   venu1 = firstdeg+ twelveArray[i+1] +enddeg;
		   System.out.println("Venus            "+venu1);
		   astr[3]=  "Venus            "+venu1  ;
		   }
		   
		   
	}
	   
	   
	   
	   /**火星
	    * 
	    */
	   //System.out.println(mars);
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (mars.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  mars.substring(mars.indexOf("°")+1,mars.length()-1);
		   String enddeg =    mars.substring(mars.indexOf(
				   "°")-2,mars.indexOf("°"));
		   
		String   mars1 = firstdeg+ twelveArray[i+1] +enddeg;
		   System.out.println("Mars             "+mars1);
		   astr[4]= "Mars             "+mars1   ;
		   }
		   
		   
	}
	   
	   
	   
	  
	   /**木星
	    * 
	    */
	//   System.out.println(jupi);
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (jupi.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  sun.substring(jupi.indexOf("°")+1,jupi.length()-1);
		   String enddeg =    sun.substring(jupi.indexOf("°")-2,jupi.indexOf("°"));
		   
		String   jupi1 = firstdeg+ twelveArray[i+1] +enddeg;
		   System.out.println("Jupiter          "+jupi1);
		   astr[5]= "Jupiter          "+jupi1   ;
		   }
		   
		   
	}
	   /**土星
	    * 
	    */
	  
	 //  System.out.println(satu);
	   for (int i = 0; i < twelveArray.length; i++) {

		   if (satu.substring(9, 11).equals(twelveArray[i])) {
			//System.out.println(i+1);
		    String firstdeg =  satu.substring(satu.indexOf("°")+1,satu.length()-1);
		   String enddeg =    satu.substring(satu.indexOf("°")-2,satu.indexOf("°"));
		   
		String   satu1 = firstdeg+ twelveArray[i+1] +enddeg;
		   System.out.println("Saturn           "+satu1);
		   astr[6]="Saturn           "+satu1    ;
		   }	   
	}
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
