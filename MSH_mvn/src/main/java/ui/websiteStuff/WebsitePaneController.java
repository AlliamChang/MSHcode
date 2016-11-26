package ui.websiteStuff;

import ui.utility.*;

public class WebsitePaneController {
	private static WebsitePaneController controller;
	
	private WebsitePaneController(){
		
	}
	
	public static WebsitePaneController getInstance(){
		if(controller==null)
			controller=new WebsitePaneController();
		return controller;
	}
	
	

}
