import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDelServlet
 */
@WebServlet("/AdminDelServlet")
public class AdminDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_id=Integer.parseInt(request.getParameter("delpoll"));
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			Statement st=con.createStatement();
			String sql="delete from poll_details where poll_id='"+p_id+"'";
			System.out.println("After del");
			st.executeUpdate(sql);
			PrintWriter ps=response.getWriter();
			ps.println("      Deletion Successful       ");  
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
