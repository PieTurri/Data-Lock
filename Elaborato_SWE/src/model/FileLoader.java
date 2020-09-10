package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
	
	private String resultText = "";
	private int flag = 0;
	private String OutString = "";
	
	public FileLoader() {}
	
	public String openFile(String fileName) {
		
		try {
    		FileReader fileReader = new FileReader(fileName);
   
    		BufferedReader reader = new BufferedReader(fileReader);
    		String tmpString = reader.readLine();
    		
    		if(tmpString.equals("<%CRYPTED%>")) {
    			flag = 1;
    			OutString = tmpString.replace("<%CRYPTED%>", reader.readLine());
    		}else
    			OutString =  tmpString;
    		
    		tmpString = reader.readLine();
    		
    		while(tmpString != null) {
    			OutString = OutString.concat("\n");
    			OutString = OutString.concat(tmpString);
    			tmpString = reader.readLine();
    		}
    		
    		resultText = OutString;
    		
    		reader.close();
    		fileReader.close();
    		
    	} catch (IOException ex) {
    		System.out.println("Trouble reading from the file: " + ex.getMessage());
    	}
		return resultText;
	}

	public boolean isCrypted() {
		if(flag == 1) {
			return true;
		}
		else return false;
	}	
}




