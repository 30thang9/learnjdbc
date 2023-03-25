<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/template/admin/images/favicon.png'/>">
    <!-- Custom Stylesheet -->
    <link href="<c:url value='/template/admin/css/bootstrap.min.css'/>" rel="stylesheet">
    <script src="<c:url value='/template/admin/js/bootstrap.bundle.min.js'/>"></script>
    <link href="<c:url value='/template/admin/css/style.css'/>" rel="stylesheet">

    <script src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>

    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->


    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <div class="brand-logo">
                <a href="<c:url value='/trang-chu'/>">
                    <b class="logo-abbr"><img src="<c:url value='/template/admin/images/logo.png'/>" alt=""> </b>
                   <span class="logo-compact"><img src="<c:url value='/template/admin/images/logo-compact.png'/>" alt=""></span>
                   <span class="brand-title" style="color:white;font-weight:bold;font-size:25px">
                       Ogani
                   </span>
                </a>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->

        <%@include file="/common/admin/header.jsp"%>

        <!--**********************************
            Header end
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->

        <%@include file="/common/admin/sidebar.jsp"%>

        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->

        <dec:body/>

        <!--**********************************
            Content body end
        ***********************************-->


        <!--**********************************
            Footer start
        ***********************************-->

        <%@include file="/common/admin/footer.jsp"%>

        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="<c:url value='/template/admin/plugins/common/common.min.js'/>"></script>
    <script src="<c:url value='/template/admin/js/custom.min.js'/>"></script>
    <script src="<c:url value='/template/admin/js/settings.js'/>"></script>
    <script src="<c:url value='/template/admin/js/gleek.js'/>"></script>
    <script src="<c:url value='/template/admin/js/styleSwitcher.js'/>"></script>


    <script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>



</body>

</html>