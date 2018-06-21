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
<title>Changing Day</title>
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
				id="fakeChangeDayButton"
				type="submit"
			>Change day and meal</button>
		</form>
		<form
			action="${pageContext.request.contextPath}/ChangeDay"
			method="post"
			id="changeDayForm"
		></form>
		<div id="frameContainer">
			<img
				id="changeDayFrame"
				src="${pageContext.request.contextPath }/styles/calloutLeft.svg"
			/>
		</div>
		<div id="changeDayDiv">
			<div id="container">
				<div class="addDishText">
					<h3>Set Day</h3>
				</div>
				<div id="datePickerBox">
					<select
						class="datePickers"
						name="month"
						form="changeDayForm"
					>
						<c:forEach
							items="${sessionScope.monthsArray}"
							var="month"
						>
							<c:choose>
								<c:when test="${month.number == sessionScope.month}">
									<option
										value="${month.number}"
										selected
									>${month.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${month.number}">${month.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select
						class="datePickers"
						name="day"
						form="changeDayForm"
					>
						<c:forEach
							items="${sessionScope.daysArray }"
							var="day"
						>
							<c:choose>
								<c:when test="${day == sessionScope.day}">
									<option
										value="${day}"
										selected
									>${day}</option>
								</c:when>
								<c:otherwise>
									<option value="${day}">${day}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select
						class="datePickers"
						name="year"
						form="changeDayForm"
					><c:forEach
							items="${sessionScope.yearsArray }"
							var="year"
						>
							<c:choose>
								<c:when test="${year == sessionScope.year}">
									<option
										value="${year}"
										selected
									>${year}</option>
								</c:when>
								<c:otherwise>
									<option value="${year}">${year}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div id="lunchBox">
					<input
						form="changeDayForm"
						type="radio"
						name="isLunch"
						value="true"
						checked
					>
					Lunch
					<br>
					<input
						form="changeDayForm"
						type="radio"
						name="isLunch"
						value="false"
					>
					Breakfast
					<br>
				</div>
				<div id="submitDayButton">
					<button
						type="submit"
						form="changeDayForm"
					>OK</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>