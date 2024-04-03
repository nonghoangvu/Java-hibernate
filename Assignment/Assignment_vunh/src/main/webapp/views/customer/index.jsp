<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container py-2 bg-white rounded shadow">
    <form action="/customer/index" method="get">
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
        <table class="table mt-4">
            <thead>
            <tr class="text-center">
                <th scope="col">#</th>
                <th scope="col">Customer name</th>
                <th scope="col">Number phone</th>
                <th scope="col">Address</th>
                <th scope="col">Last updated</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCustomers}" var="c" varStatus="i">
                <fmt:formatDate value="${c.ngaySua}" pattern="dd-MM-yyyy HH:mm:ss" var="editDate"/>
                <tr class="text-center">
                    <td>${i.index + 1}</td>
                    <td class="text-start">${c.hoTen}</td>
                    <td>${c.sdt}</td>
                    <td class="text-start">${c.diaChi}</td>
                    <td>${editDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${c.trangThai == 'Activity'}">
                                <span class="badge text-success">${c.trangThai}</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge text-danger">${c.trangThai}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="/customer/show?id=${c.id}" class="btn btn-outline-info"><i class="bi bi-eye-fill"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>