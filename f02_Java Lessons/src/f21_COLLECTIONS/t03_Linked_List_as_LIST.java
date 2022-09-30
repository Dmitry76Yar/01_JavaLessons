package f21_COLLECTIONS;

import java.util.Collections;
import java.util.LinkedList;
/*   LinkedList: ��������� ���������������� ������ �� ��������� ������� � ��������������� �������.
��� ������ � �������� ������ LinkedList ����������� ��������� ��������� List
��� ������ � �������� ������� LinkedList ��������� ���������� Dequeue � Queue
�������� ������ LinkedList: 	����� AbstractCollection - ����� AbstractList - ����� AbstractSequantialList - ����� LinkedList
LinkedList ���������: 			��������� Iterable - ��������� Collection - ��������� Queue - ��������� Deque, � ����� ��������� List

��� �������� ������ ���������� ���������� List - ��� ArrayList � LinkedList.
����� ������, ArrayList ������������ ������� ������, ����������� �������, �� ��� �����������, ��� ���������� ��������� � ��� �� �����������.
����� LinkedList ������������ ����� ������� ���������, � ������� 
    - ������ ������� ����� ������ �� ���������� ������� � �� ���������. 
    - ������ ��������� �� ������ �������
    - ��������� ������� ��������� �� NULL
����� LinkedList ����� ArrayList:
 - � LinkedList ������� ������ �� ������ � �� ����� ������, ��� ��������� ������ �������� ������ � ������� � � ���������� ��������.
  - ������� ���������� � �������� ��������� ������ �����: ����� ����� ���� �������� ���� ������
���������� ArrayList (��� ��� ����������� � ArrayList � �� �������� ������� � ������������, �� ��������� ������������������ �������): 
 - ��� ������� �� ������� ��������� �������� ��������������� �� ���� �������, ������� ����� ������� �� ������� ����� ��������������� ������� ������ 
 
 		������ ���������� Iterable<E>:
 - Iterator<T> iterator() - ���������� ������-��������
 
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

		������ ���������� List
- void add(int index, E obj): ��������� � ������ �� ������� index ������ obj 
- boolean addAll(int index, Collection<? extends E> col): ��������� � ������ �� ������� index ��� �������� ��������� col. ���� � ���������� ���������� ������ ��� �������, �� ������������ true, ����� ������������ false
- E get(int index): ���������� ������ �� ������ �� ������� index
- int indexOf(Object obj): ���������� ������ ������� ��������� ������� obj � ������. ���� ������ �� ������, �� ������������ -1
- int lastIndexOf(Object obj): ���������� ������ ���������� ��������� ������� obj � ������. ���� ������ �� ������, �� ������������ -1
- ListIterator<E> listIterator (): ���������� ������ ListIterator ��� ������ ��������� ������
- static <E> List<E> of(��������): ������� �� ������ ��������� ������ List
- E remove(int index): ������� ������ �� ������ �� ������� index, ��������� ��� ���� ��������� ������
- E set(int index, E obj): ����������� �������� ������� obj ��������, ������� ��������� �� ������� index
- void sort(Comparator<? super E> comp): ��������� ������ � ������� ����������� comp
- List<E> subList(int start, int end): �������� ����� ���������, ������� ��������� � ������ ����� ��������� start � end

		������ ������ LinkedList
- LinkedList(): ������� ������ ������
- LinkedList(Collection<? extends E> col): ������� ������, � ������� ��������� ��� �������� ��������� col	
		 */

