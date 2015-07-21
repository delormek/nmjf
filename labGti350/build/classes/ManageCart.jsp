<%@page import="controller.UserManageCartService"%>
<%@page import="controller.Service"%>
<%@page import="entry.Switch"%>
<%@page import="entry.Gate"%>
<%@page import="java.util.List"%>
<%@page import="objects.FoodCategory"%>
<%@page import="objects.Food"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="">

<title>NMJF</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap-3.3.5-dist/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/signin.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="${pageContext.request.contextPath}//css/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="container">
		<%
			List<FoodCategory> list = (List<FoodCategory>) request
					.getAttribute(UserManageCartService.FOOD_CATEGORIES);
				
				if(list!=null){
		%>


		<jsp:include page="session_invalidate_link.jsp" />
		<!-- -------------------------------CATEGORY LIST ------------------ -->
		<div class='row'>
			<div
				class="col-xs-10 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4 page-header">
				<h1>Choose a category</h1>
			</div>
		</div>
		<div class='row'>

			<div class="col-xs-10 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">
				<div class="list-group">
					<%
						for (int i = 0; i < list.size(); i++) {

									FoodCategory cat = (FoodCategory) list.get(i);
					%>
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageCartService&"+Service.REQUESTED_SERVICE_LBL+"=displayFoodForCat&"
						+UserManageCartService.FOOD_CATEGORY_ID+"="+cat.getIdFoodCategory()%>"
						class="list-group-item "> </br>
						<h4 class="list-group-item-heading"><%=cat.getName()%></h4> </br>
					</a>
					<%
						}
					%>

				</div>
			</div>
		</div>

		<%
			}
		
			List<Food> list2 = (List<Food>) request.getAttribute(
				UserManageCartService.FOOD);
				
			
				
				if(list2!=null){
		%>
		<jsp:include page="session_invalidate_link.jsp" />
		<!-- -------------------------------FOOD LIST FROM A SELECTED CATEGORY ------------------ -->
		<div class='row'>
			<div
				class="col-xs-10 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4 page-header">
				<h1>Select food</h1>
			</div>
		</div>
		<div class='row'>

			<div class="col-xs-10 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">
				<div class="list-group">
					<%
						for (int i = 0; i < list2.size(); i++) {

						Food f = (Food) list2.get(i);
					%>
					<div class="list-group-item ">
						</br>
						<h4 class="list-group-item-heading"><%=f.getName()%></h4>
						<a href="" class="btn btn-primary">view details >></a> </br>
					</div>
					<%
						}
					%>

				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.js"></script>
</body>
</html>