<%@page pageEncoding="utf-8" isELIgnored="false" contentType="text/html; utf-8" %>
<html>
<head>
    <script type="text/javascript">
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                $('#dd').dialog({
                    title: '添加',
                    width: 400,
                    height: 300,
                    closed: false,
                    cache: false,
                    //  href: 'get_content.php',
                    modal: true

                });
            }

        }, '-', {
            iconCls: 'icon-help',
            text: "删除",
            handler: function () {
                /*获取选中行*/
                var row = $("#bg").edatagrid("getSelected")
                console.log(row)
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中删除行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行删除*/
                    $("#bg").edatagrid("destroyRow");
                    /* $.messager.show({
                        // msg:"删除成功",
                     })*/
                }
                //重新加载当前页面
                // $("#bg").edatagrid("reload", true);
            }
        }, '-', {
            iconCls: 'icon-help',
            text: "修改",
            handler: function () {
                /*获取选中行*/
                var row = $("#bg").edatagrid("getSelected")
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中修改行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行变成可编辑模式*/
                    var index = $("#bg").edatagrid("getRowIndex", row);
                    $("#bg").edatagrid("editRow", index);
                }

            }
        }, '-', {
            iconCls: 'icon-help',
            text: "保存 ",
            handler: function () {
                $("#bg").edatagrid("saveRow");
            }
        }];

        $(function () {
            $('#bg').edatagrid({
                //通过URL将'id'参数发送到服务器以销毁行。
                destroyUrl: "${pageContext.request.contextPath}/main/delete",

                //该方法在edatagtid中，通过URL更新数据到服务器并返回更新的行。
                updateUrl: "${pageContext.request.contextPath}/main/update",
                toolbar: toolbar,
                url: '${pageContext.request.contextPath}/main/getByPage',

                columns: [[
                    {field: 'title', title: '名字', width: 100},
                    {field: 'status', title: '状态', width: 100, editor: {type: 'text', options: {required: true}}},
                    {field: 'desc', title: '描述', width: 100, align: 'right'}
                ]],
                pagination: true,
                fit: true,
                fitColumns: true,
                pageSize: 3,
                pageList: [3, 6, 9, 12],
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>时间: ' + rowData.date + '</p>' +
                        '<p>描述: ' + rowData.desc + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }


            });
        });

        //添加操作开始
        function doAdd() {
            $("#ff").form("submit", {
                url: "${pageContext.request.contextPath}/main/add",
                //回调函数
                success: function (data) {
                    //因为data是json字符串，所以判断时，要么用JSON.parse()方法解析，要么时其等于一个true字符串进行判断
                    if (data == "true") {
                        //关闭修改对话框
                        $("#dd").dialog("close", true);
                        //刷新展示数据页面
                        // $("#ta").datagrid("reload",true);
                    } else {
                        alert("添加失败");
                    }
                },
            });
        };
        //添加操作====结束===
    </script>
</head>

<table id="bg"></table>
<%--弹出对话框--%>
<div id="dd">
    <form id="ff" method="post">
        标题： <input type="text" name="title"/> </br>
        描述：<input type="text" name="desc"/> </br>
        状态：<input type="text" name="status"/> </br>
        <%-- <input type="submit" value="添加">--%>
        <a href="JavaScript:void(0)" class="easyui-linkbutton" onclick="doAdd()">添加</a>
    </form>
</div>

</html>
