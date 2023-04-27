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
    <style>
        .input-group {
          display: flex;
          align-items: center;
          justify-content: space-between;
          width: 150px;
        }

        .input-group input[type="number"] {
          background-color: #f8f8f8;
          color: #333;
          font-size: 14px;
          font-weight: bold;
          text-align: center;
          border: none;
          height:30px;
          border-radius: 0;
        }

        .input-group p {
          background-color: #7fad39;
          color: white;
          border: none;
          cursor: pointer;
          border-radius: 0;
          font-size: 14px;
          margin:0;
          font-weight: bold;
          width: 30px;
          height: 30px;
        }

        .input-group p:hover {
          background-color: #5b8c30;
        }

        .input-group p:active {
          background-color: #4d772b;
        }

    </style>
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <c:choose>
                            <c:when test="${not empty sessionScope.cart}">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="shoping__product">Products</th>
                                            <!--<th>Commodity</th>-->
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.cart.getListItems()}" var="item" varStatus="status">
                                            <tr>
                                                <td class="shoping__cart__item">
                                                    <c:forEach var="c" items="${product.getListResult()}">
                                                        <c:if test="${c.getId()==item.getProductLotModel().getProductId()}">
                                                            <img style="height:35px;width:35px;" src="<c:url value='/template/web/img/product/'/>${c.getImageUrl()}"/>
                                                            <h5>${c.getName()}</h5>
                                                        </c:if>

                                                    </c:forEach>
                                                </td>
                                                <!--
                                                <td class="shoping__cart__commodity">
                                                    <c:forEach items="${productLot.getListResult()}" var="c" varStatus="loop">
                                                        <c:if test="${c.getId()==item.getProductLotModel().getId()}">
                                                            <h5>${loop.index + 1}</h5>
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                -->
                                                <td class="shoping__cart__price">
                                                    ${item.getPrice()}
                                                </td>
                                                <td class="shoping__cart__quantity">
                                                    <div class="quantity">
                                                        <div class="input-group">
                                                          <c:set var="maxQuantity" value="0" />
                                                          <c:forEach items="${productLot.getListResult()}" var="c" varStatus="loop">
                                                            <c:if test="${c.getId()==item.getProductLotModel().getId()}">
                                                              <c:set var="maxQuantity" value="${item.getProductLotModel().getQuantity()}" />
                                                            </c:if>
                                                          </c:forEach>
                                                          <span class="input-group-btn">
                                                            <p class="btn btn-default" type="button" data-action="decrement">-</p>
                                                          </span>
                                                          <input type="number" class="form-control"
                                                                 data-product-lot-id="${item.getProductLotModel().getId()}"
                                                                 data-price="${item.getPrice()}"
                                                                 value="${item.getQuantity()}"
                                                                 max="${maxQuantity != 0 ? maxQuantity : ''}"
                                                                 disabled>
                                                          <span class="input-group-btn">
                                                            <p class="btn btn-default" type="button" data-action="increment">+</p>
                                                          </span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="shoping__cart__total">
                                                    ${item.getPrice() * item.getQuantity()}
                                                </td>
                                                <td class="shoping__cart__item__close">
                                                    <p onclick="removeItem(this)" data-plid="${item.getProductLotModel().getId()}"><span class="icon_close"></span></p>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

                                        <script>
                                          $(document).ready(function() {
                                            $('.input-group').on('click', '[data-action="increment"]', function() {
                                              var input = $(this).closest('.input-group').find('input');
                                              var newValue = parseInt(input.val()) + 1;
                                              input.val(newValue);
                                              input.trigger('input');
                                              var data = {
                                                productLotId: input.data('product-lot-id'),
                                                price: input.data('price'),
                                                quantity: input.val()
                                              };
                                              $.post("<c:url value='/update-cart'/>", data, function() {
                                                location.reload();
                                              });
                                            });

                                            $('.input-group').on('click', '[data-action="decrement"]', function() {
                                              var input = $(this).closest('.input-group').find('input');
                                              var newValue = parseInt(input.val()) - 1;
                                              if (newValue < 1) {
                                                newValue = 1;
                                              }
                                              input.val(newValue);
                                              input.trigger('input');
                                              var data = {
                                                productLotId: input.data('product-lot-id'),
                                                price: input.data('price'),
                                                quantity: input.val()
                                              };
                                              $.post("<c:url value='/update-cart'/>", data, function() {
                                                location.reload();
                                              });
                                            });
                                          });

                                          function removeItem(p) {
                                            var itemId = p.dataset.plid;
                                            console.log(itemId);
                                            var data = {
                                                productLotId: itemId,
                                              };
                                              $.post("<c:url value='/remove-cart-item'/>", data, function() {
                                                location.reload();
                                              });
                                          }

                                        </script>

                                    </tbody>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <h3>Cart is empty</h3>
                            </c:otherwise>
                        </c:choose>


                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="<c:url value='/shop'/>" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                            Upadate Cart</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Discount Codes</h5>
                            <form action="#">
                                <input type="text" placeholder="Enter your coupon code">
                                <button type="submit" class="site-btn">APPLY COUPON</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>Subtotal <span>${sessionScope.cart.getTotalMoney()}</span></li>
                            <li>Total <span>${sessionScope.cart.getTotalMoney()}</span></li>
                        </ul>
                        <a href="<c:url value='/checkout'/>" class="primary-btn">PROCEED TO CHECKOUT</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

</body>
</html>