package tools;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {
	
	private boolean hasTime;
	private String date;
	private int year,month,day;
	private LocalDate l;
	private final DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	public Date(String date,boolean hasTime){
		this.date = date;
		this.hasTime = hasTime;
		if(!hasTime){
			String[] temp = date.split("/");
			year = Integer.valueOf(temp[0]);
			month = Integer.valueOf(temp[1]);
			day = Integer.valueOf(temp[2]);
		}
	}

	public String getDate(){
		return date;
	}
	
	public LocalDate getLocalDate(){
		return LocalDate.of(year, month, day);
	}
	
	public String plus(int days){
		l = LocalDate.of(year, month, day);
		return l.plusDays(days).format(f);
	}
}
