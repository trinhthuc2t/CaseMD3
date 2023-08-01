<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/08/2023
  Time: 3:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
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
<div class="container form-login" >
<form>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" placeholder="Nhập Email" id="inputEmail4">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" placeholder="Nhập mật khẩu" id="inputPassword4">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Name</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="Nhập họ tên đầy đủ">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Phone Number</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="Nhập số điện thoại">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCity">Address</label>
            <input type="text" class="form-control" placeholder="Nhập địa chỉ" id="inputCity">
        </div>
        <div class="form-group col-md-4">
            <label for="inputState">Sex</label>
            <select id="inputState" class="form-control">
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
    <div class="form-group">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck">
            <label class="form-check-label" for="gridCheck">
                cho phép truy cập vị trí của bạn
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>
</body>
</html>
