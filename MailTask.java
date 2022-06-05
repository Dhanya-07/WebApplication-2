import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class MailTask  extends TimerTask{
	public void run()
	{
		 try {
		  	 //timer
		  	// TimerTask cleanUpTimerTask=new CleanUpTimer
		  	 
		  	 //
			 
		  	
		  	 System.out.println("1");
		  	 final 	String username="raspberrypi796@gmail.com";
		  	 final String password="19L109Dha";
		  	 String from="raspberrypi796@gmail.com";
		  	 String to="ownermailid90@gmail.com";
		  	 
		  	 //prp
		  	 System.out.println("prp");
		  	 Properties prp=new Properties();
		  	 prp.put("mail.smtp.auth", "true");
		  	 prp.put("mail.smtp.starttls.enable", "true");
		  	 prp.put("mail.smtp.user", from);
		  	 prp.put("mail.smtp.password", password);
		  	 prp.put("mail.smtp.host", "smtp.gmail.com");
		  	 prp.put("mail.smtp.port", "587");
		  	 System.out.println("3");
		  	 Session ses=Session.getInstance(prp,new javax.mail.Authenticator()
		  			 {
		  		 protected javax.mail.PasswordAuthentication getPasswordAuthentication()
		  		 {
		  			 return new PasswordAuthentication(username,password);
		  		 }
		  		 
		  			 });
		  	 
		  	 MimeMessage msg=new MimeMessage(ses);
		  	 msg.setFrom(new InternetAddress(from));
		  	 msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		  	 System.out.println("af");
		  	 
		  	 msg.setSubject("Poll Vote Information");
		  	 Multipart emailcontent =new MimeMultipart();
		  	 MimeBodyPart csvfile=new MimeBodyPart();
		  	 csvfile.attachFile("C:\\Users\\Dhanya\\OneDrive\\Desktop\\CSV Files\\Votes_table.csv");
		  	 emailcontent.addBodyPart(csvfile);
		  	 msg.setContent(emailcontent);
		  	
		  	 //
		  	 //Transposrt
		  	 Transport.send(msg);
		  	 System.out.println("trans");
		  	 System.out.println("Sent mail");
		  	 System.out.println("pw");
		  	 
		  	 //csv
		    
		    } catch (Exception e) {
		       // TODO: handle exception
		    	System.out.println(e);
		    }
  }
}
