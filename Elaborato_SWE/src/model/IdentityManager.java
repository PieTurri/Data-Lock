package model;

public class IdentityManager {
	
	private static String usernameAdv = "root";
	private static String passwordAdv = "toor";
	private static String usernameBas = "user";
	private static String passwordBas = "password";
	
	public static int checkUser(String user, String pass) {
        if(usernameAdv.equals(user) && passwordAdv.equals(pass))
        	return 0;
        else if (usernameBas.equals(user) && passwordBas.equals(pass))
			return 1;	
        else
			return 2;
    }
}