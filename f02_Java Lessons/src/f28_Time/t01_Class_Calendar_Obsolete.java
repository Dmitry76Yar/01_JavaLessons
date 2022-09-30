package f28_Time;

import java.util.Calendar;
import java.util.Date;

public class t01_Class_Calendar_Obsolete {
public static void main(String[] args) {
		/* Класс java.util.Calendar является абстрактным классом. Единственная реализация — java.util.GregorianCalendar.
		  Новый экземпляр создаётся фабричным методом:		 */
		
	Calendar rightNow = Calendar.getInstance();
	System.out.println("Дата - " + rightNow.getTime().toString());
	
		// Метод getTime() возвращает объект класса Date, у которого есть свои методы
	Date currentDate = rightNow.getTime();
	System.out.println("Текущее время = " + currentDate.toString());
	
		// Прибавление или вычитание из даты
	rightNow.add(Calendar.DAY_OF_MONTH, -2);
	System.out.println("Дата после вычитания 2-х дней - " + rightNow.getTime().toString());		rightNow = Calendar.getInstance();
	rightNow.add(Calendar.WEEK_OF_MONTH, -2);
	System.out.println("Дата после вычитания 2-х недель - " + rightNow.getTime().toString());	rightNow = Calendar.getInstance();
	
	
	
	
	}					
}
        
        
  