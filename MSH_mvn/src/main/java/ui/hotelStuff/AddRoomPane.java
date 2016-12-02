package ui.hotelStuff;

import java.util.Iterator;

import javafx.geometry.HPos;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import tools.BedStyle;
import ui.hotelStuff.subgroup.RoomListTable;
import ui.utility.MainPane;
import vo.RoomVO;

public class AddRoomPane extends VBox{

	private GridPane textPane;
	private Label styleLab,bedLab,maxLab,numLab,priceLab;
	private TextField styleText,numText,priceText;
	private ChoiceBox<String> bedBox;
	private ChoiceBox<Integer> maxBox;
	private RoomListTable table;
	
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
		textPane = new GridPane();
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
        
        styleLab = new Label("客房类型：");
        GridPane.setHalignment(styleLab, HPos.RIGHT);
        textPane.add(styleLab, 0, 0);
        
        styleText = new TextField();
        GridPane.setHalignment(styleText, HPos.CENTER);
        textPane.add(styleText, 1, 0, 3, 1);
        
        bedLab = new Label("床型：");
        GridPane.setHalignment(bedLab, HPos.RIGHT);
        textPane.add(bedLab, 4, 0);
        
        bedBox = new ChoiceBox<>();
        bedBox.getItems().addAll("大床","双床","上下铺");
        bedBox.setMinWidth(75);
        GridPane.setHalignment(bedBox, HPos.CENTER);
        textPane.add(bedBox, 5, 0);
        
        maxLab = new Label("最多可住人数：");
        GridPane.setHalignment(maxLab, HPos.RIGHT);
        textPane.add(maxLab, 0, 1);
        
        maxBox = new ChoiceBox<>();
        maxBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        GridPane.setHalignment(maxBox, HPos.CENTER);
        textPane.add(maxBox, 1, 1);
        
        numLab = new Label("客房数量：");
        GridPane.setHalignment(numLab, HPos.RIGHT);
        textPane.add(numLab, 2, 1);
        
        numText = new TextField();
        GridPane.setHalignment(numText, HPos.CENTER);
        textPane.add(numText, 3, 1);
        
        priceLab = new Label("原始价格：");
        GridPane.setHalignment(priceLab, HPos.RIGHT);
        textPane.add(priceLab, 4, 1);
        
        priceText = new TextField();
        GridPane.setHalignment(priceText, HPos.CENTER);
        textPane.add(priceText, 5, 1);
        
        Button add = new Button("添加");
        GridPane.setHalignment(add, HPos.CENTER);
        add.setOnAction(e -> {
        	boolean noStyle = this.styleText.getText().equals(null) && this.styleText.getText().equals("");
        	boolean noBed = (this.bedBox.getValue() == null);
        	boolean noMax = (this.maxBox.getValue() == null);
        	boolean noPrice = this.priceText.getText().equals(null) && this.priceText.getText().equals("");
        	boolean noNum = this.numText.getText().equals(null) && this.numText.getText().equals("");
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
				
				this.table.getItems().add(
						new RoomVO(this.styleText.getText(),bedStyle,
								Double.valueOf(this.priceText.getText()),Integer.valueOf(this.numText.getText()),
								this.maxBox.getValue()));
//				System.out.println(this.styleText.getText());
//				System.out.println(this.numText.getText());
//				System.out.println(this.priceText.getText());
//				System.out.println(this.bedBox.getValue());
//				System.out.println(this.maxBox.getValue());
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
        textPane.add(add, 6, 1);
        textPane.setGridLinesVisible(true);
        
        this.getChildren().add(textPane);
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
				alert.getDialogPane().setContentText("确认删除？");
				alert.showAndWait().filter(response -> 
					response == ButtonType.OK).ifPresent(response ->{
						//HotelPaneController.getInstance()
						System.out.println("保存");
					});
		});
		save.setStyle("-fx-font-size:20");
		
		this.setAlignment(Pos.CENTER);
		
		
		this.getChildren().addAll(table,sep,save);
		
	}
}
