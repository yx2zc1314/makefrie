package com.lechuang.controller;


import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.io.Writer;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.apache.xerces.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.lechuang.util.UrlUtil;

@Controller
public class WXAppletUserInfo {  
    private static Logger log = Logger.getLogger(WXAppletUserInfo.class);  
    
    public static String appid = "wx46fc2bfeeab5922b";
    public static String secret = "f20f41724073d4fe260eae80e135715d";
    public static String grant_type = "authorization_code";
    
    /** 
     * 获取微信小程序 session_key 和 openid 
     *  
     * @author zhy 
     * @param code 调用微信登陆返回的Code 
     * @return 
     */ 
    @RequestMapping("loginlogin")
	
    public void  getSessionKeyOropenid(String code,HttpServletResponse response){
    	
			System.out.println("////////////////--");
			//拿到前端传的CODE 
			
			String wxCode = code;
			System.out.println(code);
			//读取属性文件  
			//ResourceBundle resource = ResourceBundle.getBundle("weixin");   
			//请求的接口地址 https://api.weixin.qq.com/sns/jscode2session
			String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
			Map<String, String> requestUrlParam = new HashMap<String, String>();
			//开发者设置中的appId  
			requestUrlParam.put("appid", appid);
			//开发者设置中的appSecret  
			requestUrlParam.put("secret",secret);
			//小程序调用wx.login返回的code 
			requestUrlParam.put("js_code", wxCode);
			//默认参数
			requestUrlParam.put("grant_type",grant_type);
			//发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识  
			JSONObject jsonObject = JSON.parseObject(UrlUtil.sendPost(requestUrl, requestUrlParam));
			System.out.println("++++++++++++++++++++++"+jsonObject );
			try {
				Writer out = response.getWriter();
				out.write(jsonObject.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
     
      
    /** 
     * 解密用户敏感数据获取用户信息 
     *  
     * @author zhy 
     * @param sessionKey 数据进行加密签名的密钥 
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据 
     * @param iv 加密算法的初始向量 
     * @return 
     */  
    public static JSONObject getUserInfo(String encryptedData,String sessionKey,String iv){  
        // 被加密的数据  
        byte[] dataByte = Base64.decode(encryptedData);  
        // 加密秘钥  
        byte[] keyByte = Base64.decode(sessionKey);  
        // 偏移量  
        byte[] ivByte = Base64.decode(iv);  
        try {  
               // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要  
            int base = 16;  
            if (keyByte.length % base != 0) {  
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);  
                byte[] temp = new byte[groups * base];  
                Arrays.fill(temp, (byte) 0);  
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);  
                keyByte = temp;  
            }  
            // 初始化  
            Security.addProvider(new BouncyCastleProvider());  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");  
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");  
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");  
            parameters.init(new IvParameterSpec(ivByte));  
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化  
            byte[] resultByte = cipher.doFinal(dataByte);  
            if (null != resultByte && resultByte.length > 0) {  
                String result = new String(resultByte, "UTF-8");  
                return JSON.parseObject(result);  
            }  
        } catch (NoSuchAlgorithmException e) {  
            log.error(e.getMessage(), e);  
        } catch (NoSuchPaddingException e) {  
            log.error(e.getMessage(), e);  
        } catch (InvalidParameterSpecException e) {  
            log.error(e.getMessage(), e);  
        } catch (IllegalBlockSizeException e) {  
            log.error(e.getMessage(), e);  
        } catch (BadPaddingException e) {  
            log.error(e.getMessage(), e);  
        } catch (UnsupportedEncodingException e) {  
            log.error(e.getMessage(), e);  
        } catch (InvalidKeyException e) {  
            log.error(e.getMessage(), e);  
        } catch (InvalidAlgorithmParameterException e) {  
            log.error(e.getMessage(), e);  
        } catch (NoSuchProviderException e) {  
            log.error(e.getMessage(), e);  
        }  
        return null;  
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
   

}  




