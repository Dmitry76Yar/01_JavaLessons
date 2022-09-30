package f21_COLLECTIONS;

import java.util.ArrayList;

/* ArrayList: ������� ������ ��������
���������� ��������� List, ������� ��������� ��������������� ���������� Collection.
��� �������� ������ ���������� ���������� List - ��� ArrayList � LinkedList.
����� ������, ArrayList ������������ ������� ������, ����������� �������, �� ��� �����������, ��� ���������� ��������� � ��� �� �����������. 
����� ArrayList ����� LinkedList - ������ � ArrayList�� ������� (����������� ������ ��������) ���������� ����� ������.
���������� ArrayList (��� ��� ����������� � ArrayList � �� �������� ������� � ������������, �� ��������� ������������������ �������): 
- ���������� ��������� � �������� ������ ��������, �.�. ����� ����� ��������� ������ ������ �������, ������� ��� ����� ������������. � ��������� ����� �� �����. .
- ������ ����� �������� ���������� ��������� ����� � ���� �� ���������� �������, ������� ������� ����� ������ �������� �������, �������� � ���� ��� �������� �� ���������. 
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
- ArrayList (int capacity): ������� ������, ������� ����� ��������� ������� capacity */

public class t02_Array_List_Search_Contain {
public static void main(String args[]) {

ArrayList <Integer> id = new ArrayList <Integer>();
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

	// 20_boolean contains (Object item): ���������� true, ���� ������ item ���������� � ���������, ����� ���������� false
System.out.println("20_contains (Object item)������ ������� ��������� �������� 34433 � ������   - " + id.lastIndexOf(34433));

	// 21_void sort(Comparator<? super E> comp): ��������� ������ � ������� ����������� comp

}
}