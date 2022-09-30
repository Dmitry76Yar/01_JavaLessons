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

/* Map � ��� ��������� ������, ������� �������� ����� ��� �����-��������. 
 ��� ���� ��� ����� ���������� � ������ ������� Map (�������� ����� �����������). ��� ��������� ����� ��������, ���� ��� �������� ����
 �����������, ��������, ����� ����� ������ � ������ � ���, � ������ ��������, � ����������� ������ �������� ��-�� ����������� ��� ��������
 �� ����� ��������� ������ ���������� �������, ������� �� ����� ��� � ��������.
 
 ��������� Map �� ��������� ��������� Collection.
 ��������� Map ��������� ����������� ����� AbstractMap, � ��� ��������� Hashmap, LinkedHashMap, Hashtable, TreeMap.
 ����� ������������ ���������� � Hashmap
 
	� ������ �� ���������� ���������� Map (Hashmap, LinkedHashMap, Hashtable, TreeMap) ���� ���� �����������:
		1. HashMap: 
 - �� �����������, ��� �������� ����� ��������� � ������� ����������.����� ������� ��������� ����� �������� �� ��������.
 - ��������� ����� ���� � �������� null 
 - ��������� ������ ��� ������� - ���-�������
  		2. Hashtable
 - ������������������. ������ HashTable ����������������, ��������� � ���. ���� � ���� �� ����� ���������� ������ ������, �������������
 ������������ HashMap ������ HashTable.
 - �� �����������, ��� �������� ����� ��������� � ������� ����������.����� ������� ��������� ����� �������� �� ��������.
 - �� ��������� ����� ���� � �������� null
 - ��������� ������ ��� ������� - ���-�������
  		3.  TreeMap
 - ����������� �������� ��������� � ������� ���������� ��� �� � ������������ � �������� ������������.
 - TreeMap ����� ������������ �������� null ������ ���� ��� ��������� ����������. ��� ������������� ����������� (��� �������� ��� 
� ������� ����������) �������� null �� �����������.
- ��������� ������ ��� ������� - ������-������ ������
 
 ����� �������� ������ � ���������, ������������ ����� put, � ����� �������� �� ����� - ����� get
 		������ ���������� Map
 - V put(K k, V v): �������� � ��������� ����� ������ � ������ k � ��������� v. ���� � ��������� ��� ���� ������ � �������� ������, �� �� ����������������. ����� ���������� ���������� ���������� �������� ��� ����� k, ���� �� ��� ��� � ���������. ���� �� ����� ��� �� ���� � ���������, �� ������������ �������� null
 - void putAll(Map<? extends K, ? extends V> map): ��������� � ��������� ��� ������� �� ����������� map
 - V putIfAbsent(K k, V v): �������� � ��������� ����� ������ � ������ k � ��������� v, ���� � ��������� ��� ��� �������� � �������� ������.
 - V get(Object k): ���������� �������� �������, ���� �������� ����� k. ���� ������ �������� �� ��������, �� ������������ �������� null
 - V getOrDefault(Object k, V defaultValue): ���������� �������� �������, ���� �������� ����� k. ���� ������ �������� �� ��������, �� ������������ �������� defaultVlue
 - Set<Map.Entry<K, V>> entrySet(): ���������� ����� ��������� ���������. ��� �������� ������������ ������ Map.Entry
 - Set<K> keySet(): ���������� ����� ���� ������ �����������
 - Collection<V> values(): ���������� ����� ���� �������� �����������
 - int size(): ���������� ���������� ��������� ���������
 - boolean containsKey(Object k): ���������� true, ���� ��������� �������� ���� k
 - boolean containsValue(Object v): ���������� true, ���� ��������� �������� �������� v
 - boolean isEmpty: ���������� true, ���� ��������� �����
 - boolean equals(Object obj): ���������� true, ���� ��������� ��������� ���������, ������������ ����� �������� obj
 - V remove(Object k): ������� ������ � ������ k
 - void clear(): ������� ���������
 
 	��������� Map.Entry � Java ��������� �������� � ��������, ��� � Set
 		������ ���������� Map.Entry
 - boolean equals(Object obj) - ���������� true, ���� obj - ��� Map.Entry, ��� ���� � �������� ����� �������� ����������� �������.
 - Object getKey( ) - ���������� ���� ��� ���� ������ � Map.
 - Object getValue( ) - ���������� �������� ��� ���� ������ � Map.
 - int hashCode( ) - ���������� ���-��� ��� ���� ������ � Map.
 -  Object setValue(Object v) - ������������� �������� v ��� ���� ������ Map. ���������� ClassCastException, ���� v �� �������� ���������� ����� ��� Map. A ���������� NullPointerException ��������, ���� v �������� ����, � Map �� ��������� ������� �����. ���������� UnsupportedOperationException ���������, ���� ����� �� ����� ���� ��������.
*/

