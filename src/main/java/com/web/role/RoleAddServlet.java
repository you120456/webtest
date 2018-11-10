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



public class RoleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取页面数据
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		RoleInfo info = new RoleInfo();
		info.setRoleName(roleName);
		info.setRoleDesc(roleDesc);
		
		//业务逻辑类
		RoleService service = new RoleServiceImpl();
		boolean mark = service.add(info);
		
		if(mark){
			request.setAttribute("info", "角色添加成功!");
		}else{
			request.setAttribute("info", "角色添加失败!");
		}
		
		request.getRequestDispatcher("/view/system/role/role_info.jsp").forward(request, response);
		
	}
}
