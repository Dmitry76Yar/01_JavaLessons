package f01_Converts;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


/*		 Использование классов-оболочек для преобразования числовых строк
 * 	В Java отсутствует метод, который читал бы числовые строки и преобразовывал их во внутреннюю двоичную форму.
 	Например, не существует варианта метода read () , который читал бы числовую строку "100" и автоматически преобразовывал ее в целое
число, пригодное для хранения в переменной типа int. 
	Проще всего подобное преобразование осуществляется с помощью так называемых оболочек типов (объектных оболочек) Java.
Объектные оболочки в Java представляют собой классы, которые инкапсулируют простые типы. Оболочки типов необходимы, поскольку простые
типы не являются объектами, что ограничивает их применение. Так, простой тип нельзя передать методу по ссылке.
	Кроме того, в классах-оболочках числовых типов содержатся методы, предназначенные для преобразования числовых строк в 
соответствующие двоичные эквиваленты. Каждый из них возвращает двоичное значение, соответствующее числовой  строке.
 - Double - static double parseDouble (String str) throws NumberFormatException
 - Float - 	static float parseFloat (String str) throws NumberFormatException
 - Long - 	static long parseLong (String str) throws NumberFormatException
 - Integer - static int parse!nt (String str) throws NumberFormatException
 - Short - 	static short parseShort (String str) throws NumberFormatException
 - Byte - 	static byte parseByte(String str) throws NumberFormatException
 
 Ниже приведен пример программы, демонстрирующий применениe для этих целей методов parseint () и parseDouble (). В этой программе
находится среднее арифметическое ряда чисел, введенных пользователем с клавиатуры. 
	Сначала пользователю предлагается указать количество подлежащих обработке числовых значений, а затем программа вводит числа с 
клавиатуры, используя метод readLine ( ) , а с помощью метода parseint () преобразует символьную строку в целочисленное значение.
Далее осуществляется ввод числовых значений и последующее их преобразование в тип douЫe с помощью метода parseDouЫe ().	 */

public class t3_ParseInt_ParseDouble  {
public static void main(String[] args) throws IOException {
		// Инициализация байтового потока по считыванию с клавиатуры
	int n = 0;
	double a = 0.0;
	BufferedReader bufstream = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Введите число цифр для расчета среднего арифметического");
	String str = bufstream.readLine();
		try {
			n = Integer.parseInt(str);}
		catch (NumberFormatException e) {
			System.out.println("В записи числа есть нецифровые символы");}
			
	System.out.println("Вы ввели " + n);
	double Array[] = new double [n];
	System.out.println("Введите числа");
		for (int i = 0; i<n; i++ ) {
			String a1;
			a1 = bufstream.readLine();
			try {
				a = Double.parseDouble(a1);
				Array[i] = a;}
			catch (NumberFormatException e) {
				System.out.println("В записи числа есть нецифровые символы");}
		}
	System.out.println(Arrays.toString(Array));
	double sum = 0.0;
	for (int i= 0; i<n; i++) { 	sum = sum + Array[i];	}
	System.out.println("Среднее значение " + sum/n);
	
	}
}