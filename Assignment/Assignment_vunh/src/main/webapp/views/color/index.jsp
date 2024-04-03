<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container py-2 bg-white rounded shadow">
    <c:if test="${sessionScope.user.role}">
        <div class="text-end mt-3 mb-3">
            <a href="/color/create" class="btn btn-outline-secondary">New</a>
        </div>
    </c:if>
    <form action="/color/index" method="get">
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
                <th scope="col">ID</th>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Create date</th>
                <th scope="col">Edit date</th>
                <th scope="col">Status</th>
                <c:if test="${sessionScope.user.role}">
                    <th scope="col">Action</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listColor}" var="c" varStatus="i">
                <fmt:formatDate value="${c.ngayTao}" pattern="dd-MM-yyyy" var="createDate"/>
                <fmt:formatDate value="${c.ngaySua}" pattern="dd-MM-yyyy" var="editDate"/>
                <tr>
                    <td>${c.id}</td>
                    <td>${c.maMau}</td>
                    <td>${c.tenMau}</td>
                    <td>${createDate}</td>
                    <td>${editDate}</td>
                    <td class="text-center">
                        <c:if test="${c.trangThai == 'Activity'}">
                            <span class="badge rounded-pill text-success">Activity</span>
                        </c:if>
                        <c:if test="${c.trangThai == 'Inactive'}">
                            <span class="badge rounded-pill text-danger">Inactive</span>
                        </c:if>
                    </td>
                    <c:if test="${sessionScope.user.role}">
                        <td class="text-center">
                            <a href="/color/delete?id=${c.id}" class="btn btn-outline-danger border-0"><i class="bi bi-trash"></i></a>
                            <a href="/color/edit?id=${c.id}" class="btn btn-outline-warning border-0"><i class="bi bi-pencil-square"></i></a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>