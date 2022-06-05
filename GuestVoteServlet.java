

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

/**
 * Servlet implementation class GuestVoteServlet
 */
@WebServlet("/GuestVoteServlet")
public class GuestVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestVoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		p.println();
		
		//p.println("Served");
		try {
			int id=0;
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/FormApp";
			String r="postgres";int n=0,i=0;
			String pass="Dh@ny@07";
			Connection con=DriverManager.getConnection(url,r,pass); 
			
			Connection conq=DriverManager.getConnection(url,r,pass); 
			Statement stq=conq.createStatement();
			ResultSet rsq=stq.executeQuery("select * from poll_ques");
			while(rsq.next())
			{
				//String fn = java.net.URLDecoder.decode(req.getParameter("title"));
				System.out.println(request.getParameter(rsq.getString(3)));
			}
			
			
			
			
				p.println("Thank you for your votes");
			
			
			Connection con1=DriverManager.getConnection(url,r,pass); 
			Statement st1=con1.createStatement();
			System.out.println("here");
			ResultSet rs1=st1.executeQuery("select count(*) from poll_ques");
			if(rs1.next())
			n=rs1.getInt(1);
			System.out.println("n "+n);
			String arr[]=new String[n];
			
			Connection con2=DriverManager.getConnection(url,r,pass); 
			Statement st2=con2.createStatement();
			ResultSet rs2=st2.executeQuery("select * from poll_ques");
			while(rs2.next())
			{
				String str=rs2.getString(3);
				System.out.println(str);
				arr[i++]=request.getParameter(str);
				//System.out.println("Check:t "+request.getParameter("Best Movie:Tamil"));
			}
			for(int j=0;j<n;j++)
				System.out.println(arr[j]);
			
			//u_id
			Connection con3=DriverManager.getConnection(url,r,pass); 
			Statement st3=con3.createStatement();
			ResultSet rs3=st3.executeQuery("select admin_id from temp");
			while(rs3.next())
			{
				n=rs3.getInt(1);
			}
			///q_id
			
			Connection con4=DriverManager.getConnection(url,r,pass); 
			Statement st4=con4.createStatement();
			ResultSet rs4=st4.executeQuery("select q_no from poll_ques");
			
			Connection con5=DriverManager.getConnection(url,r,pass); 
			Statement st5=con5.createStatement();
			i=0;
			System.out.println("bef while");
			
			
			while(rs4.next())
			{
				System.out.println("5");
				if(arr[i]!=null)
				st5.executeUpdate("insert into Votes values('"+n+"','"+rs4.getInt(1)+"','"+ arr[i]+"')");
			    i++;
			}	
			p.println("You are being redirected to Homepage");
			p.println("");
			p.println("");
			p.println("");
			p.println("");
			response.sendRedirect("guestHomePage.jsp");
			
			
		} catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("ExceptionHandler.jsp");
		}
			
		
	}


}
