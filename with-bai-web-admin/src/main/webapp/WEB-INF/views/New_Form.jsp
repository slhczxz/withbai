<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 后台管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/assets/plugins/dropzone/min/dropzone.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/plugins/dropzone/min/basic.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/assets/plugins/wangEditor/wangEditor.min.css"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                日常管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">特聘专家</li>
                <li class="active">新增专家</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <c:if test="${!empty baseResult}">
                <div class="row">
                    <div class="box-body">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </div>
                </div>
            </c:if>
            <div class="row">
                <div class="col-md-12">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">新增专家</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <%--<form class="form-horizontal" action="/user/save" method="post">--%>
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/information/save"
                              method="post">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">新闻标题</label>

                                    <div class="col-sm-10">

                                        <input class="form-control" id="title" name="title" placeholder="新闻标题"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="content" class="col-sm-2 control-label">内容</label>

                                    <div class="col-sm-10">

                                        <textarea cols="20px" Class="form-control" id="content" name="content"
                                                  placeholder="内容"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="image" class="col-sm-2 control-label">上传图片</label>

                                    <div class="col-sm-10">

                                        <input type="hidden" class="form-control" id="image" name="image"
                                               placeholder="上传图片"/>
                                        <div id="dropz" style="border: 2px dashed #0087F7;" class="dropzone"></div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
                                <button type="submit" onclick="save()" class="btn btn-info pull-right">提交</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /.row (main row) -->

        </section>
        <!-- /.content -->
    </div>
    <jsp:include page="../includes/copyright.jsp"/>


    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../includes/footer.jsp"/>
<script src="${pageContext.request.contextPath}/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/plugins/wangEditor/wangEditor.min.js"></script>
<script>


    var myDropzone = new Dropzone("#dropz", {
        url: "${pageContext.request.contextPath}/upload",
        dictDefaultMessage: '拖动文件至此或者点击上传',
        paramName: "dropFile",
        init: function () {
            this.on("success", function (file, data) {
                // 上传成功触发的事件
                //将图片路径显示在表单中
                $("#image").val(data.filename);

            });
        }
    });

</script>

</body>
</html>
