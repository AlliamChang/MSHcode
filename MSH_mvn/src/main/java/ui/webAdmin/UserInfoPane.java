package ui.webAdmin;

import java.util.ArrayList;
import java.util.List;

import tools.UserType;
import ui.utility.MainPane;
import ui.utility.MyImageView;
import vo.CreditVO;
import vo.UserVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Modality;

public class UserInfoPane extends AnchorPane{
	
	private VBox detailBox, imageNameBox, creditRecordsBox;
	private HBox hBox;
	private ScrollPane sp;
	private Label typeLabel, nameLabel, genderLabel, phoneNumberLabel, levelLabel, creditLabel, creditRecordsLabel, accountLabel;
	private Button modifyButton, deleteButton;
	private Parent lastPane;
	private BackButton backButton;
	private TextFlow typeFlow;
	
	public UserInfoPane(UserVO user, Parent lastPane){
		super();
		this.lastPane = lastPane;
		setStyle("-fx-border-color: black");
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		backButton = new BackButton(lastPane);
		getChildren().add(backButton);
		AnchorPane.setTopAnchor(backButton, 15.0);
		AnchorPane.setLeftAnchor(backButton, 15.0);
		
		typeLabel = new Label("账户类型：" + typeCheck(user.getType()));
		nameLabel = new Label("姓名：" + user.getName());
		genderLabel = new Label("性别：" + user.getGender());
		phoneNumberLabel = new Label("联系电话：" + user.getNumber());
		typeFlow = new TextFlow();
		typeFlow.getChildren().add(typeLabel);
		if (user.getType() == UserType.COMPANY_CUSTOMER)
			typeFlow.getChildren().add(new Text(" (" + user.getCompany() + ")"){{setStyle("-fx-fill: gray");}});
		if (user.getType() == UserType.HOTEL_STAFF)
			typeFlow.getChildren().add(new Text(
					" (" + WebAdminController.getInstance().getHotelName(user.getHotelID()) + ")"){{setStyle("-fx-fill: gray");}});
		detailBox = new VBox();
		detailBox.setSpacing(20);
		
		detailBox.getChildren().addAll(typeFlow, nameLabel, genderLabel, phoneNumberLabel);

		if (user.getType() == UserType.CUSTOMER || user.getType() == UserType.COMPANY_CUSTOMER){
			levelLabel = new Label("会员等级：" + String.valueOf(user.getLevel()));
			creditLabel = new Label("信用值：" + String.valueOf(user.getCredit()));
			creditRecordsLabel = new Label("信用记录：");
			creditRecordsBox = new VBox();
			sp = new ScrollPane(creditRecordsBox);
			sp.setStyle("-fx-border-color: gray");
			sp.setPrefSize(500, 200);
			sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			creditRecordsBox.setPadding(new Insets(10, 10, 10, 10));
			creditRecordsBox.setSpacing(10);
			creditRecordsBox.setPrefWidth(472);
			creditRecordsBox.getChildren().addAll(Record.makeRecords((WebAdminController.getInstance().getCreditRecords(user))));
			detailBox.getChildren().addAll(levelLabel, creditLabel, creditRecordsLabel, sp);
		}
		MyImageView userImage = new MyImageView(user.getImage());
		userImage.setFitWidth(200); userImage.setFitHeight(200);
		accountLabel = new Label(user.getAccount() != null ? user.getAccount() : ("ID: " + String.format("%08d", user.getID())));
		accountLabel.setPrefWidth(200);
		accountLabel.setMaxWidth(200);
		accountLabel.setStyle("-fx-font-size: 30px; -fx-alignment: center;");
		imageNameBox = new VBox();
		imageNameBox.getChildren().addAll(userImage, accountLabel);
		
		getChildren().add(detailBox);
		AnchorPane.setTopAnchor(detailBox, 70.0);
		AnchorPane.setLeftAnchor(detailBox, 70.0);
		getChildren().add(imageNameBox);
		AnchorPane.setRightAnchor(imageNameBox, 70.0);
		AnchorPane.setTopAnchor(imageNameBox, 90.0);
		
		hBox = new HBox();
		hBox.setSpacing(30);
		modifyButton = new Button("修改");
		
		modifyButton.setOnAction(e -> WebAdminController.getInstance().setModifyUserInfo(user, UserInfoPane.this));
		
		deleteButton = new Button("删除");
		modifyButton.setPrefSize(80, 30);
		deleteButton.setPrefSize(80, 30);
		deleteButton.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("确认删除该用户？");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response
				-> {
					WebAdminController.getInstance().deleteUser(user);
					WebAdminController.getInstance().setInitialPane();
				});
		});
		hBox.getChildren().add(modifyButton);
		hBox.getChildren().add(deleteButton);
		if (user.getType() == UserType.HOTEL_STAFF || user.getType() == UserType.WEB_ADMIN)
			deleteButton.setDisable(true);
		

		getChildren().add(hBox);
		
		AnchorPane.setBottomAnchor(hBox, 15.0);
		AnchorPane.setLeftAnchor(hBox, 230.0);
		
	}
	
	public Parent getLastPane(){
		return lastPane;
	}
	
	public static String typeCheck(UserType userType){
		switch(userType){
		case CUSTOMER:
			return "普通用户";
		case COMPANY_CUSTOMER:
			return "企业用户";
		case HOTEL_STAFF:
			return "酒店工作人员";
		case WEB_ADMIN:
			return "网站管理人员";
		case MARKETER:
			return "网站营销人员";
		}
		return null;
	}
}

class Record extends GridPane{
	Text reason, date, change;
	HBox hBox;
	Record(CreditVO creditVO){
		super();
		setStyle("-fx-border-color: gray");
		setPadding(new Insets(5, 5, 5, 5));
		setHgap(10);
		setVgap(10);
		reason = new Text(creditVO.reasonProperty().getValue());
		reason.setStyle("-fx-fill: #3D3D3D");
		date = new Text(creditVO.dateProperty().getValue());
		date.setStyle("-fx-fill: #3D3D3D");
		add(reason, 0, 0);
		add(date, 0, 1);
		change = new Text(creditVO.changeProperty().getValue());
		change.setStyle("-fx-font-size: 28px; -fx-fill: #3D3D3D");
		hBox = new HBox();
		hBox.setAlignment(Pos.CENTER_RIGHT);
		hBox.getChildren().add(change);
		add(hBox, 1, 0, 1, 2);
		GridPane.setHgrow(hBox, Priority.ALWAYS);
	}
	
	static List<Record> makeRecords(List<CreditVO> list){
		ArrayList<Record> ret = new ArrayList<Record>();
		if (list != null)
			for (CreditVO item: list)
				ret.add(new Record(item));
		return ret;
	}
}
