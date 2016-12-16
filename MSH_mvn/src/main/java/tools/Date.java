package tools;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {
	
	private boolean hasTime;
	private String date;
	private int year,month,day;
	private int hour,minute,second;
	private LocalDate l;
	private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	public Date(String date,boolean hasTime){
		this.date = date;
		this.hasTime = hasTime;
		String dateTemp;
		if(date != null){
			if(hasTime){
				String[] temp2 = date.split(" ");
				dateTemp = temp2[0];
				if(temp2.length == 2){
					String[] time = temp2[1].split(":");
					hour = Integer.valueOf(time[0]);
					minute = Integer.valueOf(time[1]);
					second = Integer.valueOf(time[2]);
				}
			}else{
				dateTemp = date.trim();
			}
			String[] temp = dateTemp.split("/");
			year = Integer.valueOf(temp[0]);
			month = Integer.valueOf(temp[1]);
			day = Integer.valueOf(temp[2]);
		}
	}

	public static String now(){
		return LocalDate.now().format(f);
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return hasTime?date:null;
	}
	
	public LocalDateTime getLocalDateTime(){
		return hasTime?LocalDateTime.of(year, month, day, hour, minute, second):null;
	}
	
	public LocalDate getLocalDate(){
		return LocalDate.of(year, month, day);
	}
	
	public String plus(int days){
		l = LocalDate.of(year, month, day);
		return l.plusDays(days).format(f);
	}
}
