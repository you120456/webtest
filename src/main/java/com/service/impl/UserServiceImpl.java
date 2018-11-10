package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dao.UserDAO;
import com.dao.impl.UserDaoImpl;
import com.entity.UserInfo;
import com.service.UserService;
import com.sys.utils.Mark;



/**
 * 用户信息管理的业务逻辑类
 * 
 * @author zhangjinyou
 * 
 */
public class UserServiceImpl implements UserService {

	private UserDAO dao = new UserDaoImpl();

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 *            添加的信息
	 * @return
	 */
	public boolean add(UserInfo user) {
		if (user != null && user.getUserNumber() != null
				&& user.getUserPw() != null) {
			user.setUserMark(Mark.DB_YES);

			return dao.add(user);
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 *            信息
	 * @return
	 */
	public boolean update(UserInfo user) {
		if (user != null && user.getUserId() != null) {

			// 查询条件
			UserInfo u1 = new UserInfo();
			u1.setUserId(user.getUserId());

			List<UserInfo> list = getList(u1);

			if (list != null && list.size() == 1) {
				UserInfo puser = list.get(0);

				if (puser != null) {

					puser.setUserPw(user.getUserPw());
					puser.setRoleId(user.getRoleId());
					puser.setUserName(user.getUserName());
					puser.setUserSex(user.getUserSex());
					puser.setUserAge(user.getUserAge());
					puser.setUserBirthday(user.getUserBirthday());
					puser.setUserAddress(user.getUserAddress());
					puser.setUserPhone(user.getUserPhone());

					return dao.update(puser);
				}

			}

		}
		return false;
	}

	/**
	 * 删除用户信息
	 * 
	 * @param user
	 *            信息
	 * @return
	 */
	public boolean delete(UserInfo user) {
		if (user != null && user.getUserId() != null) {

			List<UserInfo> list = getList(user);

			if (list != null && list.size() == 1) {
				UserInfo puser = list.get(0);

				if (puser != null) {

					puser.setUserMark(Mark.DB_NO);

					return dao.update(puser);
				}

			}

		}
		return false;
	}

	/**
	 * 查询用户信息
	 * 
	 * @param user
	 *            查询条件
	 * @return
	 */
	public List<UserInfo> getList(UserInfo user) {

		StringBuilder sql = new StringBuilder(
				" SELECT a.*,b.role_name FROM user_info a,role_info  b WHERE a.role_id=b.role_id AND  a.user_mark=?");
		List<Object> list = new ArrayList<Object>();
		list.add(Mark.DB_YES);

		if (user != null) {

			if (user.getUserId() != null && !user.getUserId().equals("")) {
				sql.append(" and a.user_id=?");
				list.add(user.getUserId());
			}

			if (user.getUserNumber() != null
					&& !user.getUserNumber().equals("")) {
				sql.append(" and a.user_number=?");
				list.add(user.getUserNumber());
			}

			if (user.getUserName() != null && !user.getUserName().equals("")) {
				sql.append(" and a.user_name like  ?  ");
				list.add("%" + user.getUserName() + "%");
			}

			if (user.getUserPw() != null && !user.getUserPw().equals("")) {
				sql.append(" and a.user_pw=? ");
				list.add(user.getUserPw());
			}

		}

		sql.append(" order by a.user_id desc");

		System.out.println(sql);
		return dao.getList(sql.toString(), list.toArray());
	}

	public List<Map> getCount() {
		return dao.getCount();
	}
}

