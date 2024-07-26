<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secu" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <jsp:include page="/WEB-INF/backend/common/head.jsp"/>

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="/backend/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/backend/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/backend/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/backend/common/side.jsp"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="/WEB-INF/backend/common/nav.jsp"/>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container">
                <div class="bg-light p-5 rounded">
                    <div class="col-sm-8 mx-auto">
                        <br>
                        <h1>Tạo mới User</h1>
                        <form:form class="row g-3 needs-validation" action="/backend/user/save" method="post" modelAttribute="userDto">
                            <div class="col-md-4">
                                <label for="validationCustom01" class="form-label">Tên đăng nhập</label>
                                <form:input type="text" path="username" class="form-control" id="validationCustom01" value="" />
                                <form:errors path="username" cssClass="errors"></form:errors>
                                <div class="invalid-feedback">
                                    ĐMM điền vào cho tao
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label">Mật khẩu</label>
                                <form:input class="form-control" path="password" type="password" id="password" />
                                <form:errors path="password" cssClass="errors"></form:errors>
                                <div class="valid-feedback">
                                    ĐMM điền vào cho tao
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label">Confirm Password</label>
                                <form:input type="password" class="form-control" path="repassword" id="repassword" />
                                <form:errors path="repassword" cssClass="errors"></form:errors>
                                <div class="valid-feedback">
                                    ĐMM điền vào cho tao
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label">Phone number</label>
                                <form:input type="text" class="form-control" path="phone" />
                                <div class="invalid-feedback">
                                    ĐMM điền vào cho tao
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label">Email</label>
                                <form:input type="text" class="form-control" path="email" />
                                <div class="valid-feedback">
                                    ĐMM điền vào cho tao
                                </div>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label">Chọn quyền</label>
                                <form:select type="text" class="form-control" path="role" >
                                    <form:option value="">Chọn quyền</form:option>
                                    <c:forEach items="${roles}" var="role">
                                        <form:option value="${role}">${role}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="username" cssClass="errors"></form:errors>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-primary" type="submit">Tạo mới</button>
                            </div>
                        </form:form>
                    </div>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->



        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/logout">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/backend/common/foot.jsp"/>

    <jsp:include page="/WEB-INF/backend/common/upload-file.jsp"/>
</body>

</html>

<script>

    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        // nếu form bị lỗi nhập
                        event.preventDefault()
                        event.stopPropagation()
                    } else {
                        if (password.value !== confirmPassword.value) {
                            event.preventDefault();
                            event.stopPropagation();
                            confirmPassword.setCustomValidity('Passwords do not match');
                            confirmPassword.classList.add('is-invalid');
                        } else {
                            confirmPassword.setCustomValidity('');
                            confirmPassword.classList.remove('is-invalid');
                            confirmPassword.classList.add('is-valid');
                        }
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>




