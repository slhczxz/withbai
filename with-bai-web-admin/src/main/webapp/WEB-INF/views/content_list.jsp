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
                产品管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">产品管理</li>
                <li class="active">基金列表</li>
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
                            <h3 class="box-title">基金列表</h3>
                        </div>
                        <div class="row">
                            <div class="col-sm-12" style="padding-left: 25px">
                                <a href="${pageContext.request.contextPath}/content/form" type="button" class="btn btn-sm btn-default"><i
                                        class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;
                                <a type="button" onclick="deleteItem()" class="btn btn-sm btn-default"><i
                                        class="fa fa-trash"></i> 删除</a>&nbsp;&nbsp;
                                <a type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;
                                <a type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>
                            </div>
                        </div>
                        <!-- /.box-header -->

                        <div class="box-body">
                            <div class="col-sm-4 form-group">
                                <label for="name" class="col-sm-4 control-label" style="line-height: 34px;heigth:34px">名称</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="name" placeholder="基金名称"/>
                                </div>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label for="code" class="col-sm-4 control-label" style="line-height: 34px;heigth:34px">基金代码</label>
                                <div class="col-sm-8">
                                    <input type="text" id="code" class="form-control" placeholder="基金代码">
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
                                    <th>简称</th>
                                    <th>基金代码</th>
                                    <th>最低投资金额</th>
                                    <th>单价</th>
                                    <th>数量</th>
                                    <th><select id="select" name="type" onchange="select()">
                                        <option selected="" value="2">默认</option>
                                        <option value="1">理财</option>
                                        <option value="0">基金</option>
                                    </select></th>
                                    <th>操作</th>
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
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!--/.modal-->
<!--modal-->
<div class="modal fade" id="modal-default2">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">友情提醒</h4>
            </div>
            <div class="modal-body">
                <p id="model-message2"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="delete"type="button" onclick="btnModalClick(value)" class="btn btn-primary">确定</button>
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
        //iCheck for checkbox and radio inputs
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


    function deleteItem() {
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

            $("#delete").val(_idArray);
            $("#model-message2").html("确认删除?");
            //弹出
            $("#modal-default2").modal("show");

        }
    }

    function btnModalClick(value) {
        //隐藏
        $("#modal-default2").modal("hide");
        //ajax
        $.ajax({
            "url": "${pageContext.request.contextPath}/content/deletemulti",
            "type": "GET",
            "data": {"fids": value.toString()},
            "dataType": "JSON",
            "success": function (data) {
                //BaseResult  : status   message
                //更新页面
                window.location.reload();

                alert(data.message);

            }

        });
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
            "url": "${pageContext.request.contextPath}/content/page"
        },
        "columns": [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.fid + '" type="checkbox" class="minimal">';
                }
            },
            {"data": "fid"},
            {"data": "name"},
            {"data": "code"},
            {"data": function (row, type, val, meta) {
                    return "¥"+row.baseline;
                }},
            {"data": function (row, type, val, meta) {
                    return "¥"+row.unitPrice;
                }},
            {"data": "overallscope"},
            {"data": function(row, type, val, meta){

                    if(row.power==0){
                        return "基金";
                    }
                    return "理财";
                }},
            {
                "data": function (row, type, val, meta) {
                    return '<button type="button" onclick="showDetail(' + row.fid + ')" class="btn btn-sm btn-default"><i class="fa fa-search"></i>查看</button>&nbsp;&nbsp;' +
                        '<a type="button" href="${pageContext.request.contextPath}/content/form?fid=' + row.fid + '" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;' +
                        '<a type="button" class="btn btn-sm btn-danger"  onclick="deletebyId('+row.fid+')"><i class="fa fa-trash"></i>删除</a>'

                }
            }


        ],
        "drawCallback": function (settings) {
            //表格重绘后的回调函数
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
        var name = $("#name").val();
        var code = $("#code").val();
        var param = {
            "code": code,
            "name": name
        };
        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }

    function select(){
        var name = $("#name").val();
        var code = $("#code").val();
        var option = $("#select").val();
        var param = {
            "power":option,
            "code": code,
            "name": name
        };
        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }

    function showDetail(fid) {
        $.ajax({
            "url": "${pageContext.request.contextPath}/content/detail?fid=" + fid,
            "type": "GET",
            "dataType": "HTML",
            "success": function (data) {
                $("#detail-message1").html(data);
                $("#detail-default1").modal("show");
            }

        });


    }
    function deletebyId(fid) {
        $.ajax({

            url: "${pageContext.request.contextPath}/content/deleteById",
            type: "GET",
            data: {"fid": fid},
            dataType: "JSON",
            success: function (data) {
                window.location.reload();
                alert(data.message);
            }
        });

    }

</script>

</body>
</html>
