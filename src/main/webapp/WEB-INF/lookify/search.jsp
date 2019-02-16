<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search</title>
</head>
<body>
	
	<a href="/dashboard" >Dashboard</a>
		
	<form action="/search" method="post">
   		<input type="text" name="artist">
    	<button type="submit" >Search Artists</button>
	</form> 
	
	
	<h2>Songs by artist: <c:out value="${artist}"/></h2>
	
	<table>
    <thead>
        <tr>
	        <th>Name</th>
	        <th>Rating</th>
	        <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        
        <tr>
            <td><a href="/song/<c:out value='${song.id}'/>"><c:out value="${song.name}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td>
            	<form action="/delete/${song.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	


</body>
</html>