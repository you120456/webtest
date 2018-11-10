package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.UserInfo;
/**
 * 用户信息管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public interface UserDAO {
	
	/**
	 * 添加用户信息
	 * 
	 * @param info
	 * @return boolean
	 */
	public boolean add(UserInfo user);
	/**
	 * 更新用户信息
	 * 
	 * @param info
	 * @return  boolean
	 */
	public boolean update(UserInfo user);

	/**
	 * 查询用户信息
	 * 
	 * @param info
	 * @return list<UserInfo>
	 */
	public List<UserInfo> getList(String sql, Object[] params);

	/**
	 * 查询用户信息
	 * 
	 * @param info
	 * @return list<UserInfo>
	 */
	public List<Map> getCount();
}
