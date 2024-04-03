<i class="ri-menu-line sidebar-toggle me-3 d-block d-md-none"></i>
<h5 class="fw-bold mb-0 me-auto">${TITLE} <img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExZ2VsdWNmZmM2ZzVyZHVsajd6dGd5bGUwcTB5czg0dGowc3h1bDZlZCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/nSLNTip3CtGXcwv4Nq/giphy.gif" alt="" style="width: 25px"></h5>
<div class="dropdown me-3 d-none d-sm-block">
    <div class="cursor-pointer dropdown-toggle navbar-link" data-bs-toggle="dropdown"
         aria-expanded="false">
        <i class="ri-notification-line"></i>
    </div>
    <div class="dropdown-menu fx-dropdown-menu">
        <h5 class="p-3 bg-indigo text-light">Notification</h5>
        <div class="list-group list-group-flush">
            <a href="#"
               class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                <div class="me-auto">
                    <div class="fw-semibold">Subheading</div>
                    <span class="fs-7">Content for list item</span>
                </div>
                <span class="badge bg-primary rounded-pill">14</span>
            </a>
            <a href="#"
               class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                <div class="me-auto">
                    <div class="fw-semibold">Subheading</div>
                    <span class="fs-7">Content for list item</span>
                </div>
                <span class="badge bg-primary rounded-pill">14</span>
            </a>
            <a href="#"
               class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                <div class="me-auto">
                    <div class="fw-semibold">Subheading</div>
                    <span class="fs-7">Content for list item</span>
                </div>
                <span class="badge bg-primary rounded-pill">14</span>
            </a>
            <a href="#"
               class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                <div class="me-auto">
                    <div class="fw-semibold">Subheading</div>
                    <span class="fs-7">Content for list item</span>
                </div>
                <span class="badge bg-primary rounded-pill">14</span>
            </a>
            <a href="#"
               class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                <div class="me-auto">
                    <div class="fw-semibold">Subheading</div>
                    <span class="fs-7">Content for list item</span>
                </div>
                <span class="badge bg-primary rounded-pill">14</span>
            </a>
        </div>
    </div>
</div>
<div class="dropdown">
    <div class="d-flex align-items-center cursor-pointer dropdown-toggle" data-bs-toggle="dropdown"
         aria-expanded="false">
        <span class="me-2 d-none d-sm-block">${sessionScope.user.username}</span>
        <img class="navbar-profile-image"
             src="/assets/img/Admin.jpg"
             alt="Image">
    </div>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
        <%--        <li><a class="dropdown-item" href="/user/index">Manage your account</a></li>--%>
        <li>
            <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" class="dropdown-item"
                    href="/user/index">Manage your account
            </button>
        </li>
        <li><a class="dropdown-item" href="/logout">Sign out</a></li>
    </ul>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/user/store?uid=${sessionScope.user.id}" id="updateAccount" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Information</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-3">
                            <img src="https://t3.ftcdn.net/jpg/05/56/29/10/360_F_556291020_q2ieMiOCKYbtoLITrnt7qcSL1LJYyWrU.jpg"
                                 class="img-thumbnail img-radius" alt="..." style="width: 100px">
                        </div>
                        <div class="col-9">
                            <p>ID: ${sessionScope.user.id}</p>
                            <p>Username: ${sessionScope.user.username}</p>
                            <p>Email: ${sessionScope.user.email}</p>
                            <p>Role: ${sessionScope.user.role ? "Admin" : "Employee"}</p>
                            <p>Password:
                                <input type="password" value="${sessionScope.user.password}" id="password" name="password" class="form-control-sm border-0">
                            </p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer ">
                    <button type="button" onclick="updateAccount()" class="btn btn-secondary btn-sm">Save changes</button>
                </div>
            </div>
        </div>
    </form>
</div>