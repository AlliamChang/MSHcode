package ui.hotelStuff;

import java.util.*;

import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.hotelStuff.control.HotelPaneController;
import ui.hotelStuff.subgroup.CheckinTable;
import ui.utility.MainPane;
import vo.CheckInVO;
import vo.RoomVO;

public class CheckInListPane extends AnchorPane{

	
	private Tab[] roomTab;
	private CheckinTable[] roomList;
	private TabPane checkinTabPane;
	private String[] roomStyle;
	private Map<String,List<CheckInVO> >  data;
	private final List<Integer> roomNum;
	
	public CheckInListPane (String[] roomStyle,Iterator<CheckInVO> list ){
		super();
		this.roomStyle = roomStyle;
		this.roomTab = new Tab[roomStyle.length];
		this.roomList = new CheckinTable[roomStyle.length];
		this.checkinTabPane = new TabPane();
		
		data = new HashMap<String,List<CheckInVO>>();
		
		for(int i = 0; i < roomStyle.length; i ++){
			roomTab[i] = new Tab(roomStyle[i]);
			data.put(roomStyle[i], new ArrayList<CheckInVO>());
		}
		while(list.hasNext()){
			CheckInVO temp = list.next();
			data.get(temp.getRoomStyle()).add(temp);
		}
		
		Iterator<RoomVO> itr = HotelPaneController.getInstance().getRoomList();
		roomNum = new ArrayList<Integer>();
		while(itr.hasNext()){
			roomNum.add(itr.next().getNum());
		}
		
		this.init();
	}
	 
	private void init(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		Label title = new Label("入住信息列表");
		title.setFont(Font.font(40));
		AnchorPane.setLeftAnchor(title, 20.0);
		AnchorPane.setTopAnchor(title, 20.0);
		
		Separator sep = new Separator();
		sep.setPrefWidth(275);
		sep.setStyle("-fx-background-color:black;-fx-border-width:2");
		AnchorPane.setTopAnchor(sep, 70.0);
		AnchorPane.setLeftAnchor(sep, 20.0);
		
		Button add = new Button("新的入住");
		add.setFont(Font.font(17));
		add.setOnAction(e -> {
			MainPane.getInstance().setRightPane(new CheckinInfoPane(this));
		});
		AnchorPane.setTopAnchor(add, 55.0);
		AnchorPane.setRightAnchor(add, 75.0);
		
		
		this.checkinTabPane.setPrefSize(MainPane.MINWIDTH - 10, 500);
		this.checkinTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.checkinTabPane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
		for(int i = 0; i < roomTab.length; i ++){
			VBox temp = new VBox(10);
			Text numInfo = new Text();
			int num = 0;
			for(int j = 0; j < data.get(roomStyle[i]).size(); j ++){
				num += data.get(roomStyle[i]).get(j).getRoomNum();
			}
			if(num == roomNum.get(i))
				numInfo.setText("本房间类型房源状况：" + num + "/ " + roomNum.get(i) + "（已满）");
			else
				numInfo.setText("本房间类型房源状况：" + num + "/ " + roomNum.get(i));
			roomList[i] = new CheckinTable(data.get(roomStyle[i]).iterator()); 
			checkinTabPane.getTabs().add(roomTab[i]);
			VBox.setMargin(numInfo, new Insets(10,0,0,20));
			temp.getChildren().addAll(numInfo,roomList[i]);
			temp.setStyle("-fx-background-color:white");
			roomTab[i].setContent(temp);
		}
		AnchorPane.setLeftAnchor(this.checkinTabPane, 5.0);
		AnchorPane.setBottomAnchor(this.checkinTabPane, 20.0);
		
		this.setStyle("-fx-font-size:15;-fx-border-color:black");
		this.getChildren().addAll(title,sep,add,checkinTabPane);
		
	}
}
 