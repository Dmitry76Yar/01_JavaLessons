package f09_Arrays;
import java.util.Arrays;

/* Cами по себе массивы не переопределяют метод equals(). Поэтому если мы попробуем сравнить их так: 
int[] numbers = {1, 2, 3};      	int[] numbers2 = {1, 2, 3};       System.out.println(numbers.equals(numbers2));
получим результат false. 
	Ведь будет вызван метод Object.equals(), который сравнивает ссылки. А они, естественно, разные!  Но нам-то надо сравнить содержимое массивов, а не ссылки.
Класс Arrays содержит переопределенный метод equals(), который делает ровно то, что нам нужно */	

class t8_Equals_Arrays {
public static void main(String args[]) {
	
	//Сравнение двух одномерных массивов
System.out.println("Сравнение двух одномерных массивов");
int[] numbers = {1, 2, 3};
int[] numbers2 = {1, 2, 3};
int[] numbers3 = {1, 2, 2};
int[] numbers4 = {1, 2, 3, 0};
    System.out.println(Arrays.equals(numbers, numbers2));
	System.out.println(Arrays.equals(numbers, numbers3));
	System.out.println(Arrays.equals(numbers, numbers4));
	
	//Сравнение двух двумерных массивов
System.out.println("Сравнение двух двумерных массивов");
int[][] nums1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
int[][] nums2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
int[][] nums3 = {{1, 2, 3}, {4, 100, 6}, {7, 8, 9}};
	System.out.println(Arrays.deepEquals(nums1, nums2));
	System.out.println(Arrays.deepEquals(nums1, nums3));
	
	// 
	
}
}