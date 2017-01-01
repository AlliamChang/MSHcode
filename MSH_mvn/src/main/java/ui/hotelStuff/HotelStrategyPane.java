package ui.hotelStuff;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import ui.hotelStuff.subgroup.StrategyTable;
import ui.utility.MainPane;
import vo.StrategyVO;

public class HotelStrategyPane extends VBox{

	List<StrategyVO> data;
	
	public HotelStrategyPane(List<StrategyVO> list){
		super(10);
		data = list;
		init();
	}
	
	private void init(){
		this.setStyle("-fx-font-size:15;-fx-border-color:black;");
		
		Label title = new Label("促销策略列表");
		title.setFont(Font.font(30));
		VBox.setMargin(title, new Insets(30,0,0,20));
		
		Separator sep = new Separator();
		sep.setMaxWidth(200);
		sep.setStyle("-fx-border-width:2;-fx-background-color:black");
		VBox.setMargin(sep, new Insets(-10,0,0,20));
		
		StrategyTable table = new StrategyTable(data.iterator());
		VBox.setMargin(table, new Insets(10,0,0,0));
		
		Separator sep2 = new Separator();
//		sep2.setMaxWidth(200);
		sep2.setStyle("-fx-border-width:2;-fx-background-color:black");
		
		Button add = new Button("添加新的策略");
		add.setFont(Font.font(17));
		add.setOnAction(e -> {
			MainPane.getInstance().setRightPane(new HotelStrategyAddPane(this));
		});
		VBox.setMargin(add, new Insets(10,0,0,260));
		
		this.getChildren().addAll(title,sep,table,sep2,add);
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
	}
}
