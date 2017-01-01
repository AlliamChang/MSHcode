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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
import ui.utility.MyRetreatButton;
import vo.HotelInfoVO;
import vo.RoomVO;

public class HotelListPane extends Pane{
	private static HotelListPane instance;
	private GridPane pane;
	private Button search;
	private ChoiceBox<String> P;
	private ChoiceBox<String> city;
	private ChoiceBox<String> TradeArea;
	private ChoiceBox<String> price;
	private ChoiceBox<String> score;
	private ChoiceBox<String> star_level;
	private MyDatePicker enter;
	private MyDatePicker out;
	private TextField key;
	private MyRetreatButton ret=new MyRetreatButton(HotelSearchPane.getInstance());
	private Label province=new Label("省份");
	private Label City=new Label("城市");
	private Label trade_area=new Label("商圈");
	private Label enter_time=new Label("入住时间");
	private Label out_time=new Label("退房时间");
	private Label price_range=new Label("价格区间");
	private Label score_range=new Label("评分区间");
	private Label star=new Label("星级");
	//private Label HotelName=new Label("酒店名称");
	private int column=0;
	private int row=1;
	private static final String user_name="angel"; 
	private static ScrollPane sp;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	private HotelBLService hotel=new HotelBL();
	public HotelListPane(){
		super();
	}
	
