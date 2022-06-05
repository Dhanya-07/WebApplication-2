

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewExit
 */
@WebServlet("/ViewExit")
public class ViewExit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewExit() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=request.getParameter("oper");
		if(s.equals("view"))
			response.sendRedirect("View.jsp");
		else if(s.equals("exit"))
		{
			response.sendRedirect("CreateCSV");
			
		}
			
		else
			response.sendRedirect("Login.jsp");
	}

}
