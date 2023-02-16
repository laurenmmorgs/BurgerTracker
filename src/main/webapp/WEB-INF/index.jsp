<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> Burger Tracker </h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Burger Name</th>
      <th scope="col">Rest Name</th>
      <th scope="col">Rating </th>
      <th scope="col">Actions </th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var= "burger" items = "${burgers}" >
    <tr class="table-primary">
      <th scope="row"><c:out  value="${burger.burgerName}"> </c:out> </th>
      <td><c:out  value="${burger.restName}"> </c:out> </td>
      <td><c:out  value="${burger.rating}"> </c:out></td>
      <td> <a href="/edit/${burger.id}">Edit </a><c:out  value="${burger.id}"> </c:out> </td>
    </tr>
	</c:forEach>




  </tbody>
</table>
<div class=container-fluid>
<h1> Add a Burger </h1>
<form:form action="/burger" method="post" modelAttribute="burger">
    <p>
        <form:label path="burgerName">Burger Name:</form:label>
        <form:errors path="burgerName"/>
        <form:input path="burgerName"/>
    </p>
    <p>
        <form:label path="restName">Restaurant Name: </form:label>
        <form:errors path="restName"/>
        <form:input path="restName"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>     
        <form:input type="number" path="rating"/>
    </p>    
  
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>