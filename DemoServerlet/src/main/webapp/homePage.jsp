<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/8/2024
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>This is home page</h1>
<br>
<span>Fullname: ${value.fullName}</span>
<br>
<span>Age: ${value.age}</span>
<br>
<span>Major: ${value.major}</span>
<br>
<form action="/home" method="post">
    <input type="text" name="myName" placeholder="Enter your name">
    <button type="submit">Submit</button>
</form>
</body>
</html>
