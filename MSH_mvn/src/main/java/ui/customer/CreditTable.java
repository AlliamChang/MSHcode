package ui.customer;


import java.util.List;

import vo.CreditVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

public class CreditTable extends TableView{
	private final ObservableList<CreditVO> data;
	private int width=150;
	public CreditTable(List<CreditVO> list){
		super();
		data = FXCollections.observableArrayList();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		this.init();
	}
	
	public void init(){
		
	TableColumn time=new TableColumn("时间");
	time.setMinWidth(width);
	time.setCellValueFactory(new PropertyValueFactory("date"));
	
	
	TableColumn credit_change=new TableColumn("信用值变化");
	credit_change.setCellValueFactory(new PropertyValueFactory("change"));
	credit_change.setMinWidth(width);
	
	TableColumn change_reason=new TableColumn("原因");
	change_reason.setCellValueFactory(new PropertyValueFactory("reason"));
	change_reason.setMinWidth(width);
	this.setItems(data);
	
	this.getColumns().addAll(time,credit_change,change_reason);
}
	
}
