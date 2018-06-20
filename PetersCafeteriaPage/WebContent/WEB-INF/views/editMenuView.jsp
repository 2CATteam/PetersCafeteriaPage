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
<title>Editing Menu</title>
<link
	rel="stylesheet"
	type="text/css"
	href="${pageContext.request.contextPath }/styles/style.css"
>
</head>
<body>
	<div id="viewWindow">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_leftButtons.jsp"></jsp:include>
		<jsp:include page="_menuPanel.jsp"></jsp:include>
		<jsp:include page="_productionPanel.jsp"></jsp:include>
		<form
			action="${pageContext.request.contextPath}/Main"
			method="post"
		>
			<button
				class="backoutButton"
				type="submit"
			></button>
			<button
				id="fakeEditMenuButton"
				type="submit"
			>Edit Menu</button>
		</form>
		<form
			action="${pageContext.request.contextPath}/AddMenu"
			method="post"
			id="addDishForm"
		></form>
		<form
			action="${pageContext.request.contextPath}/RemoveMenu"
			method="post"
			id="removeDishForm"
		></form>
		<div id="frameContainer">
			<img
				id="editMenuFrame"
				src="${pageContext.request.contextPath }/styles/calloutLeft.svg"
			/>
		</div>
		<div id="editMenuDiv">
			<div id="container">
				<div class="addDishText">
					<h3>Add Dish</h3>
				</div>
				<div class="addLine1">
					<div class="dishDropdownLabel">Select dish:</div>
					<div class="dropdownDishes">
						<select
							style="position: absolute; width: 100%;"
							name="toAdd"
							form="addDishForm"
						>
							<c:forEach
								items="${sessionScope.dishesInDB}"
								var="dishChoice"
							>
								<option value="${dishChoice}">${dishChoice}</option>
							</c:forEach>
						</select>
					</div>
					<div class="submitButton">
						<button
							type="submit"
							form="addDishForm"
						>Add</button>
					</div>
				</div>
				<div id="removeText">
					<h3>Remove Dish</h3>
				</div>
				<div id="removeLine">
					<div class="dishDropdownLabel">Select dish:</div>
					<div class="dropdownDishes">
						<select
							style="position: absolute; width: 100%;"
							name="toRemove"
							form="removeDishForm"
						>
							<c:forEach
								items="${sessionScope.dishList}"
								var="dishChoice"
							>
								<option value="${dishChoice.dishName}">${dishChoice.dishName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="submitButton">
						<button
							type="submit"
							form="removeDishForm"
						>Remove</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>