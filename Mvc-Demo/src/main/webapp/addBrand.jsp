<%--
  Created by IntelliJ IDEA.
  User: yl
  Date: 2022/11/30
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加品牌</title>
</head>
<body>
    <div id="app">
        <h3>添加品牌</h3>
        <form action="" method="post">
            品牌名称: <input id="brandName" v-model="brand.brandName" name="brandName"><br> <br>
            企业名称: <input id="companyName"  v-model="brand.companyName" name="companyName"><br> <br>
            品牌排序: <input id="ordered" v-model="brand.ordered" name="ordered"><br> <br>
            描述信息: <textarea rows="5" cols="20" id="description" v-model="brand.description" name="description"></textarea> <br> <br>
            状态:
            <input type="radio" name="status" v-model="brand.status" value="0">禁用
            <input type="radio" name="status" v-model="brand.status" value="1">启用 <br><br>

            <input type="button" id="submit" @click="submitForm" value="提交">
        </form>
    </div>

    <script src="js/axios-0.18.0.js"></script>
    <script src="js/vue.js"></script>
    <script>
        new Vue({
            el:"#app",
            data() {
                return {
                    brand:{}
                }
            },
            methods: {
                submitForm() {
                    var _this = this;
                    axios({
                        method:"post",
                        url: "http://localhost:8080/Mvc-Demo/addServlet",
                        data: _this.brand
                    }).then(function (resp) {
                        if (resp.data == "success") {
                            location.href = "http://localhost:8080/Mvc-Demo/brand.jsp";
                        }
                    })
                }
            }
        })
    </script>
</body>
</html>
