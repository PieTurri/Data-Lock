package model;

public class Decrypt {
	
	private AESDecrypt aesDec;
	private CdCDecrypt cdcDec;
	
	public Decrypt() {
		aesDec = new AESDecrypt();
		cdcDec = new CdCDecrypt();
	}
	
	public String setDecryptStrategy(int typeDecryptStrategy, String txtFileCrypt, String key){
		
		switch (typeDecryptStrategy) {
			case 0: {
				return aesDec.decryptExecute(txtFileCrypt, key);
				
			}case 1:{
				return cdcDec.decryptExecute(txtFileCrypt,key);		
			
			}default: return null;
		}
		
		
	}
}
