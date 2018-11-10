package com.web.role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.RoleInfo;
import com.service.RoleService;
import com.service.impl.RoleServiceImpl;



public class RoleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取角色编号
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));

		RoleService service = new RoleServiceImpl();
		// 根据编号查询角色信息
		RoleInfo role = service.getRole(roleId);

		request.setAttribute("role", role);

		request.getRequestDispatcher("/view/system/role/role_update.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取页面数据
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		RoleInfo info = new RoleInfo();
		info.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		info.setRoleName(roleName);
		info.setRoleDesc(roleDesc);
		
		//业务逻辑类
		RoleService service = new RoleServiceImpl();
		boolean mark = service.update(info);
		
		if(mark){
			request.setAttribute("info", "角色修改成功!");
		}else{
			request.setAttribute("info", "角色修改失败!");
		}
		
		request.getRequestDispatcher("/view/system/role/role_info.jsp").forward(request, response);
		
		
		
	}

}
