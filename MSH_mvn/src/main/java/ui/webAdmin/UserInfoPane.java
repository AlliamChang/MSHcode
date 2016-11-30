package ui.webAdmin;

import tools.UserType;
import vo.UserVO;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class UserInfoPane extends AnchorPane{
	
	private VBox detailBox, imageNameBox;
	private Label typeLabel, nameLabel, genderLabel, phoneNumberLabel, levelLabel, creditLabel, creditChangeLabel, accountLabel;
	public UserInfoPane(UserVO user){
		super();
		setStyle("-fx-font-size: 17px");
		
		typeLabel = new Label("账户类型：" + typeCheck(user.getType()));
		nameLabel = new Label("姓名：" + user.getName());
		genderLabel = new Label("性别：" + user.getGender());
		phoneNumberLabel = new Label("联系电话：" + user.getNumber());
		levelLabel = new Label("会员等级：" + String.valueOf(user.getLevel()));
		creditLabel = new Label("信用值：" + String.valueOf(user.getCredit()));
		creditChangeLabel = new Label("信用记录：");
		detailBox = new VBox();
		detailBox.setSpacing(15);
		detailBox.getChildren().addAll(typeLabel, nameLabel, genderLabel, phoneNumberLabel, levelLabel, creditLabel, creditChangeLabel);
		
		ImageView userImage = new ImageView(new Image(getClass().getResource("/image/默认头像1.png").toExternalForm()));
		userImage.setFitWidth(200); userImage.setFitHeight(200);
		accountLabel = new Label(user.getAccount());
		accountLabel.setPrefWidth(200);
		accountLabel.setMaxWidth(200);
		accountLabel.setStyle("-fx-font-size: 40px; -fx-alignment: center;");
		imageNameBox = new VBox();
		imageNameBox.getChildren().addAll(userImage, accountLabel);
		
		getChildren().add(detailBox);
		AnchorPane.setTopAnchor(detailBox, 70.0);
		AnchorPane.setLeftAnchor(detailBox, 70.0);
		getChildren().add(imageNameBox);
		AnchorPane.setRightAnchor(imageNameBox, 70.0);
		AnchorPane.setTopAnchor(imageNameBox, 70.0);
	}
	
	private String typeCheck(UserType userType){
		switch(userType){
		case CUSTOMER:
			return "普通用户";
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
