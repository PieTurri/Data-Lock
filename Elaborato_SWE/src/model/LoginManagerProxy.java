package model;

public class LoginManagerProxy implements LoginInterface{

	private String username;
    private String password;
    private LoginManager loginManager;
    public int check;
    
 
    public LoginManagerProxy(String user, String password) {
		this.username = user;
		this.password = password;
		loginManager = new LoginManager();
	}
	
    @Override
    public int getAdvancedUser() {
    	check = checkUser();
    	setAdmin(true);
    	return check;
    }
    
    @Override
	public void setAdmin(boolean admin) {
		if( checkUser() == 0)
            loginManager.setAdmin(admin);
	}
    
	private int checkUser() {
		return IdentityManager.checkUser(this.username, this.password);
	}	
}