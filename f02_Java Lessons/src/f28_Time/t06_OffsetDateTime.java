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

public class t06_OffsetDateTime {
public static void main(String[] args) {
	
	/* Каждый часовой пояс определяется идентификатором, имеющим формат регион/город (Asia/Tokyo), и смещением от Гринвича/UTC.
	   Например, смещение для Токио +9:00.  
	      Date-Time API содержит два класса для указания часового пояса или смещения: 
	   ZoneId указывает идентификатор часового пояса и поставляет правила для конвертирования Instant в LocalDateTime.
	   ZoneOffset указывает смещение часового пояса от Гринвича/UTC. 
	   Смещения от Гринвича/UTC обычно определяются в полных часах, но есть исключения. */
	
//-------------------------------------------------------------------------------------------------------------------------	
					// Класс ZoneOffset 
	/* Класс ZoneOffset указывает смещение часового пояса от Гринвича/UTC. 
	   Смещения от Гринвича/UTC обычно определяются в полных часах, но есть исключения. */
	System.out.println("\t\t\t Класс ZoneOffset");
	
		// Инициализация ZoneOffset через метод ofHours(int hours)
	ZoneOffset offset01 = ZoneOffset.ofHours(10);
	System.out.println("Инициализация ZoneOffset через метод ofHours(int hours)  - " + offset01.toString());
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
//----------------------------------------------------------------------------------------------------------------------------	
					// Класс OffsetDateTime - комбинация LocalDateTime  и ZoneOffset.
		//Он содержит полную дату, время и смещение от Гринвича/UTC (+/-часы:минуты).
	System.out.println("\t\t\t Класс OffsetDateTime");
	
		// Инициализация методом now() для текущей даты
	OffsetDateTime offsetDateTime = OffsetDateTime.now();
	System.out.println("Инициализация методом now() для текущей даты и зоны - "  + offsetDateTime.toString());
		// Инициализация методом of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, ZoneOffset)
	ZoneOffset offset = ZoneOffset.ofHours(10);
	OffsetDateTime offsetDateTime3 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, offset);
	System.out.println("Инициализация методом of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, offset) - "  +
			offsetDateTime3.toString());
		// Инициализация методом of(LocalDateTime localDateTime, ZoneOffset)
	LocalDateTime dateTime1 = LocalDateTime.of(2022, 02, 20, 10, 00);
	offset = ZoneOffset.ofHours(10);
	OffsetDateTime offsetDateTime2 = OffsetDateTime.of(dateTime1, offset);
	System.out.println("Инициализация методом of(LocalDateTime localDateTime, ZoneOffset) - "  + offsetDateTime2.toString());
		// Инициализация методом of(LocalDate localDate, LocalTime localTime,Zoneld zone)
	LocalTime localTime = LocalTime.of(10, 00);
	LocalDate localDate = LocalDate.of(2022, 02, 20);
	offset = ZoneOffset.ofHours(10);
	OffsetDateTime offsetDateTime4 = OffsetDateTime.of(localDate, localTime, offset);
	System.out.println("Инициализация методом of(LocalDate localDate, LocalTime localTime,Zoneld zone) - "  + 
			offsetDateTime4.toString());

