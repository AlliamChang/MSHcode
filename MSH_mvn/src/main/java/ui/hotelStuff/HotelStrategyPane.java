package ui.hotelStuff;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HotelStrategyPane extends VBox{

	public HotelStrategyPane(){
		super();
		Label l = new Label("促销");
		this.getChildren().add(l);
	}
}
