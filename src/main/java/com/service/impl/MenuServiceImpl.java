package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.entity.MenuInfo;
import com.service.MenuService;
import com.dao.MenuDAO;
import com.dao.impl.MenuDaoImpl;
import com.sys.utils.Mark;

/**
 * 菜单管理的service
 * 
 * @author zhangjinyou
 * 
 */
public class MenuServiceImpl implements MenuService  {

	private MenuDAO dao = new MenuDaoImpl();

	/**
	 * 查询菜单信息
	 * 
	 * @param info
	 * @return
	 */
	public List<MenuInfo> getList(MenuInfo info) {

		StringBuilder sql = new StringBuilder(
				"select * from menu_info where menu_mark=? ");
		List<Object> list = new ArrayList<Object>();
		list.add(Mark.DB_YES);

		if (info != null) {

			if (info.getMenuId() != null && !"".equals(info.getMenuId())) {
				sql.append(" and menu_id=? ");
				list.add(info.getMenuId());
			}
			
			if (info.getMenMenuId() != null && !"".equals(info.getMenMenuId())) {
				sql.append(" and men_menu_id=? ");
				list.add(info.getMenMenuId());
			}

		}
System.out.println(sql);
		return dao.getList(sql.toString(), list.toArray());
	}

	/**
	 * 根据条件查询菜单信息
	 * 
	 * @param info
	 * @return
	 */
	public MenuInfo getMenuInfo(MenuInfo info) {
		List<MenuInfo> list = getList(info);
		if (list != null && list.size() == 1) {

			return list.get(0);
		}

		return null;

	}
	
	public boolean add(MenuInfo info){
		
		if(info!=null && info.getMenMenuId()!=null&&info.getMenuName()!=null){
			info.setMenuMark(Mark.DB_YES);
			return dao.add(info);
		}
		return false;
	}
	
	public boolean update(MenuInfo info) {
		if(info!=null && info.getMenuId()!=null){
			MenuInfo m = new MenuInfo();
			m.setMenuId(info.getMenuId());
			
			MenuInfo menu = getMenuInfo(m);
			if(menu!=null){
				menu.setMenMenuId(info.getMenMenuId());
				menu.setMenuName(info.getMenuName());
				menu.setMenuRemarks(info.getMenuRemarks());
				menu.setMenuUrl(info.getMenuUrl());
				
				return dao.update(menu);
				
			}
			
		}
		return false;
	}
	
	public boolean delete(MenuInfo info) {
		if(info!=null && info.getMenuId()!=null){
			MenuInfo m = new MenuInfo();
			m.setMenuId(info.getMenuId());
			
			MenuInfo menu = getMenuInfo(m);
			if(menu!=null){
				menu.setMenuMark(Mark.DB_NO);
				
				return dao.update(menu);
				
			}
			
		}
		return false;
	}
}
