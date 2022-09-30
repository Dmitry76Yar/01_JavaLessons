package Recursiya;

import java.util.Scanner;

/* Среднее значение последовательности
Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите среднее значение элементов
этой последовательности (без учета последнего нуля).
	В этой задаче нельзя использовать глобальные переменные. Функция получает данные, считывая их с клавиатуры
*/


public class r10_Average_in_Row_Of_Chisel {
	
    public static double recursion(int sum, int count) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	if (n == 0) return sum/count;
    	else {
    		return (recursion(sum+n, ++count)); 
    	}
    }
    
    public static void main(String[] args) {
        System.out.println(recursion(0,0));
    }
}