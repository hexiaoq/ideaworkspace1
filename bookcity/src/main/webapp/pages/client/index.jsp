<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/bookcity3/static/css/style.css" >
    <script type="text/javascript" src="http://localhost:8080/bookcity3/static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
         $(".addtocart").click(function () {
             var attr = $(this).attr("bookid");
             location.href="http://localhost:8080/bookcity3/cartservlet?action=additems&page=&id="+attr;


         })
        })
    </script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="http://localhost:8080/bookcity3/static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.username}">
					<a href="http://localhost:8080/bookcity3/pages/user/login.jsp">登录</a> |
					<a href="http://localhost:8080/bookcity3/pages/user/regist.jsp">注册</a> </c:if>
				<c:if test="${not empty sessionScope.username}">
					${sessionScope.username}
				</c:if>
				<a href="http://localhost:8080/bookcity3/pages/order/order.jsp">我的订单</a>
				<a href="http://localhost:8080/bookcity3/logout">注销</a>&nbsp;
				<a href="http://localhost:8080/bookcity3/pages/cart/cart.jsp">购物车</a>
				<a href="http://localhost:8080/bookcity3/pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="http://localhost:8080/bookcity3/pagebyprice" method="get">

					价格：<input id="min" type="text" name="min" value=""> 元 - 
						<input id="max" type="text" name="max" value=""> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.totalcount}">
					<span>您的购物车中有0件商品</span>
				</c:if>
				<c:if test="${not empty sessionScope.cart.totalcount}">
					<span>您的购物车中有${sessionScope.cart.totalcount}件商品</span>
				</c:if>

				<c:if test="${not empty sessionScope.lastname}">
					<div>
						<span style="color: red">您刚刚将《${sessionScope.lastname}》加入到了购物车中</span>
					</div>
				</c:if>

			</div>
			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="http://localhost:8080/bookcity3/static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button bookid="${book.id}" class="addtocart">加入购物车</button>
					</div>
				</div>
			</div></c:forEach>
			
			
			
			
			
			
			
		</div>

		<%@include file="/pages/common/pagenav.jsp"%>
	
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>