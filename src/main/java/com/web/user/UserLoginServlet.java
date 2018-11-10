package com.web.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.MenuInfo;
import com.entity.UserInfo;
import com.service.RoleMenuService;
import com.service.UserService;
import com.service.impl.RoleMenuServiceImpl;
import com.service.impl.UserServiceImpl;
import com.sys.utils.Mark;
import com.sys.utils.RequestBeanUtils;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();//获取session  
	        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");//从session中获取用户名  
            System.out.println(userInfo.getUserNumber()+"   "+userInfo.getUserPw());
	        session.invalidate(); //注销session  
	        String path = "/login.jsp";
	        request.getRequestDispatcher(path).forward(request, response);
	      
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);

		String path = "/login.jsp";

		if (user != null && user.getUserNumber() != null
				&& !"".equals(user.getUserNumber()) && user.getUserPw() != null
				&& !"".equals(user.getUserPw())) {

			UserService service = new UserServiceImpl();
			List<UserInfo> list = service.getList(user);
			if (list != null && list.size() == 1) {
				UserInfo userInfo = list.get(0);
				path = "/index.jsp";
				HttpSession session = request.getSession();
				session.setAttribute(Mark.LOGIN_SESSION_USER, userInfo);
				
				RoleMenuService rmservice = new RoleMenuServiceImpl();
				List<MenuInfo> menulist = rmservice.getMenuList(userInfo.getRoleId());
				System.out.println(menulist);
				
				session.setAttribute("loginmenulist", menulist);
				
				List<Map> listmap = service.getCount();
				
				session.setAttribute("listmap", listmap);
				
			} else {
				request.setAttribute(Mark.ERROR_INFO, "账号或密码错误!");
			}
		} else {
			request.setAttribute(Mark.ERROR_INFO, "账号或密码不能为空!");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}
}
