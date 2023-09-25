package com.example.test.utils;

import lombok.Data;

/**
 * @author:	cxy
 * @version: 创建时间：2023年7月6日 上午9:24:31 
 * @Description:
 */
@Data
public class ResultEntity<T> {
	public static <T>ResultEntity<T> infor(ResultCode rc, T data,Integer total) {
		return new ResultEntity<T>(rc,data,total);
	}
	public static <T>ResultEntity<T> infor(ResultCode rc, T data) {
		return new ResultEntity<T>(rc,data);
	}
	public static <T>ResultEntity<T> infor(ResultCode rc) {
		return new ResultEntity<T>(rc);
	}
	private ResultEntity(ResultCode rc) {
		this.code = rc.getCode();
		this.msg = rc.getMessage();
	}
	private ResultEntity(Integer code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private ResultEntity(ResultCode rc,T data) {
		this.code = rc.getCode();
		this.msg = rc.getMessage();
		this.data=data;
	}
	
	private ResultEntity(ResultCode rc, T data, Integer total) {
		this.code = rc.getCode();
		this.msg = rc.getMessage();
		this.data=data;
		this.total=total;
	}

	private Integer code;
	private String msg;
	private Object data;
	private Integer total;
}
