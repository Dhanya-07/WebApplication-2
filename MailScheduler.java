

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * Servlet implementation class MailScheduler
 */
@WebServlet("/MailScheduler")
public class MailScheduler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailScheduler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get:mail");
		try
		{
			System.out.println("Assign");
			//Calendar c = Calendar.getInstance();//for current date and time
			 // c.set(Calendar.HOUR_OF_DAY, 20);
			  //c.set(Calendar.MINUTE, 05);
			  //c.set(Calendar.SECOND, 00);

			  Timer timer = new Timer();
			  //TimerTask tt=new TimerTask
			  System.out.println("gonna call tt");
			  TimerTask tt=new MailTask();
			  System.out.println("called tt");//43200000-12 hrs, 600000-10 min
			  timer.schedule(tt, new Date(), 600000);//for current  time
			  response.sendRedirect("Exit.jsp");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("put:mail");
		try
		{
			System.out.println("Assign");
			//Calendar c = Calendar.getInstance();//for current date and time
			  //c.set(Calendar.HOUR_OF_DAY, 19);
			  //c.set(Calendar.MINUTE, 26);
			  //c.set(Calendar.SECOND, 00);

			  Timer timer = new Timer();
			  //TimerTask tt=new TimerTask
			  System.out.println("gonna call tt");
			  TimerTask tt=new MailTask();
			  System.out.println("called tt");
			  //timer.schedule(tt, c.getTime(), 86400000);
			  response.sendRedirect("Exit.jsp");	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}
