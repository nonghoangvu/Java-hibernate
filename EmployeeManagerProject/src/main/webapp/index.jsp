<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="admin?index=0">Go to employee management here!</a>
<c:set var="numA" value="1" scope="page"/>
Number A is <c:out value="${numA}"/>
</body>
</html>