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
	<c:forEach
		items="${dishList}"
		var="dish"
	>
		<div class="menuDivider"></div>
		<div class="dishDivider">
			<c:choose>
				<c:when test="${(dish.numDefined() == 0) || (dish == 1)}">
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
				<h5>${dish.dishName}</h5>
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
			<button class="markButton">Mark Values</button>
		</div>
	</c:forEach>
</div>
<div id="productionLabel">
	<h3>Production</h3>
</div>