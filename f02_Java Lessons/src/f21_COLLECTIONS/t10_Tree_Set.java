package f21_COLLECTIONS;
import java.util.ArrayList;
import java.util.NavigableSet;
/* ���������� ����� TreeSet<E> ������������ ��������� ������ � ���� ������, � ������� ��� ������� �������� � ��������������� ���� 
 �� �����������.
  � HashSet ������� ��������� ������������ �� �������� ���������, ��� ����������. 
  � ���������� TreeSet, � ������� ������� �������� ���������������� �� ����������� � ������� ��������� 
  � ���������� LinkedHashSet � ��������� ��������� � ������� ����������.
  
  ������ TreeSet<E> ���������� TreeMap<E, Object> ������� � ������ ��� ��� ��������.
  ������� � ���� ����� ������� �������� add, remove, contains.
 	�������� ������ TreeSet
	���������: ����� AbstractCollection - ����� AbstractSet - ����� TreeSet
 	���������: ��������� Iterable - ��������� Collection - ��������� Set - ��������� SortedSet - ��������� NavigableSet
��������� SortedSet ��������� ������������� ���������, ��������������� � ������������ ������� ��� �� �������, ��������� �����������
���������� Comparator.			SortedSet ������ ������ ���������� ��������. 
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
Set �� ��������� ����� �������.
		������ ���������� SortedSet:
- Comparator<? super E> comparator() - ���������� ���������� �������������� ���������. ���� ��� ��������� ����������� ������������ ������� ����������, ������������ null.
- E first() - ���������� ������ ������� ����������� �������������� ���������.
- E last() - ���������� ��������� ������� ����������� �������������� ���������.
- SortedSet headSet(E toElement)- ���������� SortedSet, ���������� �������� �� ����������� ���������, ������� ������������ end.
- SortedSet subSet(E fromElement, E toElement) - ���������� SortedSet, ���������� �������� �� ����������� ���������, ����������� ����� start � end-1.
- SortedSet tailSet(E fromElement) - ���������� SortedSet, ���������� �������� �� ����������� ���������, ������� ������� �� end.
 		������ ���������� NavigableSet
��������� NavigableSet ��������� ��������� SortedSet � ��������� ��������� �������� �� ��������� �� ��������. 
- E ceiling(E obj): ���� � ������ ���������� ������� e, ������� ������ obj (e >=obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
- E floor(E obj): ���� � ������ ���������� ������� e, ������� ������ �������� obj (e <=obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
- E higher(E obj): ���� � ������ ���������� ������� e, ������� ������ �������� obj (e >obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
- E lower(E obj): ���� � ������ ���������� ������� e, ������� ������ �������� obj (e <obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
- E pollFirst(): ���������� ������ ������� � ������� ��� �� ������
- E pollLast(): ���������� ��������� ������� � ������� ��� �� ������
- NavigableSet<E> descendingSet(): ���������� ������ NavigableSet, ������� �������� ��� �������� ���������� ������ NavigableSet � �������� �������
- NavigableSet<E> headSet(E upperBound, boolean incl): ���������� ������ NavigableSet, ������� �������� ��� �������� ���������� ������ NavigableSet �� upperBound. �������� incl ��� �������� true, ��������� �������� � �������� ����� ������� upperBound
- NavigableSet<E> tailSet(E lowerBound, boolean incl): ���������� ������ NavigableSet, ������� �������� ��� �������� ���������� ������ NavigableSet, ������� � lowerBound. �������� incl ��� �������� true, ��������� �������� � �������� ����� ������� lowerBound
- NavigableSet<E> subSet(E lowerBound, boolean lowerIncl, E upperBound, boolean highIncl): ���������� ������ NavigableSet, ������� �������� ��� �������� ���������� ������ NavigableSet �� lowerBound �� upperBound.

		������ ������ TreeSet
���������� ����� TreeSet<E> ������������ ��������� ������ � ���� ������, � ������� ��� ������� �������� � ��������������� ���� �� 
�����������. TreeSet �������� ����������� ������ AbstractSet � ��������� ��������� NavigableSet, � �������������, � ��������� SortedSet.
� ������ TreeSet ���������� ��������� ������������:
- TreeSet(): ������� ������ ������
- TreeSet(Collection<? extends E> col): ������� ������, � ������� ��������� ��� �������� ��������� col
- TreeSet(SortedSet <E> set): ������� ������, � ������� ��������� ��� �������� �������������� ������ set
- TreeSet(Comparator<? super E> comparator): ������� ������ ������, ��� ��� ����������� �������� ������������ ����� ������������� ������������.
 */
