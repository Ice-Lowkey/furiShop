<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: white;
        margin: 0;
        padding: 0;
    }

    .cart-container {
        width: 350px;
        background: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        padding: 20px;
        position: fixed;
        right: 0;
        top: 0;
        height: 100%;
        overflow-y: auto;
        display: none;
        z-index: 1001;
    }

    .cart-title {
        font-size: 24px;
        margin-bottom: 20px;
    }

    .cart-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 15px;
        border-bottom: 1px solid #eee;
        padding-bottom: 10px;
    }

    .cart-item img {
        width: 60px;
        height: 60px;
        object-fit: cover;
    }

    .cart-item-details {
        flex: 1;
        margin-left: 15px;
    }

    .cart-item-name {
        font-size: 16px;
        margin: 0;
    }

    .cart-item-price {
        color: #999;
        font-size: 14px;
    }

    .cart-buy {
        bottom: 0;
    }

    .cart-total {
        display: flex;
        justify-content: space-between;
        font-size: 18px;
        margin-top: 20px;
        border-top: 1px solid #eee;
        padding-top: 10px;
    }

    .cart-buttons {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
        max-height: 50px;
    }

    .cart-button {
        padding: 10px 20px;
        border: none;
        background: #000;
        color: #fff;
        cursor: pointer;
        text-transform: uppercase;
    }

    .cart-button.zalo {
        background: #0078FF;
    }

    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5);
        display: none;
        z-index: 1000;
    }

</style>


<div class="cart-content">
    <h2 class="cart-title">Cart</h2>
    <c:forEach items="${cartItems}" var="item">
        <div class="cart-item">
            <p style="color: red">${note}</p>
            <img src="/api/product-image/${item.productimg}" alt="Product Image">
            <div class="cart-item-details">
                <p class="cart-item-name">${item.productname}</p>
                <p class="cart-item-id">Customer ID :${item.userid}</p>
                <p class="cart-item-price">$${item.productprice}</p>
                <p class="cart-item-number">${item.number}</p>
            </div>
        </div>
    </c:forEach>
    <div class="cart-buy">
        <div class="cart-total">
            <span>Thành tiền:</span>
            <span id="totalBill"></span>
        </div>
        <div class="cart-buttons">
            <a href="/cart" class="cart-button checkout">Checkout</a>
            <a href="/cart/clear" class="cart-button clear">Clear</a>
        </div>
    </div>
</div>

<script>
    var totalBill = document.getElementById('totalBill');
    var prices = document.getElementsByClassName('cart-item-price');
    var numbers = document.getElementsByClassName('cart-item-number');
    var total = 0;

    for (var i = 0; i < prices.length; i++) {
        var price = parseFloat(prices[i].innerText.replace('$', ''));
        var number = parseInt(numbers[i].innerText);
        total += price * number;
    }

    totalBill.innerText = '$' + total.toFixed(2);
</script>
