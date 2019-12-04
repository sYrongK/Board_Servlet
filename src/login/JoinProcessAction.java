package login;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserDAO userDao = new UserDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8"); 		
		request.setCharacterEncoding("UTF-8");
		
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setAge(request.getParameter("age"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("email"));
		
		int result = userDao.insertUser(user);
		
		if (result == 1) {
			out.println("<script>");
			out.println("alert('환영합니다.')");
			out.println("location.href='Login.do'");
			out.println("</script>");
			
		} else {
			out.println("<script>");
			out.println("alert('회원가입 에러')");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		return null;
	}

}
