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
 * Servlet implementation class RelativeLogin
 */
@WebServlet("/RelativeLogin")
public class RelativeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelativeLogin() {
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
		String sql = "select * from relatives where email='"+uid+"' and password='"+pwd+"'";
		boolean b = Dao.login(sql);
		HttpSession session = request.getSession();
		if(b == true){
			session.setAttribute("email", uid);
			sql = "select name from relatives where email='"+uid+"'";
			String name = Dao.getName(sql);
			session.setAttribute("name", name);
			response.sendRedirect("RelativeHome.jsp");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/ Register');");
			o.println("window.location='RelativeLogin.jsp';</script>");
		}
	}
}
