package Queue_and_Stack;

import java.util.ArrayList;

class StackClass <T> {
	private ArrayList<T> list = new ArrayList<T>();
	
		// �������� ������� �� ������� ����� (�� ������ �������)
	public void push (T item) {
		list.add(0, item);}
		
		// ������� ������� �� ������� ����� (� ������ �������) 
	public T pop () {
		return list.remove(0);}			// ������� ������ ������� (� 0-��� ��������)
	
		// �������� �������� �� ���� ������
	public boolean isEmpty() {
		return list.isEmpty();}
}


public class Stack {
public static void main(String[] args) {
	StackClass<Integer> stack = new StackClass<Integer>();
	for (int i = 0; i<4; i++) {
		stack.push(i);
		System.out.println("� ���� �������� ������� " + i);
	}
	while (stack.isEmpty() == false) System.out.println("�������� ������� �� �����   " + stack.pop());
	
	}
}
