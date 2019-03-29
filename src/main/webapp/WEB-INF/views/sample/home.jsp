<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019-03-18
  Time: 오전 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script>
        function t() {
            document.querySelector(".textdiv").innerHTML = "bbb";
        }

        function c() {
            var cvs = document.querySelector("#myCanvas");
            var ctx;
            if (!(ctx = cvs.getContext("2d"))) {
                alert("canvas not supported");
            } else {
                ctx.fillStyle = "#ff0000";
                ctx.fillRect(0, 0, 150, 75);
            }
            ctx.drawImage(0,0,100,100,300,300,50,50);
        }

        window.onload = function (ev) {
            // t();
            c();
        }
    </script>
    <style>
        html {
            scroll-behavior: smooth;
        }

        #section1 {
            height: 500px;
            background-color: #1ab7ea;
        }

        #section2 {
            height: 500px;
            background-color: #5cb85c;
        }

        #section3 {
            position: fixed;
            left: 2in;
            top: 2in;
            width: 100px;
            height: 100px;
            background-color: #0c0c0c;
        }
    </style>
</head>
<body>
<div class="textdiv">
    <span>1</span>
    <span>2</span>
    <span style="position: relative;left: 5px">3</span>
</div>
<img src="/resources/img/attach.png" width="100" height="100">
<div id="section3">

</div>
<div class="main" id="section1">
    <h2>Section 1</h2>
    <p>Click on the link to see the "smooth" scrolling effect.</p>
    <a href="#section2">Click Me to Smooth Scroll to Section 2 Below</a>
    <p>Note: Remove the scroll-behavior property to remove smooth scrolling.</p>
</div>

<div class="main" id="section2">
    <h2>Section 2</h2>
    <a href="#section1">Click Me to Smooth Scroll to Section 1 Above</a>
</div>
<canvas id="myCanvas" width="200" height="100">

</canvas>
</body>

</html>
