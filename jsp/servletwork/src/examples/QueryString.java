package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myUtil.*;
/**
 * Servlet implementation class QueryString
 */
@WebServlet("/QueryString")
public class QueryString extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = "", name = "", vclass = "", phone1 = "", phone2 = "", phone3 = "";
		id = request.getParameter("id");
		name = request.getParameter("name");
		vclass = request.getParameter("class");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		
		out.println("<html><head></head><body>");
		out.println("당신이 입력한 정보(get방식) 입니다. <br> 아이디 : <b>");
		out.println(id);
		out.println("</b><br> 이름 : <b>"); out.println(HanConv.toKore(name));
		out.println("</b><br> 구분 : <b>"); out.println(HanConv.toKore(vclass));
		out.println("</b><br> 전화번호 : <b>"); out.println(phone1);
		out.println("-"); out.println(phone2);
		out.println("-"); out.println(phone3);
		out.println("</b><br><a href = 'javascript:history.go(-1)'>다시</a>");
		
	
		out.println("</body><html>");
	}

}
