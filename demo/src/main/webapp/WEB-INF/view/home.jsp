<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2022-02-16
  Time: 오전 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="exchange.service.title"/></title>
</head>
<body>
<form:form modelAttribute="info">
    <h1><spring:message code="exchange.title"/></h1>
    <h2><spring:message code="exchange.remittance"/> : 미국(USD)</h2>
    <h2><spring:message code="exchange.reception"/> : <form:select path="selectCountry" multiple="single" items="${info.receptionCountry}" onchange="this.form.submit()"/></h2>
    <h2><spring:message code="exchange.value"/> : <fmt:formatNumber value="${info.exchangeValue}" pattern="#,###.##"/> ${info.moneyType}<c:if test="${!empty info.selectCountry}">/USD</c:if></h2>
    <form:hidden path="exchangeValue" value="${info.exchangeValue}"/>
    <h2><spring:message code="remittance.amount"/> : <form:input path="remittanceAmount"/> USD</h2>
    <input type="submit" value="submit">
</form:form>
<c:if test="${!empty result}">
    <p>
        수취 금액은 <fmt:formatNumber value="${result}" pattern="#,###.##"/> ${info.moneyType} 입니다.
    </p>
</c:if>
</body>
</html>
