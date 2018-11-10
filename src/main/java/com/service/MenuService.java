package com.service;


import java.util.List;
import com.entity.MenuInfo;


/**
 * 菜单管理的service
 * 
 * @author zhangjinyou
 * 
 */
public interface MenuService {

	
	/**
	 * 查询菜单信息
	 * 
	 * @param info
	 * @return
	 */
	public List<MenuInfo> getList(MenuInfo info);

	/**
	 * 根据条件查询菜单信息
	 * 
	 * @param info
	 * @return
	 */
	public MenuInfo getMenuInfo(MenuInfo info);
	public boolean update(MenuInfo info);
	public boolean add(MenuInfo info);
	public boolean delete(MenuInfo info) ;
}
