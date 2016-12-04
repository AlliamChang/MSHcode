package ui.customer;

import java.util.Arrays;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HotelConcreteInfoPane extends Pane{
	private Label hotel_name=new Label("酒店名称:");
	private Label address=new Label("地址:");
	private Label trade_area=new Label("商圈:");
	private Label lowest_price=new Label("最低价格:");
	private Label score=new Label("评分:");
	private Label evaluate_area=new Label("评价区");
	private Label star_level=new Label("星级:");
	private TableView room_info;
	private int column=0;
	private int row=1;
	private GridPane pane;
	private ScrollPane sp;
	private static final String user_name="angel"; 
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	public HotelConcreteInfoPane(){
		super();
		initPane();
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setPrefWidth(600);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		
		 ColumnConstraints col0 = new ColumnConstraints(100);
		 ColumnConstraints col1 = new ColumnConstraints(100);
		 ColumnConstraints col2 = new ColumnConstraints(130);
		 ColumnConstraints col3 = new ColumnConstraints(130);
		 this.pane.getColumnConstraints().addAll(col0,col1,col2,col3);
		//pane.setGridLinesVisible(true);
		
		room_info=new HotelRoomTable(CustomerPaneController.getInstance().getRoom("1"));
		pane.add(room_info, column, 4);
		
		hotel_name.setFont(f);
		pane.add(hotel_name,column,row);
		
		Text name=new Text("渡口客栈");
		name.setFont(f);
		pane.add(name, column+1, row);
		
		address.setFont(f);
		pane.add(address,column+2,row);
		
		Text add=new Text("南京市中山北路10号");
		pane.add(add, column+3, row);
		
		lowest_price.setFont(f);
		pane.add(lowest_price, column, row+1);
		
		Text Price=new Text("456");
		pane.add(Price, column+1, row+1);
		
		trade_area.setFont(f);
		pane.add(trade_area,column+2,row+1);
		
		Text TradeArea=new Text("新街口");
		pane.add(TradeArea,column+3,row+1);
		
		score.setFont(f);
		pane.add(score,column,row+2);
		
		Text Score=new Text("4.6");
		Score.setFont(f);
		pane.add(Score, column+1, row+2);
		
		star_level.setFont(f);
		pane.add(star_level, column+2, row+2);
		
		Text star=new Text("4");
		star.setFont(f);
		pane.add(star, column+3, row+2);
		
		evaluate_area.setFont(f);
		pane.add(evaluate_area, column, row+4);
		pane.setHalignment(trade_area, HPos.RIGHT);
		pane.setHalignment(address, HPos.RIGHT);
		pane.setHalignment(star_level,HPos.RIGHT);
		pane.setHalignment(score,HPos.RIGHT);
		pane.setHalignment(hotel_name,HPos.RIGHT);
		pane.setHalignment(lowest_price,HPos.RIGHT);
		this.getChildren().add(pane);

	}
}
