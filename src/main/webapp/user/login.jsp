
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
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="../css/user.css">
<body>
<form action="http://localhost:8080/user?action=login" method="post">
<div class="container">
    <h1 class="text-center">N5 SHOP</h1>
    <div class="row">
        <div class="col-md-3 col-md-offset-4">
            <h1><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Q-H-T-D
            </h1>
            <div class="login-form">
                <div class="form-group"> <input class="form-control" value="" placeholder="n5shop@gmail.com" id="login-name" type="text" name="user">
                </div>
                <div class="form-group"> <input class="form-control" value="" placeholder="Password" id="login-pass" type="password" name="password">
                </div>
                <div class="checkbox"> <label><input type="checkbox"> Giữ tôi luôn đăng nhập </label>
                </div>
                <br> <button class="btn btn-info" type="submit">Đăng nhập</button>
                <br>
                <br> <a href=""><small>Quên mật khẩu</small></a>
                <br> <a href=""><small>Đăng nhập bằng mã dùng một lần</small></a>
                <br>
                <br>
                <br>
                <div><small>Không có tài khoản?</small> <a href="http://localhost:8080/user/register.jsp"><small>Tạo tài khoản</small></a>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>
