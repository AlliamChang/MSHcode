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
	private List<OrderVO> list;
	private GridPane pane;
	private MyOrderTable order;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);
	
	public MyOrderPane(){
		super();
		initPane();
		
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 0));
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER_RIGHT);
		
		order=new MyOrderTable(CustomerPaneController.getInstance().getOrder());
		
		pane.add(order,0,2);
		this.getChildren().add(pane);
	}


}
