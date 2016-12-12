package ui.webAdmin;

import java.util.List;

import ui.utility.MainPane;
import vo.HotelInfoVO;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

public class AddHotelPane extends AnchorPane{
	private Label nameLabel, cityLabel, areaLabel, staffLabel, staffNameLabel;
	private Button addButton, confirm, cancel;
	private TextField textField;
	private GridPane grid;
	private HBox hBox, buttonBox;
	private ChoiceBox<String> provinceChoiceBox, cityChoiceBox, areaChoiceBox;
	private AddHotelStaffPane addPane;
	
	public AddHotelPane(){
		super();
		setStyle("-fx-border-color: black");
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(15);
		nameLabel = new Label("名称：");
		cityLabel = new Label("城市：");
		areaLabel = new Label("商圈：");
		staffLabel = new Label("酒店工作人员：");
		staffNameLabel = new Label("无");
		addButton = new Button("添加");
		textField = new TextField();
		textField.setPrefWidth(255);
		staffNameLabel.setPrefWidth(92);
		staffNameLabel.setMaxWidth(92);
		
		provinceChoiceBox = new ChoiceBox<String>();
		cityChoiceBox = new ChoiceBox<String>();
		areaChoiceBox = new ChoiceBox<String>();
		provinceChoiceBox.setPrefWidth(120);
		cityChoiceBox.setPrefWidth(120);
		areaChoiceBox.setPrefWidth(255);
		
		
		provinceChoiceBox.getItems().addAll(WebAdminController.getInstance().getProvinces());
		
		provinceChoiceBox.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
			cityChoiceBox.getItems().clear();
			List<String> cities = WebAdminController.getInstance().getCities((String)new_val);
			if (cities != null){
				cityChoiceBox.setDisable(false);;
				cityChoiceBox.getItems().addAll(cities);
			} else
				cityChoiceBox.setDisable(true);
			cityChoiceBox.getSelectionModel().selectFirst();
		});
		
		cityChoiceBox.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
			areaChoiceBox.getItems().clear();
			List<String> areas = WebAdminController.getInstance().getAreas(provinceChoiceBox.getValue(), (String)new_val);
			if (areas != null){
				areaChoiceBox.setDisable(false);
				areaChoiceBox.getItems().addAll(areas);
			} else
				areaChoiceBox.setDisable(true);	
			areaChoiceBox.getSelectionModel().selectFirst();
		});
		
		provinceChoiceBox.getSelectionModel().selectFirst();
		cityChoiceBox.getSelectionModel().selectFirst();
		if (cityChoiceBox.getItems().isEmpty())
			areaChoiceBox.getItems().addAll(WebAdminController.getInstance().getAreas(provinceChoiceBox.getValue(),null));
		areaChoiceBox.getSelectionModel().selectFirst();
		
		addButton.setOnAction(e -> {
			if ("添加".equals(addButton.getText()))
				WebAdminController.getInstance().setAddHotelStaffPane(this);
			else
				WebAdminController.getInstance().goBack(addPane);
		});
		
		grid.add(nameLabel, 0, 0);
		grid.add(textField, 1, 0, 4, 1);
		grid.add(cityLabel, 0, 1);
		grid.add(provinceChoiceBox, 1, 1, 2, 1);
		grid.add(cityChoiceBox, 3, 1, 2, 1);
		grid.add(areaLabel, 0, 2);
		grid.add(areaChoiceBox, 1, 2, 4, 1);
		grid.add(staffLabel, 0, 3, 2, 1);
		grid.add(staffNameLabel, 2, 3, 2, 1);
		buttonBox = new HBox();
		buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
		buttonBox.getChildren().add(addButton);
		grid.add(buttonBox, 4, 3);
		
		hBox = new HBox();
		hBox.setSpacing(30);
		confirm = new Button("确定");
		cancel = new Button("取消");
		confirm.setPrefSize(80, 30);
		cancel.setPrefSize(80, 30);
		hBox.getChildren().add(confirm);
		hBox.getChildren().add(cancel);
		

		getChildren().addAll(grid, hBox);
		
		AnchorPane.setBottomAnchor(hBox, 40.0);
		AnchorPane.setRightAnchor(hBox, 100.0);
		AnchorPane.setLeftAnchor(grid, 160.0);
		AnchorPane.setTopAnchor(grid, 170.0);
		
		confirm.setOnAction(e -> {
			AlertType type = AlertType.INFORMATION;
			String s;
			int staffID = -1;
			if (textField.getText().trim().isEmpty() || staffNameLabel.getText().equals("无")){
				type = AlertType.ERROR;
				s = "请补全酒店信息！";
			} else {
				staffID = WebAdminController.getInstance().addUser(addPane.getStaff());
				s = "添加成功！\n工作人员ID：" + staffID + "        初始密码：123456";
			}
			Alert alert = new Alert(type, "");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setContentText(s);
			alert.getDialogPane().setHeaderText(null);
			if (type.equals(AlertType.ERROR))
				alert.show();
			else {
				WebAdminController.getInstance().addHotel(
						new HotelInfoVO(textField.getText(), null, null, null, null, 
								provinceChoiceBox.getValue(), areaChoiceBox.getValue(), 0, null, 0, 0, 0, staffID));
				alert.showAndWait().filter(r -> r == ButtonType.OK).ifPresent(r -> 
					WebAdminController.getInstance().setBrowseHotelPane());
			}
		});
		
		cancel.setOnAction(event -> {
			WebAdminController.getInstance().setBrowseHotelPane();
		});
	}
	public void changeLabel(String name){
		staffNameLabel.setText(name);
	}
	
	public void changeButton(){
		addButton.setText("修改");
	}
	
	public void setAddPane(AddHotelStaffPane pane){
		addPane = pane;
	}
}
