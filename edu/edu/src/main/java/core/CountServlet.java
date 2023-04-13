package core;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); // 먼저 호출해야함
		PrintWriter out = response.getWriter(); // 클라이언트에게 응답보낼 문자스트링 객체를 만든다
		
		HttpSession session = request.getSession(); // 추출하거나 생성하거나
		if(session.getAttribute("cnt") == null) { // 상태정보를 보관할 객체에 attribute가 있느냐
			session.setAttribute("cnt", new int[1]); // 한번만 만들면 됨
		}
		int[] count = (int[])session.getAttribute("cnt"); // 이름이 cnt인 객체의 참조값 꺼내기
		count[0]++;
		out.print("<h3>당신은 "+ count[0] + 
				                       "번째 방문입니다.</h3>");		
		out.close();
	}
}



