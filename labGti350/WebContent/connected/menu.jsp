<%@page import="java.lang.Long"%>
<%@page import="controller.UserService"%>
<%@page import="entry.Gate"%>
<%@page import="entry.Switch"%>
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
      <script src="https://oss.maxcdn.com/respond/1.3.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<%
		String name = (String) request.getSession().getAttribute(
				UserService.USER_NAME_STYLE1
						+ Gate.SESSION_ATTRIBUTE_SUFFIX);

		Long nbNotesNotRead = (Long) request.getSession().getAttribute(
				UserService.NB_SHARED_NOTES_REC
						+ Gate.SESSION_ATTRIBUTE_SUFFIX);
	%>
	<div class="container">


		<jsp:include page="session_invalidate_link.jsp" />
		<div class="row">
			<div
				class=" col-xs-8 col-xs-offset-2  col-sm-12 col-md-4 col-lg-4 page-header">
				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageNotesService&"+Service.REQUESTED_SERVICE_LBL+"=launchNotesManagement"%>">
					<h1>
						Hi
						<%
						out.print(name);
						if (nbNotesNotRead > 0) {
							out.print("<span class=\"badge\" style=\"color: red;\">"
									+ nbNotesNotRead + "</span>");
						}
					%>
					</h1>
				</a>

			</div>
		</div>
		</br>


		<div class="row">

			<div class="col-xs-5  col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">
				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageCartService&"+Service.REQUESTED_SERVICE_LBL+"=launchCartManagement"%>">
					<img
					src="${pageContext.request.contextPath}/img/menu_icon/cart_icon.png"
					style="width: 100px; height: 100px; border-radius: 20px"
					class="img-thumbnail" alt="100x100">
				</a>
			</div>

			<div class="col-xs-5 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">

				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageRecipeService&"+Service.REQUESTED_SERVICE_LBL+"=launchRecipesManagement"%>">
					<img
					src="${pageContext.request.contextPath}/img/menu_icon/recipe_icon.png"
					style="width: 100px; height: 100px; border-radius: 20px"
					class="img-thumbnail" alt="100x100">
				</a>
			</div>
		</div>
		<br />
		<div class="row">

			<div class="col-xs-5  col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">

				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageFridgeService&"+Service.REQUESTED_SERVICE_LBL+"=launchFridgeManagement"%>">
					<img
					src="${pageContext.request.contextPath}/img/menu_icon/fridge_icon.png"
					style="width: 100px; height: 100px; border-radius: 20px"
					class="img-thumbnail" alt="100x100">
				</a>
			</div>


			<div class="col-xs-5 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">

				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageNotesService&"+Service.REQUESTED_SERVICE_LBL+"=launchNotesManagement"%>">
					<img
					src="${pageContext.request.contextPath}/img/menu_icon/note_icon.png"
					style="width: 100px; height: 100px; border-radius: 20px"
					class="img-thumbnail" alt="100x100">

				</a>
			</div>
		</div>
		<br />
		<div class="row">

			<div class="col-xs-5 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">

				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.SupportUserService&"+Service.REQUESTED_SERVICE_LBL+"=displayManual"%>">
					<img
					src="${pageContext.request.contextPath}/img/menu_icon/help_icon.png"
					style="width: 100px; height: 100px; border-radius: 20px"
					class="img-thumbnail" alt="100x100">
				</a>

			</div>

			<div class="col-xs-5 col-xs-offset-1 col-sm-12 col-md-4 col-lg-4">

				<a
					href="${pageContext.request.contextPath}<%="/gate?"+Switch.REQUIRED_CLASSNAME_LBL+"=controller.UserManageSettingsService&"+Service.REQUESTED_SERVICE_LBL+"=launchSettingsManagement"%>">
					<img
					"
					src="${pageContext.request.contextPath}/img/menu_icon/settings_icon.png"
					style="width: 100px; height: 100px; border-radius: 20px"
					class="img-thumbnail" alt="100x100">
				</a>
			</div>
		</div>



	</div>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
