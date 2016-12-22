package ui.utility;

import java.rmi.RemoteException;
import java.util.List;

import bl.user_bl.UserBLServiceImpl;
import blservice.user_blservice.UserBLService;
import javafx.scene.input.MouseEvent;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import po.UserPO;
import rmi.RemoteHelper;
import tools.ResultMessage;
import tools.UserType;
import ui.customer.CustomerPaneController;
import ui.hotelStuff.control.HotelPaneController;
import ui.webAdmin.WebAdminController;
import ui.websiteStuff.WebsitePaneController;
import vo.UserVO;

public class MyNavigationBar extends VBox {
	
	private static final double SPACE = 5;
	private static final String BORDER_STYLE = "-fx-border-color:black;";
	private static final String BACKGROUND_STYLE = "-fx-background-color:white;";
	private static final double MAX_WIDTH = 150;
	private static final double MAX_HEIGHT = 600;
	private static final Image DEFAULT_SCULPTURE = 
			new Image(MyNavigationBar.class.getResource("/default_sculpture.png").toExternalForm(),
					120,120,false,false);
	private Image scul;
	private List<String> info;
	private VBox infoBox;
	private ImageView sculView;
	private VBox naviBox;
	private ToggleButton[] naviButton;
	private ToggleGroup group;
	
	private UserBLService userBL;
	
	/**
	 *未登录状态下的导航栏构造方法 
	 */
	public MyNavigationBar(){
		super(SPACE);
		userBL = new UserBLServiceImpl();
		
		this.setPrefSize(MAX_WIDTH, MAX_HEIGHT);
		this.setStyle(BACKGROUND_STYLE);
		this.setStyle(BORDER_STYLE);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(100);
		Button login=new Button("登录");
		login.setOnAction(event -> {
			LoginDialog loginDialog = new LoginDialog();
			loginDialog.showAndWait().filter(r -> r != null).ifPresent(info -> {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				try {
					ResultMessage message =userBL.login(info.getKey(), info.getValue());
					if (message == ResultMessage.SUCCESS) {
						alert.setAlertType(AlertType.INFORMATION);
						alert.getDialogPane().setContentText("欢迎回来！");
						UserPO po;
						try {
							int id = Integer.parseInt(info.getKey());
							po = RemoteHelper.getInstance().getUserDAO().getUser(id);
						} catch (NumberFormatException e){
							po = RemoteHelper.getInstance().getUserDAO().getUser(info.getKey());
						}
						UserVO vo = new UserVO(po);
						switch (vo.getType()) {
						case CUSTOMER:
						case COMPANY_CUSTOMER:
							CustomerPaneController.getInstance().CustomerLogin(vo.getName(), vo.getImage());
							break;
						case HOTEL_STAFF:
							HotelPaneController.getInstance()
							.hotelStuffLogin(vo.getID(), String.valueOf(vo.getHotelID()), vo.getImage());
							break;
						case WEB_ADMIN:
							WebAdminController.getInstance().init();
							break;
						case MARKETER:
							WebsitePaneController.getInstance().init(vo.getID(), vo.getName());
							break;
						}
						alert.showAndWait();
					} else {
						if (message == ResultMessage.FAIL)
							alert.getDialogPane().setContentText("密码错误！");
						if (message == ResultMessage.NOT_EXIST)
							alert.getDialogPane().setContentText("账号不存在！");
						if (message == ResultMessage.LOGGED)
							alert.getDialogPane().setContentText("已在别处登录！");
						alert.showAndWait();
						login.fire();
					}
				} catch (RemoteException e) {
					alert.getDialogPane().setContentText("未知错误！");
					alert.showAndWait();
					login.fire();
					e.printStackTrace();
				}
			});
		});
		Button register=new Button("注册");
		register.setOnAction(event -> {
			MainPane.getInstance().setRightPane(new RegisterPane());
		});
		this.getChildren().addAll(login,register);
		
	}
	
	/**
	 * 已有登录状态下的导航栏构造方法
	 * @param scul 用户的头像
	 * @param info 用户的信息列表，顺序为由上至下
	 */
	public MyNavigationBar(Image scul,List<String> info,List<String> navi){
		super(SPACE);
		
		if(null == scul){
			this.scul = DEFAULT_SCULPTURE;
		}else{
			this.scul = scul;
		}
		this.naviButton = new ToggleButton[navi.size()];
		this.info = info;
		this.initInfo();
		this.initNavi(navi);
		this.init();
	}
	
	/**
	 * 初始化导航栏
	 */
	private void init(){
		this.setPrefSize(MAX_WIDTH, MAX_HEIGHT);
		this.setStyle(BACKGROUND_STYLE);
		if(null != infoBox)
			this.getChildren().add(infoBox);
		this.getChildren().add(naviBox);
	}
	
	private void initNavi(List<String> navi){
		group = new ToggleGroup();
		naviBox = new VBox(0);
		naviBox.setStyle(BACKGROUND_STYLE + BORDER_STYLE);
		naviBox.setMinSize(MAX_WIDTH, MAX_HEIGHT * 0.625);
		for(int i = 0; i < navi.size(); i ++){
			naviButton[i] = new ToggleButton(navi.get(i));
			naviButton[i].setMinSize(MAX_WIDTH-3,50);
			naviButton[i].setStyle("-fx-font-size:15;");
			naviButton[i].setToggleGroup(group);
			naviBox.getChildren().add(naviButton[i]);
		}
		group.selectToggle(naviButton[0]);
		group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {

            if (newValue == null) {
                group.selectToggle(oldValue);

            }else{
            	ProgressIndicator p = new ProgressIndicator();
            	p.setPrefSize(50, 50);
            	MainPane.getInstance();
            }

        });
	}
	
	private void initInfo(){
		infoBox = new VBox(SPACE);
		infoBox.setStyle(BACKGROUND_STYLE + BORDER_STYLE);
		infoBox.setMaxSize(MAX_WIDTH, MAX_HEIGHT * 0.382);
		infoBox.setMinSize(MAX_WIDTH, MAX_HEIGHT * 0.382);
		infoBox.setAlignment(Pos.BASELINE_CENTER);
		infoBox.setPadding(new Insets(10,10,10,10));
		
		
		sculView = new ImageView(scul);
		infoBox.getChildren().add(sculView);

		Text[] list = new Text[info.size()];
		for(int i = 0; i < list.length; i ++){
			list[i] = new Text(info.get(i));
			list[i].setWrappingWidth(MAX_WIDTH - 20);
			list[i].setTextAlignment(TextAlignment.CENTER);
			infoBox.getChildren().add(list[i]);
		}
		
		Button logout = new Button("注销");
		logout.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("确定要注销当前账号吗？");
			alert.getDialogPane().setHeaderText(null);
			alert.showAndWait().ifPresent(type -> {
				if(type.equals(ButtonType.OK)){
					MainPane.getInstance().logout();
				}
			});
		});
		
		infoBox.getChildren().add(logout);
	}
	
	public ToggleGroup getToggle(){
		return group;
	}
	
}
