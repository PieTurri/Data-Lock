package model;

import java.io.File;

public class DocumentManager {
	
	private Decrypt decrypt;
	private Encrypt encrypt;
	private SaveFile saveFile;
	private LogSection logSection;
	private FileManagerProxy FileManagerProxy;
	
	private String secretKey;
	private boolean isCrypted = false;
	private File fileToSave;
	private boolean admin;
	private int algorithm;
	private boolean fileLoaded = false;
	private String memorizedFile;
	private boolean overwritten;
	private boolean decryptedFile = false;

	@SuppressWarnings("deprecation")
	public DocumentManager() {
		fileToSave = null;
		admin = false;
		encrypt = new Encrypt();
		decrypt = new Decrypt();
		saveFile = new SaveFile();
		logSection = new LogSection();
		saveFile.addObserver(logSection);
	}
	
	public String choosedStrategy(int typeOfStrategy, String MessageAreaString, String key) throws Exception{
		switch (typeOfStrategy) {
			case 0: { 
				return encrypt.setEncryptStrategy(algorithm, MessageAreaString, key);
			}case 1: {
				decryptedFile = true;
				return decrypt.setDecryptStrategy(algorithm, MessageAreaString, key);
			}
			default: return null;
		}
	}
	
	public String generateKey(){
		switch (getAlgorithm()) {
			case 0: {
				String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"  + "abcdefghijklmnopqrstuvxyz"; 
				StringBuilder sb = new StringBuilder(16); 

				for (int i = 0; i < 16; i++) {
					int index = (int)(AlphaNumericString.length()* Math.random());
					sb.append(AlphaNumericString.charAt(index)); 
				} 
		
				setSecretKey(new String(sb));
				return getSecretKey();
			}
			case 1: { 
				
				int n = -1; 
				boolean flag = false;
				while(!flag) {
					n = (int) Math.floor(Math.random() * 26);
					if(n < 26)
						flag = true;
				}
				setSecretKey(new String(Integer.toString(n)));
				return getSecretKey();
			}
			default: return null;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void saveFile(String finalMessage) throws Exception {
		
		if (getFileLoaded()) {
			
			saveFile.fileToSave = getFileToSave();
			saveFile.setDecryptedFile(decryptedFile);
			
			setMemorizedFile(saveFile.writeOnFile(finalMessage));
			
			logSection.setFileName(saveFile.fileToSave);
			logSection.setNumberFile(saveFile.getNumberFile());
			
			
			saveFile.notifyObservers();
			
			setOverwritten(true);
		} else {
			
			saveFile.fileToSave = null;

			setMemorizedFile(saveFile.createNewFile(finalMessage));
			
			logSection.setFileName(saveFile.fileToSave);
			logSection.setNumberFile(saveFile.getNumberFile());
			
			
			saveFile.notifyObservers();
			
			setOverwritten(false);
		}
	}
	
	public String openFile(String absolutePath) {
		FileManagerProxy = new FileManagerProxy(absolutePath);
        return FileManagerProxy.displayFile();
	}
	
	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public void setFileToSave(File fileToSave) {
		this.fileToSave = fileToSave;
	}
	
	public File getFileToSave() {
		return fileToSave;
	}

	public boolean getIsCrypted() {
		return isCrypted;
	}

	public void setIsCrypted(boolean isCrypted) {
		this.isCrypted = isCrypted;
	}

	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getMemorizedFile() {
		return memorizedFile;
	}

	public void setMemorizedFile(String memorizedFile) {
		this.memorizedFile = memorizedFile;
	}

	public boolean isOverwritten() {
		return overwritten;
	}

	public void setOverwritten(boolean overwritten) {
		this.overwritten = overwritten;
	}

	public void setFileLoaded(boolean fileLoaded) {
		this.fileLoaded = fileLoaded;
	}
	
	public boolean getFileLoaded() {
		return fileLoaded;
	}

	public FileManagerProxy getFileManagerProxy() {
		return FileManagerProxy;
	}

	public boolean getDecryptedFile() {
		
		return decryptedFile;
	}
}
