package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.MenuDAO;
import com.entity.MenuInfo;
import com.sys.utils.DBUtils;

/**
 * 菜单信息管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public class MenuDaoImpl implements MenuDAO{

	/**
	 * 根据条件查询菜单信息
	 * 
	 * @param sql
	 *            查询SQL
	 * @param params
	 *            查询条件
	 * @return
	 */
	public List<MenuInfo> getList(String sql, Object[] params) {

		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;

		try {
			con = DBUtils.getConnection();
			pre = con.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {

					pre.setObject(i + 1, params[i]);
				}
			}

			res = pre.executeQuery();
			List<MenuInfo> list = new ArrayList<MenuInfo>();
			while (res.next()) {
				MenuInfo menu = new MenuInfo();
				menu.setMenuId(res.getInt("menu_id"));
				menu.setMenMenuId(res.getInt("men_menu_id"));
				menu.setMenuName(res.getString("menu_name"));
				menu.setMenuRemarks(res.getString("menu_remarks"));
				menu.setMenuUrl(res.getString("menu_url"));
				menu.setMenuMark(res.getString("menu_mark"));

				list.add(menu);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pre, res);
		}

		return null;

	}

	/**
	 * 添加菜单
	 * 
	 * @param info
	 * @return
	 * 
	 */
	public boolean add(MenuInfo info) {
		String sql = "insert into menu_info (men_menu_id,menu_name,menu_url,menu_remarks,menu_mark) values(?,?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(info.getMenMenuId());
		list.add(info.getMenuName());
		list.add(info.getMenuUrl());
		list.add(info.getMenuRemarks());
		list.add(info.getMenuMark());

		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

	/**
	 * 修改菜单信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(MenuInfo info) {
		String sql = "update menu_info set men_menu_id=?,menu_name=?,menu_url=?,menu_remarks=?,menu_mark=? where menu_id=? ";
		List<Object> list = new ArrayList<Object>();
		list.add(info.getMenMenuId());
		list.add(info.getMenuName());
		list.add(info.getMenuUrl());
		list.add(info.getMenuRemarks());
		list.add(info.getMenuMark());
		list.add(info.getMenuId());

		return DBUtils.saveOrUpdate(sql, list.toArray());
	}
}
