package Queue_and_Stack;

import java.util.ArrayList;

class QueueClass <T> {
	private ArrayList<T> list = new ArrayList<T>();
	
		// Добавить элемент в очередь
	public void add (T item) {
		list.add(item);}
		
		// Удалить элемент из очереди
	public T delete () {
		return list.remove(0);}			// Удаляет первый элемент (с 0-вым индексом)
	
		// Проверка является ли массив пустым
	public boolean isEmpty() {
		return list.isEmpty();}
}

public class Queue {
public static void main(String[] args) {
	QueueClass<Integer> queue = new QueueClass<Integer>();
	for (int i = 0; i<4; i++) {
		queue.add(i);
		System.out.println("В очередь добавлен элемент " + i);
	}
	while (queue.isEmpty() == false) System.out.println("Извлечен элемент   " + queue.delete());
	

	}
}
