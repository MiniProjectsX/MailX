import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JOptionPane;

public class Controller {
	//CONTROLLER
	Controller(String user,String host,String password,String to2,String sub,String message){
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
			MimeMessage message2 = new MimeMessage(session);
			message2.addRecipient(RecipientType.TO, new InternetAddress(to2));
			message2.setFrom(new InternetAddress(user));
			message2.setSubject(sub);
			message2.setText(message);
			
			/// Create a Transport
			Transport transport = session.getTransport("smtp");
			transport.connect(host,user,password);
			transport.sendMessage(message2, message2.getAllRecipients());
			transport.close();
			JOptionPane.showMessageDialog(null, "Mail Sent", "", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "Mail not sent", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
