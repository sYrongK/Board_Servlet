package etc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Start.do") // -> �̷��� annotation���� ����ϰų�, xml�� <servlet>&<servlet-mapping>���� ���� �ۼ��ϰų�
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
    	System.out.println(request.getRemoteHost() + "���� �����մϴ�.");
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ch1/_1.login/login.jsp");
    	dispatcher.forward(request, response);
    }

}
