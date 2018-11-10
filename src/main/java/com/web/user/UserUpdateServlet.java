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

public class UserUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);

		//用户的业务逻辑
		UserService service = new UserServiceImpl();
		List<UserInfo> ulist = service.getList(user);

		if (ulist != null && ulist.size() == 1) {
			request.setAttribute("user", ulist.get(0));
		}
		
		
		// 角色信息管理的业务逻辑处理类
		RoleService roleservice = new RoleServiceImpl();
		List<RoleInfo> list = roleservice.getList(null);

		request.setAttribute("list", list);

		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_update.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);
		
		//用户信息管理的业务逻辑类
		UserService service = new UserServiceImpl();
		
		boolean mark =  service.update(user);
		if(mark){
			request.setAttribute(Mark.ERROR_INFO,"用户信息修改成功！");
		}else{
			request.setAttribute(Mark.ERROR_INFO,"用户信息修改失败！");
		}
		
		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_info.jsp")
		.forward(request, response);
	}

}
