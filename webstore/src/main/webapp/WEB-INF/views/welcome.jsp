<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hello</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div align="right">
				<a href="<c:url value="j_spring_security_logout" />" class="btn btn-default"> Logout</a>
			</div>
			<div class="container">
				<h1>${greeting}</h1>
				<p>${info}</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<p>
				<a href="/webstore/books" class="btn btn-default"> Search books </a>
				<a href="/webstore/books/add" class="btn btn-default"> Add book </a>
				<a href="/webstore/login" class="btn btn-default"> Login </a>
			</p>
		</div>
	</section>
</body>
</html>
