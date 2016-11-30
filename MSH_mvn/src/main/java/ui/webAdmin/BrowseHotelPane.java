package ui.webAdmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import vo.HotelVO;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class BrowseHotelPane extends VBox{
	private Label nameLabel, cityLabel, areaLabel;
	private Button addButton, filterButton;
	private TextField textField;
	private HBox h1, h2;
	private VBox v;
	private ChoiceBox<String> provinceChoiceBox, cityChoiceBox, areaChoiceBox;
	private TableView table;
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
		name.setMinWidth(80);
		TableColumn<HotelVO, String> stuff = new TableColumn<HotelVO, String>("工作人员");
		stuff.setCellValueFactory(new PropertyValueFactory<HotelVO, String>("stuff"));
		stuff.setMinWidth(80);
		TableColumn<HotelVO, String> stuffNumber = new TableColumn<HotelVO, String>("工作人员电话");
		stuffNumber.setCellValueFactory(new PropertyValueFactory<HotelVO, String>("number"));
		stuffNumber.setMinWidth(435);
		table.getColumns().setAll(name, stuff, stuffNumber);
		
		
		
		
		getChildren().addAll(v, table);
	}
}
