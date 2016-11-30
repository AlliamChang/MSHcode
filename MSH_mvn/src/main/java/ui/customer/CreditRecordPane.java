package ui.customer;

import java.util.Arrays;
import java.util.List;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CreditRecordPane {
	private  TableView table;
	private List<String>list;
	private MyNavigationBar navi;
	private GridPane pane;
	private static final String user_name="angel";
	private Image scul;
	private int width=150;
	public CreditRecordPane(List<String> list){
		this.list=list;
		initPane();
		init();
	}
	
	private void init(){
		navi = new MyNavigationBar(scul,Arrays.asList("用户名："+user_name));
		MainPane.getInstance().getChildren().clear();
		MainPane.getInstance().getChildren().addAll(navi,pane);
	}
	
	private void initPane(){
		table=new TableView();
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER);
		//pane.setGridLinesVisible(true);
		
		TableColumn time=new TableColumn("时间");
		time.setMinWidth(width);
		
		TableColumn credit_change=new TableColumn("信用值变化");
		credit_change.setMinWidth(width);
		
		TableColumn change_reason=new TableColumn("原因");
		change_reason.setMinWidth(width);
		
		table.getColumns().addAll(time,credit_change,change_reason);
		pane.add(table,4,5);
		
		
		
	}
}
