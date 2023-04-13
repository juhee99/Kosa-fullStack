<%@ page language="java" contentType="text/plain; charset=UTF-8"%>
<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Cache-Control", "no-cache");
%>
<% String news[] = { "CROSS DOMAIN 을 테스트합니다. ㅋ",
					"CROSS DOMAIN 을 테스트합니다. ㅋㅋ",
					"[속보]두번째줄 박OO, 지금 당장 집가고 싶어해…",
					"😎",
					"메롱",
					         }; %>
<% int num = (int)(Math.random() * 5); %>
{ 
	"news" : "<%= news[num] %>"
}