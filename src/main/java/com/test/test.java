package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.entity.RoleInfo;
import com.service.RoleService;
import com.service.UserService;
import com.service.impl.RoleServiceImpl;
import com.service.impl.UserServiceImpl;
import com.sys.utils.DBUtils;

public class test {
	public static void main(String[] args) {
		RoleService roleService=new RoleServiceImpl();
		RoleInfo info=new RoleInfo();
		info.setRoleName("测试");
		info.setRoleDesc("测试");
		info.setRoleMark("2");
		roleService.add(info);
		
		roleService.getList(info);
		System.out.println(info);
	}



}
