<%@ include file="../header.jsp"%>

<main>
<div class="panel panel-default">
	<div class="panel-heading"><fmt:message key="USER_NEW" /></div>
	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tbody>
				<tr>
					<td><fmt:message key="USER_NAME" /></td>
					<td><c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="username" id="username" disabled="true" />
							</c:when>
							<c:otherwise>
								<form:input type="text" path="username" id="username" autofocus="true" />
							</c:otherwise>
						</c:choose></td>
					<td><div class="has-error"><form:errors path="username" /></div></td>
				</tr>
				<tr>
					<td><fmt:message key="USER_PASS" /></td>
					<td><form:input type="password" path="password" id="password" /></td>
					<td><div class="has-error"><form:errors path="password" /></div></td>
				</tr>
				<tr>
					<td><fmt:message key="USER_FIRSTNAME" /></td>
					<td><form:input type="text" path="first_name" id="first_name" /></td>
					<td><div class="has-error"><form:errors path="first_name" /></div></td>
				</tr>
				<tr>
					<td><fmt:message key="USER_LASTNAME" /></td>
					<td><form:input type="text" path="last_name" id="last_name" /></td>
					<td><div class="has-error"><form:errors path="last_name" /></div></td>
				</tr>
				<tr>
					<td><c:choose>
							<c:when test="${edit}">
								<input class="setup" type="submit" value="<fmt:message key="LABEL_UPDATE" />" class="btn btn-success custom-width" /> 
							</c:when>
							<c:otherwise>
								<input class="setup" type="submit" value="<fmt:message key="LABEL_REGISTER" />" class="btn btn-success custom-width" />
							</c:otherwise>
						</c:choose></td>
					<td><a href="<c:url value='${WebPath.getLIST()}' />" class="btn btn-danger custom-width2"><c:choose><c:when test="${undo}"><fmt:message key="LABEL_UNDO" /></c:when>
					<c:otherwise><fmt:message key="LABEL_RETURNTO" /><fmt:message key="USERS_HEADING_ALL" /></c:otherwise></c:choose></a></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</div>
</main>

<%@ include file="../footer.jsp"%>