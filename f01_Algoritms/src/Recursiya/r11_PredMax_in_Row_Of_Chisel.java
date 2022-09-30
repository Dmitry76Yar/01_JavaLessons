package Recursiya;

import java.util.Scanner;

/* Второй максимум
Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите значение второго по величине
элемента в этой последовательности, то есть элемента, который будет наибольшим, если из последовательности удалить наибольший
элемент.
В этой задаче нельзя использовать глобальные переменные. Функция получает данные, считывая их с клавиатуры, а не получая их в виде
параметра.
*/


public class r11_PredMax_in_Row_Of_Chisel {
	
    public static int recursion(int a, int b) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	if (n>a) {
    		b = a;
    		a = n; 
    	}
    	else if (n>b) b = n;
    	if (n == 0) {
    		System.out.println(" a = " + a + " , b = " + b);
    		return b;
    	}
    	else {
    		return (recursion(a, b)); 
    	}
    }
    
    public static void main(String[] args) {
        System.out.println(recursion(0,0));
    }
}