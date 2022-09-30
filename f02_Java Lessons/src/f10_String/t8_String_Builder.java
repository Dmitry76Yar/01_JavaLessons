/*   Объекты String являются неизменяемыми, поэтому все операции, которые изменяют строки, фактически приводят к созданию новой строки, 
что сказывается на производительности приложения. Для решения этой проблемы, чтобы работа со строками проходила с меньшими издержками
 в Java были добавлены классы StringBuffer и StringBuilder. По сути они напоминает расширяемую строку.  
     Эти классы похожи, практически двойники, они имеют одинаковые конструкторы, одни и те же методы, которые одинаково используются. 
Единственное их различие состоит в том, что класс StringBuffer синхронизированный и потокобезопасный. То есть класс StringBuffer удобнее
использовать в многопоточных приложениях, где объект данного класса может меняться в различных потоках. Если же речь о многопоточных 
приложениях не идет, то лучше использовать класс StringBuilder, который не потокобезопасный, но при этом работает быстрее, чем StringBuffer 
в однопоточных приложениях.  */

package f10_String;

public class t8_String_Builder {
public static void main(String[] args) {
	String str = "Java";
		
		// Создание объекта StringBuilder 
	StringBuilder strA = new StringBuilder();   // Конструктор StringBuffer(int capacity) - резервирует 16 байт для хранения
	StringBuilder strB = new StringBuilder(30);   // Конструктор StringBuffer(int capacity) - резервирует заданное число байт для хранения
	StringBuilder strC = new StringBuilder(str);  // Конструктор StringBuffer(String str) - вносит строку str и плюс резервирует 16 байт для хранения
	StringBuilder strD = new StringBuilder("Инициализация при инициализации объекта" );
		//StringBuilder strE = new StringBuilder('a','b','c','d');      // Конструктор StringBuffer(CharSequence chars) 	- вносит последовательно симовлов + 16 байт для хранения
	  	
		// ПЕЧАТЬ В КОНСОЛЬ
	System.out.println(strC.toString()); // Для печати нужно перевести в String
	System.out.println(strD.toString()); 
		
		// С помощью метода capacity() мы можем получить количество символов, для которых зарезервирована память. 
	System.out.println("Capacity strC= " + strC.capacity()); 
	System.out.println("Capacity strC = " + strC.length());   // Кол-во символов в строке по факту
		
		// C помощью метода ensureCapacity() изменить минимальную емкость буфера символов
	strC.ensureCapacity(40);
	System.out.println("Capacity strC= " + strC.capacity()); 
		
		// Метод charAt() получает символ по определенному индексу:
	char c = strC.charAt(0); 
	System.out.println(c);

		//Метод setCharAt() устанавливает символ по определенному индексу:	
	strC.setCharAt(0, 'j');
	System.out.println(strC.toString()); 	
		
		//Метод getChars(int Begin, int End, char dst[], int Begin) получает набор символов между определенными индексами:
	int StartIndex = 0;
	int EndIndex = 3;
	char[] Array = new char[EndIndex - StartIndex];
	strC.getChars(StartIndex, EndIndex, Array, 0);
	System.out.println(Array);
		
		// Метод append() добавляет подстроку в конец StringBuilder
	char d = '_';		strC.append(d);   	System.out.println(strC.toString());    // Добавление символа
						strC.append(Array);	System.out.println(strC.toString());	// Добавление массива символов
						strC.append(2);		System.out.println(strC.toString());	// Добавление числа Int
						strC.append(3.0);	System.out.println(strC.toString());	// Добавление числа Double
						strC.append("_is_cool");	System.out.println(strC.toString());	// Добавление строки

		// Метод delete(int start, int end) удаляет все символы с определенного индекса до определенной позиции, 
	strC.delete(4,10);
	System.out.println("После удаления \t" + strC.toString());
						
		// Метод deleteCharAt() удаляет один символ по определенному индексу:
	strC.deleteCharAt(5);	strC.deleteCharAt(4);
	System.out.println("После удаления символа \t" + strC.toString());

		// Метод insert() добавляет строку или символ по определенному индексу в StringBuilder:
	strC.insert(0, 'J');	System.out.println(strC.toString());	// Добавление символа по нулевому индексу
	strC.insert(1, "1234_"); System.out.println(strC.toString());	// Добавление строки с 1 индекса

		// Метод substring() обрезает строку с определенного индекса до конца, либо до определенного индекса:
	// Обрезает только с переносом в другую строку
	String str1 = strC.substring(6); 	System.out.println("Вырезания с 6-го символа \t" + str1);	// Обрезает с 6 символа и до конца
	String str2 = strC.substring(6, 9);	System.out.println("Вырезания 6-9 \t" + str2);	// Обрезает с 6 символа и до 9
						
		// Для замены подстроки между определенными позициями в StringBuilder на другую подстроку применяется метод replace():
	strC.replace(0, 6, "!!!!!!!!!!!!");	 	System.out.println(strC.toString());	

		// Метод reverse() меняет порядок в StringBuffer на обратный:
	strC.reverse(); 	System.out.println(strC.toString());
	strC.reverse(); 	System.out.println(strC.toString());				
						
	}
}