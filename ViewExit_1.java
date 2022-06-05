

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewExit_1
 */
@WebServlet("/ViewExit_1")
public class ViewExit_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewExit_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String s=request.getParameter("oper");
			 if(s.equals("Exit"))
				response.sendRedirect("Exit_1.jsp");
			
		}

	}


