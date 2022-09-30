package f22_Stream;

import java.util.*;

/* Ряд операций сведения, такие как min, max, reduce, возвращают объект Optional<T>. Этот объект фактически обертывает
  результат операции. После выполнения операции с помощью метода get() объекта Optional мы можем получить его значение */

public class t07_If_Optional_Object_Null {
public static void main(String[] args) {
	
		// Но что, если поток не содержит вообще никаких данных: программа выдаст исключение java.util.NoSuchElementException.
		// Самой простой способ избежать подобной ситуации - это предварительная проверка наличия значения в Optional с помощью
		// метода isPresent(). Он возврашает true, если значение присутствует в Optional, и false, если значение отсутствует:
	ArrayList<Integer> numbersEmpty = new ArrayList<Integer>();
	
	ArrayList<Integer> numbersFull = new ArrayList<Integer>();
	numbersFull.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
	
	Optional<Integer> minEmpty = numbersEmpty.stream().min(Integer::compare);
	Optional<Integer> minFull = numbersFull.stream().min(Integer::compare);
	
		// Метод ifPresent() определяет действия со значением в Optional, если значение имеется:
	if(minEmpty.isPresent())    System.out.println(minEmpty.get());
	else System.out.println("Поток был пустой и результат Optional не сущесвует");
	if(minFull.isPresent())    System.out.println("minFull = " + minFull.get());
	else System.out.println("Поток был пустой и результат Optional не сущесвует");
	
	minEmpty.ifPresent(v->System.out.println(v));
	minFull.ifPresent(v->System.out.println(v));
	
		// Метод ifPresentOrElse() позволяет определить альтернативную логику на случай, если значение в Optional отсутствует:
	minEmpty.ifPresentOrElse(
	     v -> System.out.println(v),
	     () -> System.out.println("Value not found")
	);
	
		// Метод orElse() позволяет определить альтернативное значение, которое будет возвращаться, если Optional не получит из
		// потока какого-нибудь значения:
	System.out.println("Так как поток был пустой резульат orElse() = " + minEmpty.orElse(-100));
	System.out.println("Так как поток был не пустой результат orElse()  = " + minFull.orElse(-100));
	
		// Метод orElseGet() позволяет задать функцию, которая будет возвращать значение по умолчанию
	 Random rnd = new Random();
	 System.out.println("Так как поток был пустой резульат orElseGet() = " + minEmpty.orElseGet(()->rnd.nextInt(100)));
	 System.out.println("Так как поток был не пустой результат orElseGet()  = " + minFull.orElseGet(()->rnd.nextInt(100)));
	 
	 	// // Метод orElseThrow позволяет сгенерировать исключение, если Optional не содержит значения:
//	 System.out.println("Так как поток был пустой резульат orElseThrow() = " + minEmpty.orElseThrow(IllegalStateException::new));
	 System.out.println("Так как поток был не пустой результат orElseThrow()  = " + minFull.orElseThrow(IllegalStateException::new));

	         
    }
}


        
  