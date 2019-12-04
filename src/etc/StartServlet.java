package etc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Start.do") // -> 이렇게 annotation으로 사용하거나, xml에 <servlet>&<servlet-mapping>으로 직접 작성하거나
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StartServlet() {
        super();
        System.out.println("Constructor show");
    }
    
    public void init() throws ServletException {
    	System.out.println("init() show");
    }
    
    public void destroy() {
    	System.out.println("destroy() show");
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("service() show");
    	System.out.println(request.getRemoteHost() + "에서 접속합니다.");
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ch1/_1.login/login.jsp");
    	dispatcher.forward(request, response);
    }

}
