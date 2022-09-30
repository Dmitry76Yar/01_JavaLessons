package f21_COLLECTIONS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;

/* Map — это структура данных, которая содержит набор пар “ключ-значение”. 
При этом все ключи уникальные в рамках объекта Map (значения могут повторяться). Это облегчает поиск элемента, если нам известен ключ
Применяется, например, когда нужно внести в список и ФИО, и данные паспорта, и естественно данные паспорта яв-ся уникальными для человека
По своей структуре данных напоминает словарь, поэтому ее часто так и называют.
Интерфейс Map НЕ расширяет интерфейс Collection.
Интерфейс Map реализует аюстрактный класс AbstractMap, а его наследуют Hashmap, LinkedHashMap, Hashtable, TreeMap.
	У каждой из реализаций интерфейса Map (Hashmap, LinkedHashMap, Hashtable, TreeMap) есть свои особенности:
		1. HashMap: 
- не гарантируют, что элементы будут храниться в порядке добавления.Также порядок элементов может меняться со временем.
- позволяет иметь ключ и значение null 
- Структура данных под капотом - хэш-таблица
 		2. Hashtable
- Потокобезопасность. Только HashTable синхронизирована, остальные — нет. Если к мапе НЕ будут обращаться разные потоки, рекомендуется
использовать HashMap вместо HashTable.
- не гарантируют, что элементы будут храниться в порядке добавления.Также порядок элементов может меняться со временем.
- не позволяет иметь ключ и значение null
- Структура данных под капотом - хэш-таблица
 		3.  TreeMap
- Гарантирует хранение элементов в порядке добавления или же в соответствии с заданным компаратором.
- TreeMap может использовать значения null только если это позволяет компаратор. Без использования компаратора (при хранении пар 
в порядке добавления) значение null не допускается.
- Структура данных под капотом - красно-чёрное дерево

		Класс TreeMap - в отличие от коллекции HashMap в TreeMap все объекты автоматически сортируются по возрастанию их ключей.
Иерархия:
Наследует класс AbstractMap
Реализует: интерфейс Map - интерфейс SortedMap - интерфейс NavigableMap 

Чтобы положить объект в коллекцию, используется метод put, а чтобы получить по ключу - метод get
		Методы интерфейса Map
- V put(K k, V v): помещает в коллекцию новый объект с ключом k и значением v. Если в коллекции уже есть объект с подобным ключом, то он перезаписывается. После добавления возвращает предыдущее значение для ключа k, если он уже был в коллекции. Если же ключа еще не было в коллекции, то возвращается значение null
- void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
- V putIfAbsent(K k, V v): помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента с подобным ключом.
- V get(Object k): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение null
- V getOrDefault(Object k, V defaultValue): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение defaultVlue
- Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
- Set<K> keySet(): возвращает набор всех ключей отображения
- Collection<V> values(): возвращает набор всех значений отображения
- int size(): возвращает количество элементов коллекции
- boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
- boolean containsValue(Object v): возвращает true, если коллекция содержит значение v
- boolean isEmpty: возвращает true, если коллекция пуста
- boolean equals(Object obj): возвращает true, если коллекция идентична коллекции, передаваемой через параметр obj
- V remove(Object k): удаляет объект с ключом k
- void clear(): очищает коллекцию
			Методы интерфейса SortedMap
Интерфейс SortedMap расширяет Map создает отображение, в котором все элементы отсортированы в порядке возрастания их ключей. 
- K firstKey(): возвращает ключ первого элемента отображения
- K lastKey(): возвращает ключ последнего элемента отображения
- SortedMap<K, V> headMap(K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap вплоть до элемента с ключом end
- SortedMap<K, V> tailMap(K start): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap, начиная с элемента с ключом start
- SortedMap<K, V> subMap(K start, K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap вплоть от элемента с ключом start до элемента с ключом end
			Методы интерфейса NavigableMap 
NavigableMap расширяет SortedMap и обеспечивает возможность получения элементов отображения относительно других элементов.
- Map.Entry<K, V> ceilingEntry(K obj): возвращает элемент с наименьшим ключом k, который больше или равен ключу obj (k >=obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> floorEntry(K obj): возвращает элемент с наибольшим ключом k, который меньше или равен ключу obj (k <=obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> higherEntry(): возвращает элемент с наименьшим ключом k, который больше ключа obj (k >obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> lowerEntry(): возвращает элемент с наибольшим ключом k, который меньше ключа obj (k <obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> firstEntry(): возвращает первый элемент отображения
- Map.Entry<K, V> lastEntry(): возвращает последний элемент отображения
- Map.Entry<K, V> pollFirstEntry(): возвращает и одновременно удаляет первый элемент из отображения
- Map.Entry<K, V> pollLastEntry(): возвращает и одновременно удаляет последний элемент из отображения
- K ceilingKey(K obj): возвращает наименьший ключ k, который больше или равен ключу obj (k >=obj). Если такого ключа нет, то возвращается null.
- K floorKey(K obj): возвращает наибольший ключ k, который меньше или равен ключу obj (k <=obj). Если такого ключа нет, то возвращается null.
- K lowerKey(K obj): возвращает наибольший ключ k, который меньше ключа obj (k <obj). Если такого ключа нет, то возвращается null.
- K higherKey(K obj): возвращает наименьший ключ k, который больше ключа obj (k >obj). Если такого ключа нет, то возвращается null.
- NavigableSet<K> descendingKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения в обратном порядке
- NavigableMap<K, V> descendingMap(): возвращает отображение NavigableMap, которое содержит все элементы в обратном порядке
- NavigableSet<K> navigableKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения
- NavigableMap<K, V> headMap(K upperBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap вплоть от элемента с ключом upperBound. Параметр incl при значении true указывает, что элемент с ключом upperBound также включается в выходной набор.
- NavigableMap<K, V> tailMap(K lowerBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap, начиная с элемента с ключом lowerBound. Параметр incl при значении true указывает, что элемент с ключом lowerBound также включается в выходной набор.
- NavigableMap<K, V> subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap от элемента с ключом lowerBound до элемента с ключом upperBound. Параметры lowIncl и highIncl при значении true включают в выходной набор элементы с ключами lowerBound и upperBound соответственно.
- Comparator comparator() - возвращает comparator, используемый для упорядачивания ключей, или null для default comparator	
		Методы класса TreeMap
- TreeMap(): создает пустое отображение в виде дерева
- TreeMap(Map<? extends K,​? extends V> map): создает дерево, в которое добавляет все элементы из отображения map
- TreeMap(SortedMap<K, ? extends V> smap): создает дерево, в которое добавляет все элементы из отображения smap
- TreeMap(Comparator<? super K> comparator): создает пустое дерево, где все добавляемые элементы впоследствии будут отсортированы компаратором.
*/

