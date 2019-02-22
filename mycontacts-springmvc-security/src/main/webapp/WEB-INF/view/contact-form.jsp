<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>  Save Contact </title>
<style type="text/css">
	.error{color:red}
</style>

<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath }/resources/css/style.css"/>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath }/resources/css/add-contact-style.css"/>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>My Contacts - V1</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Contact</h3>

		<form:form action="saveContact" modelAttribute="contact" method="POST">

			<!-- associate this data with contact id -->

			<form:hidden path="id" />
			 
			<table>
				<tbody>  
				<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /> 
						
						</td>
						<td><form:errors path="firstName" cssClass="error" /></td>
						
				</tr>
				
				<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" />
						
						</td>
						<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
 				
				<tr>
						<td><label>Telephone:</label></td>
						<td><form:input path="telephone" />
						</td>
						
						<td><form:errors path="telephone" cssClass="error" /><td>
				</tr>

				<tr>
						<td> </td>
						<td><input type="submit" value="Save" class="btn btn-primary"/></td>
				</tr>
				
			</tbody>

		</table>
</form:form>
<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/contact/list" class="btn btn-primary">Back to List</a>
		</p>
	
</div>

</body>
</html>
