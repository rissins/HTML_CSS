package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myUtil.HanConv;
/**
 * Servlet implementation class multiPara
 */
@WebServlet("/multiPara")
public class multiPara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out=response.getWriter();
		String[] item;
		item = request.getParameterValues("item");
		out.println("선택된 항목이");
		
		try {
			for (int i = 0; i < item.length; i++) {
				out.println(" : "+HanConv.toKore(item[i]));
				out.println("입니다.");
			} 
		}catch (Exception e) {
			out.println("없습니다.");
		}
	}
}





