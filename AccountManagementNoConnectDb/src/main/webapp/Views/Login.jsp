<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/18/2024
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--=============== REMIXICONS ===============-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/3.5.0/remixicon.css" crossorigin="">

    <!--=============== CSS ===============-->
    <link rel="stylesheet" href="Views/assets/css/styles.css">

    <title>Login form - Bedimcode</title>
</head>
<body>
<div class="login">
    <img src="Views/assets/img/login-bg.png" alt="image" class="login__bg">

    <form action="/login" method="post" class="login__form">
        <h1 class="login__title">Login</h1>

        <div class="login__inputs">
            <div class="login__box">
                <input type="email" placeholder="Email ID" required class="login__input" name="username">
                <i class="ri-mail-fill"></i>
            </div>

            <div class="login__box">
                <input type="password" placeholder="Password" required class="login__input" name="password">
                <i class="ri-lock-2-fill"></i>
            </div>
        </div>

        <div class="login__check">
            <div class="login__check-box">
                <input type="checkbox" class="login__check-input" id="user-check">
                <label for="user-check" class="login__check-label">Remember me</label>
            </div>

            <a href="#" class="login__forgot">Forgot Password?</a>
        </div>

        <button type="submit" class="login__button">Login</button>

        <div class="login__register">
            Don't have an account? <a href="#">Register</a>
        </div>
    </form>
</div>
</body>
</html>