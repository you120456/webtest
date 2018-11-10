package com.service;


import java.util.List;
import com.entity.MenuInfo;
import com.entity.RoleMenu;


/**
 * 权限变更的业务逻辑类
 * 
 * @author zhangjinyou
 * 
 */
public interface RoleMenuService {

	

	/**
	 * 权限变更
	 * 
	 * @param list
	 * @return
	 */
	public boolean powerChange(List<RoleMenu> list);

	public List<RoleMenu> getList(Integer roleId);
	
	public List<MenuInfo> getMenuList(Integer roleId) ;
	
}
