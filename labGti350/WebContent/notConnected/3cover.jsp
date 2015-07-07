<%@page import="controller.Service"%>
<%@page import="entry.Switch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NoNameFound</title>

</head>
<body>
	<h2>No more Junk food. Upgrade yourself !</h2>
	<form action="/labGti350/gate" method="post">
		Email: <input type="text" name="clis_email"><br> Password: <input
			type="password" name="clis_pass"><br> <input type="submit"
			value="Submit">
			<input type="text" hidden=true name="<%out.print(Switch.REQUIRED_CLASSNAME_LBL); %>"
			value="controller.UserService"/>
			<input type="text" hidden=true name="<%out.print(Service.REQUESTED_SERVICE_LBL); %>"
			value="authentication"/>
	</form>

</body>
</html>