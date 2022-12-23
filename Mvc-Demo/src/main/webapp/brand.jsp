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

  <div id="app">
      <a href="addBrand.jsp"> <input type="button" value="新增"></a><br>
      <br>
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
          <tr v-for="(brand, i) in brands" align="center">
              <td>{{i + 1}}</td>
              <td>{{brand.brandName}}</td>
              <td>{{brand.companyName}}</td>
              <td>{{brand.ordered}}</td>
              <td>{{brand.description}}</td>
              <td>{{brand.status}}</td>
              <td><a href="#">修改</a> <a href="#">删除</a> </td>
          </tr>
      </table>
  </div>
  <script src="js/axios-0.18.0.js"></script>
  <script src="js/vue.js"></script>
  <script>
     new Vue({
         el: "#app",
         data() {
             return {
                 brands:[]
             }
         },
         mounted() {
             var _this = this;
             axios ({
                 method: "get",
                 url : "http://localhost:8080/Mvc-Demo/selectAllServlet"
             }).then(function (resp) {
                 _this.brands = resp.data;
             })
         }
     })
  </script>
</body>
</html>




