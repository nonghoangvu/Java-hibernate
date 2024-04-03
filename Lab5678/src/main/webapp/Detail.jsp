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
    <div class="container">
        <div class="form-floating mb-3">
            <input disabled type="text" class="form-control" id="maSach" name="maSach" value="${s.maSach}">
            <label for="maSach">Ma Sach</label>
        </div>
        <div class="form-floating mb-3">
            <input disabled type="text" class="form-control" id="tenSach" name="tenSach" value="${s.tenSach}">
            <label for="tenSach">Ten Sach</label>
        </div>
        <div class="form-floating mb-3">
            <input disabled type="text" class="form-control" id="tacGia" name="tacGia" value="${s.tacGia}">
            <label for="tacGia">Tac gia</label>
        </div>
        <div class="form-floating mb-3">
            <input disabled type="number" class="form-control" id="namXuatBan" name="namXuatBan" value="${s.namXuatBan}">
            <label for="namXuatBan">Nam xuat ban</label>
        </div>
        <div class="form-floating mb-3">
            <input disabled type="number" class="form-control" id="soLuong" name="soLuong" value="${s.soLuong}">
            <label for="soLuong">So luong</label>
        </div>
        <a href="/hien-thi" class="btn btn-danger">Cancel</a>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
