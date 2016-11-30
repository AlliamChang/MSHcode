package ui.customer;

import java.util.Arrays;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EvaluatePane {
	private GridPane pane;
	private static final String user_name="angel"; 
	private static final int column_index=1;
	private static final int row_index=8;
	private String begin_time="2016/10/01";
	private String check_out_time="2016/10/07";
	private String room_type="大床房";
	private int number=1;
	private int score;
	private String content;
	private String price="¥560";
	private MyNavigationBar navi;
	private Image scul;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	
	public EvaluatePane(){
		this.initPane();
		this.init();
	}
	
	private void init(){
		navi = new MyNavigationBar(scul,Arrays.asList("用户名："+user_name));
		MainPane.getInstance().getChildren().clear();
		MainPane.getInstance().getChildren().addAll(navi,pane);
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setHgap(20);
		pane.setVgap(22);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		
		Label order_info=new Label("订单信息");
		order_info.setFont(f);
		pane.add(order_info,column_index,row_index);
		
		Label start_time=new Label("开始时间:");
		start_time.setFont(f);
		pane.add(start_time,column_index+1,row_index+1);
		
		Label begin=new Label(begin_time);
		begin.setFont(f);
		pane.add(begin,column_index+2,row_index+1);
		
		Label end_time=new Label("退房时间:");
		end_time.setFont(f);
		pane.add(end_time,column_index+3, row_index+1);
		
		Label check_out=new Label(check_out_time);
		check_out.setFont(f);
		pane.add(check_out,column_index+4,row_index+1);
		
		Label RoomType=new Label("房间类型:");
		RoomType.setFont(f);
		pane.add(RoomType,column_index+1,row_index+2);
		
		Label room=new Label(room_type);
		room.setFont(f);
		pane.add(room, column_index+2, row_index+2);
		
		Label num=new Label("数量:");
		num.setFont(f);
		pane.add(num, column_index+3, row_index+2);
		
		Label Num=new Label(number+"");
		Num.setFont(f);
		pane.add(Num, column_index+4, row_index+2);
		
		Label Price=new Label("价格:");
		Price.setFont(f);
		pane.add(Price,column_index+1,row_index+3);
		
		Label p=new Label(price);
		p.setFont(f);
		pane.add(p,column_index+2,row_index+3);
		
		Label score=new Label("评分");
		score.setFont(f);
		pane.add(score, column_index, row_index+4);
		
		TextField grade=new TextField();
		grade.setFont(f);
		pane.add(grade,column_index+1,row_index+4);
		
		Label content=new Label("评价内容");
		content.setFont(f);
		pane.add(content, column_index, row_index+5);
		
		TextArea evaluate=new TextArea();
		evaluate.setFont(f);
		pane.add(evaluate,column_index+1,row_index+5,4,1);
		
		Button upload=new Button("确定");
		upload.setFont(f);
		upload.setOnMouseClicked((MouseEvent me)->{
			
		});
		pane.add(upload, column_index+5, row_index+7);
		
		Button cancel=new Button("取消");
		cancel.setFont(f);
		cancel.setOnMouseClicked((MouseEvent me)->{
			
		});
		pane.add(cancel,column_index+5,row_index+8);
	}
}
