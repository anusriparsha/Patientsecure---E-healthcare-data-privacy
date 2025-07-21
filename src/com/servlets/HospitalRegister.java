package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.HospitalBean;
import com.beans.PatientBean;
import com.dao.Dao;

/**
 * Servlet implementation class HospitalRegister
 */
@WebServlet("/HospitalRegister")
public class HospitalRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalRegister() {
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
		String hospitalname = request.getParameter("HospitalName");
		String hospitalid = request.getParameter("HospitalID");
		String hospitalpassword = request.getParameter("HospitalPassword");
		String mobile = request.getParameter("HospitalMobile");
		String country = request.getParameter("HospitalCountry");
		String city = request.getParameter("HospitalCity");
		String address = request.getParameter("HospitalAddress");
		String pincode = request.getParameter("HospitalPincode");
		
		HospitalBean ub = new HospitalBean();
		ub.setHospitalName(hospitalname);
		ub.setHospitalID(hospitalid);
		ub.setHospitalPassword(hospitalpassword);
		ub.setMobile(mobile);
		ub.setCountry(country);
		ub.setCity(city);
		ub.setAddress(address);
		ub.setPincode(pincode);
		System.out.println("Hi");
		String sql = "insert into hospitals values(?,?,?,?,?,?,?,?)";
		int i = Dao.hospitals(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Hospital Register Successfully...');");
			o.println("window.location='HospitalLogin.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='HospitalRegister.jsp';</script>");
		}
	}

}
