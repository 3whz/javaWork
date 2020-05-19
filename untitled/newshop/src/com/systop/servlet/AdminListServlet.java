package com.systop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDao;
import com.systop.dao.impl.AdminDaoImpl;
import com.systop.entity.Admin;




@WebServlet("/admin-list")
public class AdminListServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao adminDao = new AdminDaoImpl();
		List<Admin> list = adminDao.findAdminAll();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/admin-list.jsp").forward(request, response);
	}
}
