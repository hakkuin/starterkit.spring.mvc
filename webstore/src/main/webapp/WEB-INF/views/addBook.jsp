<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<html xmlns:th="http://www.thymeleaf.org">
<title>Hello</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div align="right">
				<a href="<c:url value="j_spring_security_logout" />" class="btn btn-default"> Logout</a>
			</div>
			<div class="container">
				<h1>Add new book</h1>
				<p>Type title and authors to add new book</p>
			</div>
		</div>
		
	</section>
	<section class="container">
		<div class="row">
		 	<form:form method="post" modelAttribute="newBook">
				<p>Title: <form:input path="title" type="text" /></p>
				<p>Authors: <form:input path="authors" type="text" /></p>
				<form:errors path="title" />
				<form:errors path="authors" />
				<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
			</form:form>
			<p>
				<a href="/webstore" class="btn btn-default"> 
					Home
				</a>
			</p>
		</div>
	</section>
</body>
</html>