package C_Graphs;

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

class Tree3 {
	int value; 
	Tree3 left;
	Tree3 right;
	public Tree3(int value, Tree3 left, Tree3 right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class TreeCreation_and_WidthObhod_via_Queue {
	
	// Метод суммирование элементов обходом в глубину через стек 
		public static int sumWidth (Tree3 root) {		// root - корневой узел, с которого начинается обход дерева
			QueueClass<Tree3> queue = new QueueClass();
			queue.add(root);
			int sum = 0;
			while (queue.isEmpty() == false) {
				Tree3 node = queue.delete();
				System.out.println("Node.value = " + node.value);
				sum = sum + node.value;
				if (node.right != null) queue.add(node.right);
				if (node.left != null) queue.add(node.left);
			}
			return sum;
		}
	
public static void main(String[] args) {
		
				/* Создание дерева другим способом
			      20
			  /       \
			 7         35
			/ \       /  \
			4  9    31   40
			 \	   /     / \
			  6   28    38  52
									*/
	Tree3 left1 = new Tree3(6, null, null);
	Tree3 left2 = new Tree3(9, null, null);
	Tree3 left3 = new Tree3(4, null, left1);
	Tree3 left4 = new Tree3(7, left3, left2);
	Tree3 right1 = new Tree3(28, null, null);
	Tree3 right2 = new Tree3(38, null, null);
	Tree3 right3 = new Tree3(52, null, null);
	Tree3 right4 = new Tree3(31, right1, null);
	Tree3 right5 = new Tree3(40, right2, right3);
	Tree3 right6 = new Tree3(35, right4, right5);
	Tree3 root1 = new Tree3(20, left4, right6);
	
	System.out.println("Сумма при вызове метода для корневого элемента  = "  + sumWidth(root1));
	System.out.println("Сумма при вызове метода для нижнего элемента 6  = "  + sumWidth(left1));
	
	}
}
