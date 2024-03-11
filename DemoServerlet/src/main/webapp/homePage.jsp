<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/8/2024
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>This is home page</h1>
<br>
<select class="form-select" aria-label="Default select example">
    <c:forEach items="${listVu}" var="x">
        <option value="${x.fullName}">${x.fullName}</option>
    </c:forEach>
</select>
<c:forEach items="${listVu}" var="x" varStatus="i">
    <p>${i.index}</p>
    <p>${x.fullName}</p>
</c:forEach>
</body>
</html>
