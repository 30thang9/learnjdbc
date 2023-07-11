<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sale</title>

</head>
<body>

<!--**********************************
    Content body start
***********************************-->
<div class="content-body" style="min-height: 924px;">
    <div class="container-fluid">
      <div class="row">
        <div class="col">
          <ul class="list-inline d-flex align-items-center mb-2 mt-2 ml-4">
            <li class="d-inline-block ml-3">Home</li>
            <li class="d-inline-block ml-3 mr-3">/</li>
            <li class="d-inline-block">Sale</li>
          </ul>
        </div>
      </div>
    </div>
    <div class="container-fluid mt-3">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="active-member">
                            <div class="table-responsive">
                                <table class="table table-xs mb-0">
                                    <thead>
                                        <tr>
                                            <th rowspan="2">SaleId | Customer</th>
                                            <th colspan="5">Product Information</th>
                                            <th>Total Money</th>
                                        </tr>
                                        <tr>
                                            <th>ProductId</th>
                                            <th>ProductLotId</th>
                                            <th>Quantity</th>
                                            <th>Payment Price</th>
                                            <th>Total Price</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="o" items="${sale.getListResult()}">
                                                    <c:set var="count" value="0"/>
                                                    <c:set var="countSaleDetail" value="0"/>
                                                    <c:forEach var="m1" items="${saleDetail.getListResult()}" varStatus="loop">
                                                        <c:if test="${o.getId() == m1.getSaleId()}">
                                                            <c:set var="countSaleDetail" value="${countSaleDetail + 1}"/>
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:forEach var="m" items="${saleDetail.getListResult()}" varStatus="loop">
                                                        <c:if test="${o.getId() == m.getSaleId()}">
                                                            <tr>
                                                                <c:if test="${count==0}">
                                                                    <c:forEach var="kc" items="${customer.getListResult()}">
                                                                        <c:if test="${kc.getId() == o.getCustomerId()}">
                                                                            <td rowspan="${countSaleDetail}">${o.getId()} | ${kc.getName()}</td>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </c:if>
                                                                <c:forEach var="k" items="${productLot.getListResult()}">
                                                                    <c:if test="${k.getId() == m.getProductLotId()}">
                                                                        <td>${k.getProductId()}</td>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <td>${m.getProductLotId()}</td>
                                                                <td>${m.getQuantity()}</td>
                                                                <td>${m.getPaymentPrice()}</td>
                                                                <td>${m.getQuantity() * m.getPaymentPrice()}</td>
                                                                <c:if test="${count==0}">
                                                                    <td rowspan="${countSaleDetail}">${o.getTotalMoney()}</td>
                                                                </c:if>
                                                            </tr>
                                                            <c:set var="count" value="${count + 1}"/>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- #/ container -->
</div>


</body>
</html>