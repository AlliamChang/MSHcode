package ui.hotelStuff;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HotelInfoPane extends Pane{

	public HotelInfoPane(){
		super();
		Label l = new Label("入住信息");
		this.getChildren().add(l);
	}
}
