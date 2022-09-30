package f21_COLLECTIONS;
/* Очереди бывают однонаправленными и двунаправленными
Однонаправленные очереди работают по FIFO (first in - first out) и по LIFO  (last in - first out)
Очередь FIFO - очередь в магазин. Первым в магазин попадет тот, кто встал в очередь первым
При работе с FIFO очередью новые элементы добавляются в конец, а если ты хочешь получить элемент, он будет взят из начала.
Стек LIFO - как стопка тарелок - тарелка, которую положили первой, а затем на нее положили еще тарелки, будет взята последняя
При работе с LIFO очередью новые элементы добавляются в начало, а если ты хочешь получить элемент, он будет взят также из начала.

В Java очередь представлена не классом, а интерфейсом — Queue <E>, который расширяет базовый интерфейс Collection 
От Queue наследуются 4 разных интерфейса, и крайне внушительный список классов: 		
Subinterfaces: BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E>
Classes: AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, 
LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue

      Интерфейс Deque
Deque расширяет Queue и описывает поведение двунаправленной очереди. 
Двунаправленная очередь может функционировать как стандартная очередь FIFO либо как стек LIFO.

       У интерфейса Deque 2 наследника - Класс LinkedList и класс ArrayDeque
Из LinkedList можно организовать стек, очередь, или двойную очередь, со временем доступа O(1). 
Иерархия класса LinkedList: 	класс AbstractCollection - класс AbstractList - класс AbstractSequantialList - Класс LinkedList
LinkedList Реализует: 			интерфейс Iterable - интерфейс Collection - интерфейс Queue - интерфейс Deque, а также интерфейс List
На вставку и удаление из середины списка, получение элемента по индексу или значению потребуется линейное время O(n).
Однако, на добавление и удаление из середины списка, используя ListIterator.add() и ListIterator.remove(), потребуется O(1).Позволяет добавлять любые значения, в том числе и null.
	Push и pop -- общепринятые названия методов структуры данных "Стэк" LIFO. Поэтому если вы хотите использовать объект данного класса 
только в качестве Стэка, то рекомендуется вызывать именно эти методы, так грамотному специалисту легче понять, что за структура данных
перед ним и какова цель её использования в программе.
		
		Методы интерфейса Iterable<E>:
 - Iterator<T> iterator() - Возвращает объект-итератор
 
		Методы интерфейса Queue
 - element() - возвращает элемент из головы очереди. Элемент не удаляется. Если очередь пуста, инициируется исключение NoSuchElementException.
 - Е remove() - удаляет элемент из головы очереди, возвращая его. Инициирует исключение NoSuchElementException, если очередь пуста.
 - peek() - возвращает (но не удаляет из очереди) первый элемент.
 - Е роll() - возвращает элемент из головы очереди и удаляет его. Возвращает null, если очередь пуста.
 - boolean offer(Е оbj) - пытается добавить оbj в очередь. Возвращает true, если оbj добавлен, и false в противном случае.
 
 		Методы интерфейса Deque
 - addFirst() — добавляет новый элемент в начало очереди.
 - addLast() — добавляет элемент в конец очереди.
 - boolean offerFirst(E obj): добавляет элемент obj в самое начало очереди. Если элемент удачно добавлен, возвращает true, иначе - false
 - boolean offerLast(E obj): добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
 - void push(E element): добавляет элемент в самое начало очереди
 - getFirst(): возвращает без удаления элемент из головы очереди. Если очередь пуста, генерирует исключение NoSuchElementException
 - getLast(): возвращает без удаления последний элемент очереди. Если очередь пуста, генерирует исключение NoSuchElementException
 - peekFirst(): возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
 - peekLast(): возвращает без удаления последний элемент очереди. Если очередь пуста, возвращает значение null
 - pollFirst() — возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
 - pollLast() — возвращает с удалением последний элемент очереди. Если очередь пуста, возвращает значение null
 - pop(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
 - removeFirst(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
 - removeLast(): возвращает с удалением элемент из конца очереди. Если очередь пуста, генерирует исключение NoSuchElementException 
 - boolean removeFirstOccurrence(Object obj): удаляет первый встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.
 - boolean removeLastOccurrence(Object obj): удаляет последний встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.	
	
		Методы класса LinkedList
- LinkedList(): создает пустой список
- LinkedList(Collection<? extends E> col): создает список, в который добавляет все элементы коллекции col	
*/	

