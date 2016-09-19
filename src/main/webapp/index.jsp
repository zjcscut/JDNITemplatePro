<%--
  Created by IntelliJ IDEA.
  User: zhangjinci
  Date: 2016/9/19
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JNDI测试</title>
    <meta charset="UTF-8"/>
    <style type="text/css">
        table {
            border: solid 1px;
        }

        tr {
            border: solid 1px;
        }

        td {
            border: solid 1px;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>BIRTH</td>
    </tr>
    </thead>
    <tbody>
    <tr>
      <c:forEach var="item" items="${users}">
          <td>${item.id}</td>
          <td>${item.name}</td>
          <td>${item.birth}</td>
      </c:forEach>
    </tr>
    </tbody>
</table>

</body>
</html>
