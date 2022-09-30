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
import java.time.format.TextStyle;
import java.util.Locale;

public class t07_DayOfWeek {
public static void main(String[] args) {
	/* Перечисление DayOfWeek состоит из семи констант, описывающих дни недели. Целочисленные значения для констант начинаются с 1
	 *  (Понедельник) и заканчиваются 7 (Воскресенье).
		MONDAY  (понедельник, 1)
		TUESDAY  (вторник, 2)
		WEDNESDAY  (среда, 3)
		THURSDAY  (четверг, 4)
		FRIDAY  (пятница, 5)
		SATURDAY  (суббота, 6)
		SUNDAY  (воскресенье, 7)			 */
	
		//Инициализация
	DayOfWeek dow = DayOfWeek.SATURDAY;
	DayOfWeek dow2 = DayOfWeek.MONDAY;
	System.out.println(dow.toString());
	
		// Изменение через int
	System.out.println("Изменение через int    dow.of(2) = " + dow.of(2));		 dow = DayOfWeek.SATURDAY;	

		/* Метод String getDisplayName(TextStyle style, Locale locale)  для получения названий дней недели в соответствии 
	с региональными настройками пользователя. Перечисление java.time.format.TextStyle  позволяет указать тип строки: 
	FULL, NARROW  (обычно одна буква), SHORT  (аббревиатура). */
	Locale locale = Locale.getDefault();
	System.out.print("Название дней недели в соответствии региональными настройками пользователя:    ");
	System.out.print(dow.getDisplayName(TextStyle.FULL, locale) + "\t");
	System.out.print(dow.getDisplayName(TextStyle.NARROW, locale)  + "  \t");
	System.out.print(dow.getDisplayName(TextStyle.SHORT, locale)  + "\t");			System.out.println();
	
		// Метод compareTo(dow2) возвращает разницу в днях между указанными днями
	System.out.println("DayOfWeek.SATURDAY.compareTo(DayOfWeek.MONDAY) - "  + dow.compareTo(dow2));
	System.out.println("DayOfWeek.MONDAY.compareTo(DayOfWeek.SATURDAY) - "  + dow2.compareTo(dow));
		
		// Метод minus(int x) и plus(int x) возвращает день недели с вычеитом или плюсом к указанному дню
	System.out.println("DayOfWeek.SATURDAY.minus(1) - "  + dow.minus(1));
	System.out.println("DayOfWeek.SATURDAY.plus(1) - "  + dow.plus(1));
	
	}					
}
        
        
  