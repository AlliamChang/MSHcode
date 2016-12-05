package ui.webAdmin;

import ui.utility.MainPane;
import vo.UserVO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.util.Callback;

public class BrowseMarketersPane extends VBox{
	private TableView<UserVO> table;
	private HBox hBox;
	private Button addButton;
	@SuppressWarnings("unchecked")
	public BrowseMarketersPane(){
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setStyle("-fx-border-color: black");
		
		table = new TableView<UserVO>();
		table.setItems(WebAdminController.getInstance().getAllMarketers());
		table.setMaxWidth(600);
		table.setMinHeight(450);
		
		TableColumn<UserVO, String> IDCol = new TableColumn<UserVO, String>("ID");
		IDCol.setCellValueFactory(new PropertyValueFactory<UserVO, String>("ID"){
			public ObservableValue<String> call(CellDataFeatures<UserVO, String> user){
				return new ReadOnlyObjectWrapper<String>(String.format("%08d", user.getValue().getID()));
			}
		});
		IDCol.setMinWidth(80);
		TableColumn<UserVO, String> nameCol = new TableColumn<UserVO, String>("姓名");
		nameCol.setCellValueFactory(new PropertyValueFactory<UserVO, String>("name"));
		nameCol.setMinWidth(100);
		TableColumn<UserVO, String> genderCol = new TableColumn<UserVO, String>("性别");
		genderCol.setCellValueFactory(new PropertyValueFactory<UserVO, String>("gender"));
		genderCol.setMinWidth(50);
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
							modefyButton.setOnAction(e ->
								WebAdminController.getInstance()
								.setModifyUserInfo(table.getItems().get(getTableRow().getIndex()), BrowseMarketersPane.this));
							delButton.setOnAction(e -> {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.initModality(Modality.APPLICATION_MODAL);
								alert.getDialogPane().setHeaderText(null);
								alert.getDialogPane().setContentText("确认删除？");
								alert.showAndWait().filter(response -> response == ButtonType.OK)
									.ifPresent(response -> {
										WebAdminController.getInstance().deleteUser(table.getItems().get(getTableRow().getIndex()));
										table.getItems().remove(getTableRow().getIndex());
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
		
		table.getColumns().addAll(IDCol, nameCol, genderCol, numberCol, operation);
		addButton = new Button("添加");
		addButton.setPrefSize(80, 30);
		addButton.setOnAction(e -> WebAdminController.getInstance().setAddMarketerPane());
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
