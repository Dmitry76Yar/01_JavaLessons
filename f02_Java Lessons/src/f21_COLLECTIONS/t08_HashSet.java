package f21_COLLECTIONS;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* �������� ������: 	����� AbstractSet - ����� AbstractCollection - ������ HashSet
   ���������: 			��������� Iterable - ��������� Collection - ��������� Set, � ����� ���������� Serializable � Cloneable
   
   � HashSet ������� ��������� ������������ �� �������� ���������, ��� ����������. 
  � ���������� TreeSet, � ������� ������� �������� ���������������� �� ����������� � ������� ��������� 
  � ���������� LinkedHashSet � ��������� ��������� � ������� ����������.
  
��������� Set ������������ ����� ���������� ���������.      ���������� ����� HashSet ������������ ���-�������.  
�� ������ �� ����� �� ����� ArrayList, � � �����-�� ������ �������� ��� ����� ����������� �������.
HashSet � ��� ���������, ������� ��� �������� ��������� ������ ���������� �� ���-��������, ������� ���������� ����� hashCode().
��� �������� ������ HashSet<E> �������� ������ HashMap<E, Object>, ������� � ������ � �������� ������ �������� HashSet.
������ ���� ��������� ��������� ���������������� ������ � �������.
������������� hash-����� ��������� �������� ������ ������, ��������� � ������� �������� �� ��������� (Set).
HashSet �� ������������ ������� ���������. ��-������, ���������� ��� ������ ���, ��-������, ���� ���������� ������� ����� ������ 
���������� ��� ���������� ����� ������ ��������. � ��������� ���� ��������� ��� �������. ������ �������� ������� �� ��� ������� ���
�������� �������� � ��������� �� ������������� �������. 
	����� ���������
����� �� ���������� �� ��������� ����� �������, �������� �������, ��� ���������� ������� ��������, ������ ������ ����������� ����� 
��������. �������� ��������� � ���������� ������� ������������ ������� �� hashCode(), � ���� hashCode() ���������, �� equals.
	�����, ����� ������� ����� ������� ����� ���� ������ � Set � ��������� �������� �� ���, � ������ ������ ������ ���� ���������
����������� ������ hashCode & equals.
���� �� �������� ����������� ����� hashCode(), �� ��������, ��� ���� ������ � ��������� Set �� ����� ������, ���� ���� �� ��� ����.
����� �����, ��� ���� ��� ������� ���������� ���������� ������� hashCode � equals � ����� ������, ���� ���������� ��������� ������-����
�������, �� ��� ���� �������� � ��� hashcode. � ��� ������, ��� ����� �� ������ ��� ������ � Set��, ��� ������ ����� �� ������.
��� ���� ��������� ����� � ������� HashSet. ����� ������, ����� � HashSet (� � HashMap) �������������� �������� ���������, ������ 
���� ������� � immutable.

		��������� ������ ������� � HashSet:
- �.�. ����� ��������� ��������� Set, �� ����� ������� ������ ���������� ��������;
- ����� ������� NULL � ��������;
- ������� ���������� ��������� ����������� � ������� ���-����;
- ��������� ������� � ����������� ���������� ����� (�������) � ���-�������. ���� ��� ����� ���������, �� ���������� ���������� �������������.
- ����������� �������� = ���������� �������� ��������� � ������� / ������ ���-������� (����� ���-�� �����). 
����������� �������� � ��������� ������� � ��� ������� �������, �� ������� ������� ������������������ �������� � HashSet.
����������� �������� = 0,75, � ������� ������������ ������� ������������������. ���� ���� �������� ���������, ����� ���������� ��������
�� ������ (��� ��� ��� �������� ���������� �������� ��-����������� � ��������������), �� ��� �������� �� �������� ���������� � ������. 

		������ ���������� Collection
