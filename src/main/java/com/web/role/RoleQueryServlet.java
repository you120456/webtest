package com.web.role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.RoleInfo;
import com.service.RoleService;
import com.service.impl.RoleServiceImpl;



public class RoleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleQueryServlet() {
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
		RoleService service = new RoleServiceImpl();
		
		//获取页面数据
		String roleName = request.getParameter("roleName");
		//String roleDesc = request.getParameter("roleDesc");
		RoleInfo info = new RoleInfo();
		info.setRoleName(roleName);
		//info.setRoleDesc(roleDesc);
		List<RoleInfo> list = service.getList(info);

		request.setAttribute("list", list);
		request.setAttribute("role", info);

		request.getRequestDispatcher("/view/system/role/role_list.jsp")
				.forward(request, response);
	}
}
