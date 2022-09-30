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
import java.time.temporal.ChronoUnit;

public class t09_Duration {
public static void main(String[] args) {
	
		// Скорость работы программы
	Instant start = Instant.now();
		int a = 1;
		for (int i = 1; i<10000000; i++) a++; 
	Instant finish = Instant.now();
	long timeSpent = finish.getNano() - start.getNano();
	System.out.println("Время работы программы - " + timeSpent + " наносекунд");
	System.out.println("Время работы программы - " + timeSpent/1000000 + " миллисекунд");
	System.out.println("Время работы программы - " + (double)timeSpent/1000000000 + " секунд");
	
	
	System.out.println("-------------------------------Класс Duration-------------------------------------");
		// Класс Duration используется для измерения промежутка времени между двумя машинными временными объектами
	/* Для манипуляции в привычных единицах для человека (дни, годы) лучше использовать класс  PERIOD
	 * Duration  не связана с датой и временем, он не хранит информацию о зонах и переходе на летнее/зимнее время. 
	  Добавление Duration, эквивалентного 1 дню, к ZonedDateTime  добавит ровно 24 часа, независимо от часового пояса
      и зимнего/летнего времени.   */
	
		// Инициализация через метод between
	LocalDateTime currentDateTime = LocalDateTime.of(2021, 02, 11, 5, 00, 00);
	LocalDateTime currentDateTime1 = LocalDateTime.of(2021, 02, 10, 00, 00, 00);
	System.out.println("currentDateTime = " + currentDateTime);
	System.out.println("currentDateTime1 = " + currentDateTime1);
	Duration duration = Duration.between(currentDateTime1, currentDateTime);
	System.out.println("Промежуток между двумя объектрами времени в секундах - "  + duration.toSeconds());
	System.out.println("Промежуток между двумя объектрами времени в часах - "  + duration.toHours());
	System.out.println("Промежуток в днях округляется к целому  - "  + duration.toDays() );
		// Инициализация через метод of (int amount, ChronoUnit.xxx)
	Duration duration1 = Duration.of(1, ChronoUnit.DAYS);
	System.out.println("нициализация через метод of(1, ChronoUnit.DAYS) - "  + duration1.toHours());
		// Инициализация через метод ofDays (int days)
	duration1 = Duration.ofDays(1);
	System.out.println("Инициализация через метод of(1, ChronoUnit.DAYS) - "  + duration1.toHours());
	duration1 = Duration.ofHours(10);
	System.out.println("Инициализация через метод of(1, ChronoUnit.DAYS) - "  + duration1.toHours());
		
		// Методы GET
	duration1 = Duration.ofHours(10);
	System.out.println("duration1.getSeconds() - "  + duration1.getSeconds());
	System.out.println("duration1.getSeconds() - "  + duration1.get(ChronoUnit.SECONDS));
		// Методы getUnits() - возвращает List c единицами секунды и наносекунды, если они поддерживаются этим duration
	duration1 = Duration.ofDays(10);
	System.out.println(duration.getUnits());
	
		// Расчет возраста в годах, месяцах, днях
		// Не удобный, т.к.может выдавать только в днях
	LocalDateTime birthday  = LocalDateTime.of(1984, 10, 23, 00,00,00);
	LocalDateTime today  = LocalDateTime.now();
	System.out.println("birthday = " +  birthday);
	System.out.println("today = " +  today);
	Duration duration2 = Duration.between(birthday, today);
	System.out.println("Твой возраст в днях" + duration2.toDays());
	
	
	}					
}
        
        
  