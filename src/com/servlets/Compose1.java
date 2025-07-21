package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.ComposeBean;
import com.beans.PatientBean;
import com.dao.Dao;

/**
 * Servlet implementation class Compose1
 */
@WebServlet("/Compose1")
public class Compose1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compose1() {
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
		HttpSession session = request.getSession(false);
		String pid = (String)session.getAttribute("email");
		String did = request.getParameter("doctorname");
		String msg = request.getParameter("message");
		Date d = new Date();
		String da = "" + d;
		
		ComposeBean ub = new ComposeBean();
		ub.setPid(pid);
		ub.setDid(did);
		ub.setMsg(msg);
		ub.setDa(da);
		System.out.println("Hiii");
		String sql = "insert into compose1 values(0,?,?,?,?)";
		int i = Dao.messages(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Message Sent Successfully...');");
			o.println("window.location='Compose1.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Message Failed...');");
			o.println("window.location='Compose1.jsp';</script>");
		}
	}
}
