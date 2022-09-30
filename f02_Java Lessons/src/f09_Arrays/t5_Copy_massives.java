package f09_Arrays;
import java.util.Arrays;

class t5_Copy_massives {
public static void main(String args[]) {
    int myArray[] = {1, -10, 23, 4, 100};	
	
	// Копирование одномерного массива через циклы
System.out.println("Копирование одномерного массива через циклы");
int myArray1[] = new int[myArray.length];
for(int i=0; i < myArray.length; i++)     myArray1[i] = myArray[i]; 
	System.out.println(Arrays.toString(myArray1));
	
	// Копирование одномерного массива через Arrays.copyOf
System.out.println("Копирование одномерного массива через Arrays.copyOf");
int myArray2[] = Arrays.copyOf(myArray, myArray.length);
	System.out.println(Arrays.toString(myArray2));
System.out.println("При копирование в массив меньшего размера копируются только первые элементы оригинального массива");	
int myArray3[] = Arrays.copyOf(myArray, 3);
	System.out.println(Arrays.toString(myArray3));
	System.out.println("При копирование в массив большего размера соответственно...");	
int myArray4[] = Arrays.copyOf(myArray, 10);
	System.out.println(Arrays.toString(myArray4));
	
	/* Частичное копирование одномерного массива через Arrays.copyOfRange 
В новый массив были скопированы числа из ячеек со второй (включительно) по четвертую (не включительно). */
System.out.println("Частичное копирование одномерного массива через Arrays.copyOfRange");	
int myArray5[] = Arrays.copyOfRange(myArray, 2, 4);
	System.out.println(Arrays.toString(myArray5));
	
	// Копирование двухмерного массива через построчное Arrays.copyOf
System.out.println("Копирование двухмерного массива через построчное Arrays.copyOf");
int myArray6[][] = { 
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9} };	
int myArray6_Copy [][] = myArray6.clone();		// инициализация массива через метод clone
for (int i=0; i<myArray6.length; i++)  myArray6_Copy[i] = Arrays.copyOf(myArray6[i], myArray6[i].length);
System.out.println(Arrays.deepToString(myArray6_Copy));

	// Слияние двух двухмерных массивов
// myArray7 = {{1, 2, 3},  {4, 5, 6}};
// myArray8 = {{10, 20, 30},  {40, 50, 60}};
	
}
}