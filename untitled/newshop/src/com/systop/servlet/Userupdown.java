package com.systop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.UserDao;
import com.systop.dao.impl.UserDaoImpl;
import com.systop.entity.User;
@WebServlet("/userupdown")
public class Userupdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面的值
		String id = request.getParameter("u_id");
		int aid = Integer.parseInt(id);
		String u_statusa=request.getParameter("u_status");
		int u_status = Integer.parseInt(u_statusa);
		if(u_status==1) {
			u_status=0;
		}else {
			u_status=1;
		}
		//调用后台方法
		UserDao userDao = new UserDaoImpl();
		int rows = userDao.updownUserById(aid,u_status);
		PrintWriter out = response.getWriter();
		//根据影响行数跳转页面
		if (rows > 0) {
			//rows大于0表示数据库修改成功，所以提示1
			out.write("1");
		} else {
			//rows大于0表示数据库修改失败，所以提示0
			out.write("0");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
