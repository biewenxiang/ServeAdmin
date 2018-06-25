var host = location.host;
layui.use([ 'layer', 'table', 'form', 'element' ], function() {
	var $ = layui.jquery; // 重点处
	var layer = layui.layer // 弹层
	, table = layui.table // 表格
	, form = layui.form // 表单
	, element = layui.element;
	// 执行一个 table 实例
	$(document).on("click", "#login", function() {
		if ($("#login_form input").val() != "") {
			$.ajax({
				url : '/login',
				type : 'POST', // GET
				async : true, // 或false,是否异步
				timeout : 5000, // 超时时间
				data : $("#login_form").serialize(),
				dataType : 'text',
				success : function(data) {
					if (data == "success") {
						layer.msg('登录成功');
						setTimeout(function() {
							window.location.href = "http://" + host + "/admin";
						}, 500);
					} else {
						layer.msg("账户或密码错误");
					}
				},
				error : function(xhr, textStatus) {
					layer.msg("错误");
				}
			})
		}
	});

});