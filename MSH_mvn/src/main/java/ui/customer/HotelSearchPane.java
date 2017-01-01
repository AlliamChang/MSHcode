package ui.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bl.hotel_bl.HotelBL;
import bl_stub.HotelBLService_Stub;
import blservice.hotel_blservice.HotelBLService;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;
import ui.webAdmin.WebAdminController;
import vo.HotelInfoVO;
import vo.RoomVO;

public class HotelSearchPane extends GridPane{
	private static HotelSearchPane instance;
	private ChoiceBox<String> P;
	private ChoiceBox<String> city;
	private ChoiceBox<String> TradeArea;
	private TextField keyword;
//	private int row=10;
//	private int column=2;
	
	public HotelSearchPane(){
		super();
		setStyle("-fx-border-color: black; -fx-font-size: 18px;");
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
	}
	
	public static HotelSearchPane getInstance(){
		if(instance==null){
			instance=new HotelSearchPane();
			instance.initPane();
		}
		return instance;
	}
	
	private void initPane(){
//		this.setPadding(new Insets(10, 10, 10, 0));
		this.setAlignment(Pos.CENTER);
		this.setHgap(20);
		this.setVgap(20);
		//pane.setGridLinesVisible(true);
		
		Label title=new Label("酒店预订系统");
		HBox titleBox = new HBox();
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.getChildren().add(title);
		titleBox.setMinHeight(120);
		
		title.setFont(Font.font(60));
		this.add(titleBox,0,0,6,1);
		
//		 ColumnConstraints col0 = new ColumnConstraints(50);
//		 ColumnConstraints col1 = new ColumnConstraints(120);
//		 ColumnConstraints col2 = new ColumnConstraints(80);
//		 ColumnConstraints col3 = new ColumnConstraints(120);
//		 ColumnConstraints col4 = new ColumnConstraints(50);
//		// ColumnConstraints col5 = new ColumnConstraints(50);
//		 this.getColumnConstraints().addAll(col0,col1,col2,col3,col4);
	        
	        
	        Label province=new Label("省份:");
	        this.add(province, 0, 1);
	        
	         P=new ChoiceBox<String>();
	         P.setPrefWidth(120);
	        P.getItems().addAll(CustomerPaneController.getInstance().getProvince());
			this.add(P, 1, 1);
			
			Label City=new Label("城市:");
			this.add(City, 2, 1);
			
			 city=new ChoiceBox<String>();
			city.setPrefWidth(120);
			this.add(city,3,1);
			
			Label trade_area=new Label("商圈:");
			this.add(trade_area,4,1);
			
			 TradeArea=new ChoiceBox<String>();
			 TradeArea.setPrefWidth(120);
			this.add(TradeArea,5,1);
	        
			P.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
				city.getItems().clear();
				List<String> cities = CustomerPaneController.getInstance().getCity((String)new_val);
				if (cities != null){
					city.setDisable(false);;
					city.getItems().addAll(cities);
				} else
					city.setDisable(true);
				city.getSelectionModel().selectFirst();
			});
			
			city.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
				TradeArea.getItems().clear();
				List<String> areas = CustomerPaneController.getInstance().getareas(P.getValue(), (String)new_val);
				if (areas != null){
					TradeArea.setDisable(false);
					TradeArea.getItems().addAll(areas);
				} else
					TradeArea.setDisable(true);	
				TradeArea.getSelectionModel().selectFirst();
			});
			P.getSelectionModel().selectFirst();
			city.getSelectionModel().selectFirst();
			if (city.getItems().isEmpty())
				TradeArea.getItems().addAll(CustomerPaneController.getInstance().getareas(P.getValue(),null));
			TradeArea.getSelectionModel().selectFirst();
		
		
		
		Label key=new Label("名称:");
		this.add(key,0,2);
		
		 keyword=new TextField();
		this.add(keyword, 1, 2, 4, 1);
		
		Button search=new Button("搜索");
		search.setOnMouseClicked((MouseEvent me)->{
			MainPane.getInstance().setRightPane(new HotelListPane(P.getValue(), city.getValue(), TradeArea.getValue(), keyword.getText()));
		});
		search.setPrefSize(90, 35);
		HBox searchBox = new HBox();
		searchBox.setAlignment(Pos.BOTTOM_RIGHT);
		searchBox.getChildren().add(search);
		this.add(searchBox, 5, 2);
	}
}

	

