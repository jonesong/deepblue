<%@ include file="header.jsp" %>
<script src="<c:url value='/static/script/dialogbox.js' />"></script>

<main>
    <div id="content">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><fmt:message key="USERS_LAYOUT" /></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th><fmt:message key="USER_NAME" /></th>
				        <th><fmt:message key="USER_FIRSTNAME" /></th>
				        <th><fmt:message key="USER_LASTNAME" /></th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.username}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td><a href="<c:url value='/edit-user-${user.username}' />" class="btn btn-success custom-width"><fmt:message key="LABEL_EDIT" /></a></td>
						<td><a href="<c:url value='/delete-user-${user.username}' />" class="btn btn-danger custom-width" onclick="return confirmbox()"><fmt:message key="LABEL_DELETE" /></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	 	<div class="well">
	 		<a href="<c:url value='/newuser' />"><fmt:message key="USER_NEW" /></a>
	 	</div>
    </div>
</main>
   
<%@ include file="footer.jsp" %>