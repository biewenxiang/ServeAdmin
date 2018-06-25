  window.global = {
        pageType: 'demo'
        , preview: function () {
            var preview = document.getElementById('LAY_preview');
            return preview ? preview.innerHTML : '';
        }()
    };
    layui.config({
        base: '//res.layui.com/lay/modules/layui/'
        , version: '1515376178709'
    }).use('global');

    layui.use(['element', 'layer', 'util', 'jquery', 'form'], function () {
        //监听左侧导航点击
        var $ = layui.jquery;
        var element = layui.element;
        element.on('nav(leftnav)', function (elem) {
            var url = $(elem).children('a').attr('data-url');
            var id = $(elem).children('a').attr('data-id');
            var title = $(elem).children('a').text();
            if (title == "首页") {
                element.tabChange('tab', 0);
                return;
            }
            if (url == undefined) return;

            var tabTitleDiv = $('.layui-tab[lay-filter=\'tab\']').children('.layui-tab-title');
            var exist = tabTitleDiv.find('li[lay-id=' + id + ']');
            if (exist.length > 0) {
                //切换到指定索引的卡片
                element.tabChange('tab', id);
            } else {
                var index = layer.load(1);
                $.ajax({
                    type: 'post',
                    url: url,
                    success: function (data) {
                        layer.close(index);
                        element.tabAdd("tab", {
                            title: title,
                            content: "<iframe src='" + url + "' data-id='" + id + "'></iframe>",
                            id: id
                        });
                        //切换到指定索引的卡片
                        element.tabChange('tab', id);
                    },
                    error: function (e) {
                        var message = e.responseText;
                        layer.close(index);
                        layer.msg(message, {icon: 2});
                    }
                });

            }
        });
    })