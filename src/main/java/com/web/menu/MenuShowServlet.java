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

public class MenuShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuShowServlet() {
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
		// 获取页面数据 自动存放发到UserInfo对象
		MenuInfo menuinfo = RequestBeanUtils.requestToBean(request,
				MenuInfo.class);

		MenuService service = new MenuServiceImpl();

		MenuInfo menu = service.getMenuInfo(menuinfo);
		
		//查询父级菜单名称
		MenuInfo m1 = new MenuInfo();
		m1.setMenuId(menu.getMenMenuId());
		MenuInfo m2 = service.getMenuInfo(m1);
		menu.setParentMenuName(m2.getMenuName());
		
		//根据当前编号查询子节菜单
		MenuInfo m3 = new MenuInfo();
		m3.setMenMenuId(menu.getMenuId());
		List<MenuInfo> list = service.getList(m3);
		if(list!=null &&list.size()>0){
			menu.setIsMark("1");	
		}else{
			menu.setIsMark("0");	
		}
		

		request.setAttribute("menu", menu);

		request.getRequestDispatcher(Mark.URL_SYSTEM_MENU+"menu_show.jsp").forward(request,
				response);
	}

}
