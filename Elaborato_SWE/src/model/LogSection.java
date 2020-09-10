package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class LogSection  implements Observer {
	
	private static boolean isAdmin = false;
	private int numberFile;
	private File fileToSave;
	
	public LogSection() {}
	
	public static void setIsAdmin(boolean admin) { isAdmin = admin; }
	
	@Override
	public void update(Observable o, Object arg) { updateFileLog();	}

	private void updateFileLog() {
		
		File fileLog= new File("C:/Users/piero/Desktop/CryptoFileLog.txt");
		
		fileLog.setWritable(true);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("C:/Users/piero/Desktop/CryptoFileLog.txt",true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		if(isAdmin) {
			
			if(fileLog.exists()) {
				PrintWriter scriviPrintWriter = new PrintWriter(fileOutputStream); //serve per creare una variabile che immagazzina il testo da scrivere
				scriviPrintWriter.append("\n");
				scriviPrintWriter.append("\n");
				scriviPrintWriter.append("________________________________________________________________________________________");
				scriviPrintWriter.append("\n");
				scriviPrintWriter.append("\n");
				if(fileToSave == null) {
					scriviPrintWriter.append("> Admin ha modificato il file:<<<< CryptedFile"+ getNumberFile() +".txt >>>> in data: " + dtf.format(now) + ", alle ore: " +  dtf1.format(now));
				}
				else
					scriviPrintWriter.append("> Admin ha modificato il file:<<<< " + fileToSave.getName() + " >>>> in data: " + dtf.format(now) + ", alle ore: " +  dtf1.format(now));
				scriviPrintWriter.close();	
				fileLog.setReadOnly();
			}
		}else {
			
			if(fileLog.exists()) {
				PrintWriter scriviPrintWriter = new PrintWriter(fileOutputStream); //serve per creare una variabile che immagazzina il testo da scrivere
				scriviPrintWriter.append("\n");
				scriviPrintWriter.append("\n");
				scriviPrintWriter.append("________________________________________________________________________________________");
				scriviPrintWriter.append("\n");
				scriviPrintWriter.append("\n");
				if(fileToSave == null) {
					scriviPrintWriter.append("> User ha modificato il file:<<<< CryptedFile"+numberFile+".txt >>>> in data: " + dtf.format(now) + ", alle ore: " +  dtf1.format(now));
				}
				else
					scriviPrintWriter.append("> User ha modificato il file:<<<< " + fileToSave.getName() + " >>>> in data: " + dtf.format(now) + ", alle ore: " +  dtf1.format(now));
				scriviPrintWriter.close();		
				fileLog.setReadOnly();
			}
		}
		boolean flag = fileLog.setReadOnly();	
    	if (flag==true)
    	{
    	   System.out.println("File successfully converted to Read only mode!!");
    	}
    	else
    	{
    	   System.out.println("Unsuccessful Operation!!");
    	}
	}
	
	
	
	public boolean getIsAdmin() { return isAdmin; }
	
	public void setNumberFile(int numberFile) {	this.numberFile = numberFile; }

	public int getNumberFile() { return numberFile; }
	
	public void setFileName(File fileToSave) { this.fileToSave = fileToSave; }
}