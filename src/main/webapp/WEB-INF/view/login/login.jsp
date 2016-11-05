<%@ include file="../header.jsp" %>

<main>
	<div id="content">
    <form:form method="POST" modelAttribute="user" id="loginForm">
    	<form:input type="hidden" path="first_name" id="first_name" value="H" /><form:input type="hidden" path="last_name" id="last_name" value="H" />
    	<c:if test="${authenticationFailed}">
    		<p class="bad notification"><fmt:message key="LOGIN_AUTH_FAILED" /></p>
    	</c:if>
    	<c:if test="${authenticationSucceeded}">
    		<p class="good notification"><fmt:message key="LOGIN_AUTH_SUCCEEDED"><fmt:param value="${currentUser}" /></fmt:message></p>
    	</c:if>
    	<c:if test="${loggedOut}">
    		<p class="notification"><fmt:message key="LOGIN_LOGGED_OUT" /></p>
    	</c:if>
    	<c:if test="${!authenticationSucceeded}">
    	<h1><fmt:message key="LOGIN_HEADING" /></h1>
    	<p><fmt:message key="LOGIN_INSTRUCTIONS" /></p>
    	<label><fmt:message key="LOGIN_LABEL_USERNAME" /></label>
    	<form:input type="text" path="username" id="username" autofocus="true" />
    	<div class="has-error"><form:errors path="username" /></div>
    	<label><fmt:message key="LOGIN_LABEL_PASSWORD" /></label>
    	<form:input type="password" path="password" id="password" />
    	<div class="has-error"><form:errors path="password" /></div>
    	<p><input type="submit" value="<fmt:message key="LOGIN_BUTTON_LOGIN" />" /></p>
    	</c:if>
    </form:form>
    </div>
</main>
   
<%@ include file="../footer.jsp" %>