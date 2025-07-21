package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.PatientBean;
import com.dao.Dao;

/**
 * Servlet implementation class PateintRegister
 */
@WebServlet("/PateintRegister")
public class PateintRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PateintRegister() {
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
		String name = request.getParameter("PatientName");
		String email = request.getParameter("PatientID");
		String password = request.getParameter("PatientPassword");
		String cpassword = request.getParameter("PatientCPassword");
		String mobile = request.getParameter("PatientMobile");
		String country = request.getParameter("PatientCountry");
		String city = request.getParameter("PatientCity");
		String address = request.getParameter("PatientAddress");
		String pincode = request.getParameter("PatientPincode");
		String dm = request.getParameter("vm");
		PatientBean ub = new PatientBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setPassword(password);
		ub.setCpassword(cpassword);
		ub.setMobile(mobile);
		ub.setCountry(country);
		ub.setCity(city);
		ub.setAddress(address);
		ub.setPincode(pincode);
		ub.setDm(dm);
		System.out.println("Hiii");
		String sql = "insert into patients values(?,?,?,?,?,?,?,?,?,?,?)";
		int i = Dao.patients(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Patient Register Successfully...');");
			o.println("window.location='PatientLogin.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='PatientRegister.jsp';</script>");
		}
	}

}
