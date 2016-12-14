package ui.hotelStuff;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import ui.hotelStuff.control.HotelPaneController;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyRetreatButton;
import vo.OrderVO;

public class CheckinInfoPane extends VBox{

	private TextField bookerField;
	private TextField orderField;
	private TextField roomField;
	private ChoiceBox<String> roomStyleBox;
	private MyDatePicker checkinPick;
	private MyDatePicker checkoutPick;
	private Parent lastPane;
	
	public CheckinInfoPane(Parent lastPane){
		super(20);
		this.lastPane = lastPane;
		init();
	}
	
	public CheckinInfoPane(Parent lastPane,String booker,String roomStyle,LocalDate checkin,LocalDate checkout,long id){
		this(lastPane);
		bookerField.setText(booker);
		orderField.setText(id+"");
		roomStyleBox.getSelectionModel().select(roomStyle);
		checkinPick.setValue(checkin);
		checkoutPick.setValue(checkout);
	}
	
	private void init(){
		this.setMinSize(MainPane.getInstance().MINWIDTH, MainPane.getInstance().MINHEIGHT);
		this.setStyle("-fx-border-color:black;-fx-font-size:15;");
		this.setPadding(new Insets(50,50,50,50));
		
		MyRetreatButton retreat = new MyRetreatButton(lastPane);
		VBox.setMargin(retreat, new Insets(-45,-30,-30,-45));
		
		Label title = new Label("新的入住信息");
		title.setFont(Font.font(30));
		
		
		Separator sep = new Separator();
		sep.setMaxWidth(450);
		sep.setStyle("-fx-border-width:2;-fx-background-color:black;");
		
		GridPane infoPane = new GridPane();
		infoPane.setVgap(20);
		VBox.setMargin(infoPane, new Insets(0,0,0,40));
		
		Label bookerLab = new Label("登记者：");
		GridPane.setConstraints(bookerLab, 0, 0);
		
		Label roomStyleLab = new Label("房间类型：");
		GridPane.setConstraints(roomStyleLab, 0, 1);
		
		Label checkinLab = new Label("入住时间：");
		GridPane.setConstraints(checkinLab, 0, 2);
		
		Label checkoutLab = new Label("预计退房时间：");
		GridPane.setConstraints(checkoutLab, 0, 3);
		
		Label orderLab = new Label("附属订单号：");
		GridPane.setConstraints(orderLab, 0, 4);
		
		Label roomNumLab = new Label("房间号：");
		GridPane.setConstraints(roomNumLab, 0, 5);
		
		this.bookerField = new TextField();
		GridPane.setConstraints(bookerField, 1, 0);
		
		this.roomStyleBox = new ChoiceBox<>();
		roomStyleBox.getItems().addAll(HotelPaneController.getInstance().getRoomStyle());
		GridPane.setConstraints(roomStyleBox, 1, 1);
		
		this.checkinPick = new MyDatePicker();
		checkinPick.setValue(LocalDate.now());
		GridPane.setConstraints(checkinPick, 1, 2);
		
		this.checkoutPick = new MyDatePicker();
		checkoutPick.setBeforeDisable(checkinPick);
		GridPane.setConstraints(checkoutPick, 1, 3);
		
		this.orderField = new TextField();
		orderField.setPromptText("（没有则不用填）");
		GridPane.setConstraints(orderField, 1, 4);
		
		this.roomField = new TextField();
		GridPane.setConstraints(roomField, 1, 5);
		
		infoPane.getChildren().addAll(bookerLab,roomStyleLab,checkinLab,checkoutLab,orderLab,
				roomNumLab,bookerField,roomStyleBox,checkinPick,checkoutPick,orderField,roomField);
		
		Separator sep2 = new Separator();
		sep2.setMaxWidth(450);
		sep2.setStyle("-fx-border-width:2;-fx-background-color:black;");
		
		Button add = new Button("更新");
		add.setFont(Font.font(20));
		add.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setHeaderText(null);
			alert.setContentText("是否确认信息无误？");
			alert.showAndWait().ifPresent(response -> {
				
			});
		});
		VBox.setMargin(add, new Insets(0,0,0,400));
		
		this.getChildren().addAll(retreat,title,sep,infoPane,sep2,add);
	}
}
