package Search_in_Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Алгоритм поиска элемента - возвращает индекс элемента или -1, если элемент не найден 

public class Search_in_Array {
	
	static ArrayList<Integer> listFoundElements = new ArrayList<Integer>();
		
		// Алгоритм линейного поиска элемента в массиве		Время работы - O(N)
	public static int linerSearch (int Arr[], int elementToBeFound) {
		for (int i = 0; i<Arr.length; i++) {
			if (Arr[i] == elementToBeFound) return i;		// Возвращает ПЕРВЫЙ найденный элемент
		}
		return -1;
	}
	
		// Алгоритм бинарного поиска элемента в массиве				Массив ДОЛЖЕН быть отсортирован
		// Данный алгоритм находит первый попавшийся необходимый элемент (на который попало деление массива пополам)
	public static int binarySearch (int Arr[], int startIndex, int endIndex, int elementToBeFound) {
				// Сравниваем разыскиваемый элемент со средним элементом массива, если он больше, то продолжаем поиск только 
				// в левой половине массива и так далее рекурсивно
		if (endIndex >=startIndex) {
			int middleIndex = (startIndex + endIndex)/2;
			System.out.println("startIndex = " + startIndex + "   , endIndex = " + endIndex + "   , middleIndex = " + middleIndex);
			if (Arr[middleIndex] == elementToBeFound) return middleIndex;
			if (Arr[middleIndex] > elementToBeFound) return binarySearch(Arr, startIndex, middleIndex - 1, elementToBeFound);
			else return binarySearch(Arr, middleIndex+1, endIndex, elementToBeFound);
		}
		return -1;
	}
	
	public static ArrayList<Integer> binarySearchAllElements (int Arr[], int startIndex, int endIndex, int elementToBeFound) {
			// Сравниваем разыскиваемый элемент со средним элементом массива, если он больше, то продолжаем поиск только 
				// в левой половине массива и так далее рекурсивно
		if (endIndex >=startIndex) {
			int middleIndex = (startIndex + endIndex)/2;
			System.out.println("startIndex = " + startIndex + "   , endIndex = " + endIndex + "   , middleIndex = " + middleIndex);
			if (Arr[middleIndex] == elementToBeFound) 	listFoundElements.add(middleIndex);
			if (Arr[middleIndex] > elementToBeFound)  binarySearchAllElements(Arr, startIndex, middleIndex - 1, elementToBeFound);
			else  binarySearchAllElements(Arr, middleIndex+1, endIndex, elementToBeFound);
		}
		return listFoundElements;
	}
	
public static void main(String[] args) {
	int[] testArr = new int[]{6,3,8,2, 6,9,4,11,1, 57, 57, 75};
	System.out.println("Линейный поиск:   " + linerSearch(testArr, 57));
	
	Arrays.sort(testArr);
	System.out.println("Бинарный поиск:   " + binarySearch(testArr, 0, testArr.length, 57) + "\n");	
	
	ArrayList<Integer> listFoundElements = new ArrayList<Integer>();
	listFoundElements = binarySearchAllElements(testArr, 0, testArr.length, 57);
	System.out.println(listFoundElements);
	}
}
