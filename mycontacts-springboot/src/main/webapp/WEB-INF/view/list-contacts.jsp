<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> Contact List</title>
 
 <!-- reference our style sheet -->
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/css/style.css"/>

</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2> MyContacts - Spring Boot </h2>
	</div>
</div>
	
	<div id="container">
		<div id="content">
		
	<!-- add html table -->
	<table>
	
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Telephone</th>
		<th>Action</th>
	</tr>
	
	<!-- loop over and print contacts -->
				<c:forEach var="tempContact" items="${contacts}">
				
					<!-- construct an "update" link with contact id -->
				 	<c:url var="updateLink" value="/contact/showFormForUpdate">
						<c:param name="contactId" value="${tempContact.id}" />
					</c:url>				

					<!-- construct an "delete" link with contact id -->
		             <c:url var="deleteLink" value="/contact/delete">
						<c:param name="contactId" value="${tempContact.id}" />
					</c:url>					 	
				 					
					
					<tr> <!-- variables refers to getter methods as far as I remember -->
						<td> ${tempContact.firstName} </td>
						<td> ${tempContact.lastName} </td>
						<td> ${tempContact.phone} </td>
						<td> 
						
						<a href="${updateLink}">Update</a>
						
				<a href="${deleteLink}"
				onclick="if (!(confirm('Are you sure you want to delete this contact?'))) return false">Delete</a>
						
						</td>
						
					</tr>
				
				</c:forEach>
	
	</table>
	<br>
	<!-- put new button: Add contact -->
		<input type="button" value="Add Contact"
		onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
		</div>
	
	</div>
</body>

</html>