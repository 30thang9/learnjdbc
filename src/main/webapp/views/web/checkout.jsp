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
                        <h2>Checkout</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Checkout</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                    </h6>
                </div>
            </div>
            <div class="checkout__form">
                <h4>Billing Details</h4>
                <form action="<c:url value='/cart-checkout'/>" method="post">
                  <div class="row">
                    <div class="col-lg-6 col-md-6">
                      <div class="checkout__input">
                        <label for="full-name">Full Name<span>*</span></label>
                        <input type="text" id="full-name" name="customerName" placeholder="Full Name"
                            value="${sessionScope.customer != null ? sessionScope.customer.getName() : ''}"
                            required>
                      </div>
                      <div class="checkout__input">
                        <label for="address">Address<span>*</span></label>
                        <input type="text" id="address" name="address" placeholder="Address"
                            value="${sessionScope.customer != null ? sessionScope.customer.getAddress() : ''}"
                            class="checkout__input__add" required>
                      </div>
                      <div class="checkout__input">
                        <label for="phone">Phone<span>*</span></label>
                        <input type="tel" id="phone" name="phone" placeholder="Phone"
                            value="${sessionScope.customer != null ? sessionScope.customer.getPhone() : ''}"
                            required>
                      </div>
                      <div class="checkout__input">
                        <label for="email">Email<span>*</span></label>
                        <input type="email" id="email" name="email" placeholder="Email"
                            value="${sessionScope.customer != null ? sessionScope.customer.getEmail() : ''}"
                            required>
                      </div>
                      <div class="row">
                        <div class="col-4 mb-4"><a class="site-btn" href="<c:url value='/shop'/>">Shopping</a></div>
                        <div class="col-4 mb-4"><a class="site-btn" href="<c:url value='/shopping-cart'/>">Back to Cart</a></div>
                      </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                      <div class="checkout__order">
                        <h4>Your Order</h4>
                        <div class="row checkout__order__products">
                          <div class="col-4">Products</div>
                          <div class="col-4">Quantity</div>
                          <div class="col-4">Total</div>
                        </div>
                        <div class="row">
                            <c:forEach items="${sessionScope.cart.getListItems()}" var="item" varStatus="status">
                              <div class="col-4">
                                <c:forEach var="c" items="${product.getListResult()}">
                                    <c:if test="${c.getId()==item.getProductLotModel().getProductId()}">
                                        ${c.getName()}
                                    </c:if>
                                </c:forEach>
                              </div>
                              <div class="col-4">
                                ${item.getQuantity()}
                              </div>
                              <div class="col-4">
                                ${item.getPrice() * item.getQuantity()}
                              </div>
                            </c:forEach>
                        </div>
                        <div class="checkout__order__subtotal row">
                            <div class="col-4">Subtotal</div>
                            <div class="col-4"></div>
                            <div class="col-4">${sessionScope.cart.getTotalMoney()}</div>
                        </div>
                        <div class="checkout__order__total row">
                            <div class="col-4">Total</div>
                            <div class="col-4"></div>
                            <div class="col-4">${sessionScope.cart.getTotalMoney()}</div>
                        </div>
                        <!--
                        <div class="checkout__input__checkbox">
                          <label for="create-account">
                            Create an account?
                            <input type="checkbox" id="create-account" name="create-account">
                            <span class="checkmark"></span>
                          </label>
                        </div>
                        -->
                        <p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                        <div class="checkout__input__checkbox">
                          <label for="check-payment">
                            Check Payment
                            <input type="checkbox" id="check-payment" name="payment-method" value="check">
                            <span class="checkmark"></span>
                          </label>
                        </div>
                        <div class="checkout__input__checkbox">
                          <label for="paypal-payment">
                            Paypal
                            <input type="checkbox" id="paypal-payment" name="payment-method" value="paypal">
                            <span class="checkmark"></span>
                          </label>
                        </div>
                        <button type="submit" class="site-btn" ${not empty sessionScope.cart.getListItems() ? "" : "disabled"}>PLACE ORDER</button>
                      </div>
                    </div>

                  </div>
                </form>

            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

</body>
</html>