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
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

public class t04_LocalDateTime_and_LocalTime {
public static void main(String[] args) {
	
						// Класс LocalDateTime  - хранит дату и время
	// Класс является нечтом вроде комбинации LocalDate  и LocalTime.  
	System.out.println("\t\t\t Класс LocalDateTime");
	
		// Инициализация методом now() для текущей даты
	LocalDateTime currentDateTime = LocalDateTime.now();
	System.out.println("Дата и время в классе LocalDateTime - "  + currentDateTime.toString());
	
		// Инициализация методом of(int year, int month, int dayOfMonth, int hour, int minute)
	LocalDateTime currentDateTime1 = LocalDateTime.of(2022, 02, 20, 10, 00);
	System.out.println("Метод of(year, month, dayOfMonth, hour, minute)  - "  + currentDateTime1.toString());
		// Инициализация методом of(int year, Month month, int dayOfMonth, int hour, int minute)
	LocalDateTime currentDateTime2 = LocalDateTime.of(2022, Month.AUGUST, 20, 10, 00);
	System.out.println("Метод of(year, Month month, dayOfMonth, hour, minute)  - "  + currentDateTime2.toString());
		// Инициализация методом of(int year, Month month, int dayOfMonth, int hour, int minute, int sec)
	LocalDateTime currentDateTime3 = LocalDateTime.of(2022, Month.AUGUST, 20, 10, 00, 01);
	System.out.println("Метод of(year, int month, dayOfMonth, hour, minute, sec)  - "  + currentDateTime3.toString());
		// Инициализация методом of(int year, Month month, int dayOfMonth, int hour, int minute, int sec, int nanoOfSecond)
	LocalDateTime currentDateTime4 = LocalDateTime.of(2022, Month.AUGUST, 20, 10, 00, 01, 9999);
	System.out.println("Метод of(year, int month, dayOfMonth, hour, minute, sec, nanoOfSecond)  - "  + currentDateTime4.toString());
	
		// Инициализация методом parse(String str) 
	LocalDateTime dateTime = LocalDateTime.parse("2007-12-03T10:15:30");
	try {
		System.out.println("Метод parse()  - " + currentDateTime.toString());}
	catch (DateTimeParseException ex) {
		System.out.println(ex.toString());	}
	System.out.println("Инициализация методом parse(String str) " + dateTime);
	
		// Методы GET
	dateTime = LocalDateTime.parse("2007-12-03T10:15:30");
	System.out.println("\t\t Методы GET для 2007-12-03T10:15:30");
	System.out.print("\t date.getDayOfMonth() = " + dateTime.getDayOfMonth());
	System.out.print("\t date.getDayOfYear() = " + dateTime.getDayOfYear());
	System.out.println("\t date.getMonthValue() = " + dateTime.getMonthValue());
	System.out.print("\t date.getMonth() = " + dateTime.getMonth());
	System.out.print("\t date.getDayOfWeek() = " + dateTime.getDayOfWeek());
	System.out.println("\t date.getHour() = " + dateTime.getHour());
	System.out.println("\t date.getMinute() = " + dateTime.getMinute());
	System.out.println("\t date.getSecond() = " + dateTime.getSecond());
	
		// Метод int compareTo(LocalDateTime date) возвращает -1, если дата раньше и 1, если дата позже
	currentDateTime1 = LocalDateTime.of(2022, Month.AUGUST, 20, 10, 00, 01);
	currentDateTime2 = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("Метод int compareTo()   - "  + currentDateTime1.compareTo(currentDateTime2));
	
		// Метод boolean a.isAfter(b) проверяет позже ли одна дата относительно другой
		// Метод boolean a.isBefore(b) проверяет до ли одна дата относительно другой
		// Метод boolean a.isEqual(b) проверяет равна ли одна дата другой
	currentDateTime1 = LocalDateTime.of(2022, Month.AUGUST, 20, 10, 00, 01);
	currentDateTime2 = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("Метод boolean a.isAfter(b) - " + currentDateTime1.isAfter(currentDateTime2));
	System.out.println("Метод boolean a.isBefore(b) - " + currentDateTime1.isBefore(currentDateTime2));
	System.out.println("Метод boolean a.isEqual(b) - " + currentDateTime1.isEqual(currentDateTime2));
		
		// Метод LocalDateTime minus возвращает дату за вычетом года, минуты....
	System.out.println("Метод minusYears(int years) - " + currentDateTime1.minusYears(1));
	System.out.println("Метод minus - " + currentDateTime1.minus(1, ChronoUnit.DAYS));
	System.out.println("Метод minus - " + currentDateTime1.minus(1, ChronoUnit.WEEKS));
		// Метод LocalDateTime plus возвращает дату после прибавления года, минуты....
	System.out.println("Метод plusYears(int years) - " + currentDateTime1.plusYears(1));
	System.out.println("Метод plus  - " + currentDateTime1.plus(1, ChronoUnit.WEEKS));
	
		// Метод LocalDate withDayOfMonth (int months) возращает измененную дату в поле месяц
	currentDateTime = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("\t Дата до изменения " + currentDateTime.toString());
	System.out.println("Дата после изменения даты на 7-ое число месяца  " + currentDateTime.withDayOfMonth(7));
	System.out.println("Дата после изменения числа даты на 350 день этого года  " + currentDateTime.withDayOfYear(350));
	System.out.println("Дата после изменения месяца на июль  " + currentDateTime.withMonth(7));
	System.out.println("Дата после изменения года на 2002  " + currentDateTime.withYear(2002));
	System.out.println("Дата после изменения часа на 1 час  " + currentDateTime.withHour(1));
	System.out.println("Дата после изменения минут на 80 миунт  " + currentDateTime.withMinute(50));
	
		// Метод LocalDateTime with (TemporalAdjuster adjuster) возращает измененную по некотoрому правилу дату
	currentDateTime = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("\t Дата до изменения " + currentDateTime.toString());
	TemporalAdjuster adjuster = TemporalAdjusters.firstDayOfMonth(); 
	System.out.println("Дата с изменением числа даты к 1-му дню этого месяца " + currentDateTime.with(adjuster));
	adjuster = TemporalAdjusters.firstDayOfNextMonth();
	System.out.println("Дата с изменением числа даты к 1-му дню следующего месяца " + currentDateTime.with(adjuster));
	adjuster = TemporalAdjusters.lastDayOfMonth();
	System.out.println("Дата с изменением числа даты к последнему дню этого месяца " + currentDateTime.with(adjuster));
	adjuster = TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на первую пятницу месяца " + currentDateTime.with(adjuster));
	adjuster = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на последнюю пятницу месяца " + currentDateTime.with(adjuster));
	adjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на следующую пятницу " + currentDateTime.with(adjuster));
	
		// Метод truncatedTo(ChronoUnit.xxx) обнуляет значение времени, меньших указанного в параметре
	currentDateTime = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("До метода truncatedTo(ChronoUnit.xxx) - " + currentDateTime.toString());
	System.out.println("После метода truncatedTo(ChronoUnit.xxx) - " + currentDateTime.truncatedTo(ChronoUnit.HOURS));
		
		// Метод long until() возвращает кол-во времени между двумя точками
	currentDateTime = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	currentDateTime1 = LocalDateTime.of(2021, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("Метод until() в секундах  - " + currentDateTime.until(currentDateTime1, ChronoUnit.SECONDS));
	System.out.println("Метод until() в днях  - " + currentDateTime.until(currentDateTime1, ChronoUnit.DAYS));
	System.out.println("Метод until() в днях  - " + currentDateTime.until(currentDateTime1, ChronoUnit.WEEKS));
	
//---------------------------------------------------------------------------------------------------------------------------
					// Класс LocalTime  - Часы, минуты, секунды, наносекунды
	/* Класс LocalTime оперирует только временем. Он полезен  для хранения времени открытия/закрытия магазина и т. д.
	Класс LocalTime  не сохраняет информацию о часовой поясе и летнем/зимнем времени */
	System.out.println("-------------------------------Класс LocalTime-------------------------------------");
		// Инициализация методом now() для текущей даты
	LocalTime currentTime = LocalTime.now();
	System.out.println("Дата и время в классе LocalDateTime - "  + currentTime.toString());
		// Инициализация из объекта LocalDateTime через метод from (LocalTime dateTime)
	LocalDateTime dateTime2 = LocalDateTime.now();
	System.out.println("Из объекта LocalDateTime получена экстрация объекта LocalTime - "  + LocalTime.from(dateTime2));
		// Инициализация из объекта LocalDateTime через метод to(LocalDateTime date9)
	currentDateTime2 = LocalDateTime.of(2022, Month.AUGUST, 21, 11, 10, 01);
	System.out.println("\t Из объекта LocalDateTime получена экстрация объекта LocalTime - "  + currentDateTime2.toString());
	
	}					
}
        
        
  