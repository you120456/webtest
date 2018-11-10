package com.web.powerchange;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.MenuInfo;
import com.entity.RoleInfo;
import com.entity.RoleMenu;
import com.service.MenuService;
import com.service.RoleMenuService;
import com.service.RoleService;
import com.service.impl.MenuServiceImpl;
import com.service.impl.RoleMenuServiceImpl;
import com.service.impl.RoleServiceImpl;
import com.sys.utils.Mark;

public class PowerChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PowerChangeServlet() {
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

		// 菜单管理的业务逻辑
		MenuService menuservice = new MenuServiceImpl();
		List<MenuInfo> list = menuservice.getList(null);
		request.setAttribute("list", list);

		RoleMenuService rmservice = new RoleMenuServiceImpl();
		
		List<RoleMenu> rmlist = rmservice.getList(roleId);
		request.setAttribute("rmlist", rmlist);
		
		request.getRequestDispatcher(
				"/view/system/powerchange/power_change.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取角色编号
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		
		String[] menuIds = request.getParameterValues("menuId");

		//业务逻辑
		RoleMenuService service = new RoleMenuServiceImpl();
		
		if(menuIds!=null && menuIds.length>0){
			List<RoleMenu> list = new ArrayList<RoleMenu>();
			for(String menuId:menuIds){
				RoleMenu rm = new RoleMenu();
				rm.setMenuId(Integer.parseInt(menuId));
				rm.setRoleId(roleId);
				list.add(rm);
			}
			
			
			boolean mark = service.powerChange(list);
			if(mark){
				request.setAttribute(Mark.ERROR_INFO,"权限变更成功！");
			}else{
				request.setAttribute(Mark.ERROR_INFO,"权限变更失败！");
			}
			
		
			
		}
		
		request.getRequestDispatcher(Mark.URL_SYSTEM_POWER_CHANGE + "power_change_info.jsp")
		.forward(request, response);
		
	}
}
