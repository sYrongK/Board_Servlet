package etc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginProcess")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doProcess(request, response);
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());	
			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ch1/_1.login/check.jsp");
//		
		String id = request.getParameter("id");
		String pwd = request.getParameter("passwd");
//		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		
		dispatcher.forward(request, response);
		
//		response.sendRedirect("ch1/_1.login/check.jsp");
//		-> redirect방식으로는 request response를 유지할 수 없다. 새로운 request, response가 생성되기 때문에 -> redirect 방식은 session 사용
	}
	
}
