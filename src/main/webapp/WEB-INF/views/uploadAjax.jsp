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
    <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <style>
        .uploadResult{
            width: 100%;
            background-color: gray;
        }
        .uploadResult ul{
            display: flex;
            flex-flow: row;
            justify-content: center;
            align-items: center;
        }
        .uploadResult ul li{
            list-style: none;
            padding: 10px;
        }
        .uploadResult ul li img{
            width:20px;
        }
    </style>
</head>
<body>
<h1>Upload with Ajax</h1>
<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple>
</div>
<button id="uploadBtn">Upload</button>
<div class="uploadResult">
    <ul>

    </ul>
</div>
</body>
<script>
    $(function () {
        var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)");
        var maxSize = 5242880;
        var cloneObj = $('.uploadDiv').clone();
        var uploadResult = $(".uploadResult ul");

        function showUploadedFile(uploadResultArr) {
            var str = "";
            $(uploadResultArr).each(function (i, obj) {
                if(!obj.image){
                    str += "<li><img src='/resources/img/attach.png'>" + obj.fileName + "</li>";
                }else{
                    str+="<li>"+obj.fileName+"</li>";
                }
            });
            uploadResult.append(str);
        }

        function checkExtension(fileName, fileSize) {
            if (fileSize >= maxSize) {
                alert("파일 사이즈 초과");
                return false;
            }
            if (regex.test(fileName)) {
                alert("해당 종류의 파일은 업로드할 수 없습니다.");
                return false;
            }
            return true;
        }

        $("#uploadBtn").on("click", function (e) {
            var formData = new FormData();
            //inputFile=>type:FileList
            var inputFile = $("input[name='uploadFile']");
            var files = inputFile[0].files;
            console.log(files);
            for (var i = 0; i < files.length; ++i) {
                if (!checkExtension(files[i].name, files[i].size)) {
                    return false;
            }
                formData.append("uploadFile", files[i]);
            }
            $.ajax({
                url: '/uploadAjaxAction',
                processData: false,
                contentType: false,
                data: formData,
                type: 'post',
                dataType: 'json',
                success: function (result) {
                    console.log(result);
                    showUploadedFile(result);
                    $(".uploadDiv").html(cloneObj.html());
                }
            });
        });
    });
</script>
</html>
