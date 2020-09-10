package controller;

import java.io.File;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DocumentManager;
import model.LogSection;
import model.LoginManagerProxy;
import model.LoginInterface;
import model.SaveFile;
import view.LoginView;
import view.SavingView;
import view.AdvancedUserView;
import view.BaseUserView;
import view.ErrorView;
import view.LogSectionView;

public class Controller {

	private AdvancedUserView advancedUserView;
	private BaseUserView baseUserView;
	private SaveFile saveFile;
	private JTextArea textToSaveArea;
	private SavingView sView;
	public boolean fileLoaded = false;
	private String secretKeyString;
	private JTextArea keyArea;
	private JTextArea textArea;
	private boolean isCrypted;
	private ErrorView errorView;
	private LoginView loginView;

	
	private int isAdmin = -1;
	private boolean decFile = false;
	
	LogSectionView logSectionView;
	LogSection lSection;
	DocumentManager documentManager;

	public Controller() {
		documentManager = new DocumentManager();
		
		saveFile = new SaveFile();
		lSection = new LogSection();
	}

	public void login() {
		documentManager.setAdmin(false);
		LogSection.setIsAdmin(false);
		fileLoaded = false;
		documentManager.setFileToSave(null);
		loginView  = new LoginView(this);
	}
	
	public LoginInterface login(String user, String password) {
		LoginInterface loginInterface;
		return loginInterface = new LoginManagerProxy(user, password);
	}
	
	public boolean getIsCrypted() {	return documentManager.getIsCrypted(); }
		
	public void postGui(int value) {
		setIsAdmin(value);
		switch (value) {
		case 0:
			documentManager.setAdmin(true);
			advancedUserView = new AdvancedUserView(this);
			break;
		case 1:
			baseUserView = new BaseUserView(this);
			break;
		default:
			break;
		}
	}

	public int getIsAdmin() { return isAdmin; }

	public void setIsAdmin(int isAdmin) { this.isAdmin = isAdmin; }
	
	public void cryptStrategy(int typeOfStrategy, JTextArea MessageArea, JTextArea encryptKey, JTextArea textArea) throws Exception {
		String txtAfter = documentManager.choosedStrategy(typeOfStrategy, MessageArea.getText(), encryptKey.getText());
		//System.out.println(txtAfter);
		textArea.setText(txtAfter);
	}

	public void openFile(JTextArea textArea,File file, boolean isNotLogSection) {
		textArea.setText(null);
		String loadedString = null;
		File txtFile = file;
		
		if (isNotLogSection) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Select File to Open");

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "txt");
			fileChooser.setFileFilter(filter);
			int returnVal = fileChooser.showOpenDialog(null);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				txtFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				loadedString = documentManager.openFile(txtFile.getAbsolutePath());
				documentManager.setIsCrypted(documentManager.getFileManagerProxy().getFileManager().getFileLoader().isCrypted());
				System.out.println(documentManager.getIsCrypted());
				documentManager.setFileToSave(txtFile);
				documentManager.setFileLoaded(true);	
				decFile = documentManager.getDecryptedFile();
			}
		} else {
			loadedString = documentManager.openFile(txtFile.getAbsolutePath());
		}
		
		textArea.append(loadedString);
	}

	public void saveFile(JTextArea finalMessageArea) throws Exception {
		documentManager.saveFile(finalMessageArea.getText());
		sView = new SavingView(documentManager.getSecretKey(),documentManager.getMemorizedFile(), documentManager.isOverwritten());	
		fileLoaded = false;
		documentManager.setFileToSave(null);
	}

	public void reset(JTextArea textToSaveArea, JTextArea textArea, JTextArea keyArea) {
		textToSaveArea.setText("");
		textArea.setText("");
		keyArea.setText("");
		documentManager.setFileLoaded(false);
	}
	
	public String generatedKey(int typeOfAlgorithm) throws NoSuchAlgorithmException {
		return documentManager.generateKey();
	}

	public void showLogSection() {
		logSectionView = new LogSectionView();
	}

	public void setAlgorithm(int algorithm) {
		documentManager.setAlgorithm(algorithm);
	}
	
	public int getAlgorithm() {
		return documentManager.getAlgorithm();
	}	
	
	public void showErrorView(String errorMSG) {
		errorView = new ErrorView(errorMSG);
	}
	
	public boolean checkText(JTextArea textArea) {
		
		boolean flag = true;
		String stringText = textArea.getText();
		for(int j = 0; j < stringText.length(); j++) {
			if((Character.isLetter(stringText.charAt(j)) == false) && stringText.charAt(j) != ' ')
				flag = false;
		}
		return flag;
	}

	public boolean getDecryptedFile() {
		
		return decFile;
	}
}
