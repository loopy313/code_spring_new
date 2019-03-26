<%--
  Created by IntelliJ IDEA.
  User: PC23
  Date: 2019-03-26
  Time: 오후 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Upload with Ajax</h1>
<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple>
</div>
<button id="uploadBtn">Upload</button>
</body>
<script>
    document.addEventListener('onload',function (evt) {
        document.querySelector("#uploadBtn").addEventListener('click',function (evt1) {
            var formData=new FormData();
            var inputFile=document.querySelector("input[name='uploadFile']");
            var files=inputFile[0].files;
            console.log(files);
        })
    })
</script>
</html>
