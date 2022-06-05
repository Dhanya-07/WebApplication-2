

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
 * Servlet implementation class AdminDelServlet_1
 */
@WebServlet("/AdminDelServlet_1")
public class AdminDelServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelServlet_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p_id=Integer.parseInt(request.getParameter("delpoll"));
		int q_id=Integer.parseInt(request.getParameter("delque"));
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			Statement st=con.createStatement();
			
			String sql="delete from poll_ques where q_no='"+q_id+"'";
			System.out.println("After del");
			st.executeUpdate(sql);
			Connection con1=DriverManager.getConnection(url,r,pass); 
			Statement st1=con1.createStatement();
			String sql1="update poll_details set no_of_que=no_of_que-1 where poll_id='"+p_id+"'";
		    st1.executeUpdate(sql1);
		    System.out.println("up success");
		   // response.sendRedirect("AdminHomePage.jsp");
			//PrintWriter ps=response.getWriter();
			//ps.println("      Que Deletion Successful       ");  
			
		//	ps.println("       You are being redirected to Homepage    ");
			response.sendRedirect("AHomePage.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			//response.sendRedirect("ExceptionHandler.jsp");
		}
		
	}

}
