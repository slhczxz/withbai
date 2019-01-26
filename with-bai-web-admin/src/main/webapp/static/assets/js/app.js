var App=function(){
    var handlerAlert=function(){
        alert("nihao");
    };
    var handlercheckAllInit=function(){
        //iCheck for checkbox and radio inputs样式
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
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
    };

    return {

        alert: function () {
            handlerAlert();
        },
        checkAllInit:function(){
            handlercheckAllInit();
        }
    }
}();