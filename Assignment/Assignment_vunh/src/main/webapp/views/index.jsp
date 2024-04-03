<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon"
          href="/assets/img/Logo.svg">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/Profile.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <title>VuProShop</title>
</head>
<body>
<div class="sidebar position-fixed top-0 bottom-0 bg-white border-end">
    <jsp:include page="/template/Sidebar.jsp"></jsp:include>
</div>
<div class="sidebar-overlay"></div>
<main class="bg-light">
    <div class="p-2">
        <nav class="px-3 py-2 bg-white rounded shadow">
            <jsp:include page="/template/Navbar.jsp"></jsp:include>
        </nav>
        <div class="py-4">
            <c:if test="${showAlerts}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Notification: </strong>${message}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <jsp:include page="${VIEW}"></jsp:include>
        </div>
    </div>
</main>
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.bundle.min.js"></script>
<script src="../assets/js/script.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js"
        integrity="sha512-sW/w8s4RWTdFFSduOTGtk4isV1+190E/GghVffMA9XczdJ2MDzSzLEubKAs5h0wzgSJOQTRYyaz73L3d6RtJSg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="/assets/js/main.js"></script>
</body>
</html>
