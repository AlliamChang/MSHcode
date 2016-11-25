package ui.utility;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
	
	/**
	 *未登录状态下的导航栏构造方法 
	 */
	public MyNavigationBar(){
		super(0);
		this.initNavi();
		naviBox.setMinSize(MAX_WIDTH, MAX_HEIGHT+10);
		this.init();
	}
	
	/**
	 * 已有登录状态下的导航栏构造方法
	 * @param scul 用户的头像
	 * @param info 用户的信息列表，顺序为由上至下
	 */
	public MyNavigationBar(Image scul,List<String> info){
		super(SPACE);
		
		if(null == scul){
			this.scul = DEFAULT_SCULPTURE;
		}else{
			this.scul = scul;
		}
		
		this.info = info;
		this.initInfo();
		this.initNavi();
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
	
	private void initNavi(){
		naviBox = new VBox(SPACE);
		naviBox.setStyle(BACKGROUND_STYLE + BORDER_STYLE);
		naviBox.setMinSize(MAX_WIDTH, MAX_HEIGHT * 0.625);
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
	
}
