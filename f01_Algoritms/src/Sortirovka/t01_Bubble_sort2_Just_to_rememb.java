package Sortirovka;

import java.util.Arrays;

public class t01_Bubble_sort2_Just_to_rememb {
	
	public static void bubbleSort (int Arr[]) {
		boolean isSorted = false;
		
		while (isSorted == false) {						// Цикл для повтореняи операции пока все будет не отсортировано
			isSorted = true;
			for (int i = 0; i<Arr.length-1; i++) {		// Сравнение левого и правого элементов и обмен их местами
				if (Arr[i]>Arr[i+1]) {
					int a = Arr[i];
					Arr[i] = Arr[i+1];
					Arr[i+1] = a;
					isSorted = false;
				}
				System.out.println(Arrays.toString(Arr));
			}
		}
	}
		
public static void main(String[] args) {
	int[] testArr = new int[]{6,3,8,2, 6,9,4,11,1};
    bubbleSort(testArr);
       for (int i : testArr) {
           System.out.print(i + " -> ");
       }
   }
}
