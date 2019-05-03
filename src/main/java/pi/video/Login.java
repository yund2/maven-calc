package pi.video;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public static final String USER_LOGIN = "user";
	public static final String USER_PASSWORD = "user";
	public static final String ADMIN_LOGIN = "admin";
	public static final String ADMIN_PASSWORD = "admin";
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 419, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(74, 73, 260, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 128, 260, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("as user");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(checkUserData() == true)
					System.out.print("correct");
				else
					System.out.print("wrong");

			}
			
		});
		btnNewButton.setBounds(74, 174, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("as admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAdminData() == true)
					System.out.print("correct");
				else
					System.out.print("wrong");
			}
		});
		btnNewButton_1.setBounds(245, 174, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("login");
		lblNewLabel.setBounds(192, 33, 46, 14);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private boolean checkUserData() {
		if(textField.getText().equals(USER_LOGIN) && textField_1.getText().equals(USER_PASSWORD))
			return true;
		else
			return false;
	}
	
	private boolean checkAdminData() {
		if(textField.getText().equals(ADMIN_LOGIN) && textField_1.getText().equals(ADMIN_PASSWORD))
			return true;
		else
			return false;
	}
}
