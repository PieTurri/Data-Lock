package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Encrypt;

class EncryptTest {

	Encrypt encrypt;
	
	@BeforeEach
	void setUp() {
		encrypt = new Encrypt();
	}
	@Test
	void testEncryptStrategy() {
		assertEquals(encrypt.setEncryptStrategy(0, "Messaggio da Criptare" , "VavElWbHQPasREDS"), "zcI8D/tgzzOMtW1n/Xxd7KRY/K8Qndb/FHAsbmh20Qk=");
		assertEquals(encrypt.setEncryptStrategy(1, "Messaggio da Criptare" , "3"), "PHVVDJJLRGDFULSWDUH");
	}
}
