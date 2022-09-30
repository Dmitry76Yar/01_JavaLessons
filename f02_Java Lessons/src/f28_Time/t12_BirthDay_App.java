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
import java.time.temporal.ChronoUnit;

public class t12_BirthDay_App {
public static void main(String[] args) {
	
	LocalDate birthday  = LocalDate.of(1984, 10, 23);
	LocalDate nextBirthday  = birthday.withYear(Year.now().getValue());
	LocalDate today  = LocalDate.now();
	if ((nextBirthday.isBefore(today)) || (nextBirthday.isEqual(today)))
		nextBirthday.plusYears(1);
	System.out.println("Дата твоего рождения - " +  birthday.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
	System.out.println("Следующий День твоего рождения - " +  nextBirthday.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
	
	if (birthday.isAfter(LocalDate.now())) System.out.println("Ты еще не родился!");

	DayOfWeek birthDayOfWeek =  birthday.getDayOfWeek(); 
	System.out.println("Ты родился в " + birthDayOfWeek + ".");
	
	Period p = Period.between(birthday, today);
	long p2 = ChronoUnit.DAYS.between(birthday, today);
	System.out.println("Тебе " + p.getYears() + " лет, " + p.getMonths() +
            " месяцев и  " + p.getDays() + " дней. (" + p2 + " всего дней от даты рождения)");
	
	Period per = Period.between(today, nextBirthday);
	long p1 = ChronoUnit.DAYS.between(today, nextBirthday);
	System.out.println("До твоего следующего Дня Рождения  - " + per.getMonths() + " месяцев и " +
            per.getDays() + " дней. (" + p1 + " всего дней)");
	}					
}
        
        
  