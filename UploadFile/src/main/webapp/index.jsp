<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
  <div class="container">
    <h1 class="text-center">Upload File</h1>
    <form action="" method="post" enctype="multipart/form-data">
      <div class="row g-2 mt-5">
        <div class="col-md">
          <div class="form-floating">
            <input type="number" class="form-control" id="id" name="id">
            <label for="id">ID</label>
          </div>
        </div>
        <div class="col-md">
          <div class="form-floating">
            <input type="text" class="form-control" id="name" name="name">
            <label for="name">Name</label>
          </div>
        </div>
      </div>
      <div class="col-md mt-2">
        <div class="col-md">
            <input class="form-control" type="file" id="formFile" name="photo">
        </div>
      </div>
      <div class="col-md mt-2">
        <button type="submit" class="btn btn-outline-success">Submit</button>
      </div>
    </form>
  </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>