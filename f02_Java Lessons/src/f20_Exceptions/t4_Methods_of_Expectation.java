package f20_Exceptions;
/* Поскольку все классы исключений наследуются от класса Exception, то все они наследуют ряд его методов, которые позволяют получить информацию о характере исключения. Среди этих методов отметим наиболее важные:
	Метод getMessage() возвращает сообщение об исключении
	Метод getStackTrace() возвращает массив, содержащий трассировку стека исключения
	Метод printStackTrace() отображает трассировку стека */

public class t4_Methods_of_Expectation {
	public static int division (int a) {
	int result = 1;  result = 5/a; return result;}

public static void main(String[] args) {
	try {division(0);}
	catch (ArithmeticException ex) {
		System.out.println("Деление на ноль");
		System.out.println(ex.getMessage());	// Метод getMessage() возвращает сообщение об исключении
		System.out.println(ex.getStackTrace());	// Метод getStackTrace() возвращает массив, содержащий трассировку стека исключения
		ex.printStackTrace();
		System.out.println(ex.getCause());}					// Метод printStackTrace() отображает трассировку стека */
	}
}
