<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="/guestbook/delete">
					<input type='hidden' name="no" value="${no }">
					<label>비밀번호</label>
					<input type="password" name="password">
					<input type="submit" value="확인">
				</form>
				<a href="/guestbook/index">방명록 리스트</a>
			</div>
		</div>
	</div>
</body>
</html>