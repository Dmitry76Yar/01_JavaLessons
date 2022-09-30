package f21_COLLECTIONS;
/* PriorityQueue – это класс очереди с приоритетами.
  Иерархия - интерфейс Queue - класс AbstractQueue - класс PriorityQueue
  Пример использования - Когда клиенты посылают запросы к нашему приложению, то образуется очередь, но мы хотим обработать премиум 
  клиентов первыми, а обычных клиентов уже после них. Именно в этом случае нам будет лучше всего использовать PriorityQueue.
  
  По умолчанию очередь с приоритетами размещает элементы согласно естественному порядку сортировки используя Comparable. 
  Элементу с наименьшим значением присваивается наибольший приоритет. Если несколько элементов имеют одинаковый наивысший элемент – 
  связь определяется произвольно. 
  Также можно указать специальный порядок размещения, используя Comparator.
  
  PriorityQueue не позволяет добавлять null-значения и non-comparable объекты.
  PriorityQueue не является потокобезопасной! Для этих целей в Java реализован класс PriorityBlockingQueue, реализующий интерфейс
BlockingQueue. Именно он используется в многопоточной среде.    */

import java.util.PriorityQueue;


public class t07_Priority_Queue_std_methods {
public static void main(String[] args) {
	PriorityQueue<String> name_list2 = new PriorityQueue<>();
	PriorityQueue<String> name_list1 = new PriorityQueue<>();
	name_list1.add("Alice33");		name_list1.add("Barak");	name_list1.add("Tom");
	name_list1.add("Mark");			name_list1.add("Justin");
	
		/*	1_peek() — возвращает (но не удаляет из очереди) первый элемент.
	Элементы располагаются в очереди не в порядке их внесения, а сразу упорядачиваются по приоритету 
	По умолчанию Для String - элементы сразу располагаются по алфавиту + учет строчная или прописная */
	System.out.println("1_peek()_Весь список до метода	\t" + name_list1);
	System.out.println("1_peek() — возвращает (но не удаляет из очереди) первый элемент\t" + name_list1.peek());
	System.out.println("1_peek()_Весь список после метода	\t" + name_list1 );
	System.out.println("1_peek()_Возвращает для пустого списка - " + name_list2.peek() + "\n" );
	
		/*	2_remove() — возвращает и удаляет из СПИСКА первый элемент.
		Элементы располагаются в очереди не в порядке их внесения, а сразу упорядачиваются по приоритету 
		По умолчанию Для String - элементы сразу располагаются по алфавиту + учет строчная или прописная */
	System.out.println("2_remove()- Весь список до метода	\t" + name_list1);
	System.out.println("2_remove() — возвращает и удаляет из СПИСКА первый элемент \t" + name_list1.remove());
	System.out.println("2_remove() - Весь список после метода	\t" + name_list1);
	//	name_list2.remove();
	System.out.println("2_remove()_Возвращает для пустого списка ИСКЛЮЧЕНИЕ" + "\n" );
	
		// 3_remove(Object)_Удаляет заданный объект из списка по индексу index, возвращая при этом true при нахождении такого объекта
	System.out.println("3_remove(Object)- Весь список до метода	\t\t  " + name_list1);
	System.out.println("3_remove(Object)_Вернул true при нахождении Mark - \t   " + name_list1.remove("Mark"));
    System.out.println("3_remove(Object)_Вернул false при ненахождении Piter - \t   " + name_list1.remove("Piter"));
    name_list1.remove("Mark");
    System.out.println("3_remove(Object) - Весь список после метода	\t   " + name_list1 + "\n");
	
    	// 4_poll() — возвращает и удаляет из очереди первый элемент.
	 name_list1.add("Mark");
	 System.out.println("4_poll()- Весь список до метода	\t\t\t\t\t" + name_list1);
	 System.out. println("4_poll() — возвращает (но не удаляет из очереди) последний элемент\t"  + name_list1.peek());
	 System.out.println("4_poll() - Весь список после метода 	\t\t\t\t" + name_list1);
	 System.out.println("4_poll() - Возвращает для пустого списка name_list2 \t\t\t" + name_list2.poll() + "\n" );
	 
	 	// 5_boolean contains (Object): возвращает true, если объект item содержится в коллекции, иначе возвращает false
	 System.out.println("5_contains - Весь список до метода	\t\t  " + name_list1);
	 System.out.println("5_contains - _Вернул true при нахождении Mark в списке     " + name_list1.contains("Mark"));
	 System.out.println("5_contains - _Вернул false при ненахождении Piter - \t   " + name_list1.contains("Piter") + "\n");

	 	// 6_isEmpty(): возвращает true, если список пустой
	 System.out.println("6_isEmpty() - Вернул false для непустого списка name_list1 \t\t  " + name_list1.isEmpty());
	 System.out.println("6_isEmpty() - Вернул true для ПУСТОГО списка name_list2 \t\t " + name_list2.isEmpty() + "\n");
	 
	 	// 7_toArray(): возвращает массив класса Object
	 Object Array[] =  name_list1.toArray();
	 System.out.print("7_toArray(): возвращает массив класса Object - \t");
	 for (Object element: Array) System.out.print(element + "\t\n");
	 
	 	// 8_clear(): удаляет все элементы массива
	 System.out.println("8_clear() - Весь список до метода	\t  " + name_list1);
	 name_list1.clear();
	 System.out.println("8_clear() - Весь список после метода \t\t  " + name_list1);
	 
	 
	}

}
