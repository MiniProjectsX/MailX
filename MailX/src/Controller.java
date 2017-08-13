import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JOptionPane;

public class Controller {

	Controller(String user,String host,String password,String to2,String sub,String message,String n,String fp){
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.user", user);
		prop.put("mail.smtp.password", password);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		try{
			/// Create a session
			Session session = Session.getDefaultInstance(prop);
			
			/// Configure the message
			MimeMessage message1 = new MimeMessage(session);
			message1.addRecipient(RecipientType.TO, new InternetAddress(to2));
			message1.setFrom(new InternetAddress(user));
			message1.setSubject(sub);
			message1.setText(message);
			
			// File sending part
			if(n != ""){
				MimeBodyPart messageBodyPart = new MimeBodyPart();
		        Multipart multipart = new MimeMultipart();    
		        messageBodyPart = new MimeBodyPart();
		        String file = fp;
		        String fileName = n;
		        DataSource source = new FileDataSource(file);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        multipart.addBodyPart(messageBodyPart);
		        message1.setContent(multipart);
			}
	        
			/// Create a Transport
			Transport transport = session.getTransport("smtp");
			transport.connect(host,user,password);
			transport.sendMessage(message1, message1.getAllRecipients());
			transport.close();
			JOptionPane.showMessageDialog(null, "Mail Sent", "", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "Mail not sent", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

