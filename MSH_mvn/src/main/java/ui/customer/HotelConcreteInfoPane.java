package ui.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bl_stub.HotelBLService_Stub;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HotelConcreteInfoPane extends Pane{
	private HotelInfoVO vo;
	private Image hotel;
	private Label hotel_name=new Label("酒店名称:");
	private Label address=new Label("地址:");
	private Label trade_area=new Label("商圈:");
	private Label lowest_price=new Label("最低价格:");
	private Label score=new Label("评分:");
	//private Label evaluate_area=new Label("评价区");
	private Label star_level=new Label("星级:");
	private TableView room_info;
	private int column=0;
	private int row=0;
	private GridPane pane;
	private List<OrderVO> list;
	//private ScrollPane sp;
	private ScrollPane evaluate;
	private static final String user_name="angel"; 
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	public HotelConcreteInfoPane(HotelInfoVO VO){
		super();
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		vo=VO;
		initPane();
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setPrefWidth(600);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		 ColumnConstraints col=new ColumnConstraints(50);
		 ColumnConstraints col0 = new ColumnConstraints(100);
		 ColumnConstraints col1 = new ColumnConstraints(100);
		 ColumnConstraints col2 = new ColumnConstraints(130);
		 ColumnConstraints col3 = new ColumnConstraints(130);
		 this.pane.getColumnConstraints().addAll(col,col0,col1,col2,col3);
		//pane.setGridLinesVisible(true);
		VBox vb=new VBox();
		vb.setMinWidth(600);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);
		HotelBLService_Stub stub=new HotelBLService_Stub();
		vb.getChildren().addAll(Evaluate.getEvaluate(stub.getEvaluate(1)));
		evaluate=new ScrollPane(vb);
		evaluate.setMinWidth(605);
		evaluate.setPrefSize(600,400);
		pane.add(evaluate,column,5,5,1);
		
		hotel=vo.getScul();
		ImageView image=new ImageView(hotel);
		image.setFitHeight(100);
		image.setFitWidth(100);
		pane.add(image, column, 0,1,2);
		
		
		room_info=new HotelRoomTable(CustomerPaneController.getInstance().getRoom(1));
		pane.add(room_info, column, 4);
		
		hotel_name.setFont(f);
		pane.add(hotel_name,column+1,row);
		
		Text name=new Text(vo.getHotel());
		name.setFont(f);
		pane.add(name, column+2, row);
		
		address.setFont(f);
		pane.add(address,column+3,row);
		
		Text add=new Text(vo.getAdress());
		pane.add(add, column+4, row);
		
		lowest_price.setFont(f);
		pane.add(lowest_price, column+1, row+1);
		
		Text Price=new Text(vo.getLowest_price()+"");
		pane.add(Price, column+2, row+1);
		
		trade_area.setFont(f);
		pane.add(trade_area,column+3,row+1);
		
		Text TradeArea=new Text(vo.getTradingArea());
		pane.add(TradeArea,column+4,row+1);
		
		score.setFont(f);
		pane.add(score,column+1,row+2);
		
		Text Score=new Text(vo.getScore()+"");
		Score.setFont(f);
		pane.add(Score, column+2, row+2);
		
		star_level.setFont(f);
		pane.add(star_level, column+3, row+2);
		
		Text star=new Text(vo.getStar()+"");
		star.setFont(f);
		pane.add(star, column+4, row+2);
		
		/*evaluate_area.setFont(f);
		pane.add(evaluate_area, column, row+4);*/
		pane.setHalignment(trade_area, HPos.RIGHT);
		pane.setHalignment(address, HPos.RIGHT);
		pane.setHalignment(star_level,HPos.RIGHT);
		pane.setHalignment(score,HPos.RIGHT);
		pane.setHalignment(hotel_name,HPos.RIGHT);
		pane.setHalignment(lowest_price,HPos.RIGHT);
		this.getChildren().add(pane);

	}
}

class Evaluate extends GridPane{
	Evaluate(EvaluateVO ev){
		super();
		setStyle("-fx-border-color: gray");
		setPadding(new Insets(5, 5, 5, 5));
		setHgap(10);
		setVgap(10);
	    ColumnConstraints colInfo1 = new ColumnConstraints();
	    colInfo1.setPercentWidth(50);
	    ColumnConstraints colInfo2 = new ColumnConstraints();
	    colInfo2.setPercentWidth(20);
	    ColumnConstraints colInfo3 = new ColumnConstraints();
	    colInfo3.setPercentWidth(30);
		Text score=new Text(ev.getScore()+"");
		TextArea content=new TextArea(ev.getContent());
		content.setEditable(false);
		content.setMaxWidth(370);
		content.setMaxHeight(50);
		Text name=new Text(ev.getId()+"");
		Text time=new Text(ev.getDate());
		this.add(score, 0, 0);
		this.add(content, 0, 1);
		this.add(name, 1, 1);
		this.add(time, 2, 1);
	}
	
	static List<Evaluate> getEvaluate(List<EvaluateVO> list){
		ArrayList<Evaluate> eva=new ArrayList<Evaluate>();
		for(EvaluateVO item:list)
			eva.add(new Evaluate(item));
		return eva;
	}
}
