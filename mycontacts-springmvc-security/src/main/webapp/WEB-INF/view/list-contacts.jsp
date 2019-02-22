<!-- need taglib for jsp. TODO: check details about jsp and taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

<head>
<title>Contact List</title>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>My Contacts - V1</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<p>
				<b>Welcome </b> <i> <security:authentication
						property="principal.username" />
				</i> <b>!</b>

				<!-- add html table -->
			<table>

				<tr>
					<th style="text-align: center;">First Name</th>
					<th style="text-align: center;">Last Name</th>
					<th style="text-align: center;">Telephone</th>
					<th style="text-align: center;">Operation</th>

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


					<tr>
						<td>${tempContact.firstName}</td>
						<td>${tempContact.lastName}</td>
						<td>${tempContact.telephone}</td>
						<security:authorize access="hasAnyRole('ADMIN', 'USER')">

							<td><security:authorize access="hasAnyRole('ADMIN', 'USER')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize> <security:authorize access="hasAnyRole('ADMIN', 'USER')">
									<a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete this contact?'))) return false">Delete</a>
								</security:authorize></td>

						</security:authorize>

					</tr>

				</c:forEach>
			</table>
		</div>

	</div>
	<br>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<div style="margin-top: 10px" class="form-group">
			<div class="col-sm-6 controls">
				<!-- put new button: Add Contact -->
				<input type="button" value="Add Contact" class="btn btn-primary"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
				<!-- Add a logout button -->
				<input type="submit" value="Logout" class="btn btn-primary" />
			</div>
		</div>
	</form:form>
</body>

</html>