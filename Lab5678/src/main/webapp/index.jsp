<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1 class="text-center">Danh Sach Books</h1>
    <div>
        <form action="/add" id="add" method="post">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="maSach" name="maSach">
                <label for="maSach">Ma Sach</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="tenSach" name="tenSach">
                <label for="tenSach">Ten Sach</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="tacGia" name="tacGia">
                <label for="tacGia">Tac gia</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="namXuatBan" name="namXuatBan">
                <label for="namXuatBan">Nam xuat ban</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="soLuong" name="soLuong">
                <label for="soLuong">So luong</label>
            </div>
            <button type="button" onclick="save()" class="btn btn-outline-success">Add</button>
        </form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Ma</th>
                <th scope="col">Ten</th>
                <th scope="col">Tac gia</th>
                <th scope="col">Nam xuat ban</th>
                <th scope="col">So luong</th>
                <th scope="col">Thao tac</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="i" items="${listSach}">
                <tr>
                    <th scope="row">${i.id}</th>
                    <td>${i.maSach}</td>
                    <td>${i.tenSach}</td>
                    <td>${i.tacGia}</td>
                    <td>${i.namXuatBan}</td>
                    <td>${i.soLuong}</td>
                    <td>
                        <button onclick="delte(${i.id})" class="btn btn-outline-danger">Delete</button>
                        <a href="/detail?id=${i.id}" class="btn btn-outline-info">Detail</a>
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
<script>
    function delte(id){
        let confirm = this.window.confirm("Ban co muon xoa hong??");
        if(confirm){
            this.window.location.href = "/delete?id=" + id;
            alert("Xoa thanh cong!")
        }
    }
    function save(){
        let soLuong = document.getElementById("soLuong").value;
        if(soLuong < 10){
            alert("So luong khong hop le!")
            return false;
        }
        document.getElementById("add").submit();
        alert("Them thanh cong")
    }
</script>
</html>
