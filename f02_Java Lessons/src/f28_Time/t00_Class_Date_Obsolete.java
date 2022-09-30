package f28_Time;

import java.util.Date;

public class t00_Class_Date_Obsolete {
public static void main(String[] args) {
		/* java.util.Date   Самый древний способ. Если вы посмотрите на описание методов java.util.Date, то вы заметите, 
	 что большая часть методов указана устаревшими. Реально полезного и работающего всего чуть-чуть.		 */
		
		/* Создаём экземпляр с текущей датой и временем - время, получившееся по прошествии  указанного количества миллисекунд
	от 	1 января 1970 года 00:00 GMT. Обычно используется для конвертации из других форматов даты и времени. */
	java.util.Date currentDate = new java.util.Date();
	
		// Метод getTime() возвращает значение java.util.Date в количестве миллисекунд, прошедших с 1 января 1970 года 00:00 GMT
	System.out.println("Текущее время = " + currentDate.toString());
	
		// Другие методы get
	System.out.print("Год - " + (currentDate.getYear() + 1900) + "\t");		// Год отсчитывается от 1900
	System.out.print("Месяц - " + (currentDate.getMonth() + 1) + "\t");		// Январь - нулевой месяц
	System.out.print("Дата - " + currentDate.getDate() + "\t");		System.out.println();
	System.out.println("День недели - " + currentDate.getDay());
	System.out.print("Время : " + currentDate.getHours() + "." + currentDate.getMinutes() + "." + currentDate.getSeconds());  System.out.println();
		
		// Метод void setTime(long time) устанавливает значение java.util.Date в количестве миллисекунд, прошедших с 1 января 1970 года 00:00 GMT.
	Date otherDate = new Date();
	otherDate.setTime(1645811030884L);
	System.out.println("Время для 1645811030884L = " + otherDate.toString());
	
		// Метод void pares(String time) устанавливает время из строки
	Date otherDate1 = new Date();
	otherDate1.parse("Sat, 12 Aug 1995 13:30:00 GMT");
	System.out.println("Время для Sat, 12 Aug 1995 13:30:00 GMT = " + otherDate1.toString());
	
		// Метод public boolean after(Date when) возвращает true, если дата объекта находится позже указанной.
		// Метод public boolean before(Date when) возвращает true, если дата  объекта находится перед указанной.
	System.out.println("Дата находится позже указанной - " + otherDate.after(currentDate));
	System.out.println("Дата находится раньше указанной - " + otherDate.before(currentDate));
	
		/* Метод public int compareTo(Date anotherDate) - сравнение дат. Возвращает 0, если даты равны. Возвращает -1, если 
		 * дата объекта находится до anotherDate.  Возвращает 1, если дата объекта позже anotherDate.  */
	System.out.println("Дата находится позже или раньше указанной - " + currentDate.compareTo(otherDate));
	
		// Методы set
	System.out.println("\t  Методы set");
	System.out.println("Время до изменений = " + otherDate.toString());
	otherDate.setYear(1);    System.out.println("После установки другого года = " + otherDate.toString());  	otherDate.setTime(1645811030884L);
	otherDate.setMonth(9);    System.out.println("После установки другого месяцы = " + otherDate.toString());  	otherDate.setTime(1645811030884L);
	otherDate.setDate(30);    System.out.println("После установки другой даты = " + otherDate.toString()); 		otherDate.setTime(1645811030884L);
	
	
	}					
}
        
        
  