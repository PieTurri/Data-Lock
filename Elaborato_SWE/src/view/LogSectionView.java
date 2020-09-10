package view;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import controller.Controller;

public class LogSectionView{
	private JFrame frame;
	private JPanel panel;
	private JTextArea logTextArea;
	private JButton backButton;
	private JLabel titleLabel;
	private JLabel descriptionViewLabel;
	private Font titlFont;
	private File logFile;
	private JScrollPane scrollPaneLogMessage;
	private TitledBorder titledBorder;
	
	private Controller controller;
	
	public LogSectionView() {
		instanceObject();
		addFeature();
		addObjectToFrame();
		loadLogList();
	}

	private void loadLogList() {
		controller.openFile(logTextArea, logFile, false);
	}

	private void addObjectToFrame() {
		panel.setLayout(null);
		
		panel.add(backButton);
		panel.add(titleLabel);
		panel.add(scrollPaneLogMessage);
		
		frame.add(panel);
	}

	private void addFeature() {
		frame.setSize(700, 780);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		frame.setLocation ( ( screenSize.width / 2 ) - ( frame.getWidth ( ) / 2 ), (screenSize.height / 2 ) - ( frame.getHeight ( ) / 2 ) );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		scrollPaneLogMessage.setBounds(40, 150, 600, 500);
		scrollPaneLogMessage.setBorder(titledBorder);
		
		logTextArea.setBackground(Color.WHITE);
		logTextArea.setLineWrap(true);
		logTextArea.setEditable(false);
		
		backButton.setBounds(40, 680, 35, 20);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controller.postGui(0);
			}
		});
		
		titleLabel.setBounds(40, 10, 300, 50);
		titleLabel.setFont(titlFont);
		
		descriptionViewLabel.setBounds(40, 80, 250, 25);
	}

	private void instanceObject() {
		
		controller = new Controller();
		frame = new JFrame("Data Lock - LogSection");
		panel = new JPanel();
		logTextArea = new JTextArea("");
		backButton = new JButton(new ImageIcon(getClass().getResource("/back.png")));
		titleLabel = new JLabel("Data Lock");
		titlFont = new Font("Courier", Font.PLAIN,40);
		descriptionViewLabel = new JLabel("Registro processi effettuati:");
		logFile = new File("C:/Users/piero/Desktop/CryptoFileLog.txt");
		scrollPaneLogMessage = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		titledBorder = new TitledBorder("Riepilogo modifiche effettuate da Data Lock:");
	}
}