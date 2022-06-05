

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminOper
 */
@WebServlet("/AdminOper")
public class AdminOper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In adOp");
		String s=request.getParameter("oper");
		if(s.equals("addPoll"))
		{
			response.sendRedirect("AdminAdd.jsp");
			
		}
		else if(s.equals("delPoll"))
		{
			response.sendRedirect("AdminDel.jsp");	
		}
		else if(s.equals("editPoll"))
		{
			response.sendRedirect("AdminEdit.jsp");	
		}
		else if(s.equals("view votes(%)"))
			response.sendRedirect("ViewJSP.jsp");
		else if(s.equals("add"))
			response.sendRedirect("AdminAddQue_1.jsp");
		else if(s.equals("delete"))
			response.sendRedirect("AdminDelQue_1.jsp");
		else if(s.equals("edit"))
			response.sendRedirect("AdminEditQue_1.jsp");
		else if(s.equals("view"))
			response.sendRedirect("View.jsp");
		else if(s.equals("exit"))
		{
			response.sendRedirect("CreateCSV");
			
		}
		else
			response.sendRedirect("Login.jsp");
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
