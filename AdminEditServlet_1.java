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
 * Servlet implementation class AdminEditServlet_1
 */
@WebServlet("/AdminEditServlet_1")
public class AdminEditServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditServlet_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			int p_id=Integer.parseInt(request.getParameter("editid"));
			String name=request.getParameter("editname");
			String op1=request.getParameter("editop1");
			String op2=request.getParameter("editop2");
			String op3=request.getParameter("editop3");
			String s="AAA";
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			Statement st=con.createStatement();
			String sql="update poll_ques set  que='"+name+"',op1='"+op1+"',op2='"+op2+"',op3='"+op3+"' where q_no='"+p_id+"';";
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
