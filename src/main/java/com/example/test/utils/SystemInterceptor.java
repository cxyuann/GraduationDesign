package com.example.test.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author:	cxy
 * @version: 创建时间：2023年7月26日 下午3:33:46 
 * @Description:
 */
@Component
public class SystemInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("【"+request.getMethod()+"】IP:"+ request.getRemoteAddr()+",Path=" + request.getRequestURI()+"");
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			String values = request.getParameter(name);
			sb.append(","+name+":"+values);
		}
		System.out.println(sb.toString());
		if ((request.getRequestURI()).contains("/vue/login")) {
			return true;
		}else if((request.getRequestURI()).contains("/vue")) {
			
			String token = request.getHeader("token");
			/*
			 * if(LoginUtil.checkTime(token)) { return false; }
			 */
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	

}
