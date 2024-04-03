<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_server_push_re_303w.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/product/store" id="newProductPost" method="post" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Add New Product</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input required type="text" class="form-control" id="maSanPham" name="maSanPham">
                            <label for="maSanPham">Enter the product code</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input required type="text" class="form-control" id="tenSanPham" name="tenSanPham">
                            <label for="tenSanPham">Enter a product name</label>
                        </div>
                    </div>
                    <div class="col-12 form-floating mb-3">
                        <select class="form-select" aria-label="Default select example" id="danhMuc" name="danhMuc">
                            <option value="" selected disabled>Open this select menu</option>
                            <c:forEach var="x" items="${listCategory}">
                                <option value="${x.id}">${x.tenDanhMuc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="Active" id="trangThai"
                                   name="trangThai">
                            <label class="form-check-label" for="trangThai">
                                Active
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/product/index" class="btn btn-outline-danger">Cancel</a>
                        <button type="button" onclick="saveOrUpdateProductValidate('newProductPost')" class="btn btn-outline-info">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>