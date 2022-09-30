package f21_COLLECTIONS;
/* ������� ������ ����������������� � ����������������
���������������� ������� �������� �� FIFO (first in - first out) � �� LIFO  (last in - first out)
������� FIFO - ������� � �������. ������ � ������� ������� ���, ��� ����� � ������� ������
��� ������ � FIFO �������� ����� �������� ����������� � �����, � ���� �� ������ �������� �������, �� ����� ���� �� ������.
���� LIFO - ��� ������ ������� - �������, ������� �������� ������, � ����� �� ��� �������� ��� �������, ����� ����� ���������
��� ������ � LIFO �������� ����� �������� ����������� � ������, � ���� �� ������ �������� �������, �� ����� ���� ����� �� ������.

� Java ������� ������������ �� �������, � ����������� � Queue <E>, ������� ��������� ������� ��������� Collection 
�� Queue ����������� 4 ������ ����������, � ������ ������������ ������ �������: 		
Subinterfaces: BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E>
Classes: AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, 
LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue

      ��������� Deque
Deque ��������� Queue � ��������� ��������� ��������������� �������. 
��������������� ������� ����� ��������������� ��� ����������� ������� FIFO ���� ��� ���� LIFO.

       � ���������� Deque 2 ���������� - ����� LinkedList � ����� ArrayDeque
�� LinkedList ����� ������������ ����, �������, ��� ������� �������, �� �������� ������� O(1). 
�������� ������ LinkedList: 	����� AbstractCollection - ����� AbstractList - ����� AbstractSequantialList - ����� LinkedList
LinkedList ���������: 			��������� Iterable - ��������� Collection - ��������� Queue - ��������� Deque, � ����� ��������� List
�� ������� � �������� �� �������� ������, ��������� �������� �� ������� ��� �������� ����������� �������� ����� O(n).
������, �� ���������� � �������� �� �������� ������, ��������� ListIterator.add() � ListIterator.remove(), ����������� O(1).��������� ��������� ����� ��������, � ��� ����� � null.
	Push � pop -- ������������ �������� ������� ��������� ������ "����" LIFO. ������� ���� �� ������ ������������ ������ ������� ������ 
������ � �������� �����, �� ������������� �������� ������ ��� ������, ��� ���������� ����������� ����� ������, ��� �� ��������� ������
����� ��� � ������ ���� � ������������� � ���������.
		
		������ ���������� Iterable<E>:
 - Iterator<T> iterator() - ���������� ������-��������
 
		������ ���������� Queue
 - element() - ���������� ������� �� ������ �������. ������� �� ���������. ���� ������� �����, ������������ ���������� NoSuchElementException.
 - � remove() - ������� ������� �� ������ �������, ��������� ���. ���������� ���������� NoSuchElementException, ���� ������� �����.
 - peek() - ���������� (�� �� ������� �� �������) ������ �������.
 - � ��ll() - ���������� ������� �� ������ ������� � ������� ���. ���������� null, ���� ������� �����.
 - boolean offer(� �bj) - �������� �������� �bj � �������. ���������� true, ���� �bj ��������, � false � ��������� ������.
 
 		������ ���������� Deque
 - addFirst() � ��������� ����� ������� � ������ �������.
 - addLast() � ��������� ������� � ����� �������.
 - boolean offerFirst(E obj): ��������� ������� obj � ����� ������ �������. ���� ������� ������ ��������, ���������� true, ����� - false
 - boolean offerLast(E obj): ��������� ������� obj � ����� �������. ���� ������� ������ ��������, ���������� true, ����� - false
 - void push(E element): ��������� ������� � ����� ������ �������
 - getFirst(): ���������� ��� �������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� NoSuchElementException
 - getLast(): ���������� ��� �������� ��������� ������� �������. ���� ������� �����, ���������� ���������� NoSuchElementException
 - peekFirst(): ���������� ��� �������� ������� �� ������ �������. ���� ������� �����, ���������� �������� null
 - peekLast(): ���������� ��� �������� ��������� ������� �������. ���� ������� �����, ���������� �������� null
 - pollFirst() � ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� �������� null
 - pollLast() � ���������� � ��������� ��������� ������� �������. ���� ������� �����, ���������� �������� null
 - pop(): ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� NoSuchElementException
 - removeFirst(): ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� NoSuchElementException
 - removeLast(): ���������� � ��������� ������� �� ����� �������. ���� ������� �����, ���������� ���������� NoSuchElementException 
 - boolean removeFirstOccurrence(Object obj): ������� ������ ����������� ������� obj �� �������. ���� �������� ��������, �� ���������� true, ����� ���������� false.
 - boolean removeLastOccurrence(Object obj): ������� ��������� ����������� ������� obj �� �������. ���� �������� ��������, �� ���������� true, ����� ���������� false.	
	
		������ ������ LinkedList
- LinkedList(): ������� ������ ������
- LinkedList(Collection<? extends E> col): ������� ������, � ������� ��������� ��� �������� ��������� col	
*/	

