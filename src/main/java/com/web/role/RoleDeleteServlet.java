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


public class RoleDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RoleInfo info = new RoleInfo();
		info.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		
		//业务逻辑类
		RoleService service = new RoleServiceImpl();
		
		boolean mark = service.delete(info);
		
		if(mark){
			request.setAttribute("info", "角色删除成功!");
		}else{
			request.setAttribute("info", "角色删除失败!");
		}
		
		request.getRequestDispatcher("/view/system/role/role_info.jsp").forward(request, response);
		
	}

}
