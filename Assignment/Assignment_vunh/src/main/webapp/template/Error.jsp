<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 3/27/2024
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Error</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        html,
        body {
            font-family: 'Poppins', sans-serif !important;
        }

        .header-link {
            font-size: 15px;
            margin-left: 20px;
            color: black !important;
        }

        .header-link:hover {
            color: #34d796 !important;
        }

        .main-img {
            padding-top: 8%;
        }

        .main-description {
            font-size: 14px;
        }

        .btn-sz-primary {
            font-size: 14px;
            padding: 10px 25px;
            border-radius: 50px;
            color: white !important;
            background-color: #34d796 !important;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-transperant">
    <div class="container pt-2">
        <!-- <a class="navbar-brand" href="#">Logo</a> -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<section>
    <div class="main container">
        <div class="row">
            <div class="col-12 col-sm-12 col-md-12 col-lg-3"></div>

            <div class="col-12 col-sm-12 col-md-12 col-lg-6">
                <div class="main-img text-center">
                    <img src="/assets/img/404.png" alt="Main" class="img-fluid pb-3">

                    <h2>Page Not Found</h2>
                    <p class="main-description pt-2">We're sorry, the page you requested could not be found please
                        go back to the homepage</p>
                    <a href="/home/dashboard" class="btn btn-sz-primary">Go Home</a>
                </div>
            </div>

            <div class="col-12 col-sm-12 col-md-12 col-lg-3"></div>
        </div>
    </div>
</section>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>
