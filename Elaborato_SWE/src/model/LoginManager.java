package model;

public class LoginManager implements LoginInterface{
	
	public LoginManager() {}
	

	@Override
	public int getAdvancedUser() {
		return -1;
	}

	@Override
	public void setAdmin(boolean admin) {
		LogSection.setIsAdmin(admin);		
	}
}