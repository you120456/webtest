package com.web.user;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.RoleInfo;
import com.entity.UserInfo;
import com.service.RoleService;
import com.service.UserService;
import com.service.impl.RoleServiceImpl;
import com.service.impl.UserServiceImpl;
import com.sys.utils.Mark;
import com.sys.utils.RequestBeanUtils;

public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------查询角色信息-----------");

		// 角色信息管理的业务逻辑处理类
		RoleService service = new RoleServiceImpl();
		List<RoleInfo> list = service.getList(null);
		
		System.out.println(list);

		request.setAttribute("list", list);

		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_add.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);
		
		//用户信息管理的业务逻辑类
		UserService service = new UserServiceImpl();
		
		System.out.println(user);
		boolean mark =  service.add(user);
		if(mark){
			request.setAttribute(Mark.ERROR_INFO,"用户信息添加成功！");
		}else{
			request.setAttribute(Mark.ERROR_INFO,"用户信息添加失败！");
		}
		
		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_info.jsp")
		.forward(request, response);
	}
}
