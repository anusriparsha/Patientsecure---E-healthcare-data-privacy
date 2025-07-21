package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.ComposeBean;
import com.beans.DoctorBean;
import com.beans.FileRequestBean;
import com.beans.HospitalBean;
import com.beans.PatientBean;
import com.beans.RelativeBean;
import com.beans.UploadBean;

import model.FileModel;

public class Dao {
	
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/vtjnw07", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	public static List<String> getOkey(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
			//	lt.add(rs.getString(4));
			//	lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static ResultSet getData2(String sql) {
		// TODO Auto-generated method stub
		Connection con = connect();
		ResultSet rs = null;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			rs =  ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	public static int patients(String sql, PatientBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getPassword());
			ps.setString(4, ub.getCpassword());
			ps.setString(5, ub.getMobile());
			ps.setString(6, ub.getCountry());
			ps.setString(7, ub.getCity());
			ps.setString(8, ub.getAddress());
			ps.setString(9, ub.getPincode());
			ps.setString(10, ub.getDm());
			ps.setString(11, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int relatives(String sql, RelativeBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getPassword());
			ps.setString(4, ub.getMobile());
			ps.setString(5, ub.getCountry());
			ps.setString(6, ub.getCity());
			ps.setString(7, ub.getAddress());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int messages(String sql, ComposeBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getPid());
			ps.setString(2, ub.getDid());
			ps.setString(3, ub.getMsg());
			ps.setString(4, ub.getDa());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getAllusers() throws SQLException {
		List al = new ArrayList();
		String sql = "select doctorname from doctors";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public static ResultSet getAllusers1(String uid) throws SQLException {
		List al = new ArrayList();
		String sql = "select * from patients where status2= 'pending' and email='"+uid+"'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public static ResultSet getAllusers3(String uid) throws SQLException {
		List al = new ArrayList();
		String sql = "select * from patients where status2= 'Approved' and email='"+uid+"'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public static ResultSet getAllusers2(String uid) throws SQLException {
		List al = new ArrayList();
		String sql = "select * from patients where status2= 'pending' and doctorname='"+uid+"'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public static ResultSet getRelativeRequests(String uid) throws SQLException {
	
		String sql = "select * from relativerequest where status1='pending' and fid='"+uid+"'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public static int upload(String sql, UploadBean u) 
	{
		// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, u.getUid());
				ps.setString(2, u.getDoctorname());
				InputStream photo = u.getPhoto();
				if (photo != null) {
					ps.setBinaryStream(3, photo);
				}
				ps.setString(4, u.getEnc());
				ps.setString(5, u.getContent());
				ps.setString(6, u.getKey());
			
				i = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	public static boolean updateUser(String s) throws SQLException {
		String sql = "update doctorsreq set status1='Approved' where email='" + s + "'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		boolean f = st.execute(sql);
		System.out.println("boolean is" + f);
		return f;
	}
	public static int hospitals(String sql, HospitalBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getHospitalName());
			ps.setString(2, ub.getHospitalID());
			ps.setString(3, ub.getHospitalPassword());
			ps.setString(4, ub.getMobile());
			ps.setString(5, ub.getCountry());
			ps.setString(6, ub.getCity());
			ps.setString(7, ub.getAddress());
			ps.setString(8, ub.getPincode());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static int doctors(String sql, DoctorBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getPassword());
			ps.setString(4, ub.getCpassword());
			ps.setString(5, ub.getMobile());
			ps.setString(6, ub.getCountry());
			ps.setString(7, ub.getCity());
			ps.setString(8, ub.getAddress());
			ps.setString(9, ub.getPincode());
			ps.setString(10, ub.getDHighestDegree());
			ps.setString(11, ub.getDSpecialization());
			ps.setString(12, ub.getDExperience());
			ps.setString(13, ub.getDRegistrationNumber());
			ps.setString(14, ub.getStateMedicalCouncil());
			ps.setString(15, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static boolean login(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public static List<String> getCloud(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getVM(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getUser1(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(5));
				lt.add(rs.getString(11));
				lt.add(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static String getName(String sql) {
		// TODO Auto-generated method stub
		String name = "";
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			name = rs.getString(1);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	public static List<String> getVMPayment(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getUserPayment(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getPlan(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}


	public static int update(String sql) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/*public static int requestSpace(String sql, RequestBean rb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rb.getVm());
			ps.setString(2, rb.getCloud());
			ps.setString(3, rb.getSpace());
			ps.setString(4, rb.getReq());
			ps.setDouble(5, rb.getPrice());
			ps.setString(6, rb.getDate1());
			ps.setString(7, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	*/
	public static List<String> getPlanReq(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static String getPrice(String sql) {
		// TODO Auto-generated method stub
		String price = null;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				price = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	
	public static List<String> getCard(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int getCvv(String sql) {
		// TODO Auto-generated method stub
		int cvv = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cvv = rs.getInt(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cvv;
	}

	public static List<String> getSpace(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getVMName(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getVMName3(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getVMName1(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	/*public static int store(String sql, StoreBean sb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sb.getUid());
			ps.setString(2, sb.getName());
			InputStream photo = sb.getPhoto();
			if(photo != null){
				ps.setBinaryStream(3, photo);
			}
			ps.setString(4, sb.getVm());
			ps.setString(5, sb.getDa());
			ps.setString(6, sb.getContent());
			ps.setDouble(7, sb.getSize());
			i = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}*/
	
	public static double getSize(String sql) {
		double d = 0.0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			d = rs.getDouble(1);
			rs.close();
			ps.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;
	}
	
	public static List<Integer> getMin(String sql) {
		// TODO Auto-generated method stub
		List<Integer> lt = new ArrayList<Integer>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getInt(1));
				lt.add(rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getFile(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}public static List<String> getDFile(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getPMessages(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getPMessages1(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static String getName1(String sql) {
		// TODO Auto-generated method stub
		String name = "";
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			name = rs.getString(1);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static List<String> getCauction(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static ResultSet getDoctorsList(String uid) throws SQLException
	 {
	 	Connection con =Dao.connect();
	 	String sql="select * from doctors where status2='Approved'";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	return r;
	 }
	public static ResultSet getPatientsList(String uid) throws SQLException
	 {
	 	Connection con =Dao.connect();
	 	String sql="select * from uploadfiles";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	return r;
	 }
	
	public static List<FileModel> getPatientList() throws SQLException
	 {
		List<FileModel> files=new ArrayList();
	 	Connection con =Dao.connect();
	 	String sql="select * from uploadfiles";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	
	 	while(r.next()) {
	 		
	 		FileModel fm=new FileModel();
	 		fm.setFileId(r.getInt(1));
	 		fm.setUid(r.getString(2));
	 		
	 /*		String[] singleBinaryArray = r.getBinaryStream(5).toString().split("\\s");
	 		String finalResult = "";
	 		for (String string : singleBinaryArray) {
	 		Character c = (char) Integer.parseInt(string, 2);
	 		    finalResult += c.toString();
	 		}
	 		System.out.println("String " + finalResult);
	 		*/
	 		fm.setFileContent(r.getString(5));
	 		
	 		files.add(fm);
	 		
	 		
	 		
	 	}
	 	
	 	
	 	
	 	return files;
	 }
	public static List<String> getVPlan(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
				lt.add(rs.getString(7));
				lt.add(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static int requestFile(String sql, FileRequestBean rb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rb.getReid());
			ps.setString(2, rb.getFid());
			ps.setString(3, rb.getUid());
			ps.setString(4, rb.getDoctorname());
			ps.setString(5, rb.getDate1());
			ps.setString(6, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
