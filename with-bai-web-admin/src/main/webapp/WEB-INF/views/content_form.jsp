<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 后台管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/jq22.css"/>

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
                产品管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">产品管理</li>
                <li class="active">${fund.fid==null?"新增":"编辑"}内容</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <c:if test="${baseResult.status==500}">
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
                            <h3 class="box-title"> ${fund.fid==null?"新增":"编辑"}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <ul id="tabs">
                            <li><a href="#" title="tab1">新增基金</a></li>
                            <li><a href="#" title="tab2">新增理财</a></li>
                        </ul>
                        <div id="content">
                            <div id="tab1" class="div">
                                <form:form cssClass="form-horizontal" action="${pageContext.request.contextPath}/content/save" method="post"
                                           modelAttribute="fund">
                                    <form:hidden path="fid"/>
                                    <form:hidden path="power" value="0"/>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="name" class="col-sm-2 control-label">简称</label>
                                            <div class="col-sm-10">
                                                <form:input cssClass="form-control" path="name" placeholder="简称"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="fullname" class="col-sm-2 control-label">基金全称</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="fullname" placeholder="基金全称"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="code" class="col-sm-2 control-label">基金代码</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="code" placeholder="基金代码"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="risklevel" class="col-sm-2 control-label">风险等级</label>

                                            <div class="col-sm-10">

                                                <form:radiobutton path="risklevel" value="高风险"/>&nbsp;高风险&nbsp;&nbsp;
                                                <form:radiobutton path="risklevel" value="中风险" />&nbsp;中风险&nbsp;&nbsp;
                                                <form:radiobutton path="risklevel" value="低风险" />&nbsp;低风险&nbsp;&nbsp;

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="unitPrice" class="col-sm-2 control-label">单价</label>

                                            <div class="col-sm-10">
                                                <form:input cssClass="form-control" path="unitPrice" placeholder="单价"/>
                                                    <%--<div id="dropz2" style="border: 2px dashed #0087F7;" class="dropzone"></div>--%>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="interestRate" class="col-sm-2 control-label">日利率</label>

                                            <div class="col-sm-10">
                                                <form:input cssClass="form-control" path="interestRate" placeholder="日利率"/>
                                                    <%--<div id="dropz2" style="border: 2px dashed #0087F7;" class="dropzone"></div>--%>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="baseline" class="col-sm-2 control-label">最低起步金额</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="baseline" placeholder="最低起步金额"/>
                                            </div>
                                        </div>
                                        <form:hidden cssClass="form-control" path="state" value="0" />
                                        <div class="form-group">
                                            <label for="company" class="col-sm-2 control-label">基金公司</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="company" placeholder="基金公司"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dateofestablishment" class="col-sm-2 control-label">公司成立日期</label>

                                            <div class="col-sm-10">

                                                <form:input type="date" cssClass="form-control" path="dateofestablishment" placeholder="公司成立日期"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="generalmanager" class="col-sm-2 control-label">总经理</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="generalmanager" placeholder="总经理"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="overallscope" class="col-sm-2 control-label">总规模</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="overallscope" placeholder="总规模"/>
                                                    <%-- <div id="dropz" style="border: 2px dashed #0087F7;" class="dropzone"></div>--%>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="introduction" class="col-sm-2 control-label">介绍</label>

                                            <div class="col-sm-10">
                                                <%--<div id="editor">
                                                        ${fund.introduction}
                                                </div>--%>
                                                <form:textarea rows="7px" cssClass="form-control" path="introduction" placeholder="介绍"/>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.box-body -->
                                    <div class="box-footer">
                                        <button type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
                                        <button type="submit" onclick="save()" class="btn btn-info pull-right">提交</button>
                                    </div>
                                    <!-- /.box-footer -->
                                </form:form>
                            </div>
                            <div id="tab2" class="div">
                                <form:form cssClass="form-horizontal" action="${pageContext.request.contextPath}/content/save" method="post"
                                           modelAttribute="fund">
                                    <form:hidden path="fid"/>
                                    <form:hidden path="power" value="1"/>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="name" class="col-sm-2 control-label">简称</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="name" placeholder="简称"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="investTime" class="col-sm-2 control-label">投资时限</label>

                                            <div class="col-sm-10">

                                                <form:radiobutton path="investTime" value="1"/>&nbsp;0-12个月&nbsp;&nbsp;
                                                <form:radiobutton path="investTime" value="2" />&nbsp;12个月及以上&nbsp;&nbsp;
                                                <form:radiobutton path="investTime" value="3" />&nbsp;活期&nbsp;&nbsp;
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="remainingtime" class="col-sm-2 control-label">结束时间</label>

                                            <div class="col-sm-10">

                                                <form:input type="date" cssClass="form-control" path="remainingtime" placeholder="结束时间"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="unitPrice" class="col-sm-2 control-label">单价</label>

                                            <div class="col-sm-10">
                                                <form:input cssClass="form-control" path="unitPrice" placeholder="单价"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="yearRate" class="col-sm-2 control-label">预期年化收益率</label>

                                            <div class="col-sm-10">
                                                <form:input cssClass="form-control" path="yearRate" placeholder="预期年化收益率"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="baseline" class="col-sm-2 control-label">最低起步金额</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="baseline" placeholder="最低起步金额"/>
                                            </div>
                                        </div>
                                        <form:hidden cssClass="form-control" path="state" value="0" />
                                        <div class="form-group">
                                            <label for="overallscope" class="col-sm-2 control-label">总规模</label>

                                            <div class="col-sm-10">

                                                <form:input cssClass="form-control" path="overallscope" placeholder="总规模"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="introduction" class="col-sm-2 control-label">介绍</label>

                                            <div class="col-sm-10">
                                                <form:textarea rows="7px" cssClass="form-control" path="introduction" placeholder="介绍"/>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.box-body -->
                                    <div class="box-footer">
                                        <button type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
                                        <button type="submit" onclick="save()" class="btn btn-info pull-right">提交</button>
                                    </div>
                                    <!-- /.box-footer -->
                                </form:form>
                            </div>
                        </div>
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

        $("#content .div").hide(); // Initially hide all content
        $("#tabs li:first").attr("id","current"); // Activate first tab
        $("#content div:first").fadeIn();
       // Activate first tab

        var i='${fund.power}';
        if(i==1) {
            $("#content .div").hide(); //Hide all content
            $("#tabs li").attr("id", ""); //Reset id's
            $("#tabs li").eq(1).attr("id", "current"); // Activate this
           $('#'+$('#tabs a').eq(1).attr('title')).fadeIn();
        }

        $('#tabs a').click(function(e) {
            if(i=="") {
                e.preventDefault();
                $("#content .div").hide(); //Hide all content
                $("#tabs li").attr("id", ""); //Reset id's
                $(this).parent().attr("id", "current"); // Activate this
                $('#' + $(this).attr('title')).fadeIn(); // Show content for current tab
            }
        });


</script>

</body>
</html>