public class t15_TreeMap {
public static void main(String[] args) {
	TreeMap <Integer, String> map1 = new TreeMap<>();		// TreeMap(): создает пустое отображение в виде дерева
		Map <Integer, String> hashMap = new HashMap<>(20, 0.75F);		
	TreeMap <Integer, String> map3 = new TreeMap<>(hashMap);		// TreeMap(Map map): создает дерево, в которое добавляет все элементы из отображения map
	TreeMap <Integer, String> map2 = new TreeMap<>(map1); 	// TreeMap(SortedMap map): создает дерево, в которое добавляет все элементы из отображения smap

		/* 1_V put(K k, V v): помещает в коллекцию новый объект с ключом k и значением v. Если в коллекции уже есть объект с подобным
	ключом, то он перезаписывается. После добавления возвращает предыдущее значение для ключа k, если он уже был в коллекции. 
	Если же ключа еще не было в коллекции, то возвращается значение null	*/
System.out.println("1_put(K, V)_Вернул null, т.к. получилось  добавить элемент Tom c ключом 111 - \t\t" + map1.put(111, "Tom"));
System.out.println("1_put(K, V)_Вернул null, т.к. получилось  добавить элемент Tom c ключом 120 - \t\t" + map1.put(120, "Tom"));
System.out.println("1_put(K, V)_Вернул null, т.к. получилось  добавить элемент Alice c ключом 131 - \t" + map1.put(131, "Alice"));
System.out.println("1_put(K, V)_Вернул null, т.к. получилось  добавить элемент Kate c ключом 140 - \t\t" + map1.put(140, "Kate"));
System.out.println("1_put(K, V)_Вернул Kate, т.к. ключи совпали и произошла перезапись значения Mark вместо Kate - \t\t" + map1.put(140, "Mark"));
System.out.println("1_put(K, V)_Словарь после добавления всех элементов - \t\t\t\t\t" + map1 + "\n");

		// 2_void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
map2.putAll(map1);
System.out.println("2_putAll(Map)_Скопировал все элементы из map1 в map2 - \t\t\t\t\t" + map2 + "\n");

		// 3_V putIfAbsent(K k, V v): помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента
		// с подобным ключом.
System.out.println("3_putIfAbsent(K, V)_Словарь до  метода - \t\t\t\t\t" + map1);
System.out.println("3_putIfAbsent(K, V)_Вернул null, т.к. получилось  добавить элемент Alisa c уникальным ключом 143 - \t" + map1.putIfAbsent(143, "Alisa"));
System.out.println("3_putIfAbsent(K, V)_Вернул Mark, т.к. не получилось добавить Kate  с тем же ключом 140 - \t\t" + map1.putIfAbsent(140, "Kate"));			
System.out.println("3_putIfAbsent(K, V)_Словарь после  метода - \t\t\t\t\t" + map1 + "\n");		
			
		// 4_V get(Object k): возвращает и не удаляет значение объекта, ключ которого равен k. Если такого элемента не окажется, то 
		//возвращается значение null
System.out.println("4_get(Object)_Словарь до  метода - \t\t\t\t" + map1);
System.out.println("4_get(Object)_Вернул найденный объект с ключом 143 - \t\t" + map1.get(143));
System.out.println("4_get(Object)_Вернул null, т.к. не нашел объект с ключом 144 - \t" + map1.get(144));
System.out.println("4_get(Object)_Словарь после  метода - \t\t\t\t" + map1 + "\n");

		// 5_V getOrDefault(Object k, V defaultValue): возвращает и не удаляет значение объекта, ключ которого равен k. 
		//Если такого элемента не окажется, то возвращается значение defaultVlue
System.out.println("5_get(Object, value)_Словарь до  метода - \t\t\t\t" + map1);
System.out.println("5_get(Object, value)_Вернул найденный объект с ключом 143 - \t\t" + map1.getOrDefault(143, "defaultValue" ));
System.out.println("5_get(Object, value)_Вернул null, т.к. не нашел объект с ключом 144 - \t" + map1.getOrDefault(144, "defaultValue"));
System.out.println("5_get(Object, value)_Словарь после  метода - \t\t\t\t" + map1 + "\n");

		//6_1_Метод entrySet() - возвращает Set, содержащий записи Map. Каждый из этих элементов является объектом Map.Entry
	// 
	
		// 6_Перебор с использованием entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
//Перебор значений — самая частая операция. Все пары (ключ-значение) хранятся во внутреннем интерфейсе Map.Entry, а чтобы получить их,
//нужно вызвать метод entrySet(). Он возвращает множество (Set) пар, которые можно перебрать в цикле:
System.out.print("6_Перебор через 6_entrySet() с получением всех ключей и значений \t"); System.out.println();
for (Map.Entry<Integer, String> entry : map1.entrySet()) {
		// Получить ключи  и значения
	System.out.print(" \t" + entry.getKey()); 
	System.out.print(" \t" + entry.getValue());} 
System.out.println("\n");

	// 7_Перебор с использованием Iterator
System.out.print("7_Перебор с использованием Iterator с получением всех ключей и значений \t"); System.out.println();
Iterator<Map.Entry<Integer, String>> itr = map1.entrySet().iterator();
while(itr.hasNext()) { Map.Entry<Integer, String> entry2 =  itr.next();
		//Получить ключи  и значения
	System.out.print(" \t" + entry2.getKey()); 
	System.out.print(" \t" + entry2.getValue()); }
System.out.println("\n");

	// 8_- Set<K> keySet(): возвращает набор всех ключей отображения
Set<Integer> keySet = map1.keySet();
System.out.println("8_- keySet() Получает Set набор ключей " + keySet); 
// Так как в классе ArrayList есть конструктор с аргументом Collection и так как Set является наследником Collection, то можно
// передать этот  Set в ArrayList
ArrayList<Integer> keyArrayList = new ArrayList<Integer>(keySet);
System.out.println("8_- keySet() После преобразования в ArrayList " + keyArrayList + "\n");

	// 9_Collection<V> values(): возвращает набор всех значений отображения
Collection<String> ValuesCol = map1.values();
System.out.println("9_- values() Получает Collection набор набор всех значений " + ValuesCol);
//Так как в классе ArrayList есть конструктор с аргументом Collection, то можно передать в ArrayList
ArrayList<String> ValuesArrayList = new ArrayList<String>(ValuesCol);
System.out.println	("9_- values() После преобразования в ArrayList " + ValuesArrayList + "\n");

	// 10_int size(): возвращает количество элементов коллекции
System.out.println("10_size()_Словарь до  метода - \t" + map1);
System.out.println("10_size()_Размер - \t\t\t" + map1.size() + "\n");

	// 11_boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
System.out.println("11_containsKey()_Словарь до  метода - \t" + map1);
System.out.println("11_containsKey()_Содержит элемент с ключом 120 - \t\t\t" + map1.containsKey(120));
System.out.println("11_containsKey()_Содержит элемент с ключом 121 - \t\t\t" + map1.containsKey(121) + "\n");

	//12_boolean containsValue(Object v): возвращает true, если коллекция содержит значение v
System.out.println("12_containsValue()_Словарь до  метода - \t\t\t\t" + map1);
System.out.println("12_containsValue()_Содержит элемент с значением Mark - \t\t\t" + map1.containsValue("Mark"));
System.out.println("12_containsValue()_Содержит элемент с значением Mark22 - \t\t" + map1.containsValue("Mark22") + "\n");

	//13_boolean isEmpty: возвращает true, если коллекция пуста
System.out.println("13_isEmpty()_Словарь map1 пустой? - \t\t\t" + map1.isEmpty());
System.out.println("13_isEmpty()_Словарь map3 пустой? - \t\t\t" + map3.isEmpty() + "\n");

	//14_boolean equals(Object obj): возвращает true, если коллекция идентична коллекции, передаваемой через параметр obj
System.out.println("14_equals()_Словарь map1 - \t\t\t\t" + map1);
System.out.println("14_equals()_Словарь map2 - \t\t\t\t" + map2);
System.out.println("14_equals()_Словарь map1 одинаков с map2? - \t\t" + map1.equals(map2) + "\n");

	//15_V remove(k): удаляет объект с ключом k
System.out.println("15_remove()_Словарь map1 до  метода - \t\t" + map1);
System.out.println("15_remove()_Словарь map2 до  метода - \t\t" + map2);
System.out.println("15_remove()_Вернул значение удаляемого элемента \t\t\t" +  map1.remove(140));
System.out.println("15_remove()_Вернул null, т.к. не нашел такого элемента \t\t\t" +  map1.remove(141));
System.out.println("15_remove()_Словарь map1 после  метода - \t" + map1);
System.out.println("15_remove()_Словарь map2 после  метода - \t" + map2  + "\n");

	//16_V remove(k,v): удаляет объект с ключом k и значением v
map1.put(140, "Mark2");
System.out.println("16_remove(k,v)_Словарь map1 до  метода - \t\t" + map1);
System.out.println("16_remove(k,v)_Не нашел такого элемента 140 - Mark3 \t" + map1.remove(140, "Mark3"));
System.out.println("16_remove(k,v)_Нашел и удалил элемент 140 - Mark2 \t" + map1.remove(140, "Mark2"));
System.out.println("16_remove(k,v)_Словарь map2 после  метода - \t" + map2  + "\n");

	//17_replace(key, value)_Заменяет значение элемента выбранного по индексу
map1.put(140, "Mark2");
System.out.println("17_replace(k,v)_Словарь map1 до  метода - \t\t" + map1);
System.out.println("17_replace(k,v) Вернул заменяемое значение выбранного по индексу элемента \t" + map1.replace(131, "AliceNEW"));
System.out.println("17_replace(k,v)_Вернул null, т.к. не нашел такого элемента \t\t\t" +  map1.replace(121, "UUUUUU"));
System.out.println("17_replace(k,v)_Словарь map1 после  метода - \t\t" + map1 + "\n");

	//18_replace(key, oldValue, newValue)  _Заменяет значение элемента выбранного по индексу 
System.out.println("18_replace(k,v,v)_Словарь map1 до  метода - \t\t" + map1);
System.out.println("18_replace(k,v,v) Вернул заменяемое значение выбранного по индексу элемента \t" + map1.replace(131, "AliceNEW", "AliceNEW2"));
System.out.println("18_replace(k,v,v)_Вернул null, т.к. не нашел такого элемента \t\t\t" +  map1.replace(131, "AliceNEW", "UUUUUU"));
System.out.println("18_replace(k,v,v)_Словарь map1 после  метода - \t\t" + map1  + "\n");

	//19_clear(): очищает коллекцию
System.out.println("19_clear()_Словарь map1 до  метода - \t\t" + map2);
map2.clear();
System.out.println("19_clear()_Словарь map1 до  метода - \t\t" + map2 + "\n");

	//20_Сортировка ключей через создания Map.Entry и затем размещения его в список ArrayList	
ArrayList<Entry<Integer, String>> entryList2 = new ArrayList<Entry<Integer, String>>(map1.entrySet());
//System.out.println("20_Сортировка ключей_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("20_Сортировка ключей_ Entry список entryList2 до  метода - \t" + entryList2);
Collections.sort(entryList2, new Comparator<Entry<Integer, String>>() {
		@Override
	public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
		if(o1.getKey() > o2.getKey())	return 1;
		else if(o1.getKey() < o2.getKey())	return -1;
		else return 0;		}
});
System.out.println("20_Сортировка ключей_ Entry после entryList2 до  метода - \t" + entryList2  + "\n");
//System.out.println("20_Сортировка ключей_Словарь map1 после  метода - \t\t" + map1 + "\n");

