<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1"
>
<title>Peter's Kitchen Records</title>
<link
	rel="stylesheet"
	type="text/css"
	href="${pageContext.request.contextPath }/styles/style.css"
>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_leftButtons.jsp"></jsp:include>
	<jsp:include page="_menuPanel.jsp"></jsp:include>
	<jsp:include page="_productionPanel.jsp"></jsp:include>
</body>
</html>