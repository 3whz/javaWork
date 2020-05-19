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
@WebServlet("/doAdminUpdate")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ���ֵ
		String account = request.getParameter("account");
		String adminPass = request.getParameter("adminPass");
		String id = request.getParameter("aid");
		int aid = Integer.parseInt(id);
		
		//ʵ����Admin�������
		Admin admin = new Admin();
		admin.setaId(aid);
		admin.setAccount(account);
		admin.setAdminpass(adminPass);
		
		//���ú�̨����
		AdminDao adminDao = new AdminDaoImpl();
		int rows = adminDao.updateAdmin(admin);
		
		//����Ӱ��������תҳ��
		if (rows > 0) {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
