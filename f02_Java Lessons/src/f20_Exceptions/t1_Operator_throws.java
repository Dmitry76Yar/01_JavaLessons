package f20_Exceptions;
/* Оператор throws
Иногда метод, в котором может генерироваться исключение, сам не обрабатывает это исключение. В этом случае в объявлении метода 
используется оператор throws, который надо обработать при вызове этого метода. 
Например, у нас имеется метод вычисления факториала, и нам надо обработать ситуацию, если в метод передается число меньше 1
Без обработки исключение у нас возникнет ошибка компиляции, и мы не сможем скомпилировать программу. */

public class t1_Operator_throws{
	
	/* С помощью оператора throw по условию выбрасывается исключение. В то же время метод сам это исключение не
		обрабатывает с помощью try..catch, поэтому в определении метода используется выражение throws Exception.  */
public static int factorial (int num)  throws Exception {
		if (num<1) throw new Exception ("Число меньше единицы");
		int result = 1;
		for (int i=1; i<=num; i++) result = result*i;
		return result; 	}

	/* В качестве альтернативы мы могли бы и не использовать оператор throws, а обработать исключение прямо в методе: */
public static int factorial2 (int num) {
	int result = 1;
	try {
		if (num<1) throw new Exception ("Число меньше единицы");
		for (int i=1; i<=num; i++) result = result*i; }
	catch (Exception ex) {
		System.out.println(ex.getMessage()); 
		result = num;}
	return result;  }

public static void main(String[] args) {
	int result = 0;
						// Теперь при вызове метода factorial нам обязательно надо обработать выбрасываемое исключение
	System.out.println("При генерации исключения в методe, а обработке исключения уже в основной программе");
	try {
		result = factorial(0);
		System.out.println(result); }
	catch(Exception ex) {
		System.out.println(ex.getMessage()); }
	
	System.out.println("\n При генерации и обработке исключения сразу в методе");
	int result2 = 1;
	result2 = factorial2(-5);
	System.out.println(result2); 
	}
}
