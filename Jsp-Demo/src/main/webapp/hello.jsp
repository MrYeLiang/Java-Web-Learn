<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello jsp</h1>
    <%
        System.out.println("hello, jso~");
        int i = 5;
    %>

    <%="hello"%>
    <%=i%>

    <%!
        void show() {}
        String name = "zhangsan";
    %>
</body>
</html>
