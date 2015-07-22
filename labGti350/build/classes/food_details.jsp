<%@page import="controller.UserManageCartService"%>
<%@page import="controller.Service"%>
<%@page import="entry.Switch"%>
<%@page import="objects.User"%>
<%@page import="entry.Gate"%>
<%@page import="objects.Food"%>
<%@page import="entry.Gate"%>


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
			Food food = (Food) request.getAttribute(UserManageCartService.FOOD);
			
		%>
		<jsp:include page="session_invalidate_link.jsp" />
		</br> </br>
		<div class='row'>
			<div class="col-xs-6 col-xs-offset-3 col-sm-12 col-md-4 col-lg-4">
				<img class="img-thumbnail" alt="150x150"
					style="width: 150px; height: 150px;"
					src="http://kevin.delorme.free.fr/nmjf/img/food/<%=food.getId()%>.jpg">
			</div>
		</div>
		<div class='row'>
			<div class="col-xs-6 col-xs-offset-3 col-sm-12 col-md-4 col-lg-4">
				<div class="well">
					<p><%=food.getDescription()%></p>
				</div>
			</div>
		</div>
	</div>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.js"></script>
</body>
</html>