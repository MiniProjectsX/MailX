import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class View {
	JFrame j = new JFrame("Mailx");
	JLabel from,pass,to,sub,message;
	JButton send,clear,quit,attach;
	JTextField from1,to1,sub1;
	JPasswordField pass1;
	JTextArea message1;
	JPanel jp;
	JFileChooser fc;
	
	View()
	{
		fc = new JFileChooser();
		j.setSize(400, 470);
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
		send.setBounds(2+2, 380, 90, 30);
		
		clear = new JButton("CLEAR");
		clear.setBounds(102+2, 380, 90, 30);
		
		quit = new JButton("QUIT");
		quit.setBounds(200+2, 380, 90, 30);
		
		attach = new JButton("ATTACH");
		attach.setBounds(300+2, 380, 90, 30);
		
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
		j.add(attach);
		
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

