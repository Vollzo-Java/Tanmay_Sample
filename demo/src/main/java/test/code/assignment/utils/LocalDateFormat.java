package test.code.assignment.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateFormat {

	public static LocalDate dateFormat(LocalDate dt) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate parsedDate = LocalDate.parse(dt.format(formatters), formatters);

		return parsedDate;
	}
	
	public static String dateFormatString(Timestamp month1) {
		  
		String date =  new SimpleDateFormat("dd-MMM-yyyy").format(month1);
		    
		return date;
	}
}
