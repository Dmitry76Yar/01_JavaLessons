package f22_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* Stream 
 * По коллекциям Arraylist и другим можно пробегать циклом for или for each
 * Недостаток это, что весь цикл должен быть выполнен непрерывно в одном ядре процессора.
 * Для многоядерных процессоров лучше использовать потоки       */


public class t03_Int_Double_LongStream {
public static void main(String[] args) {
	ArrayList<Integer> intArl = new ArrayList<Integer>();
	intArl.add(4);		intArl.add(1);		intArl.add(6);		intArl.add(2);		intArl.add(-2);		intArl.add(-5);	intArl.add(2);	
	int array[] = {-1,2,4,7,-3,1, 4, 4};	
	
		// ДЛЯ МАССИВОВ
    IntStream intStream = Arrays.stream(array);
    IntStream intStream2 = IntStream.of(array);
    	// Создание через лямба-выражение
    IntStream.of(array).forEach(w -> System.out.print(w + "\t"));		System.out.println();
    Stream.of(array).forEach(w -> System.out.print(w + "\t"));		System.out.println();
    
    	// ДЛЯ COLLECTIONS (ARRAYLIST, LINKEDLIST)
    	// Метод default Stream<E> stream: возвращается поток данных из коллекции
    Stream<Integer> intArlStream = intArl.stream(); 
    intArlStream.forEach(s->System.out.print(s + " \t"));		System.out.println();
    	// Создание через лямба-выражение
    intArl.stream().forEach(s->System.out.print(s + " \t"));		System.out.println();
	
		// FILTER Печать только отрицательных чисел
	IntStream.of(array).filter(w -> w < 0).forEach(w -> System.out.print(w + "\t"));		System.out.println();
	intArl.stream().filter(w -> w < 0).forEach(w -> System.out.print(w + "\t"));		System.out.println();
		
		// FILTER Печать только отрицательных чисел
		// + COLLECT чтобы получить данные не в виде потока, а в виде обычной коллекции, например, ArrayList или HashSet.
		// toList(): преобразование к типу List
		// toSet(): преобразование к типу Set
		// toMap(): преобразование к типу Map
	List<Integer> filteredIntArl = intArl.stream().filter(w -> w < 0).collect(Collectors.toList());
	System.out.println("Список до фильтрации " + intArl);
	System.out.println("Список после фильтрации " + filteredIntArl);
	
		// Метод Object[] toArray(): возвращает массив из элементов потока.
	System.out.println(Arrays.toString(intArl.stream().toArray()));
	System.out.println(Arrays.toString(IntStream.of(array).toArray()));
	
		// Метод Stream distinct() возвaщает из исходного потока новый поток, не содержащий повторяющихя элементов 
	intArl.stream().distinct().forEach(s -> System.out.print(s + "\t" )); 		System.out.println();
		
		// Метод Stream sorted() возвaщает из исходного потока новый отсортированный поток
	IntStream.of(array).sorted().forEach(s -> System.out.print(s + "\t" ));			System.out.println();
	
		// Метод Stream<T> dropWhile​(Predicate<? super T> predicate): выбирает из потока элементы, пока они НЕ соответствуют условию 
	IntStream.of(1, -3, -2, -1, 0, 1, 2, 3, -4, -5).dropWhile(n -> n < 0).forEach(w -> System.out.print(w + "\t" ));		System.out.println();
 
		// Метод Stream<T> takeWhile​(Predicate<? super T> predicate): выбирает из потока элементы, пока они соответствуют условию 
	IntStream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5).takeWhile(n -> n < 0).forEach(w -> System.out.print(w + "\t" ));		System.out.println();
	
		// Метод concat() объединяет элементы двух потоков, возвращая объединенный поток:
	IntStream.concat(IntStream.of(-3, -2, -1), IntStream.of(-3, -2, -1)).forEach(n -> System.out.print(n + "\t"));
	
