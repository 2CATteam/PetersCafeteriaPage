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
	href="${pageContext.request.contextPath}/styles/style.css"
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
				style="position: absolute; height: 9%; width: 11.5%; top: ${19 + 9.8 * positionScalar}%; left: 82%;"
				type="submit"
			>Mark Values</button>
		</form>
		<form
			action="${pageContext.request.contextPath}/MarkDish"
			method="post"
			id="addDishForm"
		></form>
		<div id="frameContainer">
			<img
				style="position: absolute; bottom: ${76 - 9.8 * positionScalar}%; right: 18%; height: 296px;"
				src="${pageContext.request.contextPath }/styles/calloutRight.svg"
			/>
		</div>
		<div style="position: absolute; top: ${24 + 9.8 * positionScalar}%; height: 85px; width: 545px; right: 18%;">
			<div style="position: absolute; height: 250px; width: 495px; bottom: 0; right: 50px;">
				<div class=markupLine>
					<div class="markupLabel">Amount Prepped (${dishToEdit.getUnits()}):</div>
					<div class="numberInput">
						<input
							style="width: 100%"
							type="number"
							form="addDishForm"
							name="updateAmountPrepped"
							value="${dishToEdit.getAmountPrepped()}"
						>
					</div>
					<div class="submitEdits">
						<button
							type="submit"
							form="addDishForm"
							name="dishNameToEdit"
							value="${dishToEdit.dishName}"
						>Mark</button>
					</div>
				</div>
				<div class=markupLine>
					<div class="markupLabel">Amount Left (${dishToEdit.getUnits()}):</div>
					<div class="numberInput">
						<input
							style="width: 100%"
							type="number"
							form="addDishForm"
							name="updateAmountLeft"
							value="${dishToEdit.getAmountLeft()}"
						>
					</div>
					<div class="submitEdits">
						<button
							type="submit"
							form="addDishForm"
							name="dishNameToEdit"
							value="${dishToEdit.dishName}"
						>Mark</button>
					</div>
				</div>
				<div class=markupLine>
					<div class="markupLabel">Temp Start (°):</div>
					<div class="numberInput">
						<input
							style="width: 100%"
							type="number"
							step="0.1"
							form="addDishForm"
							name="updateTempStart"
							value="${dishToEdit.getTempStart()}"
						>
					</div>
					<div class="submitEdits">
						<button
							type="submit"
							form="addDishForm"
							name="dishNameToEdit"
							value="${dishToEdit.dishName}"
						>Mark</button>
					</div>
				</div>
				<div class=markupLine>
					<div class="markupLabel">Temp End (°):</div>
					<div class="numberInput">
						<input
							style="width: 100%"
							type="number"
							step="0.1"
							form="addDishForm"
							name="updateTempEnd"
							value="${dishToEdit.getTempEnd()}"
						>
					</div>
					<div class="submitEdits">
						<button
							type="submit"
							form="addDishForm"
							name="dishNameToEdit"
							value="${dishToEdit.dishName}"
						>Mark</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>