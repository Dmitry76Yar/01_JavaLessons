package Queue_and_Stack;

import java.util.ArrayList;

class QueueClass <T> {
	private ArrayList<T> list = new ArrayList<T>();
	
		// �������� ������� � �������
	public void add (T item) {
		list.add(item);}
		
		// ������� ������� �� �������
	public T delete () {
		return list.remove(0);}			// ������� ������ ������� (� 0-��� ��������)
	
		// �������� �������� �� ������ ������
	public boolean isEmpty() {
		return list.isEmpty();}
}

public class Queue {
public static void main(String[] args) {
	QueueClass<Integer> queue = new QueueClass<Integer>();
	for (int i = 0; i<4; i++) {
		queue.add(i);
		System.out.println("� ������� �������� ������� " + i);
	}
	while (queue.isEmpty() == false) System.out.println("�������� �������   " + queue.delete());
	

	}
}
