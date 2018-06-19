<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<div id="rightPanel">
	<form
		action="${pageContext.request.contextPath}/EditDish"
		method="post"
		id="editDishForm"
	></form>
	<c:forEach
		items="${sessionScope.dishList}"
		var="dish"
	>
		<div class="menuDivider"></div>
		<div class="dishDivider">
			<c:choose>
				<c:when test="${(dish.numDefined() == 0) || (dish.numDefined() == 1)}">
					<c:set
						var="classToUse"
						value="redBox"
					></c:set>
				</c:when>
				<c:when test="${(dish.numDefined() == 2) || (dish.numDefined() == 3)}">
					<c:set
						var="classToUse"
						value="yellowBox"
					></c:set>
				</c:when>
				<c:otherwise>
					<c:set
						var="classToUse"
						value="greenBox"
					></c:set>
				</c:otherwise>
			</c:choose>
			<div class="${classToUse}">
				<h3>${dish.dishName}</h3>
				<p>
					<c:if test="${dish.getAmountPrepped() != null}">
					Made ${dish.getAmountPrepped()} ${dish.getUnits()}, 
				</c:if>
					<c:if test="${dish.getAmountLeft() != null}">
					${dish.getAmountLeft()} ${dish.getUnits()} left
				</c:if>
				</p>
				<p>
					<c:if test="${dish.getTempStart() != null}">
					Start at ${dish.getTempStart()}°, 
				</c:if>
					<c:if test="${dish.getTempEnd() != null}">
					${dish.getTempEnd()}° end
				</c:if>
				</p>
			</div>
			<button
				class="markButton"
				type="submit"
				form="editDishForm"
				name="dishToEdit"
				value="${dish.dishName}"
			>Mark Values</button>
		</div>
	</c:forEach>
</div>
<div id="productionLabel">
	<h3>Production</h3>
</div>