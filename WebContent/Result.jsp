<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="default.css" rel="stylesheet" type="text/css">
<title>TrainTimer - Getting you there!</title>
<body>
	<div id="header">
		<div id="logo">
			<h1><a href="/">TrainTimer</a></h1>
			<h2>Getting You There!</h2>
			<h2>
				<br />
				<a href="About.html">About the Project</a>
			</h2>
		</div>
		<div id="menu">
			<br /> Cloud Computing <br /> Keith Kelly<br /> BSCHE4<br />
			09104844
		</div>
	</div>
	<div id="content">
		<div id="colOne">
			<table border="1" style="text-align: center">
				<tr>
					<th />
					<th>Information</th>
					<th>Due in</th>
				</tr>
				<c:forEach items="${results}" var="train">
					<tr>
						<td><img src="images/train.png" width="30" height="30" /></td>
						<td width="70%">Dart traveling <c:out
								value="${train.getDir()}" /> going to <c:out
								value="${train.getDes()}" /> has <c:out
								value="${train.getLastLoc()}" />. <br /></td>
						<td><c:out value="${train.getDue()}" /> Minutes<br />
						<br /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer">
		<p></p>
	</div>
</body>
</html>