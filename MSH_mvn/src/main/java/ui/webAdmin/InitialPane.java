package ui.webAdmin;

import ui.utility.MainPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class InitialPane extends GridPane{
	private ImageView imageView;
	private SearchBox searchBox;
	private Button searchButton;
	
	public InitialPane(){
		super();
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);

		setStyle("-fx-border-color: black");
		searchButton = new Button("查询");
		searchButton.setId("searchButton");
		searchBox = new SearchBox(searchButton);
		HBox hBox = new HBox();
		imageView = new ImageView(new Image(getClass().getResource("/image/默认头像1.png").toExternalForm()));
		hBox.getChildren().add(imageView);
		hBox.setAlignment(Pos.CENTER);
		
		setAlignment(Pos.TOP_CENTER);
		getStylesheets().add(getClass().getResource("/css/InitialPane.css").toExternalForm());
		setHgap(20);
		setVgap(50);
		setPadding(new Insets(20, 20, 20, 20));
		setPrefWidth(200);
		setMaxWidth(Control.USE_PREF_SIZE);
		
		add(hBox, 0, 0, 2, 1);
		add(searchBox, 0, 1);
		add(searchButton, 1, 1);
		
		searchButton.setOnAction(e -> {
			WebAdminController.getInstance().search(searchBox.getContent());
		});
	}
}
