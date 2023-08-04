<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>N5 SHOP</title>
    <link rel="icon"
          href="https://cdn.dribbble.com/users/1595645/screenshots/13966658/media/3896bf05aa6ae338d73474edd5cc16a7.png">
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>N5-Shop</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet"/>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #F0F2F5">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#!"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="http://localhost:8080/products?action=home">Home</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown"
                       href="http://localhost:8080/products?action=home" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Danh Mục Sản Phẩm</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="http://localhost:8080/products?action=home">Tất cả SP</a>
                        </li>
                        <li>
                            <hr class="dropdown-divider"/>
                        </li>
                        <C:forEach items="${brands}" var="brand">
                            <li><a class="dropdown-item"
                                   href="http://localhost:8080/products?action=product_to_brand&id=${brand.id}">${brand.name}</a>
                            </li>
                        </C:forEach>
                        <C:forEach items="${categories}" var="category">
                            <li><a class="dropdown-item"
                                   href="http://localhost:8080/products?action=product_to_category&id=${category.id}">${category.name}</a>
                            </li>
                        </C:forEach>
                    </ul>
                </li>
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="http://localhost:8080/products?action=asc">Giá tăng dần</a></li>
                <li class="nav-item dropdown">
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="http://localhost:8080/products?action=desc">Giá giảm dần</a></li>
                <li class="nav-item dropdown">
            </ul>
            <input type="text" name=search" placeholder="Search" class="search">

            <form class="d-flex">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    <a href="http://localhost:8080/products?action=cart" style="text-decoration: none">Giỏ hàng</a>
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.idCart}</span>
                </button>
            </form>

            <button class="btn btn-outline-dark user" type="submit">
                <a href="http://localhost:8080/user?action=login" class="user">Tài khoản</a>
            </button>
            <button class="btn btn-outline-dark user" type="submit">
                <a href="" class="user">Chảo ${sessionScope.idUser}</a>
            </button>

        </div>
    </div>
</nav>
<!-- Header-->

<div class="card">
    <div class="card-body">
        <div class="row">
            <div class="col-md-7">
                <div class="left border">
                    <div class="row">
                        <span class="header">Payment</span>
                        <div class="icons">
                            <img src="https://img.icons8.com/color/48/000000/visa.png"/>
                            <img src="https://img.icons8.com/color/48/000000/mastercard-logo.png"/>
                            <img src="https://img.icons8.com/color/48/000000/maestro.png"/>
                        </div>
                    </div>
                    <form>
                        <div class="row">
                            <span>Tên chủ thẻ</span>
                            <input placeholder="NGUYEN VAN A">
                        </div>
                        <div class="row">
                            <span>Số thẻ:</span>
                            <input placeholder="0125 6780 4567 9909">
                        </div>

                        <div class="row">
                            <div class="col-4"><p> Ngày hết hạn</p>
                                <input placeholder="YY/MM">
                            </div>
                            <div class="col-4">
                                <p>CVV:</p>
                                <input id="cvv">
                            </div>
                        </div>
                        <input type="checkbox" id="save_card" class="align-left">
                        <label for="save_card">Lưu thông tin</label>
                    </form>
                </div>
            </div>
            <div class="col-md-5">
                <div class="right border">
                    <div class="header">Giỏ hàng</div>
                    <p>${sessionScope.idCart} Sản phẩm</p>
                    <C:forEach items="${carts}" var="cart">
                        <div class="row item">
                            <div class="col-4 align-self-center"><img class="img-fluid" src="${cart.product.img}" alt=""></div>
                            <div class="col-8">
                                <div class="row"><b>${cart.product.price}VNĐ</b></div>
                                <div class="row text-muted">${cart.product.name}</div>
                                <div class="row">Số lượng: ${cart.quantity}</div>
                                <div class="text-center col-6"><a class="btn btn-outline-dark mt-auto"
                                                                  href="http://localhost:8080/products?action=delete_cart&id=${products.id}">Xóa</a>
                                </div>
                            </div>
                        </div>
                    </C:forEach>
                    <hr>
                    <div class="row lower">
                        <div class="col text-left">Tổng tiền</div>
                        <div class="col text-right">${sessionScope.sumCart}</div>
                    </div>
                    <div class="row lower">
                        <div class="col text-left">Ship</div>
                        <div class="col text-right">Free</div>
                    </div>
                    <div class="row lower">
                        <div class="col text-left"><b>Tổng tiền thanh toán</b></div>
                        <div class="col text-right"><b></b>${sessionScope.sumCart}</div>
                    </div>
                    <button class="btn btn-outline-dark" type="submit">
                        <i class=" me-1"></i>
                        <a href="http://localhost:8080/products?action=home" style="text-decoration: none">Thanh toán</a>
                        <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.idCart}</span>
                    </button>                    <p class="text-muted text-center">Complimentary Shipping & Returns</p>
                </div>
            </div>
        </div>
    </div>

    <div>
    </div>
</div>

</body>
</html>