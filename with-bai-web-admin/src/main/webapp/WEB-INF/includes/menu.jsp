<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p> ${admin.name}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">功能菜单</li>

            <li class="active treeview">
                <a href="####">
                    <i class="fa  fa-square"></i> <span>控制面板</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
               <ul class="treeview-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/info/index"><i class="fa fa-info"></i> 消息面板</a></li>

                </ul>
            </li>

            <li class="active treeview">
                <a href="####">
                    <i class="fa fa-users"></i> <span>用户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/user/list"><i class="fa fa-user"></i> 用户列表</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/user/form"><i class="fa fa-user-plus"></i> 新增用户</a></li>
                </ul>
            </li>

            <li class="active treeview">
                <a href="####">
                    <i class="fa fa-user-secret"></i> <span>产品管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/loanlist/loan_list"><i class="fa  fa-sort"></i> 贷款列表</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/content/content_list"><i class="fa fa-money"></i>基金/理财列表</a></li>
                </ul>
            </li>

            <li class="active treeview">
                <a href="####">
                    <i class="fa fa-cc-stripe"></i> <span>订单管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/loan/loan_list"><i class="fa fa-cc-jcb"></i> 贷款订单</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/fund/fund_list"><i class="fa fa-cc-visa"></i> 基金/理财订单</a></li>
                </ul>
            </li>

            <li class="active treeview">
                <a href="####">
                    <i class="fa fa-sun-o"></i> <span>日常管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/expert/expert_form"><i class="fa  fa-ship"></i> 特聘专家</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/information/new_form"><i class="fa fa-hacker-news"></i> 经济新闻</a></li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