		// Метод Stream<T> skip(long n): возвращает поток, в котором отсутствуют первые n элементов
	IntStream.of(array).skip(3).forEach(s -> System.out.print(s + "\t" ));			System.out.println();
	
		// Метод long count() возвращает число элементов в потоке
    System.out.println("Число элементов в потоке = " + IntStream.of(array).count());
    	// Удобно использовать для подсчета числа элементов, удовлетворяющих условиям
    System.out.println("Число элементов в потоке > 0 = " + IntStream.of(array).filter(n-> n>0).count());
    
    	// Метод skip(long n)  возвращает новый поток, в котором пропущены первые n элементов.
 		// Метод limit(long n) возвращает модифицированный поток, в котором не более n элементов.
 		// Удобно использовать в паре для выбора определенных номеров объектов - ниже выбор 2 и 3-го объектов
    IntStream.of(array).skip(1).limit(2).forEach(s->System.out.print(s + "\t"));  System.out.println();
    
    	// boolean allMatch, anyMatch, noneMatch
    	// allMatch(Predicate<? super T> predicate): возвращает true, если все элементы потока удовлетворяют условию в предикате
    	// anyMatch(Predicate<? super T> predicate): возвращает true, если хоть один элемент потока удовлетворяют условию в предикате
    	// noneMatch(Predicate<? super T> predicate): возвращает true, если ни один из элементов в потоке не удовлетворяет условию в предикате
	System.out.println("Все цифры отрицательные - это " + IntStream.of(array).allMatch(w -> w<0));		
	System.out.println("Есть хотя бы одна отрицательная цифра - это " + IntStream.of(array).anyMatch(w -> w<0));
	System.out.println("Ни один из элементов не больше 100 - это " + IntStream.of(array).noneMatch(w -> w>100));
	
		// Метод Optional<T> min (Comparator<? super T> comparator): возвращает минимальный элемент из потока. 
		// Метод Optional<T> max (Comparator<? super T> comparator): возвращает минимальный элемент из потока.	
		// Оба метода возвращают элемент потока (минимальный или максимальный), обернутый в объект Optional.
		// Затем с помощью метода get() мы можем получить собственно результат вычислений: result.get()
		// Для сравнения элементов применяется компаратор comparator.
	 ArrayList<Integer> numbers = new ArrayList<Integer>();
     numbers.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
     Optional<Integer> min = numbers.stream().min(Integer::compare);
     Optional<Integer> max = numbers.stream().max(Integer::compare);
     System.out.println("Минимальный элемент - "  + min.get());  // 1
     System.out.println("Максимальный элемент - "  + max.get());  // 9
     	// Для массива
     System.out.println("Минимальный элемент массива - "  + IntStream.of(array).min().getAsInt()); 
     	// Для ArrayList коротко
     System.out.println("Минимальный элемент ArrayList - "  + intArl.stream().min(Integer::compare).get());
	
     	// Метод Optional<T> reduce(BinaryOperator<T> accumulator) выполняет терминальные операции сведения, возвращая 
       // некоторое значение - результат операции.
     System.out.println(" Результат сведения с перемножением = " + IntStream.of(array).reduce((x,y)->x*y).getAsInt());
	
 		// Метод T reduce(T identity, BinaryOperator<T> accumulator) сводит еще значение параметра identity  
     System.out.println(" Результат сведения с перемножением с = identity = -1 =     " + 
 		IntStream.of(array).reduce(-1, (x,y)->x*y));
     
     	// Метод  U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
     	// используется, когда нужно свести числа ,удовлетворяющие определенному условию
        // identity - используется, как первый элемент в сведении
     	// Ниже складываем числа меньшие 5      identity = 0
     ArrayList<Integer> numbers1 = new ArrayList<Integer>();
     numbers1.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
     int sum = numbers1.stream().reduce(0, 
             (x,y)-> {
                     if(y<5) return x + y;
                     else return x + 0;
             }, 
             (x, y)->x+y);
     System.out.println("Сумма числе меньших 5 равна =   " + sum);
     
     
	}
}
        
        
  