package Sortirovka;
import java.util.Arrays;

/* 	Быстрая сортировка
	Это один из самых популярных алгоритмов, и поэтому на него стоит обратить особое внимание.
	Суть данного алгоритма заключается в том, что в списке с элементами выбирается опорный элемент — по сути любой элемент, 
относительно которого нужно отсортировать остальные значения. Значения меньше его — слева, значения больше — справа.
	Далее у правой и левой части также выбирается по опорному элементу и происходит то же самое: сортируются значения относительно
этих элементов, потом у образовавшихся частей выбираются  опорные элементы — и так до тех пор, пока мы не получим отсортированный
ряд.	
	Вне всяких сомнений, алгоритм быстрой сортировки считается самым популярным, так как в большинстве ситуаций он выполняется быстрее 
остальных, за время O(N*logN).
*/

public class t05_FastSort {
	
	public static void fastSort(int[] array) {
	       recursionFastSort(array, 0, array.length - 1);  }


	 public static void recursionFastSort(int[] array, int min, int max) {
	      if (array.length == 0)// условие выхода из рекурсии,  если длина массива равна 0
	          return;
	       if (min >= max) //выходим, так как нечего уже делить
	           return;

	       int middle = min + (max - min) / 2;  // выбираем середину
	       int middleElement = array[middle];

	       int i = min, j = max;
	       while (i <= j) {  // относительно элемента middle определяем меньшие элементы слева, большие справа
	           while (array[i] < middleElement) {
	               i++;	  }
	           while (array[j] > middleElement) {
	               j--;    }

	           if (i <= j) {      //меняем местами
	               int temp = array[i];
	               array[i] = array[j];
	               array[j] = temp;
	               i++;
	               j--;	   }
	       }

	       if (min < j) // запускаем рекурсию с элементами меньшими чем middle
	           recursionFastSort(array, min, j);

	       if (max > i)// запускаем рекурсию с элементами большими чем middle
	           recursionFastSort(array, i, max);
	   }
	
public static void main(String[] args) {
	int[] testArr = new int[]{6, 3, 10, 12, 6, 9, 4, 11, 1};
	fastSort(testArr);
    for (int i : testArr)   System.out.print(i + " ->");
	}
}
