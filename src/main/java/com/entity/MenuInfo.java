package com.entity;

/**
 * 菜单信息管理的实体类
 * 
 * @author zhangjinyou
 * 
 */
public class MenuInfo {

	private Integer menuId;

	private Integer menMenuId;

	private String parentMenuName;

	private String menuName;

	private String menuUrl;

	private String menuRemarks;

	private String menuMark;

	//判断是否有子节点 有 1 无 0 
	private String isMark;

	public String getIsMark() {
		return isMark;
	}

	public void setIsMark(String isMark) {
		this.isMark = isMark;
	}

	public String getParentMenuName() {
		return parentMenuName;
	}

	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenMenuId() {
		return menMenuId;
	}

	public void setMenMenuId(Integer menMenuId) {
		this.menMenuId = menMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuRemarks() {
		return menuRemarks;
	}

	public void setMenuRemarks(String menuRemarks) {
		this.menuRemarks = menuRemarks;
	}

	public String getMenuMark() {
		return menuMark;
	}

	public void setMenuMark(String menuMark) {
		this.menuMark = menuMark;
	}

	@Override
	public String toString() {
		return "MenuInfo [menuId=" + menuId + ", menMenuId=" + menMenuId
				+ ", menuName=" + menuName + ", menuUrl=" + menuUrl
				+ ", menuRemarks=" + menuRemarks + ", menuMark=" + menuMark
				+ "]";
	}

}
