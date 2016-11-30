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
	time.setMinWidth(150);
	time.setCellValueFactory(new PropertyValueFactory("date"));
	
	
	TableColumn credit_change=new TableColumn("信用值变化");
	credit_change.setCellValueFactory(new PropertyValueFactory("change"));
	credit_change.setMinWidth(150);
	
	TableColumn change_reason=new TableColumn("原因");
	change_reason.setCellValueFactory(new PropertyValueFactory("reason"));
	change_reason.setMinWidth(150);
	this.setItems(data);
	this.setHeight(400);
	this.getColumns().addAll(time,credit_change,change_reason);
}
	
}
