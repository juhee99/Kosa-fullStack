<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.domain.TimeVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fail</title>
</head>
<body>
<% TimeVO vo = (TimeVO)request.getAttribute("time"); %>
<div>
<h3> ${time.hour}시 ${time.minute}분 실패!! 아쉽아쉽</h3>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7RZiBD1CyOyH8gPRHATYsvIllAqWs4Zt0kA&usqp=CAU"/>

<a href='<%= request.getHeader("referer") %>' >로또 응모 링크</a>
</div>
</body>
</html>