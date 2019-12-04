package login;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Action을 상속받아서 HttpServletRequest, HttpServletResponse를 가져다가 사용할 수 있다.
		
		UserDAO userDao = new UserDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("passwd");
		
		int result = userDao.lookUpId(id, pwd);
		
		if (result == -1) {
			out.println("<script>");
			out.println("alert('회원가입 ㄱㄱ')");
			out.println("location.href='Join.do'");
			out.println("</script>");	
		} else if (result == 0){
			out.println("<script>");
			out.println("alert('비밀번호 ㄴㄴ')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("main/main.jsp");		
		}
		
		return null;
	}
	
	

}
