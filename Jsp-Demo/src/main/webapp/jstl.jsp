<%--
  Created by IntelliJ IDEA.
  User: yl
  Date: 2022/11/27
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- <c:if>标签 --%>
    <c:if test="${status == 1}">
        开启
    </c:if>

    <c:if test="${status == 0}">
        关闭
    </c:if>
    <br>

    <%-- <c:forEach>标签 --%>
    <c:forEach items="${brands}" var="brand">
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.description}</td>
        </tr>
        <br>
    </c:forEach>
    <br>

    <%-- <c:forEach>标签 --%>
    <c:forEach begin="0" end="10" step="1" var="i">
        ${i}
    </c:forEach>

</body>
</html>
