

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAddQueServlet
 */
@WebServlet("/AdminAddQueServlet")
public class AdminAddQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddQueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter ps=response.getWriter();
				
				try
				
				{
					int i=0,j=0;
					String id[]=new String[6];
					String que[]=new String[6];
					String op1[]=new String[6];
					String op2[]=new String[6];
					String op3[]=new String[6];
					
					Class.forName("org.postgresql.Driver");
					String url="jdbc:postgresql://localhost:5432/FormApp";
					String r="postgres";
					String pass="Dh@ny@07";
					Connection con=DriverManager.getConnection(url,r,pass); 
					Statement st=con.createStatement();int n=0;
					
					//ResultSet rs=st.executeQuery("select no_of_que from Poll_details order by s_no desc");
					
					
		
					id[0]=request.getParameter("id");
					que[0]=request.getParameter("a");
					op1[0]=request.getParameter("b");
					op2[0]=request.getParameter("c");
					op3[0]=request.getParameter("d");
					id[1]=request.getParameter("id");
					que[1]=request.getParameter("a1");
					op1[1]=request.getParameter("b1");
					op2[1]=request.getParameter("c1");
					op3[1]=request.getParameter("d1");
					id[2]=request.getParameter("id");
					que[2]=request.getParameter("a2");
					op1[2]=request.getParameter("b2");
					op2[2]=request.getParameter("c2");
					op3[2]=request.getParameter("d2");
					id[3]=request.getParameter("id");
					que[3]=request.getParameter("a3");
					op1[3]=request.getParameter("b3");
					op2[3]=request.getParameter("c3");
					op3[3]=request.getParameter("d3");
					id[4]=request.getParameter("id");
					que[4]=request.getParameter("a4");
					op1[4]=request.getParameter("b4");
					op2[4]=request.getParameter("c4");
					op3[4]=request.getParameter("d4");
					id[5]=request.getParameter("id");
					que[5]=request.getParameter("a5");
					op1[5]=request.getParameter("b5");
					op2[5]=request.getParameter("c5");
					op3[5]=request.getParameter("d5");
					for(i=0;i<6;i++)
					{
						String sql="insert into Poll_ques(poll_id,que,op1,op2,op3) values('"+id[i]+"','"+que[i]+"','"+op1[i]+"','"+op2[i]+"','"+op3[i]+"')";
		                st.executeUpdate(sql);
					}
					ps.println("Done ins");
					response.sendRedirect("AHomePage.jsp");
					
				}
				catch(Exception e)
				{
					System.out.println(e);
					response.sendRedirect("ExceptionHandler.jsp");
				}
				
	}

}
