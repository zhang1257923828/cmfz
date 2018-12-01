<%@page pageEncoding="utf-8" isELIgnored="false" contentType="text/html; utf-8" %>
<html>
<head>
    <script type="text/javascript">

        var tb = [{
            //添加专辑
            iconCls: 'icon-edit',
            text: "添加专辑",
            handler: function () {
                $("#album_add").dialog("open");

            }
        }, '-', {
            //添加章节
            iconCls: 'icon-help',
            text: "添加章节",
            handler: function () {
                var row = $("#albumbg").treegrid("getSelected");
                if (row == null) {
                    alert("请先选中专辑")
                } else {
                    $("#chapter_add").dialog("open")
                    $("#p_id").val(row.id)
                }

            }
        }, '-', {
            text: "专辑详情",
            iconCls: 'icon-help',
            handler: function () {
                /*展示专辑相关的信息*/
                $('#album_ff').dialog("open")
                /*把专辑信息填充到dialog*/
                var r = $("#albumbg").treegrid("getSelected");
                console.log(r)
                if (r.author == null) {
                    alert("请先选中专辑")
                } else {
                    if (r.author != null) {
                        $("#album_ff").form("load", r);
                        $("#album_img").prop("src", "${pageContext.request.contextPath}/img/" + r.coverImg)
                    } else {
                        alert("请先选中专辑")
                    }
                }
            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-help',
            handler: function () {
                var row = $("#albumbg").treegrid("getSelected");
                if (row != null) {
                    if (row.size != null) {

                        location.href = "${pageContext.request.contextPath}/chapter/download?url=" + row.url + "&title=" + row.title
                        alert(title)
                    }
                }
            }
        }];

        $(function () {
            $('#albumbg').treegrid({
                onDblClickRow: function (w) {
                    $("#audio").dialog("open")
                    $("#audio_id").prop("src", "${pageContext.request.contextPath}/upload/" + w.downPath)
                },
                toolbar: tb,
                url: '${pageContext.request.contextPath}/album/selectAll',
                idField: 'id',
                treeField: 'title',
                columns: [[
                    {field: 'title', title: '名字', width: 60},
                    {field: 'downPath', title: '路径', width: 60},
                    {field: 'size', title: '大小', width: 80},
                    {field: 'duration', title: '时长', width: 80}
                ]],
                fit: true,
                fitColumns: true
            });

            $('#album_ff').dialog({
                title: '专辑详情',
                width: 400,
                height: 200,
                closed: true,
            });
            //添加章节
            $('#album_add').dialog({
                title: '添加专辑',
                width: 400,
                height: 200,
                closed: true,
                buttons: [{
                    text: '保存',
                    handler: function () {
                        addAlbum();
                    }
                }, {
                    text: '关闭',
                    handler: function () {
                        $("#album_add").dialog("close")
                    }
                }],
            });

            $('#audio').dialog({
                title: '播放',
                width: 400,
                height: 200,
                closed: true,
            });
            //添加章节
            $('#chapter_add').dialog({
                title: '添加章节',
                width: 400,
                height: 200,
                closed: true,
                buttons: [{
                    text: '保存',
                    handler: function () {
                        addChapter();
                    }
                }, {
                    text: '关闭',
                    handler: function () {
                        $("#chapter_add").dialog("close")
                    }
                }],
            });

        })

        function addChapter() {

            $('#chapter_ff').form('submit', {
                url: "${pageContext.request.contextPath}/chapter/addChapter"
            })
        }

        function addAlbum() {
            alert(1)
            $("#album_fr").form("submit", {
                url: "${pageContext.request.contextPath}/album/addAlbum"
            })
            alert(5)
        }


    </script>

</head>

<table id="albumbg"></table>


<div>
    <form id="album_ff">

        <input type="text" name="title"/><br>

        <input type="text" name="author"/><br>
        <input type="text" name="brief"/><br>
        <img src="" id="album_img">
        </table>
    </form>
</div>

<div id="chapter_add">

    <form id="chapter_ff" method="post" ENCTYPE="multipart/form-data">
        <div>
            标题:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            请选择:<input type="file" name="chapter" style="width:300px">
        </div>
        <div>
            <input type="hidden" name="id" id="p_id" value="" style="width:300px">
        </div>
    </form>
</div>
<div id="audio">
    <audio id="audio_id" src="" autoplay="autoplay" controls="controls" loop="loop"></audio>
</div>
<div id="album_add">
    <form id="album_fr" method="post" enctype="multipart/form-data">
        标题：<input type="text" name="title"><br>
        图片名：<input type="file" name="pic" style="width:300px"><br>
        数量：<input type="text" name="count"><br>
        评分： <input type="text" name="score"><br>
        作者：<input type="text" name="author"><br>
        简介：<input type="text" name="broadCast"><br>
        摘要：<input type="text" name="brief">

    </form>
</div>


</html>