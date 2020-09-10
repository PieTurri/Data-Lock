package model;

public class Encrypt {
	
	private AESEncrypt aesEnc;
	private CdCEncrypt cdcEnc;
	
	public Encrypt() {
		aesEnc = new AESEncrypt();
		cdcEnc = new CdCEncrypt();
	}
	
	public String setEncryptStrategy(int typeEncryptStrategy, String txtFileCrypt, String key){
		
		switch (typeEncryptStrategy) {
			case 0: {
				return aesEnc.encryptExecute(txtFileCrypt, key);
				
			}case 1: {
				return cdcEnc.encryptExecute(txtFileCrypt,key);
				
			}
			default: return null;			
		}
	}
}
