var host = location.host;
layui.use(['layer', 'table', 'form', 'element'], function () {
    var $ = layui.jquery; // 重点处
    var layer = layui.layer // 弹层
        , table = layui.table // 表格
        , form = layui.form // 表单
        , element = layui.element;
    // 执行一个 table 实例
    table.render({
        elem: '#test',
        height: 490,
        url: '/user/json',
        page: true // 开启分页
        ,
        cols: [[ // 表头
            {
                field: 'username',
                title: '用户名',
                width: 150
            }, {
                field: 'password',
                title: '密码',
                width: 150,
                sort: true
            }, {
                field: 'usertype',
                title: '用户类型',
                width: 150,
                sort: true
            }, {
                field: 'roleid',
                title: '角色id',
                width: 150,
                sort: true
            }, {
                field: 'userdescription',
                title: '描述信息',
                width: 150,
                sort: true
            },
            {
                fixed: 'right',
                title: '操作',
                align: 'center',
                toolbar: '#barDemo'
            }]]
    });

    $(document).on(
        "click",
        "#submit_button",
        function () {
            if ($("#window input[type='text']").val() != "") {
                $.ajax({
                    url: '/user/update',
                    type: 'POST', // GET
                    async: true, // 或false,是否异步
                    timeout: 5000, // 超时时间
                    data: $("#window").serialize(),
                    dataType: 'json',
                    success: function (data) {
                        if (data.success) {
                            layer.msg('修改成功');
                            setTimeout(function () {
                                window.location.href = "http://" + host
                                    + "/user/list";
                            }, 500);
                        } else {
                            layer.msg("修改失败");
                        }
                    },
                    error: function (xhr, textStatus) {
                        layer.msg("错误");
                    }
                })
            }
        });

    $(document).on("click", "#add", function () {
        if ($("#window input[type='text']").val() != "") {
            $.ajax({
                url: '/user/add',
                type: 'POST', // GET
                async: true, // 或false,是否异步
                timeout: 5000, // 超时时间
                data: $("#window").serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        layer.msg('添加成功');
                        setTimeout(function () {
                            window.location.href = "http://" + host
                                + "/user/list";
                        }, 500);
                    } else {
                        layer.msg("添加失败");
                    }
                },
                error: function (xhr, textStatus) {
                    layer.msg("错误");
                }
            })
        }
    });

    $(document).on("click", "#add_button", function () {
        $("#window").find("input[type='text']").val("");
        $("#window").find("input").attr("disabled", false);
        $("#submit_button").hide();
        $("#add").show();
        $("#reset_button").show();
        layer.open({
            type: 1,
            title: '添加',
            area: ['860px', '560px'],
            shadeClose: true, // 点击遮罩关闭
            content: $('#window')
        });
    });

    $(document).on("click", "#search_button", function () {
        var sw = $("#search_name").val() || "";
        var ip = $("#search_ip").val() || "";
        if (sw != "") {
            table.render({
                elem: '#test',
                height: 490,
                url: '/user/json?name=' + encodeURIComponent(sw) + "&ip=" + ip,
                post: {},
                page: true // 开启分页
                ,
                cols: [[ // 表头
                    {
                        field: 'name',
                        title: '服务器名称',
                        width: 150
                    }, {
                        field: 'ip',
                        title: '服务器ip',
                        width: 150,
                        sort: true
                    }, {
                        field: 'computeros',
                        title: '服务器系统',
                        width: 150,
                        sort: true
                    }, {
                        field: 'computerpwd',
                        title: '系统密码',
                        width: 150,
                        sort: true
                    }, {
                        field: 'computetype',
                        title: '打开/关闭电源',
                        width: 150,
                        sort: true
                    }, {
                        field: 'serveradmin',
                        title: '服务器管理人员',
                        width: 150,
                        sort: true
                    }, {
                        field: 'comment',
                        title: '备注',
                        width: 150,
                        sort: true
                    }, {
                        fixed: 'right',
                        title: '操作',
                        align: 'center',
                        toolbar: '#barDemo'
                    }]]
            });
        } else {
            layer.msg('请输入检索内容');
        }
    });
    // 监听工具条
    table.on('tool(demo)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        // lay-filter="对应的值"
        var data = obj.data // 获得当前行数据
            , layEvent = obj.event; // 获得 lay-event 对应的值
        if (layEvent === 'detail') {
            var aa = "userid,username,password,usertype,roleid,userdescription";
            var aa2 = aa.split(",");
            for (var i = 0; i < aa2.length; i++) {
                var name2 = aa2[i];
                $("input[name='" + name2 + "']").val(data[name2]);
            }
            $("#add").hide();
            $("#submit_button").hide();
            $("#reset_button").hide();
            $("#window").find("input").attr("disabled", true);
            layer.open({
                type: 1,
                title: '查看',
                area: ['860px', '560px'],
                shadeClose: true, // 点击遮罩关闭
                content: $('#window')
            });
        } else if (layEvent === 'del') {
            layer.confirm('真的删除么', function (index) {
                /*
                 * obj.del(); //删除对应行（tr）的DOM结构 layer.close(index);
                 */
                // 向服务端发送删除指令
                $.ajax({
                    url: '/user/delete?userid=' + data.userid,
                    type: 'POST', // GET
                    async: true, // 或false,是否异步
                    timeout: 5000, // 超时时间
                    dataType: 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
                    success: function (data) {
                        if (data.success) {
                            layer.msg('刪除成功');
                            setTimeout(function () {
                                window.location.href = "http://" + host
                                    + "/user/list";
                            }, 1000);
                        } else {
                            layer.msg("删除失败");
                        }
                    },
                    error: function (xhr, textStatus) {
                        layer.msg("错误");
                    }
                })
            });
        } else if (layEvent === 'edit') {
            /* var magid=$(this).parent().find("input[name='magid']").val(); */
            var aa = "userid,username,password,usertype,roleid,userdescription";
            var aa2 = aa.split(",");
            for (var i = 0; i < aa2.length; i++) {
                var name2 = aa2[i];
                $("input[name='" + name2 + "']").val(data[name2]);
            }
            $("input[name='id']").val(data.id);
            $("#window").find("input").attr("disabled", false);
            $("#add").hide();
            $("#submit_button").show();
            $("#reset_button").show();
            layer.open({
                type: 1,
                title: '编辑',
                area: ['860px', '560px'],
                shadeClose: true, //点击遮罩关闭
                content: $('#window')
            });
        }
    });

});