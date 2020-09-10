package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.FileManagerProxy;
import model.DocumentManager;

class FileLoaderTest {

	DocumentManager dManager;
	FileManagerProxy fProxy;
	
	@BeforeEach
	void setUp() throws Exception {
		dManager = new DocumentManager();
		fProxy = new FileManagerProxy("fileTest.txt");
	}

	@Test
	void testIsCrypted() {
		assertEquals(fProxy.displayFile(), "6JOf2PdcX/5zroHLZWODUuNwNlpLBJOXiZdACL3hqt0BCrogFr3vV72svBzYuoM+");
		assertEquals(fProxy.getFileManager().getFileLoader().isCrypted(), true);
	}
}




