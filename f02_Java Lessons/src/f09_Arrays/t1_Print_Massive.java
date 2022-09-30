package f09_Arrays;
import java.util.Arrays;

public class t1_Print_Massive { 
public static void main(String args[]) {
	
	/* Вывод на печать через Arrays.toString одномерного массива */
	int nums1[] = {-3,5,3,8,1};
	System.out.println(Arrays.toString(nums1));
	
	/* toString не преобразовывает числа в строку, а просто выводит на печать */
	for (int i = 0; i<nums1.length; i++)    nums1[i] +=10;
	System.out.println(Arrays.toString(nums1));
	
	/* Для массива типа char все аналогично*/
	char nums2[] = {'a', 'g', 'y', 'e', '1'};
	System.out.println(Arrays.toString(nums2));
		
	/* Вывод на печать через Arrays.toString для двухмерного массива
Для этого делается построчное обращение к массиву и использование к каждой строке метода toString*/
System.out.println("\tВывод на печать через Arrays.toString для двухмерного массива");
int[][] nums = new int[][] { 
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9} };
for (int i = 0; i < nums.length; i++)   	System.out.println(Arrays.toString(nums[i]));

	/* Вывод на печать двухмерного массива черех Arrays.deepToString */
System.out.println("\tВывод на печать двухмерного массива черех Arrays.deepToString");
System.out.println(Arrays.deepToString(nums));

	/* Вывод на печать через циклы
Сначала создается цикл для перебора по строкам, а затем внутри первого цикла создается внутренний цикл для перебора по столбцам конкретной строки. 
Подобным образом можно перебрать и трехмерные массивы и наборы с большим количеством размерностей. */
System.out.println("\tВывод на печать через циклы");
for (int i = 0; i < nums.length; i++){
    for(int j=0; j < nums[i].length; j++){
             
        System.out.printf("%d ", nums[i][j]);
    }
    System.out.println();
}
     
}
}