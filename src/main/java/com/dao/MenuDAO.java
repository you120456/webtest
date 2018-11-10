package com.dao;

import java.util.List;
import com.entity.MenuInfo;

/**
 * 菜单信息管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public interface MenuDAO {

	/**
	 * 根据条件查询菜单信息
	 * 
	 * @param sql
	 *            查询SQL
	 * @param params
	 *            查询条件
	 * @return
	 */
	public List<MenuInfo> getList(String sql, Object[] params) ;

	/**
	 * 添加菜单
	 * 
	 * @param info
	 * @return
	 * 
	 */
	public boolean add(MenuInfo info) ;
	/**
	 * 修改菜单信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(MenuInfo info) ;
}
