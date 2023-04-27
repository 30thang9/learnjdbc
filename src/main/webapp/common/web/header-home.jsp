<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
    <div class="humberger__menu__logo">
        <a href="<c:url value='/home'/>"><img src="<c:url value='/template/web/img/logo.png'/>" alt=""></a>
    </div>
    <div class="humberger__menu__cart">
        <ul>
            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
            <li><a href="<c:url value='/shopping-cart'/>"><i class="fa fa-shopping-bag"></i>
                <c:choose>
                    <c:when test="${not empty sessionScope.cart}">
                        <span>${sessionScope.cart.getListItems().size()}</span>
                    </c:when>
                    <c:otherwise>
                        <span>0</span>
                    </c:otherwise>
                </c:choose>
            </a></li>
        </ul>
        <div class="header__cart__price">item: <span>$150.00</span></div>
    </div>
    <div class="humberger__menu__widget">
        <div class="header__top__right__language">
            <img src="<c:url value='/template/web/img/language.png'/>" alt="">
            <div>English</div>
            <span class="arrow_carrot-down"></span>
            <ul>
                <li><a href="#">Spanis</a></li>
                <li><a href="#">English</a></li>
            </ul>
        </div>
        <div class="header__top__right__auth">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="<c:url value='/login?action=logout'/>"><i class="fa fa-sign-out"></i> Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value='/login'/>"><i class="fa fa-user"></i> Login</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <nav class="humberger__menu__nav mobile-menu">
        <ul>
            <li class="active"><a href="<c:url value='/home'/>">Home</a></li>
            <li><a href="<c:url value='/shop'/>">Shop</a></li>
            <li><a href="#">Pages</a>
                <ul class="header__menu__dropdown">
                    <li><a href="<c:url value='/shop-details'/>">Shop Details</a></li>
                    <li><a href="<c:url value='/shopping-cart'/>">Shoping Cart</a></li>
                    <li><a href="<c:url value='/checkout'/>">Check Out</a></li>
                    <li><a href="<c:url value='/blog-details'/>">Blog Details</a></li>
                </ul>
            </li>
            <li><a href="<c:url value='/blog'/>">Blog</a></li>
            <li><a href="<c:url value='/contact'/>">Contact</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>
    <div class="header__top__right__social">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-linkedin"></i></a>
        <a href="#"><i class="fa fa-pinterest-p"></i></a>
    </div>
    <div class="humberger__menu__contact">
        <ul>
            <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
            <li>Free Shipping for all Order of $99</li>
        </ul>
    </div>
</div>
<!-- Humberger End -->

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                            <li>Free Shipping for all Order of $99</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                            <a href="#"><i class="fa fa-pinterest-p"></i></a>
                        </div>
                        <div class="header__top__right__language">
                            <img src="<c:url value='/template/web/img/language.png'/>" alt="">
                            <div>English</div>
                            <span class="arrow_carrot-down"></span>
                            <ul>
                                <li><a href="#">Spanis</a></li>
                                <li><a href="#">English</a></li>
                            </ul>
                        </div>
                        <div class="header__top__right__auth">
                            <c:choose>
                                <c:when test="${not empty sessionScope.user}">
                                    <a href="<c:url value='/login?action=logout'/>"><i class="fa fa-sign-out"></i> Logout</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/login'/>"><i class="fa fa-user"></i> Login</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="<c:url value='/home'/>"><img src="<c:url value='/template/web/img/logo.png'/>" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="<c:url value='/home'/>">Home</a></li>
                        <li><a href="<c:url value='/shop'/>">Shop</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="<c:url value='/shop-details'/>">Shop Details</a></li>
                                <li><a href="<c:url value='/shopping-cart'/>">Shoping Cart</a></li>
                                <li><a href="<c:url value='/checkout'/>">Check Out</a></li>
                                <li><a href="<c:url value='/blog-details'/>">Blog Details</a></li>
                                <li><a href="<c:url value='/admin-home'/>">Admin Home</a></li>
                            </ul>
                        </li>
                        <li><a href="<c:url value='/blog'/>">Blog</a></li>
                        <li><a href="<c:url value='/contact'/>">Contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                        <li><a href="<c:url value='/shopping-cart'/>"><i class="fa fa-shopping-bag"></i>
                            <c:choose>
                                <c:when test="${not empty sessionScope.cart}">
                                    <span>${sessionScope.cart.getListItems().size()}</span>
                                </c:when>
                                <c:otherwise>
                                    <span>0</span>
                                </c:otherwise>
                            </c:choose>
                        </a></li>
                    </ul>
                    <div class="header__cart__price">item: <span>$150.00</span></div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>
