<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_cloud_files_wmo8.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/product/update?id=${product.id}" method="post" id="updateProductPost" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Update Product</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <fmt:formatDate value="${product.ngaySua}" pattern="dd-MM-yyyy HH:mm:ss" var="editDate"/>
                            <span>Last edited: ${editDate}</span>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="maSanPham" name="maSanPham"
                                   value="${product.maSanPham}">
                            <label for="maSanPham">Enter the product code</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham"
                                   value="${product.tenSanPham}">
                            <label for="tenSanPham">Enter a product name</label>
                        </div>
                    </div>
                    <div class="col-12 form-floating mb-3">
                        <select class="form-select" aria-label="Default select example" id="danhMuc" name="danhMuc">
                            <option value="" selected disabled>Open this select menu</option>
                            <c:forEach var="x" items="${listCategory}">
                                <option ${product.danhMuc.tenDanhMuc == x.tenDanhMuc ? "selected" : ""}
                                        value="${x.id}">${x.tenDanhMuc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="Activity"
                                   id="trangThai" ${product.trangThai == "Activity" ? "checked" : ""}
                                   name="trangThai">
                            <label class="form-check-label" for="trangThai">
                                Activity
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/product/index" class="btn btn-outline-danger">Cancel</a>
                        <button type="button" onclick="saveOrUpdateProductValidate('updateProductPost')" class="btn btn-outline-info">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>