import java.util.Collections;
import java.util.LinkedList;

public class t04_Linked_List_as_DEQUE {
public static void main(String[] args) {
	LinkedList <String> people2 = new LinkedList<String>();
	Collections.addAll(people2, "Alice33", "Barak", "Tom", "Mark", "Justin");
	LinkedList <String> NullList = new LinkedList<String>();
	System.out.println("�������� ������	\t\t\t\t\t\t\t" + people2);
	
		//	1_peekFirst(): ���������� ��� �������� ������� �� ������ �������. ���� ������� �����, ���������� �������� null
	System.out.println("1_peekFirst() � ���������� (�� �� ������� �� �������) ������ �������\t" + people2.peekFirst());
	System.out.println("1_peekFirst() - ���� ������ ����� ������	\t\t\t" + people2);
	System.out.println("1_peekFirst() - ���������� null ��� ������ ������� 	\t\t" + NullList.peekFirst() + "\n");
		
		//	2_peekLast(): ���������� ��� �������� ��������� ������� �������. ���� ������� �����, ���������� �������� null
	System.out.println("2_peekLast() � ���������� (�� �� ������� �� �������) ��������� �������\t" + people2.peekLast());
	System.out.println("2_peekLast() � ���� ������ ����� ������ 	\t\t\t" + people2);
	System.out.println("2_peekLast() - ���������� null ��� ������ ������� 	\t\t" + NullList.peekLast() + "\n");
	
		//	3_getFirst(): ���������� ��� �������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� NoSuchElementException
	System.out.println("3_getFirst() � ���������� (�� �� ������� �� �������) ������ �������\t" + people2.getFirst());
	System.out.println("3_getFirst() � ���� ������ ����� ������   	\t\t\t" + people2 + "\n");
//	System.out.println("3_getFirst() - ���������� null ��� ������ ������� 	\t\t" + NullList.getFirst() + "\n");
		
		//	4_getLast(): ���������� ��� �������� ��������� ������� �������. ���� ������� �����, ���������� ���������� NoSuchElementException
	System.out.println("4_getLast() � ���������� (�� �� ������� �� �������) ��������� �������\t" + people2.getLast());
	System.out.println("4_getLast() � ���� ������ ����� ������   	\t\t\t" + people2 + "\n");
//	System.out.println("4_getLast() - ���������� null ��� ������ ������� 	\t\t" + NullList.getLast() + "\n");
	
		//	5_pollFirst(): ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� �������� null
	System.out.println("5_pollFirst() � ���� ������ �� ������   	\t\t\t" + people2);
	System.out.println("5_pollFirst() � ���������� ������ ������� �� ������� � ������� ���\t" + people2.pollFirst());
	System.out.println("5_pollFirst - ���� ������ ����� ������ 	\t\t\t\t" + people2);
	System.out.println("5_pollFirst() - ���������� null ��� ������ ������� 	\t\t" + NullList.pollFirst() + "\n");
	
		//	6_pollLast(): ���������� � ��������� ��������� ������� �������. ���� ������� �����, ���������� �������� null
	people2.add("Alice333");
	System.out.println("6_pollLast() � ���� ������ �� ������   	\t\t\t\t" + people2);
	System.out.println("6_pollLast() � ���������� ��������� ������� �� ������� � ������� ���.\t" + people2.pollLast());
	System.out.println("6_pollLast() - ���� ������ ����� ������ 	\t\t\t" + people2);
	System.out.println("6_pollLast() - ���������� null ��� ������ ������� 	\t\t" + NullList.pollFirst() + "\n");
	
		//7_pop(): ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� NoSuchElementException
	people2.add("Alice333");
	System.out.println("7_pop() � ���� ������ �� ������   	\t\t\t\t" + people2);
	System.out.println("7_pop() � ���������� ��������� ������� �� ������� � ������� ���.\t" + people2.pop());
	System.out.println("7_pop() - ���� ������ ����� ������ 	\t\t\t\t" + people2 + "\n");
//	System.out.println("7_pop() - ���������� null ��� ������ ������� 	\t\t" + NullList.pop() + "\n");
	
		//8_removeFirst(): ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� NoSuchElementException
	people2.add("Barak");
	System.out.println("8_removeFirst() � ���� ������ �� ������   	\t\t\t\t" + people2);
	System.out.println("8_removeFirst() � ���������� ��������� ������� �� ������� � ������� ���.\t" + people2.removeFirst());
	System.out.println("8_removeFirst() - ���� ������ ����� ������ 	\t\t\t\t" + people2 + "\n");
//	System.out.println("8_removeFirst() - ���������� null ��� ������ ������� 	\t\t" + NullList.removeFirst() + "\n");
	
		//9_removeLast(): ���������� � ��������� ������� �� ����� �������. ���� ������� �����, ���������� ���������� NoSuchElementException
	people2.add("Tom");
	System.out.println("9_removeLast() � ���� ������ �� ������   	\t\t\t\t" + people2);
	System.out.println("9_removeLast() � ���������� ��������� ������� �� ������� � ������� ���.\t\t" + people2.removeLast());
	System.out.println("9_removeLast() - ���� ������ ����� ������ 	\t\t\t\t" + people2 + "\n");
//	System.out.println("9_removeLast() - ���������� null ��� ������ ������� 	\t\t" + NullList.removeLast() + "\n");
	
		//10_boolean removeFirstOccurrence(Object obj): ������� ������ ����������� ������� obj �� �������. 
        //	���� �������� ��������, �� ���������� true, ����� ���������� false.
	people2.add("Mark");
	System.out.println("10_removeFirstOccurrence() � ���� ������ �� ������   	\t\t\t\t" + people2);
	System.out.println("10_removeFirstOccurrence() � ���������� ������ Mark �� ������� � ������� ���.\t" + people2.removeFirstOccurrence("Mark"));
	System.out.println("10_removeFirstOccurrence() - ���� ������ ����� ������ 	\t\t\t\t" + people2);
	System.out.println("10_removeFirstOccurrence() - ���������� false, ���� �� ����� Tim \t\t\t" + people2.removeFirstOccurrence("Tim") + "\n");
	
		//11_boolean removeLastOccurrence(Object obj): ������� ��������� ����������� ������� obj �� �������. ���� �������� ��������, �� ���������� true, ����� ���������� false.
	people2.add("Justin");
	System.out.println("11_removeLastOccurrence() � ���� ������ �� ������   	\t\t\t\t" + people2);
	System.out.println("11_removeLastOccurrence() � ���������� ��������� Justin �� ������� � ������� ���.\t" + people2.removeLastOccurrence("Justin"));
	System.out.println("11_removeLastOccurrence() - ���� ������ ����� ������ 	\t\t\t\t" + people2);
	System.out.println("11_removeLastOccurrence() - ���������� false, ���� �� ����� Tim \t\t\t" + people2.removeLastOccurrence("Tim") + "\n");
	
		//	12_addFirst() � ��������� ����� ������� � ������ �������.
	System.out.println("12_addFirst() � ���� ������ �� ������   	\t\t" + people2);
	people2.addFirst("Jerry_First");
	System.out.println("12_addFirst - ���� ������ ����� ������ + Jerry_First 	\t" + people2 + "\n");
	
		//	13_addLast() � ��������� ������� � ����� �������.
	System.out.println("13_addLast() � ���� ������ �� ������   	\t\t\t" + people2);
	people2.addLast("Jerry_Last");
	System.out.println("13_addLast - ���� ������ ����� ������ + Jerry_First 	\t" + people2  + "\n");
	
		//	14_boolean offerFirst(E obj): ��������� ������� obj � ����� ������ �������. ���� ������� ������ ��������, ���������� true, ����� - false
	people2.remove(0); people2.remove(4); 
	System.out.println("14_offerFirst() � ���� ������ �� ������   	\t\t" + people2);
	System.out.println("14_offerFirst() - ���������� ��� �������� ���������� - \t\t" + people2.offerFirst("Jerry_First"));
	System.out.println("14_offerFirst() - ���� ������ ����� ������ + Jerry_First 	" + people2 + "\n");
	
		//	15_boolean offerLast(E obj): ��������� ������� obj � ����� �������. ���� ������� ������ ��������, ���������� true, ����� - false
	System.out.println("15_offerLast() � ���� ������ �� ������   	\t\t" + people2);
	System.out.println("15_offerLast() - ���������� ��� �������� ���������� - \t\t" + people2.offerLast("Jerry_Last"));
	System.out.println("15_offerLast() - ���� ������ ����� ������ + Jerry_Last \t 	" + people2 + "\n");
	
		//  16_void push(E element): ��������� ������� � ����� ������ �������
	people2.remove(0); people2.remove(4);
	System.out.println("16_void push() � ���� ������ �� ������   	\t\t" + people2);
	people2.push("Jerry_First");
	System.out.println("16_void push() - ���� ������ ����� ������ + Jerry_First 	" + people2 + "\n");
	
	}
}
