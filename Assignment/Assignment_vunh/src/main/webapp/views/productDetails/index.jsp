<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container py-2 bg-white rounded shadow">
    <div class="mb-3 mt-3">
        <a class="btn btn-outline-danger" href="/product/index">Back</a>
        <button class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#newProductDetail">New
            product detail
        </button>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-bordered">
                <thead>
                <tr class="text-center">
                    <th scope="col">ID</th>
                    <th scope="col">Color</th>
                    <th scope="col">Size</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="i">
                    <tr class="text-center">
                        <th class="text-center" scope="row">${i.id}</th>
                        <td>${i.mauSac.tenMau}</td>
                        <td>${i.size.tenSize}</td>
                        <td>${i.giaBan}</td>
                        <td>${i.soLuongTon}</td>
                        <td>
                            <c:if test="${i.trangThai == 'Activity'}">
                                <span class="badge rounded-pill text-bg-success">Activity</span>
                            </c:if>
                            <c:if test="${i.trangThai == 'Inactive'}">
                                <span class="badge rounded-pill text-bg-danger">Inactive</span>
                            </c:if>
                        </td>
                        <td class="text-center">
                            <a href="/product-detail/edit?id=${i.id}" class="btn btn-outline-warning border-white"><i
                                    class="bi bi-pencil-square"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="newProductDetail" tabindex="-1" aria-labelledby="newProductDetail" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">Add new product detail</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="productDetailPost" method="post" action="/product-detail/store?id=${id}" class="row">
                    <div class="col-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" aria-label="Default select example" id="size" name="size"
                                    required>
                                <option selected value="" disabled>Size</option>
                                <c:forEach items="${listSize}" var="size">
                                    <option value="${size.id}">${size.tenSize}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" aria-label="Default select example" id="mauSac" name="mauSac"
                                    required>
                                <option selected value="" disabled>Color</option>
                                <c:forEach items="${listColor}" var="color">
                                    <option value="${color.id}">${color.tenMau}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" id="giaBan" name="giaBan" required>
                            <label for="giaBan">Price</label>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" id="soLuongTon" name="soLuongTon" required>
                            <label for="soLuongTon">Quantity</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="Activity" id="trangThai"
                                       name="trangThai">
                                <label class="form-check-label" for="trangThai">
                                    Activity
                                </label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" onclick="saveProductDetailValidate('productDetailPost')" class="btn btn-success">
                    Save
                </button>
            </div>
        </div>
    </div>
</div>