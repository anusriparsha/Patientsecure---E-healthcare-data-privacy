<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Dao"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hook</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
</head>

<body class="bg-black muli">
    <nav class="w-100pc flex flex-column md-flex-row md-px-10 py-5 bg-black">
        <div class="flex justify-between">
            <a href="#" class="flex items-center p-2 mr-4 no-underline">
                <img class="max-h-l2 w-auto" src="assets/images/logo.png" />
            </a>
            <a data-toggle="toggle-nav" data-target="#nav-items" href="#"
                class="flex items-center ml-auto md-hidden indigo-lighter opacity-50 hover-opacity-100 ease-300 p-1 m-3">
                <i data-feather="menu"></i>
            </a>
        </div>
        <div id="nav-items" class="hidden flex sm-w-100pc flex-column md-flex md-flex-row md-justify-end items-center">
            <a href="index.html" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Home</a>
            <a href="PatientLogin.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Patient</a>
            <a href="DoctorLogin.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Doctor</a>
            <a href="HospitalLogin.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Hospital</a>
     <!--        <a href="RelativeLogin.jsp" class="button bg-white black fw-600 no-underline mx-5">Relative</a>
      -->   </div>
    </nav>

    <!-- hero section -->
   <section id="home" class="min-h-100vh flex justify-start items-center">
        <div class="mx-5 md-mx-l5">
            <div>
                <h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-900 ">Patient Registration</h1>
				<form action="PateintRegister" method="post">
                <div>
                <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient Name" name="PatientName"> &nbsp;&nbsp;&nbsp;
                        <br><br>
                    <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient ID" name="PatientID"> 
                        <br><br>
                        <input type="password"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Password" name="PatientPassword"> &nbsp;&nbsp;&nbsp;
                        <br><br>
                        <input type="password"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Confirm Password" name="PatientCPassword"> &nbsp;&nbsp;&nbsp;
						<br><br>
                        <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient Contact" name="PatientMobile">
                        <br><br>
                    <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient Country" name="PatientCountry">&nbsp;&nbsp;&nbsp;
						<br><br>
                        <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient City" name="PatientCity">
						<br><br>
                        <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient Address" name="PatientAddress"> &nbsp;&nbsp;&nbsp;
                        <br><br>
                        <input type="text"
                        class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                        placeholder="Enter Patient Pincode" name="PatientPincode"> 
                        <br><br>
                        <select name="vm" class="button-lg bg-indigo-lightest-20 indigo-lightest focus-white fw-300 fs-s3 mr-0 br-l-0"
                         placeholder="Select Doctor">
					<option value="null">----select----</option>
					<%
		String sql = "select name from doctors";
		List<String> lt = Dao.getVMName(sql);
		Iterator<String> itr = lt.iterator();
		%>
					<%
					while(itr.hasNext()){
						String vm = itr.next();
					%>
					<option value="<%=vm %>"><%=vm %></option>
					<%} %>
					</select>
                    <input type="submit" class="button-lg bg-indigo-lightest-20 indigo-lightest focus-white fw-300 fs-s3 mr-0 br-l-0"
                         placeholder="Register"/>
                                                 </div>
                </form>
        </div>
        </div>
    </section>
    <section class="p-10 md-py-10">
    </section>

    <!-- product options -->
    

    <!-- pricing -->
    <!-- testimonials -->
    <!-- subscribe -->
    <!-- footer -->
</body>

</html>