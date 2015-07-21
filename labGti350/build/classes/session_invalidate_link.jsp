<%@page import="entry.Gate"%>
<%@page import="controller.Service"%>

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

	<script type="text/javascript">
		function back() {
			history.go(-1);
			location.reload(true);
		}
	</script>

	<%
		String filename = (String) request.getAttribute(Gate.NEW_LOCATION);
		Boolean value = false;
		if (filename != null) {
			value = filename.contains("menu");
		}
		if (!value) {
	%>
	<div class="row">
		<div class="col-xs-5  col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">
			<a class="btn btn-success" onclick="back();"> Back</a>
		</div>
		<div class="col-xs-5 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">
			<a class="btn btn-warning"
				href="${pageContext.request.contextPath}<%="/gate?"+Service.SESSION_INVALIDATE_BOOL+"=TRUE"%>">
				Sign out</a>
		</div>

	</div>
	<%
		} else {
	%>

	<div class="row">
		<div class="col-xs-2 col-xs-offset-4 col-sm-12 col-md-4 col-lg-4">
			<a class="btn btn-warning"
				href="${pageContext.request.contextPath}<%="/gate?"+Service.SESSION_INVALIDATE_BOOL+"=TRUE"%>">
				Sign out</a>
		</div>

	</div>


	<%
		}
	%>



	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.js"></script>
</body>
</html>