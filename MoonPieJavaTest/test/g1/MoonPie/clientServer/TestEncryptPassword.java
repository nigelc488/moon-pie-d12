package g1.MoonPie.clientServer;

import junit.framework.TestCase;

public class TestEncryptPassword extends TestCase {
	
	public void testEncrypt(){
		String password = "password";
		String encryptedPassword = EncryptPassword.getSuperSecrectPassword(password);
		String password2 = "password";
		String encryptedPassword2 = EncryptPassword.getSuperSecrectPassword(password2);
		assertEquals(encryptedPassword, encryptedPassword2);
	}

}
