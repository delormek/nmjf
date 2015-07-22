<%@page import="entry.Gate"%>
<%@page import="controller.Service"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
