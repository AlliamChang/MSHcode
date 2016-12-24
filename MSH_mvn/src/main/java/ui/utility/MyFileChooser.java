package ui.utility;

import java.io.File;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class MyFileChooser{

	private final FileChooser fileChooser;
	
	public MyFileChooser(){
		fileChooser = new FileChooser();
		fileChooser.setTitle("上传图片");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        );                 
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Images", "*.jpg","*.png"),
            new FileChooser.ExtensionFilter("JPG", "*.jpg"),
            new FileChooser.ExtensionFilter("PNG", "*.png")
        );
	}
	
	public Image showOpenDialog(){
		File file = fileChooser.showOpenDialog(MainPane.getInstance().getStage());
		if (file != null) {
            return new Image("file:"+file.getPath().replace('\\', '/'));
        }else{
        	return null;
        }
	}
	
}
