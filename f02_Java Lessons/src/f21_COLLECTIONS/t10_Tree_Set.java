package f21_COLLECTIONS;
import java.util.ArrayList;
import java.util.NavigableSet;
/* Обобщенный класс TreeSet<E> представляет структуру данных в виде дерева, в котором все объекты хранятся в отсортированном виде 
 по возрастанию.
  В HashSet порядок элементов определяется по сложному алгоритму, нет сортировки. 
  В контейнере TreeSet, в котором объекты хранятся отсортированными по возрастанию в порядке сравнения 
  В контейнере LinkedHashSet с хранением элементов в порядке добавления.
  
  Внутри TreeSet<E> содержится TreeMap<E, Object> который и хранит все эти значения.
  Поэтому у него очень быстрые операции add, remove, contains.
 	Иерархия класса TreeSet
	Наследует: класс AbstractCollection - класс AbstractSet - класс TreeSet
 	Реализует: интерфейс Iterable - интерфейс Collection - интерфейс Set - интерфейс SortedSet - интерфейс NavigableSet
Интерфейс SortedSet описывает упорядоченное множество, отсортированное в возрастающем порядке или по порядку, заданному реализацией
интерфейса Comparator.			SortedSet хранит только уникальные значения. 
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
Set не добавляет новых методов.
		Методы интерфейса SortedSet:
- Comparator<? super E> comparator() - возвращает компаратор сортированного множества. Если для множества применяется естественный порядок сортировки, возвращается null.
- E first() - возвращает первый элемент вызывающего сортированного множества.
- E last() - возвращает последний элемент вызывающего сортированного множества.
- SortedSet headSet(E toElement)- возвращает SortedSet, содержащий элементы из вызывающего множества, которые предшествуют end.
- SortedSet subSet(E fromElement, E toElement) - возвращает SortedSet, содержащий элементы из вызывающего множества, находящиеся между start и end-1.
- SortedSet tailSet(E fromElement) - возвращает SortedSet, содержащий элементы из вызывающего множества, которые следуют за end.
 		Методы интерфейса NavigableSet
Интерфейс NavigableSet расширяет интерфейс SortedSet и позволяет извлекать элементы на основании их значений. 
- E ceiling(E obj): ищет в наборе наименьший элемент e, который больше obj (e >=obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E floor(E obj): ищет в наборе наибольший элемент e, который меньше элемента obj (e <=obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E higher(E obj): ищет в наборе наименьший элемент e, который больше элемента obj (e >obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E lower(E obj): ищет в наборе наибольший элемент e, который меньше элемента obj (e <obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E pollFirst(): возвращает первый элемент и удаляет его из набора
- E pollLast(): возвращает последний элемент и удаляет его из набора
- NavigableSet<E> descendingSet(): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet в обратном порядке
- NavigableSet<E> headSet(E upperBound, boolean incl): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet до upperBound. Параметр incl при значении true, позволяет включить в выходной набор элемент upperBound
- NavigableSet<E> tailSet(E lowerBound, boolean incl): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet, начиная с lowerBound. Параметр incl при значении true, позволяет включить в выходной набор элемент lowerBound
- NavigableSet<E> subSet(E lowerBound, boolean lowerIncl, E upperBound, boolean highIncl): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet от lowerBound до upperBound.

		Методы класса TreeSet
Обобщенный класс TreeSet<E> представляет структуру данных в виде дерева, в котором все объекты хранятся в отсортированном виде по 
возрастанию. TreeSet является наследником класса AbstractSet и реализует интерфейс NavigableSet, а следовательно, и интерфейс SortedSet.
В классе TreeSet определены следующие конструкторы:
- TreeSet(): создает пустое дерево
- TreeSet(Collection<? extends E> col): создает дерево, в которое добавляет все элементы коллекции col
- TreeSet(SortedSet <E> set): создает дерево, в которое добавляет все элементы сортированного набора set
- TreeSet(Comparator<? super E> comparator): создает пустое дерево, где все добавляемые элементы впоследствии будут отсортированы компаратором.
 */
import java.util.TreeSet;

