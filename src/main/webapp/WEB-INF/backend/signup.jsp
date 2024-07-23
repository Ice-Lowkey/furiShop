<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang đăng ký</title>
    <link rel="stylesheet" type="text/css" href="/frontend/css/signup.css">
</head>
<body>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <form class="form-m" action="/customer/save" method="post">
                <div class="form-header">
                    <h3>Đăng ký người dùng mới</h3>
                </div>
                <fieldset>
                    <div class="form-group">
                        <label for="username">Tên đăng nhập</label>
                        <h3 style="color: red">${message}</h3>
                        <input type="text" id="username" name="username" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu</label>
                        <input type="password" id="password" name="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password">Nhập lại mật khẩu</label>
                        <input type="password" id="repassword" name="repassword" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="phone">Số điện thoại</label>
                        <input type="number" id="phone" name="phone" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="address">Địa chỉ</label>
                        <input type="text" id="address" name="address" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Đăng ký" class="btn btn-primary">
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>

<script>
    document.querySelector('form').addEventListener('submit', function (event){
        const password = document.getElementById('password')
        const repassword = document.getElementById('repassword')

        const pass = password.value
        const repass = repassword.value

        if(!(pass == repass)) {
            alert('Mật khẩu không trùng khớp')
            event.preventDefault()
        }
    })

    document.querySelector('form').addEventListener('submit', function (event) {
        const phone = document.getElementById('phone')
        const phonecnt = phone.value;

        if (!phonecnt.length <= 8) {
            alert('Số điện thoại không hợp lệ')
            event.preventDefault();
        }
    })

    document.querySelector('form').addEventListener('submit', function(event) {
        const email = document.getElementById('email');
        const emailValue = email.value;
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; //email phải có dạng như này

        if (!emailRegex.test(emailValue)) {
            alert('Email không hợp lệ');
            event.preventDefault(); // Ngăn không cho form gửi đi
        } else if (!emailValue.endsWith('@gmail.com')) { //kết thức email là @ gmail.com
            alert('Email của bạn không hợp lệ');
            event.preventDefault(); // Ngăn không cho form gửi đi
        }
    });

</script>

</html>

