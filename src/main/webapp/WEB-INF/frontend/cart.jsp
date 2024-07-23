<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="secu" uri="http://www.springframework.org/security/tags" %>
<!-- /*
* Bootstrap 5
* Template Name: Furni
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="favicon.png">

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />

    <!-- Bootstrap CSS -->
    <link href="/frontend/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="/frontend/css/tiny-slider.css" rel="stylesheet">
    <link href="/frontend/css/style.css" rel="stylesheet">
    <title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
</head>

<body>

<!-- Start Header/Navigation -->
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">
    <div class="container">
        <a class="navbar-brand" href="index.html">Furni<span>.</span></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item ">
                    <a class="nav-link" href="/home">Home</a>
                </li>
                <li><a class="nav-link" href="/shop">Shop</a></li>
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
<!-- End Header/Navigation -->

<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Cart</h1>
                </div>
            </div>
            <div class="col-lg-7">
            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<div class="untree_co-section before-footer-section">
    <div class="container">
        <div class="row mb-5">
            <form class="col-md-12" method="post">
                <div class="site-blocks-table">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="product-thumbnail">Image</th>
                            <th class="product-name">Product</th>
                            <th class="product-price">Price</th>
                            <th class="product-quantity">Quantity</th>
                            <th class="product-total">Total</th>
                            <th class="product-remove">Remove</th>
                        </tr>
                        </thead>
                        <tbody id="cart-contents">
                        <c:forEach items="${cartItems}" var="item">
                            <tr>
                                <td class="product-thumbnail">
                                    <img src="/api/product-image/${item.productimg}" alt="Image" class="img-fluid">
                                </td>
                                <td class="product-name">
                                    <h2 class="h5 text-black">${item.productname}</h2>
                                </td>
                                <td class="price-product" >${item.productprice}</td>
                                <td>
                                    <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                                        </div>
                                        <input type="text" class="form-control text-center quantity-amount" value="${item.number}" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-black increase" type="button">&plus;</button>
                                        </div>
                                    </div>

                                </td>
                                <td id="total-price-product">9000</td>
                                <td><button class="btn btn-black btn-sm" onclick="removeFromCart(${item.id})">X</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="row mb-5">
                    <div class="col-md-6 mb-3 mb-md-0">
                        <button class="btn btn-black btn-sm btn-block">Update Cart</button>
                    </div>
                    <div class="col-md-6">
                        <a href="/shop" class="btn btn-outline-black btn-sm btn-block">Continue Shopping</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <label class="text-black h4" for="coupon">Coupon</label>
                        <p>Enter your coupon code if you have one.</p>
                    </div>
                    <div class="col-md-8 mb-3 mb-md-0">
                        <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-black">Apply Coupon</button>
                    </div>
                </div>
            </div>
            <div class="col-md-6 pl-5">
                <div class="row justify-content-end">
                    <div class="col-md-7">
                        <div class="row">
                            <div class="col-md-12 text-right border-bottom mb-5">
                                <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <span class="text-black">Subtotal</span>
                            </div>
                            <div class="col-md-6 text-right">
                                <strong class="text-black">$0.00</strong>
                            </div>
                        </div>
                        <div class="row mb-5">
                            <div class="col-md-6">
                                <span class="text-black">Total</span>
                            </div>
                            <div class="col-md-6 text-right">
                                <strong id="total-Cart" class="text-black">$0.00</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button class="btn btn-black btn-lg py-3 btn-block" onclick="window.location='/checkout'">Proceed To Checkout</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Start Footer Section -->
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
        <div class="row g-3 mb-5">
            <div class="col-lg-3">
                <div class="mb-4 footer-logo-wrap"><a href="#" class="footer-logo">Furni<span>.</span></a></div>
                <p class="mb-4">Donec facilisis quam ut purus rutrum lobortis. Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                <ul class="list-unstyled custom-social">
                    <li><a href="#"><span class="fa fa-brands fa-facebook-f"></span></a></li>
                    <li><a href="#"><span class="fa fa-brands fa-twitter"></span></a></li>
                    <li><a href="#"><span class="fa fa-brands fa-instagram"></span></a></li>
                    <li><a href="#"><span class="fa fa-brands fa-linkedin"></span></a></li>
                </ul>
            </div>
            <div class="col-lg-8 ms-auto">
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
                            <li><a href="#">Wooden Chair</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</footer>
<!-- End Footer Section -->
<script src="/frontend/js/bootstrap.bundle.min.js"></script>
<script src="/frontend/js/tiny-slider.js"></script>
<script src="/frontend/js/custom.js"></script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const quantityInputs = document.querySelectorAll('.quantity-amount');
        const decreaseButtons = document.querySelectorAll('.decrease');
        const increaseButtons = document.querySelectorAll('.increase');
        const priceElements = document.querySelectorAll('.price-product');
        const totalProductElements = document.querySelectorAll('#total-price-product');
        const totalElementCart = document.getElementById('total-Cart');

        function updateTotal(index) {
            const quantity = parseInt(quantityInputs[index].value);
            const price = parseFloat(priceElements[index].textContent.replace('$', ''));
            const total = price * quantity;
            totalProductElements[index].textContent = '$' + total.toFixed(2);
            updateTotalCart(); // Gọi hàm cập nhật tổng số tiền giỏ hàng
        }

        function updateTotalCart() {
            let totalCart = 0;
            totalProductElements.forEach(element => {
                totalCart += parseFloat(element.textContent.replace('$', ''));
            });
            totalElementCart.textContent = '$' + totalCart.toFixed(2);
        }

        decreaseButtons.forEach((button, index) => {
            button.addEventListener('click', function() {
                let currentQuantity = parseInt(quantityInputs[index].value);
                if (currentQuantity > 1) {
                    quantityInputs[index].value = currentQuantity - 1;
                    updateTotal(index);
                }
            });
        });

        increaseButtons.forEach((button, index) => {
            button.addEventListener('click', function() {
                let currentQuantity = parseInt(quantityInputs[index].value);
                quantityInputs[index].value = currentQuantity + 1;
                updateTotal(index);
            });
        });

        // Khởi tạo tổng số tiền cho mỗi sản phẩm khi trang được tải
        quantityInputs.forEach((input, index) => {
            updateTotal(index);
        });
    });
</script>



</body>
</html>
