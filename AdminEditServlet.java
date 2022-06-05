
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminEditServlet
 */
@WebServlet("/AdminEditServlet")
public class AdminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int p_id=Integer.parseInt(request.getParameter("editid"));
		String name=request.getParameter("editname");
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			Statement st=con.createStatement();
			String sql="update poll_details set  poll_name='"+name+"' where poll_id='"+p_id+"';";
			//"update poll_details set  poll_name='"+name+"where poll_id='"+p_id;
			System.out.println("After edit");
			st.executeUpdate(sql);
			PrintWriter ps=response.getWriter();
			ps.println("      updation Successful       ");  
			ps.println("       You are being redirected to Homepage    ");
			response.sendRedirect("AHomePage.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("ExceptionHandler.jsp");
		}
		
	}
	}


