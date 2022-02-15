<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<form:form>
    <h1><spring:message code="exchange.title"/></h1>
    <h2><spring:message code="exchange.remittance"/> : 미국</h2>
    <h2><spring:message code="exchange.reception"/> : </h2>
    <h2><spring:message code="exchange.value"/> : </h2>
    <h2><spring:message code="remittance.amount"/> : </h2>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
