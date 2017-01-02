package ui.customer;

import java.util.Arrays;
import java.util.List;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import ui.webAdmin.BackButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CreditRecordPane extends Pane{
	
	private GridPane pane;
	private CreditTable credit;
	private BackButton back;
	
	public CreditRecordPane(Pane lastPane){
		super();
		back = new BackButton(lastPane);
		initPane();
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER);
		//pane.setGridLinesVisible(true);
		credit=new CreditTable(CustomerPaneController.getInstance().getcredit());
		
		pane.add(back, 0, 0);
		pane.add(credit,2,5);
		this.getChildren().add(pane);
	}
}
