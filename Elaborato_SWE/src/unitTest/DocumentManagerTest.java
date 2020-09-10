package unitTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.SaveFile;

class DocumentManagerTest {

	DocumentManager docManager;
	SaveFile sFile;
	
	@BeforeEach
	void setUp() {
		docManager = new DocumentManager();
		sFile = new SaveFile();
	}

	@Test
	void testChooseStrategy() throws Exception {
		docManager.setAlgorithm(0);
		
		assertEquals(docManager.choosedStrategy(0, "Messaggio da Criptare", "VavElWbHQPasREDS"), "zcI8D/tgzzOMtW1n/Xxd7KRY/K8Qndb/FHAsbmh20Qk=");
		assertEquals(docManager.choosedStrategy(1, "zcI8D/tgzzOMtW1n/Xxd7KRY/K8Qndb/FHAsbmh20Qk=", "VavElWbHQPasREDS"), "Messaggio da Criptare");
		
		docManager.setAlgorithm(1);
		
		assertEquals(docManager.choosedStrategy(0, "Messaggio da Criptare", "3"), "PHVVDJJLRGDFULSWDUH");
		assertEquals(docManager.choosedStrategy(1, "PHVVDJJLRGDFULSWDUH", "3"), "MESSAGGIODACRIPTARE");
	}
	
	@Test
	void testGenerateKey() throws NoSuchAlgorithmException {
		docManager.setAlgorithm(0);
		assertEquals(docManager.generateKey().length(), 16);
		docManager.setAlgorithm(1);
		assertTrue(Integer.parseInt(docManager.generateKey()) < 26);
	}
	
	@Test
	void testSaveFile() throws Exception {

		docManager.setFileLoaded(true);
		docManager.setFileToSave(new File("CryptedFile.txt"));
		docManager.saveFile("Stringa da Salvare");
		
		assertEquals(docManager.isOverwritten(), true);
		
		docManager.setFileLoaded(false);
		docManager.setFileToSave(null);
		docManager.saveFile("Stringa da Salvare");
		assertEquals(docManager.isOverwritten(), false);
	}
	
	@Test
	void testOpenFile() {
		assertTrue(docManager.openFile("C:/Users/piero/Desktop/CryptoFileLog.txt"), true);
		
		docManager.setIsCrypted(docManager.getFileManagerProxy().getFileManager().getFileLoader().isCrypted());
		assertFalse(docManager.getIsCrypted());
	}
}
