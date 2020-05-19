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

/**
 * Servlet implementation class AdminUpdateServlet
 */
@WebServlet("/admin-p-update")
public class PrepareAdminUpdateServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareAdminUpdateServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面的值
		String id = request.getParameter("id");
		int aid = Integer.parseInt(id);
		
		//调用后台方法
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.findAdminById(aid);
		
		//根据影响行数跳转页面
		if (admin != null) {
			request.setAttribute("admin", admin);
		}
		request.getRequestDispatcher("/admin-update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
