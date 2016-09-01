<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<html>
<head>
    <title>管理系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Cooper Wang">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/home.init.js"></script>

    <script type="text/javascript">
        var _menus = {
            "menus": [
                {
                    "menuid": "1", "icon": "icon-sys", "menuname": "美食管理",
                    "menus": [
                        {"menuid": "12", "menuname": "按菜系管理", "icon": "icon-sys",
                        "menus":[
                            {"menuid": "91", "menuname": "川菜", "icon": "icon-nav", "url": "川菜.html"},
                            {"menuid": "92", "menuname": "湘菜", "icon": "icon-nav", "url": "湘菜.html"},
                            {"menuid": "93", "menuname": "鲁菜", "icon": "icon-nav", "url": "鲁菜.html"},
                            {"menuid": "94", "menuname": "浙菜", "icon": "icon-nav", "url": "浙菜.html"},
                            {"menuid": "94", "menuname": "京菜", "icon": "icon-nav", "url": "京菜.html"},
                            {"menuid": "94", "menuname": "徽菜", "icon": "icon-nav", "url": "徽菜.html"},
                            {"menuid": "94", "menuname": "东北菜", "icon": "icon-nav", "url": "东北菜.html"},
                            {"menuid": "94", "menuname": "西北菜", "icon": "icon-nav", "url": "西北菜.html"},
                            {"menuid": "94", "menuname": "新疆菜", "icon": "icon-nav", "url": "新疆菜.html"},
                            {"menuid": "94", "menuname": "云南菜", "icon": "icon-nav", "url": "云南菜.html"},
                            {"menuid": "94", "menuname": "台湾美食", "icon": "icon-nav", "url": "台湾美食.html"},
                            {"menuid": "94", "menuname": "香港美食", "icon": "icon-nav", "url": "香港美食.html"}
                        ]},
                        {"menuid": "14", "menuname": "按菜式管理", "icon": "icon-sys",
                         "menus":[
                            {"menuid": "91", "menuname": "家常菜", "icon": "icon-nav", "url": "家常菜.html"},
                            {"menuid": "91", "menuname": "下酒菜", "icon": "icon-nav", "url": "下酒菜.html"},
                            {"menuid": "92", "menuname": "甜品", "icon": "icon-nav", "url": "甜品.html"},
                            {"menuid": "93", "menuname": "肉类", "icon": "icon-nav", "url": "肉类.html"},
                            {"menuid": "94", "menuname": "凉菜", "icon": "icon-nav", "url": "凉菜.html"},
                            {"menuid": "94", "menuname": "烘焙", "icon": "icon-nav", "url": "烘焙.html"},
                            {"menuid": "94", "menuname": "煲汤", "icon": "icon-nav", "url": "煲汤.html"},
                            {"menuid": "94", "menuname": "海鲜", "icon": "icon-nav", "url": "海鲜.html"},
                            {"menuid": "94", "menuname": "禽类", "icon": "icon-nav", "url": "禽类.html"},
                            {"menuid": "94", "menuname": "饮品", "icon": "icon-nav", "url": "饮品.html"}
                        ]},
                        {"menuid": "14", "menuname": "按场景管理", "icon": "icon-sys",
                        "menus":[
                            {"menuid": "91", "menuname": "早餐", "icon": "icon-nav", "url": "早餐.html"},
                            {"menuid": "91", "menuname": "午餐", "icon": "icon-nav", "url": "午餐.html"},
                            {"menuid": "92", "menuname": "下午茶", "icon": "icon-nav", "url": "下午茶.html"},
                            {"menuid": "93", "menuname": "晚餐", "icon": "icon-nav", "url": "晚餐.html"},
                            {"menuid": "94", "menuname": "宵夜", "icon": "icon-nav", "url": "宵夜.html"},
                            {"menuid": "94", "menuname": "生日聚会", "icon": "icon-nav", "url": "生日聚会.html"},
                            {"menuid": "94", "menuname": "户外野炊", "icon": "icon-nav", "url": "户外野炊.html"}
                        ]},
                        {"menuid": "13", "menuname": "推荐美食管理", "icon": "icon-sys", "url": "demo2.html"}
                    ]
                }, {
                    "menuid": "2", "icon": "icon-sys", "menuname": "用户管理",
                    "menus": [{"menuid": "21", "menuname": "角色管理", "icon": "icon-role", "url": "角色管理.html"},
                                {"menuid": "21", "menuname": "权限设置", "icon": "icon-set", "url": "权限设置.html"},
                                {"menuid": "21", "menuname": "用户管理", "icon": "icon-user", "url": "用户管理.html"},
                                {"menuid": "22", "menuname": "视频监控", "icon": "icon-nav", "url": "视频监控.html"}
                    ]
                }, {
                    "menuid": "3", "icon": "icon-sys", "menuname": "系统设置",
                    "menus": [{"menuid": "31", "menuname": "添加部门", "icon": "icon-nav", "url": "添加部门.html"},
                        {"menuid": "32", "menuname": "部门列表", "icon": "icon-nav", "url": "部门列表.html"}
                    ]
                }, {
                    "menuid": "28", "icon": "icon-sys", "menuname": "财务管理",
                    "menus": [{"menuid": "41", "menuname": "收支分类", "icon": "icon-nav", "url": "收支分类.html"},
                        {"menuid": "42", "menuname": "报表统计", "icon": "icon-nav", "url": "报表统计.html"},
                        {"menuid": "43", "menuname": "添加支出", "icon": "icon-nav", "url": "添加支出.html"}
                    ]
                }, {
                    "menuid": "39", "icon": "icon-sys", "menuname": "商城管理",
                    "menus": [{"menuid": "51", "menuname": "商品分类", "icon": "icon-nav", "url": "demo.html"},
                        {"menuid": "52", "menuname": "商品列表", "icon": "icon-nav", "url": "demo1.html"},
                        {"menuid": "53", "menuname": "商品订单", "icon": "icon-nav", "url": "demo2.html"}
                    ]
                }
            ]
        };
        //打开修改密码窗口
        function initPwd() {
            $('#changePwWin').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable: false
            });
        }

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function (msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })

        }

        $(function () {
            initPwd();
            $('#editpass').click(function () {
                $('#changePwWin').window('open');
            });

            $('#btnEp').click(function () {
                serverLogin();
            })

            $('#btnCancel').click(function () {
                $('#changePwWin').window('close');
            })

            $('#loginOut').click(function () {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function (r) {
                    if (r) {
                        location.href = '/ajax/loginout.ashx';
                    }
                });
            })
        });


    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
