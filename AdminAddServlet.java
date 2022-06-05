

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
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("idp"));
		int uid=Integer.parseInt(request.getParameter("id"));
		String col=request.getParameter("col");
		int c=6;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			Statement st=con.createStatement();
			String sql="insert into Poll_details(admin_id,poll_id,poll_name,no_of_que) values('"+uid+"','"+pid+"','"+col+"','"+c+"')";
			System.out.println("After ins");
			st.executeUpdate(sql);
			Connection conz=DriverManager.getConnection(url,r,pass); 
			Statement stz=conz.createStatement();
			//String sqlz="insert into Statistics values('"+qid+"','"+col+"')";
			
			PrintWriter ps=response.getWriter();
			ps.println("  Insertion Successful    ");
			//ps.println("    You are being redirected to Homepage   ");
			response.sendRedirect("AdminAddQue.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("ExceptionHandler.jsp");
		}
	}

}
