package f21_COLLECTIONS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* Map — это структура данных, которая содержит набор пар “ключ-значение”. 
 При этом все ключи уникальные в рамках объекта Map (значения могут повторяться). Это облегчает поиск элемента, если нам известен ключ
 Применяется, например, когда нужно внести в список и ФИО, и данные паспорта, и естественно данные паспорта яв-ся уникальными для человека
 По своей структуре данных напоминает словарь, поэтому ее часто так и называют.
 
 Интерфейс Map НЕ расширяет интерфейс Collection.
 Интерфейс Map реализует аюстрактный класс AbstractMap, а его наследуют Hashmap, LinkedHashMap, Hashtable, TreeMap.
 Самая используемая реализация — Hashmap
 
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
 
 	Интерфейс Map.Entry в Java позволяет работать с записями, как с Set
 		Методы интерфейса Map.Entry
 - boolean equals(Object obj) - возвращает true, если obj - это Map.Entry, чей ключ и значение равны значению вызывающего объекта.
 - Object getKey( ) - возвращает ключ для этой записи в Map.
 - Object getValue( ) - возвращает значение для этой записи в Map.
 - int hashCode( ) - возвращает хэш-код для этой записи в Map.
 -  Object setValue(Object v) - устанавливает значение v для этой записи Map. Вызывается ClassCastException, если v не является правильным типом для Map. A Исключение NullPointerException выдается, если v является нулём, а Map не разрешает нулевые ключи. Исключение UnsupportedOperationException возникает, если карта не может быть изменена.
*/

public class t14_Hash_map {
public static void main(String[] args) {
	Map <Integer, String> map1 = new HashMap<>();			// конструктор по умолчанию. Начальная емкость по умолчанию – 16, коэффициент загрузки – 0,75.
	Map <Integer, String> map2 = new HashMap<>(20);			// конструктор с заданной начальной емкостью. Коэффициент загрузки – 0,75.
	Map <Integer, String> map3 = new HashMap<>(20, 0.75F); 	// конструктор для заданной емкости и заданным коэффициентом загрузки
/*Коэффициент загрузки = Количество хранимых элементов в таблице / размер хэш-таблицы (общее кол-во ячеек). 
Коэффициент загрузки и начальная емкость – два главных фактора, от которых зависит производительность операций с HashSet.
Коэффициент загрузки = 0,75, в среднем обеспечивает хорошую производительность. Если этот параметр увеличить, тогда уменьшится нагрузка
на память (так как это уменьшит количество операций ре-хэширования и перестраивания), но это повлияет на операции добавления и поиска. */
			
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

	//22_Сортировка всего словаря через создание TreeMap
map1.put(141, "Bob");
System.out.println("22_Сортировка всего словаря через создание TreeMap, до  метода - \t" + map1);
SortedMap <Integer, String> treeMap = new TreeMap<Integer, String>(map1);
System.out.println("22_Сортировка всего словаря через создание TreeMap, ПОСЛЕ  метода - \t" + treeMap);

	}
}



class KeyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) return 1;
		else if (o1<o2) return -1;
		else return 0; 	}
}
