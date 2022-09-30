package f28_Time;

/* Класс Time - Наиболее удобный и современный способ работы с датой и временем 
 * В него входят следующие классы:
	LocalTime A time (hours, minutes, and seconds to nanosecond precision) without an associated time zone.
	LocalDate A date (year, month, and day) without an associated time zone.
	LocalDateTime A date and time without an associated time zone.
	OffsetTime A time and an offset from UTC (Coordinated Universal Time, also known as Greenwich
	Mean Time), such as 12:30:00-8.00, which means the time is 12:30 with an offset of
	-8 hours from UTC.
	OffsetDateTime A date and time with an offset value from UTC.
	ZonedDateTime A date and time with an associated time zone, such as America/Los_Angeles.
	MonthDay A month and day without an associated year. You can use a MonthDay object to
	represent a date such as a birthday, anniversary, or holiday.
	YearMonth A year and month, such as December, 2015. No day, time, or time zone values are
	associated with the year and month.
	Year A year, such as 2038. No month, day, time, or time zone values are associated
	with the year.
	Instant A single point of time, represented internally as the number of nanoseconds that have
	elapsed since midnight, January 1, 1970. The value assumes a UTC/GMT time offset of 0.
 * */

import java.time.*;
import java.time.format.DateTimeFormatter;

public class t11_DataTimeFormatter {
public static void main(String[] args) {
	/* Format pattern Explanation
		y Year (two or four digits)
		M Month (one or two digits or three or more letters)
		d Day of month (such as 1, 28)
		H Hour
		m Minute
		s Second (0 to 59)
		h Clock hour (1 to 12)
		a AM or PM
		V Time zone ID (such as America/Los_Angeles)
		z Time zone name (such as Pacific Daylight Time)  */
	
	LocalDate date = LocalDate.of(2021, 02, 11);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM YYYY");
	String formattedDate = date.format(formatter);
	System.out.print("date = " + formattedDate + "\t\t");
	System.out.print("date = " + date.format(DateTimeFormatter.ofPattern("dd-MM-YY"))  + "\t\t");
	System.out.println("date = " + date.format(DateTimeFormatter.ofPattern("YYYY.MM.dd"))  + "\t\t");
	
	LocalDateTime dateTime = LocalDateTime.of(2021, 02, 11, 5, 00, 00);
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MMM YYYY HH:mm:ss");
	String formattedDate1 = dateTime.format(formatter1);
	System.out.print("dateTime = " + formattedDate1 + "\t\t");
	System.out.print("dateTime = " + dateTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\t\t");
	
	}					
}
        
        
  