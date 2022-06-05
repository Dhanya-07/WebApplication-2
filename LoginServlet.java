

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			 String s=request.getParameter("userid");
		      String s1=request.getParameter("name");
		      String s2=request.getParameter("password");
		      HttpSession session=request.getSession();
		      session.setAttribute("username",s1);
			PrintWriter out=response.getWriter();
			 int c=0,a=0;
			// Scheduler sobj=new Scheduler();
			 //System.out.println("obj bel");
			 //sobj.CreateCSV();
			 //sobj.Assign();
			 System.out.println("obj aft");
			 
		     String url="jdbc:postgresql://localhost:5432/FormApp";
			 String r="postgres"; String pass="Dh@ny@07";
			 System.out.println("in ???");
			 String driver="org.postgresql.Driver";
					try {
						Class.forName(driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1);
					}
			
				Connection  con=null;
				try {
					 con=DriverManager.getConnection(url,r,pass);
					if(con!=null)
						System.out.println("Successfully con log");
					else
						System.out.println("NOO");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Users");
			     
			      while(rs.next())
			      {
			    	  if(rs.getString(1).equals(s));
			    	  {
			    		  if((rs.getString(2).equals(s1))&&(rs.getString(3).equals(s2))&&(rs.getString(4).equals("ad")))
			    		  {
			    			  c++;
			    		  }
			    	  }
			    	  
			      }
			      if(c>0)
			      {
			    	  out.println("admin successs");
			    	  Connection cond=DriverManager.getConnection(url,r,pass); 
						Statement std=cond.createStatement();
						std.executeUpdate("Delete from temp");
			    	  Connection con2=DriverManager.getConnection(url,r,pass); 
						Statement st2=con2.createStatement();
						String sql1="insert into temp values('"+s+"','"+s1+"','"+s2+"')";
						st2.executeUpdate(sql1);
			    	  response.sendRedirect("AdminHomePage.jsp");
			      }
			      else
			      {
			    	  Statement sta=con.createStatement();
						ResultSet rsa=sta.executeQuery("select * from Users");
				     
				      while(rsa.next())
				      {
				    	  if(rsa.getString(1).equals(s));
				    	  {
				    		  if((rsa.getString(2).equals(s1))&&(rsa.getString(3).equals(s2))&&(rsa.getString(4).equals("g")))
				    		  {
				    			  a++;
				    		  }
				    	  }
				    	  
				      }
				      if(a==0)
						{
				    	  Connection cond=DriverManager.getConnection(url,r,pass); 
							Statement std=cond.createStatement();
							std.executeUpdate("Delete from temp");
				    	  Connection con2=DriverManager.getConnection(url,r,pass); 
							Statement st2=con2.createStatement();
							String sql1="insert into temp values('"+s+"','"+s1+"','"+s2+"')";
							st2.executeUpdate(sql1);
				    	  Connection con1=DriverManager.getConnection(url,r,pass); 
						Statement st1=con1.createStatement();
						String u="g";
						String sql="insert into Users values('"+s+"','"+s1+"','"+s2+"','"+u+"')";
						st1.executeUpdate(sql);
			    	   response.sendRedirect("guestHomePage.jsp");
			    	   }
				      else
				      {
				    	Connection cond=DriverManager.getConnection(url,r,pass); 
							Statement std=cond.createStatement();
							std.executeUpdate("Delete from temp");  
				    	  Connection con2=DriverManager.getConnection(url,r,pass); 
							Statement st2=con2.createStatement();
							String sql1="insert into temp values('"+s+"','"+s1+"','"+s2+"')";
							st2.executeUpdate(sql1);
				    	  response.sendRedirect("ExistingGuestHomePage.jsp"); 
				      }  
			      } 
				} catch(Exception e)
				{
					System.out.println(e);
					response.sendRedirect("ExceptionHandler.jsp");
				}
		}

}
