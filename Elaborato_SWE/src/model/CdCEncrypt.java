package model;

public class CdCEncrypt implements EncryptStrategy{

	private String codString;
	
	public CdCEncrypt() {
		codString = "";
	}
	
	@Override
	public String encryptExecute(String txtFileCrypt, String key) {
		int shift = Integer.parseInt(key);
		txtFileCrypt = txtFileCrypt.replaceAll(" ", "");
		txtFileCrypt = txtFileCrypt.toUpperCase();
		
		for(int i = 0; i < txtFileCrypt.length(); i++) {
			if(txtFileCrypt.charAt(i) < 'A' || txtFileCrypt.charAt(i) > 'Z') {
				txtFileCrypt = txtFileCrypt.replaceAll(""+txtFileCrypt.charAt(i), "");
			}
		}
		
		codString = codifica(txtFileCrypt,shift);
		
		return codString;
	}

	private String codifica(String txtFileCrypt, int shift) {
		int val;
		String encryptString = "";
		
		for(int i = 0; i < txtFileCrypt.length(); i++) {
			val = (int)txtFileCrypt.charAt(i) + shift;
			if(val > 90)
				val -= 26;
			encryptString += (char)val;
		}
		
		return encryptString;
		
	}

}




