package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Decrypt;

class DecryptTest {

	Decrypt decrypt;
	
	@BeforeEach
	void setUp() {
		decrypt = new Decrypt();
	}
	
	@Test
	void testSetDecryptStrategy() {
		assertEquals(decrypt.setDecryptStrategy(0, "zcI8D/tgzzOMtW1n/Xxd7KRY/K8Qndb/FHAsbmh20Qk=", "VavElWbHQPasREDS"), "Messaggio da Criptare");
		assertEquals(decrypt.setDecryptStrategy(1, "PHVVDJJLRGDFULSWDUH", "3"), "MESSAGGIODACRIPTARE");
	}
}
