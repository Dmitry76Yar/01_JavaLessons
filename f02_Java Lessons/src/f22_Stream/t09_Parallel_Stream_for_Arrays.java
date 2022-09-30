package f22_Stream;

import java.util.*;
import java.util.stream.Stream;

/*  В JDK 8 к классу Arrays было добавлено ряд методов, которые позволяют в параллельном режиме совершать обработку элементов массива. 
 * И хотя данные методы формально не входят в Stream API, но реализуют схожую функциональность, что и параллельные потоки. */

public class t09_Parallel_Stream_for_Arrays {
public static void main(String[] args) {
	
	int[] numbers = new int[6];
	Arrays.parallelSetAll(numbers, i -> i*10);
    for(int i: numbers)  System.out.print(i + "\t");
    
	/* parallelPrefix(): вычисляет некоторое значение для элементов массива (например, сумму элементов)
	parallelSetAll(): устанавливает элементы массива с помощью лямбда-выражения
	parallelSort(): сортирует массив */
    	
    
	}
}


        
  