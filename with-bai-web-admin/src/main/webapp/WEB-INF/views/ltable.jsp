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
    #tb td{width:230px;text-align:center;}
</style>
<body>
<table id="tb" cellpadding="0px" cellspacing="0px" border="1px black solid" align="center">
    <tr>
        <td>理财简称</td>
        <td>${fund.name}</td>
    </tr>
    <tr>
        <td>类型</td>
        <td>
            <input type="radio" ${fund.power==0?"checked":""} disabled="true"/>基金
            <input type="radio" ${fund.power==1?"checked":""} disabled="true"/>理财
        </td>
    </tr>
    <tr>
        <td>投资时限</td>
        <td>
            <input type="radio" ${fund.investTime==1?"checked":""} disabled="true"/>0-12个月
            <input type="radio" ${fund.investTime==2?"checked":""} disabled="true"/>12个月及以上
            <input type="radio" ${fund.investTime==3?"checked":""} disabled="true"/>活期
        </td>
    </tr>
    <tr>
        <td>单价</td>
        <td>${fund.unitPrice}</td>
    </tr>
    <tr>
        <td>预期年化收益率</td>
        <td>${yearRate}</td>
    </tr>

    <tr>
        <td>最低起步金额</td>
        <td>${fund.baseline}</td>
    </tr>
    <tr>
        <td>总规模</td>
        <td>${fund.overallscope}</td>
    </tr>
    <tr>
        <td>介绍</td>
        <td style="word-wrap:break-word;word-break:break-all;">${fund.introduction}</td>
    </tr>

</table>

</body>
</html>
