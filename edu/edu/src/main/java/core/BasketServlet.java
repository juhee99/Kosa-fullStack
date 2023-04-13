package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

@WebServlet(description = "basket", urlPatterns = { "/basket" })
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String prdName = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		
		if(prdName == null) {
			session.invalidate();
			JSONObject msg = new JSONObject();
			msg.put("msg", "데이터를 지웠어요~");
			out.write(msg.toString());
			return;
		}
		
		int index = Integer.parseInt( prdName.substring(1))-1;
		if(session.isNew()) {
			session.setAttribute("prdCnt", new int[10]);
		}
		
		int [] arr = (int [])session.getAttribute("prdCnt");
		arr[index]++;
		session.setAttribute("prdCnt", arr);
		
		System.out.println(arr[0]);
		
		JSONObject jobj = new JSONObject();// json객체 생성
		for(int i=0 ; i < arr.length ; i++) {
			if(arr[i] != 0) {
				jobj.put(String.format("p%03d", i+1), arr[i]);
			}
		}
		

		out.write(jobj.toString());
		out.close();
		
	
	}
}