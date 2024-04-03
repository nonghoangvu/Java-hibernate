<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container py-2 bg-white rounded shadow">
    <c:if test="${sessionScope.user.role}">
        <div class="text-end mt-3 mb-3">
            <a href="/product/create" class="btn btn-outline-secondary">New</a>
        </div>
    </c:if>
    <form action="/product/index" method="get">
        <div class="row">
            <div class="col">
                <div class="row">
                    <div class="col-9">
                        <div class="input-group mb-3">
                            <button class="btn btn-outline-secondary" type="submit" id="btnSearch">Search</button>
                            <input type="text" class="form-control" name="keyword"
                                   aria-label="Example text with button addon" aria-describedby="btnSearch"
                                   value="${keyword}">
                        </div>
                    </div>
                    <div class="col-3">
                        <select class="form-select" aria-label="Default select example" name="status">
                            <option selected disabled>Select status</option>
                            <option ${status == '' ? "selected" : ""} value="">All</option>
                            <option ${status == 'Activity' ? "selected" : ""} value="Activity">Activity</option>
                            <option ${status == 'Inactive' ? "selected" : ""} value="Inactive">Inactive</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div>
        <table class="table table-bordered table-hover mt-4">
            <thead>
            <tr class="text-center">
                <th scope="col">#</th>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Status</th>
                <th scope="col">Create date</th>
                <c:if test="${sessionScope.user.role}">
                    <th scope="col">Action</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listProduct}" var="c" varStatus="i">
                <fmt:formatDate value="${c.ngayTao}" pattern="dd-MM-yyyy" var="createDate"/>
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${c.maSanPham}</td>
                    <td>${c.tenSanPham}</td>
                    <td>${c.danhMuc.tenDanhMuc}</td>
                    <td>
                        <c:if test="${c.trangThai == 'Activity'}">
                            <span class="badge rounded-pill text-success">Activity</span>
                        </c:if>
                        <c:if test="${c.trangThai == 'Inactive'}">
                            <span class="badge rounded-pill text-danger">Inactive</span>
                        </c:if>
                    </td>
                    <td class="text-center">${createDate}</td>
                    <c:if test="${sessionScope.user.role}">
                        <td class="text-center">
                            <a href="/product/edit?id=${c.id}" class="btn btn-outline-warning border-0"><i
                                    class="bi bi-pencil-square"></i></a>
                            <a href="/product-detail/index?id=${c.id}" class="btn btn-outline-success border-0"><i
                                    class="bi bi-eye"></i></a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <nav aria-label="Page navigation example" class="align-items-center justify-content-center">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/product/index?${queryString}&page=1">First</a></li>
            <c:if test="${page > 1}">
            <li class="page-item"><a class="page-link" href="/product/index?${queryString}&page=${page - 1}">Prev</a>
                </c:if>
            <li class="page-item"><span class="page-link">${ page }</span></li>
            <li class="page-item">
                <c:if test="${page < totalPage}">
                    <a class="page-link" href="/product/index?${queryString}&page=${page + 1}">Next</a>
                </c:if>
            </li>
            <li class="page-item"><a class="page-link" href="/product/index?${queryString}&page=${totalPage}">Last</a>
            </li>
        </ul>
    </nav>
</div>