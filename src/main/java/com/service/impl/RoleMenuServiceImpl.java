package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.RoleMenuDaoImpl;
import com.entity.MenuInfo;
import com.entity.RoleMenu;
import com.service.RoleMenuService;
import com.service.RoleService;
import com.dao.RoleMenuDAO;

/**
 * 权限变更的业务逻辑类
 * 
 * @author zhangjinyou
 * 
 */
public class RoleMenuServiceImpl implements RoleMenuService {

	RoleMenuDAO dao = new RoleMenuDaoImpl();

	/**
	 * 权限变更
	 * 
	 * @param list
	 * @return
	 */
	public boolean powerChange(List<RoleMenu> list) {

		if (list != null && list.size() > 0) {

			return dao.add(list);
		}

		return false;
	}

	public List<RoleMenu> getList(Integer roleId) {

		if (roleId != null ) {
			String sql = "select * from role_menu where role_id=?";
			List<Object> list = new ArrayList<Object>();
			list.add(roleId);
			
			return dao.getList(sql, list.toArray());
		}
		
		return null;
	}
	
	public List<MenuInfo> getMenuList(Integer roleId) {
		
		return dao.getMenuList(roleId);
	}
}
