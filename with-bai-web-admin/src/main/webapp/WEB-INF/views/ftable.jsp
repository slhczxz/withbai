<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/11 0011
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #tb td{width:240px;text-align:center;}
</style>
<body>
<table id="tb" cellpadding="0px" cellspacing="0px" border="1px black solid" align="center">
    <tr>
        <td>基金简称</td>
        <td>${fund.name}</td>
    </tr>
    <tr>
        <td>基金代码</td>
        <td>${fund.code}</td>
    </tr>
    <tr>
        <td>类型</td>
        <td>
            <input type="radio" ${fund.power==0?"checked":""} disabled="true"/>基金
            <input type="radio" ${fund.power==1?"checked":""} disabled="true"/>理财
        </td>
    </tr>
    <tr>
        <td>风险等级</td>
        <td>
            <input type="radio" ${fund.risklevel=="高风险"?"checked":""} disabled="true"/>高风险
            <input type="radio" ${fund. risklevel=="中风险"?"checked":""} disabled="true"/>中风险
            <input type="radio" ${fund. risklevel=="低风险"?"checked":""} disabled="true"/>低风险
        </td>
    </tr>
    <tr>
        <td>单价</td>
        <td>${fund.unitPrice}</td>
    </tr>
    <tr>
        <td>日利率</td>
        <td>${fund.interestRate}</td>
    </tr>

    <tr>
        <td>最低起步金额</td>
        <td>${fund.baseline}</td>
    </tr>
    <tr>
        <td>基金公司</td>
        <td>${fund.company}</td>
    </tr>
    <tr>
        <td>总经理</td>
        <td>${fund.generalmanager}</td>
    </tr>
    <tr>
        <td>总规模</td>
        <td>${fund.overallscope}</td>
    </tr>
    <tr>
        <td>总资产</td>
        <td>${fund.totalassets}</td>
    </tr>
    <tr>
        <td>公司成立日期</td>
        <td>${fund.dateofestablishment}</td>
    </tr>
    <tr>
        <td>介绍</td>
        <td style="word-wrap:break-word;word-break:break-all;">${fund.introduction}</td>
    </tr>

</table>

</body>
</html>
