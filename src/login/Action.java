package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	/**QQQQ*/
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
