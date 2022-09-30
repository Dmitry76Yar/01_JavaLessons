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

public class t03_LocalDate_Yearh_MonthDay {
public static void main(String[] args) {
	
	System.out.println("----------------------------------------Класс LocalDate----------------------------------");
						/* Класс LocalDate 
	Класс LocalDate хранит год, месяц и день.    Используется для хранения и обработки даты без времени. */
	
		// Инициализация   Метод of (int year, int month, int day)  
	LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
	LocalDate date2 = LocalDate.of(2000, 2, 20);
	System.out.println("\t Инициализация    LocalDate.of(2000, Month.NOVEMBER, 20) = " + date.toString());
		// Инициализация из объекта LocalDateTime через метод from (LocalDateTime date9)
	LocalDateTime currentDateTime = LocalDateTime.now();
	System.out.println("Дата и время в классе LocalDateTime - "  + currentDateTime.toString());
	System.out.println("\t Из объекта LocalDateTime получена экстрация объекта LocalDate - "  + LocalDate.from(currentDateTime));
		// Инициализация из объекта LocalDateTime через метод LocalDate to(LocalDateTime date9)
	LocalDate currentDate = currentDateTime.toLocalDate();
	System.out.println("\t Из объекта LocalDateTime получена экстрация объекта LocalDate - "  + currentDate.toString());
		// Инициализация методом now() для текущей даты 
	LocalDate date6 = LocalDate.now();
	System.out.println("\t Текущая дата объекта LocalDate - "  + date6.toString());
		// Метод LocalDateTime void atStartOfDay()возвращает объект LocalDateTime для указанной даты + время 00:00
	System.out.println("\t Метод LocalDateTime  для " + date.atStartOfDay());
		// Метод LocalDateTime atStartOfDay()возвращает объект LocalDateTime для указанной даты + время 00:00
	System.out.println("\t Метод LocalDateTime  для " + date.atTime(LocalTime.of(22, 01, 59)));
	
		// Инициализация методом parse(String str) 
	LocalDate date9 = LocalDate.parse("2007-12-03");
	try {
		System.out.println("Метод parse()  - " + currentDateTime.toString());}
	catch (DateTimeParseException ex) {
		System.out.println(ex.toString());}	
	System.out.println("\t Инициализация методом parse(String str) " + date9.toString());
	
		// Метод int compareTo(LocalDate date) возвращает разницу в днях между указанными днями
	LocalDate date3 = LocalDate.of(2000, 3, 5);
	System.out.println("\t Метод int compareTo(LocalDate date)   разнцица в днях  - "  + date.compareTo(date3));
	
		// Метод Stream datesUntil(LocalDate finishDate) возвращает поток от начальной до конеченой дат
	LocalDate startDate = LocalDate.of(2000, 2, 20);
	LocalDate finishDate = LocalDate.of(2000, 2, 23);
	System.out.print("\t Метод datesUntil(LocalDate finishDate) : ");
	startDate.datesUntil(finishDate).forEach(s -> System.out.print(s + "\t" ));		System.out.println();
	
		// Метод Stream datesUntil(LocalDate finishDate, int step) возвращает поток от начальной до конеченой дат С ШАГОМ
	startDate = LocalDate.of(2000, 2, 20);
	finishDate = LocalDate.of(2000, 3, 4);
	Period period = Period.ofDays(4);
	System.out.print("\t Метод datesUntil(LocalDate finishDate, int step)  c шагом 4 дня : ");
	startDate.datesUntil(finishDate, period).forEach(s -> System.out.print(s + "\t" ));		System.out.println();
	
		// Метод LocalDate format(DateTimeFormatter) возврщает отформатированную дату
	System.out.println("\t Дата 20 ноября 2000 года без форматирования " + date.toString());
	System.out.println("\t Дата DateTimeFormatter.BASIC_ISO_DATE -   " + date.format(DateTimeFormatter.BASIC_ISO_DATE));
	
		// Методы GET
	System.out.println("\t\t Методы GET для 20 ноября 2000 года");
	System.out.print("\t date.getDayOfMonth() = " + date.getDayOfMonth());
	System.out.print("\t date.getDayOfYear() = " + date.getDayOfYear());
	System.out.println("\t date.getMonthValue() = " + date.getMonthValue());
	System.out.print("\t date.getMonth() = " + date.getMonth());
	System.out.print("\t date.getDayOfWeek() = " + date.getDayOfWeek());
	System.out.println("\t date.getEra() = " + date.getEra());
	
		// Метод boolean a.isAfter(b) проверяет позже ли одна дата относительно другой
		// Метод boolean a.isBefore(b) проверяет до ли одна дата относительно другой
		// Метод boolean a.isEqual(b) проверяет равна ли одна дата другой
	LocalDate a = LocalDate.of(2012, 6, 30);		  LocalDate b = LocalDate.of(2012, 7, 1);
	System.out.println("\t Метод boolean a.isAfter(b) - " + a.isAfter(b));
	System.out.println("\t Метод boolean a.isBefore(b) - " + a.isBefore(b));
	System.out.println("\t Метод boolean a.isEqual(b) - " + a.isEqual(b));
	
		// Метод boolean a.isLeapYear() проверяет является ли год данной даты високосным
	System.out.println("\t Метод boolean a.isLeapYear()  - " + date.isLeapYear());
	
		// Метод int lengthOfMonth() возвращает длительность месяца заданной даты
	System.out.println("\t Метод int lengthOfMonth()  - " + date.lengthOfMonth());
	
		// Метод int lengthOfYear() возвращает длительность года заданной даты
	System.out.println("\t Метод int lengthOfYear()  - " + date.lengthOfYear());
	
		// Метод minus(int x) и plus(int x) возвращает день  с вычетом или плюсом к указанному дню
	System.out.println("\t Дата 20 ноября 2000 года без форматирования " + date.toString());
	System.out.println("\t Дата после вычитания 5-ти дней - "  + date.minusDays(5));
	System.out.println("\t Дата после вычитания 5-ти недель - "  + date.minusWeeks(5));
	System.out.println("\t Дата после вычитания 5-ти месяцев - "  + date.minusMonths(5));
	System.out.println("\t Дата после вычитания 5-ти лет - "  + date.minusYears(5));
	System.out.println("\t Дата после приплюсования 5-ти дней - "  + date.plusDays(5));
	System.out.println("Метод minus - " + date.minus(1, ChronoUnit.DAYS));
	System.out.println("Метод minus - " + date.minus(1, ChronoUnit.WEEKS));
	
	// Метод LocalDate withDayOfMonth (int months) возращает измененную дату в поле месяц
	System.out.println("\t\t Дата 20 ноября 2000 года до изменения " + date.toString());
	System.out.println("\t Дата после изменения даты на 7-ое число месяца  " + date.withDayOfMonth(7));
	System.out.println("\t Дата после изменения числа даты на 350 день этого года  " + date.withDayOfYear(350));
	System.out.println("\t Дата после изменения месяца на июль  " + date.withMonth(7));
	System.out.println("\t Дата после изменения года на 2002  " + date.withYear(2002));
	
		// Метод LocalDate with (TemporalAdjuster adjuster) возращает измененную по некотрому правилу дату
	System.out.println("\t\t Дата 20 ноября 2000 года до изменения " + date.toString());
	TemporalAdjuster adjuster = TemporalAdjusters.firstDayOfMonth(); 
	System.out.println("\t Дата с изменением числа даты к 1-му дню этого месяца " + date.with(adjuster));
	adjuster = TemporalAdjusters.firstDayOfNextMonth();
	System.out.println("\t Дата с изменением числа даты к 1-му дню следующего месяца " + date.with(adjuster));
	adjuster = TemporalAdjusters.lastDayOfMonth();
	System.out.println("\t Дата с изменением числа даты к последнему дню этого месяца " + date.with(adjuster));
	adjuster = TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
	System.out.println("\t Дата с изменением числа даты на первую пятницу месяца " + date.with(adjuster));
	adjuster = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
	System.out.println("\t Дата с изменением числа даты на последнюю пятницу месяца " + date.with(adjuster));
	adjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);
	System.out.println("\t Дата с изменением числа даты на следующую пятницу " + date.with(adjuster));
	
