package ui.hotelStuff;

import java.time.LocalDate;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyRetreatButton;

public class HotelStrategyAddPane extends GridPane{

	private static final String[] TYPE_NAME = {"节假日特惠","生日特惠","合作企业特惠","多房间特惠"};
	private static final Integer[] NUM ={2,3,4,5,6,7,8,9,10};
	private Parent lastPane;
	
	public HotelStrategyAddPane(Parent lastPane){
		super();
		this.lastPane = lastPane;
		this.init();
	}
	
	private void init(){
		this.setStyle("-fx-font-size:15;-fx-border-color:black");
		this.setVgap(10);
		
		MyRetreatButton retreat = new MyRetreatButton(lastPane);
		GridPane.setConstraints(retreat, 0, 0);
		GridPane.setMargin(retreat, new Insets(-115,0,0,-95));
		
		Label title = new Label("新的促销策略");
		title.setFont(Font.font(30));
		GridPane.setConstraints(title, 0, 1);
		
		Label typeLabel = new Label("策略类型：");
		GridPane.setConstraints(typeLabel, 0, 2);
		
		ChoiceBox<String> typeBox = new ChoiceBox<>();
		typeBox.getItems().addAll(TYPE_NAME);
//		typeBox.selectionModelProperty().addListener((listener,oldValue,newValue) -> {
//			System.out.println(newValue);
//		});
		typeBox.setMinWidth(150);
		GridPane.setConstraints(typeBox, 1, 2);
		GridPane.setHalignment(typeBox, HPos.RIGHT);
		
		
		GridPane text = new GridPane();
		text.setStyle("-fx-border-color:black");
		text.setPrefSize(400, 300);
		text.setMaxSize(GridPane.USE_PREF_SIZE, GridPane.USE_PREF_SIZE);
		text.setMinSize(GridPane.USE_PREF_SIZE, GridPane.USE_PREF_SIZE);
		GridPane.setConstraints(text, 0, 3, 2, 5);
		
		Label nameLabel = new Label("促销策略名称：");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		Label timeLabel = new Label("时间：");
		GridPane.setConstraints(timeLabel, 0, 1);
		
		Label discountLabel = new Label("折扣：");
		GridPane.setConstraints(discountLabel, 0, 2);
		
		TextField name = new TextField();
		GridPane.setConstraints(name, 1, 0, 3, 1);
		
		MyDatePicker begin = new MyDatePicker();
		begin.setValue(LocalDate.now());
		GridPane.setConstraints(begin, 1, 1);
		
		Separator sep = new Separator();
		GridPane.setConstraints(sep, 2, 1);
		
		MyDatePicker end = new MyDatePicker();
		end.setValue(LocalDate.now().plusDays(1));
		end.setBeforeDisable(begin);
		GridPane.setConstraints(end, 3, 1);
		
		TextField discount = new TextField();
		GridPane.setConstraints(discount, 1, 2);
		
		ChoiceBox<String> discountType = new ChoiceBox<>();
		discountType.getItems().addAll("元","百分比");
		GridPane.setConstraints(discountType, 3, 2);
		
		Label businessLabel = new Label("选择合作企业：");
		GridPane.setConstraints(businessLabel, 0, 3);
		
		TextField business = new TextField();
		GridPane.setConstraints(business, 1, 3);
		
		Label roomStyleLabel = new Label("选择特惠房型：");
		GridPane.setConstraints(roomStyleLabel, 0, 3);
		
		Label roomNumLabel = new Label("特惠要求数量：");
		GridPane.setConstraints(roomNumLabel, 0, 4);
		
		ChoiceBox<String> roomStyle = new ChoiceBox<>();
		GridPane.setConstraints(roomStyle, 1, 3);
		
		ChoiceBox<Integer> num = new ChoiceBox<>();
		num.getItems().addAll(NUM);
		num.getSelectionModel().select(0);
		GridPane.setConstraints(num, 1, 4);
		
		final Node[] birthOrFestival = {nameLabel,timeLabel,discountLabel,
				name,begin,sep,end,discount,discountType};
		final Node[] enterprise = {nameLabel,timeLabel,discountLabel,
				name,begin,sep,end,discount,discountType,businessLabel,business};
		final Node[] moreRooms = {nameLabel,timeLabel,discountLabel,
				name,begin,sep,end,discount,discountType,roomStyleLabel,roomNumLabel,roomStyle,num};
		
		typeBox.setOnAction(e -> {
			if(text.getChildren().size() > 0)
				text.getChildren().remove(0, text.getChildren().size());
			switch(typeBox.getValue()){
			case "生日特惠":
			case "节假日特惠":
				text.getChildren().addAll(birthOrFestival);
				break;
				
			case "多房间特惠":
				text.getChildren().addAll(moreRooms);
				break;
				
			case "合作企业特惠":
				text.getChildren().addAll(enterprise);
				break;
			}
		});
		typeBox.getSelectionModel().select(0);
		
		
		Button add = new Button("添加");
		add.setFont(Font.font(20));
		add.setOnAction(e -> {
			
		});
		GridPane.setConstraints(add, 1, 8);
		GridPane.setHalignment(add, HPos.RIGHT);
		
		this.setGridLinesVisible(false);
		this.setPadding(new Insets(100,100,100,100));
		this.getChildren().addAll(retreat,title,typeLabel,typeBox,text,add);
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		
	}
	
}
