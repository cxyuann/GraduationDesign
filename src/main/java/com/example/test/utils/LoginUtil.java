package com.example.test.utils;

import java.util.Map;


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;

/**
 * @ClassName LoginUtil
 * @Description Json工具类
 */
public class LoginUtil {
	private static long time = 1000 * 60 * 60 * 24;		//有效期
	private static String signature ="cxy";		//签名
	
	
	/**
	 * @return the time
	 */
	public static long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public static void setTime(long time) {
		LoginUtil.time = time;
	}

	public static String createToken(Map<String, Object> map) {

		String token = JWTUtil.createToken(map, signature.getBytes());
		return token;
	}
	
	public static boolean checkToken(String token) {
		return JWTUtil.verify(token, signature.getBytes());
	}
	
	public static boolean checkTime(String token) {
		JWT jwt=JWTUtil.parseToken(token);
		Object time = jwt.getPayload("expire_time");
		return System.currentTimeMillis() > Long.parseLong(time.toString());
	}
}
