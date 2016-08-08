<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Book search</title>
</head>
<body>
	<fieldset>
		<div class="form-group">
			<input class="form-control" placeholder="User"
				name='j_username' type="text">
		</div>
		<div class="form-group">
			<input class="form-control" placeholder="password"
				name='j_password' type="password" value="">
		</div>
		<input class="btn btn-lg btn-success btn-block" type="submit"
			value="Submit">
	</fieldset>
</body>
</html>
