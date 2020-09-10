package model;

public class FileManager implements FileInterface{
	
	private String fileName;
	private FileLoader fileLoader;
	
	public FileManager(String fileName) {
		this.fileName = fileName;
		fileLoader = new FileLoader();
	}
	
	@Override
	public String displayFile() {
		return fileLoader.openFile(fileName);
	}
	
	public FileLoader getFileLoader() {
		return fileLoader;
	}
}