package Recursiya;

// Дано натуральное число n. Выведите все числа от 1 до n.

import java.io.*;

public class r02_Print_Chisla_From_1_to_N {
	
	static String printRecurs (int n) {
			// Базовый случай
		if (n==1) return "1";	
			// Шаг рекурсии / рекурсивное условие
		return printRecurs(n-1) + " " + n;
	}
	
public static void main(String[] args) throws IOException {
	int n = 5;
	System.out.println(printRecurs(n));

}
}




