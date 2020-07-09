<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	<script>
	$(function() {
		  $("form[name='saveContact']").validate({
		    rules: {
		      contactName: "required",
		      contactEmail: email: true,
		      contactNumber: {
		        maxlength: 15
		      }
		    },
		    messages: {
		      contactName: "Please enter name",
		      password: {
		        maxlength: "Phone number max length is 10"
		      },
		      email: "Please enter a valid email address"
		    },
		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
	</script>
</head>
<body>
	<h2>Save Contact</h2>
	<p>
		<font color="green">${succMsg}</font>
	</p>
	<p>
		<font color="red">${errMsg}</font>
	</p>
	<form:form action="saveContact" method="post" modelAttribute="contact" name="saveContact">
		<table>
			<tbody>
				<tr>
					<form:hidden path="contactId" />
					<td>Contact Name:</td>
					<td><form:input path="contactName" id="contactName" name="contactName"/></td>
				</tr>
				<tr>
					<td>Contact Email:</td>
					<td><form:input path="contactEmail" id="contactEmail" /></td>
				</tr>
				<tr>
					<td>Contact Number:</td>
					<td><form:input path="contactNumber" id="contactNumber"/></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="save" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="viewContacts">View All Contacts</a>
</body>
</html>