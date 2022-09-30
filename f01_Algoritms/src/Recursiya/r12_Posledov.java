package Recursiya;

import java.util.Scanner;

/* R: Треугольная последовательность
Дана монотонная последовательность, в которой каждое натуральное число k встречается ровно k раз: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4,…
По данному натуральному n выведите первые n членов этой последовательности. Попробуйте обойтись только одним циклом for.
*/

public class r12_Posledov {
	
    public static String recursion(int n, int count, int count2) {
    	if (count2 >= n) return "";
    	else {
    		String str = "";
    		for (int i = 0; i<count; i++) {
    			if (count2 == n) break;
    			str = str + " " + Integer.toString(count);
    			count2++;
    		}
    		return str + ""  + recursion(n, ++count, count2);
    	}
    }
    		
    public static void main(String[] args) {
    	int n = 11;
    	System.out.println(recursion(n, 1, 0));
    }
}