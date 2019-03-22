<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read Page</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Read Page</div>
            <div class="panel-body">
                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno" value="<c:out value="${board.bno}"/>"
                           readonly="readonly">
                </div>
                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title" value="<c:out value="${board.title}"/>"
                           readonly="readonly">
                </div>
                <div class="form-group">
                    <label>Text area</label>
                    <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out
                            value="${board.content}"/></textarea>
                </div>
                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer" value="<c:out value="${board.writer}"/>"
                           readonly="readonly"/>
                </div>
                <%--modify,list button--%>
                <button data-oper="modify" class="btn btn-default">Modify</button>
                <button data-oper="list" class="btn btn-info">List</button>
                <form id="operForm" action="/board/modify" method="get">
                    <input type="hidden" name="bno" id="bno" value="<c:out value="${board.bno}"/>">
                    <input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum}"/>">
                    <input type="hidden" name="amount" value="<c:out value="${cri.amount}"/>">
                    <input type="hidden" name="type" value="<c:out value="${cri.type}"/>">
                    <input type="hidden" name="keyword" value="<c:out value="${cri.keyword}"/>">
                </form>
            </div>
        </div>
    </div>
</div>
<%--comment area--%>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-comment fa-fw"></i>Reply
            </div>
            <div class="panel-body">
                <ul class="chat">
                    <li class="left clearfix" data-rno="12">
                        <div>
                            <div class="header">
                                <strong class="primary-font">user00</strong>
                                <jsp:useBean id="date" class="java.util.Date"/>
                                <small class="pull-right text-muted">
                                    <fmt:formatDate value="${date}"
                                                    pattern="yyyy-MM-dd hh:mm"/></small>
                            </div>
                            <p>Good job!</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp" %>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        console.log("=================");
        console.log("JS TEST");

        var bnoValue = '<c:out value="${board.bno}"/>';
        var replyUL = $(".chat");
        showList(1);

        function showList(page) {
            replyService.getList({bno: bnoValue, page: page || 1}, function (list) {
                var str = "";
                if (list == null || list.length == 0) {
                    replyUL.html("");
                    return;
                }
                for (var i = 0, len = list.length || 0; i < len; ++i) {
                    str+=<li class="left clearfix" data-rno=list[i].>
                        <div>
                        <div class="header">
                        <strong class="primary-font">user00</strong>
                        <jsp:useBean id="date" class="java.util.Date"/>
                        <small class="pull-right text-muted">
                        <fmt:formatDate value="${date}"
                                        pattern="yyyy-MM-dd hh:mm"/></small>
                        </div>
                        <p>Good job!</p>
                    </div>
                    </li>
                }
            })
        }

        // replyService.add({reply:"JS Test",replyer:"tester",bno:bnoValue},function(result){
        //     alert("RESULT: "+result);
        // });
        //
        // replyService.getList({bno:bnoValue,page:1},function (list) {
        //     for(var i=0,len=list.length||0;i<len;++i){
        //         console.log(list[i]);
        //     }
        // });
        //
        // replyService.remove(14,function(count){
        //     console.log(count);
        //     if(count==="success"){
        //         alert("REMOVED");
        //     }
        // },function(err){
        //     alert('REMOVE ERROR...');
        // });
        //
        // replyService.update({
        //     rno:17,
        //     bno:bnoValue,
        //     reply:"Modified Reply....."
        // },function (result) {
        //     alert("RESULT : "+result);
        // },function (err) {
        //     alert('MODIFY ERROR....');
        // });
        // replyService.get(20,function(data){
        //     console.log(data);
        // });

        var operForm = $("#operForm");
        $("button[data-oper='modify']").on("click", function (e) {
            operForm.submit();
        });
        $("button[data-oper='list']").on("click", function (e) {
            operForm.find("#bno").remove();
            //removeall childelement
            // operForm.empty();
            //remove node with 'id=bno'
            //operForm.find("#bno").remove();
            operForm.attr("action", "/board/list").submit();
        });
    });
</script>