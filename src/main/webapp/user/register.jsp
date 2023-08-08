
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>N5 SHOP</title>
    <link rel="icon" href="https://cdn.dribbble.com/users/1595645/screenshots/13966658/media/3896bf05aa6ae338d73474edd5cc16a7.png">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <style>
        .form-login{
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div class="container form-login"  >
<form action="http://localhost:8080/user?action=register" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Tên tài khoản</label>
            <input type="text" class="form-control" placeholder="Tên tài khoản" name="user" id="inputEmail4">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Mật khẩu</label>
            <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="pass" id="inputPassword4">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Họ và tên</label>
        <input type="text" class="form-control" id="inputAddress" name="name" placeholder="Nhập họ tên đầy đủ">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Số điện thoại</label>
        <input type="text" class="form-control" id="inputAddress2" name="phone" placeholder="Nhập số điện thoại">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCity"Địa chỉ></label>
            <input type="text" class="form-control" placeholder="Nhập địa chỉ" name="address" id="inputCity">
        </div>
        <div class="form-group col-md-4">
            <label for="inputState">Giới tính</label>
            <select id="inputState" name="sex" class="form-control">
                <option selected>Nam</option>
                <option>Nữ</option>
                <option>Khác</option>
            </select>
        </div>
        <div class="form-group col-md-2">
            <label for="inputZip">Referral Code</label>
            <input type="text" class="form-control" placeholder="Mã giới thiệu nếu có" id="inputZip">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>
</body>
</html>
