package f09_Arrays;
import java.util.Arrays;

/* Метод Arrays.binarySearch() умеет искать заданное значение в массиве. Это не обычный поиск, а так называемый бинарный поиск. Суть его:
 - Предварительно массив сортируется
 - Затем средний элемент массива сравнивается с искомым (с тем, который мы ищем).
 - Если искомый больше среднего, поиск продолжается в правой половине массива.  
Если искомый элемент меньше среднего, поиск продолжается в левой половине массива
Такой подход делает бинарный поиск очень быстрым. В массиве из миллиона(!) элементов он может найти индекс нужного элемента всего за 20 сравнений. 
Минусом такого подхода является то, что МАССиВ ПРЕДВАРиТЕЛЬНО НУЖНО ОТСОРТиРОВАТЬ, а сортировка тоже занимает время.*/	

class t9_Search_elements {
public static void main(String args[]) {
	
	/* Поиск числа в одномерном массиве с помощью метода binarySearch  - выдаст индекс элемента с этим числом
Выдаст индекс только первого найденного числа, другие проигнорирует */
System.out.println("Поиск числа в одномерном массиве");
int[] numbers = {2, 5, -10, 4, 1, 7};
	// МАССиВ ПРЕДВАРиТЕЛЬНО НУЖНО ОТСОРТиРОВАТЬ,
Arrays.sort (numbers);
System.out.println("После сортировки" + Arrays.toString(numbers));
	System.out.println(Arrays.binarySearch(numbers, 5));
	
System.out.println("Поиск символа    " + 'c' + "   в одномерном массиве");
char[] numbers2 = {'a', 'b', 'c', 'd', 'e', 'c'};
	System.out.println(Arrays.binarySearch(numbers2, 'c'));
	
/* Поиск числа в одномерном массиве, начиная с i-го и заканчивая j-ым элементом с помощью метода binarySearch */
System.out.println("Поиск числа в части одномерного массива");
System.out.println(Arrays.binarySearch(numbers,4,6,5));


}
}