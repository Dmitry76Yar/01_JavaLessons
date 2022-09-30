package Recursiya;

import java.util.Arrays;

// Вывести все числа, состоящие из k цифр от 1 до 9.  Число не может начинаться с нуля

public class r16_Vse_K_znachnie_Chisla {
	
    public static void recursion(int k, int store[], int counter) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	int i_min;
    	if (counter == 0) i_min = 1;
    	else i_min = 0;
    	if (counter < k) {
    		for (int i = i_min; i<=9; i++) {
	    		store[counter] = i; 
	    		recursion(k, store, counter+1);
    		}
    	}
    	else {
    		System.out.println(Arrays.toString(store));
    	}
    }
    
    public static void main(String[] args) {
    	int k = 2;
    	int a[] = new int[k];
    	recursion(k, a, 0);
    }
}