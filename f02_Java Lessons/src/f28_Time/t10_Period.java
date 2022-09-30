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

public class t10_Period {
public static void main(String[] args) {
	
		// Класс java.time.Period определяет период времени в человеческих единицах: месяцах, днях, годах. 
	/* В отличии от класса Duration в Period НЕТ ВРЕМЕНИ
	 * Класс java.time.Period содержит методы getMonths, getDays, getYears, которые используются для получения соответствующих
	   единиц времени из периода.Duration bспользуется для измерения промежутка времени между двумя машинными временными
	   объектами */
	
		// Инициализация через метод between
	LocalDate currentDate = LocalDate.of(2021, 02, 11);
	LocalDate currentDate1 = LocalDate.of(2022, 03, 17);
	System.out.println("currentDate = " + currentDate);
	System.out.println("currentDate = " + currentDate1);
	Period period = Period.between(currentDate1, currentDate);
	System.out.println("Промежуток между двумя объектрами дат  - "  + period.toString());
		// Инициализация через метод of(int time)
	Period period1 = Period.ofDays(20).plusMonths(11).plusYears(1);
	System.out.println("Инициализация через метод of(int time) - "  + period1.toString());

	// Методы GET
	period1 = Period.ofDays(20).plusMonths(11).plusYears(1);
	System.out.println("duration1.getSeconds() - "  + period1.getDays());
	System.out.println("duration1.getSeconds() - "  + period1.getMonths());
		// Методы getUnits() - возвращает List c единицами год, месяц и день, если они поддерживаются этим period
	System.out.println(period1.getUnits());
	
		// Расчет возраста в годах, месяцах, днях
	System.out.println("\t Расчет возраста в годах, месяцах, днях");
	LocalDate birthday  = LocalDate.of(1984, 10, 23);
	LocalDate today  = LocalDate.now();
	System.out.println("birthday = " +  birthday);
	System.out.println("today = " +  today);
	Period p = Period.between(birthday, today);
	long p2 = ChronoUnit.DAYS.between(birthday, today);
	System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
            " months, and " + p.getDays() + " days old. (" + p2 + " days total)");
	
		// Расчет сколько осталось до следующего дня рождения
	System.out.println("\t Расчет сколько осталось до следующего дня рождения");
	LocalDate birthday1  = LocalDate.of(1984, 10, 23);
	LocalDate nextBirthday  = birthday1.withYear(Year.now().getValue());
	LocalDate today1  = LocalDate.now();
	System.out.println("birthday1 = " +  birthday1);
	System.out.println("nextBirthday = " +  nextBirthday);
	if ((nextBirthday.isBefore(today1)) || (nextBirthday.isEqual(today1)))
		nextBirthday.plusYears(1);
	Period per = Period.between(today, nextBirthday);
	long p1 = ChronoUnit.DAYS.between(today, nextBirthday);
	System.out.println("There are " + per.getMonths() + " months, and " +
            per.getDays() + " days until your next birthday. (" + p1 + " total)");
	
	}					
}
        
        
  