package Recursiya;

import java.util.Scanner;

/* P: Количество элементов, равных максимуму
Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите, какое количество элементов 
этой последовательности, равны ее наибольшему элементу.
В этой задаче нельзя использовать глобальные переменные. Функция получает данные, считывая их с клавиатуры, а не получая их в 
виде параметра.
*/

public class r13_Number_of_MaxChisel {
	
    public static int recursion(int a, int count) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	if (n == a) count++;
    	else if (n>a) {
    		a = n;
    		count = 1;;
    	}
    	if (n == 0) {
    		System.out.println(" a = " + a + " , count = " + count);
    		return count;
    	}
    	else {
    		return (recursion(a, count)); 
    	}
    }
    
    public static void main(String[] args) {
        System.out.println(recursion(0,0));
    }
}