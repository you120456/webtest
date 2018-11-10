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
import com.sys.utils.Mark;
import com.sys.utils.RequestBeanUtils;

public class UserShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);

		UserService service = new UserServiceImpl();
		List<UserInfo> list = service.getList(user);

		if (list != null && list.size() == 1) {
			request.setAttribute("user", list.get(0));
		}

		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_show.jsp")
				.forward(request, response);

	}
}
