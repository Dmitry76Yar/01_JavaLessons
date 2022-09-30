package f21_COLLECTIONS;

import java.util.ArrayList;

/* ArrayList: простой список объектов
Использует интерфейс List, который расширяет функцональность интерфейса Collection.
Две наиболее частые реализации интерфейса List - это ArrayList и LinkedList.
Проще говоря, ArrayList представляет простой список, аналогичный массиву, за тем исключением, что количество элементов в нем не фиксировано. 
Плюсы ArrayList перед LinkedList - Доступ в ArrayListпо индексу (порядковому номеру элемента) происходит очень быстро.
Недостатки ArrayList (все они реализуются в ArrayList и не вызывают проблем у программиста, но уменьшает производительность системы): 
- Добавление элементов в середину списка затратно, т.к. нужно будет подвинуть вправо каждый элемент, который идёт после добавляемого. С удалением такая же штука. .
- Массив имеет конечное количество свободных ячеек и если их перестанет хватать, придётся создать новый массив большего размера, перенеся в него все элементы из исходного. 
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
- ArrayList (int capacity): создает список, который имеет начальную емкость capacity */

public class t02_Array_List_Search_Contain {
public static void main(String args[]) {

ArrayList <Integer> id = new ArrayList <Integer>();
id.add(104929); 	id.add(34433);	id.add(96374); id.add(34433);

	//16_boolean contains (Object item): возвращает true, если объект item содержится в коллекции, иначе возвращает false
System.out.println("16_contains (Object item)_Список содержит объект 96374? - \t " + id.contains(96374));

	//17_E get(int index): возвращает объект из списка по индексу index
System.out.println("17_get(int index)_Исходный список id  \t\t - " + id.toString());
System.out.println("17_get(int index)_Объект под индексом 1 - \t - " + id.get(1));

	// 18_int indexOf(Object obj): возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1
System.out.println("18_int indexOf(Object obj_Индекс первого вхождения элемента 34433 в списке   - " + id.indexOf(34433));
System.out.println("18_int indexOf(Object obj)_Индекс элемента 34434 в списке   - " + id.indexOf(3443));
	
	// 19_int lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта obj в список. Если объект не найден, то возвращается -1
System.out.println("19_int lastIndexOf(Object obj)_Индекс первого вхождения элемента 34433 в списке   - " + id.lastIndexOf(34433));

	// 20_boolean contains (Object item): возвращает true, если объект item содержится в коллекции, иначе возвращает false
System.out.println("20_contains (Object item)Индекс первого вхождения элемента 34433 в списке   - " + id.lastIndexOf(34433));

	// 21_void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp

}
}