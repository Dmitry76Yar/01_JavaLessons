package f22_In_Out_Streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
 Программа считывает со стандартного вхоодного потока 2 short числа и вывод в стандартный поток выход их сумму
 */

public class t00_Standard_In_Out_Streams {  // throws IOException
public static void main(String[] args) {
	int sum = 0;
	String str = null;
	BufferedReader bfr = null;
	try {
		bfr = new BufferedReader (new InputStreamReader(System.in));
		for (int i = 0; i<2; i++) {
			System.out.println("Введите число");
			str = bfr.readLine();
			try {
				sum  =  sum + Short.parseShort(str);}
			catch (NumberFormatException e) {
				System.out.println("Неверный формат числа");}
		}
	}
	catch (IOException e) {
		   System.out.println("Ошибка ввода - вывода");}
	System.out.println("Сумма чисел равна " + sum);
	
}
}