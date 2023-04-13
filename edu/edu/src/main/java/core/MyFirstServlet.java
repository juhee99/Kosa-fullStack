package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		if (userName == null) {
			userName="GUEST";
		}
		
		String date = (LocalDate.now()).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		out.print("<h2>"+userName+"님 반갑습니다. 오늘은 "+date+"요일입니다😄</h2>");
		out.close();
		}

}
