<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="objects.SharedNote"%>
<%@page import="controller.Service"%>
<%@page import="entry.Switch"%>
<%@page import="objects.User"%>
<%@page import="entry.Gate"%>
<%@page import="objects.Note"%>
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
	<%
		String name = (String) request.getSession().getAttribute(
				User.USER_NAME_STYLE1 + Gate.SESSION_ATTRIBUTE_SUFFIX);

		int nbNotesNoteRead = (Integer) request.getSession().getAttribute(
				SharedNote.NB_SHARED_NOTES_REC
						+ Gate.SESSION_ATTRIBUTE_SUFFIX);
	%>
	<div class="container">
		<center>
			<div class="jumbotron">


					<h3 style="text-decoration: underline;">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageNotesService&"+Service.REQUESTED_SERVICE_LBL+"=launchNotesManagement"%>">
						Hi <%=name%> <span class="badge" style="color: red;"><%=nbNotesNoteRead%></span>


			</div>

			<div class="row">

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageCartService&"+Service.REQUESTED_SERVICE_LBL+"=launchCartManagement"%>">
						<img data-holder-rendered="true"
						src="${pageContext.request.contextPath}/img/menu_icon/cart_icon.png"
						style="width: 100px; height: 100px;" class="img-thumbnail"
						alt="100x100">
					</a>
				</div>

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageFridgeService&"+Service.REQUESTED_SERVICE_LBL+"=launchFridgeManagement"%>">
						<img data-holder-rendered="true"
						src="${pageContext.request.contextPath}/img/menu_icon/fridge_icon.png"
						style="width: 100px; height: 100px;" class="img-thumbnail"
						alt="100x100">
					</a>
				</div>

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageRecipeService&"+Service.REQUESTED_SERVICE_LBL+"=launchRecipesManagement"%>">
						<img data-holder-rendered="true"
						src="${pageContext.request.contextPath}/img/menu_icon/recipe_icon.png"
						style="width: 100px; height: 100px;" class="img-thumbnail"
						alt="100x100">
					</a>
				</div>
			</div>

			<div class="row">

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.SupportUserService&"+Service.REQUESTED_SERVICE_LBL+"=displayManual"%>">
						<img
						src="${pageContext.request.contextPath}/img/menu_icon/help_icon.png"
						style="width: 100px; height: 100px;" class="img-thumbnail"
						alt="100x100">
					</a>
				</div>

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageNotesService&"+Service.REQUESTED_SERVICE_LBL+"=launchNotesManagement"%>">
						<img
						src="${pageContext.request.contextPath}/img/menu_icon/note_icon.png"
						style="width: 100px; height: 100px;" class="img-thumbnail"
						alt="100x100">

					</a>
				</div>

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<a
						href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageSettingsService&"+Service.REQUESTED_SERVICE_LBL+"=launchSettingsManagement"%>">
						<img
						src="${pageContext.request.contextPath}/img/menu_icon/settings_icon.png"
						style="width: 100px; height: 100px;" class="img-thumbnail"
						alt="100x100">
					</a>
				</div>
			</div>
		</center>
	</div>


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