import java.util.Collections;
import java.util.LinkedList;

public class t04_Linked_List_as_DEQUE {
public static void main(String[] args) {
	LinkedList <String> people2 = new LinkedList<String>();
	Collections.addAll(people2, "Alice33", "Barak", "Tom", "Mark", "Justin");
	LinkedList <String> NullList = new LinkedList<String>();
	System.out.println("Исходный список	\t\t\t\t\t\t\t" + people2);
	
		//	1_peekFirst(): возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
	System.out.println("1_peekFirst() — возвращает (но не удаляет из очереди) первый элемент\t" + people2.peekFirst());
	System.out.println("1_peekFirst() - весь список после метода	\t\t\t" + people2);
	System.out.println("1_peekFirst() - возвращает null для пустой очереди 	\t\t" + NullList.peekFirst() + "\n");
		
		//	2_peekLast(): возвращает без удаления последний элемент очереди. Если очередь пуста, возвращает значение null
	System.out.println("2_peekLast() — возвращает (но не удаляет из очереди) последний элемент\t" + people2.peekLast());
	System.out.println("2_peekLast() — Весь список после метода 	\t\t\t" + people2);
	System.out.println("2_peekLast() - возвращает null для пустой очереди 	\t\t" + NullList.peekLast() + "\n");
	
		//	3_getFirst(): возвращает без удаления элемент из головы очереди. Если очередь пуста, генерирует исключение NoSuchElementException
	System.out.println("3_getFirst() — возвращает (но не удаляет из очереди) первый элемент\t" + people2.getFirst());
	System.out.println("3_getFirst() — Весь список после метода   	\t\t\t" + people2 + "\n");
//	System.out.println("3_getFirst() - возвращает null для пустой очереди 	\t\t" + NullList.getFirst() + "\n");
		
		//	4_getLast(): возвращает без удаления последний элемент очереди. Если очередь пуста, генерирует исключение NoSuchElementException
	System.out.println("4_getLast() — возвращает (но не удаляет из очереди) последний элемент\t" + people2.getLast());
	System.out.println("4_getLast() — Весь список после метода   	\t\t\t" + people2 + "\n");
//	System.out.println("4_getLast() - возвращает null для пустой очереди 	\t\t" + NullList.getLast() + "\n");
	
		//	5_pollFirst(): возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
	System.out.println("5_pollFirst() — Весь список до метода   	\t\t\t" + people2);
	System.out.println("5_pollFirst() — возвращает первый элемент из очереди и удаляет его\t" + people2.pollFirst());
	System.out.println("5_pollFirst - Весь список после метода 	\t\t\t\t" + people2);
	System.out.println("5_pollFirst() - возвращает null для пустой очереди 	\t\t" + NullList.pollFirst() + "\n");
	
		//	6_pollLast(): возвращает с удалением последний элемент очереди. Если очередь пуста, возвращает значение null
	people2.add("Alice333");
	System.out.println("6_pollLast() — Весь список до метода   	\t\t\t\t" + people2);
	System.out.println("6_pollLast() — возвращает последний элемент из очереди и удаляет его.\t" + people2.pollLast());
	System.out.println("6_pollLast() - Весь список после метода 	\t\t\t" + people2);
	System.out.println("6_pollLast() - возвращает null для пустой очереди 	\t\t" + NullList.pollFirst() + "\n");
	
		//7_pop(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
	people2.add("Alice333");
	System.out.println("7_pop() — Весь список до метода   	\t\t\t\t" + people2);
	System.out.println("7_pop() — возвращает последний элемент из очереди и удаляет его.\t" + people2.pop());
	System.out.println("7_pop() - Весь список после метода 	\t\t\t\t" + people2 + "\n");
//	System.out.println("7_pop() - возвращает null для пустой очереди 	\t\t" + NullList.pop() + "\n");
	
		//8_removeFirst(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
	people2.add("Barak");
	System.out.println("8_removeFirst() — Весь список до метода   	\t\t\t\t" + people2);
	System.out.println("8_removeFirst() — возвращает последний элемент из очереди и удаляет его.\t" + people2.removeFirst());
	System.out.println("8_removeFirst() - Весь список после метода 	\t\t\t\t" + people2 + "\n");
//	System.out.println("8_removeFirst() - возвращает null для пустой очереди 	\t\t" + NullList.removeFirst() + "\n");
	
		//9_removeLast(): возвращает с удалением элемент из конца очереди. Если очередь пуста, генерирует исключение NoSuchElementException
	people2.add("Tom");
	System.out.println("9_removeLast() — Весь список до метода   	\t\t\t\t" + people2);
	System.out.println("9_removeLast() — возвращает последний элемент из очереди и удаляет его.\t\t" + people2.removeLast());
	System.out.println("9_removeLast() - Весь список после метода 	\t\t\t\t" + people2 + "\n");
//	System.out.println("9_removeLast() - возвращает null для пустой очереди 	\t\t" + NullList.removeLast() + "\n");
	
		//10_boolean removeFirstOccurrence(Object obj): удаляет первый встреченный элемент obj из очереди. 
        //	Если удаление произшло, то возвращает true, иначе возвращает false.
	people2.add("Mark");
	System.out.println("10_removeFirstOccurrence() — Весь список до метода   	\t\t\t\t" + people2);
	System.out.println("10_removeFirstOccurrence() — возвращает первый Mark из очереди и удаляет его.\t" + people2.removeFirstOccurrence("Mark"));
	System.out.println("10_removeFirstOccurrence() - Весь список после метода 	\t\t\t\t" + people2);
	System.out.println("10_removeFirstOccurrence() - возвращает false, если не нашел Tim \t\t\t" + people2.removeFirstOccurrence("Tim") + "\n");
	
		//11_boolean removeLastOccurrence(Object obj): удаляет последний встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.
	people2.add("Justin");
	System.out.println("11_removeLastOccurrence() — Весь список до метода   	\t\t\t\t" + people2);
	System.out.println("11_removeLastOccurrence() — возвращает последний Justin из очереди и удаляет его.\t" + people2.removeLastOccurrence("Justin"));
	System.out.println("11_removeLastOccurrence() - Весь список после метода 	\t\t\t\t" + people2);
	System.out.println("11_removeLastOccurrence() - возвращает false, если не нашел Tim \t\t\t" + people2.removeLastOccurrence("Tim") + "\n");
	
		//	12_addFirst() — добавляет новый элемент в начало очереди.
	System.out.println("12_addFirst() — Весь список до метода   	\t\t" + people2);
	people2.addFirst("Jerry_First");
	System.out.println("12_addFirst - Весь список после метода + Jerry_First 	\t" + people2 + "\n");
	
		//	13_addLast() — добавляет элемент в конец очереди.
	System.out.println("13_addLast() — Весь список до метода   	\t\t\t" + people2);
	people2.addLast("Jerry_Last");
	System.out.println("13_addLast - Весь список после метода + Jerry_First 	\t" + people2  + "\n");
	
		//	14_boolean offerFirst(E obj): добавляет элемент obj в самое начало очереди. Если элемент удачно добавлен, возвращает true, иначе - false
	people2.remove(0); people2.remove(4); 
	System.out.println("14_offerFirst() — Весь список до метода   	\t\t" + people2);
	System.out.println("14_offerFirst() - возвращает при успешном добавлении - \t\t" + people2.offerFirst("Jerry_First"));
	System.out.println("14_offerFirst() - Весь список после метода + Jerry_First 	" + people2 + "\n");
	
		//	15_boolean offerLast(E obj): добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
	System.out.println("15_offerLast() — Весь список до метода   	\t\t" + people2);
	System.out.println("15_offerLast() - возвращает при успешном добавлении - \t\t" + people2.offerLast("Jerry_Last"));
	System.out.println("15_offerLast() - Весь список после метода + Jerry_Last \t 	" + people2 + "\n");
	
		//  16_void push(E element): добавляет элемент в самое начало очереди
	people2.remove(0); people2.remove(4);
	System.out.println("16_void push() — Весь список до метода   	\t\t" + people2);
	people2.push("Jerry_First");
	System.out.println("16_void push() - Весь список после метода + Jerry_First 	" + people2 + "\n");
	
	}
}
