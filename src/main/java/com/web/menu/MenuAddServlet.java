package com.web.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.MenuInfo;
import com.service.MenuService;
import com.service.impl.MenuServiceImpl;
import com.sys.utils.Mark;
import com.sys.utils.RequestBeanUtils;

public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取页面数据 自动存放发到UserInfo对象
		MenuInfo menuinfo = RequestBeanUtils.requestToBean(request,
				MenuInfo.class);
		
		request.setAttribute("menu", menuinfo);
		
		
		// 菜单管理的业务逻辑
		MenuService service = new MenuServiceImpl();
		List<MenuInfo> list = service.getList(null);
		request.setAttribute("list", list);

		request.getRequestDispatcher(Mark.URL_SYSTEM_MENU+"menu_add.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取页面数据 自动存放发到UserInfo对象
		MenuInfo menuinfo = RequestBeanUtils.requestToBean(request,
				MenuInfo.class);
		
		//菜单信息管理的业务逻辑类
		MenuService service = new MenuServiceImpl();
		
		boolean mark =  service.add(menuinfo);
		if(mark){
			request.setAttribute(Mark.ERROR_INFO,"菜单信息添加成功！");
		}else{
			request.setAttribute(Mark.ERROR_INFO,"菜单信息添加失败！");
		}
		
		request.getRequestDispatcher(Mark.URL_SYSTEM_MENU + "menu_info.jsp")
		.forward(request, response);
	}

}
