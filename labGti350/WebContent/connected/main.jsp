<%@page import="controller.Service"%>
<%@page import="entry.Switch"%>
<%@page import="objects.User"%>
<%@page import="entry.Gate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NoNameFound</title>

</head>
<body>
<%User actualCli = (User)request.getSession().getAttribute(User.USER_LBL_IN_SESSION+Gate.SESSION_ATTRIBUTE_SUFFIX);%>
	<h2>No more Junk food. Upgrade yourself !</h2>
	<p>Welcome <%= actualCli.getFName() + " " + actualCli.getLName() %></p>
	
	<menu>  
	
	</menu>
	
	
</body>
</html>