<noscript>
    <div class="no-script">
        <img src="${pageContext.request.contextPath}/img/noscript.gif" alt='抱歉，请开启脚本支持！'/>
    </div>
</noscript>

<div region="north" split="true" border="false" style="overflow: hidden; height: 50px;
        background: url(../img/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 40px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head">欢迎 疯狂秀才
        <a href="#" id="editpass">修改密码</a>
        <a href="#" id="loginOut">安全退出</a>
    </span>

    <span style="padding-left:10px; font-size: 16px; ">
        <img src="${pageContext.request.contextPath}/img/blocks.gif" width="20" height="20" align="absmiddle"/>
        后台管理系统
    </span>
</div>

<!--  导航内容 -->
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="navigation">
    <div id="nav" class="easyui-accordion" fit="true" border="false">

    </div>

</div>

<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; ">
            <h1 style="font-size:24px;">* 作者：Cooper Wang QQ：770833020</h1>
        </div>
    </div>
</div>

<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
    <div class="footer">By Cooper Wang(QQ:770833020)</div>
</div>


<!--修改密码窗口-->
<div id="changePwWin" class="easyui-window" title="修改密码" collapsible="false" minimizable="true"
     maximizable="false" icon="icon-save" style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            <table cellpadding=3>
                <tr>
                    <td>新密码：</td>
                    <td><input id="txtNewPass" type="Password" class="txt01"/></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input id="txtRePass" type="Password" class="txt01"/></td>
                </tr>
            </table>
        </div>
        <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
            <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
            <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
        </div>
    </div>
</div>

<div id="mm" class="easyui-menu" style="width:150px;">
    <div id="mm-tabupdate">刷新</div>
    <div class="menu-sep"></div>
    <div id="mm-tabclose">关闭</div>
    <div id="mm-tabcloseall">全部关闭</div>
    <div id="mm-tabcloseother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="mm-tabcloseright">当前页右侧全部关闭</div>
    <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
    <div class="menu-sep"></div>
    <div id="mm-exit">退出</div>
</div>


</body>
</html>