	//21_Сортировка значений через создания Map.Entry и затем размещения его в список ArrayList	
ArrayList<Entry<Integer, String>> entryList3 = new ArrayList<Entry<Integer, String>>(map1.entrySet());
//System.out.println("21_Сортировка значений - Словарь map1 до  метода - \t\t" + map1);
System.out.println("21_Сортировка значений - Entry список entryList2 до  метода - \t" + entryList3);
Collections.sort(entryList3, new Comparator<Entry<Integer, String>>() {
		@Override
	public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
			return o1.getValue().compareTo(o2.getValue());	}
});
System.out.println("21_Сортировка значений - Entry после entryList2 до  метода - \t " + entryList3  + "\n");
//System.out.println("21_Сортировка значений - Словарь map1 после  метода - \t\t" + map1 + "\n");
	
			/*  Методы NavigableMap
	22_Map.Entry<K, V> ceilingEntry(K obj): возвращает элемент с наименьшим ключом k, который больше или равен ключу obj (k >=obj). 
	Если такого ключа нет, то возвращается null.  */
System.out.println("22_ceilingEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.print("22_ceilingEntry()_Вернул объект Map.Entry = элемент с ближайшим большим ключом, чем заданный ключ 121");
System.out.println(" \t" + map1.ceilingEntry(121));
System.out.print("22_ceilingEntry()_Вернул null, т.к. нет элемента с большим ключом, чем заданный ключ 144 \t");
System.out.println(" \t" + map1.ceilingEntry(144) + "\n");

	//23_Map.Entry<K, V> floorEntry(K obj): возвращает элемент с наибольшим ключом k, который меньше или равен ключу obj (k <=obj).
System.out.println("23_floorEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.print("23_floorEntry()_Вернул объект Map.Entry = элемент с ближайшим меньшим ключом, чем заданный ключ 121");
System.out.println(" \t" + map1.floorEntry(121));
System.out.print("23_floorEntry()_Вернул null, т.к. нет элемента с меньшим ключом, чем заданный ключ 110 \t");
System.out.println(" \t" + map1.floorEntry(110) + "\n");
	
	// 24_Map.Entry<K, V> higherEntry(): возвращает элемент с наименьшим ключом k, который больше ключа obj (k >obj). 
System.out.println("24_higherEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.print("24_higherEntry()_Вернул объект Map.Entry = элемент с ближайшим меньшим ключом, чем заданный ключ 121");
System.out.println(" \t" + map1.higherEntry(121));
System.out.print("24_higherEntry()_Вернул null, т.к. нет элемента с меньшим ключом, чем заданный ключ 144 \t");
System.out.println(" \t" + map1.higherEntry(144) + "\n");

	// 25_Map.Entry<K, V> lowerEntry(): возвращает элемент с наибольшим ключом k, который меньше ключа obj (k <obj). 
System.out.println("24_higherEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.print("25_lowerEntry()_Вернул объект Map.Entry = элемент с ближайшим меньшим ключом, чем заданный ключ 121");
System.out.println(" \t" + map1.lowerEntry(121));
System.out.print("25_lowerEntry()_Вернул null, т.к. нет элемента с меньшим ключом, чем заданный ключ 110 \t");
System.out.println(" \t" + map1.lowerEntry(110) + "\n");

	// 26_Map.Entry<K, V> firstEntry(): возвращает первый элемент отображения
System.out.println("26_firstEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("26_firstEntry()_Вернул объект Map.Entry = Первый элемент отображения - \t\t"+ map1.firstEntry() + "\n");

	//27_Map.Entry<K, V> lastEntry(): возвращает последний элемент отображения
System.out.println("27_lastEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("27_lastEntry()_Вернул объект Map.Entry = Последний элемент отображения - \t"+ map1.lastEntry() + "\n");

	// 28_Map.Entry<K, V> pollFirstEntry(): возвращает и одновременно удаляет первый элемент из отображения
System.out.println("28_pollFirstEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("28_pollFirstEntry()_Вернул и удалил объект Map.Entry = Первый элемент отображения - \t"+ map1.pollFirstEntry());
System.out.println("28_pollFirstEntry()_Словарь map1 до  метода - \t\t\t" + map1  + "\n");

	//29_Map.Entry<K, V> pollLastEntry(): возвращает и одновременно удаляет последний элемент из отображения
map1.put(111, "Tom");
System.out.println("29_pollLastEntry()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("29_pollLastEntry()_Вернул и удалил объект Map.Entry = Последний элемент отображения - \t"+ map1.pollLastEntry());
System.out.println("29_pollLastEntry()_Словарь map1 до  метода - \t\t\t" + map1  + "\n");

	//30_K ceilingKey(K obj): возвращает наименьший ключ k, который больше или равен ключу obj (k >=obj). 
	//Если такого ключа нет, то возвращается null.
map1.put(143, "Alisa");
System.out.println("30_ceilingKey()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("30_ceilingKey()_Вернул int Ключ элемента с ближайшим большим ключом, чем заданный ключ 121 - \t"+ map1.ceilingKey(121));
System.out.println("30_ceilingKey()_Вернул null, т.к. нет элемента с большим ключом, чем заданный ключ 144 \t\t" + map1.ceilingKey(144) + "\n");
	
	// 31_K floorKey(K obj): возвращает наибольший ключ k, который меньше или равен ключу obj (k <=obj).
System.out.println("31_floorKey()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("31_floorKey()_Вернул int Ключ элемента с ближайшим меньшим ключом, чем заданный ключ 121 - \t"+ map1.floorKey(121));
System.out.println("31_floorKey()_Вернул null, т.к. нет элемента с меньшим ключом, чем заданный ключ 110 \t\t" + map1.floorKey(110) + "\n");

	//32_K lowerKey(K obj): возвращает наибольший ключ k, который меньше ключа obj (k <obj). Если такого ключа нет, то возвращается null.
System.out.println("32_lowerKey()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("32_lowerKey()_Вернул int Ключ элемента с ближайшим меньшим ключом, чем заданный ключ 121 - \t"+ map1.lowerKey(121));
System.out.println("32_lowerKey()_Вернул null, т.к. нет элемента с меньшим ключом, чем заданный ключ 110 \t\t" + map1.lowerKey(110) + "\n");

	//33_K higherKey(K obj): возвращает наименьший ключ k, который больше ключа obj (k >obj). Если такого ключа нет, то возвращается null.
System.out.println("33_higherKey()_Словарь map1 до  метода - \t\t\t" + map1);
System.out.println("33_higherKey()_Вернул int Ключ элемента с ближайшим большим ключом, чем заданный ключ 121 - \t"+ map1.higherKey(121));
System.out.println("33_higherKey()_Вернул null, т.к. нет элемента с большим ключом, чем заданный ключ 144 \t\t" + map1.higherKey(144) + "\n");

	//34_NavigableSet<K> descendingKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения в обратном порядке
NavigableSet<Integer> navSet = map1.descendingKeySet();
System.out.println("34_descendingKeySet()_Словарь TreeMap map1 до  метода - \t\t\t\t\t" + map1);
System.out.println("34_descendingKeySet()_Вернул набор ключей NavigableSet navSet с обратным располо ключей - \t" + navSet  + "\n");

	//35_NavigableMap<K, V> descendingMap(): возвращает отображение NavigableMap, которое содержит все элементы в обратном порядке
NavigableMap<Integer, String> navSet2 = map1.descendingMap();
System.out.println("35_descendingMap()_Словарь TreeMap map1 до  метода - \t\t\t\t\t" + map1);
System.out.println("35_descendingMap()_Вернул NavigableSet словарь Key-value с обратным распол ключей - \t" + navSet2  + "\n");

	//36_NavigableSet<K> navigableKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения
NavigableSet<Integer> navSet3 = map1.navigableKeySet();
System.out.println("36_navigableKeySet()_Словарь TreeMap map1 до  метода - \t\t\t\t\t" + map1);
System.out.println("36_navigableKeySet()_Вернул набор ключей NavigableSet navSet с нормальным располож ключей - \t" + navSet3  + "\n");

	/* 37_NavigableMap<K, V> headMap(K upperBound, boolean incl): возвращает отображение NavigableMap, которое содержит
	  все элементы оригинального NavigableMap вплоть от элемента с ключом upperBound. Параметр incl при значении true указывает, 
	  что элемент с ключом upperBound также включается в выходной набор.  */
System.out.println("37_headMap()_Словарь TreeMap map1 до  метода - \t\t\t\t\t" + map1);
NavigableMap<Integer, String> navSet4 = map1.headMap(131, true);
System.out.println("37_headMap()_Вернул словарь NavigableMap до элемента с ключом 131 ВКЛЮЧИТЕЛЬНО - \t" + navSet4);
NavigableMap<Integer, String> navSet5 = map1.headMap(131, false);
System.out.println("37_headMap()_Вернул словарь NavigableMap до элемента с ключом 131 НЕВКЛЮЧИТЕЛЬНО - \t" + navSet5);
NavigableMap<Integer, String> navSet6 = map1.headMap(139, false);
System.out.println("37_headMap()_Вернул словарь NavigableMap до элемента с ключом 139 НЕВКЛЮЧИТЕЛЬНО - \t" + navSet6);
System.out.println("УДАЛЕНИЕ ЭЛЕМЕНТОВ В созданному словаре приводит к удалению этого же элеметна в исходном словаре");
navSet6.remove(131);
System.out.println("37_headMap()_Словарь map1 после удаления элемента 131 в созданном из него словаря - \t" + map1 + "\n");

	/* 38_NavigableMap<K, V> tailMap(K lowerBound, boolean incl): возвращает отображение NavigableMap, которое содержит
	  все элементы оригинального NavigableMap, начиная с элемента с ключом lowerBound. Параметр incl при значении true указывает, 
	  что элемент с ключом lowerBound также включается в выходной набор.  */
map1.put(131,  "Kirill");
System.out.println("38_tailMap()_Словарь TreeMap map1 до  метода - \t\t\t\t\t\t" + map1);
NavigableMap<Integer, String> navSet7 = map1.tailMap(131, true);
System.out.println("38_tailMap()_Вернул словарь NavigableMap С элемента с ключом 131 ВКЛЮЧИТЕЛЬНО - \t" + navSet7);
NavigableMap<Integer, String> navSet8 = map1.tailMap(131, false);
System.out.println("38_tailMap()_Вернул словарь NavigableMap С элемента с ключом 131 НЕВКЛЮЧИТЕЛЬНО - \t" + navSet8);
NavigableMap<Integer, String> navSet9 = map1.tailMap(139, false);
System.out.println("38_tailMap()_Вернул словарь NavigableMap С элемента с ключом 139 НЕВКЛЮЧИТЕЛЬНО - \t" + navSet9);
System.out.println("УДАЛЕНИЕ ЭЛЕМЕНТОВ В созданному словаре приводит к удалению этого же элеметна в исходном словаре");
navSet9.remove(140);
System.out.println("38_tailMap()_Словарь map1 после удаления элемента 140 в созданном из него словаря - \t" + map1 + "\n");

	/* 39_NavigableMap<K, V> subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl): возвращает отображение 
	 NavigableMap, которое содержит все элементы оригинального NavigableMap от элемента с ключом lowerBound до элемента с ключом 
	 upperBound. Параметры lowIncl и highIncl при значении true включают в выходной набор элементы с ключами lowerBound и upperBound 
	 соответственно. 	 */
map1.put(140,  "Barak");
System.out.println("39_subMap()_Словарь map1 до  метода - \t\t\t\t\t\t" + map1);
NavigableMap<Integer, String> navSet10 = map1.subMap(120, true, 140, true);
System.out.println("39_subMap()_Вернул словарь NavigableMap С элемента120  и до элемента140 ВКЛЮЧИТЕЛЬНО - \t" + navSet10);
NavigableMap<Integer, String> navSet11 = map1.subMap(120, false, 140, false);
System.out.println("39_subMap()_Вернул словарь NavigableMap С элемента120  и до элемента140 НЕВКЛЮЧИТЕЛЬНО - \t" + navSet11);
NavigableMap<Integer, String> navSet12 = map1.subMap(121, true, 141, true);
System.out.println("39_subMap()_Вернул словарь NavigableMap С элемента121  и до элемента141 ВКЛЮЧИТЕЛЬНО - \t\t" + navSet12);
System.out.println("УДАЛЕНИЕ ЭЛЕМЕНТОВ В созданному словаре приводит к удалению этого же элеметна в исходном словаре");
navSet12.remove(140);
System.out.println("39_subMap()_Словарь map1 после удаления элемента 140 в созданном из него словаря - \t" + map1 + "\n");

	// 40_Comparator comparator() - возвращает comparator, используемый для упорядачивания ключей, или null для default comparator 
System.out.println("Вернул null, т.к. в map1 используется стандартный алгоритм \t" + map1.comparator()+ "\n");

Comparator<Person> pcomp3 = new PersonNameComparator().thenComparing(new PersonIdComparator());
TreeSet<Person> people_list4 = new TreeSet<Person> (pcomp3);	
people_list4.add(new Person("Bob", 22355));  
people_list4.add(new Person("Tom", 32355));
people_list4.add(new Person("Mark", 12355));
System.out.println(people_list4.toString());
	
	}
}

