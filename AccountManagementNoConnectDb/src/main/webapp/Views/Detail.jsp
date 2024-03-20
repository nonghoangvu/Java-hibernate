<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/15/2024
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center text-danger text-uppercase">detail</h1>
    <form class="row g-3 mt-5" action="/admin/update" method="post">
        <div class="col-md-6 form-floating">
            <input type="number" class="form-control" id="id" name="id" required="required" value="${Account.id}">
            <label for="id">Identification Number</label>
        </div>
        <div class="col-md-6 form-floating">
            <input type="text" class="form-control" id="fullName" name="fullName" required="required" value="${Account.fullName}">
            <label for="fullName">FullName</label>
        </div>
        <div class="col-md-6 form-floating">
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required="required" value="${Account.dateOfBirth}">
            <label for="dateOfBirth">Date Of Birth</label>
        </div>
        <div class="col-md-6 form-floating">
            <select class="form-select" id="floatingSelectGrid" name="country">
                <c:forEach items="${countryList}" var="x">
                    <option ${Account.country == x? "selected":""} value="${x}">${x}</option>
                </c:forEach>
            </select>
            <label for="floatingSelectGrid">Country</label>
        </div>
        <div class="col-md-12">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="Male" value="true" ${Account.gender?"checked":""}>
                <label class="form-check-label" for="Male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="Female" value="false" ${!Account.gender?"checked":""}>
                <label class="form-check-label" for="Female">Female</label>
            </div>
        </div>
        <div class="col-md-12 text-start">
            <a href="/admin/home" class="btn btn-outline-danger">Cancel</a>
            <button type="submit" class="btn btn-outline-warning">Update</button>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
