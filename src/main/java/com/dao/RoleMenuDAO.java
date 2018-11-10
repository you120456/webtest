package com.dao;

import java.util.List;
import com.entity.MenuInfo;
import com.entity.RoleMenu;



/**
 * 菜单角色关系管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public interface RoleMenuDAO {

	public boolean add(List<RoleMenu> list);
	
	/**
	 * 查询菜单信息
	 *           
	 * @return
	 */
	public List<RoleMenu> getList(String sql, Object[] params) ;
	
	/**
	 * 根据角色编号查询所属菜单信息
	 * 
	 * @param info
	 *           
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer roleId);

}
