package model;

public class FileManagerProxy implements FileInterface{

	private FileManager fileManager;
	private String filePath;
	
	public FileManagerProxy(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public String displayFile() {
		if (fileManager==null)
            fileManager = new FileManager(filePath);
        
        return fileManager.displayFile();
	}

	public FileManager getFileManager() {
		return fileManager;
	}
}

