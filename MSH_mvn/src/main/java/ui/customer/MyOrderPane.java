package ui.customer;

import java.util.List;

import vo.OrderVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MyOrderPane extends Pane{
	@SuppressWarnings("unused")
	private List<OrderVO> list;
	private GridPane pane;
	private MyOrderTable order;
	
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
