package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.Encrypt;

class LogSectionTest {

	Encrypt encrypt;
	DocumentManager dManager;
	
	@BeforeEach
	void setUp() throws Exception {
		encrypt = new Encrypt();
		dManager = new DocumentManager();
	}

	@Test
	void test() throws Exception {
		
		File fileToCheckBefore = new File("C:/Users/piero/Desktop/CryptoFileLog.txt"); 
		long sizeInBytesBefore = fileToCheckBefore.length();
		
		dManager.setFileLoaded(false);
		dManager.saveFile("Salvo una stringa per il test");
		
		File fileToCheckAfter = new File("C:/Users/piero/Desktop/CryptoFileLog.txt"); 
		long sizeInBytesAfter = fileToCheckAfter.length();
		
		assertTrue(sizeInBytesAfter > sizeInBytesBefore);
	}

}
