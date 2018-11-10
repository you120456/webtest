package com.service;

import java.util.List;
import java.util.Map;
import com.entity.UserInfo;


/**
 * 用户信息管理的业务逻辑类
 * 
 * @author zhangjinyou
 * 
 */
public interface UserService {


	/**
	 * 添加用户信息
	 * 
	 * @param user
	 *            添加的信息
	 * @return
	 */
	public boolean add(UserInfo user) ;

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 *            信息
	 * @return
	 */
	public boolean update(UserInfo user) ;

	/**
	 * 删除用户信息
	 * 
	 * @param user
	 *            信息
	 * @return
	 */
	public boolean delete(UserInfo user) ;

	/**
	 * 查询用户信息
	 * 
	 * @param user
	 *            查询条件
	 * @return
	 */
	public List<UserInfo> getList(UserInfo user);

	public List<Map> getCount() ;
}
