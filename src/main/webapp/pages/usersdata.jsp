<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>

  <title>UsersData</title>


  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>

</head>
<body style="padding: 40px">
<h1>User Details</h1>

<table class="tg">
  <tr>
    <th width="80">ID</th>
    <th width="120">Login</th>
    <th width="120">Name</th>
    <th width="120">Surname</th>
    <th width="120">Alias</th>
    <th width="120">Email</th>
  </tr>
  <tr>
    <td>${user.id}</td>
    <td>${user.login}</td>
    <td>${user.name}</td>
    <td>${user.surname}</td>
    <td>${user.alias}</td>
    <td>${user.email}</td>
  </tr>
</table>


</body>
</html>