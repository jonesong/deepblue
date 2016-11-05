<%@ include file="../header.jsp" %>

<main>
    <div id="content">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><fmt:message key="MODULES_LAYOUT" /></div>
			<table>
	    		<thead>
		      		<tr>
				        <th><fmt:message key="MODULE_NAME" /></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${modules}" var="module">
					<tr>
						<td>${module.name}</td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
    </div>
</main>
   
<%@ include file="../footer.jsp" %>