package Sortirovka;
import java.util.Arrays;

/*	Сортировка слиянием
	Эта сортировка тоже популярна. Она относится к одному из видов алгоритмов, работающих по принципу «разделяй и властвуй»: в них 
мы в первую очередь делим задачи на минимальные части (также представителем таких алгоритмов является быстрая сортировка).
 	Итак, в чём же суть данного алгоритма?
 		Разделяй: 	
 	Массив разбивается на две части примерно одинакового размера, каждая из этих двух частей делится еще на две, и так
далее, пока не останутся наименьшие неделимые части.
 	Наименьшие неделимые части — это когда в каждом массиве есть по одному элементу, а значит, такой массив автоматически считается
отсортированным.
		Властвуй:
	Тут и начинается процесс, задавший название алгоритму — слияние. Для этого берутся два получившиеся упорядоченных массива и
сливаются в один. При этом наименьший из первых элементов двух массивов записывается в результирующий массив, и эта операция
повторяется, пока не закончатся элементы в этих двух массивах.
	То есть, если у нас есть два минимальных массива {6} и {4}, их значения будут сравнены и записан результат: {4,6}. 
 	Если будут отсортированные массивы {4,6} и {2,8}, то сперва сравнится значение 4 и 2, из которых 2 будет записано в
результирующий массив. После этого будет сравниваться 4 и 8, 4 будет записано, и в конце сравнится 6 и 8. Соответственно, 6 будет
записано, и только после него — 8. В итоге мы получим результирующий массив: {2,4,6,8}.
 	Каким же образом это будет выглядеть в Java-коде?
 	Как и в быстрой сортировке, мы выносим рекурсивный метод в промежуточный, чтобы пользователю не нужно было заморачиваться над
заданием дополнительных дефолтных аргументов, а можно было всего лишь задать массив, который необходимо отсортировать.
	Так как данный алгоритм имеет схожесть с быстрей сотрировкой, то и скорость его выполнения та же — O(N*logN).
 	*/

public class t06_MergeSort {
	
	public static int[] mergeSort(int[] array1) {
	       int[] sortArr = Arrays.copyOf(array1, array1.length);// массив для сортировки
	       int[] bufferArr = new int[array1.length];// буферный массив
	       return recurtionMergeSort(sortArr, bufferArr, 0, array1.length);
	   }

	   public static int[] recurtionMergeSort(int[] sortArr, int[] bufferArr, int startIndex, int endIndex) {
	       if (startIndex >= endIndex - 1) {// выход из массива, когда в рассматриваемом промежутке массива, только один элемент
	           return sortArr;
	       }

	       // запускаем рекурсию, чтобы получить два отсортированных массива:
	       int middle = startIndex + (endIndex - startIndex) / 2;
	       int[] firstSortArr = recurtionMergeSort(sortArr, bufferArr, startIndex, middle);
	       int[] secondSortArr = recurtionMergeSort(sortArr, bufferArr, middle, endIndex);

	       // Слияние отсортированных массивов:
	       int firstIndex = startIndex;
	       int secondIndex = middle;
	       int destIndex = startIndex;
	       int[] result = firstSortArr == sortArr ? bufferArr : sortArr;
	       while (firstIndex < middle && secondIndex < endIndex) {
	           result[destIndex++] = firstSortArr[firstIndex] < secondSortArr[secondIndex]
	                   ? firstSortArr[firstIndex++] : secondSortArr[secondIndex++];
	       }
	       while (firstIndex < middle) {
	           result[destIndex++] = firstSortArr[firstIndex++];
	       }
	       while (secondIndex < endIndex) {
	           result[destIndex++] = secondSortArr[secondIndex++];
	       }
	       return result;
	   }
	
public static void main(String[] args) {
	int[] testArr = new int[]{6, 3, 10, 12, 6, 9, 4, 11, 1};
	testArr = mergeSort(testArr);
    for (int i : testArr)   System.out.print(i + " ->");
	}
}
 