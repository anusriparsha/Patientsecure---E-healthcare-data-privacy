package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;

/**
 * Servlet implementation class UApprove
 */
@WebServlet("/UApprove")
public class UApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UApprove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String em = request.getParameter("em");
		String sql = "update doctors set status2='Approved' where email='"+em+"'";
		int i = Dao.update(sql);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Doctors Request Accepted Successfully...');");
			o.println("window.location='DoctorRequests.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Doctors Request Not Accepted');");
			o.println("window.location='DoctorRequests.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
