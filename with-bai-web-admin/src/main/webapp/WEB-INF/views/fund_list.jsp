<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <title>用呗 | 后台管理</title>
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
                订单管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>订单管理</li>
                <li class="active">基金/理财订单</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <c:if test="${baseResult.status==200}">
                <div class="row">
                    <div class="box-body">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </div>
                </div>
            </c:if>

            <!-- Small boxes (Stat box) -->
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">基金/理财订单</h3>
                        </div>

                        <div class="row">
                            <div class="col-sm-12" style="padding-left: 25px">
                                <a type="button" onclick=" approveItems()" class="btn btn-sm btn-default"><i
                                        class="fa fa-trash"></i> 批量审批</a>&nbsp;&nbsp;
                                <a type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;
                                <a type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>
                            </div>
                        </div>
                        <!-- /.box-header -->

                        <div class="box-body" style="padding-bottom: 0px;padding-top: 30px;">
                            <div class="col-sm-4 form-group">
                                <label for="userName" class="col-sm-4 control-label" style="line-height: 34px;heigth:34px">用户名</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="userName" placeholder="用户名"/>
                                </div>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label for="fundName" class="col-sm-4 control-label" style="line-height: 34px;heigth:34px">贷款项目</label>
                                <div class="col-sm-8">
                                    <input type="text" id="fundName" class="form-control" placeholder="贷款项目">
                                </div>
                            </div>
                            <div class="box-tools">
                                <button type="button" onclick="search()" class="btn  btn-primary btn-sm" >搜索</button>
                            </div>
                        </div>


                        <div class="box-body table-responsive no-padding">
                            <table id="datatable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal checkbox-master"></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>产品名称</th>
                                    <th>利率</th>
                                    <th>投资金额</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th><select id="select" name="type" onchange="select()">
                                        <option selected="" value="2">默认</option>
                                        <option value="1">理财</option>
                                        <option value="0">基金</option>
                                    </select></th>
                                    <th><select id="select1" name="type" onchange="select()">
                                        <option selected="" value="2">默认</option>
                                        <option value="1">已审核</option>
                                        <option value="0">未审核</option>
                                    </select></th>
                                    <th>管理</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
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

<!--modal-->
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">友情提醒</h4>
            </div>
            <div class="modal-body">
                <p id="model-message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button type="button" onclick="btnModalClick()" class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!--/.modal-->
<jsp:include page="../includes/mtk.jsp"/>
<jsp:include page="../includes/footer.jsp"/>
<script src="${pageContext.request.contextPath}/static/assets/js/datetime.js"></script>
<script>


    function icheckfun() {
        //iCheck for checkbox and radio inputs样式
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        })
        //全选/全不选
        _checkboxMaster = $(".checkbox-master");
        _checkbox = $("tbody").find("[type='checkbox']").not("[disabled]");
        _checkboxMaster.on("ifClicked", function (e) {
            // 当前状态已选中，点击后应取消选择
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            // 当前状态未选中，点击后应全选
            else {
                _checkbox.iCheck("check");
            }
        });

    }

    function approveItems() {
        var _idArray = new Array();
        _checkbox.each(function () {
            //判断当前复选框有没有被选中
            var delFlag = $(this).is(":checked");
            if (delFlag) {
                _idArray.push($(this).attr("id"));
            }
        })
        if (_idArray.length == 0) {//弹出莫泰框
            $("#model-message").html("请至少选中一个");
            //弹出
            $("#modal-default").modal("show");

        } else {
            $.ajax({
                "url": "${pageContext.request.contextPath}/fund/approvemulti",
                "type": "GET",
                "data": {"oids": _idArray.toString()},
                "dataType": "JSON",
                "success": function (data) {
                    window.location.reload();
                    alert(data.message);
                }
            });
        }
    }
    function approve(oid,state){
        if(state==0) {
            $.ajax({
                "url": "${pageContext.request.contextPath}/fund/approvemulti",
                "type": "GET",
                "data": {"oids": oid},
                "dataType": "JSON",
                "success": function (data) {
                    window.location.reload();
                    alert(data.message);
                }
            });
        }else{
            alert("该订单已审核");
        }
    }

    function btnModalClick() {
        //隐藏
        $("#modal-default").modal("hide");
    }

    function show(uid) {
        $.ajax({
            url: "${pageContext.request.contextPath}/user/show",
            type: "GET",
            data: {"uid": uid},
            dataType: "HTML",
            success: function (data) {
                $("#modal-detail").html(data);
                $("#modal-user").modal("show");
            }
        });
    }

    function btnModal() {
        $("#detail-default").modal("hide");
    }

    var oTable = $("#datatable").DataTable({
        "autoWidth": true,
        "info": true,
        "lengthChange": false,
        "ordering": false,
        "paging": true,
        "searching": false,
        "serverSide": true,
        "ajax": {
            "url": "${pageContext.request.contextPath}/fund/page",
        },
        "columns": [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.oid+':'+row.user.uid +'" type="checkbox" class="minimal">';
                }
            },
            {"data":"oid"},
            {"data":"user.name"},
            {"data":"fund.name"},
            {"data":"fund.interestRate"},
            {"data":"loanMoney"},
            {"data":function(row, type, val, meta){
                    return DateTime.format(row.startTime,"yyyy-MM-dd HH:mm:ss");
                }
            },
            {"data":function(row, type, val, meta){
                    return DateTime.format(row.endTime,"yyyy-MM-dd HH:mm:ss");
                }
            },
            {"data": function(row, type, val, meta){

                    if(row.fund.power==0){
                        return "基金";
                    }
                    return "理财";
                }},
            {"data":function(row, type, val, meta){
                    if(row.state==1){
                        return  '<a type="button" class="btn btn-sm btn-success"><i class="fa fa-check-square-o"></i>&nbsp;已审批</a>';
                    }else{
                        return  '<a type="button" class="btn btn-sm btn-danger"><i class="fa fa-times-circle-o"></i>&nbsp;待审批</a>'
                    }
                }},
            {
                "data": function (row, type, val, meta) {
                    return '<a type="button" class="btn btn-sm btn-default" onclick="show('+row.user.uid+')"><i class="fa fa-search"></i>查看</a>&nbsp;&nbsp;'+
                        '<a type="button" class="btn btn-sm btn-primary" onclick="approve('+row.oid+','+row.state+')"><i class="fa fa-edit"></i>通过审批</a>&nbsp;&nbsp;'

                }
            }


        ],
        "drawCallback": function (settings) {
            //初始化后的回调函数
            icheckfun();

        },
        language: {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        }
    });

    function search() {
        var name = $("#userName").val();
        var fundName = $("#fundName").val();
        var param = {
            "user.name": name,
            "fund.name": fundName
    };
        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }

    function select(){
        var name = $("#userName").val();
        var fundName = $("#fundName").val();
        var option = $("#select").val();
        var option1 = $("#select1").val();
        var param = {
            "fund.power":option,
            "user.name": name,
            "fund.name": fundName,
            "state":option1
        };
        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }
    function select1(){
        var name = $("#userName").val();
        var fundName= $("#fundName").val();
        var option = $("#select").val();
        var option1 = $("#select1").val();
        var param = {
            "fund.power":option,
            "user.name": name,
            "fund.name": fundName,
            "state":option1
        };
        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }

</script>
</body>
</html>

