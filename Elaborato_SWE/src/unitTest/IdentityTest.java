package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.LogSection;
import model.LoginInterface;
import model.LoginManagerProxy;

class IdentityTest {

	LoginInterface lInterface;
	LogSection ls;
	
	@BeforeEach
	void setUp() {
		ls = new LogSection();
	}

	@Test
	void test() {
		lInterface = new LoginManagerProxy("root", "password");
		
		assertEquals(lInterface.getAdvancedUser(), 2);
		assertFalse(ls.getIsAdmin());
		
		lInterface = new LoginManagerProxy("root", "toor");
		
		assertEquals(lInterface.getAdvancedUser(), 0);
		assertTrue(ls.getIsAdmin());
	}
}
