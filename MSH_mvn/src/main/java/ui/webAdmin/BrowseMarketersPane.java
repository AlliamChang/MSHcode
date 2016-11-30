package ui.webAdmin;

import tools.UserType;
import vo.UserVO;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class BrowseMarketersPane extends VBox{
	private TableView<UserVO> table;
	private HBox hBox;
	private Button addButton;
	@SuppressWarnings("unchecked")
	public BrowseMarketersPane(){
		table = new TableView<UserVO>();
		
		table.setItems(FXCollections.observableArrayList(
				new UserVO("NJU_ZXF", "123456", "郑晓峰", "男", "15050582962", UserType.MARKETER, 0, 1000){{setID(1);}}
				));
		
		table.setMaxWidth(600);
		table.setMinHeight(450);
		TableColumn<UserVO, Integer> IDCol = new TableColumn<UserVO, Integer>("ID");
		IDCol.setCellValueFactory(new PropertyValueFactory<UserVO, Integer>("ID"));
		IDCol.setMinWidth(80);
		TableColumn<UserVO, Integer> nameCol = new TableColumn<UserVO, Integer>("姓名");
		nameCol.setCellValueFactory(new PropertyValueFactory<UserVO, Integer>("name"));
		nameCol.setMinWidth(100);
		TableColumn<UserVO, Integer> numberCol = new TableColumn<UserVO, Integer>("联系电话");
		numberCol.setCellValueFactory(new PropertyValueFactory<UserVO, Integer>("number"));
		numberCol.setMinWidth(398);
		table.getColumns().addAll(IDCol, nameCol, numberCol);
		addButton = new Button("添加");
		addButton.setPadding(new Insets(10, 30, 10, 30));
		addButton.setStyle("-fx-font-size: 17px");
		addButton.setOnAction(e -> {
			table.getItems().add(new UserVO("afdd", "123456", "郑皓铭", "男", "10086", UserType.MARKETER, 0, 1000){{setID(2);}});
		});
		hBox = new HBox();
		hBox.getChildren().add(addButton);
		hBox.setAlignment(Pos.CENTER_RIGHT);
		hBox.setPadding(new Insets(0, 50, 0, 0));
		
		setAlignment(Pos.TOP_CENTER);
		setPadding(new Insets(50, 0, 0, 0));
		setSpacing(20);
		getChildren().addAll(table, hBox);
	}
	
}
