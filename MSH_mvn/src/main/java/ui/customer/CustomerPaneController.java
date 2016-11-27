package ui.customer;

public class CustomerPaneController {
	private static CustomerPaneController controller;
	
	private CustomerPaneController(){
		
	}
	
	public CustomerPaneController createController(){
		if(controller==null)
			controller= new CustomerPaneController();
		return controller;
	}
}
