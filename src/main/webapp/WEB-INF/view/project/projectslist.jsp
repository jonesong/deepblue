<%@ include file="../header.jsp" %>
<script src="<c:url value='/static/script/dialogbox.js' />"></script>

<main>
    <div id="content">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><fmt:message key="PROJECTS_LAYOUT" /></div>
			<table>
	    		<thead>
		      		<tr>
				        <th><fmt:message key="PROJECT_NAME" /></th>
				        <th><fmt:message key="PROJECT_NOTE" /></th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${projects}" var="project">
					<tr>
						<td>${project.name}</td>
						<td>${project.note}</td>
						<td><a href="<c:url value='${WebPath.getEDIT_PROJECT()}${project.id}' />" class="btn btn-success custom-width"><fmt:message key="LABEL_EDIT" /></a></td>
						<td><a href="<c:url value='${WebPath.getDEL_PROJECT()}${project.id}' />" class="btn btn-danger custom-width" onclick="return confirmbox()"><fmt:message key="LABEL_DELETE" /></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	 	<div class="well">
	 		<a href="<c:url value='${WebPath.getNEW_PROJECT()}' />"><fmt:message key="PROJECT_NEW" /></a>
	 	</div>
    </div>
</main>
   
<%@ include file="../footer.jsp" %>