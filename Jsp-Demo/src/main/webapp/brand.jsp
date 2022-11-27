<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jsp.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Brand> brandList = new ArrayList();
    brandList.add(new Brand(1, "华为", "华为", 200, "5G厂商", 1));
    brandList.add(new Brand(2, "比亚迪", "比亚迪", 300, "国产电车", 1));
    brandList.add(new Brand(3, "茅台", "茅台", 400, "白酒酱香", 1));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

    <%
        for (int i = 0; i < brandList.size(); i++) {
            Brand brand = brandList.get(i);
    %>

    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanyName()%></td>
        <td><%=brand.getOrdered()%></td>
        <td><%=brand.getDescription()%></td>
        <td><%=brand.getStatus() == 1 ? "启用" : "禁用"%></td>
        <td><a href="#">修改</a> <a href="#">删除</a> </td>
    </tr>

    <%
        }
    %>
</table>

</body>
</html>
