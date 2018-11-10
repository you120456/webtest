package com.web.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserInfo;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.sys.utils.RequestBeanUtils;

public class UserCheckSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCheckSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);
		System.out.println(user);
		// /用户信息管理的业务逻辑
		UserService service = new UserServiceImpl();

		List<UserInfo> list = service.getList(user);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (list != null && list.size() == 1) {
			out.print("true");
		} else {
			out.print("false");
		}

		out.flush();
		out.close();
	}


}
