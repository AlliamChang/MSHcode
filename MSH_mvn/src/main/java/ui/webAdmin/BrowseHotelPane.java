package ui.webAdmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import ui.utility.MainPane;
import vo.HotelVO;
import vo.RoomVO;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.util.Callback;

public class BrowseHotelPane extends VBox{
	private Label nameLabel, cityLabel, areaLabel;
	private Button addButton, filterButton;
	private TextField textField;
	private HBox h1, h2;
	private VBox v;
	private ChoiceBox<String> provinceChoiceBox, cityChoiceBox, areaChoiceBox;
	private TableView<HotelVO> table;
	private Separator sprt;

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
	
	
	public BrowseHotelPane(){
		super();
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setStyle("-fx-border-color: black");
		setPadding(new Insets(20, 20, 20, 20));
		setSpacing(20);
		nameLabel = new Label("名称：");
		cityLabel = new Label("城市：");
		areaLabel = new Label("商圈：");
		addButton = new Button("添加酒店");
		filterButton = new Button("筛选");
		filterButton.setPrefWidth(60);
		textField = new TextField();
		textField.setPrefWidth(300);
		
		provinceChoiceBox = new ChoiceBox<String>();
		provinceChoiceBox.setPrefWidth(100);
		cityChoiceBox = new ChoiceBox<String>();
		cityChoiceBox.setPrefWidth(100);
		areaChoiceBox = new ChoiceBox<String>();
		areaChoiceBox.setPrefWidth(200);
		provinceChoiceBox.getItems().addAll(provinceList);
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
		
		cityChoiceBox.setDisable(true);;
		
		h1 = new HBox(); h2 = new HBox();
		h1.setSpacing(20); h2.setSpacing(20);
		h1.getChildren().addAll(cityLabel, provinceChoiceBox, cityChoiceBox, areaLabel, areaChoiceBox);
		sprt = new Separator();
		sprt.setOrientation(Orientation.VERTICAL);
		h2.getChildren().addAll(nameLabel, textField, filterButton, sprt, addButton);
		v = new VBox();
		v.getChildren().addAll(h1, h2);
		v.setPadding(new Insets(20, 20, 20, 20));
		v.setSpacing(20);
		v.setStyle("-fx-border-color: #CDCDC1");
		
		table = new TableView<HotelVO>();
		TableColumn<HotelVO, String> name = new TableColumn<HotelVO, String>("酒店名称");
		name.setCellValueFactory(new PropertyValueFactory<HotelVO, String>("name"));
		name.setPrefWidth(200);
		TableColumn<HotelVO, String> stuff = new TableColumn<HotelVO, String>("工作人员");
		stuff.setCellValueFactory(new PropertyValueFactory<HotelVO, String>("stuff"));
		stuff.setPrefWidth(80);
		TableColumn<HotelVO, String> stuffNumber = new TableColumn<HotelVO, String>("工作人员电话");
		stuffNumber.setCellValueFactory(new PropertyValueFactory<HotelVO, String>("number"));
		stuffNumber.setPrefWidth(130);
		stuffNumber.setSortable(false);
		TableColumn<HotelVO, HBox> operation = new TableColumn<HotelVO, HBox>("");
		operation.setPrefWidth(183);
		operation.setSortable(false);
		operation.setCellFactory(new Callback<TableColumn<HotelVO, HBox>, TableCell<HotelVO, HBox> >(){

			@Override
			public TableCell<HotelVO, HBox> call(TableColumn<HotelVO, HBox> col) {
				return new TableCell<HotelVO, HBox>(){
					
					@Override
					protected void updateItem(HBox item, boolean empty){
						if (!empty){
							item = new HBox();
							item.setSpacing(5);
							Button modefyButton = new Button("修改工作人员");
							Button delButton = new Button("删除酒店");
							modefyButton.setPadding(new Insets(2, 5, 2, 5));
							delButton.setPadding(new Insets(2, 5, 2, 5));
							delButton.setOnAction(e -> {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.getDialogPane().setHeaderText(null);
								alert.getDialogPane().setContentText("确认删除？");
								alert.showAndWait().filter(response -> response == ButtonType.OK)
									.ifPresent(response -> {
										table.getItems().remove(this.getTableRow().getIndex());
									});
							});
							item.getChildren().addAll(modefyButton, delButton);
						} else
							item = null;
						setGraphic(item);
					}
				};
			}
			
		});
		
		table.getColumns().setAll(name, stuff, stuffNumber, operation); 
		
		table.getItems().add(new HotelVO("1","123","456","456", "456"));
		table.getItems().add(new HotelVO("2","dfdf","aaa","vvv", "c"));
		table.getItems().add(new HotelVO("4","d2fdf","a1aa","v3vv", "c"));
		
		
		getChildren().addAll(v, table);
	}
}
