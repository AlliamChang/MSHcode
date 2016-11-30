package ui.hotelStuff;

import java.util.Iterator;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import ui.hotelStuff.subgroup.RoomListTable;
import ui.utility.MainPane;
import vo.RoomVO;

public class AddRoomPane extends VBox{

	
	public AddRoomPane(Iterator<RoomVO> roomList){
		super(5);
		initText();
		initTab(roomList);
		init();
	}
	
	private void init(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setStyle("-fx-background-color:white;-fx-border-color:black;-fx-font-size:14;");
	}
	
	private void initText(){
		GridPane textPane = new GridPane();
		textPane.setMinHeight(MainPane.MINHEIGHT * 0.15);
		textPane.setMaxHeight(MainPane.MINHEIGHT * 0.15);
        RowConstraints rowinfo = new RowConstraints();
        rowinfo.setPercentHeight(50);
        textPane.getRowConstraints().addAll(rowinfo,rowinfo);
        
        ColumnConstraints colInfo1 = new ColumnConstraints();
        colInfo1.setPercentWidth(15);
        ColumnConstraints colInfo2 = new ColumnConstraints();
        colInfo2.setPercentWidth(10);
        for(int i = 0; i < 5; i ++){
        	textPane.getColumnConstraints().add(colInfo1);
        }
        textPane.getColumnConstraints().add(colInfo2);
        
        Label styleLab = new Label("客房类型：");
        GridPane.setHalignment(styleLab, HPos.RIGHT);
        textPane.add(styleLab, 0, 0);
        
        TextField styleText = new TextField();
        GridPane.setHalignment(styleText, HPos.CENTER);
        textPane.add(styleText, 1, 0, 3, 1);
        
        Label bedLab = new Label("床型：");
        GridPane.setHalignment(bedLab, HPos.RIGHT);
        textPane.add(bedLab, 4, 0);
        
        ChoiceBox bedBox = new ChoiceBox();
        GridPane.setHalignment(bedBox, HPos.CENTER);
        textPane.add(bedBox, 5, 0);
        
        Label maxLab = new Label("最多可住人数：");
        GridPane.setHalignment(maxLab, HPos.RIGHT);
        textPane.add(maxLab, 0, 1);
        
        ChoiceBox maxBox = new ChoiceBox();
        GridPane.setHalignment(maxBox, HPos.CENTER);
        textPane.add(maxBox, 1, 1);
        
        Label numLab = new Label("客房数量：");
        GridPane.setHalignment(numLab, HPos.RIGHT);
        textPane.add(numLab, 2, 1);
        
        TextField numText = new TextField();
        GridPane.setHalignment(numText, HPos.CENTER);
        textPane.add(numText, 3, 1);
        
        Label priceLab = new Label("原始价格：");
        GridPane.setHalignment(priceLab, HPos.RIGHT);
        textPane.add(priceLab, 4, 1);
        
        TextField priceText = new TextField();
        GridPane.setHalignment(priceText, HPos.CENTER);
        textPane.add(priceText, 5, 1);
        
        Button add = new Button("添加");
        GridPane.setHalignment(add, HPos.CENTER);
        textPane.add(add, 6, 1);
        
        this.getChildren().add(textPane);
	}
	
	private void initTab(Iterator<RoomVO> roomList){
		
		RoomListTable table = new RoomListTable(roomList);
		
		Button save = new Button("保存");
		this.setAlignment(Pos.CENTER);
		
		
		this.getChildren().addAll(table,save);
		
	}
}
