package f28_Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class t05_ZonedDateTime {
public static void main(String[] args) {
	
	/* Каждый часовой пояс определяется идентификатором, имеющим формат регион/город (Asia/Tokyo), и смещением от Гринвича/UTC.
	   Например, смещение для Токио +9:00.  
	      Date-Time API содержит два класса для указания часового пояса или смещения: 
	   ZoneId указывает идентификатор часового пояса и поставляет правила для конвертирования Instant в LocalDateTime.
	   ZoneOffset указывает смещение часового пояса от Гринвича/UTC. 
	   Смещения от Гринвича/UTC обычно определяются в полных часах, но есть исключения. */
	
					// Класс ZoneId 
		// Класс ZoneId указывает идентификатор часового пояса и поставляет правила для конвертирования Instant в LocalDateTime.
		// Иниализация ZoneId по умолчанию
	System.out.println("\t\t\t Класс ZoneId");
	ZoneId zone = ZoneId.systemDefault();
	System.out.println("Иниализация ZoneId по умолчанию    - "  + zone.toString());
		// Иниализация ZoneId через метод of(String zona)
	ZoneId zone2 = ZoneId.of("Africa/Accra");
	System.out.println("Иниализация через метод of(String zona)    - "  + zone2.toString());
	
		// Весь перечень зон ZoneId методом getAvailableZoneIds()
	Set<String> allZones = ZoneId.getAvailableZoneIds();
	List<String> zoneList = new ArrayList<String>(allZones);
	Collections.sort(zoneList);									// Для сортировки по названию
	System.out.println("Весь перечень зон ZoneId - " + zoneList);
	
		// Печать названия зоны методом toString())
	System.out.println("Печать названия зоны методом getId() - "  + zone.getId());
		// Печать названия зоны методом getDisplayName(TextStyle, Locale))
	System.out.println("Название зоны в полном исполнении и локалью по умолчанию -   " + 
		zone.getDisplayName(TextStyle.FULL, Locale.getDefault()));
	System.out.println("Название зоны в полном исполнении и локалью FRANCE -   " +
			zone.getDisplayName(TextStyle.FULL, Locale.FRANCE));
	System.out.println("Название зоны в коротком исполнении и локалью по умолчанию -   " +
			zone.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
	System.out.println("Название зоны в коротком исполнении и локалью по умолчанию -   " +
			zone.getDisplayName(TextStyle.NARROW, Locale.getDefault()));
	
	//----------------------------------------------------------------------------------------------------------
						// Класс ZoneOffset 
	/* Класс ZoneOffset указывает смещение часового пояса от Гринвича/UTC. 
	   Смещения от Гринвича/UTC обычно определяются в полных часах, но есть исключения. */
	System.out.println("\t\t\t Класс ZoneOffset");
	
		// Инициализация ZoneOffset через метод ofHours(int hours)
	ZoneOffset offset = ZoneOffset.ofHours(10);
	System.out.println("Инициализация ZoneOffset через метод ofHours(int hours)  - " + offset.toString());
		// Инициализация ZoneOffset через метод ofHours(int hours, int min)
	ZoneOffset offset1 = ZoneOffset.ofHoursMinutes(10, 20);
	System.out.println("Инициализация ZoneOffset через метод ofHours(int hours, int min)  - " + offset1.toString());
		// Инициализация ZoneOffset через метод ofHoursMinutesSeconds(hours, minutes, seconds)
	ZoneOffset offset2 = ZoneOffset.ofHoursMinutesSeconds(10, 20, 30);
	System.out.println("Инициализация ZoneOffset через метод ofHours(int hours, int min, int sec)  - " + offset2.toString());
		// Инициализация ZoneOffset через метод ofTotalSeconds(seconds)
	ZoneOffset offset3 = ZoneOffset.ofTotalSeconds(1000);
	System.out.println("Инициализация ZoneOffset через метод ofHours(int sec)  - " + offset3.toString());
	
		// Инициализация методом of(String str) 
	ZoneOffset offset11 = ZoneOffset.of("-08:00");
	try {
		System.out.println("Инициализация методом of(String str)  - " + offset11.toString());}
	catch (DateTimeParseException ex) {
		System.out.println(ex.toString());}	
	
		// Печать всех зон с офсетами
	System.out.println("Печать всех зон с офсетами");
	Set<String> allZones1 = ZoneId.getAvailableZoneIds();
	LocalDateTime dateTime = LocalDateTime.now();
		// Создаём список с зонами и сортируем его.
	List<String> zoneList1 = new ArrayList<String>(allZones1);
	Collections.sort(zoneList1);
	for (String s : zoneList1) {
	    ZoneId zone1 = ZoneId.of(s);
	    ZonedDateTime zoneDateTime = dateTime.atZone(zone1);
	    ZoneOffset offset5 = zoneDateTime.getOffset();
	    String out = String.format("%35s %10s%n", zone1, offset5);
//	    System.out.print(out);
	}
	
//----------------------------------------------------------------------------------------------------------
		// Класс ZonedDateTime  - можно рассматривать как комбинацию LocalDateTime  и ZoneId.
		// Класс представляет собой полную дату, время и часовой пояс. 
	System.out.println("\t\t\t Класс ZonedDateTime");
	
		// Инициализация методом now() для текущей даты
	ZonedDateTime currentZonaDateTime = ZonedDateTime.now();
	System.out.println("Инициализация методом now() для текущей даты и зоны - "  + currentZonaDateTime.toString());
		// Инициализация методом of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone)
	ZoneId zone5 = ZoneId.of("Europe/Moscow");
	ZonedDateTime currentZonaDateTime3 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, zone5);
	System.out.println("Инициализация методом of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone) - "  +
			currentZonaDateTime3.toString());
		// Инициализация методом of(LocalDateTime localDateTime, Zoneld zone)
	LocalDateTime dateTime1 = LocalDateTime.of(2022, 02, 20, 10, 00);
	ZoneId zone3 = ZoneId.of("Africa/Accra");
	ZonedDateTime currentZonaDateTime2 = ZonedDateTime.of(dateTime1, zone3);
	System.out.println("Инициализация методом of(LocalDateTime localDateTime, Zoneld zone) - "  + currentZonaDateTime2.toString());
		// Инициализация методом of(LocalDate localDate, LocalTime localTime,Zoneld zone)
	LocalTime localTime = LocalTime.of(10, 00);
	LocalDate localDate = LocalDate.of(2022, 02, 20);
	ZoneId zone4 = ZoneId.of("Europe/Moscow");
	ZonedDateTime currentZonaDateTime4 = ZonedDateTime.of(localDate, localTime, zone4);
	System.out.println("Инициализация методом of(LocalDate localDate, LocalTime localTime,Zoneld zone) - "  + 
			currentZonaDateTime4.toString());
		// Инициализация методом ofInstant(localDateTime, offset3, zone4)
	LocalDateTime dateTime2 = LocalDateTime.of(2022, 02, 20, 10, 00);
	ZoneId zone6 = ZoneId.of("Europe/Moscow");
	ZoneOffset offset4 = ZoneOffset.ofHours(10);
	ZonedDateTime currentZonaDateTime5 = ZonedDateTime.ofInstant(dateTime2, offset4, zone6);
	System.out.println("Инициализация методом ofInstant(localDateTime, offset3, zone4) - "  + 
			currentZonaDateTime5.toString());
	
		// Печать времени с использованием format(DateTimeFormatter formatter)
	ZonedDateTime zonaDateTime0 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
	System.out.println("Печать времени с использованием DateTimeFormatter      " + zonaDateTime0.format(formatter));
	
		// Методы GET
	ZonedDateTime zonaDateTime = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, zone5);
	System.out.println("\t Методы GET для 2022-02-20T03:00+03:00[Europe/Moscow]");
	System.out.print("zonaDateTime.getDayOfMonth() = " + zonaDateTime.getDayOfMonth());
	System.out.print("zonaDateTime.getDayOfYear() = " + zonaDateTime.getDayOfYear());
	System.out.println("zonaDateTime.getMonthValue() = " + zonaDateTime.getMonthValue());
	System.out.print("zonaDateTime.getMonth() = " + zonaDateTime.getMonth());
	System.out.print("zonaDateTime.getDayOfWeek() = " + zonaDateTime.getDayOfWeek());
	System.out.println("zonaDateTime.getHour() = " + zonaDateTime.getHour());
	System.out.println("zonaDateTime.getMinute() = " + zonaDateTime.getMinute());
	System.out.println("zonaDateTime.getSecond() = " + zonaDateTime.getSecond());
	System.out.println("zonaDateTime.getOffset() = " + zonaDateTime.getOffset());
	System.out.println("zonaDateTime.getZone() = " + zonaDateTime.getZone());
	
		// Метод int compareTo(LocalDateTime date) возвращает -1, если дата раньше и 1, если дата позже
	zonaDateTime = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Africa/Accra"));
	ZonedDateTime zonaDateTime2 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	System.out.println("Метод int compareTo()   - "  + zonaDateTime.compareTo(zonaDateTime2));
		
		// Метод boolean a.isAfter(b) проверяет позже ли одна дата относительно другой
		// Метод boolean a.isBefore(b) проверяет до ли одна дата относительно другой
		// Метод boolean a.isEqual(b) проверяет равна ли одна дата другой
	zonaDateTime = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Africa/Accra"));
	zonaDateTime2 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	System.out.println("\tМетод boolean a.isAfter(b) - " + zonaDateTime.isAfter(zonaDateTime2));
	System.out.println("Метод boolean a.isBefore(b) - " + zonaDateTime.isBefore(zonaDateTime2));
	System.out.println("Метод boolean a.isEqual(b) - " + zonaDateTime.isEqual(zonaDateTime2));
	
		// Метод ZonedDateTime minusYears(int years) возвращает дату за вычетом года
	System.out.println("Метод minusYears(int years) - " + zonaDateTime.minusYears(1));
	System.out.println("Метод minus - " + zonaDateTime.minus(1, ChronoUnit.DAYS));
	System.out.println("Метод minus - " + zonaDateTime.minus(1, ChronoUnit.WEEKS));
		// Метод ZonedDateTime plusYears(int years) возвращает дату за плюсом года
	System.out.println("Метод plusYears(int years) - " + zonaDateTime.plusYears(1));
	System.out.println("Метод plus  - " + zonaDateTime.plus(1, ChronoUnit.WEEKS));
	
		// Метод truncatedTo(ChronoUnit.xxx) обнуляет значение времени, меньших указанного в параметре
	zonaDateTime2 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	System.out.println("До метода truncatedTo(ChronoUnit.xxx) - " + zonaDateTime2.toString());
	System.out.println("После метода truncatedTo(ChronoUnit.xxx) - " + zonaDateTime2.truncatedTo(ChronoUnit.HOURS));
	
		// Метод long until() возвращает кол-во времени между двумя точками
	zonaDateTime = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Africa/Accra"));
	zonaDateTime2 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	System.out.println("Метод until() в секундах  - " + zonaDateTime.until(zonaDateTime2, ChronoUnit.SECONDS));
	System.out.println("Метод until() в днях  - " + zonaDateTime.until(zonaDateTime2, ChronoUnit.DAYS));
	System.out.println("Метод until() в днях  - " + zonaDateTime.until(zonaDateTime2, ChronoUnit.WEEKS));
	
	// Метод LocalDate withDayOfMonth (int months) возращает измененную дату в поле месяц
	zonaDateTime2 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	System.out.println("\t Дата до изменения " + zonaDateTime2.toString());
	System.out.println("Дата после изменения даты на 7-ое число месяца  " + zonaDateTime2.withDayOfMonth(7));
	System.out.println("Дата после изменения числа даты на 350 день этого года  " + zonaDateTime2.withDayOfYear(350));
	System.out.println("Дата после изменения месяца на июль  " + zonaDateTime2.withMonth(7));
	System.out.println("Дата после изменения года на 2002  " + zonaDateTime2.withYear(2002));
	System.out.println("Дата после изменения часа на 1 час  " + zonaDateTime2.withHour(1));
	System.out.println("Дата после изменения минут на 80 минут  " + zonaDateTime2.withMinute(50));
	System.out.println("Дата после изменения зоны на другую  " + zonaDateTime2.withZoneSameInstant(ZoneId.of("Africa/Accra")));
	System.out.println("Дата после изменения зоны на другую, но время не меняется  " + 
			zonaDateTime2.withZoneSameLocal(ZoneId.of("Africa/Accra")));
	
		// Метод LocalDateTime with (TemporalAdjuster adjuster) возращает измененную по некотoрому правилу дату
	zonaDateTime2 = ZonedDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneId.of("Europe/Moscow"));
	System.out.println("\t Дата до изменения " + zonaDateTime2.toString());
	TemporalAdjuster adjuster = TemporalAdjusters.firstDayOfMonth(); 
	System.out.println("Дата с изменением числа даты к 1-му дню этого месяца " + zonaDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.firstDayOfNextMonth();
	System.out.println("Дата с изменением числа даты к 1-му дню следующего месяца " + zonaDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.lastDayOfMonth();
	System.out.println("Дата с изменением числа даты к последнему дню этого месяца " + zonaDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на первую пятницу месяца " + zonaDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на последнюю пятницу месяца " + zonaDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);
	
						// ПРИМЕР Определение времени прилета  из Сан-Франциско в Токио */
	LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);  // Отправление из Сан-Франциско 20 июля 2013 в 19:30.
	ZoneId leavingZone = ZoneId.of("America/Los_Angeles"); 
	ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
	try {
		DateTimeFormatter formatter1 = DateTimeFormatter.ISO_TIME; 
	    String out1 = departure.format(formatter1);
	    System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
	} catch (DateTimeException exc) {
	    System.out.printf("%s can't be formatted!%n", departure);
	    throw exc;
	}
	ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");		// Полёт длится 10 часов и 50 минут (650 минут) 
		// Метод withZoneSameInstant() меняет зону с соответствующим изменением времени.
	ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);
	try {
		DateTimeFormatter formatter1 = DateTimeFormatter.ISO_TIME;
	    String out2 = arrival.format(formatter1);
	    System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
	} catch (DateTimeException exc) {
	    System.out.printf("%s can't be formatted!%n", arrival);
	    throw exc;
	}	
		// Метод ZoneRules.isDaylightSavings  определяет, используется ли летнее время по прибытии в
	if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) 
	    System.out.printf("  (%s daylight saving time will be in effect.)%n",  arrivingZone);
	else System.out.printf("  (%s standard time will be in effect.)%n", arrivingZone);
	
	
	}					
}
        
        
  