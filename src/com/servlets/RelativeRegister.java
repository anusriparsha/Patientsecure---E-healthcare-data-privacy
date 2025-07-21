package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.PatientBean;
import com.beans.RelativeBean;
import com.dao.Dao;

/**
 * Servlet implementation class RelativeRegister
 */
@WebServlet("/RelativeRegister")
public class RelativeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelativeRegister() {
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
		String name = request.getParameter("RelativeName");
		String email = request.getParameter("RelativeID");
		String password = request.getParameter("RelativePassword");
		String mobile = request.getParameter("RelativeMobile");
		String country = request.getParameter("RelativeCountry");
		String city = request.getParameter("RelativeCity");
		String address = request.getParameter("RelativeAddress");
		
		RelativeBean ub = new RelativeBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setPassword(password);
		ub.setMobile(mobile);
		ub.setCountry(country);
		ub.setCity(city);
		ub.setAddress(address);
		System.out.println("Hiii");
		String sql = "insert into relatives values(?,?,?,?,?,?,?)";
		int i = Dao.relatives(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Relative Register Successfully...');");
			o.println("window.location='RelativeLogin.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='RelativeRegister.jsp';</script>");
		}
	}
}
