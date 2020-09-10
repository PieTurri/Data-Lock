package view;

import controller.Controller;

public class BaseUserView extends UserView{
	
	private int role = 1;
	
	public BaseUserView(Controller controller) {
		
		super.controller = controller;
		
	
		instanceElements(role); //istanzio tutti gli oggetti di cui ho bisogno per la grafica

		setFrame(); //instanzio la finestra
		
		setContentFrame(role); //definisco gli elementi
		
		addElementToFrame(role);//aggiungo gli elementi al frame
	}
}
