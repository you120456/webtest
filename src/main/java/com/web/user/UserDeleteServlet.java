package com.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserInfo;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.sys.utils.Mark;
import com.sys.utils.RequestBeanUtils;

public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面数据 自动存放发到UserInfo对象
		UserInfo user = RequestBeanUtils.requestToBean(request, UserInfo.class);
		
		//用户信息管理的业务逻辑类
		UserService service = new UserServiceImpl();
		
		boolean mark =  service.delete(user);
		if(mark){
			request.setAttribute(Mark.ERROR_INFO,"用户信息删除成功！");
		}else{
			request.setAttribute(Mark.ERROR_INFO,"用户信息删除失败！");
		}
		
		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_info.jsp")
		.forward(request, response);
	}


}
