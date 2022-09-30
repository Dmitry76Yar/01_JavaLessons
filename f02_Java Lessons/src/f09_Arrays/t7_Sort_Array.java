package f09_Arrays;
import java.util.Arrays;
import java.util.Collections;

public class t7_Sort_Array { 
public static void main(String args[]) {
	
		//Сортировка одномерного массива в процессе возрастания
	System.out.println("Сортировка одномерного INTEGER массива в процессе возрастания");
int myArray[] = {1, -10, 23, 4, 100};	
Arrays.sort (myArray);
System.out.println("\t" + Arrays.toString(myArray));
	System.out.println("Сортировка одномерного DOUBLE массива в процессе возрастания");
double myArrayDouble[] = {1.0, -10.2, 23.1, 4.5, 100.7};	
Arrays.sort (myArrayDouble);
System.out.println("\t" + Arrays.toString(myArrayDouble));

//			Сортировка одномерного массива в процессе убывания
//Arrays.sort(Arr_a, Collections.reverseOrder());

		// Сортировка начиная с i-го и заканчивая j-ым индексами
	System.out.println("Сортировка начиная с i-го и заканчивая j-ым индексами");
int myArray2[] = {1, -10, 23, 4, 100, -25, 74, 92};
Arrays.sort (myArray2, 2, 6);
System.out.println("\t" + Arrays.toString(myArray2));

	// Построчная сортировка двухмерного массива
int myArray1[][] = {
	{1, -10, 23, 4, 100},
	{-5, 10, 3, 56, 34}};
for (int i=0; i<myArray1.length; i++)  Arrays.sort (myArray1[i]);
for (int i=0; i<myArray1.length; i++) {
      for (int j=0; j<myArray1[i].length; j++)    System.out.print(myArray1[i][j] + "\t");
       System.out.println();} System.out.println();
	   
	//  Сортировка char массива
char myArrayCh[] = {'h', 'e', 'l', 'l', 'o'};	
Arrays.sort (myArrayCh);
for (int i = 0; i < myArrayCh.length; i++)   	System.out.print(myArrayCh[i] + "\t ");  	System.out.println("\n");
	   
	   
	   
	   
	   //


}
}