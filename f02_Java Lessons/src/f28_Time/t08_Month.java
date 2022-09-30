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

public class t08_Month {
public static void main(String[] args) {
	/* Перечисление java.time.Month  содержит константы для двенадцати месяцев, пронумерованных от 1 до 12:
		JANUARY  (январь, 1)
		FEBRUARY  (февраль, 2)
		MARCH  (март, 3)
		APRIL  (апрель, 4)
		MAY  (май, 5)
		JUNE  (июнь, 6)
		JULY  (июль, 7)
		AUGUST  (август, 8)
		SEPTEMBER  (сентябрь, 9)
		OCTOBER  (октябрь, 10)
		NOVEMBER  (ноябрь, 11)
		DECEMBER  (декабрь, 12)			 */
	
		//Инициализация
	Month month = Month.AUGUST;
	Month month2 = Month.DECEMBER;
	System.out.println(month.toString());
	
		// Изменение через int
	System.out.println("Изменение через int    month.of(2) = " + month.of(2));		 month2 = Month.DECEMBER;	

		/* Метод String getDisplayName(TextStyle style, Locale locale)  для получения название месяца в соответствии 
	с региональными настройками пользователя. Перечисление java.time.format.TextStyle  позволяет указать тип строки: 
	FULL, NARROW  (обычно одна буква), SHORT  (аббревиатура). */
	Locale locale = Locale.getDefault();
	System.out.print("Название дней недели в соответствии региональными настройками пользователя:    ");
	System.out.print(month.getDisplayName(TextStyle.FULL, locale) + "\t");
	System.out.print(month.getDisplayName(TextStyle.NARROW, locale)  + "  \t");
	System.out.print(month.getDisplayName(TextStyle.SHORT, locale)  + "\t");			System.out.println();
	
		// Метод length(boolean leap) возвращает длину месяца для високосного или нет года
	System.out.println("Метод length(boolean leap)     Длина месяца Month.FEBRUARY для невисосного года - " + 
			Month.FEBRUARY.length(false));
	System.out.println("Метод length(boolean leap)     Длина месяца Month.FEBRUARY для висосного года - " + 
			Month.FEBRUARY.length(true));

		// Метод maxLength()  возвращает максимально возможное количество дней в месяце (по сути для високосного года)
	System.out.println("Метод maxLength()        Максимальная длина месяца Month.FEBRUARY = " + Month.FEBRUARY.maxLength());
	
		// Метод minLength()  возвращает минимально возможное количество дней в месяце (по сути для невисокосного года)
	System.out.println("Метод minLength()        Минимальная длина месяца Month.FEBRUARY = " + Month.FEBRUARY.minLength());
		
		// Метод compareTo(dow2) возвращает разницу в месяцах между указанными месяцами
	System.out.println("Метод compareTo(dow2)    Month.AUGUST.compareTo(Month.DECEMBER) - "  + month.compareTo(month2));
	System.out.println("Метод compareTo(dow2)    Month.DECEMBER.compareTo(Month.AUGUST) - "  + month2.compareTo(month));
		
		// Метод minus(int x) и plus(int x) возвращает день недели с вычеитом или плюсом к указанному дню
	System.out.println("Метод minus(int x)   Month.AUGUST.minus(1) - "  + month.minus(1));
	System.out.println("Метод plus(int x)    Month.AUGUST.plus(1) - "  + month.plus(1));
		
		// Метод firstDayOfYear(leapYear) возвращает порядковый номер 1-го дня указанного месяца. Параметр  - високосный или нет год
	System.out.println("Метод firstDayOfYear(leapYear)       Порядковый номер 1-го дня Month.AUGUST невисокосного года - " + 
		month.firstDayOfYear(false));
		
		// Метод firstMonthOfQuarter() возвращает 1-ый месяц квартала, в который входит указанный месяц
	System.out.println("Метод month.firstMonthOfQuarter()    1-ый месяц квартала, в который входит Month.AUGUST - "
			+ month.firstMonthOfQuarter());
	
		// Метод int getValue() возвращает номер указанного месяца
	System.out.println("Метод int getValue()     Номер месяца Month.AUGUST  - " + month.getValue());
	
	}					
}
        
        
  