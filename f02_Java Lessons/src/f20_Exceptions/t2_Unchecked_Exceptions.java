package f20_Exceptions;
/* Базовым классом для всех исключений является класс Throwable. От него уже наследуются два класса: Error и Exception.
Все остальные классы являются производными от этих двух классов. 
Класс Error описывает внутренние ошибки в исполняющей среде Java. Программист не имеет возможности для обработки подобных ошибок.
	Класс Exception - суперкласс для всех исключений, нампример для класса RuntimeException. 
	
RuntimeException является базовым классом для так называемой группы непроверяемых исключений (unchecked exceptions).
Такие исключения выбрасываются по умолчанию и не требуется указывать оператор throws в объявлении метода. 
Такие исключения являются следствием ошибок разработчика, например, неверное преобразование типов или выход за пределы массива.  */

public class t2_Unchecked_Exceptions {
	
	// Исключение ArithmeticException - деление на ноль.  Наследник класса RuntimeException, не требует указания оператора throws
public static int division (int a) {
	int result = 1;  result = 5/a; return result;}

	// Исключение IndexOutOfBoundsException: индекс вне границ массива. Наследник класса RuntimeException, не требует указания оператора throws
public static int sumArray (int a[], int b) {
	int result = 1; result = a[b] + a[b+1]; return result;} 

	// Исключения NullPointerException: использование пустой ссылки. Наследник класса RuntimeException, не требует указания оператора throws
public static String join (String a) {
	String result; result = a.concat("plus"); return result;}

public static void main(String[] args) {
	System.out.println("\t Исключение ArithmeticException - деление на ноль. Не требует throws в методe division");
try {division(0);}
catch (ArithmeticException ex) {System.out.println("Деление на ноль");}
	
	System.out.println("\t Исключение IndexOutOfBoundsException. Не требует throws в методe sumArray");
int Array[] = {1,2,4};
try {sumArray(Array, 2); }
catch (IndexOutOfBoundsException ex1) {System.out.println("индекс вне границ массива");}

	System.out.println("\t Исключение NullPointerException. Не требует throws в методe sumArray");
String a = null; 
try {System.out.println(join(a));}
catch (NullPointerException ex) {System.out.println("Использование пустой ссылки");}
	
	}
}