package com.example.test.utils;


/**
 * @author:	cxy
 * @version: 创建时间：2023年9月18日 上午9:33:28
 * @Description:
 */
public enum ResultCode {
	ROLE_UPDATE_IS_SUCCESS(0,"角色修改成功!!!"),
	ROLE_SELECT_IS_SUCCESS(0,"角色查询成功!!!"),
	ROLE_INSERT_IS_SUCCESS(0,"角色添加成功!!!"),
	ROLE_DELETE_IS_SUCCESS(0,"角色删除成功!!!"),
	DELETE_IS_SUCCESS(0,"删除成功!!!"),
	INSERT_IS_SUCCESS(0,"添加成功!!!"),
	UPDATE_IS_SUCCESS(0,"修改成功!!!"),
	USER_IS_ERROR(-1,"用户名或密码错误"),
	USERNAME_IS_NULL(-1,"用户名不能为空"),
	PASSWORD_IS_NULL(-1,"密码不能为空"),
	SUCCESS(0,"成功"),
	ERROR(-1,"失败"),
	INFOR(1,"提示");
	
	private Integer code;
	private String message;
	private ResultCode(Integer code,String message){
		this.code =code;
		this.message = message;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public String getMessage() {
		return this.message;
	}
}
