package ui.hotelStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bl.hotel.HotelBLServiceImpl;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import tools.ResultMessage;
import ui.hotelStuff.control.HotelPaneController;
import ui.utility.MainPane;
import ui.utility.MyDeletableTextField;
import ui.utility.MyFileChooser;
import ui.utility.MyNumberField;
import ui.utility.MyRetreatButton;
import vo.HotelInfoVO;

public class HotelInfoRevisePane extends AnchorPane{

	private static final double LEFT_ANCHOR = 50;
	private static final List<String> STAR = Arrays.asList("尚未设置","经济型","二星级","三星级/舒适","四星级/高级","五星级/豪华");
	private SimpleBooleanProperty hasntRevise = new SimpleBooleanProperty(true);
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
		sculView.setFitHeight(200);
		sculView.setFitWidth(200);
		sculView.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.5), 8, 0, 0, 2));
		AnchorPane.setRightAnchor(sculView, LEFT_ANCHOR-20);
		AnchorPane.setTopAnchor(sculView, 100.0);
		
		Button changeScul = new Button("上传图片");
		changeScul.setFont(Font.font(15));
		changeScul.setOnAction(e -> {
			Image newImage;
			if((newImage = new MyFileChooser().showOpenDialog()) != null){
				sculView.setImage(newImage);
				hasntRevise.set(false);
			}
		});
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
		
		Label starLabel = new Label("酒店星级：");
		infoPane.add(starLabel, 0, 4);
		
		Label openLabel = new Label("开业时间：");
		infoPane.add(openLabel, 0, 5);
		
		Label faciLabel = new Label("酒店设施：");
		infoPane.add(faciLabel, 0, 6);
		
		Label introLable = new Label("酒店简介：");
		infoPane.add(introLable, 0, 7);
		
		TextField adressText = new TextField(hotelInfo.getAdress());
		adressText.setMaxWidth(200);
		adressText.textProperty().addListener((l,o,n) -> hasntRevise.set(false));
		infoPane.add(adressText, 1, 0);
		
		TextField phoneText = new MyNumberField(hotelInfo.getPhone());
		phoneText.setMaxWidth(150);
		infoPane.add(phoneText, 1, 1);
		
		Label cityText = new Label(hotelInfo.getProvince() + " " + (hotelInfo.getCity()==null? "" : hotelInfo.getCity()));
		cityText.setMaxWidth(100);
		infoPane.add(cityText, 1, 2);
		
		Label tradAreaText = new Label(hotelInfo.getTradingArea());
		tradAreaText.setMaxWidth(100);
		infoPane.add(tradAreaText, 1, 3);
		
		ChoiceBox<String> starBox = new ChoiceBox<>();
		starBox.getItems().addAll(STAR);
		starBox.getSelectionModel().select(hotelInfo.getStar());
		starBox.valueProperty().addListener((l,o,n) -> hasntRevise.set(false));
		infoPane.add(starBox, 1, 4);
		
		TextField openLabelText = new MyNumberField(hotelInfo.getYear()+"");
		openLabelText.textProperty().addListener((l,o,n) -> hasntRevise.set(false));
		openLabelText.setMaxWidth(100);
		infoPane.add(openLabelText, 1, 5);
		
		FlowPane flow = new FlowPane(Orientation.HORIZONTAL,3,6);
		flow.setPrefWrapLength(350);
		List<MyDeletableTextField> faciText = new ArrayList<MyDeletableTextField>();
		if (hotelInfo.getFacility() != null)
			for(int i = 0; i < hotelInfo.getFacility().length; i ++){
				MyDeletableTextField temp = new MyDeletableTextField(flow,hotelInfo.getFacility()[i]);
				temp.setMaxWidth(100);
				temp.getEditor().textProperty().addListener((l,o,n) -> hasntRevise.set(false));
				faciText.add(temp);
				flow.getChildren().add(temp);
			}
		Button addFaci = new Button("+");
		addFaci.setMinWidth(20);
		addFaci.setOnAction(e -> {
			MyDeletableTextField temp = new MyDeletableTextField(flow);
			hasntRevise.set(false);
			temp.setMaxWidth(100);
			faciText.add(temp);
			flow.getChildren().add(flow.getChildren().size()-1, temp);
		});
		flow.getChildren().add(addFaci);
		infoPane.add(flow, 1, 6);
		
		
		TextArea introText = new TextArea(hotelInfo.getIntroduction());
		introText.setPrefSize(340, 150);
		introText.textProperty().addListener((l,o,n) -> hasntRevise.set(false));
		introText.setWrapText(true);
		infoPane.add(introText, 1, 7);
		
		for(int i = 0; i < infoPane.getChildren().size()-1; i ++)
			GridPane.setValignment(infoPane.getChildren().get(i), VPos.BASELINE);
		
		AnchorPane.setLeftAnchor(infoPane, LEFT_ANCHOR);
		AnchorPane.setTopAnchor(infoPane, 110.0);
		
		Button save = new Button("保存");
		save.disableProperty().bind(hasntRevise);;
		save.setFont(Font.font(20));
		save.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setHeaderText(null);
			alert.setContentText("确定要保存修改吗？");
			alert.showAndWait().ifPresent(response -> {
				if(response == ButtonType.OK){
					StringBuilder fac = new StringBuilder();
					for(int i = 0; i < flow.getChildren().size()-1; i ++){
						MyDeletableTextField temp = (MyDeletableTextField)(flow.getChildren().get(i));
						if(temp.getContent() != null && !temp.getContent().equals("")){
							fac.append(temp.getContent()+"%");
						}
					}
					String imagePath = sculView.getImage().impl_getUrl().startsWith("file:")?sculView.getImage().impl_getUrl().substring(5).replace('/','\\'):null;
				
					ResultMessage result = new HotelBLServiceImpl().modify(new HotelInfoVO(hotelInfo.getHotel(),adressText.getText(),
							phoneText.getText(),fac.toString().trim().split("%"),introText.getText(),hotelInfo.getProvince(),
							hotelInfo.getTradingArea(),Integer.valueOf(openLabelText.getText()),imagePath,starBox.getSelectionModel().getSelectedIndex(),hotelInfo.getScore(),hotelInfo.getHotel_id(),
							hotelInfo.getStuff_id(),hotelInfo.getCity()));
					if(result == ResultMessage.SUCCESS){
						Alert a = new Alert(AlertType.CONFIRMATION);
						a.getDialogPane().setHeaderText(null);
						a.setContentText("修改成功");
						a.showAndWait().ifPresent(ok -> MainPane.getInstance().setRightPane(HotelPaneController.getInstance().createHotelInfoPane()));
					}else{
						Alert a = new Alert(AlertType.ERROR);
						a.getDialogPane().setHeaderText(null);
						a.setContentText("修改失败");
						a.show();
					}
				}
			});
		});
		AnchorPane.setRightAnchor(save, 100.0);
		AnchorPane.setBottomAnchor(save, LEFT_ANCHOR-10);
		
		Button cancel = new Button("取消");
		cancel.setFont(Font.font(20));
		cancel.setOnAction(e -> {
			if(!hasntRevise.get()){
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				alert.setContentText("确定要放弃当前操作，返回上一页面吗？");
				alert.showAndWait().ifPresent(response -> {
					if(response == ButtonType.OK){
						MainPane.getInstance().setRightPane(lastPane);
						
					}
				});
			}else{
				MainPane.getInstance().setRightPane(lastPane);
			}
		});
		AnchorPane.setRightAnchor(cancel, 20.0);
		AnchorPane.setBottomAnchor(cancel, LEFT_ANCHOR-10);
		

		this.getChildren().addAll(retreat,title,sep,infoPane,sculView,save,cancel,changeScul);
		this.setStyle("-fx-border-color:black;");
		this.setPrefSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
	}
}
