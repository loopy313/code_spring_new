<%--
  Created by IntelliJ IDEA.
  User: PC23
  Date: 2019-03-26
  Time: 오후 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="uploadFormAction" method="post" enctype="multipart/form-data">
        <input type="file" name="uploadFile" multiple>
        <button>Submit</button>
    </form>
</body>
</html>
