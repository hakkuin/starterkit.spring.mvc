<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
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


			<div class="panel panel-default" style="width: 400px">
				<div class="panel-body">
					<form action="/webstore/books/by-title-and-authors">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Title"
									name='title' type="text">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Authors"
									name='authors' type="text" value="">
							</div>
							<input type="submit" value="Submit">
						</fieldset>
					</form>
				</div>
			</div>

			<div class="panel-body">
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
		</div>
	</section>
	<section class="container">
		<c:if test="${not empty bookList}">
			<ul>
				<c:forEach var="bookValue" items="${bookList}">
					<h3>${bookValue.id}. ${bookValue.authors}, <i>${bookValue.title}</i></h3>
					<p>
						status: ${bookValue.status}
					</p>
					<a href="/webstore/books/book?id=${bookValue.id}" class="btn btn-default"> 
						Show details
					</a>
					<a href="/webstore/books/delete?id=${bookValue.id}" class="btn btn-default"> 
						Delete book
					</a>
				</c:forEach>
			</ul>
		</c:if>
	</section>
</body>
</html>
