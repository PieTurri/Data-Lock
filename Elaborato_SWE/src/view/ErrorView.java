package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ErrorView {
	private JFrame errorFrame;
	private JLabel errorMessageLabel;
	private JLabel errorLabel;
	private JPanel panel;
	
	private JButton button;
	
	public ErrorView(String errorMSG) {
		errorFrame = new JFrame("Data Lock - Error");
		errorFrame.setResizable(false);	
		panel = new JPanel();
		
		Font font = new Font("Courier", Font.BOLD,30);
		
		errorLabel = new JLabel("");
		errorLabel.setText("ERRORE");
		errorLabel.setBounds(145,10,150,40);
		errorLabel.setFont(font);
		errorLabel.setForeground(Color.RED);
		
		errorMessageLabel = new JLabel("");
		errorMessageLabel.setText(errorMSG);
		errorMessageLabel.setBounds(20,20,380,150);
		errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		button = new JButton("Capito!");
		button.setBounds(170, 155, 80, 25);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				errorFrame.dispose();
			}
		});
		
		Image icon = new ImageIcon(this.getClass().getResource("/enigma1.png")).getImage();
		
		errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		errorFrame.setSize(420, 235);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		errorFrame.setLocation ( ( screenSize.width / 2 ) - ( errorFrame.getWidth ( ) / 2 ), (screenSize.height / 2 ) - ( errorFrame.getHeight ( ) / 2 ) );		
		
		panel.setLayout(null);
		panel.add(button);
		panel.add(errorMessageLabel, BorderLayout.CENTER);
		panel.add(errorLabel);
		panel.add(button);
		errorFrame.add(panel);
		errorFrame.setIconImage(icon);
		errorFrame.setVisible(true);
	}
}
