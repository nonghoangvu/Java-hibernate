<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container py-2 bg-white rounded shadow">
    <form action="/bill/index" method="get">
        <div class="row">
            <div class="col">
                <div class="row">
                    <div class="col-9">
                        <div class="input-group mb-3">
                            <button class="btn btn-outline-secondary" type="submit" id="btnSearch">Search</button>
                            <input type="number" class="form-control" name="keyword"
                                   aria-label="Example text with button addon" aria-describedby="btnSearch"
                                   value="${keyword}" placeholder="ID Invoice">
                        </div>
                    </div>
                    <div class="col-3">
                        <select class="form-select" aria-label="Default select example" name="status">
                            <option selected disabled>Select status</option>
                            <option ${status == '' ? "selected" : ""} value="">All</option>
                            <option ${status == 'Paid' ? "selected" : ""} value="Paid">Paid</option>
                            <option ${status == 'Cancel' ? "selected" : ""} value="Cancel">Cancel</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div>
        <table class="table mt-4">
            <thead>
            <tr class="text-center">
                <th scope="col">#</th>
                <th scope="col">ID</th>
                <th scope="col">Customer name</th>
                <th scope="col">Number phone</th>
                <th scope="col">Create date</th>
                <th scope="col">Edit date</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listInvoices}" var="inv" varStatus="i">
                <fmt:formatDate value="${inv.ngayTao}" pattern="dd-MM-yyyy HH:mm:ss" var="createDate"/>
                <fmt:formatDate value="${inv.ngaySua}" pattern="dd-MM-yyyy HH:mm:ss" var="editDate"/>
                <tr class="text-center">
                    <td>${i.index + 1}</td>
                    <td>${inv.id}</td>
                    <td>${inv.khachHang.hoTen == null ? "Unknown" : inv.khachHang.hoTen}</td>
                    <td>${inv.khachHang.sdt == null ? "Unknown" : inv.khachHang.sdt}</td>
                    <td>${createDate}</td>
                    <td>${editDate}</td>
                    <td>
                    <c:choose>
                        <c:when test="${inv.trangThai == 'Paid'}">
                            <span class="badge text-success">${inv.trangThai}</span>
                        </c:when>
                        <c:otherwise>
                            <span class="badge text-danger">${inv.trangThai}</span>
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                        <a href="/bill/show?id=${inv.id}" class="btn btn-outline-warning"><i class="bi bi-pencil-square"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <nav aria-label="Page navigation example" class="align-items-center justify-content-center">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/bill/index?${queryString}&page=1">First</a></li>
                    <c:if test="${page > 1}">
                    <li class="page-item"><a class="page-link" href="/bill/index?${queryString}&page=${page - 1}">Prev</a>
                        </c:if>
                    <li class="page-item"><span class="page-link">${ page }</span></li>
                    <li class="page-item">
                        <c:if test="${page < totalPage}">
                            <a class="page-link" href="/bill/index?${queryString}&page=${page + 1}">Next</a>
                        </c:if>
                    </li>
                    <li class="page-item"><a class="page-link" href="/bill/index?${queryString}&page=${totalPage}">Last</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>