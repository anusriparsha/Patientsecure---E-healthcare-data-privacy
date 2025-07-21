package com.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;

/**
 * Servlet implementation class Download
 */
@WebServlet("/FileDecryptDownload")
public class FileDecryptDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDecryptDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = Dao.connect();
	//	PrintWriter out=response.getWriter();
		String status="Pending";
	String fileId = request.getParameter("fid");
	String userid=request.getParameter("userid");
	//	HttpSession session = request.getSession(false);
	//	String email = (String) session.getAttribute("email");
		String sql1="SELECT status1 FROM relativerequest where uploadedId='"+fileId+"' and UID='"+userid+"'";
	//	String sql2="SELECT status1 FROM relativerequest WHERE uploadedId='3' AND UID='ibraheem@gmail.com'";
		try {
		PreparedStatement ps1=con.prepareStatement(sql1);
		ResultSet rs1=ps1.executeQuery();
		if(rs1.next()) {
			
			status=rs1.getString(1);
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		if(!status.equalsIgnoreCase("pending")) {
			String sql = "select * from uploadfiles where fid='"+fileId+"'";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				OutputStream o = response.getOutputStream();
				if(rs.next()){
					response.setContentType(rs.getString(6));
					o.write(rs.getBytes(4));
				}
				o.flush();
				o.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			PrintWriter out=response.getWriter();
		out.println("File is not Approved by Patient");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
