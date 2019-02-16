<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song Details</title>
</head>
<body>
	<a href="/dashboard" >Dashboard</a>	
		<p>Name: <c:out value="${song.name}"/></p>
		<p>Artist: <c:out value="${song.artist}"/></p>
		<p>Rating (1-10): <c:out value="${song.rating}"/></p>				
		<form action="/delete/${song.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
		</form>
</body>
</html>