public class t14_Hash_map {
public static void main(String[] args) {
	Map <Integer, String> map1 = new HashMap<>();			// ����������� �� ���������. ��������� ������� �� ��������� � 16, ����������� �������� � 0,75.
	Map <Integer, String> map2 = new HashMap<>(20);			// ����������� � �������� ��������� ��������. ����������� �������� � 0,75.
	Map <Integer, String> map3 = new HashMap<>(20, 0.75F); 	// ����������� ��� �������� ������� � �������� ������������� ��������
/*����������� �������� = ���������� �������� ��������� � ������� / ������ ���-������� (����� ���-�� �����). 
����������� �������� � ��������� ������� � ��� ������� �������, �� ������� ������� ������������������ �������� � HashSet.
����������� �������� = 0,75, � ������� ������������ ������� ������������������. ���� ���� �������� ���������, ����� ���������� ��������
�� ������ (��� ��� ��� �������� ���������� �������� ��-����������� � ��������������), �� ��� �������� �� �������� ���������� � ������. */
			
		/* 1_V put(K k, V v): �������� � ��������� ����� ������ � ������ k � ��������� v. ���� � ��������� ��� ���� ������ � ��������
	������, �� �� ����������������. ����� ���������� ���������� ���������� �������� ��� ����� k, ���� �� ��� ��� � ���������. 
	���� �� ����� ��� �� ���� � ���������, �� ������������ �������� null	*/
System.out.println("1_put(K, V)_������ null, �.�. ����������  �������� ������� Tom c ������ 111 - \t\t" + map1.put(111, "Tom"));
System.out.println("1_put(K, V)_������ null, �.�. ����������  �������� ������� Tom c ������ 120 - \t\t" + map1.put(120, "Tom"));
System.out.println("1_put(K, V)_������ null, �.�. ����������  �������� ������� Alice c ������ 131 - \t" + map1.put(131, "Alice"));
System.out.println("1_put(K, V)_������ null, �.�. ����������  �������� ������� Kate c ������ 140 - \t\t" + map1.put(140, "Kate"));
System.out.println("1_put(K, V)_������ Kate, �.�. ����� ������� � ��������� ���������� �������� Mark ������ Kate - \t\t" + map1.put(140, "Mark"));
System.out.println("1_put(K, V)_������� ����� ���������� ���� ��������� - \t\t\t\t\t" + map1 + "\n");

		// 2_void putAll(Map<? extends K, ? extends V> map): ��������� � ��������� ��� ������� �� ����������� map
map2.putAll(map1);
System.out.println("2_putAll(Map)_���������� ��� �������� �� map1 � map2 - \t\t\t\t\t" + map2 + "\n");

		// 3_V putIfAbsent(K k, V v): �������� � ��������� ����� ������ � ������ k � ��������� v, ���� � ��������� ��� ��� ��������
		// � �������� ������.
System.out.println("3_putIfAbsent(K, V)_������� ��  ������ - \t\t\t\t\t" + map1);
System.out.println("3_putIfAbsent(K, V)_������ null, �.�. ����������  �������� ������� Alisa c ���������� ������ 143 - \t" + map1.putIfAbsent(143, "Alisa"));
System.out.println("3_putIfAbsent(K, V)_������ Mark, �.�. �� ���������� �������� Kate  � ��� �� ������ 140 - \t\t" + map1.putIfAbsent(140, "Kate"));			
System.out.println("3_putIfAbsent(K, V)_������� �����  ������ - \t\t\t\t\t" + map1 + "\n");		
			
		// 4_V get(Object k): ���������� � �� ������� �������� �������, ���� �������� ����� k. ���� ������ �������� �� ��������, �� 
		//������������ �������� null
System.out.println("4_get(Object)_������� ��  ������ - \t\t\t\t" + map1);
System.out.println("4_get(Object)_������ ��������� ������ � ������ 143 - \t\t" + map1.get(143));
System.out.println("4_get(Object)_������ null, �.�. �� ����� ������ � ������ 144 - \t" + map1.get(144));
System.out.println("4_get(Object)_������� �����  ������ - \t\t\t\t" + map1 + "\n");

		// 5_V getOrDefault(Object k, V defaultValue): ���������� � �� ������� �������� �������, ���� �������� ����� k. 
		//���� ������ �������� �� ��������, �� ������������ �������� defaultVlue
System.out.println("5_get(Object, value)_������� ��  ������ - \t\t\t\t" + map1);
System.out.println("5_get(Object, value)_������ ��������� ������ � ������ 143 - \t\t" + map1.getOrDefault(143, "defaultValue" ));
System.out.println("5_get(Object, value)_������ null, �.�. �� ����� ������ � ������ 144 - \t" + map1.getOrDefault(144, "defaultValue"));
System.out.println("5_get(Object, value)_������� �����  ������ - \t\t\t\t" + map1 + "\n");

		//6_1_����� entrySet() - ���������� Set, ���������� ������ Map. ������ �� ���� ��������� �������� �������� Map.Entry
	// 
	
		// 6_������� � �������������� entrySet(): ���������� ����� ��������� ���������. ��� �������� ������������ ������ Map.Entry
//������� �������� � ����� ������ ��������. ��� ���� (����-��������) �������� �� ���������� ���������� Map.Entry, � ����� �������� ��,
//����� ������� ����� entrySet(). �� ���������� ��������� (Set) ���, ������� ����� ��������� � �����:
System.out.print("6_������� ����� 6_entrySet() � ���������� ���� ������ � �������� \t"); System.out.println();
for (Map.Entry<Integer, String> entry : map1.entrySet()) {
		// �������� �����  � ��������
	System.out.print(" \t" + entry.getKey()); 
	System.out.print(" \t" + entry.getValue());} 
System.out.println("\n");

	// 7_������� � �������������� Iterator
System.out.print("7_������� � �������������� Iterator � ���������� ���� ������ � �������� \t"); System.out.println();
Iterator<Map.Entry<Integer, String>> itr = map1.entrySet().iterator();
while(itr.hasNext()) { Map.Entry<Integer, String> entry2 =  itr.next();
		//�������� �����  � ��������
	System.out.print(" \t" + entry2.getKey()); 
	System.out.print(" \t" + entry2.getValue()); }
System.out.println("\n");

	// 8_- Set<K> keySet(): ���������� ����� ���� ������ �����������
Set<Integer> keySet = map1.keySet();
System.out.println("8_- keySet() �������� Set ����� ������ " + keySet); 
// ��� ��� � ������ ArrayList ���� ����������� � ���������� Collection � ��� ��� Set �������� ����������� Collection, �� �����
// �������� ����  Set � ArrayList
ArrayList<Integer> keyArrayList = new ArrayList<Integer>(keySet);
System.out.println("8_- keySet() ����� �������������� � ArrayList " + keyArrayList + "\n");

	// 9_Collection<V> values(): ���������� ����� ���� �������� �����������
Collection<String> ValuesCol = map1.values();
System.out.println("9_- values() �������� Collection ����� ����� ���� �������� " + ValuesCol);
//��� ��� � ������ ArrayList ���� ����������� � ���������� Collection, �� ����� �������� � ArrayList
ArrayList<String> ValuesArrayList = new ArrayList<String>(ValuesCol);
System.out.println	("9_- values() ����� �������������� � ArrayList " + ValuesArrayList + "\n");

	// 10_int size(): ���������� ���������� ��������� ���������
System.out.println("10_size()_������� ��  ������ - \t" + map1);
System.out.println("10_size()_������ - \t\t\t" + map1.size() + "\n");

	// 11_boolean containsKey(Object k): ���������� true, ���� ��������� �������� ���� k
System.out.println("11_containsKey()_������� ��  ������ - \t" + map1);
System.out.println("11_containsKey()_�������� ������� � ������ 120 - \t\t\t" + map1.containsKey(120));
System.out.println("11_containsKey()_�������� ������� � ������ 121 - \t\t\t" + map1.containsKey(121) + "\n");

	//12_boolean containsValue(Object v): ���������� true, ���� ��������� �������� �������� v
System.out.println("12_containsValue()_������� ��  ������ - \t\t\t\t" + map1);
System.out.println("12_containsValue()_�������� ������� � ��������� Mark - \t\t\t" + map1.containsValue("Mark"));
System.out.println("12_containsValue()_�������� ������� � ��������� Mark22 - \t\t" + map1.containsValue("Mark22") + "\n");

	//13_boolean isEmpty: ���������� true, ���� ��������� �����
System.out.println("13_isEmpty()_������� map1 ������? - \t\t\t" + map1.isEmpty());
System.out.println("13_isEmpty()_������� map3 ������? - \t\t\t" + map3.isEmpty() + "\n");

	//14_boolean equals(Object obj): ���������� true, ���� ��������� ��������� ���������, ������������ ����� �������� obj
System.out.println("14_equals()_������� map1 - \t\t\t\t" + map1);
System.out.println("14_equals()_������� map2 - \t\t\t\t" + map2);
System.out.println("14_equals()_������� map1 �������� � map2? - \t\t" + map1.equals(map2) + "\n");

	//15_V remove(k): ������� ������ � ������ k
System.out.println("15_remove()_������� map1 ��  ������ - \t\t" + map1);
System.out.println("15_remove()_������� map2 ��  ������ - \t\t" + map2);
System.out.println("15_remove()_������ �������� ���������� �������� \t\t\t" +  map1.remove(140));
System.out.println("15_remove()_������ null, �.�. �� ����� ������ �������� \t\t\t" +  map1.remove(141));
System.out.println("15_remove()_������� map1 �����  ������ - \t" + map1);
System.out.println("15_remove()_������� map2 �����  ������ - \t" + map2  + "\n");

	//16_V remove(k,v): ������� ������ � ������ k � ��������� v
map1.put(140, "Mark2");
System.out.println("16_remove(k,v)_������� map1 ��  ������ - \t\t" + map1);
System.out.println("16_remove(k,v)_�� ����� ������ �������� 140 - Mark3 \t" + map1.remove(140, "Mark3"));
System.out.println("16_remove(k,v)_����� � ������ ������� 140 - Mark2 \t" + map1.remove(140, "Mark2"));
System.out.println("16_remove(k,v)_������� map2 �����  ������ - \t" + map2  + "\n");

	//17_replace(key, value)_�������� �������� �������� ���������� �� �������
map1.put(140, "Mark2");
System.out.println("17_replace(k,v)_������� map1 ��  ������ - \t\t" + map1);
System.out.println("17_replace(k,v) ������ ���������� �������� ���������� �� ������� �������� \t" + map1.replace(131, "AliceNEW"));
System.out.println("17_replace(k,v)_������ null, �.�. �� ����� ������ �������� \t\t\t" +  map1.replace(121, "UUUUUU"));
System.out.println("17_replace(k,v)_������� map1 �����  ������ - \t\t" + map1 + "\n");

	//18_replace(key, oldValue, newValue)  _�������� �������� �������� ���������� �� ������� 
System.out.println("18_replace(k,v,v)_������� map1 ��  ������ - \t\t" + map1);
System.out.println("18_replace(k,v,v) ������ ���������� �������� ���������� �� ������� �������� \t" + map1.replace(131, "AliceNEW", "AliceNEW2"));
System.out.println("18_replace(k,v,v)_������ null, �.�. �� ����� ������ �������� \t\t\t" +  map1.replace(131, "AliceNEW", "UUUUUU"));
System.out.println("18_replace(k,v,v)_������� map1 �����  ������ - \t\t" + map1  + "\n");

	//19_clear(): ������� ���������
System.out.println("19_clear()_������� map1 ��  ������ - \t\t" + map2);
map2.clear();
System.out.println("19_clear()_������� map1 ��  ������ - \t\t" + map2 + "\n");

	//20_���������� ������ ����� �������� Map.Entry � ����� ���������� ��� � ������ ArrayList	
ArrayList<Entry<Integer, String>> entryList2 = new ArrayList<Entry<Integer, String>>(map1.entrySet());
//System.out.println("20_���������� ������_������� map1 ��  ������ - \t\t\t" + map1);
System.out.println("20_���������� ������_ Entry ������ entryList2 ��  ������ - \t" + entryList2);
Collections.sort(entryList2, new Comparator<Entry<Integer, String>>() {
		@Override
	public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
		if(o1.getKey() > o2.getKey())	return 1;
		else if(o1.getKey() < o2.getKey())	return -1;
		else return 0;		}
});
System.out.println("20_���������� ������_ Entry ����� entryList2 ��  ������ - \t" + entryList2  + "\n");
//System.out.println("20_���������� ������_������� map1 �����  ������ - \t\t" + map1 + "\n");

