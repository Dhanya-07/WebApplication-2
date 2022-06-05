

import java.io.File;
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
 * Servlet implementation class CreateCSV
 */
@WebServlet("/CreateCSV")
public class CreateCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("get:createCSV");
			PrintWriter pw= new PrintWriter(new File("C:\\Users\\Dhanya\\OneDrive\\Desktop\\CSV Files\\Votes_table.csv"));
		    StringBuilder sb=new StringBuilder();
		    sb.append("admin_id");
		    sb.append(",");
		    sb.append("q_no");
		    sb.append(",");
		    sb.append("Selected");
		    sb.append("\r\n");
		    System.out.println("1");
		    //
		    Class.forName("org.postgresql.Driver");
		  	String url="jdbc:postgresql://localhost:5432/FormApp";
		  	String r="postgres";
		  	String pass="Dh@ny@07";
		  	Connection con=DriverManager.getConnection(url,r,pass); 
		  	Statement st=con.createStatement();
		  	String sql="select * from Votes";
		  	ResultSet rs=st.executeQuery(sql);
		  	while(rs.next())
		  	{
		  		sb.append(rs.getInt(1));
		  		sb.append(",");
		  		sb.append(rs.getInt(2));
		  		sb.append(",");
		  		sb.append(rs.getString(3));
		  		sb.append("\r\n");
		  	}
		  	System.out.println("2");
		    pw.write(sb.toString());
		    pw.close();
		    System.out.println("finished DB fetch");
		    response.sendRedirect("MailScheduler");
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("put:createCSV");
	}

}
