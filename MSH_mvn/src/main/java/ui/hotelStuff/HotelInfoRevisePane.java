package ui.hotelStuff;

import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import ui.utility.MainPane;
import ui.utility.MyRetreatButton;
import vo.HotelInfoVO;

public class HotelInfoRevisePane extends AnchorPane{

	private static final double LEFT_ANCHOR = 50;
	private HotelInfoVO hotelInfo;
	private HotelInfoPane lastPane;
	
	public HotelInfoRevisePane(HotelInfoVO hotelInfo,HotelInfoPane lastPane){
		super();
		this.hotelInfo = hotelInfo;
		this.lastPane = lastPane;
		init();
	}
	
	private void init(){
		Label title = new Label(hotelInfo.getHotel());
		title.setStyle("-fx-font-size:40;");
		AnchorPane.setLeftAnchor(title, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(title, 40.0);
		
		MyRetreatButton retreat = new MyRetreatButton(lastPane);
		AnchorPane.setLeftAnchor(retreat, 5.0);
		AnchorPane.setTopAnchor(retreat, 5.0);
		
		Separator sep = new Separator();
		sep.setPrefWidth(300);
		sep.setStyle("-fx-background-color:black;-fx-border-color:black;");
		AnchorPane.setLeftAnchor(sep, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(sep, 90.0);
		
		ImageView sculView = new ImageView(hotelInfo.getScul());
		sculView.setStyle("-fx-border-color:black");
		sculView.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.5), 8, 0, 0, 2));
		AnchorPane.setRightAnchor(sculView, LEFT_ANCHOR-10);
		AnchorPane.setTopAnchor(sculView, 100.0);
		
		Button changeScul = new Button("修改酒店封面");
		changeScul.setFont(Font.font(15));
		AnchorPane.setRightAnchor(changeScul, LEFT_ANCHOR+35);
		AnchorPane.setTopAnchor(changeScul, 310.0);
		
		GridPane infoPane = new GridPane();
		infoPane.setStyle("-fx-font-size:15");
//		infoPane.setGridLinesVisible(true);
		infoPane.setMaxHeight(450);
		infoPane.setVgap(10);
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
		
		TextField adressText = new TextField(hotelInfo.getAdress());
		adressText.setMaxWidth(200);
		infoPane.add(adressText, 1, 0);
		
		TextField phoneText = new TextField(hotelInfo.getPhone());
		phoneText.setMaxWidth(150);
		infoPane.add(phoneText, 1, 1);
		
		TextField cityText = new TextField(hotelInfo.getProvince());
		cityText.setMaxWidth(100);
		infoPane.add(cityText, 1, 2);
		
		TextField tradAreaText = new TextField(hotelInfo.getTradingArea());
		tradAreaText.setMaxWidth(100);
		infoPane.add(tradAreaText, 1, 3);
		
		TextField openLabelText = new TextField(hotelInfo.getYear()+"");
		openLabelText.setMaxWidth(100);
		infoPane.add(openLabelText, 1, 4);
		
		Text faciText = new Text();
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < hotelInfo.getFacility().length; i ++){
			temp.append(hotelInfo.getFacility()[i]);
			if(i < hotelInfo.getFacility().length - 1)
				temp.append("、");
		}
		faciText.setText(temp.toString());
		faciText.setWrappingWidth(250);
		infoPane.add(faciText, 1, 5);
		
		TextArea introText = new TextArea(hotelInfo.getIntroduction());
		introText.setPrefSize(340, 150);
		introText.setWrapText(true);
		infoPane.add(introText, 1, 6);
		
		for(int i = 0; i < infoPane.getChildren().size()-1; i ++)
			GridPane.setValignment(infoPane.getChildren().get(i), VPos.BASELINE);
		
		AnchorPane.setLeftAnchor(infoPane, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(infoPane, 110.0);
		
		Button save = new Button("保存");
		save.setFont(Font.font(20));
		save.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setHeaderText(null);
			alert.setContentText("确定要保存修改吗？");
			alert.showAndWait().ifPresent(response -> {
				if(response == ButtonType.OK){
					MainPane.getInstance().setRightPane(lastPane);
					
				}
			});
		});
		AnchorPane.setRightAnchor(save, 130.0);
		AnchorPane.setBottomAnchor(save, LEFT_ANCHOR-10);
		
		Button cancel = new Button("取消");
		cancel.setFont(Font.font(20));
		cancel.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setHeaderText(null);
			alert.setContentText("确定要放弃当前操作，返回上一页面吗？");
			alert.showAndWait().ifPresent(response -> {
				if(response == ButtonType.OK){
					MainPane.getInstance().setRightPane(lastPane);
					
				}
			});
		});
		AnchorPane.setRightAnchor(cancel, 40.0);
		AnchorPane.setBottomAnchor(cancel, LEFT_ANCHOR-10);
		

		this.getChildren().addAll(retreat,title,sep,infoPane,sculView,save,cancel,changeScul);
		this.setStyle("-fx-border-color:black;");
		this.setPrefSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
	}
}
