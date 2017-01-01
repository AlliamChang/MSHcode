package ui.customer;

import java.util.Arrays;

import blservice.user_blservice.UserBLService;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import ui.utility.MyRetreatButton;
import vo.UserVO;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import tools.UserType;

public class PersonInfoPane extends Pane {
	private UserVO user;
	private  String user_name;
	private String name;
	private String phone_number;
	private String birthday;
	private int credit_value,vip_level;
	private UserType type;
	private String sex;
	private GridPane grid;
	private static final int column=8;
	private static final int row=1;
	private Image scul;
	private MyRetreatButton back;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);
	
	public PersonInfoPane(UserVO vo){
		super();
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		user=vo;
		user_name=user.getAccount();
		name=user.getName();
		phone_number=user.getNumber();
		birthday=user.getYear()+"-"+user.getMonth()+"-"+user.getDay();
		credit_value=user.getCredit();
		vip_level=user.getLevel();
		sex=user.getGender();
		scul=user.getImage();
		type = user.getType();
		back=new MyRetreatButton(HotelSearchPane.getInstance());
		initgrid();
	}
	
	private void initgrid(){
		this.grid=new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(20);
		grid.setVgap(20);
		//grid.setGridLinesVisible(true);
		
		/*Label title=new Label("基本资料");
		title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
		this.grid.add(title,1,1);*/
		
		this.grid.add(back, column-6, row-1);
		ImageView iv1 = new ImageView(scul);
		iv1.setFitWidth(150);
		iv1.setFitHeight(150);
		this.grid.add(iv1,column,row);
				
		Text uncontent=new Text(this.user_name);
		//uncontent.setFont(f);
		this.grid.add(uncontent,column+1,row);
		
		Label n=new Label("姓名:");
		//n.setFont(f);
		this.grid.add(n, column, row+1);
		
		Text namecontent=new Text(this.name);
		//namecontent.setFont(f);
		this.grid.add(namecontent,column+1, row+1);
		
		Label sextual=new Label("性别:");
		//sextual.setFont(f);
		this.grid.add(sextual, column, row+2);
		
		Text sextualcontent=new Text(sex);
		//sextualcontent.setFont(f);
		this.grid.add(sextualcontent,column+1,row+2);
		
	    Label phone=new Label("联系方式:");
	   // phone.setFont(f);
	    this.grid.add(phone, column, row+3);
	    
	    Text phonecontent=new Text(phone_number);
	   // phonecontent.setFont(f);
	    this.grid.add(phonecontent, column+1, row+3);
	    
	    Label credit=new Label("信用值:");
	    //credit.setFont(f);
	    this.grid.add(credit, column, row+4);
	    
	    Text creditcontent=new Text(credit_value+"");
	   // creditcontent.setFont(f);
	    this.grid.add(creditcontent, column+1, row+4);
	    
	    Button browsecredit=new Button("查看");
	    this.grid.add(browsecredit, column+2, row+4);
	    
	    browsecredit.setOnMouseClicked((MouseEvent me)->{
	    	MainPane.getInstance().setRightPane(new CreditRecordPane());
	    });
	    
	    Label member=new Label("会员类型:");
	    member.setFont(f);
	    this.grid.add(member, column, row+5);
	    Text membercontent;
	    if(type == UserType.CUSTOMER ||type == UserType.COMPANY_CUSTOMER){
	    	membercontent=new Text(type == UserType.CUSTOMER ? "普通会员" : "企业会员");
	     	//membercontent.setFont(f);
		    this.grid.add(membercontent, column+1, row+5);

	    }
	    else{
	    	membercontent=new Text("非会员");
	    	//membercontent.setFont(f);
	    	this.grid.add(membercontent, column+1, row+5);
	    	
	    	Button register=new Button("注册");
	    	//register.setFont(f);
	    	this.grid.add(register, column+2, row+5);
	    }
	    
	    Label vip=new Label("vip等级:");
	  //  vip.setFont(f);
	    this.grid.add(vip, column, row+6);
	    
	    Text vipcontent=new Text(vip_level+"");
	   // vipcontent.setFont(f);
	    this.grid.add(vipcontent, column+1, row+6);
	    
	    Label birth=new Label("生日:");
	    //birth.setFont(f);
	    this.grid.add(birth, column, row+7);
	    
	    Text birthcontent=new Text(birthday);
	    //birthcontent.setFont(f);
	    this.grid.add(birthcontent,column+1, row+7);
	    
	    Button change=new Button("修改");
	    change.setOnMouseClicked((MouseEvent me)->{
	    	this.grid.getChildren().removeAll(birthcontent,namecontent,sextualcontent,phonecontent);
	    	this.grid.getChildren().removeAll(browsecredit,change);
	    	
	    	Button save=new Button("保存");
	    	this.grid.add(save, column+2, row+7);
	    	
	    	Button upload=new Button("上传");
	    	this.grid.add(upload,column+2,row);
	    	upload.setOnMouseClicked((e)->{
	    		
	    	});
	    	TextField birth_content=new TextField();
	    	birth_content.setText(birthcontent.getText());
	    	birth_content.setPrefWidth(100);
	    	//birth_content.setFont(f);
	    	this.grid.add(birth_content, column+1, row+7);
	    	
	    	TextField name_content=new TextField();
	    	//name_content.setFont(f);
	    	name_content.setText(namecontent.getText());
	    	name_content.setPrefWidth(100);
	    	this.grid.add(name_content,column+1, row+1);
	    	
	    	ChoiceBox<String> sextual_content=new ChoiceBox<String>(FXCollections.observableArrayList("男","女"));
	    	//sextual_content.setFont(f);
	    	if(sextualcontent.getText().equals("男"))
	    		sextual_content.getSelectionModel().select(0);
	    	else
	    		sextual_content.getSelectionModel().select(1);
	    	//sextual_content.setPrefWidth(100);
	    	this.grid.add(sextual_content, column+1, row+2);
	    	
	    	TextField phone_content=new TextField();
	    	//phone_content.setFont(f);
	    	phone_content.setText(phonecontent.getText());
	    	phone_content.setPrefWidth(140);
	    	this.grid.add(phone_content,column+1,row+3);
	    	
	    	save.setOnMouseClicked((MouseEvent e)->{
	    		UserBLService user=new bl.user_bl.UserBLServiceImpl();
	    		this.user.setName(name_content.getText());
	    		this.user.setGender(sextual_content.getValue());
	    		this.user.setNumber(phone_content.getText());
	    		this.user.setYear(Integer.parseInt(birth_content.getText().split("-")[0]));
	    		//System.out.println(Integer.parseInt(birth_content.getText().split("-")[0]));
	    		this.user.setMonth(Integer.parseInt(birth_content.getText().split("-")[1]));
	    		this.user.setDay(Integer.parseInt(birth_content.getText().split("-")[2]));
	    		user.update(this.user);
	    	});
	    	
	    });
	    this.grid.add(change, column+2, row+7);
	    this.getChildren().add(grid);
	}
}
