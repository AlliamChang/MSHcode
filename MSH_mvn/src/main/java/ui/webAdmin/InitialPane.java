package ui.webAdmin;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.*;

public class InitialPane extends GridPane{
	private SearchBox searchBox;
	private Button searchButton;
	
	private InitialPane(){
		super();
		searchButton = new Button("查询");
		searchButton.setId("searchButton");
		searchBox = new SearchBox(searchButton);
		
		setAlignment(Pos.CENTER);
		getStylesheets().add(getClass().getResource("/css/InitialPane.css").toExternalForm());
		setHgap(20);
		setVgap(50);
		setPadding(new Insets(20, 20, 20, 20));
		setPrefWidth(200);
		setMaxWidth(Control.USE_PREF_SIZE);
//		setGridLinesVisible(true);
		add(searchBox, 0, 0);
		add(searchButton, 1, 0);
		
		searchButton.setOnAction(event -> {
			System.out.println("Duang!");
		});
	}
	
	private static InitialPane INSTANCE;
	
	public static InitialPane getInstance(){
		return INSTANCE != null ? INSTANCE : (INSTANCE = new InitialPane());
	}
}
