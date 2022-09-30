package Recursiya;

import java.util.Scanner;

/* Максимум последовательности
Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите наибольшее значение числа в
этой последовательности. 
В этой задаче нельзя использовать глобальные переменные и передавать какие-либо параметры в рекурсивную функцию.
Функция получает данные, считывая их с клавиатуры. Функция возвращает единственное значение: максимум считанной 
последовательности. Гарантируется, что последовательность содержит хотя бы одно число (кроме нуля).
*/


public class r09_Max_Chislo_in_Row_of_Chisel {
	
    public static int recursion() {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	if (n == 0) return 0;
    	else {
    		return Math.max(n, recursion());
    	}
    }
    
    public static void main(String[] args) {
        System.out.println(recursion());
    }
}