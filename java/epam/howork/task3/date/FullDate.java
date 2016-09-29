package epam.howork.task3.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FullDate {

	static SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");

	
	private static String fullDate = time.format(new Date()) + " " + date.format(new Date());

	public static String getFullDate() {
		return fullDate;
	}
}
