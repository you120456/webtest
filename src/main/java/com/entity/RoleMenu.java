package com.entity;

/**
 * 角色菜单关系类
 * @author zhangjinyou
 *
 */
public class RoleMenu {

	private Integer roleMenuId;
	
	private Integer menuId;
	
	private Integer roleId;

	public Integer getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(Integer roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
