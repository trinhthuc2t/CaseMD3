
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

            <a href="/products?action=cart" style="text-decoration: none">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Giỏ hàng
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.iCart}</span>
                </button>
            </a>


            <button class="btn btn-outline-dark user" type="submit">
                <c:if test="${sessionScope.user == null}">
                    <a href="http://localhost:8080/user?action=login" class="user">Tài khoản</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <a href="http://localhost:8080/user?action=logout" class="user">Đăng xuất</a>
                </c:if>
            </button>

        </div>
    </div>
</nav>
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img src="${product.img}" width="600" height="700" alt=""></div>
            <div class="col-md-6">
                <div class="small mb-1">${product.id}</div>
                <h1 class="display-5 fw-bolder">${product.name}</h1>
                <div class="fs-5 mb-5">
                    <span class="text-decoration-line-through">${product.price}</span>
                    <span>$40.00</span>
                </div>
                <p class="lead">${product.description}</p>
                <div class="d-flex">
                    <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                    <button class="btn btn-outline-dark flex-shrink-0" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        <a href="http://localhost:8080/products?action=add_cart&id=${product.id}" style="text-decoration: none" >Thêm vào giỏ hàng</a>
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <C:forEach items="${products}" var="products">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="${products.img}" height="300" width="200" alt="..."/>
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${products.name}</h5>
                                <!-- Product price-->
                                    ${products.price}
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="http://localhost:8080/products?action=add_cart&id=${products.id}">Xem thêm</a>
                            </div>
                        </div>
                    </div>
                </div>
            </C:forEach>

        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
