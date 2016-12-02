package ui.utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Modality;

public class MyRetreatButton extends Button{

	private static final Image PIC = 
			new Image(MyRetreatButton.class.getResource("/image/retreat.png").toExternalForm(),
					30,30,false,false);
	private static final ImageView VIEW = new ImageView(PIC);
	
	
	public MyRetreatButton(Region lastPane){
		super(null,VIEW);
		this.setStyle("-fx-background-color:null;");
		this.setPrefSize(50, 50);
		this.setMinSize(MyRetreatButton.USE_PREF_SIZE, Button.USE_PREF_SIZE);
		this.setMaxSize(MyRetreatButton.USE_PREF_SIZE, Button.USE_PREF_SIZE);
		this.setOnAction(e -> {
        	Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setHeaderText(null);
			alert.setContentText("确定要放弃当前操作，返回上一页面吗？");
			alert.showAndWait().ifPresent(response -> {
				if(response == ButtonType.OK){
					MainPane.getInstance().setRightPane(lastPane);
					
				}
			});
			
		});
	}
	
	 
}