<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>All departments</span>
                    </div>
                    <%@include file="sidebar.jsp"%>
                </div>
            </div>
            <div class="col-lg-9" style="position:relative;">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="#">
                            <div class="hero__search__categories">
                                All Categories
                                <span class="arrow_carrot-down"></span>
                            </div>
                            <input class="searchByOnInput" oninput="searchByOnInput()" type="text" placeholder="What do yo u need?">
                            <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>

                    <div class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>+65 11.188.888</h5>
                            <span>support 24/7 time</span>
                        </div>
                    </div>
                </div>
                <div class="wrapper_result_search" style="position:absolute;top:50px;left:0;padding-left:15px; width:55%; z-index:80">
                    <div id="resultSearchByOnInput" class"row" style="padding:0px 5px 0px 5px; background-color:white; box-shadow:0px 0px 10px rgba(0, 0, 0, 0.08);"></div>
                </div>
                <style>
                    #see-more-product{
                      color: black;
                      padding-bottom:10px;
                    }
                    #see-more-product:hover {
                      color: black;
                    }
                </style>
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script>
                    function searchByOnInput() {
                        var query = $('.searchByOnInput').val();
                        $.ajax({
                            url: "<c:url value='/api-search-product?search='/>" + query,
                            type: 'GET',
                            dataType: 'json',
                            success: function(data) {
                                var html = "";
                                if ($.isEmptyObject(data)) {
                                   html += '<div class="col-12 d-flex justify-content-center align-items-center" style="height:120px; margin-bottom:10px; border-bottom:1px dotted #dfe0e1;">';
                                   html += '<h6>No Product...</h6>';
                                   html += '</div>';
                                } else {
                                  $.each(data, function(index, val) {
                                      var imageUrlV = "<c:url value='/template/web/img/product/'/>" + val.imageUrl;
                                      var ctspLink = "<c:url value='/shop-details?id='/>" + val.id;

                                      html += '<div class="col-12" style="margin-bottom:10px; border-bottom:1px dotted #dfe0e1">';
                                      html += '<div class="">';
                                      html += '<a href="' + ctspLink + '">';
                                      html += '<div class="row" style="">';

                                      html += '<div class="col-4 d-flex justify-content-center align-items-center">';
                                      html += '<img style="height:60px;" src="' + imageUrlV + '"/>';
                                      html += '</div>';

                                      html += '<div class="col-4 d-flex justify-content-center align-items-center">';
                                      html += '<h6>'+ val.name + '</h6>';
                                      html += '</div>';

                                      html += '<div class="col-4 d-flex justify-content-center align-items-center">';
                                      html += '<h6>' + val.exportPrice + '</h6>';
                                      html += '</div>';

                                      html += '</div>';
                                      html += '</a>';

                                      html += '</div>';
                                      html += '</div>';
                                  });
                                  var goShop="<c:url value='/shop'/>";
                                  html += '<div class="col-12 d-flex justify-content-center align-items-center" style="height:40px; margin-bottom:10px; border-bottom:1px dotted #dfe0e1;">';
                                  html += '<a id="see-more-product" href="'+goShop+'">See more...</a>';
                                  html += '</div>';
                                }
                                $('#resultSearchByOnInput').html(html);
                            },
                            error: function(xhr) {
                                // handle error
                                console.log(xhr);
                            }
                        });
                    }
                </script>

                <div class="hero__item set-bg" data-setbg="<c:url value='/template/web/img/hero/banner.jpg'/>">
                    <div class="hero__text">
                        <span>FRUIT FRESH</span>
                        <h2>Vegetable <br />100% Organic</h2>
                        <p>Free Pickup and Delivery Available</p>
                        <a href="#" class="primary-btn">SHOP NOW</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->
