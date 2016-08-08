<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Book input test</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Book added successfully</h1>
			</div>
		</div>
		
	</section>
	<section class="container">
		<div class="row">
			<p>Following book added:</p>
			<h3>${newBook.id}. ${newBook.authors}, <i>${newBook.title}</i></h3>
			<p>
				<a href="/webstore/books/add" class="btn btn-default"> 
					Submit another book
				</a>
				<a href="/webstore" class="btn btn-default"> 
					Home
				</a>
			</p>
		</div>
	</section>
</html>
