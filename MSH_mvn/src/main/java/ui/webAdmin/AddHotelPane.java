package ui.webAdmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

public class AddHotelPane extends AnchorPane{
	private Label nameLabel, cityLabel, areaLabel, stuffLabel, stuffNameLabel;
	private Button addButton, confirm, cancel;
	private TextField textField;
	private GridPane grid;
	private HBox hBox;
	private ChoiceBox<String> provinceChoiceBox, cityChoiceBox, areaChoiceBox;
	
	/*
	 * 测试用
	 */
	private final ArrayList<String> provinceList = new ArrayList<String>(Arrays.asList("北京", "江苏省"));
	private HashMap<String, ArrayList<String> > cityList = new HashMap<String, ArrayList<String> >(){
		{
			put("江苏省", new ArrayList<String>(Arrays.asList("南京市", "无锡市")));
			put("山东省", new ArrayList<String>(Arrays.asList("济南市", "潍坊市")));
		}
	};
	
	public AddHotelPane(){
		super();
		setStyle("-fx-font-size: 20px;");
		grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(15);
		nameLabel = new Label("名称：");
		cityLabel = new Label("城市：");
		areaLabel = new Label("商圈：");
		stuffLabel = new Label("酒店工作人员：");
		stuffNameLabel = new Label("无");
		addButton = new Button("添加");
		textField = new TextField();
		textField.setPrefWidth(255);
		stuffNameLabel.setPrefWidth(92);
		stuffNameLabel.setMaxWidth(92);
		
		provinceChoiceBox = new ChoiceBox<String>();
		cityChoiceBox = new ChoiceBox<String>();
		areaChoiceBox = new ChoiceBox<String>();
		provinceChoiceBox.getItems().addAll(provinceList);
		provinceChoiceBox.setPrefWidth(120);
		provinceChoiceBox.getSelectionModel().selectFirst();
		
		provinceChoiceBox.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
			cityChoiceBox.getItems().clear();
			ArrayList<String> cities = cityList.get((String)new_val);
			if (cities != null){
				cityChoiceBox.setDisable(false);;
				cityChoiceBox.getItems().addAll(cities);
			}
			else
				cityChoiceBox.setDisable(true);;
			cityChoiceBox.getSelectionModel().selectFirst();
		});
		
		cityChoiceBox.setPrefWidth(120);
		cityChoiceBox.setDisable(true);;
		areaChoiceBox.setPrefWidth(255);
		
		addButton.setOnAction(e -> {
			if ("添加".equals(addButton.getText())){
				stuffNameLabel.setText("新增人员");
				addButton.setText("修改");
			} else {
				stuffNameLabel.setText("无");
				addButton.setText("添加");
			}
		});
		
		grid.add(nameLabel, 0, 0);
		grid.add(textField, 1, 0, 4, 1);
		grid.add(cityLabel, 0, 1);
		grid.add(provinceChoiceBox, 1, 1, 2, 1);
		grid.add(cityChoiceBox, 3, 1, 2, 1);
		grid.add(areaLabel, 0, 2);
		grid.add(areaChoiceBox, 1, 2, 4, 1);
		grid.add(stuffLabel, 0, 3, 2, 1);
		grid.add(stuffNameLabel, 2, 3, 2, 1);
		grid.add(addButton, 4, 3);
		
		
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
			String s = "添加成功！";
			if (textField.getText().replace(" ", "").length() == 0 || stuffNameLabel.getText().equals("无")){
				type = AlertType.ERROR;
				s = "请补全酒店信息！";
			}
			Alert alert = new Alert(type, "");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setContentText(s);
			alert.getDialogPane().setHeaderText(null);
			alert.showAndWait();
		});
		
		cancel.setOnAction(event -> {
			System.out.println("Cancel");
		});
	}

}
