package Recursiya;

import java.util.Arrays;

/* Вывести все сочетания, состоящие из k чисел, без повторений для всех чисел от 1 до n		*/

public class r00_How_Save_in_Array {
	
    public static void recursion(int n, int k, int store[], int counter) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	
    	int i_min;
    	if (counter<k) {
    		if (counter == 0) i_min = 1; 
    		else i_min = store[counter-1] +1;
    		for (int i = i_min; i<=n; i++) {
    			store[counter] = i;
    			recursion(n, k, store, counter+1);
    		}
    	}
    	else {
    		System.out.println(Arrays.toString(store));
    	}
    }
    
    public static void main(String[] args) {
    	int n = 5;
    	int k = 3;
    	int a[] = new int[k];
    	recursion(n, k, a, 0);
    }
}