package ui.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

public class MyDatePicker extends DatePicker{

	private final String pattern = "yyyy/MM/dd";
	
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
	}
}
