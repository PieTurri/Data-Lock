package model;

public class CdCDecrypt implements DecryptStrategy{

	@Override
	public String decryptExecute(String txtFileCrypt, String key) {
		
		int shift = Integer.parseInt(key);
		int val;
		String decryptString = "";
		
		for(int i = 0; i < txtFileCrypt.length(); i++) {
			val = (int)txtFileCrypt.charAt(i) - shift;
			if(val < 65)
				val += 26;
			decryptString += (char)val;
		}
		return decryptString;
	}
}
