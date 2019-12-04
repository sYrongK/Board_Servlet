package etc;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginProcess")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet2() {
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
			
		String id = request.getParameter("id");
		String pwd = request.getParameter("passwd");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", "session! " + id);
		
//		현재 페이지가 소속된 웹 애플리케이션의 ServletContext객체를 구해옵니다.
		ServletContext context = this.getServletContext();
//		ServletContext context = request.getSession().getServletContext();	--> session에서 얻어오는 것 아님
		context.setAttribute("pwd", "context! " + pwd);
		
		response.sendRedirect("ch1/_1.login/check.jsp");
	}
	
}
