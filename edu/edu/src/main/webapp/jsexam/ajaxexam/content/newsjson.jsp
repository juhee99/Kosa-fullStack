<%@ page language="java" contentType="application/json; charset=UTF-8"%>
<% String news[] = { "뉴스이야기1",
		"뉴스이야기2",
		"뉴스이야기3",
  	    "뉴스이야기4",
		"[속보]두번째줄 박OO, 지금 당장 집가고 싶어해…",
		"😎",
		"메롱"}; %>
<% response.setHeader("Cache-Control", "no-cache"); %>
<% int num = (int)(Math.random() * 7);%>
{ 
	"news" : "<%= news[num] %>"
}