<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
 <ul>
    <c:forEach var="o" items="${category.getListResult()}">
        <li><a href="<c:url value='/shop?categoryId='/>${o.getId()}">${o.getName()}</a></li>
    </c:forEach>
</ul>