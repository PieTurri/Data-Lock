package view;

import controller.Controller;

public class AdvancedUserView extends UserView{

	private int role = 0;
	
	public AdvancedUserView(Controller controller) {

		super.controller = controller;
		
		instanceElements(role); //istanzio tutti gli oggetti di cui ho bisogno per la grafica

		setFrame(); //instanzio la finestra
		
		setContentFrame(role); //definisco gli elementi
		
		addElementToFrame(role);//aggiungo gli elementi al frame
	}
}
	
	