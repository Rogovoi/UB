<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <title>Welcome</title>

</head>

<body style="padding: 40px">

<div align="right">

    <a href="/admin" style="font-size: 20px; font-weight: bold">Admin mode</a>

</div>

<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>

        <h4>Please enter additional information about you</h4>
    </c:if>
</div>


<div class="table-scroll">
    <table class="tg">
    <c:if test="${!empty profile}">
        <tr>
            <th width="80">ID</th>
            <th width="120">Login</th>
            <th width="120">Password</th>
            <th width="120">Name</th>
            <th width="120">Surname</th>
            <th width="120">Alias</th>
            <th width="120">Email</th>
            <th width="120">Edit</th>
        </tr>
        <c:forEach items="${profile}" var="user">
            <c:if test="${pageContext.request.userPrincipal.name == user.login}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.alias}</td>
                    <td>${user.email}</td>
                    <td><a href="<c:url value='/editprofile/${user.id}'/>">Edit</a></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    </c:if>
</div>


<c:url var="addAction" value="/welcome/changedata"/>

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
            </td>
        </tr>
    </table>
</form:form>

<div>
    <br>
    <a href="/users" style="font-size: 20px">Users list</a>
    <br>
</div>


</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
    <%@include file='../resources/js/bootstrap.min.js' %>
</script>

<style>
    <%@include file='../resources/css/bootstrap.min.css' %>
    <%@include file='../resources/css/usersstyle.css' %>
</style>

</html>