<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/14/2024
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nong Hoang Vu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center text-danger text-uppercase">Account management</h1>
    <form class="row g-3 mt-5" action="/admin/add" method="post">
        <div class="col-md-6 form-floating">
            <input type="number" class="form-control" id="id" name="id" required="required">
            <label for="id">Identification Number</label>
        </div>
        <div class="col-md-6 form-floating">
            <input type="text" class="form-control" id="fullName" name="fullName" required="required">
            <label for="fullName">FullName</label>
        </div>
        <div class="col-md-6 form-floating">
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required="required">
            <label for="dateOfBirth">Date Of Birth</label>
        </div>
        <div class="col-md-6 form-floating">
            <select class="form-select" id="floatingSelectGrid" name="country">
                <c:forEach items="${countryList}" var="x">
                    <option value="${x}">${x}</option>
                </c:forEach>
            </select>
            <label for="floatingSelectGrid">Country</label>
        </div>
        <div class="col-md-12">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="Male" value="true" checked>
                <label class="form-check-label" for="Male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="Female" value="false">
                <label class="form-check-label" for="Female">Female</label>
            </div>
        </div>
        <div class="col-md-12 text-start">
            <button type="submit" class="btn btn-outline-success">Add</button>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="/logout" class="btn btn-outline-danger">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="/logout" class="btn btn-outline-danger">Login</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="text-start">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <span class="text-success">Your email: ${sessionScope.user}</span>
                </c:when>
                <c:otherwise>
                    <span class="text-danger">Please login first!</span>
                </c:otherwise>
            </c:choose>
        </div>
    </form>
    <hr>
    <div class="container">
        <table class="table text-center table-light">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Image</th>
                <th scope="col">Identification Number</th>
                <th scope="col">FullName</th>
                <th scope="col">Gender</th>
                <th scope="col">Date Of Birth</th>
                <th scope="col">Country</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Accounts}" var="x" varStatus="i">
                <tr>
                    <th scope="row">${i.index + 1}</th>
                    <td><c:if test="${x.getAge() < 18}">
                        <img src="https://img.freepik.com/premium-photo/photo-little-baby-giving-thumbs-up-isolated-transparent-background_483949-1501.jpg"
                             class="rounded mx-auto d-block" alt="..." style="width: 50px">
                    </c:if>
                        <c:if test="${x.getAge() >= 18}">
                            <c:if test="${x.gender}">
                                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Elon_Musk_Royal_Society_%28crop1%29.jpg/250px-Elon_Musk_Royal_Society_%28crop1%29.jpg"
                                     class="rounded mx-auto d-block" alt="..." style="width: 50px">
                            </c:if>
                            <c:if test="${!x.gender}">
                                <img src="https://image-cdn.hypb.st/https%3A%2F%2Fhypebeast.com%2Fwp-content%2Fblogs.dir%2F6%2Ffiles%2F2021%2F09%2Fblackpink-rose-attending-met-gala-saint-laurent-nyc-1.jpg?cbr=1&q=90"
                                     class="rounded mx-auto d-block" alt="..." style="width: 50px">
                            </c:if>
                        </c:if>
                    </td>
                    <td>${x.id}</td>
                    <td>${x.fullName}</td>
                    <td>${x.gender?"Male":"Female"}</td>
                    <td>${x.dateOfBirth}</td>
                    <td>${x.country}</td>
                    <td>
                        <c:if test="${x.getAge() < 18}">
                            <span class="badge bg-danger">Baby</span>
                        </c:if>
                        <c:if test="${x.getAge() >= 18}">
                            <span class="badge bg-success">+18</span>
                        </c:if>
                    </td>
                    <td>
                        <a class="btn btn-danger" onclick="remove(${i.index})">Delete</a>
                        <a class="btn btn-primary" href="/admin/detail?index=${i.index}">View</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script>
    function remove(index) {
        let confirm = window.confirm("Are you sure delete this account?");
        if (confirm) {
            window.location.href = "/admin/delete?index=" + index;
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
