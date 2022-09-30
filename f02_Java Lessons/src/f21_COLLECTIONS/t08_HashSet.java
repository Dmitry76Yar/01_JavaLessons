package f21_COLLECTIONS;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* Иерархия класса: 	класс AbstractSet - класс AbstractCollection - класса HashSet
   Реализует: 			интерфейс Iterable - интерфейс Collection - интерфейс Set, а также интерфейсы Serializable и Cloneable
   
   В HashSet порядок элементов определяется по сложному алгоритму, нет сортировки. 
  В контейнере TreeSet, в котором объекты хранятся отсортированными по возрастанию в порядке сравнения 
  В контейнере LinkedHashSet с хранением элементов в порядке добавления.
  
Интерфейс Set представляет набор уникальных элементов.      Обобщенный класс HashSet представляет хеш-таблицу.  
Во многом он похож на класс ArrayList, и в каком-то смысле является его более примитивной версией.
HashSet – это коллекция, которая для хранения элементов внутри использует их хэш-значения, которые возвращает метод hashCode().
Для простоты внутри HashSet<E> хранится объект HashMap<E, Object>, который и хранит в качестве ключей значения HashSet.
Данный ключ позволяет уникально идентифицировать объект в таблице.
Использование hash-кодов позволяет довольно быстро искать, добавлять и удалять элементы из множества (Set).
HashSet не поддерживает порядок элементов. Во-первых, официально его просто нет, во-вторых, даже внутренний порядок может сильно 
поменяться при добавлении всего одного элемента. У элементов этой коллекции нет номеров. Нельзя получить элемент по его индексу или
записать значение в коллекцию по определенному индексу. 
	Поиск элементов
Когда вы добавляете во множество новый элемент, удаляете элемент, или проверяете наличие элемента, внутри метода выполняется поиск 
элемента. Элементы коллекции и переданный элемент сравниваются сначала по hashCode(), а если hashCode() совпадают, по equals.
	ВАЖНО, чтобы объекты твоих классов можно было класть в Set и правильно находить их там, у твоего класса должны быть правильно
реализованы методы hashCode & equals.
Если ты забудешь реализовать метод hashCode(), то рискуешь, что твой объект в коллекции Set не будет найден, даже если он там есть.
Также важно, что даже при условии правильной реализации методов hashCode и equals в своем классе, если происходит изменение какого-либо
объекта, то при этом меняется и его hashcode. А это значит, что когда ты будешь его искать в Set’е, его скорее всего не найдут.
Это всем известный косяк с работой HashSet. Грубо говоря, поиск в HashSet (и в HashMap) гарантированно работает правильно, только 
если объекты – immutable.

		Несколько важных пунктов о HashSet:
- Т.к. класс реализует интерфейс Set, он может хранить только уникальные значения;
- Может хранить NULL – значения;
- Порядок добавления элементов вычисляется с помощью хэш-кода;
- Начальная емкость – изначальное количество ячеек («корзин») в хэш-таблице. Если все будут заполнены, их количество увеличится автоматически.
- Коэффициент загрузки = Количество хранимых элементов в таблице / размер хэш-таблицы (общее кол-во ячеек). 
Коэффициент загрузки и начальная емкость – два главных фактора, от которых зависит производительность операций с HashSet.
Коэффициент загрузки = 0,75, в среднем обеспечивает хорошую производительность. Если этот параметр увеличить, тогда уменьшится нагрузка
на память (так как это уменьшит количество операций ре-хэширования и перестраивания), но это повлияет на операции добавления и поиска. 

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

		Методы интерфейса Set
Set не добавляет новых методов, только вносит изменения унаследованные. В частности, метод add() добавляет элемент в коллекцию и 
возвращает true, если в коллекции еще нет такого элемента.

		Методы класса HashSet
- HashSet(): конструктор по умолчанию. Начальная емкость по умолчанию – 16, коэффициент загрузки – 0,75.
- HashSet(int initialCapacity): конструктор с заданной начальной емкостью. Коэффициент загрузки – 0,75.
- HashSet(int initialCapacity, float loadFactor):  конструктор с заданными начальной емкостью и коэффициентом загрузки.
- HashSet(Collection C): конструктор, добавляющий элементы из другой коллекции.
 */

