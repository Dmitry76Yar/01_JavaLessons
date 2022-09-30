package f21_COLLECTIONS;
/* PriorityQueue � ��� ����� ������� � ������������.
  �������� - ��������� Queue - ����� AbstractQueue - ����� PriorityQueue
  ������ ������������� - ����� ������� �������� ������� � ������ ����������, �� ���������� �������, �� �� ����� ���������� ������� 
  �������� �������, � ������� �������� ��� ����� ���. ������ � ���� ������ ��� ����� ����� ����� ������������ PriorityQueue.
  
  �� ��������� ������� � ������������ ��������� �������� �������� ������������� ������� ���������� ��������� Comparable. 
  �������� � ���������� ��������� ������������� ���������� ���������. ���� ��������� ��������� ����� ���������� ��������� ������� � 
  ����� ������������ �����������. 
  ����� ����� ������� ����������� ������� ����������, ��������� Comparator.
  
  PriorityQueue �� ��������� ��������� null-�������� � non-comparable �������.
  PriorityQueue �� �������� ����������������! ��� ���� ����� � Java ���������� ����� PriorityBlockingQueue, ����������� ���������
BlockingQueue. ������ �� ������������ � ������������� �����.    */

import java.util.PriorityQueue;


public class t07_Priority_Queue_std_methods {
public static void main(String[] args) {
	PriorityQueue<String> name_list2 = new PriorityQueue<>();
	PriorityQueue<String> name_list1 = new PriorityQueue<>();
	name_list1.add("Alice33");		name_list1.add("Barak");	name_list1.add("Tom");
	name_list1.add("Mark");			name_list1.add("Justin");
	
		/*	1_peek() � ���������� (�� �� ������� �� �������) ������ �������.
	�������� ������������� � ������� �� � ������� �� ��������, � ����� ��������������� �� ���������� 
	�� ��������� ��� String - �������� ����� ������������� �� �������� + ���� �������� ��� ��������� */
	System.out.println("1_peek()_���� ������ �� ������	\t" + name_list1);
	System.out.println("1_peek() � ���������� (�� �� ������� �� �������) ������ �������\t" + name_list1.peek());
	System.out.println("1_peek()_���� ������ ����� ������	\t" + name_list1 );
	System.out.println("1_peek()_���������� ��� ������� ������ - " + name_list2.peek() + "\n" );
	
		/*	2_remove() � ���������� � ������� �� ������ ������ �������.
		�������� ������������� � ������� �� � ������� �� ��������, � ����� ��������������� �� ���������� 
		�� ��������� ��� String - �������� ����� ������������� �� �������� + ���� �������� ��� ��������� */
	System.out.println("2_remove()- ���� ������ �� ������	\t" + name_list1);
	System.out.println("2_remove() � ���������� � ������� �� ������ ������ ������� \t" + name_list1.remove());
	System.out.println("2_remove() - ���� ������ ����� ������	\t" + name_list1);
	//	name_list2.remove();
	System.out.println("2_remove()_���������� ��� ������� ������ ����������" + "\n" );
	
		// 3_remove(Object)_������� �������� ������ �� ������ �� ������� index, ��������� ��� ���� true ��� ���������� ������ �������
	System.out.println("3_remove(Object)- ���� ������ �� ������	\t\t  " + name_list1);
	System.out.println("3_remove(Object)_������ true ��� ���������� Mark - \t   " + name_list1.remove("Mark"));
    System.out.println("3_remove(Object)_������ false ��� ������������ Piter - \t   " + name_list1.remove("Piter"));
    name_list1.remove("Mark");
    System.out.println("3_remove(Object) - ���� ������ ����� ������	\t   " + name_list1 + "\n");
	
    	// 4_poll() � ���������� � ������� �� ������� ������ �������.
	 name_list1.add("Mark");
	 System.out.println("4_poll()- ���� ������ �� ������	\t\t\t\t\t" + name_list1);
	 System.out. println("4_poll() � ���������� (�� �� ������� �� �������) ��������� �������\t"  + name_list1.peek());
	 System.out.println("4_poll() - ���� ������ ����� ������ 	\t\t\t\t" + name_list1);
	 System.out.println("4_poll() - ���������� ��� ������� ������ name_list2 \t\t\t" + name_list2.poll() + "\n" );
	 
	 	// 5_boolean contains (Object): ���������� true, ���� ������ item ���������� � ���������, ����� ���������� false
	 System.out.println("5_contains - ���� ������ �� ������	\t\t  " + name_list1);
	 System.out.println("5_contains - _������ true ��� ���������� Mark � ������     " + name_list1.contains("Mark"));
	 System.out.println("5_contains - _������ false ��� ������������ Piter - \t   " + name_list1.contains("Piter") + "\n");

	 	// 6_isEmpty(): ���������� true, ���� ������ ������
	 System.out.println("6_isEmpty() - ������ false ��� ��������� ������ name_list1 \t\t  " + name_list1.isEmpty());
	 System.out.println("6_isEmpty() - ������ true ��� ������� ������ name_list2 \t\t " + name_list2.isEmpty() + "\n");
	 
	 	// 7_toArray(): ���������� ������ ������ Object
	 Object Array[] =  name_list1.toArray();
	 System.out.print("7_toArray(): ���������� ������ ������ Object - \t");
	 for (Object element: Array) System.out.print(element + "\t\n");
	 
	 	// 8_clear(): ������� ��� �������� �������
	 System.out.println("8_clear() - ���� ������ �� ������	\t  " + name_list1);
	 name_list1.clear();
	 System.out.println("8_clear() - ���� ������ ����� ������ \t\t  " + name_list1);
	 
	 
	}

}
