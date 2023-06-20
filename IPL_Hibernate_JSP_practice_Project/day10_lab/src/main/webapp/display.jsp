<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="player" class="beans.PlayerBean" scope="application" />
<jsp:setProperty property="*" name="player"/>
<body>
<h1>In display </h1>
	<h1>${applicationScope.player.validate()}</h1>
</body>
</html>