- boolean add (E item): ��������� � ��������� ������ item. ��� ������� ���������� ���������� true, ��� ��������� - false
- boolean addAll (Collection<? extends E> col): ��������� � ��������� ��� �������� �� ��������� col. ��� ������� ���������� ���������� true, ��� ��������� - false
- void clear (): ������� ��� �������� �� ���������
- boolean contains (Object item): ���������� true, ���� ������ item ���������� � ���������, ����� ���������� false
- boolean isEmpty (): ���������� true, ���� ��������� �����, ����� ���������� false
- Iterator<E> iterator (): ���������� ������ Iterator ��� ������ ��������� ���������
- boolean remove (Object item): ���������� true, ���� ������ item ������ ������ �� ���������, ����� ������������ false
- boolean removeAll (Collection<?> col): ������� ��� ������� ��������� col �� ������� ���������. ���� ������� ��������� ����������, ���������� true, ����� ������������ false
- boolean retainAll (Collection<?> col): ������� ��� ������� �� ������� ���������, ����� ���, ������� ���������� � ��������� col. ���� ������� ��������� ����� �������� ����������, ���������� true, ����� ������������ false
- int size (): ���������� ����� ��������� � ���������
- Object[] toArray (): ���������� ������, ���������� ��� �������� ���������

		������ ���������� Set
Set �� ��������� ����� �������, ������ ������ ��������� ��������������. � ���������, ����� add() ��������� ������� � ��������� � 
���������� true, ���� � ��������� ��� ��� ������ ��������.

		������ ������ HashSet
- HashSet(): ����������� �� ���������. ��������� ������� �� ��������� � 16, ����������� �������� � 0,75.
- HashSet(int initialCapacity): ����������� � �������� ��������� ��������. ����������� �������� � 0,75.
- HashSet(int initialCapacity, float loadFactor):  ����������� � ��������� ��������� �������� � ������������� ��������.
- HashSet(Collection C): �����������, ����������� �������� �� ������ ���������.
 */

