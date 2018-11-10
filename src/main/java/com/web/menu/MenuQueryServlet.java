package com.web.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.MenuInfo;
import com.service.MenuService;
import com.service.impl.MenuServiceImpl;
import com.sys.utils.Mark;

public class MenuQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuQueryServlet() {
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

		// 菜单管理的业务逻辑
		MenuService service = new MenuServiceImpl();
		List<MenuInfo> list = service.getList(null);
		HttpSession session = request.getSession();
		System.out.println(list);
		
		session.setAttribute("menulist", list);

		request.getRequestDispatcher(Mark.URL_SYSTEM_MENU + "menu_main.jsp")
				.forward(request, response);

	}


}
