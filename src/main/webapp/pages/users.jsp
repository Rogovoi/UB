<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Users</title>

</head>
<body style="padding: 30px">
<a href="/welcome" style="font-size: 20px">Back to profile</a>

<br/>
<br/>

<h1>Users List</h1>


<div class="table-scroll">
<table class="tg">
<c:if test="${!empty listUsers}">
    <tr>
      <th width="80">ID</th>
      <th width="120">Login</th>
      <th width="120">Name</th>
      <th width="120">Surname</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td><a href="/usersdata/${user.id}" target="_blank">${user.login}</a></td>
        <td>${user.name}</td>
        <td>${user.surname}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</div>

</body>

<style>
  <%@include file='../resources/css/usersstyle.css' %>
  <%@include file='../resources/css/bootstrap.min.css' %>
</style>
</html>