public class t10_Tree_Set {
public static void main(String[] args) {
		// TreeSet(): создает пустое дерево
	TreeSet <String> peopleTreeSet = new TreeSet <String>();   	// создает пустое дерево
		// 1_void add(E obj)_Добавляем в список объект void add(E obj)		При удачном добавлении возвращает true, при неудачном - false
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Mark - \t\t" + peopleTreeSet.add("Mark"));
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Steve - \t\t" + peopleTreeSet.add("Steve")); 		
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Scarlet - \t\t" + peopleTreeSet.add("Scarlet"));
	System.out.println("1_add(E obj)_Вернул false, т.к. не получилось СНОВА добавить элемент Scarlet - \t" + peopleTreeSet.add("Scarlet"));
	System.out.println("1_add(E obj)_Вернул true, т.к. получилось  добавить элемент Justin - \t\t" + peopleTreeSet.add("Justin"));
	System.out.println("1_add(E obj)_Tree set таблица после добавления всех элементов - \t\t" + peopleTreeSet + "\n");
		
		// 2_TreeSet(Collection col): создает дерево, в которое добавляет все элементы коллекции col
	ArrayList<String> List = new ArrayList<String>();
	List.add("Dmitry");
	TreeSet <String> peopleTreeSet2 = new TreeSet <String>(List);   	// создает дерево, в которое добавляет все элементы коллекции col
	System.out.println("2_TreeSet(Collection): Tree set таблица peopleTreeSet2 после добавления ArrayList List -   " + peopleTreeSet2 + " \n");
		
		// 3_TreeSet(SortedSet set): создает дерево, в которое добавляет все элементы сортированного набора set
	peopleTreeSet2.addAll(peopleTreeSet);
	System.out.println("3_TreeSet(Collection): Tree set таблица peopleTreeSet2 после добавления peopleTreeSet -   " + peopleTreeSet2 + " \n");
			
		//	TreeSet(Comparator<? super E> comparator): создает пустое дерево, где все добавляемые элементы впоследствии будут отсортированы компаратором.
//	TreeSet <String> peopleTreeSet3 = new TreeSet <String>(Comparator<String> comparator);
		
		// 4_addAll()_Добавляем в список peopleTreeSet все элементы из списка peopleTreeSet2
	System.out.println("4_addAll():_Вернул false, т.к. не получилось снова добавить все элементы списка people - \t" + peopleTreeSet2.addAll(peopleTreeSet));
	System.out.println("4_addAll(): Tree set таблица peopleTreeSet2 после добавления peopleTreeSet \t\t   -   " + peopleTreeSet2 + " \n");
		
		// 5_clear()_Удаляет все элементы из коллекции   	void clear ():
	System.out.println("5_clear()_Tree set таблица peopleTreeSet2 до удаления всех объектов/элементов -    " + peopleTreeSet2);
	peopleTreeSet2.clear();
	System.out.println("5_clear()_Tree set таблица peopleTreeSet2 после удаления всех объектов/элементов -    " + peopleTreeSet2  + "\n");
		 
	 	// 6_boolean contains (Object item): возвращает true, если объект item содержится в хэш-таблице, иначе возвращает false
	System.out.println("6_contains() - Tree set таблица peopleTreeSet до метода - \t\t\t\t" + peopleTreeSet);
	System.out.println("6_contains() - Tree set таблица peopleTreeSet содержит объект Mark? - \t\t\t" + peopleTreeSet.contains("Mark"));
	System.out.println("6_contains() - Tree set таблица peopleTreeSet после метода - \t\t\t" + peopleTreeSet + "\n");
		
		// 7_boolean containsAll (Collection a): возвращает true, если Tree set таблица содержится в Tree set таблице, иначе возвращает false
	System.out.println("7_containsAll()_Tree set таблица peopleTreeSet2 содержит peopleTreeSet? - \t\t\t" + peopleTreeSet2.containsAll(peopleTreeSet) + "\n");
			  
		// 8_boolean isEmpty (): возвращает true, если Tree set таблица пуста, иначе возвращает false
	System.out.println("8_isEmpty - Tree set таблица peopleTreeSet пуст? - \t" + peopleTreeSet.isEmpty());
	System.out.println("8_isEmpty - Tree set таблица peopleTreeSet пуст? - \t" + peopleTreeSet2.isEmpty() + "\n");
				   
		// 9_remove(Object)_Удаляет заданный объект из Tree set таблицы, возвращая при этом true при нахождении такого объекта
	System.out.println("9_remove(Object)_Tree set таблица peopleTreeSet до метода -    " + peopleTreeSet + "\n");
	System.out.println("9_remove(Object)_Вернул true при нахождении Alice - \t   " + peopleTreeSet.remove("Mark"));
	System.out.println("9_remove(Object)_Вернул false при ненахождении Piter - \t   " + peopleTreeSet.remove("Piter"));
	System.out.println("9_remove(Object)_Tree set таблица peopleTreeSet после удалениея Mark -    " + peopleTreeSet + "\n");
			   
	   	// 10_removeAll(Collection c)_Удаляет из Tree set таблицы _peopleTreeSet2 все объекты таблицы _peopleTreeSet, возвращая при этом true при нахождении такого объекта
	peopleTreeSet2.addAll(peopleTreeSet);
	System.out.println("10_remove(Object)_Tree set таблица peopleTreeSet2 до метода \t\t\t-    " + peopleTreeSet2);
	System.out.println("10_removeAll(Object)_Вернул true при нахождении всех объектов peopleTreeSet в peopleTreeSet2 \t-   " + peopleTreeSet2.removeAll(peopleTreeSet));
	System.out.println("10_removeAll(Object)_peopleTreeSet2 после удалениея всех элементов  -    \t\t\t " + peopleTreeSet2  + "\n");
	
		// 11_retainAll(Collection c)_Оставляет в Tree set таблицы people2 только объекты Tree set таблицы people, возвращая при этом true при нахождении такого объекта
	peopleTreeSet2.addAll(peopleTreeSet);
	peopleTreeSet2.add("Mary");		peopleTreeSet2.add("Mary2"); 	peopleTreeSet2.add("Mary3");
	System.out.println("11_retainAll() - Tree set таблица peopleTreeSet2 до метода - \t\t\t" + peopleTreeSet2);
	peopleTreeSet2.retainAll(peopleTreeSet);
	System.out.println("11_retainAll() - Tree set таблица peopleTreeSet2 после метода - \t\t\t" + peopleTreeSet2);
	System.out.println("11_retainAll()_Вернул false при ненахождении снова people - \t\t   " + peopleTreeSet2.retainAll(peopleTreeSet)  + "\n");
		
		//12_int_size(): возвращает число элементов в Tree set таблицы
	System.out.println("12_int_size() - Tree set таблица people до метода - \t\t\t\t" + peopleTreeSet2);
	System.out.println("12_int_size()_Число элементов в  people - \t\t\t\t" + peopleTreeSet2.size() + "\n");
		
		// 11_Object[] toArray (): возвращает массив, содержащий все элементы коллекции
	 Object Array[] = peopleTreeSet2.toArray();
	 Array.toString();
	 System.out.println("11_toArray ()_После перевода в массив,   Array[1] =  \t" + Array[1] + "\n");
	 
	 				//	 Методы интерфейса SortedSet:
	 	// 12_Comparator<? super E> comparator() - возвращает компаратор сортированного множества. Если для множества применяется естественный порядок сортировки, возвращается null.
	 	 
	 	// 13_E first() - возвращает, но не удаляет первый элемент вызывающего сортированного множества.
	 System.out.println("13_first() - Tree set таблица peopleTreeSet до метода - \t\t" + peopleTreeSet);
	 System.out.println("13_first() - извлекается первый элемент peopleTreeSet \t\t\t " + peopleTreeSet.first());
	 System.out.println("13_first() - Tree set таблица peopleTreeSet после метода - \t\t" + peopleTreeSet + "\n");
	 
		// 14_E last() - возвращает, но не удаляет первый элемент вызывающего сортированного множества.
	 System.out.println("14_last() - Tree set таблица peopleTreeSet до метода - \t\t" + peopleTreeSet);
	 System.out.println("14_last() - извлекается первый элемент peopleTreeSet \t\t\t " + peopleTreeSet.last());
	 System.out.println("14_last() - Tree set таблица peopleTreeSet после метода - \t\t" + peopleTreeSet + "\n");
	 
	 	//15_SortedSet headSet(E toElement)- возвращает SortedSet, содержащий элементы из вызывающего множества, которые предшествуют end.
	 peopleTreeSet.add("Mark");		peopleTreeSet.add("Bob");		peopleTreeSet.add("Tom");
	 peopleTreeSet2.clear();
	 System.out.println("15_headSet() - Tree set таблица peopleTreeSet до метода - \t\t\t" + peopleTreeSet);
	 peopleTreeSet2 = (TreeSet<String>) peopleTreeSet.headSet("Bob");
	 System.out.println("15_headSet() - Извлеченная Tree set таблица до элемента Bob - \t\t\t" + peopleTreeSet2);
	 peopleTreeSet2.clear();		peopleTreeSet2 = (TreeSet<String>) peopleTreeSet.headSet("Scarlet");
	 System.out.println("15_headSet() - Извлеченная Tree set таблица до элемента Scarlet - \t\t" + peopleTreeSet2);
	 System.out.println("15_headSet() - Tree set таблица peopleTreeSet после метода - \t\t\t" + peopleTreeSet);
	 peopleTreeSet2.remove("Bob");
	 System.out.println("Удаление элемента в извлеченной таблице приводит также к удалению в таблице, из которой было извлечено");
	 System.out.println("15_headSet() - peopleTreeSet2 после удаления Bob - \t\t\t\t" + peopleTreeSet);
	 System.out.println("15_headSet() - peopleTreeSet после удаления Bob в peopleTreeSet2 - \t\t" + peopleTreeSet + "\n");
	 
	 	//16_SortedSet subSet(E fromElement, E toElement) - возвращает SortedSet, содержащий элементы из вызывающего множества,
	    //	 находящиеся между start и end-1.
	 peopleTreeSet.add("Bob");
	 System.out.println("16_subSet() - Tree set таблица peopleTreeSet до метода - \t\t\t" + peopleTreeSet);
	 TreeSet <String> peopleTreeSet3 = new TreeSet <String>();   	
	 peopleTreeSet2.remove("Bob");
	 peopleTreeSet3 = (TreeSet<String>) peopleTreeSet.subSet("Bob", "Steve");
	 System.out.println("16_subSet() - Извлеченная Tree set таблица c Bob и по Steve - \t\t\t" + peopleTreeSet3);
	 System.out.println("16_subSet() - Tree set таблица peopleTreeSet после метода - \t\t\t" + peopleTreeSet);
	 System.out.println("Удаление элемента в извлеченной таблице приводит также к удалению в таблице, из которой было извлечено");
	 System.out.println("16_subSet() - peopleTreeSet2 после удаления Bob - \t\t\t\t" + peopleTreeSet);
	 System.out.println("16_subSet() - peopleTreeSet после удаления Bob в peopleTreeSet2 - \t\t" + peopleTreeSet + "\n");
	 
	 	// 17_SortedSet tailSet(E fromElement) - возвращает SortedSet, содержащий элементы из вызывающего множества, которые следуют за end.
	 TreeSet <String> peopleTreeSet4 = new TreeSet <String>();
	 System.out.println("17_tailSet() - Tree set таблица peopleTreeSet до метода - \t\t\t" + peopleTreeSet);
	 peopleTreeSet4 = (TreeSet<String>) peopleTreeSet.tailSet("Mark");
	 System.out.println("17_tailSet() - Извлеченная Tree set таблица после элемента Mark - \t\t" + peopleTreeSet4);
	 System.out.println("17_tailSet() - Tree set таблица peopleTreeSet после метода - \t\t\t" + peopleTreeSet + "\n");
	 
	 	// 18_- E ceiling(E obj): ищет в наборе наименьший элемент e, который больше obj (e >=obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
	 peopleTreeSet.add("Bob");
	 System.out.println("18_ceiling() - Tree set таблица peopleTreeSet до метода - \t" + peopleTreeSet);
	 System.out.println("Элемент который меньше Mark1 - \t\t\t\t\t" + peopleTreeSet.ceiling("Mark1")+ "\n");
	 
	 	// 19_- E floor(E obj): ищет в наборе наибольший элемент e, который меньше элемента obj (e <=obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
	 System.out.println("19_floor() - Tree set таблица peopleTreeSet до метода - \t" + peopleTreeSet);
	 System.out.println("19_floor()_Элемент который больше Mark1 - \t\t\t" + peopleTreeSet.floor("Mark1")+ "\n");
	 
	 	// 20_E higher(E obj): ищет в наборе наименьший элемент e, который больше элемента obj (e >obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
	 System.out.println("20_higher() - Tree set таблица peopleTreeSet до метода - \t" + peopleTreeSet);
	 System.out.println("20_higher()_Элемент который меньше Mark1 - \t\t\t" + peopleTreeSet.higher("Mark1")+ "\n"); 
	 
	 	// 21_E lower(E obj): ищет в наборе наибольший элемент e, который меньше элемента obj (e <obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
	 System.out.println("21_lower() - Tree set таблица peopleTreeSet до метода - \t" + peopleTreeSet);
	 System.out.println("21_lower()_Элемент который меньше Mark1 - \t\t\t" + peopleTreeSet.lower("Mark1")+ "\n");

	 	// 22_E pollFirst(): возвращает первый элемент и удаляет его из набора
	 System.out.println("22_pollFirst() - Tree set таблица peopleTreeSet до метода - \t" + peopleTreeSet);
	 System.out.println("22_pollFirst()_Первый элемент извлеченный из таблицы - \t\t\t" + peopleTreeSet.pollFirst());
	 System.out.println("22_pollFirst() - Tree set таблица peopleTreeSet после метода - \t" + peopleTreeSet + "\n");
	 
		// 23_E pollLast(): возвращает последний элемент и удаляет его из набора
	 peopleTreeSet.add("Bob");
	 System.out.println("23_pollLast() - Tree set таблица peopleTreeSet до метода - \t" + peopleTreeSet);
	 System.out.println("23_pollLast()_Последний элемент извлеченный из таблицы - \t\t\t" + peopleTreeSet.pollLast());
	 System.out.println("23_pollLast() - Tree set таблица peopleTreeSet после метода - \t" + peopleTreeSet + "\n");
	 
	 	// 24_NavigableSet<E> descendingSet(): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet в обратном порядке
	 peopleTreeSet.add("Tom");
	 System.out.println("24_descendingSet() - Tree set таблица peopleTreeSet до метода - \t\t" + peopleTreeSet);
	 NavigableSet<String> Set1 = peopleTreeSet.descendingSet();
	 System.out.println("24_descendingSet() - Извлеченный NavigableSet из peopleTreeSet  - \t\t" + Set1);
	 System.out.println("24_descendingSet() - Tree set таблица peopleTreeSet после метода - \t\t" + peopleTreeSet);
	 TreeSet <String> peopleTreeSet5 = new TreeSet <String>();
	 peopleTreeSet5 = (TreeSet<String>)Set1;
	 System.out.println("24_descendingSet() - Извлеченный NavigableSet после приведения к TreeList  - \t" + peopleTreeSet5);
	 peopleTreeSet5.remove("Scarlet");
	 System.out.println("\t Удаление элемента Scarlet в извлеченной таблице приводит к удалению и в извлеченной");
	 System.out.println("24_descendingSet() - Tree set таблица peopleTreeSet до метода - \t\t" + peopleTreeSet);
	 System.out.println("24_descendingSet() - Tree set таблица peopleTreeSet до метода - \t\t" + Set1);
	 System.out.println("24_descendingSet() - Tree set таблица peopleTreeSet до метода - \t\t" + peopleTreeSet + "\n");
	 
	 	//25_NavigableSet<E> headSet(E upperBound, boolean incl): возвращает объект NavigableSet, который содержит все элементы
 // первичного набора NavigableSet до upperBound. Параметр incl при значении true, позволяет включить в выходной набор элемент upperBound
	 System.out.println("25_headSet() - Tree set таблица peopleTreeSet до метода - \t\t\t\t" + peopleTreeSet);
	 NavigableSet<String> Set2 = peopleTreeSet.headSet("Steve", false);
	 System.out.println("25_headSet() - Извлеченный NavigableSet из peopleTreeSet c inclusive = false - \t\t" + Set2);
	 NavigableSet<String> Set3 = peopleTreeSet.headSet("Steve", true);
	 System.out.println("25_headSet() - Извлеченный NavigableSet из peopleTreeSet c inclusive = true - \t\t" + Set3);
	 
	 //	26 NavigableSet<E> tailSet(E lowerBound, boolean incl): возвращает объект NavigableSet, который содержит все элементы 
//	 первичного набора NavigableSet, начиная с lowerBound. Параметр incl при значении true, позволяет включить в выходной набор
//элемент lowerBound
	 
	 //27_NavigableSet<E> subSet(E lowerBound, boolean lowerIncl, E upperBound, boolean highIncl): возвращает объект NavigableSet, 
//	 который содержит все элементы первичного набора NavigableSet от lowerBound до upperBound.
	 
	}
}
