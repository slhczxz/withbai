<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/5 0005
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form cssClass="form-horizontal" action="${pageContext.request.contextPath}/user/save" method="post" modelAttribute="tbUser">
    <form:hidden path="uid"/>
    <div class="box-body">
        <div class="form-group">
            <label for="name" class="col-xs-2 control-label">姓名</label>

            <div class="col-sm-10">
                    <%-- <input type="text" class="form-control" value="${tbUser.username}" name="username" id="username" placeholder="姓名">--%>
                <form:input cssClass="form-control" path="name" placeholder="姓名" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-xs-2 control-label">电话</label>

            <div class="col-sm-10">
                <form:input path="phone" cssClass="form-control" placeholder="电话"  readonly="true"/>
                    <%--  <input type="text" class="form-control" name="phone" id="phone" placeholder="电话">
                 --%> </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-xs-2 control-label">邮箱</label>

            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control" placeholder="邮箱"  readonly="true"/>
                    <%--<input type="email" class="form-control" name="email" id="email" placeholder="邮箱">
                --%></div>
        </div>
        <div class="form-group">
            <label for="created" class="col-xs-2 control-label">创建时间</label>

            <div class="col-sm-10">
                <form:input path="created" cssClass="form-control" placeholder="创建时间"  readonly="true"/>
                    <%--<input type="email" class="form-control" name="email" id="email" placeholder="邮箱">
                --%></div>
        </div>
        <div class="form-group">
            <label for="updated" class="col-xs-2 control-label">更新时间</label>

            <div class="col-sm-10">
                <form:input path="updated" cssClass="form-control" placeholder="更新时间"  readonly="true"/>
                    <%--<input type="email" class="form-control" name="email" id="email" placeholder="邮箱">
                --%></div>
        </div>
        <div style="float:right"><img src="${pageContext.request.contextPath}/static/assets/img/xy.jpg"></div>

    </div>
    <!-- /.box-body -->
</form:form>
</body>
</html>
