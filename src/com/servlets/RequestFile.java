package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.FileRequestBean;
import com.dao.Dao;

/**
 * Servlet implementation class RequestFile
 */
@WebServlet("/RequestFile")
public class RequestFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//<td><a href="RequestFile?email=<%=emailid%>&&fid=<%=fid%>&&uid=<%=uid%>&&doctorname=<%=doctorname%>">Send Request</a></td>
	    PrintWriter o = response.getWriter();
		HttpSession session = request.getSession();
		String reid = (String) session.getAttribute("email");
		String fid = request.getParameter("fid");
		String uid = request.getParameter("uid");
		String uploadId=request.getParameter("uploadId");
		String doctorname = request.getParameter("doctorname");
		Date d = new Date();
		String date1 = "" + d;
		
		FileRequestBean rb = new FileRequestBean();
		rb.setReid(reid);
		rb.setFid(fid);
		rb.setUid(uid);
		rb.setDoctorname(doctorname);
		rb.setDate1(date1);
		String sql = "insert into relativerequest values(0,?,?,?,?,?,?,?)";
		Connection con=Dao.connect();
		Statement st;
		System.out.println("kkkkkk"+reid);
		System.out.println("kkkkkk"+fid);
		System.out.println("kkkkkk"+uid);
		System.out.println("kkkkkk"+doctorname);
		 try {
			// st = con.createStatement();
		//	int i=st.executeUpdate("insert into relativerequest values('"+reid+"','"+fid+"','"+uid+"','"+doctorname+"',Pending,'"+uploadId+"'");
			String sql2="insert into relativerequest values(0,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql2);
			ps.setString(1,reid);
			ps.setString(2, fid);
			ps.setString(3, uid);
			ps.setString(4, doctorname);
			ps.setString(5, "pending");
			ps.setString(6, uploadId);
			int i=ps.executeUpdate();
			 o.println("<script type=\"text/javascript\">");
			 o.println("alert('Data Recovery Request Sent Successfully...');");
			 o.println("location='ViewPatientsList.jsp';");
			 o.println("</script>");
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
		
		/*HttpSession session=request.getSession();
	    PrintWriter pw=response.getWriter();
	    String reid = (String) session.getAttribute("email");
	    //String ried=request.getParameter("name");
	    String fid=request.getParameter("fid");
	    String uid=request.getParameter("uid");
	    String doctorname=request.getParameter("doctorname");
	 //   String sql="select * from relatives where cserver='CloudServer2' and status1='Approved'";
	    Connection con=Dao.connect();
	    Statement st;
	    
			String sql4="select * from relativerequest where rid='" + reid + "' and status1='Approved'";
			if(Dao.getData(sql4)==true){
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Already Sent Data Recovery Request');");
			pw.println("window.location='ReqForRecovery.jsp';</script>");
		}else{
			
			 try {
				 st = con.createStatement();
				int i=st.executeUpdate("insert into relativerequest values(0,'"+reid+"','"+fid+"','"+uid+"','"+doctorname+"','Pending')");
				 pw.println("<script type=\"text/javascript\">");
				 pw.println("alert('Data Recovery Request Sent Successfully...');");
				 pw.println("location='ReqForRecovery.jsp';");
				 pw.println("</script>");
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} */
