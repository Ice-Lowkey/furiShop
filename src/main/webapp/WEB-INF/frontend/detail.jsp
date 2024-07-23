<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="secu" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="favicon.png">
    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />
    <link href="/frontend/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="/frontend/css/tiny-slider.css" rel="stylesheet">
    <link href="/frontend/css/style.css" rel="stylesheet">
    <title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
</head>

<body>
<nav class="custom-navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">
    <div class="container">
        <a class="navbar-brand" href="/home">Furni<span>.</span></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item ">
                    <a class="nav-link" href="/home">Home</a>
                </li>
                <li class="active"><a class="nav-link" href="/shop">Shop</a></li>
                <li><a class="nav-link" href="/about">About us</a></li>
                <li><a class="nav-link" href="/blog">Blog</a></li>
                <li><a class="nav-link" href="/contact">Contact us</a></li>
            </ul>
            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
                <li>
                    <secu:authorize access="!isAuthenticated()">
                    <a class="nav-link" href="/_admin/login"><img src="/frontend/images/home/user.svg"></a></li>
                </secu:authorize>
                <li>
                    <secu:authorize access="isAuthenticated()">
                    <a class="nav-link" href="/logout"><img src="/frontend/images/home/logout.png" size="10px"></a></li>
                </secu:authorize>
                <li><a class="nav-link" href="/cart"><img src="/frontend/images/home/cart.svg"></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Shop</h1>
                </div>
            </div>
            <div class="col-lg-7">
            </div>
        </div>
    </div>
</div>

<div class="untree_co-section product-section before-footer-section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="/api/product-image/${product.image}" class="img-fluid" alt="${product.name}">
            </div>
            <div class="col-md-6">
                <h2>${product.name}</h2>
                <p>Loại sản phẩm : ${product.brand}</p>
                <p>Giá tiền: $${product.price}</p>
                <p>Mô tả: ${product.description}</p>
                <a href="/shop" class="btn btn-primary">Back to Shop</a>
                <a href="javascript:void(0);" class="btn go-to-cart" onclick="addToCart(${product.id})">Add to Cart</a>
            </div>
        </div>
    </div>
</div>

<!-- Cart Section (Hidden initially) -->
<div class="overlay" style="display:none;"></div>
<div class="cart-container" style="display:none;"></div>

<footer class="footer-section">
    <div class="container relative">
        <div class="sofa-img">
            <img src="/frontend/images/home/sofa.png" alt="Image" class="img-fluid">
        </div>
        <div class="row">
            <div class="col-lg-8">
                <div class="subscription-form">
                    <h3 class="d-flex align-items-center"><span class="me-1"><img src="/frontend/images/home/envelope-outline.svg" alt="Image" class="img-fluid"></span><span>Subscribe to Newsletter</span></h3>
                    <form action="#" class="row g-3">
                        <div class="col-auto">
                            <input type="text" class="form-control" placeholder="Enter your name">
                        </div>
                        <div class="col-auto">
                            <input type="email" class="form-control" placeholder="Enter your email">
                        </div>
                        <div class="col-auto">
                            <button class="btn btn-primary">
                                <span class="fa fa-paper-plane"></span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="row g-5 mb-5">
            <div class="col-lg-4">
                <div class="mb-4 footer-logo-wrap"><a href="#" class="footer-logo">Furni<span>.</span></a></div>
                <p class="mb-4">Donec facilisis quam ut purus rutrum lobortis. Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique. Pellentesque habitant</p>

                <ul class="list-unstyled custom-social">
                    <li><a href="#"><span class="fa fa-brands fa-facebook-f"></span></a></li>
                    <li><a href="#"><span class="fa fa-brands fa-twitter"></span></a></li>
                    <li><a href="#"><span class="fa fa-brands fa-instagram"></span></a></li>
                    <li><a href="#"><span class="fa fa-brands fa-linkedin"></span></a></li>
                </ul>
            </div>

            <div class="col-lg-8">
                <div class="row links-wrap">
                    <div class="col-6 col-sm-6 col-md-3">
                        <ul class="list-unstyled">
                            <li><a href="/about">About us</a></li>
                            <li><a href="/blog">Blog</a></li>
                            <li><a href="/contact">Contact us</a></li>
                        </ul>
                    </div>

                    <div class="col-6 col-sm-6 col-md-3">
                        <ul class="list-unstyled">
                            <li><a href="#">Support</a></li>
                            <li><a href="#">Knowledge base</a></li>
                            <li><a href="#">Live chat</a></li>
                        </ul>
                    </div>

                    <div class="col-6 col-sm-6 col-md-3">
                        <ul class="list-unstyled">
                            <li><a href="#">Jobs</a></li>
                            <li><a href="#">Our team</a></li>
                            <li><a href="#">Leadership</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                        </ul>
                    </div>

                    <div class="col-6 col-sm-6 col-md-3">
                        <ul class="list-unstyled">
                            <li><a href="#">Nordic Chair</a></li>
                            <li><a href="#">Kruzo Aero</a></li>
                            <li><a href="#">Ergonomic Chair</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


    </div>
</footer>

<script src="/frontend/js/bootstrap.bundle.min.js"></script>
<script src="/frontend/js/tiny-slider.js"></script>
<script src="/frontend/js/custom.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function addToCart(productId) {
        $.ajax({
            url: '/cart/add/' + productId,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ productId: productId }),
            success: function () {
                // Sau khi thêm vào giỏ hàng thành công, lấy và hiển thị nội dung giỏ hàng
                fetchCartContent();
            },
            error: function () {
                alert('Lỗi khi thêm vào giỏ hàng.');
            }
        });
    }

    function fetchCartContent() {
        $.ajax({
            url: "/cart/content",
            success: function(result){
                $(".cart-container").html(result);
                $(".overlay").show();
                $(".cart-container").show();
            }
        });
    }

    function clearCartContent() {
        $.ajax({
            url: "/cart/clear",
            success: function(result){
                $(".cart-container").html(result);
                $(".overlay").show();
                $(".cart-container").show();
            }
        });
    }

    $(document).ready(function(){
        $(".overlay").click(function(){
            $(this).hide();
            $(".cart-container").hide();
        });
    });
</script>


</body>
</html>