	public static HotelListPane getInstance(){
		if(instance==null){
			instance=new HotelListPane();
			instance.initPane();
		}
		return instance;
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 0, 10, 0));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		
		 ColumnConstraints col0 = new ColumnConstraints(130);
		 ColumnConstraints col1 = new ColumnConstraints(100);
		 ColumnConstraints col2 = new ColumnConstraints(100);
		 ColumnConstraints col3 = new ColumnConstraints(130);
		 ColumnConstraints col4 = new ColumnConstraints(100);
		 this.pane.getColumnConstraints().addAll(col0,col1,col2,col3,col4);
		
		 pane.add(ret, 0, 0);
		 province.setFont(f);
		 pane.add(province, column, row);
		 
		  P=new ChoiceBox<String>();
		  P.setPrefWidth(100);
	        P.getItems().addAll(CustomerPaneController.getInstance().getProvince());
			pane.add(P, column, row+1);
			
		 City.setFont(f);
		pane.add(City, column+1, row);
		
		 city=new ChoiceBox<String>();
		 city.setPrefWidth(100);
		pane.add(city,column+1,row+1);
		
		trade_area.setFont(f);
		pane.add(trade_area,column+2,row);
		
		 TradeArea=new ChoiceBox<String>();
		 TradeArea.setPrefWidth(100);
		pane.add(TradeArea, column+2, row+1);
		
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
		
		enter_time.setFont(f);
		pane.add(enter_time,column+3,row);
		
		 enter=new MyDatePicker();
		enter.setMaxWidth(130);
		pane.add(enter,column+3,row+1);
		
		out_time.setFont(f);
		pane.add(out_time, column, row+3);
		
		 out=new MyDatePicker();
		out.setMaxWidth(130);
		out.setBeforeDisable(enter);
		pane.add(out,column,row+4);
		
		price_range.setFont(f);
		pane.add(price_range,column+1,row+3);
		
		 price=new ChoiceBox(FXCollections.observableArrayList("200-499","500-999","1000以上"));
		 price.setPrefWidth(100);
		price.getSelectionModel().selectFirst();
		pane.add(price, column+1, row+4);
		
		score_range.setFont(f);
		pane.add(score_range,column+2,row+3);
		
		 score=new ChoiceBox(FXCollections.observableArrayList("4.1-5.0","3.1-4.0","0.1-3.0"));
		 score.setPrefWidth(100);
		score.getSelectionModel().selectFirst();
		pane.add(score, column+2, row+4);
		
		star.setFont(f);
		pane.add(star,column+3,row+3);
		
		 star_level=new ChoiceBox(FXCollections.observableArrayList("5","4","3","2","1"));
		 star_level.setPrefWidth(100);
		star_level.getSelectionModel().selectFirst();
		pane.add(star_level,column+3,row+4);
		
		 key=new TextField();
			pane.add(key,column,row+2,4,1);
			
		 search=new Button("搜索");
		search.setFont(f);
		pane.add(search,column+4,row+2);
		
		search.setOnMouseClicked((MouseEvent e)->{
			List<HotelInfoVO> ret=hotel.search(P.getValue(), city.getValue(),TradeArea.getValue(), key.getText(), null, null, price.getValue(), score.getValue(), -1);
			sp=HotelListPane.this.getSPane(ret);
			instance.getChildren().remove(pane);
			instance.initPane();
		});
		
		pane.setHalignment(City, HPos.CENTER);
		pane.setHalignment(trade_area, HPos.CENTER);
		pane.setHalignment(enter_time, HPos.CENTER);
		pane.setHalignment(out_time, HPos.CENTER);
		pane.setHalignment(price_range, HPos.CENTER);
		pane.setHalignment(score_range, HPos.CENTER);
		pane.setHalignment(star, HPos.CENTER);
		pane.setHalignment(star_level, HPos.CENTER);
		
		pane.add(sp, column, row+5);
		instance.getChildren().addAll(pane);
		
	}
	
	public static void setList(ScrollPane  info){
		sp=info;
	}
	
	
	private ScrollPane getSPane(List<HotelInfoVO> list2){
		VBox vb=new VBox();
		HBox hb=new HBox();
		 ToggleButton tb1 = new ToggleButton("评分");
		 ToggleButton tb2 = new ToggleButton("价格");
		 ToggleButton tb3= new ToggleButton("星级");
		 ToggleButton tb4= new ToggleButton("历史酒店");
		 hb.getChildren().addAll(tb1,tb2,tb3,tb4);
		ScrollPane sp=new ScrollPane(vb);
		sp.setPrefSize(520,400);
		vb.setMinWidth(510);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);
		HotelBLService hotel=new HotelBL();
		vb.getChildren().add(hb);
		/*System.out.println(HotelSearchPane.this.P.getValue());
		System.out.println(HotelSearchPane.this.city.getValue());
		System.out.println(HotelSearchPane.this.TradeArea.getValue());
		System.out.println(HotelSearchPane.this.keyword.getText());
		System.out.println(HotelSearchPane.this.enter.getValue());
		System.out.println(HotelSearchPane.this.out.getValue());
		System.out.println(hotel.search(HotelSearchPane.this.P.getValue(), HotelSearchPane.this.city.getValue(), 
				HotelSearchPane.this.TradeArea.getValue(), HotelSearchPane.this.keyword.getText(),
				null, null, null, null, -1));*/
		vb.getChildren().addAll(Cont.makeList(
				list2));
		sp.setMinWidth(648);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		return sp;
	}
}
	 class Cont extends GridPane{
		Label name;
		Label score;
		Label lowest_price;
		List<RoomVO> list;
		Image image; 
		Button bn=new Button("查看");
		HotelRoomTable table;
		Cont(HotelInfoVO vo){
			super();
			 ColumnConstraints colInfo = new ColumnConstraints();
		        colInfo.setPercentWidth(20);
		        for(int i=0;i<5;i++){
		        	this.getColumnConstraints().add(colInfo);
		        }
		        HotelBLService stub=new HotelBLService_Stub();
			name=new Label(vo.getHotel());
			score=new Label(vo.getScore()+"");
			lowest_price=new Label("¥"+vo.getLowest_price()+"起");
			this.image=vo.getScul();
			this.list=stub.getRoom(1);
			 table=new HotelRoomTable(list);
			 ImageView im=new ImageView(image);
			 im.setFitHeight(50);
			 im.setFitWidth(50);
			/* bn.setOnMouseClicked((MouseEvent me)->{
				 MainPane.getInstance().setRightPane(new HotelConcreteInfoPane());
			 });*/
			this.add(im, 0, 0);
			this.add(name,1,0);
			this.add(bn, 2, 0);
			this.add(score,3,0);
			this.add(lowest_price, 4, 0);
			this.add(table,0,1,5,1);
			
		}
		static List<Cont> makeList(List<HotelInfoVO> list2){
			ArrayList<Cont> ret = new ArrayList<Cont>();
			for(HotelInfoVO item:list2)
				ret.add(new Cont(item));
			return ret;
		}
	

}
