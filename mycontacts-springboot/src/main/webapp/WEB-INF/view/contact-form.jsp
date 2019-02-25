<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>  Save Contact </title>
<style type="text/css">
	.error{color:red}
</style>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath }/css/stye.css"/>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath }/css/add-contact-style.css"/>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>My Contacts - Spring Boot</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Contact</h3>

		<form:form action="saveContact" modelAttribute="contact" method="POST">

			<!-- associate this data with contact id -->

			<form:hidden path="id" />
			<table>
				<tbody> <!-- path attribs are setter methods as far as I remember -->
				<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				
				<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
 				
				<tr>
						<td><label>Telephone:</label></td>
						<td><form:input path="phone" /></td>
						<td><form:errors path="phone" cssClass="error" /><td>
				</tr>
				
				<tr>
						<td><label>  </label></td>
						<td><input type="submit" value="Save" class="save" /></td>
				</tr>
				
			</tbody>

		</table>
</form:form>
<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/contact/list">Back to List</a>
		</p>
	
</div>

</body>
</html>






