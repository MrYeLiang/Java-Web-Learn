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
    <title>所有品牌</title>
</head>
<body>
  <h1>${user.username},欢迎您</h1>
  <hr>
  <input type="button" value="新增" id="add"><br>
  <table id="brandTable" border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
  </table>
  <script src="js/axios-0.18.0.js"></script>
  <script>
      window.onload = function () {
          axios({
              method: "get",
              url: "http://localhost:8080/Mvc-Demo/selectAllServlet"
          }).then(function (resp) {
              let brands = resp.data;
              let tableData = "<tr>\n" +
                  "   <th>序号</th>\n" +
                  "   <th>品牌名称</th>\n" +
                  "   <th>企业名称</th>\n" +
                  "   <th>排序</th>\n" +
                  "    <th>品牌介绍</th>\n" +
                  "    <th>状态</th>\n" +
                  "   <th>操作</th>\n" +
                  "</tr>";

              for (let i = 0; i < brands.length; i++) {
                  let brand = brands[i];

                  tableData += "<tr align=\"center\">\n" +
                      "              <td>" + (i + 1) + "</td>\n" +
                      "              <td>" + brand.brandName + "</td>\n" +
                      "              <td>" + brand.companyName + "</td>\n" +
                      "              <td>" + brand.ordered + "</td>\n" +
                      "              <td>" + brand.description + "</td>\n" +
                      "              <td>" + brand.status + "</td>\n" +
                      "              <td>\n" +
                      "                  <a href=\"/Mvc-Demo/selectByIdServlet?id=${brand.id}\">修改\n" +
                      "                  </a> <a href=\"#\"> 删除</a>\n" +
                      "              </td>\n" +
                      "          </tr>";
              }
              document.getElementById("brandTable").innerHTML = tableData;
          })
      }
  </script>
</body>
</html>


