package util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Usefull {
	 public static String uniqueID(){
		 return UUID.randomUUID().toString();
	 }
	 public static Date currentDate() {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		return calendar.getTime();
	 }
}
