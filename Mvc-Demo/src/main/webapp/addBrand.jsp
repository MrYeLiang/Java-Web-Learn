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
    <h3>添加品牌</h3>
    <form action="" method="post">
        品牌名称: <input id="brandName" name="brandName"><br> <br>
        企业名称: <input id="companyName"  name="companyName"><br> <br>
        品牌排序: <input id="ordered" name="ordered"><br> <br>
        描述信息: <textarea rows="5" cols="20" id="description" name="description"></textarea> <br> <br>
        状态:
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1">启用 <br><br>

        <input type="button" id="submit" value="提交">
    </form>

    <script src="js/axios-0.18.0.js"></script>
    <script>
        document.getElementById("submit").onclick = function () {
            var formData = {
                brandName: "",
                companyName: "",
                ordered: "",
                description: "",
                status: "",
            };
            let brandName = document.getElementById("brandName").value;
            let companyName = document.getElementById("companyName").value;
            let ordered = document.getElementById("ordered").value;
            let description = document.getElementById("description").value;

            formData.brandName = brandName;
            formData.companyName = companyName;
            formData.ordered = ordered;
            formData.description = description;

            let status = document.getElementsByName("status");
            for (let i = 0; i < status.length; i++) {
                if (status[i].checked) {
                    formData.status = status[i].value;
                }
            }

            console.log("formData = " + formData)
            axios({
                method:"post",
                url: "http://localhost:8080/Mvc-Demo/addServlet",
                data: formData
            }).then(function (resp) {
                if (resp.data == "success") {
                    location.href = "http://localhost:8080/Mvc-Demo/brand.jsp";
                }
            })
        };
    </script>
</body>
</html>