	//21_���������� �������� ����� �������� Map.Entry � ����� ���������� ��� � ������ ArrayList	
ArrayList<Entry<Integer, String>> entryList3 = new ArrayList<Entry<Integer, String>>(map1.entrySet());
//System.out.println("21_���������� �������� - ������� map1 ��  ������ - \t\t" + map1);
System.out.println("21_���������� �������� - Entry ������ entryList2 ��  ������ - \t" + entryList3);
Collections.sort(entryList3, new Comparator<Entry<Integer, String>>() {
		@Override
	public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
			return o1.getValue().compareTo(o2.getValue());	}
});
System.out.println("21_���������� �������� - Entry ����� entryList2 ��  ������ - \t " + entryList3  + "\n");
//System.out.println("21_���������� �������� - ������� map1 �����  ������ - \t\t" + map1 + "\n");

	//22_���������� ����� ������� ����� �������� TreeMap
map1.put(141, "Bob");
System.out.println("22_���������� ����� ������� ����� �������� TreeMap, ��  ������ - \t" + map1);
SortedMap <Integer, String> treeMap = new TreeMap<Integer, String>(map1);
System.out.println("22_���������� ����� ������� ����� �������� TreeMap, �����  ������ - \t" + treeMap);

	}
}



class KeyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) return 1;
		else if (o1<o2) return -1;
		else return 0; 	}
}
