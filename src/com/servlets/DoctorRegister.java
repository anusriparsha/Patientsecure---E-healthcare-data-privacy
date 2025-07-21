package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.DoctorBean;
import com.beans.PatientBean;
import com.dao.Dao;

/**
 * Servlet implementation class DoctorRegister
 */
@WebServlet("/DoctorRegister")
public class DoctorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegister() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String mobile = request.getParameter("mobile");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String pincode = request.getParameter("pincode");
		String DHighestDegree = request.getParameter("DHighestDegree");
		String DSpecialization = request.getParameter("DSpecialization");
		String DExperience = request.getParameter("DExperience");
		String DRegistrationNumber = request.getParameter("DRegistrationNumber");
		String StateMedicalCouncil = request.getParameter("StateMedicalCouncil");
		
		DoctorBean ub = new DoctorBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setPassword(password);
		ub.setCpassword(cpassword);
		ub.setMobile(mobile);
		ub.setCountry(country);
		ub.setCity(city);
		ub.setAddress(address);
		ub.setPincode(pincode);
		ub.setDHighestDegree(DHighestDegree);
		ub.setDSpecialization(DSpecialization);
		ub.setDExperience(DExperience);
		ub.setDRegistrationNumber(DRegistrationNumber);
		ub.setStateMedicalCouncil(StateMedicalCouncil);
		
		String sql = "insert into Doctors values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = Dao.doctors(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Doctor Register Successfully...');");
			o.println("window.location='DoctorLogin.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='DoctorRegister.jsp';</script>");
		}
	}
	}
