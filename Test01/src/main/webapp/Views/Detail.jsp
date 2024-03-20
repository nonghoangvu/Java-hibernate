<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/18/2024
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/update" method="post">
    <div class="mb-3">
        <label class="form-label">Ma nhan vien</label>
        <input type="text" class="form-control" id="manv" aria-describedby="emailHelp" name="maNhanVien"
               value="${NhanVien.maNhanVien}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten nhan vien</label>
        <input type="text" class="form-control" id="ten" aria-describedby="emailHelp" name="tenNhanVien"
               value="${NhanVien.tenNhanVien}">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia chi</label>
        <input type="text" class="form-control" id="diaChi" aria-describedby="emailHelp" name="diaChi"
               value="${NhanVien.diaChi}">
    </div>
    <div class="mb-3">
        <label class="form-label">Tuoi</label>
        <input type="number" class="form-control" id="tuoi" aria-describedby="emailHelp" name="tuoi"
               value="${NhanVien.tuoi}">
    </div>
    <div class="mb-3">
        <label class="form-label">Phong ban</label>
        <select class="form-select" aria-label="Default select example" name="phongBan">
            <option selected>Open this select menu</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Gioi tinh</label>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1"
                   value="true" ${NhanVien.gioiTinh? "checked": ""}>
            <label class="form-check-label" for="inlineRadio1">Nam</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2"
                   value="false" ${NhanVien.gioiTinh ? "": "checked"}>
            <label class="form-check-label" for="inlineRadio2">Nu</label>
        </div>
    </div>
    <div class="text-start">
        <button type="submit" class="btn btn-primary">Update</button>
    </div>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
