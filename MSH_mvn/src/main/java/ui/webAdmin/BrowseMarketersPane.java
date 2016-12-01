package ui.webAdmin;

import tools.UserType;
import ui.utility.MainPane;
import vo.HotelVO;
import vo.UserVO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.util.Callback;

public class BrowseMarketersPane extends VBox{
	private TableView<UserVO> table;
	private HBox hBox;
	private Button addButton;
	@SuppressWarnings("unchecked")
	public BrowseMarketersPane(){
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setStyle("-fx-border-color: black");
		
		table = new TableView<UserVO>();
		
		table.setItems(FXCollections.observableArrayList(
				new UserVO("NJU_ZXF", "123456", "郑晓峰", "男", "15050582962", UserType.MARKETER, 0, 1000){{setID(1);}}
				));
		
		table.setMaxWidth(600);
		table.setMinHeight(450);
		TableColumn<UserVO, String> IDCol = new TableColumn<UserVO, String>("ID");
		IDCol.setCellValueFactory(new PropertyValueFactory<UserVO, String>("ID"){
			public ObservableValue<String> call(CellDataFeatures<UserVO, String> user){
				return new ReadOnlyObjectWrapper(String.format("%08d", user.getValue().getID()));
			}
		});
		IDCol.setMinWidth(80);
		TableColumn<UserVO, String> nameCol = new TableColumn<UserVO, String>("姓名");
		nameCol.setCellValueFactory(new PropertyValueFactory<UserVO, String>("name"));
		nameCol.setMinWidth(100);
		TableColumn<UserVO, String> numberCol = new TableColumn<UserVO, String>("联系电话");
		numberCol.setCellValueFactory(new PropertyValueFactory<UserVO, String>("number"));
		numberCol.setMinWidth(200);
		numberCol.setSortable(false);
		TableColumn<UserVO, HBox> operation = new TableColumn<UserVO, HBox>("");
		operation.setPrefWidth(95);
		operation.setSortable(false);
		operation.setCellFactory(new Callback<TableColumn<UserVO, HBox>, TableCell<UserVO, HBox> >(){

			@Override
			public TableCell<UserVO, HBox> call(TableColumn<UserVO, HBox> col) {
				return new TableCell<UserVO, HBox>(){
					
					@Override
					protected void updateItem(HBox item, boolean empty){
						if (!empty){
							item = new HBox();
							item.setSpacing(5);
							Button modefyButton = new Button("修改");
							Button delButton = new Button("删除");
							modefyButton.setPadding(new Insets(2, 5, 2, 5));
							delButton.setPadding(new Insets(2, 5, 2, 5));
							delButton.setOnAction(e -> {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.getDialogPane().setHeaderText(null);
								alert.getDialogPane().setContentText("确认删除？");
								alert.showAndWait().filter(response -> response == ButtonType.OK)
									.ifPresent(response -> {
										table.getItems().remove(this.getTableRow().getIndex());
									});
							});
							item.getChildren().addAll(modefyButton, delButton);
						} else
							item = null;
						setGraphic(item);
					}
				};
			}
			
		});
		
		
		
		table.getColumns().addAll(IDCol, nameCol, numberCol, operation);
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
