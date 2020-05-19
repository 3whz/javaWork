package com.systop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDao;
import com.systop.dao.impl.AdminDaoImpl;
import com.systop.entity.Admin;
@WebServlet("/Admin-add")
public class AdminAddServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("username");
//		String account = (String)request.getAttribute("account");
		String adminPass = request.getParameter("pass");
		
		Admin admin = new Admin();
		admin.setAccount(account);
		admin.setAdminpass(adminPass);
		
		AdminDao adminDao = new AdminDaoImpl();
		int rows = adminDao.saveAdmin(admin);
		if (rows > 0) {
			request.getRequestDispatcher("/success.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/error.html").forward(request, response);
		}
	}
}
