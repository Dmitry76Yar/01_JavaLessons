package f21_COLLECTIONS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/* ArrayList: простой список объектов
Использует интерфейс List, который расширяет функцональность интерфейса Collection.
Две наиболее частые реализации интерфейса List - это ArrayList и LinkedList.
Проще говоря, ArrayList представляет простой список, аналогичный массиву, за тем исключением, что количество элементов в нем не 
фиксировано. 
Плюсы ArrayList перед LinkedList - Доступ в ArrayListпо индексу (порядковому номеру элемента) происходит очень быстро.
Недостатки ArrayList (все они реализуются в ArrayList и не вызывают проблем у программиста, но уменьшает производительность системы): 
- Добавление элементов в середину списка затратно, т.к. нужно будет подвинуть вправо каждый элемент, который идёт после добавляемого. С удалением такая же штука. .
- Массив имеет конечное количество свободных ячеек и если их перестанет хватать, придётся создать новый массив большего размера, 
перенеся в него все элементы из исходного. 
В последних версиях Java ArrayList был достаточно хорошо оптимизирован и на практике можно всё время выбирать его без ущерба для производительности в любых задачах. 

		Методы интерфейса Collection
- boolean add (E item): добавляет в коллекцию объект item. При удачном добавлении возвращает true, при неудачном - false
- boolean addAll (Collection<? extends E> col): добавляет в коллекцию все элементы из коллекции col. При удачном добавлении возвращает true, при неудачном - false
- void clear (): удаляет все элементы из коллекции
- boolean contains (Object item): возвращает true, если объект item содержится в коллекции, иначе возвращает false
- boolean isEmpty (): возвращает true, если коллекция пуста, иначе возвращает false
- Iterator<E> iterator (): возвращает объект Iterator для обхода элементов коллекции
- boolean remove (Object item): возвращает true, если объект item удачно удален из коллекции, иначе возвращается false
- boolean removeAll (Collection<?> col): удаляет все объекты коллекции col из текущей коллекции. Если текущая коллекция изменилась, возвращает true, иначе возвращается false
- boolean retainAll (Collection<?> col): удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в коллекции col. Если текущая коллекция после удаления изменилась, возвращает true, иначе возвращается false
- int size (): возвращает число элементов в коллекции
- Object[] toArray (): возвращает массив, содержащий все элементы коллекции

		Методы интерфейса List
- void add(int index, E obj): добавляет в список по индексу index объект obj 
- boolean addAll(int index, Collection<? extends E> col): добавляет в список по индексу index все элементы коллекции col. Если в результате добавления список был изменен, то возвращается true, иначе возвращается false
- E get(int index): возвращает объект из списка по индексу index
- int indexOf(Object obj): возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1
- int lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта obj в список. Если объект не найден, то возвращается -1
- ListIterator<E> listIterator (): возвращает объект ListIterator для обхода элементов списка
- static <E> List<E> of(элементы): создает из набора элементов объект List
- E remove(int index): удаляет объект из списка по индексу index, возвращая при этом удаленный объект
- E set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index
- void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp
- List<E> subList(int start, int end): получает набор элементов, которые находятся в списке между индексами start и end

		Методы класса ArrayList
- ArrayList(): создает пустой список
- ArrayList(Collection <? extends E> col): создает список, в который добавляются все элементы коллекции col.
- ArrayList (int capacity): создает список, который имеет начальную емкость capacity
*/

