package f22_Stream;

import java.util.*;
import java.util.stream.Stream;

/*  Распараллеливание потоков позволяет задействовать несколько ядер процессора (если целевая машина многоядерная) и 
 тем самым может повысить производительность и ускорить вычисления. В то же время говорить, что применение параллельных потоков
 на многоядерных машинах однозначно повысит производительность - не совсем корректно. В каждом конкретном случае надо проверять
  и тестировать.     В то же время если рабочая машина не является многоядерной, то поток будет выполняться как последовательный. */

public class t08_Parallel_Stream {
public static void main(String[] args) {
	
	/* Чтобы сделать обычный последовательный поток параллельным, надо вызвать у объекта Stream метод parallel. 
	 Кроме того, можно также использовать метод parallelStream() интерфейса Collection для создания параллельного потока из коллекции.  */
	 
    System.out.println("Пример с именами");
    List<String> people = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");
    System.out.print("Последовательный поток:  ");
    people.stream().filter(p->p.length()==3).forEach(p->System.out.print(p + "\t"));		
    System.out.print("\nПараллельный поток:  ");
    	// Через метод parallelStream() интерфейса Collection
    people.parallelStream().filter(p->p.length()==3).forEach(p->System.out.print(p + "\t"));	System.out.println();
    	// Через вызов у объекта Stream метод parallel
    people.stream().parallel().filter(p->p.length()==3).forEach(p->System.out.print(p + "\t"));	System.out.println();
    
    	/* Однако не все функции можно без ущерба для точности вычисления перенести с последовательных потоков на параллельные. 
	    Прежде всего такие функции должны быть без сохранения состояния и ассоциативными, то есть при выполнении слева направо
	    давать тот же результат, что и при выполнении справа налево, как в случае с произведением чисел.
	    Фактически здесь происходит перемножение чисел. При этом нет разницы между 1 * 2 * 3 * 4 * (5 * 6) или 5 * 6 * 1 * (2 * 3) * 4.
	    Мы можем расставить скобки любым образом, разместить последовательность чисел в любом порядке, и все равно мы получим один и
	    тот же результат. То есть данная операция является ассоциативной и поэтому может быть распараллелена.  */
    Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
    Optional<Integer> result = numbersStream.parallel().reduce((x,y)-> x*y);
    System.out.println(result.get()); 
    
    	/* Упорядоченность в параллельных потоках
		Как правило, элементы передаются в поток в том же порядке, в котором они определены в источнике данных. 
		При работе с параллельными потоками система сохраняет порядок следования элементов. Исключение составляет метод forEach(),
		который может выводить элементы в произвольном порядке. И чтобы сохранить порядок следования, необходимо применять метод
	    forEachOrdered */
    List<String> people2 = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");
    System.out.print("С forEachOrdered:       ");
    people2.parallelStream().sorted().forEachOrdered(p->System.out.print(p + "\t"));	System.out.println();
    System.out.print("С forEach:              ");
    people2.parallelStream().sorted().forEach(p->System.out.print(p + "\t"));	System.out.println();
    	
    
	}
}


        
  