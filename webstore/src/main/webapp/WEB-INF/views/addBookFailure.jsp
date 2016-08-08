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
				<h1>Book addition failed!</h1>
				<p>We do not accept ghost-books, add a book which has valid title and authors.</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<p>
				<a href="/webstore" class="btn btn-default"> Home screen </a>
				<a href="/webstore/books/add" class="btn btn-default"> Submit another book </a>
			</p>
		</div>
	</section>
</body>
</html>