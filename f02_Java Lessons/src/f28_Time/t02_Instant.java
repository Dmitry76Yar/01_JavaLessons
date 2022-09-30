package f28_Time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class t02_Instant {
public static void main(String[] args) {
			/* Класс Instant — это представляет наносекунды от 1 января 1970 года 00:00:00 по UTC. 
       Может содержать отрицательное значение, если он представляет время до 1 января 1970 года.  */
	
		// Инициализация методом now() для текущей даты
	Instant timestamp = Instant.now();
	System.out.println("Инициализация методом now() для текущей даты и зоны - "  + timestamp.toString());
		// Инициализация методом of(int seconds from 01.01.1970)
	Instant timestamp1 = Instant.ofEpochSecond(1000);
	System.out.println("Инициализация методом of(int seconds from 01.01.1970) - "  + timestamp1.toString());
		// Инициализация методом of(int seconds from 01.01.1970, long nanosec)
	Instant timestamp2 = Instant.ofEpochSecond(1000, -999999);
	System.out.println("Инициализация методом of(int seconds from 01.01.1970, long nanosec) - "  + timestamp2.toString());
		// Инициализация методом parse(String str) для текущей даты
	Instant timestamp3 = Instant.parse("2007-12-03T10:15:30.00Z");
	System.out.println("Метод parse()  - " + timestamp3.toString());
		
		// Метод long toEpochMilli() конвертирует в кол-во милисекунд от 1 января 1970 года 00:00:00
	System.out.println("Метод long toEpochMilli() конвертирует в кол-во милисекунд от 1.01.1970  - " +timestamp.toEpochMilli());
		
		// Методы GET
	timestamp3 = Instant.parse("2007-12-03T10:15:30.00Z");
	System.out.println("Методы GET для 2007-12-03T10:15:30.00Z");
	System.out.println("date.getEpochSecond() = " + timestamp3.getEpochSecond());		// seconds from the Java epoch of 1970-01-01T00:00:00Z. 
	System.out.println("date.getDayOfYear() = " + timestamp3.getNano());			//  nanoseconds, later along the time-line, from the startof the second. 
	
		// Метод int compareTo(LocalDateTime date) возвращает -1, если дата раньше и 1, если дата позже
	timestamp = Instant.parse("2007-12-03T10:15:30.00Z");
	timestamp1 = Instant.parse("2006-12-03T10:15:30.00Z");
	System.out.println("Метод int compareTo()   - "  + timestamp.compareTo(timestamp1));
	
		// Метод boolean a.isAfter(b) проверяет позже ли одна дата относительно другой
		// Метод boolean a.isBefore(b) проверяет до ли одна дата относительно другой
	System.out.println("Метод boolean a.isAfter(b) - " + timestamp.isAfter(timestamp1));
	System.out.println("Метод boolean a.isBefore(b) - " + timestamp.isBefore(timestamp1));
	
		// Метод Instant minus возвращает дату за вычетом года, минуты....
	System.out.println("Метод minusYears(int years) - " + timestamp.minusSeconds(10));
	System.out.println("Метод minus - " + timestamp.minus(1, ChronoUnit.DAYS));
	System.out.println("Метод minus - " + timestamp.minus(1, ChronoUnit.SECONDS));
		// Метод Instant plus возвращает дату после прибавления года, минуты....
	System.out.println("Метод plusYears(int years) - " + timestamp.plusSeconds(10));
	System.out.println("Метод plus  - " + timestamp.plus(1, ChronoUnit.SECONDS));

		// Метод truncatedTo(ChronoUnit.xxx) обнуляет значение времени, меньших указанного в параметре
	timestamp = Instant.parse("2007-12-03T10:15:30.00Z");
	System.out.println("До метода truncatedTo(ChronoUnit.xxx) - " + timestamp.toString());
	System.out.println("После метода truncatedTo(ChronoUnit.xxx) - " + timestamp.truncatedTo(ChronoUnit.HOURS));
	
		// Метод long until() возвращает кол-во времени между двумя точками
	timestamp = Instant.parse("2007-12-03T10:15:30.00Z");
	timestamp1 = Instant.parse("2006-12-03T10:15:30.00Z");
	System.out.println("Метод until() в секундах  - " + timestamp.until(timestamp1, ChronoUnit.SECONDS));
	System.out.println("Метод until() в днях  - " + timestamp.until(timestamp1, ChronoUnit.DAYS));

		// Метод LocalDateTime with (TemporalAdjuster adjuster) возращает измененную по некотoрому правилу дату
	timestamp = Instant.parse("2007-12-03T10:15:30.00Z");
	System.out.println("\t Дата до изменения " + timestamp.toString());
	}					
}
        
        
  