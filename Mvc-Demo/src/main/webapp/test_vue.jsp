<%--
  Created by IntelliJ IDEA.
  User: yl
  Date: 2022/12/22
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="app">
        <%-- v-model --%>
        <input name="username" v-model="username">
        {{username}} <br> <br>

        <%-- v-bind --%>
        <a v-bind:href="url">百度一下</a> <br>
        <input v-model="url"> <br><br>

        <%-- v-on --%>
        <input type="button" value="按钮" v-on:click="show()"> <br><br>

        <%-- v-if --%>
        <div v-if="count == 1">div1</div>
        <div v-else-if="count == 2">div2</div>
        <div v-else>div3</div>
        <hr>
        <input v-model="count"> <br><br>

        <%-- v-for --%>
        <div v-for="add in addrs">
            {{add}} <br>
        </div>
        <hr>
        <div v-for="(addr, i) in addrs">
            {{i + 1}} -- {{addr}} <br>
        </div>
    </div>
    <script src="js/vue.js"></script>

    <script>
      new Vue({
        el:"#app",
        data() {
             return {
                 username: "",
                 url:"http://www.baidu.com",
                 count: 2,
                 addrs:["北京", "上海", "广州"]
             }
        },
        methods: {
            show() {
                alert("点击了button");
            }
        },
      });
    </script>
</body>
</html>
