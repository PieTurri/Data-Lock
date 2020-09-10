package model;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESDecrypt implements DecryptStrategy{

	private String OutString;
	private String decryptString;	

	public AESDecrypt() {}
	
	@Override
	public String decryptExecute(String txtFileCrypt, String key) {
		
		this.OutString = txtFileCrypt;
		
		try {
			byte[] byteKey = key.getBytes();
			
			Key keyDec = new SecretKeySpec(byteKey, "AES");
			
	        Cipher c = Cipher.getInstance("AES");
	        c.init(Cipher.DECRYPT_MODE, keyDec);
	        
	        byte[] decodedValue = java.util.Base64.getMimeDecoder().decode(this.OutString);
	        byte[] decValue = c.doFinal(decodedValue);
	        
	        decryptString = new String(decValue);
	        
		} catch (Exception e) {
			System.out.println("Trouble reading from the file: " + e.getMessage());
		}
		return decryptString;
	}

}
