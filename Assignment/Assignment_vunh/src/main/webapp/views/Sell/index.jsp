<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">

    <div class="row bg-white rounded shadow p-1 mb-5 bg-body-tertiary rounded">
        <div class="col-9">
            <div class="row">
                <div class="col-12 mb-3">
                    <c:if test="${empty listInvoices}">
                        <div class="alert alert-warning" role="alert">
                            <i class="bi bi-exclamation-triangle-fill"></i> Invoice list is empty!
                        </div>
                    </c:if>
                    <c:if test="${not empty listInvoices}">
                        <table class="table table-bordered">
                            <thead class="text-center">
                            <tr class="table-light" height="10">
                                <td colspan="5"><h2 class="fw-bold text-uppercase">List of invoices</h2></td>
                            </tr>
                            <tr class="table-dark">
                                <th scope="col">#</th>
                                <th scope="col">ID</th>
                                <th scope="col">Status</th>
                                <th scope="col">Create date</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody class="text-center">
                            <c:forEach varStatus="i" var="inv" items="${listInvoices}">
                                <fmt:formatDate value="${inv.ngayTao}" pattern="dd-MM-yyy HH:mm:ss"
                                                var="createDate"></fmt:formatDate>
                                <tr>
                                    <th scope="row">${i.index + 1}</th>
                                    <td class>${inv.id}</td>
                                    <td><span class="badge text-success">${inv.trangThai}</span></td>
                                    <td>${createDate}</td>
                                    <td>
                                        <a href="/sell/index?id_detail=${inv.id}"
                                           class="btn btn-outline-success border-0"><i
                                                class="bi bi-eye-fill"></i></a> <%--View Detail --%>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <hr>
                <div class="col-12 mb-3">
                    <c:if test="${ not empty invoicesDetails.listHoaDon}">
                        <table class="table table-bordered text-center">
                            <thead>
                            <tr class="table-light" height="10">
                                <td colspan="6"><h2 class="fw-bold text-uppercase">List of order details</h2></td>
                            </tr>
                            </thead>
                        </table>
                        <div style="max-height: 250px; overflow-y: auto">
                            <table class="table table-bordered text-center">
                                <thead>
                                <tr class="table-dark">
                                    <th scope="col">#</th>
                                    <th scope="col">Product name</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Total money</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="dts" items="${invoicesDetails.listHoaDon}" varStatus="i">
                                    <tr>
                                        <th scope="row">${i.index + 1}</th>
                                        <td class="text-start">${dts.ctsp.sanPham.tenSanPham}</td>
                                        <td>${dts.soLuongMua}</td>
                                        <td>${dts.giaBan}</td>
                                        <td>${dts.tongTien}</td>
                                        <td>
                                            <button class="btn btn-outline-danger border-0" type="button"
                                                    onclick="deleteProductInvoice(${dts.id})"><i
                                                    class="bi bi-trash"></i>
                                            </button>
                                                <%-- Edit Detail --%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </c:if>
                    <c:if test="${empty invoicesDetails.listHoaDon}">
                        <div class="row">
                            <div class="alert alert-warning col-12" role="alert">
                                <i class="bi bi-exclamation-triangle-fill"></i> No products have been added yet!
                            </div>
                            <div class="col text-center">
                                <img src="https://art.ngfiles.com/images/406000/406537_wondermeow_tanks-gif.gif?f1455530446" alt="" style="width: 300px;">
                                <img src="https://cdn.dribbble.com/users/882983/screenshots/5958118/6f6e5309-4ce1-4af4-8bcc-9e2a74b27881.gif" alt="" style="width: 300px;">
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-3">
            <table class="table text-center">
                <thead>
                <tr class="table-light" height="10">
                    <td colspan="1"><h4 class="fw-bold text-uppercase">Create invoices</h4></td>
                </tr>
                </thead>
            </table>
            <form action="/sell/pay" id="pay" method="post">
                <div class="mb-4">
                    <label for="phone" class="form-label">Phone number</label>
                    <div class="input-group mb-3">
                        <input type="tel" class="form-control" placeholder="Phone number"
                               aria-describedby="button-addon2" id="searchCustomer" name="searchCustomer"
                               value="${invoicesDetails.khachHang.sdt}">
                        <a onclick="searchCustomer()" id="phone" type="button"
                           class="btn btn-outline-secondary">Add</a>
                        <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                                data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-caret-down-fill"></i>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li>
                                <button type="button" data-bs-toggle="modal" data-bs-target="#newCustomer"
                                        class="dropdown-item" href="#"><i class="bi bi-person-plus-fill"></i> New Or
                                    Update Customer
                                </button>
                            </li>
                        </ul>
                        <%--Search customer--%>
                    </div>
                </div>
                <div class="mb-4">
                    <label for="customer" class="form-label">Customer
                        name</label>
                    <input type="text" class="form-control bg-white" id="customer" placeholder="Customer name"
                           value="${invoicesDetails.khachHang.hoTen}"
                           readonly>
                </div>
                <div class="mb-4">
                    <label for="idInvoices" class="form-label">Invoice ID</label>
                    <input type="number" class="form-control bg-white" id="idInvoices" name="idInvoices" readonly
                           placeholder="Invoice ID"
                           value="${invoicesDetails.id}">
                </div>
                <div class="mb-4">
                    <label for="totalMoney" class="form-label">Total payment</label>
                    <input type="number" class="form-control bg-white" id="totalMoney" value="${totalMoney}" readonly
                           placeholder="Total payment">
                </div>
                <div class="text-center">
                    <div class="row">
                        <div class="col-12 d-grid gap-2 mb-4">
                            <button class="btn btn-outline-primary" onclick="pay()" type="button"><i
                                    class="bi bi-credit-card-fill"></i> Pay
                            </button>
                        </div>
                        <div class="col-6 d-grid gap-2">
                            <a class="btn btn-outline-success" onclick="createInvoices(${listInvoices.size()})"><i
                                    class="bi bi-receipt"></i> New</a>
                        </div>
                        <div class="col-6 d-grid gap-2">
                            <button type="button" class="btn btn-outline-danger" onclick="cancelInvoices()"><i
                                    class="bi bi-x-circle-fill"></i> Cancel
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row bg-white rounded shadow p-1 mb-5 bg-body-tertiary rounded">
        <div class="col-12 mb-3">
            <form action="/sell/index?id_detail=${invoicesDetails.id}${queryString}" method="get" class="row">
                <table class="table table-bordered text-center">
                    <thead>
                    <tr class="table-light" height="10">
                        <td colspan="8"><h2 class="fw-bold text-uppercase">List of products</h2></td>
                    </tr>
                    </thead>
                </table>
                <div class="col-3">
                    <input type="hidden" class="form-control" id="id" name="id_detail" readonly
                           value="${invoicesDetails.id == null? 0 : invoicesDetails.id}">
                    <div class="col">
                        <div class="input-group mb-3">
                            <button class="btn btn-outline-secondary" type="submit" id="button-addon1"><i
                                    class="bi bi-search"></i>
                            </button>
                            <%--Search--%>
                            <input type="text" class="form-control" placeholder="Search"
                                   aria-label="Example text with button addon" aria-describedby="button-addon1"
                                   name="keyword" value="${keyword}">
                        </div>
                    </div>
                </div>
            </form>
            <table class="table table-bordered text-center">
                <thead>
                <tr class="table-dark">
                    <th scope="col">#</th>
                    <th scope="col">Code</th>
                    <th scope="col">Product name</th>
                    <th scope="col">Color</th>
                    <th scope="col">Size</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="prd" items="${listProductDetail}" varStatus="i">
                    <tr>
                        <th scope="row">${i.index + 1}</th>
                        <td>${prd.sanPham.maSanPham}</td>
                        <td class="text-start">${prd.sanPham.tenSanPham}</td>
                        <td>${prd.mauSac.tenMau}</td>
                        <td>${prd.size.tenSize}</td>
                        <td>${prd.giaBan}</td>
                        <td>${prd.soLuongTon}</td>
                        <td>
                            <button type="button" onclick="addToCart(${prd.id}, ${prd.soLuongTon})"
                                    class="btn btn-outline-primary border-0"><i class="bi bi-cart3"></i></button>
                                <%--Add to cart --%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="text-center">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link"
                                             href="/sell/index?id_detail=${id_detail}&${queryString}&page=1">First</a>
                    </li>
                    <c:if test="${page > 1}">
                        <li class="page-item"><a class="page-link"
                                                 href="/sell/index?id_detail=${id_detail}&${queryString}&page=${page - 1}">Prev</a>
                        </li>
                    </c:if>
                    <li class="page-item"><span class="page-link">${ page }</span></li>
                    <c:if test="${page < totalPage}">
                        <li class="page-item"><a class="page-link"
                                                 href="/sell/index?id_detail=${id_detail}&${queryString}&page=${page + 1}">Next</a>
                        </li>
                    </c:if>
                    <li class="page-item"><a class="page-link"
                                             href="/sell/index?id_detail=${id_detail}&${queryString}&page=${totalPage}">Last</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="newCustomer" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">New Or Update Customer</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/sell/createOrEditCustomer?id_detail=${invoicesDetails.id}" method="post"
                  id="createOrEditCustomer">
                <div class="modal-body">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="hoTen" name="hoTen">
                        <label for="hoTen">FullName</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="diaChi" name="diaChi">
                        <label for="diaChi">Address</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="sdt" name="sdt">
                        <label for="sdt">Phone</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal"><i
                            class="bi bi-x-circle"></i> Close
                    </button>
                    <button class="btn btn-outline-success" type="button" onclick="createOrEditCustomer()"><i
                            class="bi bi-floppy"></i> Save
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/assets/js/SalesProcessing.js"></script>