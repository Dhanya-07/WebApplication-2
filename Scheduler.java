import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
	public void CreateCSV()
	{
		try
		{
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
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void Assign()
	{
		try
		{
			System.out.println("Assign");
			Calendar c = Calendar.getInstance();
			  c.set(Calendar.HOUR_OF_DAY, 17);
			  c.set(Calendar.MINUTE, 30);
			  c.set(Calendar.SECOND, 00);
			  Timer timer = new Timer();
			  //TimerTask tt=new TimerTask
			  TimerTask tt=new MailTask();
			  timer.schedule(tt, c.getTime(), 86400000);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scheduler s=new Scheduler();
		System.out.println("what");
		s.CreateCSV();
		 //time duration between successive task scheduled is 24 hrs
	}
}
