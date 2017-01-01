package ui.hotelStuff;

import java.util.Iterator;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import tools.BedStyle;
import ui.hotelStuff.control.HotelPaneController;
import ui.hotelStuff.subgroup.RoomListTable;
import ui.utility.MainPane;
import vo.RoomVO;

public class AddRoomPane extends VBox{

	private HBox first,second;
	private Label styleLab,bedLab,maxLab,numLab,priceLab;
	private TextField styleText,numText,priceText;
	private ChoiceBox<String> bedBox;
	private ChoiceBox<Integer> maxBox;
	private RoomListTable table;
	
	public AddRoomPane(Iterator<RoomVO> roomList){
		super(10);
		initText();
		initTab(roomList);
		init();
	}
	
	private void init(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setStyle("-fx-background-color:white;-fx-border-color:black;-fx-font-size:15;");
	}
	
	private void initText(){
		first = new HBox();
		first.setAlignment(Pos.CENTER_LEFT);
		first.setPadding(new Insets(10,0,1,40));
		first.setMinHeight(MainPane.MINHEIGHT * 0.075);
		first.setMaxHeight(MainPane.MINHEIGHT * 0.075);
		
		second = new HBox();
		second.setPadding(new Insets(1,0,10,40));
		second.setAlignment(Pos.CENTER_LEFT);
		second.setMinHeight(MainPane.MINHEIGHT * 0.075);
		second.setMaxHeight(MainPane.MINHEIGHT * 0.075);
//        RowConstraints rowinfo = new RowConstraints();
//        rowinfo.setPercentHeight(50);
//        textPane.getRowConstraints().addAll(rowinfo,rowinfo);
//        
//        ColumnConstraints colInfo1 = new ColumnConstraints();
//        colInfo1.setPercentWidth(15);
//        ColumnConstraints colInfo2 = new ColumnConstraints();
//        colInfo2.setPercentWidth(10);
//        for(int i = 0; i < 5; i ++){
//        	textPane.getColumnConstraints().add(colInfo1);
//        }
//        textPane.getColumnConstraints().add(colInfo2);
        
        styleLab = new Label("客房类型：");
        
        styleText = new TextField();
        styleText.setMinWidth(255);
        
        bedLab = new Label("床型：");
        
        bedBox = new ChoiceBox<>();
        bedBox.getItems().addAll("大床","双床","上下铺");
        bedBox.setMinWidth(90);
        
        first.getChildren().addAll(styleLab,styleText,bedLab,bedBox);
        HBox.setMargin(bedLab, new Insets(0,0,0,35));
        
        maxLab = new Label("最多可住人数：");
        
        maxBox = new ChoiceBox<>();
        maxBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        maxBox.setMinWidth(70);
        
        numLab = new Label("客房数量：");
        
        numText = new TextField();
        numText.setMaxWidth(60);
        
        priceLab = new Label("原始价格：");
        
        priceText = new TextField();
        priceText.setMaxWidth(80);
        
        Button add = new Button("添加");
        GridPane.setHalignment(add, HPos.CENTER);
        add.setOnAction(e -> {
        	boolean noStyle = this.styleText.getText().equals(null) || this.styleText.getText().equals("");
        	boolean noBed = (this.bedBox.getValue() == null);
        	boolean noMax = (this.maxBox.getValue() == null);
        	boolean noPrice = this.priceText.getText().equals(null) || this.priceText.getText().equals("");
        	boolean noNum = this.numText.getText().equals(null) || this.numText.getText().equals("");
			if(!noStyle && !noBed && !noMax && !noPrice && !noNum){
				BedStyle bedStyle;
				switch(this.bedBox.getValue()){
				case "双床":
					bedStyle = BedStyle.DOUBLE_BEDS;
					break;
					
				case "大床":
					bedStyle = BedStyle.KING_SIZE_BED;
					break;
					
				default:
					bedStyle = BedStyle.BUNK_BED;
					break;
				}
				RoomVO newRoom = new RoomVO(this.styleText.getText(),bedStyle,
						Double.valueOf(this.priceText.getText()),Integer.valueOf(this.numText.getText()),
						this.maxBox.getValue(),HotelPaneController.getInstance().getHotelId());
				this.table.getItems().add(newRoom);
				HotelPaneController.getInstance().addRoom(newRoom);
			}else{
	        	Alert alert = new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				if(noStyle)
					alert.getDialogPane().setContentText("尚未填写客房类型");
				else if(noBed)
					alert.getDialogPane().setContentText("尚未选择床型");
				else if(noMax)
					alert.getDialogPane().setContentText("尚未选择最多可住人数");
				else if(noNum)
					alert.getDialogPane().setContentText("尚未填写客房数量");
				else
					alert.getDialogPane().setContentText("尚未填写原始价格");
				alert.show();
			}
        });
        
        second.getChildren().addAll(maxLab,maxBox,numLab,numText,priceLab,priceText,add);
        HBox.setMargin(numLab, new Insets(0,0,0,20));
        HBox.setMargin(priceLab, new Insets(0,0,0,20));
        HBox.setMargin(add, new Insets(0,0,0,20));
        this.getChildren().addAll(first,second);
	}
	
	private void initTab(Iterator<RoomVO> roomList){
		
		table = new RoomListTable(roomList);
		
		Separator sep = new Separator();
		sep.setMaxWidth(MainPane.MINWIDTH - 20);
		
		Button save = new Button("保存");
		save.setOnAction(e -> {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				alert.getDialogPane().setContentText("确认要保存吗？");
				alert.showAndWait().filter(response -> 
					response == ButtonType.OK).ifPresent(response ->{
						//HotelPaneController.getInstance()
						
					});
		});
		save.setStyle("-fx-font-size:20");
		
		this.setAlignment(Pos.CENTER);
		
		
		this.getChildren().addAll(table,sep,save);
		
	}
}
