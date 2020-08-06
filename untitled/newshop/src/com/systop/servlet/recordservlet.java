package com.systop.servlet;

import com.systop.dao.RecordDao;
import com.systop.dao.impl.RecordDaoImpl;
import com.systop.entity.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/recordservlet")
public class recordservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_name=request.getParameter("userinfo.getAccount");
        RecordDao record= new RecordDaoImpl();
        List<Record> list= record.liRecord(u_name);
        int manay=record.manay(u_name);
        request.setAttribute("r_list", list);
        request.setAttribute("r_manay", manay);
        request.getRequestDispatcher("/record-list.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
