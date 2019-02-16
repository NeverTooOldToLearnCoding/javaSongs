<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h2>Top Ten Songs:</h2>
	<table>
	    <tbody>
	        <c:forEach items="${topTen}" var="song">
	        <tr>
	        	<td><c:out value="${song.rating}"/></td>
	            <td><a href="/song/<c:out value='${song.id}'/>"><c:out value="${song.name}"/></a></td>      
	            <td><c:out value="${song.artist}"/></td>                 
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>