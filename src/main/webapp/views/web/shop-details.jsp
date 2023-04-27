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
                        <h2>${product.getName()}</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <a href="./index.html">
                                <c:forEach var="c" items="${category.getListResult()}">
                                    <c:if test="${product.getCategoryId()==c.getId()}">
                                      ${c.getName()}
                                    </c:if>
                                </c:forEach>
                            </a>
                            <span>${product.getName()}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row w-100">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large" style="background-color:#F8F4EA"
                                src="<c:url value='/template/web/img/product/'/>${product.getImageUrl()}" alt="">
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                            <c:forEach var="c" items="${productImage.getListResult()}">
                                <img style="background-color:#F8F4EA" data-imgbigurl="<c:url value='/template/web/img/product/'/>${c.getUrl()}"
                                    src="<c:url value='/template/web/img/product/'/>${c.getUrl()}" alt="">
                            </c:forEach>
                            <img style="background-color:#F8F4EA" data-imgbigurl="<c:url value='/template/web/img/product/'/>${product.getImageUrl()}"
                                src="<c:url value='/template/web/img/product/'/>${product.getImageUrl()}" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${product.getName()}</h3>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <span>(18 reviews)</span>
                        </div>
                        <div class="product__details__price">
                         <c:set var="disS" value="0.00" />
                         <c:forEach var="c" items="${productLot.getListResult()}" varStatus="loop">
                             <c:choose>
                                <c:when test="${loop.index == 0}">
                                    <c:set var="disS" value="${disS + 0.00}" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="disS" value="${disS + 0.05}" />
                                </c:otherwise>
                             </c:choose>
                         </c:forEach>
                         (${product.getExportPrice() - (product.getExportPrice() * disS)}
                         - ${product.getExportPrice()})
                         </div>
                        <p style="margin-bottom:15px">${product.getDescriptions()}</p>
                        <form method="post" action="<c:url value='/add-to-cart'/>">
                            <div class="row w-100">
                              <select class="ml-3 form-select" name="productLotId" onchange="updatePrice()" required>
                                  <option disabled selected value="">--Choose--</option>
                                  <c:set var="discount" value="0.05" />
                                  <c:forEach var="c" items="${productLot.getListResult()}" varStatus="loop">
                                        <c:set var="price" value="${product.getExportPrice()}" />
                                        <c:choose>
                                            <c:when test="${loop.index == 0}">
                                                <option data-price="${price}" value="${c.getId()}">Commodity ${loop.index + 1} - ${price} - ${c.getQuantity()}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option data-price="${price - (discount * price)}" value="${c.getId()}">Commodity ${loop.index + 1} - ${price - (discount * price)} - ${c.getQuantity()}</option>
                                                <c:set var="discount" value="${discount + 0.05}" />
                                            </c:otherwise>
                                        </c:choose>
                                  </c:forEach>
                              </select>
                            </div>
                            <br/>
                            <input type="hidden" value="${product.getExportPrice()}" name="price"/>
                            <div class="product__details__quantity">
                                <div class="quantity">
                                    <div class="pro-qty">
                                        <input type="number" value="1" name="quantity" readonly>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="primary-btn" id="add-to-cart-btn">ADD TO CARD</button>
                        </form>

                        <script>
                          function updatePrice() {
                            const selectElement = document.querySelector('[name="productLotId"]');
                            const priceInput = document.querySelector('[name="price"]');
                            const selectedOption = selectElement.options[selectElement.selectedIndex];
                            const selectedPrice = selectedOption.getAttribute('data-price');
                            priceInput.value = selectedPrice;
                          }
                        </script>

                        <!--start-script-->
                        <c:choose>
                          <c:when test="${productLot != null && productLot.getListResult() != null && not empty productLot.getListResult()}">
                            <!-- Nếu productLot không rỗng thì không làm gì cả -->
                          </c:when>
                          <c:otherwise>
                            <script>
                              // Lấy đối tượng nút "ADD TO CARD" bằng ID
                              var btn = document.getElementById("add-to-cart-btn");

                              // Vô hiệu hóa nút bằng cách gán thuộc tính onclick và sử dụng phương thức preventDefault
                              btn.onclick = function(event) {
                                  event.preventDefault();
                              };

                              // Thêm lớp CSS "disabled" để trình bày rõ ràng hơn cho người dùng
                              btn.classList.add("disabled");

                              // Thêm CSS để làm mờ nút và ngăn chặn người dùng click vào nó
                                btn.style.opacity = "0.5";
                                btn.style.pointerEvents = "none";
                            </script>
                          </c:otherwise>
                        </c:choose>
                        <!--end-script-->
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                        <ul>
                            <c:choose>
                                  <c:when test="${productLot != null && productLot.getListResult() != null && not empty productLot.getListResult()}">
                                     <li><b>Availability</b> <span>In Stock</span></li>
                                  </c:when>
                                  <c:otherwise>
                                     <li><b>Availability</b> <span>Out Stock</span></li>
                                  </c:otherwise>
                            </c:choose>
                            <!--<li><b>Availability</b> <span>In Stock</span></li>
                            <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li>-->
                            <li><b>Weight</b> <span>${product.getWeight()} kg</span></li>
                            <li><b>Share on</b>
                                <div class="share">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">Information</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">Reviews <span>(1)</span></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation</h6>
                                    <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                        Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. Vivamus
                                        suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam sit amet quam
                                        vehicula elementum sed sit amet dui. Donec rutrum congue leo eget malesuada.
                                        Vivamus suscipit tortor eget felis porttitor volutpat. Curabitur arcu erat,
                                        accumsan id imperdiet et, porttitor at sem. Praesent sapien massa, convallis a
                                        pellentesque nec, egestas non nisi. Vestibulum ac diam sit amet quam vehicula
                                        elementum sed sit amet dui. Vestibulum ante ipsum primis in faucibus orci luctus
                                        et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam
                                        vel, ullamcorper sit amet ligula. Proin eget tortor risus.</p>
                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem
                                        ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet
                                        elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum
                                        porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus
                                        nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.
                                        Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Sed
                                        porttitor lectus nibh. Vestibulum ac diam sit amet quam vehicula elementum
                                        sed sit amet dui. Proin eget tortor risus.</p>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation</h6>
                                    <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                        Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.
                                        Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam
                                        sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo
                                        eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.
                                        Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent
                                        sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac
                                        diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante
                                        ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                        Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.
                                        Proin eget tortor risus.</p>
                                    <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem
                                        ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet
                                        elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum
                                        porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus
                                        nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.</p>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation</h6>
                                    <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                        Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.
                                        Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam
                                        sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo
                                        eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.
                                        Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent
                                        sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac
                                        diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante
                                        ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                        Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.
                                        Proin eget tortor risus.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

    <!-- Related Product Section Begin -->
    <section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>Related Product</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value='/template/web/img/product/product-1.jpg'/>">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value='/template/web/img/product/product-2.jpg'/>">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value='/template/web/img/product/product-3.jpg'/>">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value='/template/web/img/product/product-7.jpg'/>">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Related Product Section End -->

</body>
</html>