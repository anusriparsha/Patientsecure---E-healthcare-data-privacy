<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Dao"%>
<%
		String sql = "select name from doctors";
		List<String> lt = Dao.getVMName(sql);
		Iterator<String> itr = lt.iterator();
		%>
			<section id="banner" data-video="images/banner" >
				<div class="inner" >
					<h1 style="margin-top: 50px;">User Registration</h1>
					<form action="UserReg" method="post">
					<table class="w3-table w3-black" style="width: 750px;">
					<tr><td>Name</td><td><input type="text" name="name" class="w3-input"></td></tr>
					<tr><td>Email</td><td><input type="text" name="uid" class="w3-input"></td></tr>
					<tr><td>Password</td><td><input type="password" name="pwd" class="w3-input"></td></tr>
					<tr><td>Mobile</td><td><input type="text" name="mob" class="w3-input"></td></tr>
					<tr><td>VM</td><td><select name="vm" class="w3-input">
					<option value="null">----select----</option>
					<%
					while(itr.hasNext()){
						String vm = itr.next();
					%>
					<option value="<%=vm %>"><%=vm %></option>
					<%} %>
					</select> </td></tr>
					</table>
					<input type="submit" value="Register" class="w3-button w3-white">
					</form>
				</div>