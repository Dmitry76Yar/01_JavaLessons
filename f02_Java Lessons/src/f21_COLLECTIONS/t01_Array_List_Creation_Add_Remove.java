package f21_COLLECTIONS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/* ArrayList: ������� ������ ��������
���������� ��������� List, ������� ��������� ��������������� ���������� Collection.
��� �������� ������ ���������� ���������� List - ��� ArrayList � LinkedList.
����� ������, ArrayList ������������ ������� ������, ����������� �������, �� ��� �����������, ��� ���������� ��������� � ��� �� 
�����������. 
����� ArrayList ����� LinkedList - ������ � ArrayList�� ������� (����������� ������ ��������) ���������� ����� ������.
���������� ArrayList (��� ��� ����������� � ArrayList � �� �������� ������� � ������������, �� ��������� ������������������ �������): 
- ���������� ��������� � �������� ������ ��������, �.�. ����� ����� ��������� ������ ������ �������, ������� ��� ����� ������������. � ��������� ����� �� �����. .
- ������ ����� �������� ���������� ��������� ����� � ���� �� ���������� �������, ������� ������� ����� ������ �������� �������, 
�������� � ���� ��� �������� �� ���������. 
� ��������� ������� Java ArrayList ��� ���������� ������ ������������� � �� �������� ����� �� ����� �������� ��� ��� ������ ��� ������������������ � ����� �������. 

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

		������ ������ ArrayList
- ArrayList(): ������� ������ ������
- ArrayList(Collection <? extends E> col): ������� ������, � ������� ����������� ��� �������� ��������� col.
- ArrayList (int capacity): ������� ������, ������� ����� ��������� ������� capacity
*/

public class t01_Array_List_Creation_Add_Remove {
public static void main(String args[]) {
	
		// ���� �������������
	ArrayList <String> people = new ArrayList <String>(); 		//	����������� ArrayList ������� ������ ������ 
	ArrayList <String> employes = new ArrayList <String>(3);	// 	����������� ArrayList (int a) ������� ������ ������, ������� ����� ��������� ������� capacity
	ArrayList <String> people2 = new ArrayList <String> (people); // �����������... - ������� ������, � ������� ����������� ��� �������� ��������� col.
		
	
			// �������� Arraylist  c �������� ����p�
	ArrayList<int []> arrlist = new ArrayList<int[]>();
	arrlist.add(new int[] {12, 13});
	
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
   
    	// 11_remove(int index)_������� ������ �� ������ �� ������� index, ��������� ��� ���� ��������� ������  E remove(int index): 
    System.out.println("11_remove(int index)_���������� ��������� ������ \t" + people2.remove(2));
    System.out.println("11_remove(int index)_people2 ����� ��������� 2-�� �������� -    " + people2.toString()  + "\n");
    	   
    	// 12_remove(Object)_������� �������� ������ �� ������ �� ������� index, ��������� ��� ���� true ��� ���������� ������ �������
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
    	   
   		// 15_boolean people2.retainAll (Object): ������� ��� ������� �� people2, ����� ���, ������� ���������� � ��������� people.
   		// ���� ������� ��������� ����� �������� ����������, ���������� true, ����� ������������ false
   System.out.println("15_retainAll (Object)_�������� ������ people -    " + people.toString());
   people2.addAll(people);
   System.out.println("15_retainAll (Object)_�������� ������ people2 -    " + people2.toString());
   System.out.println("15_retainAll (Object)_������ true, �.�. ���������� �������� ������ �������� ������ people � ������ people2 - \t" + people2.retainAll(people));
   System.out.println("15_retainAll (Object)_������ people2 ����� �������� ���� ��������� ����� ���, ������� ���� � ������ people -    " + people2.toString());
   
   }
}

