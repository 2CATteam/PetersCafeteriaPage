<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"
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
<title>Editing Database</title>
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
				id="fakeEditDBButton"
				type="submit"
			>Edit Dishes in Database</button>
		</form>
		<form
			action="${pageContext.request.contextPath}/AddDB"
			method="post"
			id="addDishForm"
		></form>
		<form
			action="${pageContext.request.contextPath}/RemoveDB"
			method="post"
			id="removeDishForm"
		></form>
		<div id="frameContainer">
			<img
				id="editDBFrame"
				src="${pageContext.request.contextPath }/styles/calloutLeft.svg"
			/>
		</div>
		<div id="editDBDiv">
			<div id="container">
				<div class="addDishText">
					<h3>Add dish</h3>
				</div>
				<div class="addLine1">
					<div id="dishNameText">Dish Name:</div>
					<div id="dishNameInput">
						<input
							name="dishName"
							type="text"
							maxlength=20
							form="addDishForm"
							required
						>
					</div>
					<div id="addButton">
						<button
							form="addDishForm"
							type="submit"
						>Add</button>
					</div>
				</div>
				<div id="addLine2">
					<div id="mainDishText">
						<label for="mainCheckBox">Is Main Dish:</label>
						<input
							id="mainCheckBox"
							type="checkbox"
							form="addDishForm"
							name="isMain"
							value="MainDish"
						>
					</div>
					<div id="unitsText">Units:</div>
					<div id="unitsSelect">
						<select
							name="unitsType"
							form="addDishForm"
						>
							<option value="items">Items</option>
							<option value="servings">Servings</option>
							<option value="lbs.">Pounds</option>
							<option value="cans">Cans</option>
						</select>
					</div>
				</div>
				<div id="removeText">
					<h3>Remove Dish</h3>
				</div>
				<div id="removeLine">
					<div class="dishDropdownText">Select dish:</div>
					<div class="dropdownDishes">
						<select
							style="position: absolute; width: 100%;"
							name="toRemove"
							form="removeDishForm"
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
							form="removeDishForm"
						>Remove</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>