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

public class UserQueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserQueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 查询条件
		String type = request.getParameter("type");
		String keywords = request.getParameter("keywords");
		UserInfo user = null;
		if (type != null && !type.equals("")) {
			user = new UserInfo();

			if ("userName".equals(type)) {
				user.setUserName(keywords);
			}

			if ("userNumber".equals(type)) {
				user.setUserNumber(keywords);
			}
		}

		// 业务逻辑
		UserService service = new UserServiceImpl();
		List<UserInfo> list = service.getList(user);

		request.setAttribute("list", list);
		request.setAttribute("type", type);
		request.setAttribute("keywords", keywords);

		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_list.jsp")
				.forward(request, response);

	}


}
