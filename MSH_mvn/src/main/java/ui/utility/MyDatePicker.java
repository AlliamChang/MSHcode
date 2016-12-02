package ui.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
import javafx.util.StringConverter;
import tools.Date;

public class MyDatePicker extends DatePicker{

	private final String pattern = "yyyy/MM/dd";
	private boolean show = false;

	public MyDatePicker (){
		super();
		this.setEditable(false);
		StringConverter converter = new StringConverter<LocalDate>() {
	           DateTimeFormatter dateFormatter =
	                   DateTimeFormatter.ofPattern(pattern);
	               @Override
	               public String toString(LocalDate date) {
	                   if (date != null) {
	                       return dateFormatter.format(date);
	                   } else {
	                       return "";
	                   }
	               }
	     
	               @Override
	               public LocalDate fromString(String string) {
	                   if (string != null && !string.isEmpty()) {
	                       return LocalDate.parse(string, dateFormatter);
	                   } else {
	                       return null;
	                   }
	               }
	     };
	     
	     this.setConverter(converter);
	     this.getEditor().setStyle("-fx-font-size:13");
	     
	     this.getEditor().setOnMouseClicked(event -> {
	    	 if(!show){
	    		 this.show();
	    	 }
    		 show = !show;
	     });
	     this.setOnHiding(event -> {
	    	 if(show){
	    		 show = !show;
	    	 }
	     });
	     
	}
	
	public MyDatePicker(String date){
		this();
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                            
	                            LocalDate temp = LocalDate.of(Integer.valueOf(date.split("/")[0]),Integer.valueOf(date.split("/")[1]),Integer.valueOf(date.split("/")[2]));
	                            	if (item.isBefore(temp.plusDays(1)) ) {
	                            			setDisable(true);
	                                    	setStyle("-fx-background-color: rgb(30,170,255);");
	                                    
	                            	}   
	                            
	                    }
	                };
	            }
	        };
	        
	        this.setDayCellFactory(dayCellFactory);
	}
	
	public void setBeforeDisable(DatePicker checkInPicker){
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                            if(checkInPicker.getValue() != null)
	                            	if (item.isBefore(checkInPicker.getValue().plusDays(1)) ) {
	                            			setDisable(true);
	                                    	setStyle("-fx-background-color: rgb(30,170,255);");
	                                    
	                            	}   
	                            
	                    }
	                };
	            }
	        };
	    
	        this.setDayCellFactory(dayCellFactory);
	        checkInPicker.setOnAction(event -> {
	        	if(MyDatePicker.this.getValue() != null) 
	        		if(checkInPicker.getValue().plusDays(1).isAfter(MyDatePicker.this.getValue())){
	        			MyDatePicker.this.setValue(null);
	        		}
	        });
	}
	
}
