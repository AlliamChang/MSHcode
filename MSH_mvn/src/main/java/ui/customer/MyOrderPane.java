package ui.customer;

import java.util.Arrays;
import java.util.List;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.OrderVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyOrderPane extends Pane{
	private TableView table=new TableView();
	private static final String user_name="angel";
	private List<OrderVO> list;
	private GridPane pane;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);
	
	
	
	public MyOrderPane(){
		super();
		initPane();
		
	}
	
	
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER_RIGHT);
		
		TableColumn start_time=new TableColumn("开始时间");
		TableColumn check_out_time=new TableColumn("退房时间");
		TableColumn room_type=new TableColumn("房间类型");
		TableColumn number=new TableColumn("数量");
		TableColumn total=new TableColumn("总价(¥)");
		TableColumn state=new TableColumn("状态");
		TableColumn isEvaluated=new TableColumn("有无评价");
		table.getColumns().addAll(start_time,check_out_time,room_type,number,total,state,isEvaluated);
		pane.getChildren().add(table);
		this.getChildren().add(pane);
	}


}
