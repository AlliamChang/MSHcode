package ui.utility;

import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

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
	
	/**
	 *未登录状态下的导航栏构造方法 
	 */
	public MyNavigationBar(){
		super(0);
		this.initNavi(null);
		naviBox.setMinSize(MAX_WIDTH, MAX_HEIGHT+10);
		this.init();
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
	}
	
	public ToggleGroup getToggle(){
		return group;
	}
	
}
