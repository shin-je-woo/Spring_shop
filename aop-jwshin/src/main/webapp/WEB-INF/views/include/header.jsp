<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href=${path }>커피배달</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbar">
		<ul class="navbar-nav mr-auto">
			<c:choose>
				<c:when test="${sessionScope.userid != null}">
					<li class="nav-item"><a class="nav-link"
						href="${path}/shop/product/write.do">상품등록</a></li>
				</c:when>
			</c:choose>
			<li class="nav-item"><a class="nav-link"
				href="${path}/shop/product/list.do">상품목록</a></li>

			<!-- 로그인 세션 처리 -->
			<c:choose>
				<c:when test="${sessionScope.userid ==null}">
					<li class="nav-item"><a class="nav-link"
						href="${path}/member/login.do">장바구니</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/member/login.do">결제목록</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/member/login.do">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/member/signup.do">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="${path}/shop/cart/list.do?userid=">장바구니</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/payment/list.do?userid=${sessionScope.userid}">결제목록</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/member/view.do?userid=${sessionScope.userid}">${sessionScope.username}님
							환영합니다.</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/member/logout.do">로그아웃</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
</nav>
<div style='line-height: 200%'>
	<br>
</div>