<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <form action="/san-pham/add" method="post">
        <div class="mb-3">
            <label for="ma" class="form-label">Ma san pham</label>
            <input type="text" class="form-control" id="ma" aria-describedby="emailHelp" name="maSanPham">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Ten san pham</label>
            <input type="text" class="form-control" id="ma" aria-describedby="emailHelp" name="tenSanPham">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">So luong ton</label>
            <input type="number" class="form-control" id="ma" aria-describedby="emailHelp" name="soLuong">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Gia ban</label>
            <input type="number" class="form-control" id="ma" aria-describedby="emailHelp" name="giaBan">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Danh muc</label>
            <select class="form-select" aria-label="Default select example" name="danhMuc">
                <c:forEach var="c" items="${listDanhMuc}">
                    <option value="${c}">${c}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Trang thai</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio1"
                       value="true" checked>
                <label class="form-check-label" for="inlineRadio1">Con hang</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio2"
                       value="false">
                <label class="form-check-label" for="inlineRadio2">Het hang</label>
            </div>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
    <form action="/san-pham/search" method="post">
        <div class="mb-3">
            <label for="ma" class="form-label">Ten san pham</label>
            <input type="text" class="form-control" id="ma" aria-describedby="emailHelp" name="searchName">
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Tim kiem</button>
        </div>
    </form>
    <h1>Danh sach san pham</h1>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Ma san pham</th>
                <th scope="col">Ten san pham</th>
                <th scope="col">So luong ton</th>
                <th scope="col">Gia ban</th>
                <th scope="col">Danh muc</th>
                <th scope="col">Chuc nang</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${check}">
                <tr>
                    <td>Danh sach trong</td>
                </tr>
            </c:if>
            <c:forEach varStatus="i" items="${listSanPham}" var="x">
                <tr>
                    <th scope="row">${i.index + 1}</th>
                    <td>${x.maSanPham}</td>
                    <td>${x.tenSanPham}</td>
                    <td>${x.soLuong}</td>
                    <td>${x.giaBan}</td>
                    <td>${x.danhMuc}</td>
                    <td>${x.trangThai? "Con hang": "Het hang"}</td>
                    <td>
                        <a href="/san-pham/delete?index=${i.index}" class="btn btn-danger">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>