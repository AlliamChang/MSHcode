package ui.utility;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyImageView extends ImageView {
	public MyImageView(Image image){
		super(image);
		if (image == null)
			this.setImage(new Image(getClass().getResource("/image/用户.png").toExternalForm()));
	}
}