		// Метод LocalDate with (TemporalAdjuster adjuster) с лямбда выражением для параметра TemporalAdjuster
	adjuster = TemporalAdjusters.ofDateAdjuster(d -> d.plusDays(2));
	System.out.println("\t Дата с изменением числа даты на 2 дню плюсом " + date.with(adjuster));
	
		// Метод long until() возвращает кол-во времени между двумя точками
	startDate = LocalDate.of(2000, 2, 20);
	finishDate = LocalDate.of(2000, 2, 23);
	System.out.println("\t Метод until() в днях  - " + startDate.until(finishDate, ChronoUnit.DAYS));
	System.out.println("\t Метод until() в днях  - " + startDate.until(finishDate, ChronoUnit.WEEKS));	
	
		// Метод Period until(endDateExclusive) возвращает период до дня в параметре от указанного дня
	LocalDate date4 = LocalDate.of(2000, Month.NOVEMBER, 25);
	Period per = date.until(date4);
	System.out.println("\t Метод Period until(endDateExclusive)   До указанной даты дней -  " + per.getDays());
	System.out.println("\t Метод Period until(endDateExclusive)   До указанной даты месяцев -  " + per.getMonths());
	
System.out.println("----------------------------------------Класс YearMonth----------------------------------");
						//  Класс YearMonth
		//  Класс YearMonth представляет месяц с годом
	System.out.println("\t\t РАБОТА С КЛАССОМ  YearMonth");
		// Инициализация из объекта Local Date
	LocalDate date0 = LocalDate.of(2000, Month.NOVEMBER, 20);
	YearMonth yearMonth  = YearMonth.from(date0);
	System.out.println("Из объекта LocalDate для 20.11.2000 получена экстрация объекта YearMonth - "  + yearMonth.toString());
		// Инициализация для текущей даты
	System.out.println("Текущая дата объекта YearMonth - "  + YearMonth.now());