public class t01_Array_List_Creation_Add_Remove {
public static void main(String args[]) {
	
		// Типы конструкторов
	ArrayList <String> people = new ArrayList <String>(); 		//	Конструктор ArrayList создает пустой список 
	ArrayList <String> employes = new ArrayList <String>(3);	// 	Конструктор ArrayList (int a) создает пустой список, который имеет начальную емкость capacity
	ArrayList <String> people2 = new ArrayList <String> (people); // Конструктор... - создает список, в который добавляются все элементы коллекции col.
		
	
			// Создание Arraylist  c массивом внутpи
	ArrayList<int []> arrlist = new ArrayList<int[]>();
	arrlist.add(new int[] {12, 13});
	
		// 1_void add(E obj)_Добавляем в список объект void add(E obj)		При удачном добавлении возвращает true, при неудачном - false
	people.add("Tom");
	people.add("Alice");
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Kate - \t" + people.add("Kate"));
	System.out.println("1_add(E obj)_people после people.add(Kate) \t\t - " + people.toString() + "\n");
		    	
	   	// 2_addAll_Добавляем сразу много объектов
	Collections.addAll(people, "Alice33", "Alice555");
	System.out.println("2_addAll_people после множественного добавления \t - " + people.toString() + "\n");
        
		// 3_void add(int index, E obj)_Добавляем элемент по индексу 1		: добавляет в список по индексу index объект obj
    people.add(1, "Bob"); 
    System.out.println("3_add(int index, E obj)_Добавление Bob по 1-му индексу) \t - " + people.toString()  + "\n");
    
    	// 4_AddAll(ArrayList)_Добавляем в список people2 все элементы из списка people	 
    people2.add("Dmitry"); people2.add("Alexey"); 
    System.out.println("4_AddAll(ArrayList)_people2 после добавления элементов       - " + people2.toString()  + "\n");
    System.out.println("4_AddAll(ArrayList)_Вернул true, т.к. получилось  добавить элементы -   " + people2.addAll(people)); 	
    System.out.println("4_AddAll(ArrayList)_people2 после добавления всех элементов из people -    " + people2.toString()  + "\n");
   
    	// 5_AddAll(int index, ArrayList)_Добавляем в список people2 все элементы из списка employes по выбранному индексу	 
    employes.add("1"); employes.add("2"); employes.add("3");
    people2.addAll(2, employes); 	
    System.out.println("5_AddAll(int index, ArrayList)_people2 после добавления всех элементов из employes по индексу 2 -    " + people2.toString()  + "\n");
 	   
    	// 6_E_set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index
    System.out.println("6_set(int index, E obj)_Исходный people \t\t - " + people.toString());
    people.set(0, "Tomy");
    System.out.println("6_set(int index, E obj)_people после people.set(0, Tomy) \t\t - " + people.toString() + "\n");
 	      
    	//7_List<E> subList(int start, int end): получает набор элементов, которые находятся в списке между индексами start и end
    LinkedList <String>  people3 = new LinkedList <String>();
   // people3 = (ArrayList<String>)people.subList(0, 1);
    System.out.println("7_subList(int start, int end)_Создан список people3 = people с 0-го по 1-ый элементы \t - " + people3.toString() + "\n");
 	      
    	//8_int size(): возвращает число элементов в коллекции
    System.out.println("8_int size()_Число элементов в списке people - \t" + people.size() + "\n");
 	   
    	// 9_boolean isEmpty (): возвращает true, если коллекция пуста, иначе возвращает false
    System.out.println("9_isEmpty_Список people пуст? - \t" + people.isEmpty() + "\n");
 	   
    	// 10_Object[] toArray (): возвращает массив, содержащий все элементы коллекции
    Object Array[] = people.toArray();
    Array.toString();
    System.out.println("10_toArray ()_После перевода в массив,   Array[1] =  \t" + Array[1] + "\n");
   
    	// 11_remove(int index)_Удаляет объект из списка по индексу index, возвращая при этом удаленный объект  E remove(int index): 
    System.out.println("11_remove(int index)_Возвращает удаленный объект \t" + people2.remove(2));
    System.out.println("11_remove(int index)_people2 после удалениея 2-го элемента -    " + people2.toString()  + "\n");
    	   
    	// 12_remove(Object)_Удаляет заданный объект из списка по индексу index, возвращая при этом true при нахождении такого объекта
    System.out.println("12_remove(Object)_Вернул true при нахождении Dmitry - \t   " + people2.remove("Dmitry"));
    System.out.println("12_remove(Object)_Вернул false при ненахождении Piter - \t   " + people2.remove("Piter"));
    System.out.println("12_remove(Object)_people2 после удалениея 2-го элемента -    " + people2.toString()  + "\n");
    		   
    	// 13_removeAll(Object)_Удаляет из списка people2 все объекты списка people, возвращая при этом true при нахождении такого объекта
    System.out.println("13_removeAll(Object)_Вернул true при нахождении всех объектов people в people2 -   " + people2.removeAll(people));
    System.out.println("13_removeAll(Object)_people2 после удалениея всех элементов списка people из списка people -    " + people2.toString());
    System.out.println("13_removeAll(Object)_Вернул true при ненахождении всех объектов people -   " + people2.removeAll(people)  + "\n");

    	// 14_clear()_Удаляет все элементы из коллекции   	void clear ():
    System.out.println("14_clear()_Список employes до удаления всех объектов/элементов -    " + employes.toString());
    employes.clear();
    System.out.println("14_clear()_Список employes после удаления всех объектов/элементов -    " + employes.toString()  + "\n");
    	   
   		// 15_boolean people2.retainAll (Object): удаляет все объекты из people2, кроме тех, которые содержатся в коллекции people.
   		// Если текущая коллекция после удаления изменилась, возвращает true, иначе возвращается false
   System.out.println("15_retainAll (Object)_Исходный список people -    " + people.toString());
   people2.addAll(people);
   System.out.println("15_retainAll (Object)_Исходный список people2 -    " + people2.toString());
   System.out.println("15_retainAll (Object)_Вернул true, т.к. получилось оставить только элементы списка people в списке people2 - \t" + people2.retainAll(people));
   System.out.println("15_retainAll (Object)_Список people2 после удаления всех элементов кроме тех, которые есть в списке people -    " + people2.toString());
   
   }
}

