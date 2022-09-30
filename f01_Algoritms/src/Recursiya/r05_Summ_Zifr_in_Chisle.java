package Recursiya;

/* Сумма цифр числа
Дано натуральное число N. Вычислите сумму его цифр.
При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется). */

import java.io.*;

public class r05_Summ_Zifr_in_Chisle {
	
	static int recurs (int n) {
		if (n==0) return 0;
		else return n%10 + recurs(n/10);
	}
	
public static void main(String[] args) throws IOException {
	int n = 12345;
	System.out.println(recurs(n));
}
}




