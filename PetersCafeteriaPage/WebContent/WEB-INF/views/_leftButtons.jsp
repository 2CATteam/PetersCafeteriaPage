<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"
%>
<form
	id="editLink"
	action="${pageContext.request.contextPath}/EditDB"
	method="post"
></form>
<form
	id="menuLink"
	action="${pageContext.request.contextPath}/EditMenu"
	method="post"
></form>
<form
	id="dayLink"
	action="${pageContext.request.contextPath}/ChangeDayBox"
	method="post"
></form>
<div id="leftButtons">
	<div class="leftSpacer"></div>
	<button
		class="leftButton"
		type="submit"
		form="editLink"
	>Edit Dishes in Database</button>
	<div class="leftSpacer"></div>
	<button
		class="leftButton"
		type="submit"
		form="menuLink"
	>Edit Menu</button>
	<div class="leftSpacer"></div>
	<button
		class="leftButton"
		type="submit"
		form="dayLink"
	>Change day and meal</button>
</div>