		// Печать времени с использованием format(DateTimeFormatter formatter)
	OffsetDateTime offsetDateTime0 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(10));
	DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
	System.out.println("Печать времени с использованием DateTimeFormatter      " + offsetDateTime0.format(formatter));
	
		// Методы GET
	OffsetDateTime offsetDateTime01 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(10));
	System.out.println("\t Методы GET для 2022-12-10T9:00+03:00[Europe/Moscow]");
	System.out.print("zonaDateTime.getDayOfMonth() = " + offsetDateTime01.getDayOfMonth());
	System.out.print("zonaDateTime.getDayOfYear() = " + offsetDateTime01.getDayOfYear());
	System.out.println("zonaDateTime.getMonthValue() = " + offsetDateTime01.getMonthValue());
	System.out.print("zonaDateTime.getMonth() = " + offsetDateTime01.getMonth());
	System.out.print("zonaDateTime.getDayOfWeek() = " + offsetDateTime01.getDayOfWeek());
	System.out.println("zonaDateTime.getHour() = " + offsetDateTime01.getHour());
	System.out.println("zonaDateTime.getMinute() = " + offsetDateTime01.getMinute());
	System.out.println("zonaDateTime.getSecond() = " + offsetDateTime01.getSecond());
	System.out.println("zonaDateTime.getOffset() = " + offsetDateTime01.getOffset());
	
		// Метод int compareTo(LocalDateTime date) возвращает -1, если дата раньше и 1, если дата позже
	offsetDateTime = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(10));
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(8));
	System.out.println("Метод int compareTo()   - "  + offsetDateTime.compareTo(offsetDateTime2));
		
		// Метод boolean a.isAfter(b) проверяет позже ли одна дата относительно другой
		// Метод boolean a.isBefore(b) проверяет до ли одна дата относительно другой
		// Метод boolean a.isEqual(b) проверяет равна ли одна дата другой
	offsetDateTime = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(10));
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(8));
	System.out.println("\tМетод boolean a.isAfter(b) - " + offsetDateTime.isAfter(offsetDateTime2));
	System.out.println("Метод boolean a.isBefore(b) - " + offsetDateTime.isBefore(offsetDateTime2));
	System.out.println("Метод boolean a.isEqual(b) - " + offsetDateTime.isEqual(offsetDateTime2));
	
		// Метод OffsetDateTime minusYears(int years) возвращает дату за вычетом года
	System.out.println("Метод minusYears(int years) - " + offsetDateTime.minusYears(1));
	System.out.println("Метод minus - " + offsetDateTime.minus(1, ChronoUnit.DAYS));
	System.out.println("Метод minus - " + offsetDateTime.minus(1, ChronoUnit.WEEKS));
		// Метод OffsetDateTime plusYears(int years) возвращает дату за плюсом года
	System.out.println("Метод plusYears(int years) - " + offsetDateTime.plusYears(1));
	System.out.println("Метод plus  - " + offsetDateTime.plus(1, ChronoUnit.WEEKS));
	
		// Метод truncatedTo(ChronoUnit.xxx) обнуляет значение времени, меньших указанного в параметре
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(8));
	System.out.println("До метода truncatedTo(ChronoUnit.xxx) - " + offsetDateTime2.toString());
	System.out.println("После метода truncatedTo(ChronoUnit.xxx) - " + offsetDateTime2.truncatedTo(ChronoUnit.HOURS));
	
		// Метод long until() возвращает кол-во времени между двумя точками
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(8));
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(6));
	System.out.println("Метод until() в секундах  - " + offsetDateTime.until(offsetDateTime2, ChronoUnit.SECONDS));
	System.out.println("Метод until() в днях  - " + offsetDateTime.until(offsetDateTime2, ChronoUnit.DAYS));
	System.out.println("Метод until() в днях  - " + offsetDateTime.until(offsetDateTime2, ChronoUnit.WEEKS));
	
	// Метод LocalDate withDayOfMonth (int months) возращает измененную дату в поле месяц
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(8));
	System.out.println("\t Дата до изменения " + offsetDateTime2.toString());
	System.out.println("Дата после изменения даты на 7-ое число месяца  " + offsetDateTime2.withDayOfMonth(7));
	System.out.println("Дата после изменения числа даты на 350 день этого года  " + offsetDateTime2.withDayOfYear(350));
	System.out.println("Дата после изменения месяца на июль  " + offsetDateTime2.withMonth(7));
	System.out.println("Дата после изменения года на 2002  " + offsetDateTime2.withYear(2002));
	System.out.println("Дата после изменения часа на 1 час  " + offsetDateTime2.withHour(1));
	System.out.println("Дата после изменения минут на 80 минут  " + offsetDateTime2.withMinute(50));
	System.out.println("Дата после изменения offset на другой  " + offsetDateTime2.withOffsetSameInstant(ZoneOffset.ofHours(8)));
	System.out.println("Дата после изменения offset на другой, но время не меняется  " + 
			offsetDateTime2.withOffsetSameLocal(ZoneOffset.ofHours(8)));
	
		// Метод LocalDateTime with (TemporalAdjuster adjuster) возращает измененную по некотoрому правилу дату
	offsetDateTime2 = OffsetDateTime.of(2022, 12, 10, 9, 00, 00, 00, ZoneOffset.ofHours(8));
	System.out.println("\t Дата до изменения " + offsetDateTime2.toString());
	TemporalAdjuster adjuster = TemporalAdjusters.firstDayOfMonth(); 
	System.out.println("Дата с изменением числа даты к 1-му дню этого месяца " + offsetDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.firstDayOfNextMonth();
	System.out.println("Дата с изменением числа даты к 1-му дню следующего месяца " + offsetDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.lastDayOfMonth();
	System.out.println("Дата с изменением числа даты к последнему дню этого месяца " + offsetDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на первую пятницу месяца " + offsetDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
	System.out.println("Дата с изменением числа даты на последнюю пятницу месяца " + offsetDateTime2.with(adjuster));
	adjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);
	
//-------------------------------------------------------------------------------------------------------------------------
						// Класс ZoneID
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
	
	
	}					
}
        
        
  