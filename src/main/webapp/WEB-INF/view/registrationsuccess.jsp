<%@ include file="header.jsp" %>

<main>
    <div id="content">
	<p>${success}</p>
	<p>Go to <a href="<c:url value='/list' />"><fmt:message key="LABEL_RETURNTO" /><fmt:message key="USERS_HEADING_ALL" /></a></p>
	</div>
</main>

<%@ include file="footer.jsp"%>