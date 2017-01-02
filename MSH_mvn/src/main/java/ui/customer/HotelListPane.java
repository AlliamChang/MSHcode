package ui.customer;

import java.util.ArrayList;
import java.util.List;

import bl.hotel.HotelBLServiceImpl;
import blservice.hotel.HotelBLService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyRetreatButton;
import vo.HotelInfoVO;
import vo.RoomVO;

public class HotelListPane extends Pane{
	//private static HotelListPane instance;
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
	private ScrollPane sp;
	private HotelBLService hotel=new HotelBLServiceImpl();
	private List<HotelInfoVO> result;
	public HotelListPane(String pro, String city, String area, String name){
		super();
		initPane(pro, city, area, name);
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	private void initPane(String p, String c, String a, String n){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 0, 10, 0));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		result = hotel.search(p, c, a, n, null, null, null, null, -1);
		 ColumnConstraints col0 = new ColumnConstraints(130);
		 ColumnConstraints col1 = new ColumnConstraints(100);
		 ColumnConstraints col2 = new ColumnConstraints(100);
		 ColumnConstraints col3 = new ColumnConstraints(130);
		 ColumnConstraints col4 = new ColumnConstraints(100);
		 this.pane.getColumnConstraints().addAll(col0,col1,col2,col3,col4);
		
		 pane.add(ret, 0, 0);
		 pane.add(province, column, row);
		 
		  P=new ChoiceBox<String>();
		  P.setPrefWidth(100);
	        P.getItems().addAll(CustomerPaneController.getInstance().getProvince());
			pane.add(P, column, row+1);
			
		pane.add(City, column+1, row);
		
		 city=new ChoiceBox<String>();
		 city.setPrefWidth(100);
		pane.add(city,column+1,row+1);
		
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
		P.getSelectionModel().select(p);
		city.getSelectionModel().select(c);;
		if (city.getItems().isEmpty())
			TradeArea.getItems().addAll(CustomerPaneController.getInstance().getareas(P.getValue(),null));
		TradeArea.getSelectionModel().select(a);
		
		pane.add(enter_time,column+3,row);
		
		 enter=new MyDatePicker();
		enter.setMaxWidth(130);
		pane.add(enter,column+3,row+1);
		
		pane.add(out_time, column, row+3);
		
		 out=new MyDatePicker();
		out.setMaxWidth(130);
		out.setBeforeDisable(enter);
		pane.add(out,column,row+4);
		
		pane.add(price_range,column+1,row+3);
		
		 price=new ChoiceBox(FXCollections.observableArrayList("0-499","500-999","1000-2000","无"));
		 price.setPrefWidth(100);
		price.getSelectionModel().selectLast();
		pane.add(price, column+1, row+4);
		
		pane.add(score_range,column+2,row+3);
		
		 score=new ChoiceBox(FXCollections.observableArrayList("4.1-5.0","3.1-4.0","0.0-3.0","无"));
		 score.setPrefWidth(100);
		score.getSelectionModel().selectLast();
		pane.add(score, column+2, row+4);
		
		pane.add(star,column+3,row+3);
		
		 star_level=new ChoiceBox(FXCollections.observableArrayList("5","4","3","2","1","无"));
		 star_level.setPrefWidth(100);
		star_level.getSelectionModel().selectLast();
		pane.add(star_level,column+3,row+4);
		
		 key=new TextField();
			pane.add(key,column,row+2,4,1);
			
		 search=new Button("搜索");
		pane.add(search,column+4,row+2);
		
		
		
		pane.setHalignment(City, HPos.CENTER);
		pane.setHalignment(trade_area, HPos.CENTER);
		pane.setHalignment(enter_time, HPos.CENTER);
		pane.setHalignment(out_time, HPos.CENTER);
		pane.setHalignment(price_range, HPos.CENTER);
		pane.setHalignment(score_range, HPos.CENTER);
		pane.setHalignment(star, HPos.CENTER);
		pane.setHalignment(star_level, HPos.CENTER);
		
		this.getChildren().addAll(pane);
		

