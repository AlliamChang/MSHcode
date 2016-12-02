package ui.hotelStuff;

import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import ui.utility.MainPane;
import vo.HotelInfoVO;

public class HotelInfoPane extends AnchorPane{

	private String hotel;
	private long id;
	private static final double LEFT_ANCHOR = 50;
	
	public HotelInfoPane(String hotel, long id){
		super();
		this.hotel = hotel;
		this.id = id;
		init();
	}
	
	private void init(){
		HotelInfoVO hotelInfo = HotelPaneController.getInstance().getHotelInfo();
		Label title = new Label(hotelInfo.getHotel());
		title.setStyle("-fx-font-size:40;");
		AnchorPane.setLeftAnchor(title, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(title, 40.0);
		
		Separator sep = new Separator();
		sep.setPrefWidth(300);
		sep.setStyle("-fx-background-color:black;-fx-border-color:black;");
		AnchorPane.setLeftAnchor(sep, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(sep, 90.0);
		
		ImageView sculView = new ImageView(hotelInfo.getScul());
		AnchorPane.setRightAnchor(sculView, LEFT_ANCHOR-10);
		AnchorPane.setTopAnchor(sculView, 100.0);
		
		GridPane infoPane = new GridPane();
		infoPane.setStyle("-fx-font-size:15");
//		infoPane.setGridLinesVisible(true);
		infoPane.setMaxHeight(450);
		infoPane.setVgap(20);
//		RowConstraints rowinfo = new RowConstraints();
//		rowinfo.setPercentHeight(30);
//		rowinfo.setMaxHeight(USE_PREF_SIZE);
//		for(int i = 0; i < 7; i ++)
//			infoPane.getRowConstraints().add(rowinfo);
		
		Label adressLabel = new Label("酒店地址：");
		infoPane.add(adressLabel, 0, 0);
		
		Label phoneLabel = new Label("联系方式：");
		infoPane.add(phoneLabel, 0, 1);
		
		Label cityLabel = new Label("所属城市：");
		infoPane.add(cityLabel, 0, 2);
		
		Label tradAreaLabel = new Label("所属商圈：");
		infoPane.add(tradAreaLabel, 0, 3);
		
		Label openLabel = new Label("开业时间：");
		infoPane.add(openLabel, 0, 4);
		
		Label faciLabel = new Label("酒店设施：");
		infoPane.add(faciLabel, 0, 5);
		
		Label introLable = new Label("酒店简介：");
		infoPane.add(introLable, 0, 6);
		
		Text adressText = new Text(hotelInfo.getAdress());
		infoPane.add(adressText, 1, 0);
		
		Text phoneText = new Text(hotelInfo.getPhone());
		infoPane.add(phoneText, 1, 1);
		
		Text cityText = new Text(hotelInfo.getProvince());
		infoPane.add(cityText, 1, 2);
		
		Text tradAreaText = new Text(hotelInfo.getTradingArea());
		infoPane.add(tradAreaText, 1, 3);
		
		Text openLabelText = new Text(hotelInfo.getYear()+"年开业");
		infoPane.add(openLabelText, 1, 4);
		
		Text faciText = new Text();
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < hotelInfo.getFacility().length; i ++){
			temp.append(hotelInfo.getFacility()[i]);
			if(i < hotelInfo.getFacility().length - 1)
				temp.append("、");
		}
		faciText.setText(temp.toString());
		faciText.setWrappingWidth(350);
		infoPane.add(faciText, 1, 5);
		
		Text introText = new Text(hotelInfo.getIntroduction());
		introText.setWrappingWidth(350);
		infoPane.add(introText, 1, 6);
		
		for(int i = 0; i < infoPane.getChildren().size(); i ++)
			GridPane.setValignment(infoPane.getChildren().get(i), VPos.BASELINE);
		
		AnchorPane.setLeftAnchor(infoPane, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(infoPane, 110.0);
		
		Button revise = new Button("修改");
		revise.setFont(Font.font(20));
		revise.setOnAction(e -> {
			
		});
		AnchorPane.setRightAnchor(revise, 90.0);
		AnchorPane.setBottomAnchor(revise, LEFT_ANCHOR);
		
		this.getChildren().addAll(title,sep,infoPane,revise,sculView);
		this.setStyle("-fx-border-color:black;");
		this.setPrefSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
	}
}
