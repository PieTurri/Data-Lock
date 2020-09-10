package model;

import java.io.*;

import java.util.Observable;



@SuppressWarnings("deprecation")
public class SaveFile  extends Observable{
	
	public File fileToSave;	
	private int numberFile;
	private boolean decryptedFile = false;

	public SaveFile() {}
	
	public String writeOnFile(String saveText) throws Exception {
		
		PrintWriter scriviPrintWriter = new PrintWriter(fileToSave);
		if(!decryptedFile)
			scriviPrintWriter.println("<%CRYPTED%>\n" + saveText);
		else
			scriviPrintWriter.println(saveText);
		scriviPrintWriter.close();
		setChanged();
		
		return fileToSave.getName();
	}
	
	public String createNewFile(String saveText) throws FileNotFoundException, IOException {
		
		File txtFile = new File("CryptedFile.txt");
		
		while(txtFile.exists()) {
			setNumber((int) Math.floor(Math.random() * 1000));
			txtFile = new File("CryptedFile"+getNumberFile()+".txt");
		}
		
		PrintWriter scriviPrintWriter = new PrintWriter(txtFile); 
		scriviPrintWriter.println("<%CRYPTED%>\n" + saveText);
		scriviPrintWriter.close();
		setChanged();
		
		return txtFile.getName();
	}

	public int getNumberFile() { return numberFile;	}
	
	public void setNumber(int number) {	numberFile = number; }

	public void setDecryptedFile(boolean decryptedFile2) {
		this.decryptedFile = decryptedFile2;
	}	
}
