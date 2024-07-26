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
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/backend/home">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="/backend/home">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>Setting</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom :</h6>
                    <a class="collapse-item" href="buttons.html">Buttons</a>
                    <a class="collapse-item" href="cards.html">Language</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <secu:authorize access="hasRole('ADMIN')">
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                   aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>User</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                     data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">User manager</h6>
                        <a class="collapse-item" href="/backend/user/create">Create</a>
                        <a class="collapse-item" href="/backend/user/list">List</a>
                    </div>
                </div>
            </li>
        </secu:authorize>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Addons
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Product</h6>
                    <a class="collapse-item" href="/backend/product/create">Create</a>
                    <a class="collapse-item" href="/backend/product/list">List</a>
                    <div class="collapse-divider"></div>
                    <h6 class="collapse-header">Category</h6>
                    <a class="collapse-item" href="/backend/category/create">Create</a>
                    <a class="collapse-item" href="/backend/category/list">List</a>
                </div>
            </div>

        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="/backend/chart">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>

        <!-- Nav Item - Tables -->
<%--        <li class="nav-item active">--%>
<%--            <a class="nav-link" href="tables.html">--%>
<%--                <i class="fas fa-fw fa-table"></i>--%>
<%--                <span>Tables</span></a>--%>
<%--        </li>--%>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
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
                        <h1>Tạo mới sản phẩm</h1>
                        <form class="row g-3 needs-validation" novalidate action="/backend/product/save" method="post">
                            <div class="col-md-4">
                                <label for="validationCustom01" class="form-label">Tên sản phẩm</label>
                                <input type="text" name="name" class="form-control" id="validationCustom01" value="" required>
                                <div class="invalid-feedback">
                                    Vui lòng điền tên sản phẩm.
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="validationCustom02" class="form-label">Nhãn hiệu</label>
                                <input type="text" class="form-control" name="brand" id="validationCustom02" value="" required>
                                <div class="valid-feedback">
                                    Vui lòng điền tên nhãn hiệu.
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="validationCustomUsername" class="form-label">Giá</label>
                                <div class="input-group has-validation">
                                    <input type="number" class="form-control" name="price" id="validationCustomUsername"
                                           aria-describedby="inputGroupPrepend" required>
                                    <div class="invalid-feedback">
                                        Vui lòng điền giá.
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="validationCustom03" class="form-label">Mô tả</label>
                                <input type="text" name="description" class="form-control" id="validationCustom03">
                            </div>
                            <div class="col-md-3">
                                <label for="validationCustom04" class="form-label">Thể loại</label>
                                <select name="category" class="form-select" id="validationCustom04" required>
                                    <option selected disabled value="">Chọn thể loại</option>
                                    <c:forEach var="c" items="${categories}">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:forEach>

                                </select>
                                <div class="invalid-feedback">
                                    Vui lòng chọn loại sản phẩm
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="fileUploadId" class="form-label">Tải file</label>
                                <input type="file" class="form-control" id="fileUploadId">
                                <input type="text" name="image" hidden class="form-control" id="fileUploadName" required>
                                <div class="invalid-feedback">
                                    Vui lòng chọn file.
                                </div>
                            </div>
                            <div class="col-md-6">
                                <img id="outputImage" width="100px"/>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-primary" type="submit">Tạo mới</button>
                            </div>
                        </form>
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
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>





