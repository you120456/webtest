package com.sys.utils;

/**
 * 标示接口
 * 
 * @author zhangjinyou
 * 
 */
public interface Mark {

	// 有效
	public static final String DB_YES = "1";

	// 无效
	public static final String DB_NO = "0";

	// 用户信息管理的URL地址前缀
	public static final String URL_SYSTEM_USER = "/view/system/user/";
	public static final String URL_SYSTEM_MENU = "/view/system/menu/";
	public static final String URL_SYSTEM_POWER_CHANGE = "/view/system/powerchange/";
	//提示消息
	public static final String ERROR_INFO = "info";
	
	public static final String LOGIN_SESSION_USER = "userInfo";
}