					//  Класс MonthDay
		//  Класс MonthDay представляет месяц с датой
	System.out.println("\t\t РАБОТА С КЛАССОМ  MonthDay");
		// Инициализация из объекта Local Date
	LocalDate date7 = LocalDate.of(2000, Month.NOVEMBER, 20);
	MonthDay monthDay  = MonthDay.from(date7);
	System.out.println("\t Из объекта MonthDay для 20.11.2000 получена экстрация объекта YearMonth - "  + monthDay.toString());
		// Инициализация для текущей даты
	System.out.println("\t Текущая дата объекта MonthDay - "  + MonthDay.now());
		// Метод isValidYear(year) проверяет ли, может ли быть такая дата + год, указанный в параметре 
	System.out.println("\t Может ли быть такая дата + год, указанный в параметре?  - " + monthDay.isValidYear(2002));
		
					//  Класс Year
		//  Класс Year представляет только год
	System.out.println("\t\t РАБОТА С КЛАССОМ  Year");
		// Инициализация из объекта Local Date
	LocalDate date8 = LocalDate.of(2000, Month.NOVEMBER, 20);
	Year year  = Year.from(date7);
	System.out.println("Из объекта MonthDay для 20.11.2000 получена экстрация объекта Year - "  + monthDay.toString());
		// Инициализация для текущей даты
	System.out.println("Текущая дата объекта Year - "  + Year.now());
		// Метод isLeap() проверяет ли, может ли быть такая дата + год, указанный в параметре 
	System.out.println("Год високосный?  - " + year.isLeap());
	
	
	}					
}
        
        
  