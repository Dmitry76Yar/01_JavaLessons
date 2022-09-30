package f20_Exceptions;

/* Хотя имеющиеся в стандартной библиотеке классов Java классы исключений описывают большинство исключительных ситуаций, которые 
 могут возникнуть при выполнении программы, все таки иногда требуется создать свои собственные классы исключений со своей логикой.
 	Чтобы создать свой класс исключений, надо унаследовать его от класса Exception. Например, у нас есть класс, вычисляющий факториал, 
 и нам надо выбрасывать специальное исключение, если число, передаваемое в метод, меньше 1 */

public class t5_Own_Exceptions {

public static int factorial (int n) throws OwnException {		// Т.к.исключение обрабатывается в main, то  указываем throws OwnException 
		int result = 1;
		if (n<1) throw new OwnException("Деление на ноль", n);	/* Для генерации исключения в методе вычисления факториала выбрасывается 
																  исключение с помощью оператора throw: throw new OwnException("Деление на ноль", n) */ 
		for (int i=1; i<=n; i++) result = result*i;
		return result;}
	
public static void main(String[] args) {
	int result;
	try {	result = factorial(-1); 
			System.out.println(result);}
	catch (OwnException ex) {System.out.printf("Сообщение: %s, \t число: %d", ex.getMessage(), ex.getNumber());}
	}
}

class OwnException extends Exception {		/* Для определения ошибки, связанной с вычислением факториала, определен класс OwnException,
											   который наследуется от Exception и который содержит всю информацию о вычислении.*/
	private int number;
	public int getNumber() { return number; 	} 	/* В конструкторе OwnException в конструктор базового класса Exception передается 
														сообщение об ошибке: super(message). Кроме того, отдельное поле предназначено для 
														хранения числа, факториал которого вычисляется. */
	public OwnException(String message, int number) {	
		super(message);
		this.number = number;	}
}
