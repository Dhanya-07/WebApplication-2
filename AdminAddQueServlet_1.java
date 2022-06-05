

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAddQueServlet_1
 */
@WebServlet("/AdminAddQueServlet_1")
public class AdminAddQueServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddQueServlet_1() {
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
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String que=request.getParameter("a");
		String op1=request.getParameter("b");
		String op2=request.getParameter("c");
		String op3=request.getParameter("d");
		try
		{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			Statement st=con.createStatement();
			String sql="insert into Poll_ques(poll_id,que,op1,op2,op3) values('"+id+"','"+que+"','"+op1+"','"+op2+"','"+op3+"')";
            st.executeUpdate(sql);
            System.out.println("in add(1)");
            Connection con1=DriverManager.getConnection(url,r,pass); 
			Statement st1=con1.createStatement();
			String sql1="update poll_details set no_of_que=no_of_que+1 where poll_id='"+id+"'";
		    st1.executeUpdate(sql1);
		    response.sendRedirect("AHomePage.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("ExceptionHandler.jsp");
		}
	}

}
