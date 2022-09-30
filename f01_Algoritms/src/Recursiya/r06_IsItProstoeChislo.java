package Recursiya;

/* Разложение на множители
Дано натуральное число n>1. Выведите все простые множители этого числа в порядке неубывания с учетом кратности. Алгоритм должен
иметь сложность O(logn). */

public class r06_IsItProstoeChislo {
	
	public static String recursion(int n, int del) {
		if (del > n) return "";
		else {
			if (n%del == 0) return Integer.toString(del) + " " + recursion(n/del, 2);
			else return recursion(n, del+1);
		}
	}
	
public static void main(String[] args) {
    	int n = 1600;
    	System.out.println(recursion(n, 2));
    }
}



