package com.systop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systop.dao.AdminDao;
import com.systop.dao.impl.AdminDaoImpl;
import com.systop.entity.Admin;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip = request.getRemoteAddr();
		//获取用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDao admindao = new AdminDaoImpl();
		Admin admin = admindao.loginAdmin(username, password);
		
		if (admin == null) {
			//
			request.setAttribute("msg", "用户名密码错误");
			//response.sendRedirect("/hagen_dazs/login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
		
			HttpSession session = request.getSession();
		
			admin.setIp(ip);
//			session.setAttribute("ip", ip);
			session.setAttribute("userinfo", admin);
//			session.setAttribute("aaa", "bbb");
//			session.setAttribute("aaa", "111");
//			session.removeAttribute("aaa");
			//response.sendRedirect("/hagen_dazs/index.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
