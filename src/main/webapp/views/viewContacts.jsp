<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book</title>
	<link rel="stylesheet" type="text/css"
		href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
	<script>
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
		function deleteConfirm() {
			return confirm("Are you sure, you want to delete?");
		}
	</script>
</head>
<body>
	<a href="addContact">+Add new Contact</a>
	<p>
		<font color="red">${errMsg}</font>
	</p>
	<table id="myTable" border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Contact Name</th>
				<th>Contact Email</th>
				<th>Contact Number</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?cid=${c.contactId}">Edit</a> | <a
						href="deleteContact?cid=${c.contactId}" onclick="return deleteConfirm()">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>