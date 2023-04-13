package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String userText = request.getParameter("opinion");

		LocalDate currentDate = LocalDate.now();
		out.print("<h2>"+userName+" 님이 "+currentDate.getYear()+"년 "+currentDate.getMonthValue()+"월 "+currentDate.getDayOfMonth()+"일에 남긴 글입니다.</h2>");
		out.print("<hr>");
		out.print(userText);
		out.print("</br>");
		out.print("</br>");
		
		out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
		out.close();
	
	}

}
