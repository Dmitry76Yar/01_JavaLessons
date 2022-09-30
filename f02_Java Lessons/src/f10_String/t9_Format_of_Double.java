package f10_String;

import java.text.DecimalFormat;

public class t9_Format_of_Double {
public static void main(String[] args) {
	
	
	double e = 2.7182818284590452353602875;
	int n = 10;

	String s = String.format("%1."+ n + "f", e);
	System.out.println(s);

	/* DecimalFormat
Kласс DecimalFormat редназначен для форматирования любого числа в Java, будь это целое число или число с плавающей запятой.
При создании экземпляра DecimalFormat мы можем передать ему строку форматирования. Она укажет, сколько десятичных разрядов 
нужно отформатировать для ввода. 
Как будет выглядеть наш пример с использованием DecimalFormat:  	 */
	double value = 34.766674;
	double value2 = 34.45235523523;
	DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
		// Строка #.### — это шаблон, который указывает, что мы форматируем передаваемое значение до 3 десятичных знаков.
	String result = decimalFormat.format(value);
	String resulta = decimalFormat.format(value2);
	System.out.println(result);		//34,767
	System.out.println(resulta);
	
	/* Чтобы изменить шаблон после создания объекта DecimalFormat, можно использовать его методы applyPattern
	и applyLocalizedPatter  */
	decimalFormat.applyPattern("#.#####");
	String result1 = decimalFormat.format(value);
	System.out.println(result1);		//34,7667
	
	/* При обрезании числа с знаками после запятой, выходящими за заданный шаблон, DecimalFormat округляет число в большую
	сторону, если последний обрезаемое число больше 5. Но что если число — 5? Получается, что оно ровно посередине между 
	ближайшими целыми. Что тогда?  В этом случае учитывается предыдущее число. 	 
	Если оно чётное, округление производится:
	Если нечётное — не производится: */
	double value1 = 7.4565;
	decimalFormat.applyPattern("#.###");
	String result2 = decimalFormat.format(7.4565);
	String result3 = decimalFormat.format(7.4575);
	System.out.println((result2));		// 7,457
	System.out.println((result2));		// 7,457
	}

}


