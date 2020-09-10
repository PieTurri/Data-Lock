package view;

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

public class SavingView{
	private JFrame saveFrame;
	private JPanel panel;
	private JLabel labeltxt;
	private JLabel labelSecretKey;
	private JLabel labelSecretKey1;
	private JLabel saveKeyLabel;
	private JButton button;

	public SavingView(String secretKeyString, String memorizedFile, boolean overwritten) {
		saveFrame = new JFrame("Save Crypt File");
		saveFrame.setResizable(false);	
		panel = new JPanel();
		if(overwritten)
			labeltxt = new JLabel("Il file: "+ memorizedFile +" è stato sovrascritto!");
		else {
			labeltxt = new JLabel("Il file: "+ memorizedFile +" è stato salvato!");
		}
		labelSecretKey = new JLabel("La chiave è: ");
		labelSecretKey1 = new JLabel(secretKeyString);
		Font font = new Font("Courier", Font.BOLD,20);
		labelSecretKey1.setFont(font);
		labelSecretKey1.setForeground(Color.RED);
		labelSecretKey1.setBounds(135, 60, 250, 25);
		saveKeyLabel = new JLabel("Salvala!");
		saveKeyLabel.setBounds(185,95,50,25);
		labelSecretKey.setBounds(35, 60, 100, 25);
		labeltxt.setBounds(60,25, 300, 25);
		button = new JButton("Capito!");
		button.setBounds(170, 135, 80, 25);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFrame.dispose();
			}
		});
		
		Image icon = new ImageIcon(this.getClass().getResource("/enigma1.png")).getImage();
		
		saveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		saveFrame.setSize(420, 235);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		saveFrame.setLocation ( ( screenSize.width / 2 ) - ( saveFrame.getWidth ( ) / 2 ), (screenSize.height / 2 ) - ( saveFrame.getHeight ( ) / 2 ) );
		
		panel.setLayout(null);
		panel.add(labeltxt);
		panel.add(button);
		panel.add(labelSecretKey);
		panel.add(labelSecretKey1);
		panel.add(saveKeyLabel);
		panel.add(button);
		saveFrame.add(panel);
		saveFrame.setIconImage(icon);
		saveFrame.setVisible(true);
	}
}
