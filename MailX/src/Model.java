import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model {
	/// MODEL VIEW CONTROLLER (MVC)
	/// THIS IS A MODEL
	public static void main(String args[])
	{
		View g = new View();
		g.send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = g.from1.getText().toString();
				String host = "smtp.gmail.com";
				String password = g.pass1.getText().toString();
				String to2 = g.to1.getText().toString();
				new Controller(user,host,password,to2,g.sub1.getText().toString(),g.message1.getText().toString());
			}
		});
		
		g.quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		g.clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g.from1.setText(" ");
				g.to1.setText(" ");
				g.pass1.setText("");
				g.sub1.setText(" ");
				g.message1.setText(" ");
			}
		});
	}
}