public class t08_HashSet {
public static void main(String[] args) {
	
	HashSet<String> people = new HashSet<String>();   	//конструктор по умолчанию. Начальная емкость по умолчанию – 16, коэффициент загрузки – 0,75.
	HashSet<String> people2 = new HashSet<String>(20);	//конструктор с заданной начальной емкостью. Коэффициент загрузки – 0,75.
	
		// 1_void add(E obj)_Добавляем в список объект void add(E obj)		При удачном добавлении возвращает true, при неудачном - false
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Tom - \t\t" + people.add("Tom"));
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Alice - \t\t" + people.add("Alice"));
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Kate - \t\t" + people.add("Kate"));
	System.out.println("1_add(E obj)_Вернул false, т.к. не получилось СНОВА добавить элемент Kate - \t" + people.add("Kate"));
	System.out.println("1_add(E obj)_Хэш-таблица после добавления всех элементов - \t\t\t" + people);
	System.out.println("1_add(E obj)_ОБРАТИ внимание, что элементы расположены не в порядке их внесения в таблицу, а по увеличению hashcode");
	System.out.print("hashCode для Tom = " + "Tom".hashCode() + "\t"); 
	System.out.print("hashCode для Alice = " + "Alice".hashCode() + "\t");
	System.out.print("hashCode для Kate = " + "Kate".hashCode() + "\t\n\n");
	
		// 2_addAll()_Добавляем в список people2 все элементы из списка people
	System.out.println("2_addAll()_Вернул true, т.к. получилось  добавить все элементы списка people - \t" + people2.addAll(people));
	System.out.println("2_addAll()_Вернул false, т.к. не получилось СНОВА все элементы списка people - \t" + people2.addAll(people) + "\n");
	
		// 3_clear()_Удаляет все элементы из коллекции   	void clear ():
	System.out.println("3_clear()_Список people2 до удаления всех объектов/элементов -    " + people2.toString());
	people2.clear();
	System.out.println("3_clear()_Список people2 после удаления всех объектов/элементов -    " + people2.toString()  + "\n");
	 
	 	// 4_boolean contains (Object item): возвращает true, если объект item содержится в хэш-таблице, иначе возвращает false
	System.out.println("4_contains() - Хэш-таблица до метода - \t\t\t\t" + people);
	System.out.println("4_contains() - Хэш-таблица содержит объект Alice? - \t\t\t" + people.contains("Alice"));
	System.out.println("4_contains() - Хэш-таблица после метода - \t\t\t" + people + "\n");
	
		// 5_boolean containsAll (Collection a): возвращает true, если хэш-таблица содержится в хэш-таблице, иначе возвращает false
	people2.addAll(people);
	System.out.println("4_containsAll()_ Хэш-таблица people2 содержит хэш-таблицу people? - \t\t\t" + people2.containsAll(people) + "\n");
		  
		// 6_boolean isEmpty (): возвращает true, если хэш-таблица пуста, иначе возвращает false
	System.out.println("6_isEmpty - хэш-таблица people пуст? - \t" + people.isEmpty() + "\n");
			   
		// 7_remove(Object)_Удаляет заданный объект из хэш-таблицы, возвращая при этом true при нахождении такого объекта
	System.out.println("7_remove(Object)_Вернул true при нахождении Alice - \t   " + people.remove("Alice"));
	System.out.println("7_remove(Object)_Вернул false при ненахождении Piter - \t   " + people.remove("Piter"));
	System.out.println("7_remove(Object)_Хэш-таблица people после удалениея Alice -    " + people + "\n");
		   
	   	// 8_removeAll(Collection c)_Удаляет из хэш-таблицы people2 все объекты хэш-таблицы people, возвращая при этом true при нахождении такого объекта
	people.add("Alice");
	System.out.println("8_removeAll(Object)_Вернул true при нахождении всех объектов people в people2 \t-   " + people2.removeAll(people));
	System.out.println("8_removeAll(Object)_people2 после удалениея всех элементов списка people -    \t  " + people2.toString());
	System.out.println("8_removeAll(Object)_Вернул false при ненахождении всех объектов people -   \t  " + people2.removeAll(people)  + "\n");

		// 9_retainAll(Collection c)_Оставляет в хэш-таблице people2 только объекты хэш-таблицы people, возвращая при этом true при нахождении такого объекта
	people2.addAll(people);
	people2.add("Mary");		people2.add("Mary2"); 	people2.add("Mary3");
	System.out.println("9_retainAll() - Хэш-таблица people2 до метода - \t\t\t" + people2);
	people2.retainAll(people);
	System.out.println("9_retainAll() - Хэш-таблица people2 после метода - \t\t\t" + people2);
	System.out.println("9_retainAll()_Вернул false при ненахождении снова people - \t\t   " + people2.retainAll(people)  + "\n");
	
		//10_int_size(): возвращает число элементов в хэш-таблицe
	System.out.println("10_int_size() - Хэш-таблица people до метода - \t\t\t\t" + people2);
	System.out.println("10_int_size()_Число элементов в  people - \t\t\t\t" + people.size() + "\n");
	
		// 11_Object[] toArray (): возвращает массив, содержащий все элементы коллекции
	 Object Array[] = people.toArray();
	 Array.toString();
	 System.out.println("11_toArray ()_После перевода в массив,   Array[1] =  \t" + Array[1] + "\n");
	 
	 	// Чтобы сразу передать в массив такоже типа, что и SET:
	 HashSet<String> str2_Set = new HashSet<String>();
	 str2_Set.add("1");		str2_Set.add("2");		str2_Set.add("3");
	 String str2_array[] = new String [str2_Set.size()];
	 str2_array = str2_Set.toArray(str2_array);
	 System.out.println(Arrays.toString(str2_array));
	     
	 	// Сортировка
	 /* Вы не можете этого сделать, поскольку Set не имеет методов произвольного доступа (т. .get() элемента с заданным индексом), 
	  * что в основном требуется для алгоритмов сортировки;) 
	  * Однако, если вам просто нужны ваши элементы, отсортированные для этого одного вхождения, просто временно создайте список и выполните сортировку, которая:
	  * List sortedList = new ArrayList(yourHashSet);
		Collections.sort(sortedList);
	  * 	  */
	 
	 
	}
}
