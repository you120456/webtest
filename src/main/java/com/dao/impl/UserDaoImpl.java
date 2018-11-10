package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.UserDAO;
import com.entity.UserInfo;
import com.sys.utils.DBUtils;

/**
 * 用户信息管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public class UserDaoImpl implements UserDAO {

	public boolean add(UserInfo user) {
		String sql = "insert  into user_info(role_id,user_number,user_pw,"
				+ "user_name,user_sex,user_age,user_address,user_birthday,user_phone,user_mark) "
				+ "" + " values(?,?,?,?,?,?,?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(user.getRoleId());
		list.add(user.getUserNumber());
		list.add(user.getUserPw());
		list.add(user.getUserName());
		list.add(user.getUserSex());
		list.add(user.getUserAge());
		list.add(user.getUserAddress());
		list.add(user.getUserBirthday());
		list.add(user.getUserPhone());
		list.add(user.getUserMark());

		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

	public boolean update(UserInfo user) {
		String sql = "update user_info  set role_id=?,user_number=?,user_pw=?,"
				+ "user_name=?,user_sex=?,user_age=?,user_address=?,user_birthday=?,user_phone=?,user_mark=?  where user_id=?";
		List<Object> list = new ArrayList<Object>();
		list.add(user.getRoleId());
		list.add(user.getUserNumber());
		list.add(user.getUserPw());
		list.add(user.getUserName());
		list.add(user.getUserSex());
		list.add(user.getUserAge());
		list.add(user.getUserAddress());
		list.add(user.getUserBirthday());
		list.add(user.getUserPhone());
		list.add(user.getUserMark());
		list.add(user.getUserId());

		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

	/**
	 * 查询用户信息
	 * 
	 * @param info
	 *            用户信息
	 * @return
	 */
	public List<UserInfo> getList(String sql, Object[] params) {
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
			List<UserInfo> list = new ArrayList<UserInfo>();
			while (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserNumber(res.getString("user_number"));
				user.setUserPw(res.getString("user_pw"));
				user.setRoleId(res.getInt("role_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserSex(res.getString("user_sex"));
				user.setUserAge(res.getInt("user_age"));
				user.setUserBirthday(res.getTimestamp("user_birthday"));
				user.setUserAddress(res.getString("user_address"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserMark(res.getString("user_mark"));
				user.setRoleName(res.getString("role_name"));

				list.add(user);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pre, res);
		}

		return null;
	}

	public List<Map> getCount() {

		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;

		try {
			String sql = "SELECT b.role_name,COUNT(b.role_name) total FROM user_info a,role_info b"
					+ " WHERE a.role_id = b.role_id AND a.user_mark='1' AND b.role_mark='1'"
					+ "  GROUP BY b.role_name";
			con = DBUtils.getConnection();
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			List<Map> list = new ArrayList<Map>();
			while (res.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("role_name", res.getObject("role_name"));
				map.put("total", res.getObject("total"));

				list.add(map);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pre, res);
		}
		
		return null;
	}
}
