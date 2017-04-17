
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.*;
import java.awt.event.*;
import java.util.Properties;


public class gui {
	/// new push by samarth
	JFrame j = new JFrame("Mailx");
	JLabel from,pass,to,sub,message;
	JButton send,clear,quit;
	JTextField from1,to1,sub1;
	JPasswordField pass1;
	JTextArea message1;
	JPanel jp;
	
	gui()
	{
		j.setVisible(true);
		j.setSize(400, 470);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		
		from = new JLabel("FROM :");
		from.setBounds(10, 20, 48, 20);
		
		pass = new JLabel("PASSWORD :");
		pass.setBounds(10, 50, 90, 20);
		
		to = new JLabel("TO :");
		to.setBounds(10, 80, 40, 20);
		
		sub = new JLabel("SUBJECT :");
		sub.setBounds(10, 110, 90, 20);
		
		message = new  JLabel("MESSAGE :");
		message.setBounds(10, 140, 90, 20);
		
		from1 = new JTextField(30);
		from1.setBounds(60, 20, 240, 20);
		
		to1 = new JTextField(30);
		to1.setBounds(52, 80, 240, 20);
		
		pass1 = new JPasswordField(30);
		pass1.setBounds(102, 50, 240, 20);
		
		sub1 = new JTextField(30);
		sub1.setBounds(92, 110, 240, 20);
		
		message1 = new JTextArea(30,30);
		message1.setBounds(75, 160, 270, 200);
		message1.setEditable(true);
		
		JScrollPane scroll = new JScrollPane(message1);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		send = new JButton("SEND");
		send.setBounds(2+3, 380, 120, 30);
		
		clear = new JButton("CLEAR");
		clear.setBounds(124+3, 380, 120, 30);
		
		quit = new JButton("QUIT");
		quit.setBounds(246+3, 380, 120, 30);
		
		jp = new JPanel();
		j.add(from);
		j.add(pass);
		j.add(to);
		j.add(sub);
		j.add(message);
		j.add(from1);
		j.add(sub1);
		j.add(pass1);
		j.add(message1);
		j.add(to1);
		j.add(jp);
		jp.add(scroll);
		j.add(send);
		j.add(clear);
		j.add(quit);
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = from1.getText().toString();
				String host = "smtp.gmail.com";
				String password = pass1.getText().toString();
				String to2 = to1.getText().toString();
				
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
					message2.setSubject(sub1.getText().toString());
					message2.setText(message1.getText().toString());
					
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
		});
		
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				from1.setText(" ");
				to1.setText(" ");
				pass1.setText("");
				sub1.setText(" ");
				message1.setText(" ");
			}
		});
	}
	public static void main(String args[])
	{
		new gui();
	}
}

