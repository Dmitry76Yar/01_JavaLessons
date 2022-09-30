package Recursiya;

/* Точная степень двойки
Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки, или слово NO в противном случае. 
если A < B, или в порядке убывания в противном случае.   */

import java.io.*;

public class r04_Stepen_Dvoiki {
	
	static int recurs (int n) {
		if (n==0) return 0;
		if (n==1) return 1;
		
		if (n%2 == 0) return recurs((int)n/2);
		else return 0;
	}
	
public static void main(String[] args) throws IOException {
	int n = 16;
	if (n==1) System.out.println("NO");
	else {
		if (recurs(n) ==0) System.out.println("NO");
		else System.out.println("YES");}
	}
}




