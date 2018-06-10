<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1"
>
<title>Peter's Cafeteria Data App</title>
</head>
<body>
	<form
		name="leftButtons"
		method="post"
	>
		<input
			type="hidden"
			name="buttonPressed"
		>
		<button
			type="button"
			name="testButton"
			value="testing"
			style="position: absolute; height: 15%; width: 25%; left: 0%; top: 20%"
			onclick="testClicked()"
		>This is the test button!</button>
	</form>
	<script>
		function testClicked() {
			leftButtons.buttonPressed.value = leftButtons.testButton.value;
			leftButtons.submit();
		}
	</script>
	<p>
		This is a test.
		<br />
		<%
		    if (request.getParameter("buttonPressed") != null)
		    {
		%>
		Congrats on pressing the test button!
		<br />
		The value of the servlet is
		<%=request.getParameter("buttonPressed")%><br />
		<%
		    }
		%>
	</p>
</body>
</html>