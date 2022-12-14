package Sortirovka;
import java.util.Arrays;

/*	Сортировка методом вставки
	В очередной раз для примера возьмём ряд чисел, которые мы хотим расставить в возрастающем порядке.
	Данный алгоритм заключается в выставлении маркера, слева от которого элементы будут уже частично отсортированы между собой. 
На каждом шаге алгоритма будет выбираться один из элементов и помещаться на нужную позицию в уже отсортированной последовательности.
Таким образом, отсортированная часть будет увеличиваться до тех пор, пока не будут просмотрены все элементы. 
	Вы спросите:а где же взять ту часть элементов, которые уже отсортированы и после которых и нужно ставить маркер? 
	Но ведь массив из первого элемента уже отсортирован, не так ли? 
Данный вид сортировки превосходит вышеописанные, так как несмотря на то, что время работы такое же — O(N²), 
этот алгоритм работает вдвое быстрее пузырьковой сортировки и немного быстрее сортировки выбором.	 */

public class t03_InsertionSort {
	
	public static void insertionSort(int[] array) {
       for (int i = 1; i < array.length; i++) { // i - разделяющий маркер
           int temp = array[i]; // делаем копию помеченного элемента
           int j = i;
           while (j > 0 && array[j - 1] >= temp) { // пока не будет найден меньший элемент
               array[j] = array[j - 1]; // сдвигаем элементы вправо
               --j;        }
	       array[j] = temp;   // вставляем отмеченный элемент, в положеное ему место
	       System.out.println(Arrays.toString(array));
	   }
    }
	
public static void main(String[] args) {
	int[] testArr = new int[]{6, 3, 10, 12, 6, 9, 4, 11, 1};
    insertionSort(testArr);
    for (int i : testArr)   System.out.print(i + " ->");
	}
}
