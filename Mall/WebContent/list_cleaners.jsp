<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<title>家政服务后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	function selectAll() {
		var obj = document.getElementsByName("chkAll")[0];
		var checkbox = document.getElementsByName("chkCleaners");
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = obj.checked;
		}
	}

	function del() {

		//客户端验证，验证是否选中
		var ch = document.getElementsByName("chkCleaners");
		var checkcount = 0;
		for (var i = 0; i < ch.length; i++) {
			if (ch[i].checked == true) {
				checkcount++;
			}
		}
		if (checkcount == 0) {
			alert("请至少选择一个用户！");

		} else {
			var oForm = document.getElementsByName("frmAction")[0];
			oForm.action = "/Mall/DeleteCleanerServlet";
			oForm.submit();
		}
	}

	function change() {
		//客户端验证，验证是否选中
		var ch = document.getElementsByName("chkCleaners");
		var checkcount = 0;
		for (var i = 0; i < ch.length; i++) {
			if (ch[i].checked == true) {
				checkcount++;
			}
		}
		if (checkcount == 0 || checkcount > 1) {
			alert("请选择一个员工！");
		} else {
			var oForm = document.getElementsByName("frmAction")[0];
			oForm.action = "/Mall/ShowCleanerServlet";
			oForm.submit();
		}
	}

	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									//scroll-to appended content 
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>
</head>
<body>
	<form name="frmAction" method="post">
		<!--header-->
		<header>
			<h1>
				<img src="images/admin_logo.png" />
			</h1>
			<ul class="rt_nav">
				<li><a href="/Mall/login.html" class="quit_icon">安全退出</a></li>
			</ul>
		</header>

		<!--aside nav-->
		<aside class="lt_aside_nav content mCustomScrollbar">
			<h2>列表项</h2>
			<ul>
				<li>
					<dl>
						<!--当前链接则添加class:active-->
						<dd>
							<a href="/Mall/ListUserServlet" class="active">用户列表</a>
						</dd>
						<dd>
							<a href="/Mall/ListServersServlet" class="active">服务列表</a>
						</dd>
						<dd>
							<a href="/Mall/ListCleanersServlet" class="active">员工列表</a>
						</dd>
						<dd>
							<a href="/Mall/ListOrdersServlet" class="active">订单列表</a>
						</dd>
					</dl>
				</li>

			</ul>
		</aside>

		<section class="rt_wrap content mCustomScrollbar">
			<div class="rt_content">

				<section class="loading_area">
					<div class="loading_cont">
						<div class="loading_icon">
							<i></i><i></i><i></i><i></i><i></i>
						</div>
						<div class="loading_txt">
							<mark>数据正在加载，请稍后！</mark>
						</div>
					</div>
				</section>
				<!--结束加载-->
				<!--弹出框效果-->
				<script>
					$(document).ready(function() {
						//弹出文本性提示框
						$("#showPopTxt").click(function() {
							$(".pop_bg").fadeIn();
						});
						//弹出：确认按钮
						$(".trueBtn").click(function() {
							alert("你点击了确认！");//测试
							$(".pop_bg").fadeOut();
						});
						//弹出：取消或关闭按钮
						$(".falseBtn").click(function() {
							alert("你点击了取消/关闭！");//测试
							$(".pop_bg").fadeOut();
						});
					});
				</script>

				<section>
					<button class="link_btn" id="loading" onclick="del()">删除员工</button>
					<button class="link_btn" id="loading"
						onclick="window.location.href='add_cleaner.html'">增加服务</button>
					<button class="link_btn" id="loading" onclick="change()">修改服务</button>
				</section>
				<section></section>
				<section>
					<table class="table">
						<tr align="center" class="colom">
							<td><input type="checkBox" name="chkAll"
								onClick="selectAll()" /></td>
							<td align='center'>id</td>
							<td>名字</td>
							<td>头像</td>
							<td>电话</td>
							<td>年龄</td>
							<td>性别</td>
							<td>婚姻</td>
							<td>签名</td>
							<td>介绍</td>
							<td>状态</td>
						</tr>
						<c:forEach var="cleaner" items="${cleaners}">
							<tr class='even'>
								<td align='center'><input type='checkbox'
									name='chkCleaners' value='${cleaner.cid}'></td>
								<td align='center'><c:out value="${cleaner.cid}"></c:out></td>
								<td align=center><c:out value="${cleaner.name}"></c:out></td>
								<td align=center><c:out value="${cleaner.head}"></c:out></td>
								<td align=center><c:out value="${cleaner.phone}"></c:out></td>
								<td align=center><c:out value="${cleaner.age}"></c:out></td>
								<td align=center><c:out value="${cleaner.sex}"></c:out></td>
								<td align=center><c:out value="${cleaner.marrysta}"></c:out></td>
								<td align=center><c:out value="${cleaner.sign}"></c:out></td>
								<td align=center><c:out value="${cleaner.intro}"></c:out></td>
								<td align=center><c:out value="${cleaner.state}"></c:out></td>
							</tr>
						</c:forEach>

					</table>
				</section>

				<!--tabStyle-->
				<script>
					$(document).ready(
							function() {
								//tab
								$(".admin_tab li a").click(
										function() {
											var liindex = $(".admin_tab li a")
													.index(this);
											$(this).addClass("active").parent()
													.siblings().find("a")
													.removeClass("active");
											$(".admin_tab_cont").eq(liindex)
													.fadeIn(150).siblings(
															".admin_tab_cont")
													.hide();
										});
							});
				</script>
			</div>
		</section>
	</form>
</body>
</html>
