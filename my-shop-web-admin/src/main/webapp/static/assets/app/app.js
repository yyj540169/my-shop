var App = function () {

    var _masterCheckbox;
    var _checkbox;

    var _idList;

    /**
     * 私有方法 初始化iCheck
     */
    var handlerInitCheckbox = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
        //获取控制端CheckBox
        _masterCheckbox = $('input[type="checkbox"].minimal.check_master');
        //获取全部CheckBox
        _checkbox = $('input[type="checkbox"].minimal');
    }

    /**
     * Checkbox 的全选功能
     */
    var handleCheckboxAll = function () {
        _masterCheckbox.on("ifClicked",function (e) {
            if (e.target.checked){
                _checkbox.iCheck("uncheck");
            } else{
                _checkbox.iCheck("check");
            }
        })
    };

    /**
     * 批量删除
     */
    var handleDeleteMulti = function(url) {

        _idList = new Array();

        //选中的元素
        // var _checkbox = this.getCheckbox();

        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idList.push(_id);
            }
        })
        if (_idList.length === 0) {
            $("#modal-message").html("请至少选择一项进行删除...");
        }else{
            $("#modal-message").html("确定删除数据？");
        }
        $("#modal-default").modal("show");

        $("#btnFalse").bind("click", function () {
            _idList = [];
        });

        $("#btnModalOk").bind("click", function () {
            del();
        });
        function del() {

            $("#modal-default").modal("hide");
            //如果没有选择项 则关闭模态框
            if (_idList.length === 0) {

            }else{
                $.ajax({
                    "url":url,
                    "type":"post",
                    "data":{"ids":_idList.toString()},
                    "dataType":"json",
                    "success": function (data) {
                       window.location.reload();
                    }
                });
            }
        }

    };

    return{

        init:function () {
            handlerInitCheckbox();
            handleCheckboxAll();
        },
        getCheckbox:function () {

            return _checkbox;
            
        },
        deleteMulti:function(url) {
            handleDeleteMulti(url);
        }

    }
}();

$(document).ready(function () {
    App.init();
})