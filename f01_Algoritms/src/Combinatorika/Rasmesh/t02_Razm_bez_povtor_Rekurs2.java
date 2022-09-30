package Combinatorika.Rasmesh;

import java.io.*;
import java.util.ArrayList;

/* The array of integers [3,4,7] has three elements and six permutations: 	n! = 3! = 1 x 2 x 3 = 6
Permutations: [3,4,7]; [3,7,4]; [4,7,3]; [4,3,7]; [7,3,4]; [7,4,3]
Recursive Algorithm
It's a recursive algorithm which produces all permutations by swapping one element per iteration.

 		РЕКУРСИВНЫЙ МЕТОД РАЗМЕЩЕНИЯ БЕЗ ПОВТОРЕНИЙ
  	Вводные данные 
 n - количество элементов, которые нужно менять. Например, для 1,2,3,4  при n = 3, меняются только элементы 1,2 и 3
 T<> elementis - массив Generic типа. В примере ниже изменен на Integer.
 delimeter -  разделитель при выводе на печать		
 	Вывод:
 Или печать, или сохранение строк-перестановок чисел в ArrayList    		*/

public class t02_Razm_bez_povtor_Rekurs2 {
	static ArrayList<String> arl = new ArrayList<String>();
		
	public static <Integer> void printAllRecursive( int n, int[] elements, char delimiter) {
	    if(n == 1) {
//	        printArray(elements);
	        addResultToTheList_AsString(elements);
	    } else {
	        for(int i = 0; i < n-1; i++) {
	            printAllRecursive(n - 1, elements, delimiter);
	            if(n % 2 == 0) {
	                swap(elements, i, n-1); 
	            } else {
	                swap(elements, 0, n-1);
	            }
	        }
	        printAllRecursive(n - 1, elements, delimiter);
	    }
	}

	private static <Integer> void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;	}
	
	private static <Integer> void printArray(int[] input) {
	    System.out.print('\n');
	    for(int i = 0; i < input.length; i++) {
	        System.out.print(input[i]);	   }	}
	
	private static String addResultToTheList_AsString(int[] input) {
	    StringBuffer sbf = new StringBuffer();
	    for(int i = 0; i < input.length; i++)   	sbf.append(input[i]);
	    String result = sbf.toString();
	    arl.add(result);
	    return result;
	}


public static void main(String[] args) throws IOException {
//	T <Integer> Array = new T <Integer> (1,2,3);
	int Array[] = {1,2,3,4};
	printAllRecursive(4, Array, ' ');
	System.out.println(arl);
}
}