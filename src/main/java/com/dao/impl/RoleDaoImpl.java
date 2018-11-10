package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.RoleDAO;
import com.entity.RoleInfo;
import com.sys.utils.DBUtils;

/**
 * 角色信息管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public class RoleDaoImpl implements RoleDAO {

	/**
	 * 添加角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean add(RoleInfo info) {

		String sql = "insert into role_info (role_name,role_desc,role_mark) values(?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(info.getRoleName());
		list.add(info.getRoleDesc());
		list.add(info.getRoleMark());

		return DBUtils.saveOrUpdate(sql, list.toArray());

	}

	/**
	 * 查询角色信息
	 * 
	 * @param info
	 *            角色信息
	 * @return
	 */
	public List<RoleInfo> getList(String sql, Object[] params) {
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
			List<RoleInfo> list = new ArrayList<RoleInfo>();
			while (res.next()) {
				RoleInfo role = new RoleInfo();
				role.setRoleId(res.getInt("role_id"));
				role.setRoleName(res.getString("role_name"));
				role.setRoleDesc(res.getString("role_desc"));
				role.setRoleMark(res.getString("role_mark"));
				list.add(role);
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
	 * 修改角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(RoleInfo info) {

		String sql = "update  role_info set role_name=?,role_desc=?,role_mark=? where role_id=? ";
		List<Object> list = new ArrayList<Object>();
		list.add(info.getRoleName());
		list.add(info.getRoleDesc());
		list.add(info.getRoleMark());
		list.add(info.getRoleId());
		
		return DBUtils.saveOrUpdate(sql, list.toArray());

	}

}
