<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/13/2024
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Information</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <span>${person}</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <form action="trang-chu" method="post">
        <h1 class="text-center text-bg-danger">Home Page</h1>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" id="gender1" value="Male" checked>
            <label class="form-check-label" for="gender1">Male</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" id="gender2" value="Female">
            <label class="form-check-label" for="gender2">Female</label>
        </div>
        <select class="form-select mt-2" aria-label="Default select example" name="person" required="required">
            <option selected>Person</option>
            <c:forEach items="${value}" var="x">
                <option value="${x}">${x}</option>
            </c:forEach>
        </select>
        <div class="d-grid gap-2 d-md-block mt-3">
            <button class="btn btn-outline-success">Check</button>
            <button type="button" class="btn btn-outline-success" data-bs-toggle="modal"
                    data-bs-target="#exampleModal">
                Show information
            </button>
        </div>
    </form>
    <form action="validation" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name:</label>
            <input required="required" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="firstName">
            <div id="emailHelp" class="form-text">We'll never share your name with anyone else.</div>
            <button type="submit" class="btn btn-outline-success">Check</button>
        </div>
    </form>
</div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