public class t03_Linked_List_as_LIST {
public static void main(String args[]) {
			// ���� �������������
	LinkedList <String> people = new LinkedList <String>(); 	    //	����������� ArrayList ������� ������ ������
	LinkedList <String> employes = new LinkedList <String>();	    // 	����������� ArrayList (int a) ������� ������ ������, ������� ����� ��������� ������� capacity
	LinkedList <String> people2 = new LinkedList <String> (people); // �����������... - ������� ������, � ������� ����������� ��� �������� ��������� col.
	LinkedList <String> people4 = new LinkedList <String> (people);
	
		// 1_void add(E obj)_��������� � ������ ������ void add(E obj)		��� ������� ���������� ���������� true, ��� ��������� - false
   people.add("Tom");
   people.add("Alice");
   System.out.println("1_add(E obj)_������ true, �.�. ����������  �������� ������� Kate - \t" + people.add("Kate"));
   System.out.println("1_add(E obj)_people ����� people.add(Kate) \t\t - " + people.toString() + "\n");
	    	
   	// 2_addAll_��������� ����� ����� ��������
   Collections.addAll(people, "Alice33", "Alice555");
   System.out.println("2_addAll_people ����� �������������� ���������� \t - " + people.toString() + "\n");
	    
	    
    	// 3_void add(int index, E obj)_��������� ������� �� ������� 1		: ��������� � ������ �� ������� index ������ obj
    people.add(1, "Bob"); 
    System.out.println("3_add(int index, E obj)_���������� Bob �� 1-�� �������) \t - " + people.toString()  + "\n");
	    
        	// 4_AddAll(ArrayList)_��������� � ������ people2 ��� �������� �� ������ people	 
   people2.add("Dmitry"); people2.add("Alexey"); 
   System.out.println("4_AddAll(ArrayList)_people2 ����� ���������� ���������       - " + people2.toString()  + "\n");
   System.out.println("4_AddAll(ArrayList)_������ true, �.�. ����������  �������� �������� -   " + people2.addAll(people)); 	
   System.out.println("4_AddAll(ArrayList)_people2 ����� ���������� ���� ��������� �� people -    " + people2.toString()  + "\n");
	   
   		// 5_AddAll(int index, ArrayList)_��������� � ������ people2 ��� �������� �� ������ employes �� ���������� �������	 
   employes.add("1"); employes.add("2"); employes.add("3");
   people2.addAll(2, employes); 	
   System.out.println("5_AddAll(int index, ArrayList)_people2 ����� ���������� ���� ��������� �� employes �� ������� 2 -    " + people2.toString()  + "\n");
	   
   		// 6_E_set(int index, E obj): ����������� �������� ������� obj ��������, ������� ��������� �� ������� index
   System.out.println("6_set(int index, E obj)_�������� people \t\t - " + people.toString());
   people.set(0, "Tomy");
   System.out.println("6_set(int index, E obj)_people ����� people.set(0, Tomy) \t\t - " + people.toString() + "\n");
	   
   		//7_List<E> subList(int start, int end): �������� ����� ���������, ������� ��������� � ������ ����� ��������� start � end
   LinkedList <String>  people3 = new LinkedList <String>();
  // people3 = (ArrayList<String>)people.subList(0, 1);
   System.out.println("7_subList(int start, int end)_������ ������ people3 = people � 0-�� �� 1-�� �������� \t - " + people3.toString() + "\n");
	   
   		//8_int size(): ���������� ����� ��������� � ���������
   System.out.println("8_int size()_����� ��������� � ������ people - \t" + people.size() + "\n");
	   
   		// 9_boolean isEmpty (): ���������� true, ���� ��������� �����, ����� ���������� false
   System.out.println("9_isEmpty_������ people ����? - \t" + people.isEmpty() + "\n");
	   
   		// 10_Object[] toArray (): ���������� ������, ���������� ��� �������� ���������
   Object Array[] = people.toArray();
   Array.toString();
   System.out.println("10_toArray ()_����� �������� � ������,   Array[1] =  \t" + Array[1] + "\n");
   
   		// 11_1_remove (Object) ���������� � ������� ������ �� ������ ������. ���������� NoSuchElementException, ���� ���� ������ ����
   System.out.println("11_1_remove (Object) �� �������� �������� �� ������ " + people2.toString());
   System.out.println("11_1_remove (Object) ���������� � ������� ������ �� ������ ������ \t" + people2.remove());
   System.out.println("11_1_remove (Object) ����� �������� �������� �� ������ " + people2.toString()  + "\n");   
   // people4.remove();   - ����� NoSuchElementException, �.�. ������ ������ ������
   
   		// 11_2_removeFirst (Object) ���������� � ������� ������ �� ������ ������. ���������� NoSuchElementException, ���� ���� ������ ����
   people2.add("Dmitry");
   System.out.println("11_2_remove (Object) �� �������� �������� �� ������ " + people2.toString());
   System.out.println("11_2_remove (Object) ���������� � ������� ������ �� ������ ������ \t" + people2.removeFirst());
   System.out.println("11_2_remove (Object) ����� �������� �������� �� ������ " + people2.toString()  + "\n");   
   // people4.remove();   - ����� NoSuchElementException, �.�. ������ ������ ������
   
   		// 11_3_removeLast (Object) ���������� � ������� ������ �� ������ ������. ���������� NoSuchElementException, ���� ���� ������ ����
   people2.add("Alexey");
   System.out.println("11_3_remove (Object) �� �������� �������� �� ������ " + people2.toString());
   System.out.println("11_3_remove (Object) ���������� � ������� ������ �� ������ ������ \t" + people2.removeLast());
   System.out.println("11_3_remove (Object) ����� �������� �������� �� ������ " + people2.toString()  + "\n");   
   // people4.remove();   - ����� NoSuchElementException, �.�. ������ ������ ������
	   
   		// 11_5_remove(int index)_������� ������ �� ������ �� ������� index, ��������� ��� ���� ��������� ������  E remove(int index): 
   System.out.println("11_5_remove(int index)_���������� ��������� ������ \t" + people2.remove(2));
   System.out.println("11_5_remove(int index)_people2 ����� ��������� 2-�� �������� -    " + people2.toString()  + "\n");
      
      	// 12_remove(Object)_������� �������� ������ �� ������, ��������� ��� ���� true ��� ���������� ������ �������
   System.out.println("12_remove(Object)_������ true ��� ���������� Dmitry - \t   " + people2.remove("Dmitry"));
   System.out.println("12_remove(Object)_������ false ��� ������������ Piter - \t   " + people2.remove("Piter"));
   System.out.println("12_remove(Object)_people2 ����� ��������� 2-�� �������� -    " + people2.toString()  + "\n");
	   
   		// 13_removeAll(Object)_������� �� ������ people2 ��� ������� ������ people, ��������� ��� ���� true ��� ���������� ������ �������
   System.out.println("13_removeAll(Object)_������ true ��� ���������� ���� �������� people � people2 -   " + people2.removeAll(people));
   System.out.println("13_removeAll(Object)_people2 ����� ��������� ���� ��������� ������ people �� ������ people -    " + people2.toString());
   System.out.println("13_removeAll(Object)_������ true ��� ������������ ���� �������� people -   " + people2.removeAll(people)  + "\n");

   		// 14_clear()_������� ��� �������� �� ���������   	void clear ():
   System.out.println("14_clear()_������ employes �� �������� ���� ��������/��������� -    " + employes.toString());
   employes.clear();
   System.out.println("14_clear()_������ employes ����� �������� ���� ��������/��������� -    " + employes.toString()  + "\n");
	   
   		/// 15_boolean people2.retainAll (Object): ������� ��� ������� �� people2, ����� ���, ������� ���������� � ��������� people.
		// ���� ������� ��������� ����� �������� ����������, ���������� true, ����� ������������ false
   System.out.println("15_retainAll (Object)_�������� ������ people -    " + people.toString());
   people2.addAll(people);
   System.out.println("15_retainAll (Object)_�������� ������ people2 -    " + people2.toString());
   System.out.println("15_retainAll (Object)_������ true, �.�. ���������� �������� ������ �������� ������ people � ������ people2 - \t" + people2.retainAll(people));
   System.out.println("15_retainAll (Object)_������ people2 ����� �������� ���� ��������� ����� ���, ������� ���� � ������ people -    " + people2.toString());
	   
   LinkedList <Integer> id = new LinkedList <Integer>();
   id.add(104929); 	id.add(34433);	id.add(96374); id.add(34433);

   		//16_boolean contains (Object item): ���������� true, ���� ������ item ���������� � ���������, ����� ���������� false
   System.out.println("16_contains (Object item)_������ �������� ������ 96374? - \t " + id.contains(96374));

   		//17_E get(int index): ���������� ������ �� ������ �� ������� index
   System.out.println("17_get(int index)_�������� ������ id  \t\t - " + id.toString());
   System.out.println("17_get(int index)_������ ��� �������� 1 - \t - " + id.get(1));

   		// 18_int indexOf(Object obj): ���������� ������ ������� ��������� ������� obj � ������. ���� ������ �� ������, �� ������������ -1
   System.out.println("18_int indexOf(Object obj_������ ������� ��������� �������� 34433 � ������   - " + id.indexOf(34433));
   System.out.println("18_int indexOf(Object obj)_������ �������� 34434 � ������   - " + id.indexOf(3443));
   	
   		// 19_int lastIndexOf(Object obj): ���������� ������ ���������� ��������� ������� obj � ������. ���� ������ �� ������, �� ������������ -1
   System.out.println("19_int lastIndexOf(Object obj)_������ ������� ��������� �������� 34433 � ������   - " + id.lastIndexOf(34433));

   		// 21_void sort(Comparator<? super E> comp): ��������� ������ � ������� ����������� comp
   
   }
}


