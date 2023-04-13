package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "reservation", urlPatterns = { "/reservation" })
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		String client = request.getParameter("client");
		String password = request.getParameter("pwd");
		String room = request.getParameter("room");
		String date = request.getParameter("date");
		String [] options = request.getParameterValues("option");
		
		// 추가 옵션 처리
		String str = "없음";
		if(options != null) {
			str=String.join(" ,",options);
		}
		
		//Date 처리;
		if( !date.isBlank() ) {
			String [] result = date.split("-");
			date = result[0]+"년"+result[1]+" 월"+result[2]+" 일";
		}
	
		if(client == null  || client.isBlank()) {
			RequestDispatcher rd = request.getRequestDispatcher("/first.html");
			rd.forward(request, response);
			return ;
		}else if(password == null || password.isBlank() ){
			response.sendRedirect("https://www.daum.net");
			return ;
		}
		
		out.print("<h1>"+client+"님의 예약내용</h1><br><hr><br>");
		out.print("<ol><li>룸 : "+room+"</li>");
		out.print("<li>추가 요청 사항 : " + str+"</li>");
		out.print("<li>예약날짜: " + date+"</li>");
		
		out.print("<br><br><a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
		out.close();
	}


}



