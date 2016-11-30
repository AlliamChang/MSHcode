package ui.customer;

public class CustomerPaneController {
	private static CustomerPaneController controller;
	
	private CustomerPaneController(){
		
	}
	
	private CustomerPaneController createController(){
		if(controller==null)
			controller= new CustomerPaneController();
		return controller;
	}
	
	public static void setMainPane(){
		
	}
}
