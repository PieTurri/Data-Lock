package model;

public class ApplicationException extends Throwable {
	
	public ApplicationException() {}
	
	public static String getNoTextApplicationException() {
		return "È obbligatorio inserire un messaggio per criptarlo!";
	}
}
