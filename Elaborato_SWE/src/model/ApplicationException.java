package model;

public class ApplicationException extends Throwable {
	
	public ApplicationException() {}
	
	public static String getNoTextApplicationException() {
		return "� obbligatorio inserire un messaggio per criptarlo!";
	}
}
