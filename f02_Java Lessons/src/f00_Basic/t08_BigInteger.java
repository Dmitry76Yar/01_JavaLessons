package f00_Basic;

/* Класс Java BigInteger используется как аналог целочисленных значений произвольной длины, у которого нет ограничения в 64 битов,
 *  как например у long. При этом он потомок класса Number, как и стандартные обертки для числовых простых типов — Integer, Long, 
 *  Byte, Double и так далее — поэтому имеет реализации методов, приводящих к простым типам:
 */
import java.math.BigInteger;
import java.util.Random;

public class t08_BigInteger {
public static void main(String[] args) {
	
			// Создание такого объекта BigInteger с передачей в конструктор нашего значения, но в формате строки.
	BigInteger value = new BigInteger("32145");
			
			//Преобразование в другие форматы
	int intValue = value.intValue();//32145
	long longValue = value.longValue();//32145
	double doubleValue = value.doubleValue();//32145.0
	
			//Методы, реализующие стандартные арифметические операции на Java. 
			// Операции суммирования:
		BigInteger firstValue = new BigInteger("37995");
		BigInteger secondValue = new BigInteger("35466");
		BigInteger resultValue =  firstValue.add(secondValue);//73461
		
			// Операции  умножения:
		BigInteger resultValue1 =  firstValue.multiply(secondValue);//1347530670
		
			// Операции нахождения остатка при делении одного числа на другое:
		BigInteger resultValue2 =  firstValue.remainder(secondValue);//2529
		
			// Операции получение абсолютного значения числа (то есть по модулю, без знака):
		BigInteger resultValue3 =  firstValue.abs();//37995
		
			// Операции  с вычислением mod:
		BigInteger resultValue4 = firstValue.mod(secondValue); //1
		
			// Операции получение рандомного числа с заданием количества битов, которое будет использовать полученное значение:
		BigInteger firstValue1 = BigInteger.probablePrime(8, new Random());//211
		BigInteger secondValue1 = BigInteger.probablePrime(16, new Random());//42571
	
	
	}

}
