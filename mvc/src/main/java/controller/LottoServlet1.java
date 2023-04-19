package controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.TimeVO;

@WebServlet(name = "lotto1", urlPatterns = { "/lotto1" })
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("utf-8");
		int num = request.getParameter("num") == "" ? 0 : Integer.parseInt(request.getParameter("num"));
		int random = (int) ((Math.random()*6)+1);
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]); // Integer 객체로 들어감
		}
		
		int [] count = (int [])session.getAttribute("cnt");
		count[0]++;
		
		System.out.println("전달된 값 :"+num+", 추출된 값 : "+random+", 응모 시도한 횟수 : "+count[0]);
		
		LocalTime now = LocalTime.now();
		TimeVO vo = new TimeVO(now.getHour() ,now.getMinute());
		request.setAttribute("time", vo);
		
		if(count[0] > 3) {
			
		}
		else if(num == random) {
			request.getRequestDispatcher("/jspexam/sucess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/jspexam/fail.jsp").forward(request, response);
		}

		
	}

}
