<%--
  Created by IntelliJ IDEA.
  User: yl
  Date: 2022/11/30
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <hr>
  <table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
      <c:forEach items="${brands}" var="brand" varStatus="status">
          <tr align="center">
              <td>${status.count}</td>
              <td>${brand.brandName}</td>
              <td>${brand.companyName}</td>
              <td>${brand.ordered}</td>
              <td>${brand.description}</td>
              <c:if test="${brand.status == 1}">
                  <td>启用</td>
              </c:if>

               <c:if test="${brand.status != 1}">
                  <td>禁用</td>
              </c:if>
              <td>
                  <a href="/mvc-demo/selectByidServlet?id=${brand.id}">修改
                  </a> <a href="#"> 删除</a>
              </td>
          </tr>
      </c:forEach>
  </table>
</body>
</html>