public class t08_HashSet {
public static void main(String[] args) {
	
	HashSet<String> people = new HashSet<String>();   	//����������� �� ���������. ��������� ������� �� ��������� � 16, ����������� �������� � 0,75.
	HashSet<String> people2 = new HashSet<String>(20);	//����������� � �������� ��������� ��������. ����������� �������� � 0,75.
	
		// 1_void add(E obj)_��������� � ������ ������ void add(E obj)		��� ������� ���������� ���������� true, ��� ��������� - false
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Tom - \t\t" + people.add("Tom"));
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Alice - \t\t" + people.add("Alice"));
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Kate - \t\t" + people.add("Kate"));
	System.out.println("1_add(E obj)_������ false, �.�. �� ���������� ����� �������� ������� Kate - \t" + people.add("Kate"));
	System.out.println("1_add(E obj)_���-������� ����� ���������� ���� ��������� - \t\t\t" + people);
	System.out.println("1_add(E obj)_������ ��������, ��� �������� ����������� �� � ������� �� �������� � �������, � �� ���������� hashcode");
	System.out.print("hashCode ��� Tom = " + "Tom".hashCode() + "\t"); 
	System.out.print("hashCode ��� Alice = " + "Alice".hashCode() + "\t");
	System.out.print("hashCode ��� Kate = " + "Kate".hashCode() + "\t\n\n");
	
		// 2_addAll()_��������� � ������ people2 ��� �������� �� ������ people
	System.out.println("2_addAll()_������ true, �.�. ����������  �������� ��� �������� ������ people - \t" + people2.addAll(people));
	System.out.println("2_addAll()_������ false, �.�. �� ���������� ����� ��� �������� ������ people - \t" + people2.addAll(people) + "\n");
	
		// 3_clear()_������� ��� �������� �� ���������   	void clear ():
	System.out.println("3_clear()_������ people2 �� �������� ���� ��������/��������� -    " + people2.toString());
	people2.clear();
	System.out.println("3_clear()_������ people2 ����� �������� ���� ��������/��������� -    " + people2.toString()  + "\n");
	 
	 	// 4_boolean contains (Object item): ���������� true, ���� ������ item ���������� � ���-�������, ����� ���������� false
	System.out.println("4_contains() - ���-������� �� ������ - \t\t\t\t" + people);
	System.out.println("4_contains() - ���-������� �������� ������ Alice? - \t\t\t" + people.contains("Alice"));
	System.out.println("4_contains() - ���-������� ����� ������ - \t\t\t" + people + "\n");
	
		// 5_boolean containsAll (Collection a): ���������� true, ���� ���-������� ���������� � ���-�������, ����� ���������� false
	people2.addAll(people);
	System.out.println("4_containsAll()_ ���-������� people2 �������� ���-������� people? - \t\t\t" + people2.containsAll(people) + "\n");
		  
		// 6_boolean isEmpty (): ���������� true, ���� ���-������� �����, ����� ���������� false
	System.out.println("6_isEmpty - ���-������� people ����? - \t" + people.isEmpty() + "\n");
			   
		// 7_remove(Object)_������� �������� ������ �� ���-�������, ��������� ��� ���� true ��� ���������� ������ �������
	System.out.println("7_remove(Object)_������ true ��� ���������� Alice - \t   " + people.remove("Alice"));
	System.out.println("7_remove(Object)_������ false ��� ������������ Piter - \t   " + people.remove("Piter"));
	System.out.println("7_remove(Object)_���-������� people ����� ��������� Alice -    " + people + "\n");
		   
	   	// 8_removeAll(Collection c)_������� �� ���-������� people2 ��� ������� ���-������� people, ��������� ��� ���� true ��� ���������� ������ �������
	people.add("Alice");
	System.out.println("8_removeAll(Object)_������ true ��� ���������� ���� �������� people � people2 \t-   " + people2.removeAll(people));
	System.out.println("8_removeAll(Object)_people2 ����� ��������� ���� ��������� ������ people -    \t  " + people2.toString());
	System.out.println("8_removeAll(Object)_������ false ��� ������������ ���� �������� people -   \t  " + people2.removeAll(people)  + "\n");

		// 9_retainAll(Collection c)_��������� � ���-������� people2 ������ ������� ���-������� people, ��������� ��� ���� true ��� ���������� ������ �������
	people2.addAll(people);
	people2.add("Mary");		people2.add("Mary2"); 	people2.add("Mary3");
	System.out.println("9_retainAll() - ���-������� people2 �� ������ - \t\t\t" + people2);
	people2.retainAll(people);
	System.out.println("9_retainAll() - ���-������� people2 ����� ������ - \t\t\t" + people2);
	System.out.println("9_retainAll()_������ false ��� ������������ ����� people - \t\t   " + people2.retainAll(people)  + "\n");
	
		//10_int_size(): ���������� ����� ��������� � ���-������e
	System.out.println("10_int_size() - ���-������� people �� ������ - \t\t\t\t" + people2);
	System.out.println("10_int_size()_����� ��������� �  people - \t\t\t\t" + people.size() + "\n");
	
		// 11_Object[] toArray (): ���������� ������, ���������� ��� �������� ���������
	 Object Array[] = people.toArray();
	 Array.toString();
	 System.out.println("11_toArray ()_����� �������� � ������,   Array[1] =  \t" + Array[1] + "\n");
	 
	 	// ����� ����� �������� � ������ ������ ����, ��� � SET:
	 HashSet<String> str2_Set = new HashSet<String>();
	 str2_Set.add("1");		str2_Set.add("2");		str2_Set.add("3");
	 String str2_array[] = new String [str2_Set.size()];
	 str2_array = str2_Set.toArray(str2_array);
	 System.out.println(Arrays.toString(str2_array));
	     
	 	// ����������
	 /* �� �� ������ ����� �������, ��������� Set �� ����� ������� ������������� ������� (�. .get() �������� � �������� ��������), 
	  * ��� � �������� ��������� ��� ���������� ����������;) 
	  * ������, ���� ��� ������ ����� ���� ��������, ��������������� ��� ����� ������ ���������, ������ �������� �������� ������ � ��������� ����������, �������:
	  * List sortedList = new ArrayList(yourHashSet);
		Collections.sort(sortedList);
	  * 	  */
	 
	 
	}
}