import java.util.TreeSet;

public class t10_Tree_Set {
public static void main(String[] args) {
		// TreeSet(): ������� ������ ������
	TreeSet <String> peopleTreeSet = new TreeSet <String>();   	// ������� ������ ������
		// 1_void add(E obj)_��������� � ������ ������ void add(E obj)		��� ������� ���������� ���������� true, ��� ��������� - false
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Mark - \t\t" + peopleTreeSet.add("Mark"));
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Steve - \t\t" + peopleTreeSet.add("Steve")); 		
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Scarlet - \t\t" + peopleTreeSet.add("Scarlet"));
	System.out.println("1_add(E obj)_������ false, �.�. �� ���������� ����� �������� ������� Scarlet - \t" + peopleTreeSet.add("Scarlet"));
	System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Justin - \t\t" + peopleTreeSet.add("Justin"));
	System.out.println("1_add(E obj)_Tree set ������� ����� ���������� ���� ��������� - \t\t" + peopleTreeSet + "\n");
		
		// 2_TreeSet(Collection col): ������� ������, � ������� ��������� ��� �������� ��������� col
	ArrayList<String> List = new ArrayList<String>();
	List.add("Dmitry");
	TreeSet <String> peopleTreeSet2 = new TreeSet <String>(List);   	// ������� ������, � ������� ��������� ��� �������� ��������� col
	System.out.println("2_TreeSet(Collection): Tree set ������� peopleTreeSet2 ����� ���������� ArrayList List -   " + peopleTreeSet2 + " \n");
		
		// 3_TreeSet(SortedSet set): ������� ������, � ������� ��������� ��� �������� �������������� ������ set
	peopleTreeSet2.addAll(peopleTreeSet);
	System.out.println("3_TreeSet(Collection): Tree set ������� peopleTreeSet2 ����� ���������� peopleTreeSet -   " + peopleTreeSet2 + " \n");
			
		//	TreeSet(Comparator<? super E> comparator): ������� ������ ������, ��� ��� ����������� �������� ������������ ����� ������������� ������������.
//	TreeSet <String> peopleTreeSet3 = new TreeSet <String>(Comparator<String> comparator);
		
		// 4_addAll()_��������� � ������ peopleTreeSet ��� �������� �� ������ peopleTreeSet2
	System.out.println("4_addAll():_������ false, �.�. �� ���������� ����� �������� ��� �������� ������ people - \t" + peopleTreeSet2.addAll(peopleTreeSet));
	System.out.println("4_addAll(): Tree set ������� peopleTreeSet2 ����� ���������� peopleTreeSet \t\t   -   " + peopleTreeSet2 + " \n");
		
		// 5_clear()_������� ��� �������� �� ���������   	void clear ():
	System.out.println("5_clear()_Tree set ������� peopleTreeSet2 �� �������� ���� ��������/��������� -    " + peopleTreeSet2);
	peopleTreeSet2.clear();
	System.out.println("5_clear()_Tree set ������� peopleTreeSet2 ����� �������� ���� ��������/��������� -    " + peopleTreeSet2  + "\n");
		 
	 	// 6_boolean contains (Object item): ���������� true, ���� ������ item ���������� � ���-�������, ����� ���������� false
	System.out.println("6_contains() - Tree set ������� peopleTreeSet �� ������ - \t\t\t\t" + peopleTreeSet);
	System.out.println("6_contains() - Tree set ������� peopleTreeSet �������� ������ Mark? - \t\t\t" + peopleTreeSet.contains("Mark"));
	System.out.println("6_contains() - Tree set ������� peopleTreeSet ����� ������ - \t\t\t" + peopleTreeSet + "\n");
		
		// 7_boolean containsAll (Collection a): ���������� true, ���� Tree set ������� ���������� � Tree set �������, ����� ���������� false
	System.out.println("7_containsAll()_Tree set ������� peopleTreeSet2 �������� peopleTreeSet? - \t\t\t" + peopleTreeSet2.containsAll(peopleTreeSet) + "\n");
			  
		// 8_boolean isEmpty (): ���������� true, ���� Tree set ������� �����, ����� ���������� false
	System.out.println("8_isEmpty - Tree set ������� peopleTreeSet ����? - \t" + peopleTreeSet.isEmpty());
	System.out.println("8_isEmpty - Tree set ������� peopleTreeSet ����? - \t" + peopleTreeSet2.isEmpty() + "\n");
				   
		// 9_remove(Object)_������� �������� ������ �� Tree set �������, ��������� ��� ���� true ��� ���������� ������ �������
	System.out.println("9_remove(Object)_Tree set ������� peopleTreeSet �� ������ -    " + peopleTreeSet + "\n");
	System.out.println("9_remove(Object)_������ true ��� ���������� Alice - \t   " + peopleTreeSet.remove("Mark"));
	System.out.println("9_remove(Object)_������ false ��� ������������ Piter - \t   " + peopleTreeSet.remove("Piter"));
	System.out.println("9_remove(Object)_Tree set ������� peopleTreeSet ����� ��������� Mark -    " + peopleTreeSet + "\n");
			   
	   	// 10_removeAll(Collection c)_������� �� Tree set ������� _peopleTreeSet2 ��� ������� ������� _peopleTreeSet, ��������� ��� ���� true ��� ���������� ������ �������
	peopleTreeSet2.addAll(peopleTreeSet);
	System.out.println("10_remove(Object)_Tree set ������� peopleTreeSet2 �� ������ \t\t\t-    " + peopleTreeSet2);
	System.out.println("10_removeAll(Object)_������ true ��� ���������� ���� �������� peopleTreeSet � peopleTreeSet2 \t-   " + peopleTreeSet2.removeAll(peopleTreeSet));
	System.out.println("10_removeAll(Object)_peopleTreeSet2 ����� ��������� ���� ���������  -    \t\t\t " + peopleTreeSet2  + "\n");
	
		// 11_retainAll(Collection c)_��������� � Tree set ������� people2 ������ ������� Tree set ������� people, ��������� ��� ���� true ��� ���������� ������ �������
	peopleTreeSet2.addAll(peopleTreeSet);
	peopleTreeSet2.add("Mary");		peopleTreeSet2.add("Mary2"); 	peopleTreeSet2.add("Mary3");
	System.out.println("11_retainAll() - Tree set ������� peopleTreeSet2 �� ������ - \t\t\t" + peopleTreeSet2);
	peopleTreeSet2.retainAll(peopleTreeSet);
	System.out.println("11_retainAll() - Tree set ������� peopleTreeSet2 ����� ������ - \t\t\t" + peopleTreeSet2);
	System.out.println("11_retainAll()_������ false ��� ������������ ����� people - \t\t   " + peopleTreeSet2.retainAll(peopleTreeSet)  + "\n");
		
		//12_int_size(): ���������� ����� ��������� � Tree set �������
	System.out.println("12_int_size() - Tree set ������� people �� ������ - \t\t\t\t" + peopleTreeSet2);
	System.out.println("12_int_size()_����� ��������� �  people - \t\t\t\t" + peopleTreeSet2.size() + "\n");
		
		// 11_Object[] toArray (): ���������� ������, ���������� ��� �������� ���������
	 Object Array[] = peopleTreeSet2.toArray();
	 Array.toString();
	 System.out.println("11_toArray ()_����� �������� � ������,   Array[1] =  \t" + Array[1] + "\n");
	 
	 				//	 ������ ���������� SortedSet:
	 	// 12_Comparator<? super E> comparator() - ���������� ���������� �������������� ���������. ���� ��� ��������� ����������� ������������ ������� ����������, ������������ null.
	 	 
	 	// 13_E first() - ����������, �� �� ������� ������ ������� ����������� �������������� ���������.
	 System.out.println("13_first() - Tree set ������� peopleTreeSet �� ������ - \t\t" + peopleTreeSet);
	 System.out.println("13_first() - ����������� ������ ������� peopleTreeSet \t\t\t " + peopleTreeSet.first());
	 System.out.println("13_first() - Tree set ������� peopleTreeSet ����� ������ - \t\t" + peopleTreeSet + "\n");
	 
		// 14_E last() - ����������, �� �� ������� ������ ������� ����������� �������������� ���������.
	 System.out.println("14_last() - Tree set ������� peopleTreeSet �� ������ - \t\t" + peopleTreeSet);
	 System.out.println("14_last() - ����������� ������ ������� peopleTreeSet \t\t\t " + peopleTreeSet.last());
	 System.out.println("14_last() - Tree set ������� peopleTreeSet ����� ������ - \t\t" + peopleTreeSet + "\n");
	 
	 	//15_SortedSet headSet(E toElement)- ���������� SortedSet, ���������� �������� �� ����������� ���������, ������� ������������ end.
	 peopleTreeSet.add("Mark");		peopleTreeSet.add("Bob");		peopleTreeSet.add("Tom");
	 peopleTreeSet2.clear();
	 System.out.println("15_headSet() - Tree set ������� peopleTreeSet �� ������ - \t\t\t" + peopleTreeSet);
	 peopleTreeSet2 = (TreeSet<String>) peopleTreeSet.headSet("Bob");
	 System.out.println("15_headSet() - ����������� Tree set ������� �� �������� Bob - \t\t\t" + peopleTreeSet2);
	 peopleTreeSet2.clear();		peopleTreeSet2 = (TreeSet<String>) peopleTreeSet.headSet("Scarlet");
	 System.out.println("15_headSet() - ����������� Tree set ������� �� �������� Scarlet - \t\t" + peopleTreeSet2);
	 System.out.println("15_headSet() - Tree set ������� peopleTreeSet ����� ������ - \t\t\t" + peopleTreeSet);
	 peopleTreeSet2.remove("Bob");
	 System.out.println("�������� �������� � ����������� ������� �������� ����� � �������� � �������, �� ������� ���� ���������");
	 System.out.println("15_headSet() - peopleTreeSet2 ����� �������� Bob - \t\t\t\t" + peopleTreeSet);
	 System.out.println("15_headSet() - peopleTreeSet ����� �������� Bob � peopleTreeSet2 - \t\t" + peopleTreeSet + "\n");
	 
	 	//16_SortedSet subSet(E fromElement, E toElement) - ���������� SortedSet, ���������� �������� �� ����������� ���������,
	    //	 ����������� ����� start � end-1.
	 peopleTreeSet.add("Bob");
	 System.out.println("16_subSet() - Tree set ������� peopleTreeSet �� ������ - \t\t\t" + peopleTreeSet);
	 TreeSet <String> peopleTreeSet3 = new TreeSet <String>();   	
	 peopleTreeSet2.remove("Bob");
	 peopleTreeSet3 = (TreeSet<String>) peopleTreeSet.subSet("Bob", "Steve");
	 System.out.println("16_subSet() - ����������� Tree set ������� c Bob � �� Steve - \t\t\t" + peopleTreeSet3);
	 System.out.println("16_subSet() - Tree set ������� peopleTreeSet ����� ������ - \t\t\t" + peopleTreeSet);
	 System.out.println("�������� �������� � ����������� ������� �������� ����� � �������� � �������, �� ������� ���� ���������");
	 System.out.println("16_subSet() - peopleTreeSet2 ����� �������� Bob - \t\t\t\t" + peopleTreeSet);
	 System.out.println("16_subSet() - peopleTreeSet ����� �������� Bob � peopleTreeSet2 - \t\t" + peopleTreeSet + "\n");
	 
	 	// 17_SortedSet tailSet(E fromElement) - ���������� SortedSet, ���������� �������� �� ����������� ���������, ������� ������� �� end.
	 TreeSet <String> peopleTreeSet4 = new TreeSet <String>();
	 System.out.println("17_tailSet() - Tree set ������� peopleTreeSet �� ������ - \t\t\t" + peopleTreeSet);
	 peopleTreeSet4 = (TreeSet<String>) peopleTreeSet.tailSet("Mark");
	 System.out.println("17_tailSet() - ����������� Tree set ������� ����� �������� Mark - \t\t" + peopleTreeSet4);
	 System.out.println("17_tailSet() - Tree set ������� peopleTreeSet ����� ������ - \t\t\t" + peopleTreeSet + "\n");
	 
	 	// 18_- E ceiling(E obj): ���� � ������ ���������� ������� e, ������� ������ obj (e >=obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
	 peopleTreeSet.add("Bob");
	 System.out.println("18_ceiling() - Tree set ������� peopleTreeSet �� ������ - \t" + peopleTreeSet);
	 System.out.println("������� ������� ������ Mark1 - \t\t\t\t\t" + peopleTreeSet.ceiling("Mark1")+ "\n");
	 
	 	// 19_- E floor(E obj): ���� � ������ ���������� ������� e, ������� ������ �������� obj (e <=obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
	 System.out.println("19_floor() - Tree set ������� peopleTreeSet �� ������ - \t" + peopleTreeSet);
	 System.out.println("19_floor()_������� ������� ������ Mark1 - \t\t\t" + peopleTreeSet.floor("Mark1")+ "\n");
	 
	 	// 20_E higher(E obj): ���� � ������ ���������� ������� e, ������� ������ �������� obj (e >obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
	 System.out.println("20_higher() - Tree set ������� peopleTreeSet �� ������ - \t" + peopleTreeSet);
	 System.out.println("20_higher()_������� ������� ������ Mark1 - \t\t\t" + peopleTreeSet.higher("Mark1")+ "\n"); 
	 
	 	// 21_E lower(E obj): ���� � ������ ���������� ������� e, ������� ������ �������� obj (e <obj). ���� ����� ������� ������, �� �� ������������ � �������� ����������. ����� ������������ null.
	 System.out.println("21_lower() - Tree set ������� peopleTreeSet �� ������ - \t" + peopleTreeSet);
	 System.out.println("21_lower()_������� ������� ������ Mark1 - \t\t\t" + peopleTreeSet.lower("Mark1")+ "\n");

	 	// 22_E pollFirst(): ���������� ������ ������� � ������� ��� �� ������
	 System.out.println("22_pollFirst() - Tree set ������� peopleTreeSet �� ������ - \t" + peopleTreeSet);
	 System.out.println("22_pollFirst()_������ ������� ����������� �� ������� - \t\t\t" + peopleTreeSet.pollFirst());
	 System.out.println("22_pollFirst() - Tree set ������� peopleTreeSet ����� ������ - \t" + peopleTreeSet + "\n");
	 
		// 23_E pollLast(): ���������� ��������� ������� � ������� ��� �� ������
	 peopleTreeSet.add("Bob");
	 System.out.println("23_pollLast() - Tree set ������� peopleTreeSet �� ������ - \t" + peopleTreeSet);
	 System.out.println("23_pollLast()_��������� ������� ����������� �� ������� - \t\t\t" + peopleTreeSet.pollLast());
	 System.out.println("23_pollLast() - Tree set ������� peopleTreeSet ����� ������ - \t" + peopleTreeSet + "\n");
	 
	 	// 24_NavigableSet<E> descendingSet(): ���������� ������ NavigableSet, ������� �������� ��� �������� ���������� ������ NavigableSet � �������� �������
	 peopleTreeSet.add("Tom");
	 System.out.println("24_descendingSet() - Tree set ������� peopleTreeSet �� ������ - \t\t" + peopleTreeSet);
	 NavigableSet<String> Set1 = peopleTreeSet.descendingSet();
	 System.out.println("24_descendingSet() - ����������� NavigableSet �� peopleTreeSet  - \t\t" + Set1);
	 System.out.println("24_descendingSet() - Tree set ������� peopleTreeSet ����� ������ - \t\t" + peopleTreeSet);
	 TreeSet <String> peopleTreeSet5 = new TreeSet <String>();
	 peopleTreeSet5 = (TreeSet<String>)Set1;
	 System.out.println("24_descendingSet() - ����������� NavigableSet ����� ���������� � TreeList  - \t" + peopleTreeSet5);
	 peopleTreeSet5.remove("Scarlet");
	 System.out.println("\t �������� �������� Scarlet � ����������� ������� �������� � �������� � � �����������");
	 System.out.println("24_descendingSet() - Tree set ������� peopleTreeSet �� ������ - \t\t" + peopleTreeSet);
	 System.out.println("24_descendingSet() - Tree set ������� peopleTreeSet �� ������ - \t\t" + Set1);
	 System.out.println("24_descendingSet() - Tree set ������� peopleTreeSet �� ������ - \t\t" + peopleTreeSet + "\n");
	 
	 	//25_NavigableSet<E> headSet(E upperBound, boolean incl): ���������� ������ NavigableSet, ������� �������� ��� ��������
 // ���������� ������ NavigableSet �� upperBound. �������� incl ��� �������� true, ��������� �������� � �������� ����� ������� upperBound
	 System.out.println("25_headSet() - Tree set ������� peopleTreeSet �� ������ - \t\t\t\t" + peopleTreeSet);
	 NavigableSet<String> Set2 = peopleTreeSet.headSet("Steve", false);
	 System.out.println("25_headSet() - ����������� NavigableSet �� peopleTreeSet c inclusive = false - \t\t" + Set2);
	 NavigableSet<String> Set3 = peopleTreeSet.headSet("Steve", true);
	 System.out.println("25_headSet() - ����������� NavigableSet �� peopleTreeSet c inclusive = true - \t\t" + Set3);
	 
	 //	26 NavigableSet<E> tailSet(E lowerBound, boolean incl): ���������� ������ NavigableSet, ������� �������� ��� �������� 
//	 ���������� ������ NavigableSet, ������� � lowerBound. �������� incl ��� �������� true, ��������� �������� � �������� �����
//������� lowerBound
	 
	 //27_NavigableSet<E> subSet(E lowerBound, boolean lowerIncl, E upperBound, boolean highIncl): ���������� ������ NavigableSet, 
//	 ������� �������� ��� �������� ���������� ������ NavigableSet �� lowerBound �� upperBound.
	 
	}
}
