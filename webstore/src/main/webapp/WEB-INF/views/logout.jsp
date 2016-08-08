<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Logout</title>
</head>
<body>
<!-- 	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<h2>You have finally logged out, contratulations!</h2>
					<h3>Messages, whatever.</h3>
				</div>
			</div>
		</div>
	</div> -->
	<section>
		<div class="jumbotron">
			<div align="right">
				<a href="<c:url value="j_spring_security_logout" />" class="btn btn-default"> Logout</a>
			</div>
			<div class="container">
				<h1>Messages, whatever.</h1>
				<p>You have finally logged out, contratulations!</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<p>
				<a href="/webstore" class="btn btn-default"> Home screen </a>
			</p>
		</div>
	</section>
</body>