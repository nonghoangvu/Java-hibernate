<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/9/2024
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h1 class="text-center">Update Employee</h1>
    <form action="edit?id=${emp.employeeId}" method="post">
        <div class="mb-3">
            <label for="firstName" class="form-label">FirstName:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="FirstName" value="${emp.firstName}">
        </div>
        <div class="mb-3">
            <label for="lastName" class="form-label">LastName:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="LastName" value="${emp.lastName}">
        </div>
        <div class="mb-3">
            <label for="department" class="form-label">Department:</label>
            <input type="text" class="form-control" id="department" name="department" placeholder="Department" value="${emp.department}">
        </div>
        <div class="mb-3">
            <label for="position" class="form-label">Position:</label>
            <input type="text" class="form-control" id="position" name="position" placeholder="Position" value="${emp.position}">
        </div>
        <div class="mb-3">
            <label for="salary" class="form-label">Salary:</label>
            <input type="number" class="form-control" id="salary" name="salary" placeholder="Salary" value="${emp.salary}">
        </div>
        <div class="text-center">
            <a class="btn btn-danger" href="admin">Cancel</a>
            <button class="btn btn-success" type="submit">Update</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>