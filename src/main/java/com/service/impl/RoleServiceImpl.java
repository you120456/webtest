package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.RoleDaoImpl;
import com.service.RoleService;
import com.entity.RoleInfo;
import com.dao.RoleDAO;
import com.sys.utils.Mark;

/**
 * 角色管理的业务逻辑接口
 * 
 * @author zhangjinyou
 * 
 */
public class RoleServiceImpl implements RoleService  {

	// 角色管理的数据访问对象
	private RoleDAO dao = new RoleDaoImpl();

	/**
	 * 添加角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean add(RoleInfo info) {

		if (info != null && info.getRoleName() != null) {
			info.setRoleMark(Mark.DB_YES);
			return dao.add(info);
		}

		return false;
	}

	/**
	 * 修改角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(RoleInfo info) {

		if (info != null && info.getRoleId() != null) {

			// 先查询 在修改
			RoleInfo prole = getRole(info.getRoleId());

			if (prole != null) {
				// 修改具体的字段
				prole.setRoleName(info.getRoleName());
				prole.setRoleDesc(info.getRoleDesc());
			}

			return dao.update(prole);
		}

		return false;
	}

	/**
	 * 删除角色信息 假删除
	 * 
	 * @param info
	 * @return
	 */
	public boolean delete(RoleInfo info) {

		if (info != null && info.getRoleId() != null) {

			// 先查询 在修改
			RoleInfo prole = getRole(info.getRoleId());

			if (prole != null) {
				// 修改具体的字段
				prole.setRoleMark(Mark.DB_NO);
			}

			return dao.update(prole);
		}

		return false;
	}

	/**
	 * 查询角色信息
	 * 
	 * @param info
	 *            查询条件
	 * @return
	 */
	public List<RoleInfo> getList(RoleInfo info) {

		StringBuffer sb = new StringBuffer(
				"select * from role_info where role_mark=? ");
		List<Object> list = new ArrayList<Object>();
		list.add(Mark.DB_YES);

		if (info != null) {
			if (info.getRoleName() != null && !info.getRoleName().equals("")) {
				sb.append("  and role_name like ? ");
				list.add("%" + info.getRoleName() + "%");

			}

		}

		sb.append(" order by role_id desc ");

		return dao.getList(sb.toString(), list.toArray());
	}

	public RoleInfo getRole(Integer roleId) {

		if (roleId != null) {
			StringBuffer sb = new StringBuffer(
					"select * from role_info where role_mark=?  and role_id = ?");
			List<Object> list = new ArrayList<Object>();
			list.add(Mark.DB_YES);
			list.add(roleId);

			List<RoleInfo> plist = dao.getList(sb.toString(), list.toArray());
			if (plist != null && plist.size() == 1) {

				return plist.get(0);
			}

		}

		return null;
	}

}
