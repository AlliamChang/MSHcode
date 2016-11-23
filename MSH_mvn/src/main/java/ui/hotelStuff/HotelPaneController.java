package ui.hotelStuff;

public class HotelPaneController {
	
	private static HotelPaneController controller;
	
	private HotelPaneController(){
		
	}
	
	public static HotelPaneController getInstance(){
		if(controller == null){
			controller = new HotelPaneController();
		}
		return controller;
	}
}