		HBox hb=new HBox();
		ToggleButton tb1 = new ToggleButton("评分");
		ToggleButton tb2 = new ToggleButton("价格");
		ToggleButton tb3= new ToggleButton("星级");
		//ToggleButton tb4= new ToggleButton("历史酒店");
		
		ToggleGroup group = new ToggleGroup();
		tb1.setToggleGroup(group);
		tb2.setToggleGroup(group);
		tb3.setToggleGroup(group);
		//tb4.setToggleGroup(group);
		group.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
					if (newValue == null) {
						group.selectToggle(oldValue);
					} else {
						if (sp != null)
							pane.getChildren().remove(sp);
						if (newValue.equals(tb3))
							sp = getSPane(hotel.sortByHighStar(result));
						else if(newValue.equals(tb1))
							sp=getSPane(hotel.sortByHighScore(result));
						else if(newValue.equals(tb2))
							sp=getSPane(hotel.sortByHighPrice(result));
						pane.add(sp, column, row+6);
					}
		});
		group.selectToggle(tb3);
		hb.getChildren().addAll(tb1,tb2,tb3);
		pane.add(hb, column, row+5, 4, 1);
		search.setOnAction( e->{
			
			result=hotel.search(P.getValue(), city.getValue(),TradeArea.getValue(), key.getText(), null, null,price.getValue().equals("无")? null:price.getValue(), score.getValue().equals("无")?null:score.getValue(), star_level.getValue().equals("无")?-1:Integer.parseInt(star_level.getValue()));
			tb3.fire();
		});
	}
	
	private ScrollPane getSPane(List<HotelInfoVO> list2){
		VBox vb=new VBox();
		ScrollPane sp=new ScrollPane(vb);
		sp.setMaxSize(580, 350);
		sp.setMinSize(580, 350);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);
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
				list2,HotelListPane.this));
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		return sp;
	}
	
	public Pane getPane(){
		return pane;
	}
	
	
	
	
	
}

class Cont extends GridPane{
	Label name;
	Label star;
	Label score;
	Label lowest_price;
	List<RoomVO> list;
	Image image; 
	Button bn=new Button("查看");
	HotelRoomTable table;
	
	public Cont(HotelInfoVO vo,Parent last){
		super();
		 ColumnConstraints colInfo = new ColumnConstraints();
	        colInfo.setPercentWidth(20);
	        for(int i=0;i<6;i++){
	        	this.getColumnConstraints().add(colInfo);
	        }
	        HotelBLService stub=new bl.hotel.HotelBLServiceImpl();
		name=new Label(vo.getHotel());
		star=new Label(vo.getStar()+"星");
		score=new Label(vo.getScore()+"");
		double low=0;
		this.list=stub.getRoom(vo.getHotel_id());
		if(list!=null){
		for(int i=0;i<list.size();i++){
			if(low==0)
				low=list.get(i).getPrice();
			if(low>list.get(i).getPrice())
				low=list.get(i).getPrice();
		}
		}
		vo.setLowest_price((int)low);
		stub.modify(vo);
		lowest_price=new Label("¥"+low+"起");
		this.image=vo.getScul();
		
		 table=new HotelRoomTable(list,last);
		 ImageView im=new ImageView(image);
		 im.setFitHeight(50);
		 im.setFitWidth(50);
		 bn.setOnMouseClicked((MouseEvent me)->{
			 MainPane.getInstance().setRightPane(new HotelConcreteInfoPane(last,vo));
		 });
		this.add(im, 0, 0);
		this.add(star,5,0);
		this.add(name,1,0);
		this.add(bn, 2, 0);
		this.add(score,3,0);
		this.add(lowest_price, 4, 0);
		this.add(table,0,1,5,1);
		
	}
		
	public static List<Cont> makeList(List<HotelInfoVO> list2,Parent last){
		ArrayList<Cont> ret = new ArrayList<Cont>();
		for(HotelInfoVO item:list2)
			ret.add(new Cont(item,last));
		return ret;
	}
	
	

}

