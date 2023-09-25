package com.example.test.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author cxy
 * @version 创建时间：2023年9月18日 上午11:06:57
 * 
 * @Description:存放常量数据，项目相关的配置数据
 */
@Component
public class ConfigConstants {
	public static String PASSWORD;

	@Value("${config.password}")
	public void setPassword(String password) {
		ConfigConstants.PASSWORD = password;
	}
}
