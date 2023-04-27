<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>

<body>

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Organi Shop</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Department</h4>
                            <!--<%@include file="/common/web/sidebar.jsp"%>-->
                            <ul>
                                <c:forEach var="o" items="${category.getListResult()}">
                                    <li class="itemCategory" data-categoryId="${o.getId()}" style="cursor: pointer;">
                                        <i style="font-size: 12px;" class="fa fa-check" aria-hidden="true"></i>
                                        <p>${o.getName()}</p>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="sidebar__item">
                            <h4>Price</h4>
                            <div class="price-range-wrap">
                                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                    data-min="10" data-max="540">
                                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                </div>
                                <div class="range-slider">
                                    <div class="price-input">
                                        <input type="text" id="minamount">
                                        <input type="text" id="maxamount">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="sidebar__item sidebar__item__color--option">
                            <h4>Colors</h4>
                            <div class="sidebar__item__color sidebar__item__color--white">
                                <label for="white">
                                    White
                                    <input type="radio" id="white">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--gray">
                                <label for="gray">
                                    Gray
                                    <input type="radio" id="gray">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--red">
                                <label for="red">
                                    Red
                                    <input type="radio" id="red">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--black">
                                <label for="black">
                                    Black
                                    <input type="radio" id="black">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--blue">
                                <label for="blue">
                                    Blue
                                    <input type="radio" id="blue">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--green">
                                <label for="green">
                                    Green
                                    <input type="radio" id="green">
                                </label>
                            </div>
                        </div>
                        <div class="sidebar__item">
                            <h4>Popular Size</h4>
                            <div class="sidebar__item__size">
                                <label for="large">
                                    Large
                                    <input type="radio" id="large">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="medium">
                                    Medium
                                    <input type="radio" id="medium">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="small">
                                    Small
                                    <input type="radio" id="small">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="tiny">
                                    Tiny
                                    <input type="radio" id="tiny">
                                </label>
                            </div>
                        </div>
                        <div class="sidebar__item">
                            <div class="latest-product__text">
                                <h4>Latest Products</h4>
                                <div class="latest-product__slider owl-carousel">
                                    <div class="latest-prdouct__slider__item">
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>Crab Pool Security</h6>
                                                <span>$30.00</span>
                                            </div>
                                        </a>
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>Crab Pool Security</h6>
                                                <span>$30.00</span>
                                            </div>
                                        </a>
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>Crab Pool Security</h6>
                                                <span>$30.00</span>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="latest-prdouct__slider__item">
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>Crab Pool Security</h6>
                                                <span>$30.00</span>
                                            </div>
                                        </a>
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>Crab Pool Security</h6>
                                                <span>$30.00</span>
                                            </div>
                                        </a>
                                        <a href="#" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>Crab Pool Security</h6>
                                                <span>$30.00</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>Sale Off</h2>
                        </div>
                        <div class="row">
                            <div class="product__discount__slider owl-carousel">
                                <div class="col-lg-4">
                                    <div class="product__discount__item">
                                        <div class="product__discount__item__pic set-bg"
                                            data-setbg="<c:url value='/template/web/img/product/discount/pd-1.jpg'/>">
                                            <div class="product__discount__percent">-20%</div>
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__discount__item__text">
                                            <span>Dried Fruit</span>
                                            <h5><a href="#">Raisin’n’nuts</a></h5>
                                            <div class="product__item__price">$30.00 <span>$36.00</span></div>
                                        </div>
                                    </div>
                                </div>
                                <c:forEach var="o" items="${listC}">
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                data-setbg="<c:url value='/template/web/img/product/discount/pd-1.jpg'/>">
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>Dried Fruit</span>
                                                <h5><a href="#">${o.name_title}</a></h5>
                                                <div class="product__item__price">$${o.price} <span>$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>Sort By</span>
                                    <select>
                                        <option value="0">Default</option>
                                        <option value="0">Default</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6><span>16</span> Products found</h6>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-3">
                                <div class="filter__option">
                                    <span class="icon_grid-2x2"></span>
                                    <span class="icon_ul"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Product List----------------------------------------------------->
                    <div class="row" id="wrapper_list_product">
                    <!--Product List----------------------------------------------------->
                    </div>
                    <div class="product__pagination">
                        <a href="#">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#"><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

    <style>
        .itemCategory p {
          position: relative;
          display: inline-block;
        }

        .itemCategory i{
          color: white;
        }

        .itemCategory i.active,.itemCategory p.active {
          color: green;
        }

        .itemCategory:hover p {
          color: green;
        }

        .itemCategory:hover p::after {
          content: '';
          display: block;
          width: 100%;
          height: 2px;
          background-color: green;
          position: absolute;
          bottom: 0;
          left: 0;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function(){
            var urlAPI="<c:url value='/api-admin-new'/>";
            const urlParams = new URLSearchParams(window.location.search);
            const cateId = urlParams.get('categoryId');

            if (urlParams.has('categoryId') && cateId !== '') {
              // Do something with the id parameter
              urlAPI="<c:url value='/api-admin-new?categoryId='/>"+cateId;
            }

            var categoryId;

            $('li[data-categoryId]').click(function() {

                const urlPara = new URLSearchParams(window.location.search);
                urlPara.delete('categoryId');
                const newUrl = window.location.protocol + '//' + window.location.host + window.location.pathname + '?' + urlPara.toString();
                history.replaceState({path: newUrl}, '', newUrl);


                // Get the category ID from the clicked element
                var clickedCategoryId = $(this).attr('data-categoryId');

                // If the clicked category is already active, toggle off the active state and remove the categoryId parameter from the URL
                if ($(this).find('i').hasClass('active')) {
                    $(this).find('i').removeClass('active');
                    $(this).find('p').removeClass('active');

                    urlAPI = "<c:url value='/api-admin-new'/>";
                    getData();

                } else {
                    // If the clicked category is not active, update the urlAPI with the new categoryId parameter and call getData() to retrieve new data
                    categoryId = clickedCategoryId;
                    const isCategory = urlAPI.indexOf('?categoryId=');
                    if(isCategory > -1) {
                        urlAPI = urlAPI.replace(/categoryId=[^&]*/, 'categoryId=' + categoryId);
                    } else {
                        urlAPI = urlAPI + "?categoryId=" + categoryId;
                    }
                    console.log(urlAPI);
                    getData();

                    // Toggle the active state on the clicked element and toggle off the active state on other elements
                    $(this).find('i').addClass('active');
                    $('li[data-categoryId]').not(this).find('i').removeClass('active');
                    $(this).find('p').addClass('active');
                    $('li[data-categoryId]').not(this).find('p').removeClass('active');
                }
            });


            // The function to retrieve data from the API
            function getData() {
                $.ajax({
                    url: urlAPI,
                    type: "GET",
                    dataType: "json",
                    success: function(data) {
                        var html = "";
                        $.each(data, function(index, val) {
                            var imageUrlV = "<c:url value='/template/web/img/product/'/>" + val.imageUrl;
                            var ctspLink = "<c:url value='/shop-details?id='/>" + val.id;
                            html += '<div class="col-lg-4 col-md-6 col-sm-6">';
                            html += '<div class="product__item">';
                            html += '<div class="product__item__pic rounded-3" style="background-color:#F8F4EA">';
                            html += '<img src="' + imageUrlV + '"/>';
                            html += '<ul class="product__item__pic__hover">';
                            html += '<li><a href="#"><i class="fa fa-heart"></i></a></li>';
                            html += '<li><a href="#"><i class="fa fa-retweet"></i></a></li>';
                            html += '<li><a href="' + ctspLink + '"><i class="fa fa-shopping-cart"></i></a></li>';
                            html += '</ul>';
                            html += '</div>';
                            html += '<div class="product__item__text">';
                            html += '<h6><a href="#">' + val.name + '</a></h6>';
                            html += '<h5>' + val.exportPrice + '</h5>';
                            html += '</div>';
                            html += '</div>';
                            html += '</div>';
                        });
                        $('#wrapper_list_product').html(html);
                    }
                });
            }

            // Call the getData function initially
            getData();
        });
    </script>


</body>
</html>