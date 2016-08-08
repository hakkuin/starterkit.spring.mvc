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
			<div class="container">
				<h1>Book removed successfully!</h1>
			</div>
		</div>
		
	</section>
	<section class="container">
		<div class="row">
			<p>
				<a href="/webstore/books/all" class="btn btn-default"> 
					Show all books
				</a>
				<a href="/webstore/books/search" class="btn btn-default"> 
					Search books
				</a>
				<a href="/webstore" class="btn btn-default"> 
					Home
				</a>
			</p>
		</div>
	</section>
</body>
</html>
