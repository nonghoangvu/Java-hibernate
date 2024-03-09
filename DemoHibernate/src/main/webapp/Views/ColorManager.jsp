<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/8/2024
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello world</h1>
<c:forEach items="${listColor}" var="col">
    <span>${col.loaiMau}</span>
    <br>
</c:forEach>
</body>
</html>
