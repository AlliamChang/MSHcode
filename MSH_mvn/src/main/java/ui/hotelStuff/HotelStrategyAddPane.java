package ui.hotelStuff;

import java.time.LocalDate;

import bl.strategy.StrategyBLServiceImpl;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import tools.PeopleType;
import tools.ResultMessage;
import tools.StrategyType;
import ui.hotelStuff.control.HotelPaneController;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyRetreatButton;
import vo.StrategyVO;

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
		GridPane.setMargin(retreat, new Insets(-65,0,0,-95));
		
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
        ColumnConstraints colinfo1 = new ColumnConstraints(100, 100, 100);
        ColumnConstraints colinfo2 = new ColumnConstraints(130, 130, 130);
        ColumnConstraints colinfo3 = new ColumnConstraints(15, 15, 15);
        text.getColumnConstraints().addAll(colinfo1,colinfo2,colinfo3,colinfo2);
		text.setStyle("-fx-border-color:black");
		text.setPrefSize(400, 300);
		text.setVgap(20);
		text.setPadding(new Insets(20,5,20,5));
		text.setMaxSize(GridPane.USE_PREF_SIZE, GridPane.USE_PREF_SIZE);
		text.setMinSize(GridPane.USE_PREF_SIZE, GridPane.USE_PREF_SIZE);
		GridPane.setConstraints(text, 0, 3, 2, 5);
		
		Label nameLabel = new Label("策略名称：");
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
		
		Label discountType = new Label("元");
		GridPane.setConstraints(discountType, 3, 2);
		
//		Label businessLabel = new Label("合作企业：");
//		GridPane.setConstraints(businessLabel, 0, 3);
		
//		TextField business = new TextField();
//		GridPane.setConstraints(business, 1, 3, 3, 1);
		
		Label roomStyleLabel = new Label("特惠房型：");
		GridPane.setConstraints(roomStyleLabel, 0, 3);
		
//		Label roomNumLabel = new Label("要求数量：");
//		GridPane.setConstraints(roomNumLabel, 0, 4);
		
		ChoiceBox<String> roomStyle = new ChoiceBox<>();
		roomStyle.getItems().add("所有");
		roomStyle.getItems().addAll(HotelPaneController.getInstance().getRoomStyle());
		GridPane.setConstraints(roomStyle, 1, 3);
		
//		ChoiceBox<Integer> num = new ChoiceBox<>();
//		num.getItems().addAll(NUM);
//		num.getSelectionModel().select(0);
//		GridPane.setConstraints(num, 1, 4);
		
		final Node[] moreRooms = {nameLabel,timeLabel,discountLabel,
				name,begin,sep,end,discount,discountType,roomStyleLabel,roomStyle};
		text.getChildren().addAll(moreRooms);
		typeBox.getSelectionModel().select(0);
		
		Button add = new Button("添加");
		add.setFont(Font.font(20));
		add.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("请确认您的信息无误");
			alert.getDialogPane().setHeaderText(null);
			alert.showAndWait().ifPresent(ok -> {
				if(ok.equals(ButtonType.OK)){
					StrategyType type;
					switch(typeBox.getSelectionModel().getSelectedIndex()){
					case 0:
						type = StrategyType.HOLIDAY;
						break;
					case 1:
						type = StrategyType.BIRTHDAY;
						break;
					case 2:
						type = StrategyType.CO_OPERATION;
						break;
					case 3:
						type = StrategyType.TRIPLEROOM;
						break;
					default:
						type = null;	
					}
					String rStyle = roomStyle.getSelectionModel().getSelectedItem();
					rStyle = rStyle.equals("所有")?null:rStyle;
					StrategyVO vo = new StrategyVO(name.getText(), type, null, null, null,begin.getFormatValue(),
							end.getFormatValue(), Integer.valueOf(discount.getText()), 
							PeopleType.NORMAL,HotelPaneController.getInstance().getHotelId(),rStyle);
					if(ResultMessage.SUCCESS == new StrategyBLServiceImpl().addStrategy(vo)){
System.out.println(1);
						MainPane.getInstance().setRightPane(HotelPaneController.getInstance().createHotelStrategyPane());
					}
				}
			});
		});
		GridPane.setConstraints(add, 1, 8);
		GridPane.setHalignment(add, HPos.RIGHT);
		
//		this.setGridLinesVisible(true);
		this.setPadding(new Insets(50,100,50,100));
		this.getChildren().addAll(retreat,title,typeLabel,typeBox,text,add);
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
	}
	
}
