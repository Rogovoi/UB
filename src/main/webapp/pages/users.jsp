<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Users</title>

  <%--<style>--%>
    <%--<%@include file='../resources/css/usersstyle.css' %>--%>
    <%--<%@include file='../resources/css/bootstrap.min.css' %>--%>
  <%--</style>--%>

</head>
<body>
<a href="../../index.html">Back to main menu</a>

<br/>
<br/>

<h1>Users List</h1>


<div class="table-scroll">
<table class="tg">
<c:if test="${!empty listUsers}">
    <tr>
      <th width="80">ID</th>
      <th width="120">Login</th>
      <th width="120">Password</th>
      <th width="120">Name</th>
      <th width="120">Surname</th>
      <th width="120">Alias</th>
      <th width="120">Email</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td><a href="/usersdata/${user.id}" target="_blank">${user.login}</a></td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.alias}</td>
        <td>${user.email}</td>
        <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</div>

<h1>Edit a User</h1>


<c:url var="addAction" value="/users/add"/>

<form:form action="${addAction}" commandName="user">
  <table class="edits">
    <c:if test="${!empty user.login}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="id"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8" disabled="true"/>
          <form:hidden path="id"/>
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="login">
          <spring:message text="Login"/>
        </form:label>
      </td>
      <td>
        <form:input path="login"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="password">
          <spring:message text="Password"/>
        </form:label>
      </td>
      <td>
        <form:input path="password"/>
      </td>
    </tr>
    <tr>
    <tr>
      <td>
        <form:label path="name">
          <spring:message text="Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="name"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="surname">
          <spring:message text="Surname"/>
        </form:label>
      </td>
      <td>
        <form:input path="surname"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="alias">
          <spring:message text="Alias"/>
        </form:label>
      </td>
      <td>
        <form:input path="alias"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="email">
          <spring:message text="Email"/>
        </form:label>
      </td>
      <td>
        <form:input path="email"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty user.login}">
          <input type="submit"
                 value="<spring:message text="Edit User"/>"/>
        </c:if>
        <c:if test="${empty user.login}">
          <input type="submit"
                 value="<spring:message text="Add User"/>"/>
        </c:if>
      </td>
    </tr>
  </table>
</form:form>

</body>

<style>
  <%@include file='../resources/css/usersstyle.css' %>
  <%@include file='../resources/css/bootstrap.min.css' %>
</style>
</html>
