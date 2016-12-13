package ui.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bl_stub.HotelBLService_Stub;
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
import vo.RoomVO;

public class HotelSearchPane extends Pane{
	private static final String user_name="angel"; 
	private GridPane pane;
	private int row=10;
	private int column=0;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);
	
	public HotelSearchPane(){
		super();
		initPane();
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 0));
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		
		Label title=new Label("酒店预订系统");
		title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 32));
		pane.add(title,column+1,row-3,3,2);
		pane.setHalignment(title, HPos.CENTER);
		
		 ColumnConstraints colInfo = new ColumnConstraints();
	        colInfo.setPercentWidth(20);
	        
	        for(int i = 0; i < 100/colInfo.getPercentWidth(); i ++){
	        	this.pane.getColumnConstraints().add(colInfo);
	        }
	        
		Label City=new Label("城市:");
		City.setFont(f);
		pane.add(City,column,row);
		pane.setHalignment(City, HPos.RIGHT);
		
		ChoiceBox city=new ChoiceBox(FXCollections.observableArrayList("南京","北京","上海"));
		city.getSelectionModel().selectFirst();
		pane.add(city,column+1,row);
		
		Label trade_area=new Label("商圈:");
		trade_area.setFont(f);
		pane.add(trade_area,column+2,row);
		pane.setHalignment(trade_area, HPos.RIGHT);
		
		ChoiceBox TradeArea=new ChoiceBox(FXCollections.observableArrayList("栖霞区","鼓楼区","江宁区"));
		TradeArea.getSelectionModel().selectFirst();
		pane.add(TradeArea,column+3,row);
		
		Label key=new Label("关键词:");
		key.setFont(f);
		pane.add(key,column,row+1);
		pane.setHalignment(key, HPos.RIGHT);
		
		TextField keyword=new TextField();
		keyword.setFont(f);
		keyword.setMinWidth(200);
		pane.add(keyword, column+1, row+1,3,1);
		
		Button search=new Button("搜索");
		search.setFont(f);
		search.setOnMouseClicked((MouseEvent me)->{
			HotelListPane next=new HotelListPane(this.getSPane());
			MainPane.getInstance().setRightPane(next);
		});
		pane.add(search,column+4,row+1);
		
		Label enter_time=new Label("入住时间:");
		enter_time.setFont(f);
		pane.add(enter_time, column, row+2);
		pane.setHalignment(enter_time, HPos.RIGHT);
		
		DatePicker enter=new MyDatePicker();
		enter.setMaxWidth(140);
		pane.add(enter, column+1, row+2);
		
		Label out_time=new Label("退房时间:");
		out_time.setFont(f);
		pane.add(out_time,column+2,row+2);
		pane.setHalignment(out_time, HPos.RIGHT);
		
		DatePicker out=new MyDatePicker();
		out.setMaxWidth(140);
		pane.add(out,column+3,row+2);
		
		this.getChildren().add(pane);
	}
	
	private ScrollPane getSPane(){
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
		HotelBLService_Stub stub=new HotelBLService_Stub();
		vb.getChildren().add(hb);
		vb.getChildren().addAll(content.makeList(stub.search("南京市", "鼓楼区")));
		sp.setMinWidth(648);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		return sp;
	}
}
	 class content extends GridPane{
		Label name;
		Label score;
		Label lowest_price;
		List<RoomVO> list;
		Image image; 
		Button bn=new Button("查看");
		HotelRoomTable table;
		content(String hotel_name){
			super();
			 ColumnConstraints colInfo = new ColumnConstraints();
		        colInfo.setPercentWidth(20);
		        for(int i=0;i<5;i++){
		        	this.getColumnConstraints().add(colInfo);
		        }
			name=new Label(hotel_name);
			HotelBLService_Stub stub=new HotelBLService_Stub();
			score=new Label(stub.getHotel(hotel_name).getScore()+"");
			lowest_price=new Label("¥"+"500"+"起");
			this.image=stub.getHotel(hotel_name).getScul();
			this.list=stub.getRoom(1);
			 table=new HotelRoomTable(list);
			 ImageView im=new ImageView(image);
			 bn.setOnMouseClicked((MouseEvent me)->{
				 MainPane.getInstance().setRightPane(new HotelConcreteInfoPane());
			 });
			this.add(im, 0, 0);
			this.add(name,1,0);
			this.add(bn, 2, 0);
			this.add(score,3,0);
			this.add(lowest_price, 4, 0);
			this.add(table,0,1,5,1);
			
		}
		static List<content> makeList(List<String> hotel_name){
			ArrayList<content> ret = new ArrayList<content>();
			for(String item:hotel_name)
				ret.add(new content(item));
			return ret;
		}
	}
	

