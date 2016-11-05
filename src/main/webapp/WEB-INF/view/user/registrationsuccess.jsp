<%@ include file="../header.jsp" %>

<main>
    <div id="content">
	<p><c:choose>
		<c:when test="${newuser}"><fmt:message key="USER_SAVED"><fmt:param value="${success}" /></fmt:message></c:when>
		<c:otherwise><fmt:message key="USER_UPDATED"><fmt:param value="${success}" /></fmt:message></c:otherwise>
	</c:choose></p>
	<p><a href="<c:url value='${WebPath.getLIST()}' />"><fmt:message key="LABEL_RETURNTO" /><fmt:message key="USERS_HEADING_ALL" /></a></p>
	</div>
</main>

<%@ include file="../footer.jsp"%>