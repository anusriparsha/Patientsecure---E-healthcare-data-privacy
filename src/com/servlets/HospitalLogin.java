package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;

/**
 * Servlet implementation class HospitalLogin
 */
@WebServlet("/HospitalLogin")
public class HospitalLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String sql = "select * from hospitals where HospitalID='"+uid+"' and HospitalPassword='"+pwd+"'";
		boolean b = Dao.login(sql);
		HttpSession session = request.getSession();
		if(b == true){
			session.setAttribute("HospitalID", uid);
			sql = "select hospitalname from hospitals where HospitalID='"+uid+"'";
			String name = Dao.getName(sql);
			session.setAttribute("HospitalName", name);
			response.sendRedirect("HospitalHome.jsp");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='HospitalLogin.jsp';</script>");
		}
	}
}