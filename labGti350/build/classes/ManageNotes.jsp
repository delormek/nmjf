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

	<div class="container">
		<%
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-mm-yyyy");
			List<Object> notesAndUserCre = (List<Object>) request.getSession()
					.getAttribute(
							SharedNote.SHARED_NOTES_REC_NOT_READ
									+ Gate.SESSION_ATTRIBUTE_SUFFIX);
			List<Object> notesReceived = (List<Object>) request.getSession()
					.getAttribute(
							SharedNote.SHARED_NOTES_RECEIVED
									+ Gate.SESSION_ATTRIBUTE_SUFFIX);
			List<Object> notesSent = (List<Object>) request.getSession()
					.getAttribute(
							SharedNote.SHARED_NOTES_SENT
									+ Gate.SESSION_ATTRIBUTE_SUFFIX);
		%>

		<div>
			<p>
				<a href="${pageContext.request.contextPath}/connected/sendNote.jsp">
					<button class="btn btn-danger">Compose</button>
				</a>
			</p>
		</div>
		<!-- -------------------------------NOTES ON THE FRIDGE ------------------ -->
		<div class="page-header">
			<h1>On the fridge</h1>
		</div>
		<div class='row'>
			<%
				for (int i = 0; i < notesAndUserCre.size(); i++) {

					Object[] obj = (Object[]) notesAndUserCre.get(i);
					Note note = (Note) obj[0];
					User createur = (User) obj[1];
					String from_name = createur.getFName() + " "
							+ createur.getLName().charAt(0) + ".";
					String content = note.getContent();
					String date = DATE_FORMAT.format(note.getDate());
			%>
			<div class='col-xs-12 col-sm-12 col-md-4 col-lg-4'>

				<div class="panel panel-warning">

					<div class="panel-heading">
						<h3 class="panel-title">
							From
							<%=from_name%>
							on
							<%=date%>
						</h3>
					</div>
					<div class="panel-body">
						<p>
							<%=content%>
						</p>
						<p>
							<a class="btn btn-success" href="#" role="button"> Read !</a>
						</p>
					</div>

				</div>


			</div>
			<%
				}
			%>
		</div>
		<div class="alert alert-info" role="alert">
			<strong> Checked ! </strong> It 's been archived.
		</div>



		<!-- ------------------------------------------------------NOTES RECEIVED------------------------- -->
		<div class="page-header">
			<h1>Archived</h1>
		</div>
		<div class='row'>
			<%
				for (int i = 0; i < notesReceived.size(); i++) {

					Object[] obj = (Object[]) notesReceived.get(i);
					Note note = (Note) obj[0];
					User createur = (User) obj[1];
					String from_name = createur.getFName() + " "
							+ createur.getLName().charAt(0) + ".";
					String content = note.getContent();
					String date = DATE_FORMAT.format(note.getDate());
			%>
			<div class='col-xs-12 col-sm-12 col-md-4 col-lg-4'>

				<div class="panel panel-warning">

					<div class="panel-heading">
						<h3 class="panel-title">
							From
							<%=from_name%>
							on
							<%=date%>
						</h3>
					</div>
					<div class="panel-body">
						<p>
							<%=content%>
						</p>
						<p>
							<a class="btn btn-success" href="#" role="button"> Read !</a>
						</p>
					</div>

				</div>


			</div>
			<%
				}
			%>
		</div>



		<!-- -------------------------------------------NOTES SENT ----------------------------------- -->


		<div class="page-header">
			<h1>Sent</h1>
		</div>
		<div class='row'>
			<%
				for (int i = 0; i < notesSent.size(); i++) {

					Note note = (Note) notesSent.get(i);
					String content = note.getContent();
					String date = DATE_FORMAT.format(note.getDate());
			%>
			<div class='col-xs-12 col-sm-12 col-md-4 col-lg-4'>

				<div class="panel panel-warning">

					<div class="panel-heading">
						<h3 class="panel-title">
							Sent on
							<%=date%>
						</h3>
					</div>
					<div class="panel-body">
						<p>
							<%=content%>
						</p>
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