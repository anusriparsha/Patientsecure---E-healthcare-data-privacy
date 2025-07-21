package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.beans.UploadBean;
import com.dao.Dao;
import com.dao.PortNumber;
import com.dao.Test;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.beans.UploadBean;
import com.dao.Dao;
import com.dao.PortNumber;
import com.dao.Test;
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Upload")

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
		String doctorname = request.getParameter("doctorname");
		String uid = (String)session.getAttribute("email");
		Part img = request.getPart("photo");
		InputStream photo = null, photo1 = null;
		if(img != null){
			photo = img.getInputStream();
			photo1 = img.getInputStream();
		}
		String content = img.getContentType();
		String key = PortNumber.getKeys();
		String text = "";
		int j = 0;
		while((j=photo.read())!=-1) {
			text = text + (char) j;
		}
		String enc = Test.encryption(text, key);
		System.out.println(enc);
		
		UploadBean u = new UploadBean();
		u.setDoctorname(doctorname);
		u.setUid(uid);
		u.setPhoto1(photo1);
		u.setEnc(enc);
		u.setContent(content);
		u.setKey(key);
		String sql = "insert into uploadfiles values(0,?,?,?,?,?,?)";
		int i = Dao.upload(sql, u);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File Uploaded Sucessfully...');");
			o.println("window.location='UploadReports.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File not Uploaded');");
			o.println("window.location='UploadReports.jsp';</script>");
		}
	}

}
