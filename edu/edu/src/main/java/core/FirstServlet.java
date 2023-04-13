package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet 실행.....");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // IOStream API 문자기반의 출력 스트림
		out.print("<h1>안녕? Servlet!</h1>");
		out.close();
	}
}
