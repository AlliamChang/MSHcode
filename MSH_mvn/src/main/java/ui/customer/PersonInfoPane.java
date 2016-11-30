package ui.customer;

import java.util.Arrays;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PersonInfoPane {
	private static final String user_name="angel";
	//private String name,phone_number,birthday;
	private String name="xxx";
	private String phone_number="18360977498";
	private String birthday="1997-01-04";
	private int credit_value=100,vip_level=2;
	private String type;
	private String sex;
	private MyNavigationBar navi;
	private GridPane grid;
	private static final int column=3;
	private static final int row=2;
	private Image scul=new Image(PersonInfoPane.class.getResource("/default_sculpture.png").toExternalForm(),
			100,100,false,false);
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);
	
	public PersonInfoPane(){
		initgrid();
		init();
	}
	
	private void init(){
		navi = new MyNavigationBar(scul,Arrays.asList("用户名："+user_name));
		MainPane.getInstance().getChildren().clear();
		MainPane.getInstance().getChildren().addAll(navi,grid);
	}
	
	private void initgrid(){
		this.grid=new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(20);
		grid.setVgap(20);
		//grid.setGridLinesVisible(true);
		
		Label title=new Label("基本资料");
		title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
		this.grid.add(title,1,1);
		
		ImageView iv1 = new ImageView(scul);
		this.grid.add(iv1,column,row);
				
		
		
		Text uncontent=new Text(this.user_name);
		uncontent.setFont(f);
		this.grid.add(uncontent,column+1,row);
		
		Label n=new Label("姓名:");
		n.setFont(f);
		this.grid.add(n, column, row+1);
		
		Text namecontent=new Text(this.name);
		namecontent.setFont(f);
		this.grid.add(namecontent,column+1, row+1);
		
		
		
		Label sextual=new Label("性别:");
		sextual.setFont(f);
		this.grid.add(sextual, column, row+2);
		
		Text sextualcontent=new Text(sex);
		sextualcontent.setFont(f);
		this.grid.add(sextualcontent,column+1,row+2);
		
		
		
	    Label phone=new Label("联系方式:");
	    phone.setFont(f);
	    this.grid.add(phone, column, row+3);
	    
	    Text phonecontent=new Text(phone_number);
	    phonecontent.setFont(f);
	    this.grid.add(phonecontent, column+1, row+3);
	    
	    
	    
	    Label credit=new Label("信用值:");
	    credit.setFont(f);
	    this.grid.add(credit, column, row+4);
	    
	    Text creditcontent=new Text(credit_value+"");
	    creditcontent.setFont(f);
	    this.grid.add(creditcontent, column+1, row+4);
	    
	    Button browsecredit=new Button("查看");
	    this.grid.add(browsecredit, column+2, row+4);
	    
	    browsecredit.setOnMouseClicked((MouseEvent me)->{
	    	
	    });
	    
	    Label member=new Label("会员类型:");
	    member.setFont(f);
	    this.grid.add(member, column, row+5);
	    
	    Text membercontent=new Text(type);
	    membercontent.setFont(f);
	    this.grid.add(membercontent, column+1, row+5);
	    
	    Label vip=new Label("vip等级:");
	    vip.setFont(f);
	    this.grid.add(vip, column, row+6);
	    
	    Text vipcontent=new Text(vip_level+"");
	    vipcontent.setFont(f);
	    this.grid.add(vipcontent, column+1, row+6);
	    
	    Label birth=new Label("生日:");
	    birth.setFont(f);
	    this.grid.add(birth, column, row+7);
	    
	    Text birthcontent=new Text(birthday);
	    birthcontent.setFont(f);
	    this.grid.add(birthcontent,column+1, row+7);
	    
	    Button change=new Button("修改");
	    change.setOnMouseClicked((MouseEvent me)->{
	    	this.grid.getChildren().removeAll(birthcontent,namecontent,sextualcontent,phonecontent);
	    	TextField birth_content=new TextField();
	    	birth_content.setPrefWidth(140);
	    	birth_content.setFont(f);
	    	this.grid.add(birth_content, column+1, row+7);
	    	
	    	TextField name_content=new TextField();
	    	name_content.setFont(f);
	    	name_content.setPrefWidth(140);
	    	this.grid.add(name_content,column+1, row+1);
	    	
	    	TextField sextual_content=new TextField();
	    	sextual_content.setFont(f);
	    	sextual_content.setPrefWidth(100);
	    	this.grid.add(sextual_content, column+1, row+2);
	    	
	    	TextField phone_content=new TextField();
	    	phone_content.setFont(f);
	    	phone_content.setPrefWidth(140);
	    	this.grid.add(phone_content,column+1,row+3);
	    	
	    	
	    });
	    this.grid.add(change, column+2, row+7);
	    
	}
}
