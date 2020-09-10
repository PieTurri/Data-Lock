package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;



public class LoginView extends JFrame {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel labelUser;
	private JLabel labelPassword;
	private JLabel logMsg;
	private JLabel iconLabel;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JButton button;
	private Image icon;
	private int adUserList;

	public LoginView(Controller controller) {
		icon = new ImageIcon(this.getClass().getResource("/enigma1.png")).getImage();
		frame = new JFrame("Data Lock - Login");
		panel = new JPanel();
		labelUser = new JLabel("User: ");
		textFieldUser = new JTextField(20);
		labelPassword = new JLabel("Password: ");
		passwordField = new JPasswordField(20);
		button = new JButton("Login");
		logMsg = new JLabel("");
		
		
		iconLabel = new JLabel("");
		iconLabel.setIcon(new ImageIcon(icon));
		iconLabel.setBounds(190, 20, 50, 50);
		
		frame.setResizable(false);	
		frame.setSize(420, 250);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		frame.setLocation ( ( screenSize.width / 2 ) - ( frame.getWidth ( ) / 2 ), (screenSize.height / 2 ) - ( frame.getHeight ( ) / 2 ) );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		labelUser.setBounds(85, 90, 80, 25);
		labelPassword.setBounds(85, 120, 80, 25);
		logMsg.setBounds(85, 180, 150, 25);
		logMsg.setForeground(Color.RED);
		
		textFieldUser.setBounds(150, 90, 165, 25);
		passwordField.setBounds(150, 120, 165, 25);
		
		button.setBounds(234, 150, 80, 25);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textFieldUser.getText();
				String password = passwordField.getText();
				
				adUserList = controller.login(user, password).getAdvancedUser();
				
				if(adUserList == 2) {
					logMsg.setText("Login Error!");
				}else {
					frame.setVisible(false);
					controller.postGui(adUserList);
				}
			}
		});

		panel.setLayout(null);

		panel.add(labelUser);
		panel.add(textFieldUser);
		panel.add(labelPassword);
		panel.add(passwordField);		
		panel.add(button);
		panel.add(logMsg);
		panel.add(iconLabel);
		frame.setVisible(true);
		
		
		frame.add(panel);
		frame.setIconImage(icon);
	}
}