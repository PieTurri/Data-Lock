package model;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypt implements EncryptStrategy{

	private String OutString;
	private String encryptString;	
	
	public AESEncrypt() {}
	
	@Override
	public String encryptExecute(String txtFileCrypt, String key) {
		
		this.OutString = txtFileCrypt;
			try {
				byte[] byteMessage = this.OutString.getBytes();
				byte[] byteKey = key.getBytes();
			
				Key secretKey = new SecretKeySpec(byteKey, "AES") ;
			
				Cipher c = Cipher.getInstance("AES");
				c.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] cipher = c.doFinal(byteMessage);
			
			
				encryptString = Base64.getEncoder().encodeToString(cipher);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return encryptString;
	}
}


