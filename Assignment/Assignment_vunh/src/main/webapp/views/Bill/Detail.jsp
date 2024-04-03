<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container py-2 bg-white rounded shadow">
    <c:if test="${empty listInvoicesDetails}">
        <div class="alert alert-danger" role="alert">
            <i class="bi bi-exclamation-triangle-fill"></i> No products!
        </div>
    </c:if>
    <div>
        <c:if test="${not empty listInvoicesDetails}">
            <table class="table table-bordered text-center">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Product name</th>
                    <th scope="col">Size</th>
                    <th scope="col">Color</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total money</th>
                    <th scope="col">Create date</th>
                    <th scope="col">Edit date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listInvoicesDetails}" var="x" varStatus="i">
                    <fmt:formatDate value="${x.ngayTao}" pattern="dd-MM-yyyy HH:mm:ss" var="createDate"/>
                    <fmt:formatDate value="${x.ngaySua}" pattern="dd-MM-yyyy HH:mm:ss" var="editDate"/>
                    <tr>
                        <th scope="row">${i.index + 1}</th>
                        <td>${x.id}</td>
                        <td>${x.ctsp.sanPham.tenSanPham}</td>
                        <td>${x.ctsp.size.tenSize}</td>
                        <td>${x.ctsp.mauSac.tenMau}</td>
                        <td>${x.ctsp.giaBan}</td>
                        <td>${x.soLuongMua}</td>
                        <td>${x.tongTien}</td>
                        <td>${createDate}</td>
                        <td>${editDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <div class="mb-3">
        <a href="/bill/index" class="btn btn-outline-danger"><i class="bi bi-house-door-fill"></i> Back</a>
        <c:if test="${sessionScope.user.role}">
            <c:if test="${not empty listInvoicesDetails}">
                <a onclick="backToSale(${idInvoice}, ${quantitySize})" class="btn btn-outline-info"><i
                        class="bi bi-receipt"></i> Back
                    to sales</a>
            </c:if>
            <c:if test="${empty listInvoicesDetails}">
                <a href="/bill/delete?id=${idInvoice}" class="btn btn-danger"><i class="bi bi-trash3"></i> Delete</a>
            </c:if>
        </c:if>
    </div>
</div>
<script src="/assets/js/SalesProcessing.js"></script>