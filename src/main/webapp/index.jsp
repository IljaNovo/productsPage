<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Главная</title>
<style>
	.sub {
		width: 210px;
	}
</style>
</head>
<body>
	<form action="datahandler" method="post">
		<input type="text" name="name" placeholder="Введите название товара" size="30"><br><br>
		<input type="text" name="count" placeholder="Введите количество" size="30"><br><br>
		<input class="sub" type="submit" value="Отправить"><br><br>
	</form>
	<form action="server" method="get">
		<input class="sub" type="submit" value="Перейти на страницу заказов" width="150">
	</form>
</body>
</html>