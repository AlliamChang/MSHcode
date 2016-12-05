package ui.webAdmin;

import java.util.List;

import ui.utility.MainPane;
import vo.HotelInfoVO;
import vo.UserVO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.util.Callback;

public class BrowseHotelPane extends VBox{
	private Label nameLabel, cityLabel, areaLabel;
	private Button addButton, filterButton;
	private TextField textField;
	private HBox h1, h2;
	private VBox v;
	private ChoiceBox<String> provinceChoiceBox, cityChoiceBox, areaChoiceBox;
	private TableView<HotelInfoVO> table;
	private Separator sprt;
	
	public BrowseHotelPane(){
		super();
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
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
		
		table = new TableView<HotelInfoVO>();
		TableColumn<HotelInfoVO, String> name = new TableColumn<HotelInfoVO, String>("酒店名称");
		name.setCellValueFactory(new PropertyValueFactory<HotelInfoVO, String>("hotel"));
		name.setPrefWidth(210);
		TableColumn<HotelInfoVO, String> number = new TableColumn<HotelInfoVO, String>("联系电话");
		number.setCellValueFactory(new PropertyValueFactory<HotelInfoVO, String>("phone"));
		number.setPrefWidth(100);
		number.setSortable(false);
		TableColumn<HotelInfoVO, String> staff = new TableColumn<HotelInfoVO, String>("工作人员ID");
		staff.setCellValueFactory(new PropertyValueFactory<HotelInfoVO, String>("stuff_id"){
			public ObservableValue<String> call(CellDataFeatures<HotelInfoVO, String> hotel){
				return new ReadOnlyObjectWrapper<String>(String.format("%08d", hotel.getValue().get_stuff_id()));
			}
		});
		staff.setPrefWidth(90);
		staff.setSortable(false);
		TableColumn<HotelInfoVO, HBox> operation = new TableColumn<HotelInfoVO, HBox>("");
		operation.setPrefWidth(183);
		operation.setSortable(false);
		operation.setCellFactory(new Callback<TableColumn<HotelInfoVO, HBox>, TableCell<HotelInfoVO, HBox> >(){

			@Override
			public TableCell<HotelInfoVO, HBox> call(TableColumn<HotelInfoVO, HBox> col) {
				return new TableCell<HotelInfoVO, HBox>(){
					
					@Override
					protected void updateItem(HBox item, boolean empty){
						if (!empty){
							item = new HBox();
							item.setSpacing(5);
							Button modifyButton = new Button("查看工作人员");
							Button delButton = new Button("删除酒店");
							modifyButton.setPadding(new Insets(2, 5, 2, 5));
							delButton.setPadding(new Insets(2, 5, 2, 5));
							
							modifyButton.setOnAction(e -> {
								UserVO temp = WebAdminController.getInstance()
										.getUser(table.getItems().get(this.getTableRow().getIndex()).get_stuff_id());
								WebAdminController.getInstance().setUserInfoPane(temp, BrowseHotelPane.this);
							});
							
							delButton.setOnAction(e -> {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.getDialogPane().setHeaderText(null);
								alert.getDialogPane().setContentText("确认删除？");
								alert.showAndWait().filter(response -> response == ButtonType.OK)
									.ifPresent(response -> {
										WebAdminController.getInstance().delHotel(table.getItems().get(this.getTableRow().getIndex()));
										table.getItems().remove(this.getTableRow().getIndex());
									});
							});
							item.getChildren().addAll(modifyButton, delButton);
						} else
							item = null;
						setGraphic(item);
					}
				};
			}
			
		});
		
		table.getColumns().setAll(name, number, staff, operation); 
		table.setPlaceholder(new Text("请补充条件并点击筛选。"){{setStyle("-fx-fill: gray");}});
		
		getChildren().addAll(v, table);
		
		addButton.setOnAction(e -> WebAdminController.getInstance().setAddHotelPane());
		
		filterButton.setOnAction(e -> {
			table.getItems().clear();
			table.getItems().addAll(WebAdminController.getInstance()
					.filterHotel(provinceChoiceBox.getValue(), cityChoiceBox.getValue(), areaChoiceBox.getValue(), textField.getText()));
		});
	}
}
