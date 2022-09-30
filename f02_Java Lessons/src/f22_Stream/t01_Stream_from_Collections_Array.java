package f22_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* Stream 
 * По коллекциям Arraylist и другим можно пробегать циклом for или for each
 * Недостаток это, что весь цикл должен быть выполнен непрерывно в одном ядре процессора.
 * Для многоядерных процессоров лучше использовать потоки       */


public class t01_Stream_from_Collections_Array {
public static void main(String[] args) {
	 
    ArrayList<String> cities = new ArrayList<String>();
    Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
    String arrayStr[] = {"Париж1", "Лондон1", "Мадрид1"};
    int arrayInt[] = {-1,2,4,7,-3,0, 4, 4};	
    
    	// ДЛЯ МАССИВОВ
    Stream<String> stringStream = Arrays.stream(arrayStr) ;
    Stream<String> stringStream2 =Stream.of(arrayStr);
    IntStream intStream = Arrays.stream(arrayInt);
    IntStream intStream2 = IntStream.of(arrayInt);
    	// Создание через лямба-выражение
    IntStream.of(arrayInt).forEach(w -> System.out.print(w + "\t"));		System.out.println();
    Stream.of(arrayStr).forEach(w -> System.out.print(w + "\t"));		System.out.println();
    
    	// ДЛЯ COLLECTIONS (ARRAYLIST, LINKEDLIST)
    	// Метод default Stream<E> stream: возвращается поток данных из коллекции
    Stream<String> citiesStream = cities.stream(); 
    citiesStream.forEach(s->System.out.print(s + " \t"));		System.out.println();
    	// Создание через лямба-выражение
    cities.stream().forEach(s->System.out.print(s + " \t"));		System.out.println();
   
    
    	// Метод default Stream<E> parallelStream: возвращается параллельный поток данных из коллекции
    	// ИСПОЛЬЗУЕТСЯ ДЛЯ перебора больших коллекций для разделения задачи между ядрами процессора
    Stream<String> citiesStream1 = cities.parallelStream(); 
    citiesStream1.forEach(s->System.out.print(s + " \t"));		System.out.println();
    	// Создание через лямба-выражение
    cities.parallelStream().forEach(s->System.out.print(s + " \t"));		System.out.println();
    
    	/* Важно, что после использования терминальных операций (результирующие, например forEach() другие терминальные 
    или промежуточные операции (на выходе преобразованный поток)  к этому же потоку не могут быть применены, поток уже употреблен
    	Фактически жизненный цикл потока проходит следующие три стадии:
      - Создание потока
      - Применение к потоку ряда промежуточных операций
      - Применение к потоку терминальной операции и получение результата */
    Stream<String> citiesStream2 = cities.stream(); 		// получаем поток
    citiesStream2.forEach(s->System.out.println(s)); 		// терминальная операция употребляет поток
//    long number = citiesStream2.count(); 					// здесь ошибка, так как поток уже употреблен
    
    
//    citiesStream.forEach(s->System.out.println(s)); 	// терминальная операция употребляет поток
//    	long number = citiesStream.count(); 			// здесь ошибка, так как поток уже употреблен
//    	System.out.println(number);


    

}
}
