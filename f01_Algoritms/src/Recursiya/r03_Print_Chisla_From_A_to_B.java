package Recursiya;

// Даны два целых числа A и В (каждое в отдельной строке). Выведите все числа от A до B включительно, в порядке возрастания, 
// если A < B, или в порядке убывания в противном случае.

import java.io.*;

public class r03_Print_Chisla_From_A_to_B {
	
	static String printRecurs (int a, int b) { 
		if (a<b) {
			if (a==b) return Integer.toString(a);;
			return Integer.toString(a) + "  " + printRecurs(a+1, b);
		}
		else {
			if (a==b) return Integer.toString(a);;
			return Integer.toString(a) + " " + printRecurs(a-1, b) ;
		}
	}
	
public static void main(String[] args) throws IOException {
	int a = 5;
	int b = 1;
	System.out.println(printRecurs(a, b));
	}
}




