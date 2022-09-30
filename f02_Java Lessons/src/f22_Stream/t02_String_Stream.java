package f22_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* Stream 
 * По коллекциям Arraylist и другим можно пробегать циклом for или for each
 * Недостаток это, что весь цикл должен быть выполнен непрерывно в одном ядре процессора.
 * Для многоядерных процессоров лучше использовать потоки       */


public class t02_String_Stream  {
public static void main(String[] args) {
	ArrayList<String> arrlist = new ArrayList<>();
	arrlist.add("a1"); 	arrlist.add("a23");	 arrlist.add("b1"); 	arrlist.add("c32");	arrlist.add("d33"); 	arrlist.add("b");
		// Печать исходного списка
	arrlist.stream().forEach(s -> System.out.print(s + "\t" ));					System.out.println();
	
		// Метод Object[] toArray(): возвращает массив из элементов потока.
	System.out.println(Arrays.toString(arrlist.stream().toArray()));
	
		// Метод Stream distinct() возвaщает из исходного потока новый поток, не содержащий повторяющихя элементов 
	arrlist.stream().distinct().forEach(s -> System.out.print(s + "\t" )); 		System.out.println();
	
		// Метод Stream FILTER(Predicate<? super T> predicate) возвaщает из исходного потока новый отфильтрованный поток
    arrlist.stream().filter(s -> s.toLowerCase().startsWith("b")).forEach(s -> System.out.print(s  + "\t" ));		System.out.println();
    arrlist.stream().filter(s->s.length()==6).forEach(s -> System.out.print(s  + "\t" ));		System.out.println();
    
 		// COLLECT чтобы получить данные не в виде потока, а в виде обычной коллекции, например, ArrayList или HashSet.
 		// toList(): преобразование к типу List
 		// toSet(): преобразование к типу Set
 		// toMap(): преобразование к типу Map
 	List<String> filteredArrlist =arrlist.stream().filter(s -> s.toLowerCase().startsWith("b")).collect(Collectors.toList());
 	System.out.println("Список до фильтрации " + arrlist);
 	System.out.println("Список после фильтрации " + filteredArrlist);
	
		// Метод skip(long n)  возвращает новый поток, в котором пропущены первые n элементов.
	 	// Метод limit(long n) возвращает модифицированный поток, в котором не более n элементов.
	 	// Удобно использовать в паре для выбора определенных номеров объектов - ниже выбор 2 и 3-го объектов
	arrlist.stream().skip(1).limit(2).forEach(s->System.out.print(s + "\t"));  System.out.println();
		
		// Метод Stream limit(long maxSize) возвaщает из исходного потока новый поток, содержащий указанное количество элементов а 
	arrlist.stream().limit(2).forEach(s -> System.out.print(s + "\t" ));		System.out.println();
	
     
     	// Метод Stream sorted() возвaщает из исходного потока новый отсортированный поток
     arrlist.stream().sorted().forEach(s -> System.out.print(s + "\t" ));		System.out.println();
     
  		// Метод long count() возвращает число элементов в потоке
     System.out.println("Число элементов в потоке = " + arrlist.stream().count());
     	// Удобно использовать для подсчета числа элементов, удовлетворяющих условиям
     System.out.println(arrlist.stream().filter(n->n.length()<=2).count());
     
	  	// boolean allMatch, anyMatch, noneMatch
	 	// allMatch(Predicate<? super T> predicate): возвращает true, если все элементы потока удовлетворяют условию в предикате
	 	// anyMatch(Predicate<? super T> predicate): возвращает true, если хоть один элемент потока удовлетворяют условию в предикате
	 	// noneMatch(Predicate<? super T> predicate): возвращает true, если ни один из элементов в потоке не удовлетворяет условию в предикате
 	System.out.println("Все строки начинаются с b - это " + arrlist.stream().allMatch(w -> w.startsWith("b")));		
 	System.out.println("Есть хотя бы одна строка начинается с b - это " + arrlist.stream().anyMatch(w -> w.startsWith("b")));
 		
 		// Метод Stream<T> dropWhile​(Predicate<? super T> predicate): выводит элементы, которые соответствуют условию, 
 	    // пока не попадется элемент, который не соответствует условию. Выбранные элементы возвращаются в виде потока. 
 	 arrlist.stream().sorted().dropWhile(w -> w.startsWith("c")).forEach(w -> System.out.print(w + "\t" ));		System.out.println();
     
 	 	// Метод concat() объединяет элементы двух потоков, возвращая объединенный поток:
 	 Stream.concat(Stream.of("a", "b", "c"), Stream.of("a", "f" , "e")).forEach(n -> System.out.print(n + "\t")); 	System.out.println();
 	    
     	// Метод Optional<T> min (Comparator<? super T> comparator): возвращает минимальный элемент из потока. 
		// Метод Optional<T> max (Comparator<? super T> comparator): возвращает минимальный элемент из потока.	
		// Оба метода возвращают элемент потока (минимальный или максимальный), обернутый в объект Optional.
		// Для сравнения элементов применяется компаратор comparator.
 	 	// Затем с помощью метода get() мы можем получить собственно результат вычислений: result.get()
 	 	// Для строк сравнение иде по лексографическому порядрку
     System.out.println("Минимальный элемент ArrayList - "  + arrlist.stream().min(String::compareTo).get());
     System.out.println("Максимальный элемент ArrayList - "  + arrlist.stream().max(String::compareTo).get());
 	 
	 	// Метод Optional<T> reduce(BinaryOperator<T> accumulator) выполняет терминальные операции сведения, возвращая 
	    // некоторое значение - результат операции.
 	 System.out.println(" Результат сведения со сложением строк = " + arrlist.stream().reduce((x,y)->x +"" + y).get());
 	 
 	 	// Метод T reduce(T identity, BinaryOperator<T> accumulator) сводит еще значение параметра identity  
 	 System.out.println(" Результат сведения со сложением строк с identity = " + 
 			 arrlist.stream().reduce("identity", (x,y)->x +"" + y));
 	 
	
	}
}
        
        
  