package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.RoleMenuDAO;
import com.entity.MenuInfo;
import com.entity.RoleMenu;
import com.sys.utils.DBUtils;

/**
 * 菜单角色关系管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public class RoleMenuDaoImpl implements RoleMenuDAO {

	public boolean add(List<RoleMenu> list) {
		Connection con = null;
		PreparedStatement pre = null;
		PreparedStatement pre2 = null;
		try {
			String sql = "insert into role_menu (menu_id,role_id) values(?,?)";
			con = DBUtils.getConnection();
			// 关闭自动提交事物
			con.setAutoCommit(false);
			
			//先删除已经存在的
			String sql2 = "delete from role_menu where role_id=?";
			pre2 = con.prepareStatement(sql2);
			pre2.setInt(1, list.get(0).getRoleId());
			pre2.executeUpdate();
			
			for (RoleMenu rm : list) {
				pre = con.prepareStatement(sql);
				pre.setInt(1, rm.getMenuId());
				pre.setInt(2, rm.getRoleId());
				// 执行
				pre.executeUpdate();
			}

			con.commit();
			return true;

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			DBUtils.close(null, pre2);
			DBUtils.close(con, pre);
		}

		return false;

	}
	
	/**
	 * 查询菜单信息
	 *           
	 * @return
	 */
	public List<RoleMenu> getList(String sql, Object[] params) {
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
			List<RoleMenu> list = new ArrayList<RoleMenu>();
			while (res.next()) {
				RoleMenu rm = new RoleMenu();
				rm.setRoleMenuId(res.getInt("role_menu_id"));
				rm.setRoleId(res.getInt("role_id"));
				rm.setMenuId(res.getInt("menu_id"));
				
				
				list.add(rm);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(con, pre, res);
		}

		return null;
	}
	
	/**
	 * 根据角色编号查询所属菜单信息
	 * 
	 * @param info
	 *           
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer roleId) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;

		try {
			String sql = "SELECT *  FROM menu_info WHERE menu_id IN (SELECT menu_id FROM role_menu WHERE role_id=?) and menu_mark=1 ";// and men_menu_id is not null ";
			con = DBUtils.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, roleId);
		

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
		}finally{
			DBUtils.close(con, pre, res);
		}

		return null;
	}

}
