<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.domain.TimeVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success!!</title>
<style>
h3 {
	color : "#D14D72";
}
</style>
</head>
<body>
<% TimeVO vo = (TimeVO)request.getAttribute("time"); %>
<div>
<h3> ${time.hour}시 ${time.minute}분 당첨!! 추카추카</h3>
<img src="https://file3.instiz.net/data/cached_img/upload/2018/05/05/3/1d24a9f247c4865cb16cf7d83b8b124b.jpg"/>
</div>
</body>
</html>