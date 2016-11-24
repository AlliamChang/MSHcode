package ui.hotelStuff;

import javafx.scene.image.Image;
import ui.utility.MainPane;

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
	
	/**
	 * 跳转至酒店订单列表界面
	 * @param id
	 * @param hotel
	 * @param scul
	 */
	public void createOrderListPane(long id,String hotel,Image scul){
		if(MainPane.getInstance().getChildren().size() > 0 ){
			for(int i = 0; i < MainPane.getInstance().getChildren().size(); i ++)
				MainPane.getInstance().getChildren().remove(i);
		}
		
		new OrderListPane(id,hotel,scul);
	}
}
