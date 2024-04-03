<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex align-items-center p-3">
    <a href="#" class="sidebar-logo text-uppercase fw-bold text-decoration-none text-indigo fs-4">VuProShop</a>
    <i class="sidebar-toggle ri-arrow-left-circle-line ms-auto fs-5 d-none d-md-block"></i>
</div>
<ul class="sidebar-menu p-3 m-0 mb-0">
    <li class="sidebar-menu-item active">
        <a href="/home/dashboard">
            <i class="ri-dashboard-line sidebar-menu-item-icon"></i>
            Dashboard
        </a>
    </li>
    <li class="sidebar-menu-divider mt-3 mb-1 text-uppercase">Custom</li>
    <li class="sidebar-menu-item has-dropdown">
        <a href="#">
            <i class="ri-store-line sidebar-menu-item-icon"></i>
            Business management
            <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
        </a>
        <ul class="sidebar-dropdown-menu">
            <li class="sidebar-dropdown-menu-item">
                <a href="/sell/index">
                    Selling
                </a>
            </li>
            <li class="sidebar-dropdown-menu-item">
                <a href="/bill/index">
                    Bill management
                </a>
            </li>
        </ul>
    </li>
    <li class="sidebar-menu-item has-dropdown">
        <a href="#">
            <i class="ri-t-shirt-line sidebar-menu-item-icon"></i>
            Product management
            <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
        </a>
        <ul class="sidebar-dropdown-menu">
            <li class="sidebar-dropdown-menu-item">
                <a href="/product/index">
                    List of products
                </a>
            </li>
            <li class="sidebar-dropdown-menu-item">
                <a href="/category/index">
                    Category
                </a>
            </li>
            <li class="sidebar-dropdown-menu-item has-dropdown">
                <a href="#">
                    Product attributes
                    <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
                </a>
                <ul class="sidebar-dropdown-menu">
                    <li class="sidebar-dropdown-menu-item">
                        <a href="/size/index">
                            Size
                        </a>
                    </li>
                    <li class="sidebar-dropdown-menu-item">
                        <a href="/color/index">
                            Color
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </li>
    <li class="sidebar-menu-item has-dropdown">
        <a href="#">
            <i class="ri-price-tag-3-line sidebar-menu-item-icon"></i>
            Sale management
            <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
        </a>
        <ul class="sidebar-dropdown-menu">
            <li class="sidebar-dropdown-menu-item">
                <a href="#">
                    Manage coupons
                </a>
            </li>
            <li class="sidebar-dropdown-menu-item">
                <a href="#">
                    Discount management
                </a>
            </li>
        </ul>
    </li>
    <li class="sidebar-menu-divider mt-3 mb-1 text-uppercase">Other</li>
    <li class="sidebar-menu-item">
        <a href="/customer/index">
            <i class="ri-customer-service-2-line sidebar-menu-item-icon"></i>
            Customer information
        </a>
    </li>
    <li class="sidebar-menu-item has-dropdown">
        <a href="#">
            <i class="ri-user-line sidebar-menu-item-icon"></i>
            Authentication
            <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
        </a>
        <ul class="sidebar-dropdown-menu">
            <li class="sidebar-dropdown-menu-item">
                <a href="#">
                    Change Password
                </a>
            </li>
            <c:if test="${sessionScope.user.role}">
                <li class="sidebar-dropdown-menu-item">
                    <a href="#">
                        Account management
                    </a>
                </li>
            </c:if>
        </ul>
    </li>
    <li class="sidebar-menu-item">
        <a href="#">
            <i class="ri-chat-history-line sidebar-menu-item-icon"></i>
            History
        </a>
    </li>
    <li class="sidebar-menu-item">
        <a href="#">
            <i class="ri-settings-5-line sidebar-menu-item-icon"></i>
            Setting
        </a>
    </li>
    <li class="sidebar-menu-item">
        <a href="/logout">
            <i class="ri-logout-box-line sidebar-menu-item-icon"></i>
            Sign out
        </a>
    </li>
</ul>