<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 后台管理</title>
    <jsp:include page="../includes/header.jsp"/>



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
                <li>产品管理</li>
                <li class="active">${loan.lid==null?"新增":"编辑"}贷款</li>
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
                            <h3 class="box-title"> ${loan.lid==null?"新增":"编辑"}贷款</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <%--<form class="form-horizontal" action="/user/save" method="post">--%>
                        <form:form cssClass="form-horizontal" action="${pageContext.request.contextPath}/loanlist/save" method="post" modelAttribute="loan">
                            <form:hidden path="lid"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">贷款项目</label>

                                    <div class="col-sm-10">
                                            <%-- <input type="text" class="form-control" value="${tbUser.username}" name="username" id="username" placeholder="姓名">--%>
                                        <form:input cssClass="form-control" path="name" placeholder="贷款项目"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="amount" class="col-sm-2 control-label">贷款额度</label>

                                    <div class="col-sm-10">
                                        <form:input path="amount" cssClass="form-control" placeholder="贷款额度"/>
                                            <%--  <input type="text" class="form-control" name="phone" id="phone" placeholder="电话">
                                         --%> </div>
                                </div>
                                <div class="form-group">
                                    <label for="cost" class="col-sm-2 control-label">总费用</label>

                                    <div class="col-sm-10">
                                        <form:input path="cost" cssClass="form-control" placeholder="总费用"/>
                                            <%--<input type="email" class="form-control" name="email" id="email" placeholder="邮箱">
                                        --%></div>
                                </div>

                                <div class="form-group">
                                    <label for="ltvRatio" class="col-sm-2 control-label">质押率</label>

                                    <div class="col-sm-10">
                                        <form:input path="ltvRatio" cssClass="form-control" placeholder="质押率"/>
                                            <%--<input type="email" class="form-control" name="email" id="email" placeholder="邮箱">
                                        --%></div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
                                <button type="submit" class="btn btn-info pull-right" >提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
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

</body>
</html>
