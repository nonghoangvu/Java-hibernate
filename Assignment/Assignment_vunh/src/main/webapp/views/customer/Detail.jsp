<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container py-2 bg-white rounded shadow">
    <div class="mb-3">
        <c:if test="${empty invoices}">
            <div class="alert alert-warning" role="alert">
                <i class="bi bi-exclamation-triangle-fill"></i> No bills!
            </div>
        </c:if>
        <c:if test="${not empty invoices}">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID Invoice</th>
                    <th scope="col">Product</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Price</th>
                    <th scope="col">Total money</th>
                    <th scope="col">Time</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="x" items="${invoices}">
                    <c:forEach items="${x.listHoaDon}" var="c" varStatus="i">
                        <fmt:formatDate value="${c.ngaySua}" var="time" pattern="dd-MM-yyyy HH:mm:ss"></fmt:formatDate>
                        <tr>
                            <th scope="row">${i.index + 1}</th>
                            <td>${c.hoaDon.id}</td>
                            <td class="text-start">${c.ctsp.sanPham.tenSanPham}</td>
                            <td>${c.soLuongMua}</td>
                            <td>${c.giaBan}</td>
                            <td>${c.tongTien}</td>
                            <td>${time}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <div class="mb-3">
        <a href="/customer/index" class="btn btn-outline-danger"><i class="bi bi-house-door-fill"></i> Back</a>
        <c:if test="${sessionScope.user.role}">
            <c:choose>
                <c:when test="${customer.trangThai == 'Activity'}">
                    <a href="/customer/update?id=${customer.id}&value=Inactive" class="btn btn-danger">Set Inactive</a>
                </c:when>
                <c:otherwise>
                    <a href="/customer/update?id=${customer.id}&value=Activity" class="btn btn-success">Set Activity</a>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>
</div>