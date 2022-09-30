package Queue_and_Stack;

import java.util.ArrayList;

class StackClass <T> {
	private ArrayList<T> list = new ArrayList<T>();
	
		// Добавить элемент на вершину стека (на первую позицию)
	public void push (T item) {
		list.add(0, item);}
		
		// Удаляет элемент из вершины стека (с первой позиции) 
	public T pop () {
		return list.remove(0);}			// Удаляет первый элемент (с 0-вым индексом)
	
		// Проверка является ли стек пустым
	public boolean isEmpty() {
		return list.isEmpty();}
}


public class Stack {
public static void main(String[] args) {
	StackClass<Integer> stack = new StackClass<Integer>();
	for (int i = 0; i<4; i++) {
		stack.push(i);
		System.out.println("В стек добавлен элемент " + i);
	}
	while (stack.isEmpty() == false) System.out.println("Извлечен элемент из стека   " + stack.pop());
	
	}
}
