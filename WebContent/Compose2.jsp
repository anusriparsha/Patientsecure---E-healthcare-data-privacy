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
            <a href="DoctorHome.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Doctor's Dashboard</a>
            <a href="PatientRequest.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Patient Appointments</a>
            <a href="ViewUploadReports.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">View Upload Reports</a>
            <a href="PConsultation.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Live Consultation</a>
            <a href="PatientHistory.jsp" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Patient History</a>
            <a href="index.html" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Sign Out</a>
        </div>
    </nav>

    <!-- hero section -->
    <section id="home" class="min-h-100vh flex justify-start items-center">
        <div class="mx-5 md-mx-l5">
            <div>
                <h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-900 ">Live Consultation</h1>
                <br><br>
             <form action="Compose1" method="post">
                <div>
                        <select name="doctorname" class="button-lg bg-indigo-lightest-20 indigo-lightest focus-white fw-300 fs-s3 mr-0 br-l-0">
					<option value="null">----select----</option>
					<%
		String pid = (String)session.getAttribute("name");
		String sql = "select email from patients where status2='Approved'";
		List<String> lt = Dao.getVMName3(sql);
		Iterator<String> itr = lt.iterator();
		%>
					<%
					while(itr.hasNext()){
						String vm = itr.next();
					%>
					<option value="<%=vm %>"><%=vm %></option>
					<%} %>
					</select>
					<br><br>
                    <textarea name="message" rows="4" cols="50"
                    class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-25vw br-r-0"
                    placeholder="Enter Patient Info" > </textarea>
                    <br><br>
                    <input type="submit" class="button-lg bg-indigo-lightest-20 indigo-lightest focus-white fw-300 fs-s3 mr-0 br-l-0"
                         placeholder="Send"/>
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
    <section class="p-10 md-p-l5">
        <div class="br-8 bg-indigo-lightest-10 p-5 md-p-l5 flex flex-wrap md-justify-between md-items-center">
            <div class="w-100pc md-w-33pc">
                <h2 class="white fs-m4 fw-800">Try Hook today</h2>
                <p class="fw-600 indigo-lightest opacity-40">Get first month free for commercial use. Forever free for
                    open source products.</p>
            </div>
            <div class="w-100pc md-w-50pc">
                <div class="flex my-5">
                    <input type="text"
                        class="input-lg flex-grow-1 bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 br-r-0"
                        placeholder="Email Address">
                    <button class="button-lg bg-indigo indigo-lightest fw-300 fs-s3 br-l-0">Get Started</button>
                </div>
            </div>
        </div>
    </section>

    <!-- footer -->
</body>

</html>