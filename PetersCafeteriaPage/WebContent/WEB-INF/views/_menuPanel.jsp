<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<div id="leftPanel">
	<c:forEach
		items="${dishList}"
		var="dish"
	>
		<div class="menuDivider"></div>
		<div class="dishDivider">
			<div class="menuBox">
				<h5>${dish.dishName}</h5>
				<p>Last Made/Left/Used (${dish.getUnits()}): ${dish.lastServed().getAmountPrepped()}/${dish.lastServed().getAmountLeft()}/${dish.lastServed().getAmountPrepped()-dish.lastServed().getAmountLeft()}</p>
				<p>Last Start/End Temp(°): ${dish.lastServed().getTempStart()}/${dish.lastServed().getTempEnd()}</p>
			</div>
			<c:if test="${dish.isMain() && (dish.lastServedWith() != null)}">
				<div class="mainMarker">
					<p>Last Served with ${dish.lastServedWith().dishName} on ${shorthandFormatter.format(dish.lastServedWith().dateMade)}</p>
				</div>
			</c:if>
		</div>
	</c:forEach>
</div>
<div id="menuLabel">
	<h3>Menu History</h3>
</div>