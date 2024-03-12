<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/9/2024
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Employee Management</h1>
    <div class="text-end">
        <a class="btn btn-outline-success" href="add">New</a>
    </div>
    <div>
        <table class="table text-center">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">EmployeeID</th>
                <th scope="col">FirstName</th>
                <th scope="col">LastName</th>
                <th scope="col">Department</th>
                <th scope="col">Position</th>
                <th scope="col">Salary</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employee}" var="emp" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${emp.employeeId}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.department}</td>
                    <td>${emp.position}</td>
                    <td>${emp.salary}</td>
                    <td>
                        <a class="btn btn-warning" href="edit?id=${emp.employeeId}">Edit</a>
                        <a class="btn btn-danger" onclick="askDel(${emp.employeeId})">Delete</a>
                        <a class="btn btn-primary" href="detail?id=${emp.employeeId}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function askDel(id) {
        let conf = window.confirm("Are you sure you want to delete this employee");
        if (conf) {
            window.location.href = "delete?id=" + id;
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
